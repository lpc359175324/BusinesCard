package com.businesscard.bill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.FileSystem;

/**
 * @author lpc
 */
@Service
@Component
public class SendEmailService {
        
        @Value("${spring.mail.username}")
        private  String from;
        
        @Autowired
        private JavaMailSender javaMailSender;
        
        /**
         *文本邮件发送方法
         * @param to           收件人
         * @param subject 主题
         * @param content 内容
         * @return
         */
        public boolean sendSimpEmail(String to, String subject, String content) {
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setTo(to);
                simpleMailMessage.setSubject(subject);
                simpleMailMessage.setText(content);
                simpleMailMessage.setFrom(from);
                javaMailSender.send(simpleMailMessage);
                return true;
        }
        
        /**
         * html邮件发送
         * @param to 收件人
         * @param subject 主题
         * @param content 内容
         */
        public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
                MimeMessage message = javaMailSender.createMimeMessage();
                MimeMessageHelper  helper = new MimeMessageHelper(message,true,"utf-8");
                helper.setTo(to);
                helper.setFrom(from);
                helper.setSubject(subject);
                helper.setText(content,true);
                javaMailSender.send(message);
        }
        
        /**
         *附件邮件发送
         * @param to
         * @param subject
         * @param content
         * @param filePath  附件路径
         * @throws MessagingException
         */
        public void sendAccessoryMail(String to, String subject, String content,String filePath) throws MessagingException {
                MimeMessage message = javaMailSender.createMimeMessage();
                MimeMessageHelper  helper = new MimeMessageHelper(message,true,"utf-8");
                helper.setTo(to);
                helper.setFrom(from);
                helper.setSubject(subject);
                helper.setText(content,true);
                //读取附件,获取文件名
                FileSystemResource file = new FileSystemResource(new File(filePath));
                String  fileName = file.getFilename();
                helper.addAttachment(fileName,file);
                javaMailSender.send(message);
        }
        
        /**
         * 带图片邮件
         * @param to
         * @param subject
         * @param content
         * @param rscPath
         * @param rscId
         * @throws MessagingException
         */
        public void sendLinResourceMail(String to, String subject, String content,String rscPath , String rscId) throws MessagingException {
                MimeMessage message = javaMailSender.createMimeMessage();
                MimeMessageHelper  helper = new MimeMessageHelper(message,true,"utf-8");
                helper.setTo(to);
                helper.setFrom(from);
                helper.setSubject(subject);
                helper.setText(content,true);
                FileSystemResource file = new FileSystemResource(new File(rscPath));
                helper.addInline(rscId,file);
                javaMailSender.send(message);
        }
        
        
}
