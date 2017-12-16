package app;

import app.implementation.AdminOperationsImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by Vlad on 10-Dec-17.
 */
public class Publisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:7779/ws/addPackage", new AdminOperationsImpl());
        Endpoint.publish("http://localhost:7779/ws/removePackage", new AdminOperationsImpl());
        Endpoint.publish("http://localhost:7779/ws/trackPackage",new AdminOperationsImpl());
        Endpoint.publish("http://localhost:7779/ws/updateStatus",new AdminOperationsImpl());

    }
}
