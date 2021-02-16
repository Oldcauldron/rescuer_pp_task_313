package jm.pp.rescuer313.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityServiceImpl implements SecurityService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public String getCrypt(String pass) {
        return bCryptPasswordEncoder.encode(pass);
    }
}
