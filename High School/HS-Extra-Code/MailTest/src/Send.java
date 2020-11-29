
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Master
 */
public class Send {

    public static void main(String[] args) {
        String to = "jacob.ward.869@k12.friscoisd.org";//change accordingly
        String from = "Masterward14@gmail.com";//change accordingly
        String host = "192.168.1.254";//or IP address

        //Get the session object
        Properties properties = System.getProperties();
        properties.setProperty("smtp.gmail.com", host);
        Session session = Session.getDefaultInstance(properties);

        //compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Ping");
            message.setText("Hello, this is example of sending email  ");

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully....");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
