package mylab.spring.user;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {
    public boolean authenticate(String password) {
        if (password == null || password.trim().equals("")) {
            return false;
        }
        return true;
    }
}
