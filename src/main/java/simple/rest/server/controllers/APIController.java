package simple.rest.server.controllers;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import simple.rest.server.models.Payment;
import simple.rest.server.models.server.response.SimpleServerResponse;
import simple.rest.server.services.PaymentService;
import simple.rest.server.services.StudentService;

@RestController
@RequestMapping("/api/v1")
public class APIController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private StudentService studentService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public JSONObject index(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("App Name", appName);
        return jsonObject;
    }

    @RequestMapping(path = "/payment",method = RequestMethod.POST)
    public SimpleServerResponse paymentNotification(@RequestBody Payment payment){
        SimpleServerResponse response=new SimpleServerResponse();
        if(!studentService.validateByRegistrationNumber(payment.getRegistrationNumber())){
            response.setError(true)
                    .setMessage("No student found with registration Number:"+payment.getRegistrationNumber());
        }else {
            Payment savedPayment=paymentService.save(payment);
            paymentService.notifyGuardian(savedPayment);
            response.setMessage(String.format("Payment received for %s",payment.getRegistrationNumber()));
        }
        return response;
    }
}
