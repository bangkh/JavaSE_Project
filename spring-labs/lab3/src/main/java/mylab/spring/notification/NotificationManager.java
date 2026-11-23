package mylab.spring.notification;

public class NotificationManager {
    private EmailService emailService;
    private SmsService smsService;

    public NotificationManager(EmailService emailService, SmsService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public EmailService getEmailService() {
        return emailService;
    }

    public SmsService getSmsService() {
        return smsService;
    }

    public void sendNotificationByEmail(String message) {
        emailService.sendEmail(message);
    }

    public void sendNotificationBySms(String message) {
        smsService.sendSms(message);
    }
}
