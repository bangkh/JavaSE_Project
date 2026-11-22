package mylab.spring.notification;

public class SmsService {
    private final String provider;

    public SmsService(String provider) {
        if (provider == null || provider.trim().isEmpty()) {
            throw new IllegalArgumentException("SMS 제공업체가 필요합니다.");
        }
        this.provider = provider;
    }

    public String getProvider() { return provider; }
    public void sendSms(String message) {
        System.out.println("[SMS / " + provider + "] " + message);
    }
}