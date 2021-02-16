package jm.pp.rescuer313.controller;

import jm.pp.rescuer313.ExeptionHandler.DataInfoHandler;
import jm.pp.rescuer313.ExeptionHandler.UserWithSuchLoginExist;
import jm.pp.rescuer313.model.User;
import jm.pp.rescuer313.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestUserController {

    private final UserService userService;

    @Autowired
    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<Set<User>> apiGetAllUsers() {
        Set<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> apiGetOneUser(@PathVariable("id") long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<DataInfoHandler> apiAddNewUser(@Valid @RequestBody User user,
                                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String error = getErrorsFromBindingResult(bindingResult);
            return new ResponseEntity<>(new DataInfoHandler(error), HttpStatus.BAD_REQUEST);
        }
        try {
            userService.addNewUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new UserWithSuchLoginExist("User with such login Exist");
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<DataInfoHandler> apiUpdateUser(@PathVariable("id") long id,
                                              @RequestBody @Valid User user,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String error = getErrorsFromBindingResult(bindingResult);
            return new ResponseEntity<>(new DataInfoHandler(error), HttpStatus.BAD_REQUEST);
        }
        try {
            userService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            throw new UserWithSuchLoginExist("User with such login Exist");
        }
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<DataInfoHandler> apiDeleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(new DataInfoHandler("User was deleted"), HttpStatus.OK);
    }

    private String getErrorsFromBindingResult(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.joining("; "));
    }

}
