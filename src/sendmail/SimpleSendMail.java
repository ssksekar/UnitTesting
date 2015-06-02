//$Id$
package sendmail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SimpleSendMail {

	public static void main(String arg [])
	{
		String to = "ssk.zoho@gmail.com";
		String from = "ssk.zoho@gmail.com";
		String host = "localhost";
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		Properties props = System.getProperties(); 
		
		props.put("mail.smtp.host", host);
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
	     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	     props.setProperty("mail.smtp.socketFactory.fallback", "false");
	     props.setProperty("mail.smtp.port", "465");
	     props.setProperty("mail.smtp.socketFactory.port", "465");
	     props.put("mail.smtp.auth", "true");
	     props.put("mail.debug", "true");
	     props.put("mail.store.protocol", "pop3");
	     props.put("mail.transport.protocol", "smtp");
	     
	     final String username = "ssk.zoho@gmail.com";//
	     final String password = "prabasekar";
	     
		Session s = Session.getDefaultInstance(props, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }});
		
		System.out.println( s );
		
		try{
			
			MimeMessage mimeMessage = new MimeMessage(s);
			
			mimeMessage.setFrom( new InternetAddress(from) );
			mimeMessage.setRecipient( Message.RecipientType.TO, new InternetAddress(to) );
			mimeMessage.setSubject( "Subject Da Mapla!!!" );
			mimeMessage.setText( "Sucking Content!!!" );
			
			Transport.send(mimeMessage);
		System.out.println( "Done !!!" );	
		}
		catch( MessagingException mex )
		{
			System.out.println( mex );
		}
	}
	
}
