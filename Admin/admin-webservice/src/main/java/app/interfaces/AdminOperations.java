package app.interfaces;

import org.joda.time.DateTime;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;

/**
 * Created by Vlad on 10-Dec-17.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface AdminOperations {

    @WebMethod void addPackage(int sender_id, int receiver_id, String name, String description, String senderCity, String destinationCity, boolean tracking);

    @WebMethod void removePackage(int id);

    @WebMethod void trackPackage(int id, String city, Date time);

    @WebMethod void updateStatus(int id, String city, Date time);
}
