package mylab.spring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final UserRepository userRepository;
    private final SecurityService securityService;

    @Autowired
    public UserService(UserRepository userRepository, SecurityService securityService) {
        this.userRepository = userRepository;
        this.securityService = securityService;
    }

    public UserRepository getUserRepository() { return userRepository; }
    public SecurityService getSecurityService() { return securityService; }

    public boolean registerUser(String username, String password) {
        if (username == null || username.trim().isEmpty()) { return false; }
        if (!securityService.authenticate(password)) { return false; }
        userRepository.save(username);
        return true;
    }
}