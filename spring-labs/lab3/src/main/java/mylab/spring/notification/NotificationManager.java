package mylab.spring.notification;

public class NotificationManager {
    private final EmailService emailService;
    private final SmsService smsService;

    public NotificationManager(EmailService emailService, SmsService smsService) {
        if (emailService == null || smsService == null) {
            throw new IllegalArgumentException("알림 서비스 두 개가 모두 필요합니다.");
        }
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public EmailService getEmailService() { return emailService; }
    public SmsService getSmsService() { return smsService; }

    public void sendNotificationByEmail(String message) {
        emailService.sendEmail(message);
    }
    public void sendNotificationBySms(String message) {
        smsService.sendSms(message);
    }
}