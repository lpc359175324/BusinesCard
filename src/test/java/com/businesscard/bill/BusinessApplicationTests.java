package com.businesscard.bill;

import com.businesscard.bill.service.SendEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.*;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessApplicationTests {
        
        @Resource
        SendEmailService sendEmailService;
        
        @Resource
        TemplateEngine templateEngine;
        
        //模板邮件测试
        @Test
        public void setSendTemEmail() throws MessagingException {
                Context context = new Context();
                //传入模板的，k-v
                context.setVariable("id", "006");
                String email = templateEngine.process("emailTempalte", context);
                sendEmailService.sendHtmlMail("18347457687@163.com", "测试", email);
        }
        
        //图片邮件
        @Test
        public void sendLinResourceMail() throws MessagingException {
                String rscId = "identifier1235";
                String content = "<html><body><h3>图片邮件!</h3><img src='cid:" + rscId + "' ></img></body></html>";
                String path = "C:\\Users\\lpc\\Pictures\\1447758821689134.jpg";
                sendEmailService.sendLinResourceMail("18347457687@163.com", "测试", content, path, rscId);
        }
        
        //附件邮件测试类
        @Test
        public void sendAccessoryMail() throws MessagingException {
                sendEmailService.sendAccessoryMail("18347457687@163.com", "测试", "2018-09-20", "L:\\广州APM项目\\xx\\李鹏程-个人周报.xlsx");
        }
        
        //html邮件测试类
        @Test
        public void sendEmailHtml() throws MessagingException {
                String htmlTxt = "<html><body><h3>hello world ! 这是一封Html邮件!</h3></body></html>";
                sendEmailService.sendHtmlMail("18347457687@163.com", "测试", htmlTxt);
        }
        
        //文本邮件发送测试类
        @Test
        public void sendEmail() {
                sendEmailService.sendSimpEmail("18347457687@163.com", "测试", "2018-09-20");
        }
        
        //读取支付宝账单数据测试类
        @Test
        public void importInfo() throws UnsupportedEncodingException, FileNotFoundException {
                File csv = new File("L:\\工具\\谷歌下载\\alipay_record_20180920_1433\\alipay_record_20180920_1433_1.csv");
                BufferedReader br = null;
                DataInputStream in = new DataInputStream(new FileInputStream(csv));
                br = new BufferedReader(new InputStreamReader(in, "GBK"));
                String line = "";
                String everyLine = "";
                try {
                        List<String> allString = new ArrayList<>();
                        while ((line = br.readLine()) != null)  //读取到的内容给line变量
                        {
                                everyLine = line;
                                System.out.println(everyLine);
                                allString.add(everyLine);
                        }
                        System.out.println("csv表格中所有行数：" + allString.size());
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        
        
}
