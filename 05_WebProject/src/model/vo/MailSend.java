package model.vo;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailSend {
	public String mailSend(String email) {
		//랜덤코드 생성
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<6;i++) {
			sb.append(r.nextInt(10));
		}
		System.out.println("랜덤코드:"+sb.toString());
		//gmail에 대한 정보
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 465);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				//아이디와 실제 비밀번호
				//사용할때만 기입하기
				return new PasswordAuthentication("silvestr0720@gmail.com", "!Rkato4948");				
			}
		});
		//실제 메일을 써주는 객체
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setSentDate(new Date());
			msg.setFrom(new InternetAddress("silvestr0720@gmail.com","김현식!"));
			InternetAddress to = new InternetAddress(email);
			//받을사람 주소
			msg.setRecipient(Message.RecipientType.TO, to);
			//제목,인코딩
			msg.setSubject("인증메일입니다.","UTF-8");
			msg.setContent("<h1>안녕하세요 인증메일입니다. 인증 번호는 ["+sb.toString()+"]입니다.","text/html;charset=UTF-8");
			//전송
			Transport.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}
