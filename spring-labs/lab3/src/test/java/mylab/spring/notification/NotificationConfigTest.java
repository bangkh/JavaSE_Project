package mylab.spring.notification;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
    @Autowired private NotificationManager notificationManager;

    @Test
    public void notificationBeansAreInjected() {
        assertNotNull(notificationManager);
        assertNotNull(notificationManager.getEmailService());
        assertEquals("smtp.gmail.com", notificationManager.getEmailService().getSmtpServer());
        assertEquals(587, notificationManager.getEmailService().getPort());
        assertNotNull(notificationManager.getSmsService());
        assertEquals("SKT", notificationManager.getSmsService().getProvider());
    }

    @Test
    public void notificationMethodsCanBeCalled() {
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
    }
}