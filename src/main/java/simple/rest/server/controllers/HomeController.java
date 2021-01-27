package simple.rest.server.controllers;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Value("${spring.application.name}")
    String appName;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("App Name", appName);
        return jsonObject.toString();
    }

}
