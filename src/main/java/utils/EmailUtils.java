package utils;

import Domain.User;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;

/*
 * 1.������Ҫ��ȡ�����ʼ���Session����
 * 	Session session = Session.getDefaultInstance(Properties prop)
 * 2.ʹ��session���� ��ȡ�����͵��ʼ���Ϣ
 *  MimeMessage mime = new MimeMessage(session)
 * 3.���÷����� �ռ��� ���� �ʼ����� ���� ����ʱ��ȵ�
 * 4.����Transport �����ʼ�
 * */
public class EmailUtils {
	public static void sendEmail(User user){
		//���ͷ�
		String myAccount = "1186040304@qq.com";
		//��Ȩ��
		String myPass = "ptdcizbnbnnjfghj";
		//������ ����� SMTP ��������ַ
		String SMTPHost = "smtp.qq.com";
		//��� properties
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");//����Э������
		prop.setProperty("mail.smtp.host", SMTPHost);//���巢���˵������������ַ
		prop.setProperty("mail.smtp.auth", "true");//����������֤
		//1.Session���� �����Ự ���ں�������������н���
		Session session = Session.getDefaultInstance(prop);
		//����debugģʽ ���Բ鿴��ϸ������Ϣ ����
		session.setDebug(true);
		
		//2.�������� �������һ���������ʼ�
		//���� session(��������), myAccount ���ͷ� , user.getEmail() ���շ�
		MimeMessage message = createMsg(session,myAccount,user);
		//4.����Transport �����ʼ�
		try {
			Transport tran = session.getTransport();
			//���ӷ����� ȷ�Ϸ��ͷ� �Ƿ���Ȩ
			tran.connect(myAccount, myPass);
			//�����ʼ� ��message ���� ���� Transport ���� ���ʼ����ͳ�ȥ
			//����1 Ҫ�������� ����2 Ҫ����Щ�˷�
			//message.getAllRecipients() ��ȡ�����е��ռ��� | ���� | ����
			tran.sendMessage(message, message.getAllRecipients());
			//�ر�����
			tran.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static MimeMessage createMsg(Session session, String myAccount, User user) {
		//ʹ��session���� ��ȡ�����͵��ʼ���Ϣ
		MimeMessage message = new MimeMessage(session);
		//3.���÷����� �ռ��� ���� �ʼ����� ���� ����ʱ��ȵ�
		try {
			//3.1������ from
			message.setFrom(new InternetAddress(myAccount, "С��", "utf-8"));
			//3.2�ռ��� to ֧�ֿ�����Ӷ���ռ��� | ���� | ���� �����Ҫ���͸������ �����ظ����������
			/*
			 * MimeMessage.RecipientType.TO ����
			 * MimeMessage.RecipientType.CC ����
			 * MimeMessage.RecipientType.BCC ����
			 * */
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(user.getEmail(), user.getUsername(), "utf-8"));
			//3.3�����ʼ�����
			message.setSubject("С���̳��˺ż����ʼ�","utf-8");
			String ip = Inet4Address.getLocalHost().getHostAddress();
			String url = "http://"+ip+":8080/MiShopp1/activate?e="+ Base64Utils.encode(user.getEmail())+"&c="+Base64Utils.encode(user.getCode());
			//�����ʼ����� setContent ����ʹ��html��ǩ
			message.setContent(user.getUsername()+",���<br>��ӭע��С���̳�! �������ӽ��м���:<a href='"+url+"'>"+url+"</a>","text/html;charset=utf-8");
			//�����ʼ��ķ���ʱ�� ����������
			message.setSentDate(new Date());
			//��������
			message.saveChanges();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
