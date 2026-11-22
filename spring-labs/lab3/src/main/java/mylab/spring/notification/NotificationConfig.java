package mylab.spring.notification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {
    @Bean
    public EmailService emailService() {
        return new EmailService("smtp.gmail.com", 587);
    }

    @Bean
    public SmsService smsService() {
        return new SmsService("SKT");
    }

    @Bean
    public NotificationManager notificationManager(EmailService emailService, SmsService smsService) {
        return new NotificationManager(emailService, smsService);
    }
}