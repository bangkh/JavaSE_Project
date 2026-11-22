package mylab.spring.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
    @Autowired private UserService userService;

    @Test
    public void autowiringAndValueAreCorrect() {
        assertNotNull(userService);
        assertNotNull(userService.getUserRepository());
        assertEquals("MySQL", userService.getUserRepository().getDbType());
        assertNotNull(userService.getSecurityService());
    }

    @Test
    public void registrationRequiresPassword() {
        assertTrue(userService.registerUser("hong", "password123"));
        assertFalse(userService.registerUser("kim", ""));
        assertFalse(userService.registerUser("lee", null));
        assertFalse(userService.registerUser(" ", "password123"));
        assertTrue(userService.getUserRepository().getUsernames().contains("hong"));
        assertFalse(userService.getUserRepository().getUsernames().contains("kim"));
    }
}