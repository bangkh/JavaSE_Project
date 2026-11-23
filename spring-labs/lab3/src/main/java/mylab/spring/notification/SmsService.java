package mylab.spring.notification;

public class SmsService {
    private String provider;

    public SmsService(String provider) {
        this.provider = provider;
    }

    public String getProvider() {
        return provider;
    }

    public void sendSms(String message) {
        System.out.println("SMS 알림: " + message);
    }
}
