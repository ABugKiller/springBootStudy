package com.ad;

import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTests {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;

	//简单邮件发送
	@Test
	public void sendSimpleMail() throws Exception {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("892467242@qq.com");
		message.setTo("zyd@kaolabill.com");
		message.setSubject("主题，简单邮件测试");
		message.setText("测试邮件内容");
		mailSender.send(message);
	}

	//复杂邮件发送
	@Test
	public void sendAttachmentsMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("892467242@qq.com");
		helper.setTo("zyd@kaolabill.com");
		helper.setSubject("主题，附件邮件测试");
		helper.setText("有附件的邮件");

		File file = new ClassPathResource("weixin.png").getFile();
		FileSystemResource resource = new FileSystemResource(file);
		helper.addAttachment("附件-1.jpg", resource);
		helper.addAttachment("附件-2.jpg", resource);
		mailSender.send(mimeMessage);
	}

	//静态资源邮件
	@Test
	public void sendInlineMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("892467242@qq.com");
		helper.setTo("zyd@kaolabill.com");
		helper.setSubject("主题，嵌入静态资源测试");
		helper.setText("<html><body><img src='cid:weixin' ></body></html>", true);

		File file = new ClassPathResource("weixin.png").getFile();
		FileSystemResource resource = new FileSystemResource(file);
		helper.addInline("weixin", resource);
		mailSender.send(mimeMessage);
	}

	//模板邮件
	@Test
	public void sendTemplateMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("892467242@qq.com");
		helper.setTo("zyd@kaolabill.com");
		helper.setSubject("主题，模板邮件");
		Map<String, Object> model = new HashedMap();
		model.put("username", "didi");
		String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template.vm", "UTF-8", model);
		helper.setText(text, true);
		mailSender.send(mimeMessage);
	}

}
