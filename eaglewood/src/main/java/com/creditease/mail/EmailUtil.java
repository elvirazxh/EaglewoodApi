package com.creditease.mail;/**
 * Created by admin on 2019/7/28.
 */

import com.creditease.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.MessageFormat;
import java.util.*;

/**
 * @author
 * @createTime 2019/7/28 16:25
 * @description
 */
@Service
public class EmailUtil {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.sender}")
    private String from;


    public void sendMail(String[] to, String subject, String content) {

        MimeMessage message = mailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true,"UTF-8");
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            helper.setSentDate(new Date());
//            添加附件
//            helper.addAttachment(String attachmengFile,File file);

            mailSender.send(message);
            System.out.println("发送成功~");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("发送失败~");
        }
    }


    //邮件内容,是表格形式的HTML
//    public String buildHtmlContent(Map<String,String>sumData, List<Map<String,Object>> appendContents){
    public String buildHtmlContent(Map<String,String>sumData, List<List<String>> appendContents){

            StringBuilder content = new StringBuilder();
        content.append("<br/>执行用例的时间:" + sumData.get("exceuteDate"));
        content.append("<br/>执行用例的环境:" + sumData.get("sysEnv"));
        content.append("<br/>执行用例的系统标识:" + sumData.get("sysFlag"));
        content.append("<br/>执行用例的总数:" + sumData.get("totalNum"));
        content.append("<br/>执行用例失败总数:" + sumData.get("failureNUm"));

        if (null != appendContents && !appendContents.isEmpty()) {
            content.append("<br/>");
            content.append("<br/>");
            content.append("<table border=\"1\" cellpadding=\"5\" cellspacing=\"0\">");
            //表格标题
            content.append("<tr style=\"background: #669999;\">");
            //邮件表格header
            String header = "<td>SystemEnv</td><td>ServiceId</td><td>MerchId</td><td>OrderId</td><td>IsPass</td>";
            content.append(header);
            content.append("</tr>");

            //表格内容(表格内容是一个list,每一行是一个map,)
            content.append("<tr>");
//            for (Map<String, Object> row : appendContents) {
//                List<String> keys =  new ArrayList<>(row.keySet());//获取行 内容的所有key值
//                content.append("<tr>");
//                for (String key : keys) {
//                    content.append("<td>" + row.get(key) + "</td>");
//                }
//                content.append("</tr>");
//            }

            for (List<String> row : appendContents) {
                List<String> values =  row;//获取行 行的内容也是一个list
                content.append("<tr>");
                for (String value : values) {
                    content.append("<td>" + value + "</td>");
                }
                content.append("</tr>");
            }

            content.append("</tr>");
            content.append("</table>");
        }

        return String.valueOf(content);

    }








}
 
    