package simple.rest.server.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import simple.rest.server.models.Payment;
import simple.rest.server.models.Student;
import simple.rest.server.repositories.PaymentRepository;
import simple.rest.server.services.PaymentService;
import simple.rest.server.services.StudentService;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public Payment findByReference(String reference) {
        return repository.findByReference(reference);
    }

    @Override
    public void notifyGuardian(Payment payment) {

        //sent sms to Student guardian
        sendSMS(payment);
        //OR
        //sent sms to Student guardian
        sendEmail(payment);
    }

    @Async
    void sendSMS(Payment payment){
        //sms gateway required
    }

    @Async
    void sendEmail(Payment payment){
        //compose and send email
        Student student=studentService.findByRegistration(payment.getRegistrationNumber());
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(student.getGuardianEmailAddress());
        mailMessage.setSubject("Fees Payment");
        mailMessage.setText(
                String.format(
                        "Dear Guardian\n\n" +
                                "Fee payment of %s has been received for %s of registration number %s",
                        new DecimalFormat("#,###.##").format(payment.getAmount()),
                        student.getName(),student.getRegistrationNumber()
                )
        );
        mailMessage.setFrom("admin@familybank.co.ke");
        new Thread(() -> {
            System.out.println("Sending message in background ...");
            javaMailSender.send(mailMessage);
            System.out.println("Email send to:"+student.getGuardianEmailAddress());
        }).start();

    }
}
