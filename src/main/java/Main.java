import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

public class Main {
    public static void main(String[] args) {

        String recipient = args[0];
        String senderUsername = args[1];
        String senderPassword = args[2];
        Email email = EmailBuilder.startingBlank()
                .from(senderUsername)
                .to(recipient)
                .withSubject("hello")
                .withHTMLText("world")
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, senderUsername, senderPassword)
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .buildMailer();

        mailer.sendMail(email);
    }
}
