package app.controllers;

import app.generated.Client;
import app.generated.ClientService;
import app.generated.ClientServiceSoap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Vlad on 16-Dec-17.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String showRegister() {
        return "/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processRegister(HttpServletRequest request) {
        ClientServiceSoap clientServiceSoap = new ClientService().getClientServiceSoap();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Client client = clientServiceSoap.login(username,password);
        if(client.getRole().equalsIgnoreCase("ROLE_ADMIN"))
            return "/admin";
        else
        {
            HttpSession session = request.getSession();
            session.setAttribute("userId",client.getId());
            return "/user";
        }

    }
}
