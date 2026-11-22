package mylab.spring.user;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {
    public boolean authenticate(String password) {
        return password != null && !password.trim().isEmpty();
    }
}