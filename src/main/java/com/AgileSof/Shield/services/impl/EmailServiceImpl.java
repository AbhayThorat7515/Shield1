/*
package com.AgileSof.Shield.services.impl;

import com.AgileSof.Shield.services.EmailService;
import com.AgileSof.Shield.util.EmailRequest;
import com.AgileSof.Shield.exception.ShieldException;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private SendGrid sendGrid;

    @Value("${email.from}")
    String emailFrom;

    public Response sendEmail(EmailRequest emailRequest) {
        Mail mail = new Mail(new Email(emailFrom), emailRequest.getSubject(), new Email(emailRequest.getTo()), new Content("text/plain", emailRequest.getBody()));
        mail.setReplyTo(new Email("athorat@agsft.com"));
        Response response = null;
        try {
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = this.sendGrid.api(request);
        } catch (Exception e) {
            throw new ShieldException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
        return response;
    }
}
*/

