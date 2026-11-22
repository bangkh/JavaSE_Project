package mylab.spring.notification;

public class EmailService {
    private final String smtpServer;
    private final int port;

    public EmailService(String smtpServer, int port) {
        if (smtpServer == null || smtpServer.trim().isEmpty()) {
            throw new IllegalArgumentException("SMTP 서버가 필요합니다.");
        }
        if (port < 1 || port > 65535) {
            throw new IllegalArgumentException("잘못된 포트 번호입니다.");
        }
        this.smtpServer = smtpServer;
        this.port = port;
    }

    public String getSmtpServer() { return smtpServer; }
    public int getPort() { return port; }

    public void sendEmail(String message) {
        System.out.println("[EMAIL / " + smtpServer + ":" + port + "] " + message);
    }
}