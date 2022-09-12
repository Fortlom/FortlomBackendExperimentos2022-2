package com.example.fortlomisw.backend.security.service;



import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.service.PersonService;
import com.example.fortlomisw.backend.security.Dto.ChangePassword;
import com.example.fortlomisw.backend.security.Dto.EmailValues;
import com.example.fortlomisw.backend.service.PersonServiceImpl;
import com.example.fortlomisw.shared.exception.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailService {


    @Autowired
    PersonService personaService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    @Value("${mail.urlFront}")
    private String urlFront;
    private static final String subject = "Change password";


    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);
    public ResponseEntity<?> sendEmailTemplate(EmailValues dto){
        Optional<Person> usuarioOpt = personaService.getbyNombreUsuarioOrEmail(dto.getMailTo());
        if(!usuarioOpt.isPresent())
            return new ResponseEntity(new Message("No existe ningún usuario con esas credenciales"), HttpStatus.NOT_FOUND);
        Person persona = usuarioOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(persona.getEmail());
        dto.setSubject(subject);
        dto.setUserName(persona.getUsername());
        UUID uuid = UUID.randomUUID();
        String tokenPassword = uuid.toString();
        dto.setTokenPassword(tokenPassword);
        persona.setTokenpassword(tokenPassword);
        personaService.save(persona);
        sendEmail(dto);
        return new ResponseEntity(new Message("Te hemos enviado un correo"), HttpStatus.OK);

    }

    public void sendEmail(EmailValues dto) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            Context context = new Context();
            Map<String, Object> model = new HashMap<>();
            model.put("userName", dto.getUserName());
            model.put("url", urlFront + dto.getTokenPassword());
            context.setVariables(model);
            String htmlText = templateEngine.process("EmailTemplate", context);
            helper.setFrom(dto.getMailFrom());
            helper.setTo(dto.getMailTo());
            helper.setSubject(dto.getSubject());
            helper.setText(htmlText, true);


            javaMailSender.send(message);
        }catch (Exception e){
            logger.info("context", e);
        }









    }

    public ResponseEntity<?> changePassword(ChangePassword dto, BindingResult bindingResult){

        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        if(!dto.getPassword().equals(dto.getConfirmPassword()))
            return new ResponseEntity(new Message("Las contraseñas no coinciden"), HttpStatus.BAD_REQUEST);
        Optional<Person> usuarioOpt = personaService.getByTokenPassword(dto.getTokenPassword());
        if(!usuarioOpt.isPresent())
            return new ResponseEntity(new Message("No existe ningún usuario con esas credenciales"), HttpStatus.NOT_FOUND);
        Person usuario = usuarioOpt.get();
        String newPassword = passwordEncoder.encode(dto.getPassword());
        usuario.setPassword(newPassword);
        usuario.setTokenpassword(null);
        personaService.save(usuario);
        return new ResponseEntity(new Message("Contraseña actualizada"), HttpStatus.OK);





    }

}
