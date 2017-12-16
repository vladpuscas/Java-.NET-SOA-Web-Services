package app;

import app.interfaces.AdminOperations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Vlad on 11-Dec-17.
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) throws MalformedURLException {
        SpringApplication.run(Main.class,args);
//        URL url = new URL("http://localhost:7779/ws/addPackage?wsdl");
//
//        QName qName = new QName("http://implementation.app/","AdminOperationsImplService");
//        Service service = Service.create(url,qName);
//        AdminOperations adminOperations = service.getPort(AdminOperations.class);
//        adminOperations.addPackage(1,2,"test","desc test","Cluj","mama dracului",false);
//
//        url = new URL("http://localhost:56251/Login.asmx?op=login");
//        qName = new QName("http://tempuri.org/", "Service");

    }
}
