package app.controllers;

import app.generated.ClientService;
import app.generated.ClientServiceSoap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vlad on 16-Dec-17.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    @RequestMapping(method = RequestMethod.GET)
    public String showRegister() {
        return "/register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegister(HttpServletRequest request) {
        ClientServiceSoap clientServiceSoap = new ClientService().getClientServiceSoap();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        clientServiceSoap.register(username,password);
        return "/index";
    }
}
