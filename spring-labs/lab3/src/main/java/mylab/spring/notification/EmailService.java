package mylab.spring.notification;

public class EmailService {
    private String smtpServer;
    private int port;

    public EmailService(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public int getPort() {
        return port;
    }

    public void sendEmail(String message) {
        System.out.println("이메일 알림: " + message);
    }
}
