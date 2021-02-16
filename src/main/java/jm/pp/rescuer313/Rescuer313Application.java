package jm.pp.rescuer313;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Rescuer313Application {

    public static void main(String[] args) {
        SpringApplication.run(Rescuer313Application.class, args);

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String password = "admin@a.com";
//        String encodedPassword = passwordEncoder.encode(password);
//
//        System.out.println();
//        System.out.println("Password is         : " + password);
//        System.out.println("Encoded Password is : " + encodedPassword);
//        System.out.println();
//
//
//        boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
//        System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
    }

}
