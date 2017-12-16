package app.controllers;

import app.interfaces.AdminOperations;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by Vlad on 11-Dec-17.
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(method = RequestMethod.GET)
    public String showAdminPanel() {
        return "/admin";
    }

    @RequestMapping(value = "/addPackage", method = RequestMethod.GET)
    public String showAddPackage() {
        return "/admin/addPackage";
    }

    @RequestMapping(value = "/addPackage", method = RequestMethod.POST)
    public String processPackage(HttpServletRequest request) throws MalformedURLException {
        int senderId = Integer.parseInt(request.getParameter("senderId"));
        int receiverId = Integer.parseInt(request.getParameter("receiverId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String destinationCity = request.getParameter("destCity");
        String senderCity = request.getParameter("senderCity");
        URL url = new URL("http://localhost:7779/ws/addPackage?wsdl");

        QName qName = new QName("http://implementation.app/", "AdminOperationsImplService");
        Service service = Service.create(url, qName);
        AdminOperations adminOperations = service.getPort(AdminOperations.class);
        adminOperations.addPackage(senderId, receiverId, name, description, senderCity, destinationCity, false);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/registerPackage", method = RequestMethod.GET)
    public String showRegisterPackage() {
        return "/admin/registerPackage";
    }

    @RequestMapping(value = "/registerPackage", method = RequestMethod.POST)
    public String processRegisterPackage(HttpServletRequest request) throws MalformedURLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String city = request.getParameter("city");
        DateTime dateTime = DateTime.parse(request.getParameter("time"));
        URL url = new URL("http://localhost:7779/ws/trackPackage?wsdl");

        QName qName = new QName("http://implementation.app/", "AdminOperationsImplService");
        Service service = Service.create(url, qName);
        AdminOperations adminOperations = service.getPort(AdminOperations.class);
        adminOperations.trackPackage(id, city, dateTime.toDate());
        return "redirect:/admin";
    }

    @RequestMapping(value = "/removePackage", method = RequestMethod.GET)
    public String showRemovePackage() {
        return "/admin/removePackage";
    }

    @RequestMapping(value = "/removePackage", method = RequestMethod.POST)
    public String processRemovePackage(HttpServletRequest request) throws MalformedURLException {
        int id = Integer.parseInt(request.getParameter("id"));

        URL url = new URL("http://localhost:7779/ws/removePackage?wsdl");

        QName qName = new QName("http://implementation.app/", "AdminOperationsImplService");
        Service service = Service.create(url, qName);
        AdminOperations adminOperations = service.getPort(AdminOperations.class);
        adminOperations.removePackage(id);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/updateStatus",method = RequestMethod.GET)
    public String showUpdateStatus(){
        return "/admin/updateStatus";
    }

    @RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
    public String processUpdateStatus(HttpServletRequest request) throws MalformedURLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String city = request.getParameter("city");
        DateTime dateTime = DateTime.parse(request.getParameter("time"));
        URL url = new URL("http://localhost:7779/ws/trackPackage?wsdl");

        QName qName = new QName("http://implementation.app/", "AdminOperationsImplService");
        Service service = Service.create(url, qName);
        AdminOperations adminOperations = service.getPort(AdminOperations.class);
        adminOperations.updateStatus(id,city,dateTime.toDate());
        return "/admin";
    }

}
