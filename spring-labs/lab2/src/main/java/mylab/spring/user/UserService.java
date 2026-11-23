package mylab.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityService securityService;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SecurityService getSecurityService() {
        return securityService;
    }

    public boolean registerUser(String username, String password) {
        if (username == null || username.trim().equals("")) {
            return false;
        }

        boolean login = securityService.authenticate(password);
        if (login == false) {
            return false;
        }

        userRepository.save(username);
        return true;
    }
}
