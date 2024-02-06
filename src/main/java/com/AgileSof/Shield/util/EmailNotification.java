package com.AgileSof.Shield.util;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class EmailNotification {

    @Value("${app.sendgrid.Key}")
   private String sendGridKey;


    public void sendmail(Email to, String subject, String content2) throws IOException {
        Email from = new Email("dmakarand@agsft.com");

        Content content = new Content("text/html",content2);
        Mail mail = new Mail(from,subject,to,content);

        SendGrid sg = new SendGrid(sendGridKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
            System.out.println("Your Email Send Succefully");
        } catch ( Exception e) {
             e.printStackTrace();
        }
    }
}
