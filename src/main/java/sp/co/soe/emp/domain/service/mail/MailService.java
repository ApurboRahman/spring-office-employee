package sp.co.soe.emp.domain.service.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import sp.co.soe.emp.app.helper.EmployeeInventoryChkHelper;
import sp.co.soe.emp.common.util.Const;
import sp.co.soe.emp.domain.service.SystemParamService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Locale;

@Service
@Slf4j
public class MailService {

    private final SystemParamService systemParamService;
    private final JavaMailSender javaMailSender;
    private final MessageSource messageSource;
    private final SpringTemplateEngine springTemplateEngine;

    private static final String USER = "user";
    private static final String BASE_URL = "baseUrl";
    private static final String DEAD_LINE = "deadline";

    public MailService(SystemParamService systemParamService, JavaMailSender javaMailSender,
                       MessageSource messageSource, SpringTemplateEngine springTemplateEngine) {
        this.systemParamService = systemParamService;
        this.javaMailSender = javaMailSender;
        this.messageSource = messageSource;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Async
    public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHTML) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
            message.setTo(to);
            message.setFrom("email.form");
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(content, isHTML);
            javaMailSender.send(mimeMessage);
            log.debug("Sent email to User '{}'", to);
        } catch (MailException | MessagingException e) {
            e.printStackTrace();
            log.warn("Email could not be sent to user '{}'", to, e);
        }
    }

    @Async
    public void sendEmailWithAttachment(String to, String subject, String content, boolean isMultipart, boolean isHTML) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            FileSystemResource file
                    = new FileSystemResource(new File(getDirectoryPath() + File.separator + Const.CARD_RETAIN_CSV));
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
            message.setTo(to);
            message.setFrom("email.form");
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(content, isHTML);
            message.addAttachment(Const.CARD_RETAIN_CSV, file);
            javaMailSender.send(mimeMessage);
            log.debug("Sent email to User '{}'", to);
        } catch (MailException | MessagingException e) {
            e.printStackTrace();
            log.warn("Email could not be sent to user '{}'", to, e);
        }
    }

    @Async
    public void sendEmailFromTemplate(EmployeeInventoryChkHelper user, String deadline, String templateName, String titleKey) {
        Locale locale = Locale.forLanguageTag("en");
        String content = createContent(user, deadline, templateName, locale);
        String subject = messageSource.getMessage(titleKey, null, locale);
        sendEmail(user.getMailAddress(), subject, content, false, true);
    }

    @Async
    public void sendEmailFromTemplateWithAttachment(EmployeeInventoryChkHelper user, String deadline, String templateName, String titleKey) {
        Locale locale = Locale.forLanguageTag("en");
        String subject = messageSource.getMessage(titleKey, null, locale);
        String content = createContent(user, deadline, templateName, locale);
        sendEmailWithAttachment(user.getMailAddress(), subject, content, true, true);
    }

    private String createContent(EmployeeInventoryChkHelper user, String deadline, String templateName, Locale locale) {
        Context context = new Context(locale);
        context.setVariable(USER, user);
        context.setVariable(BASE_URL, "localhost");
        context.setVariable(DEAD_LINE, deadline);
        return springTemplateEngine.process(templateName, context);
    }

    /*
        @Async
        public void sendActivationEmail(User user) {
            log.debug("Sending activation email to '{}'", user.getEmail());
            sendEmailFromTemplate(user, "mail/activationEmail", "email.activation.title");
        }

        @Async
        public void sendCreationEmail(User user) {
            log.debug("Sending creation email to '{}'", user.getEmail());
            sendEmailFromTemplate(user, "mail/creationEmail", "email.activation.title");
        }

        @Async
        public void sendPasswordResetMail(User user) {
            log.debug("Sending password reset email to '{}'", user.getEmail());
            sendEmailFromTemplate(user, "mail/passwordResetEmail", "email.reset.title");
        }
        */
    private String getDirectoryPath() {
        return systemParamService.getUploadDirectoryPathFromSystemParam();
    }
}
