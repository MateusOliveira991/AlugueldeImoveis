package br.com.api.projindividual.services;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import br.com.api.projindividual.entities.Inquilino;

@Configuration
@Service
public class EmailService {
	
	

	private JavaMailSender emailSender;

    @Autowired
    public void setJavaMailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
	
	@Value("${spring.mail.host}")
	private String host;
	
	@Value("${spring.mail.port}")
	private Integer port;
	
	@Value("${spring.mail.username}")
	private String username;
	
	@Value("${spring.mail.password}")
	private String password;
	
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();
		emailSender.setHost(host);
		emailSender.setPort(port);
		emailSender.setUsername(username);
		emailSender.setPassword(password);
		prop.put("mail.transport.protocol", "smtp");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
		emailSender.setJavaMailProperties(prop);
		return emailSender;
	}
	

	public void envioEmailCadastro(Inquilino inquilino) {
		MimeMessage mensagemCadastro = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("grupo3api.2023@gmail.com");
			helper.setTo("mateusaugusto9.91@gmail.com");
			helper.setSubject("Inquilino Registrado!");
			
			StringBuilder builder=new StringBuilder();
			builder.append("<html>\r\n");
			builder.append("<body style=\"background-color:  #blue;\">\r\n");
			builder.append("<div align=\"center\">\r\n");
			builder.append("<h1 style=\"color: black;\">Olá, Senhor e Senhora Sanches</h1>\r\n");
			builder.append("<h3 style=\"color: black;\">Informo que um novo inquilino foi registrado."
					+ "<br>A partir de agora os Senhores passarão a receber o aluguel do imóvel na conta registrada.<br>Qualquer dúvida estou a disposição.</h3>\r\n");
			
			builder.append(" </h3>\r\n");
			builder.append("</div>\r\n");
			builder.append("<br/> \r\n");
			builder.append("<center>");
			builder.append("</html>");
			
			helper.setText(builder.toString(), true);
            emailSender.send(mensagemCadastro);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
