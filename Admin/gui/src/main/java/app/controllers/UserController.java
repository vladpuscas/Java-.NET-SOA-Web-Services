package app.controllers;


import app.generated.ClientService;
import app.generated.ClientServiceSoap;
import app.generated.Route;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import app.generated.Package;

/**
 * Created by Vlad on 16-Dec-17.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String showUser() {
        return "/user";
    }

    @RequestMapping(value = "/showAll",method = RequestMethod.GET)
    public String showAll(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession(false);
        int id = (Integer)session.getAttribute("userId");
        ClientServiceSoap clientServiceSoap = new ClientService().getClientServiceSoap();
        List<Package> packages = clientServiceSoap.getPackages(id).getPackage();
        model.addAttribute("packages",packages);
        return "/user/showAll";
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String showSearch() {
        return "/user/search";
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public String processSearch(HttpServletRequest request,Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        ClientServiceSoap clientServiceSoap = new ClientService().getClientServiceSoap();
        Package aPackage = clientServiceSoap.searchPackage(id);
        model.addAttribute("p",aPackage);
        return "/user/view";
    }

    @RequestMapping(value = "/track", method = RequestMethod.POST)
    public String processTrack(HttpServletRequest request,Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        ClientServiceSoap clientServiceSoap = new ClientService().getClientServiceSoap();
        List<Route> routes = clientServiceSoap.getRoutes(id).getRoute();
        model.addAttribute("r", routes);
        return "/user/track";
    }
}
