package app.implementation;

import app.dao.PackageDao;
import app.dao.RouteDao;
import app.entity.Route;
import app.interfaces.AdminOperations;
import org.hibernate.cfg.Configuration;
import app.entity.Package;
import org.joda.time.DateTime;

import javax.jws.WebService;
import java.util.Date;

/**
 * Created by Vlad on 10-Dec-17.
 */
@WebService(endpointInterface = "app.interfaces.AdminOperations")
public class AdminOperationsImpl implements AdminOperations {

    private PackageDao packageDao;

    private RouteDao routeDao;

    public void addPackage(int sender_id, int receiver_id, String name, String description, String senderCity, String destinationCity, boolean tracking) {
        Package aPackage = new Package();
        aPackage.setSender_id(sender_id);
        aPackage.setReceiver_id(receiver_id);
        aPackage.setName(name);
        aPackage.setDescription(description);
        aPackage.setSenderCity(senderCity);
        aPackage.setDestinationCity(destinationCity);
        aPackage.setTracking(tracking);
        packageDao = new PackageDao(new Configuration().configure().buildSessionFactory());
        packageDao.addPackage(aPackage);
    }

    public void removePackage(int id) {
        packageDao = new PackageDao(new Configuration().configure().buildSessionFactory());
        packageDao.removePackage(id);
    }

    public void trackPackage(int id, String city, Date time) {
        packageDao = new PackageDao(new Configuration().configure().buildSessionFactory());
        routeDao = new RouteDao(new Configuration().configure().buildSessionFactory());
        Package aPackage = packageDao.getPackage(id);
        aPackage.setTracking(true);
        packageDao.updatePackage(aPackage,id);
        Route route = new Route();
        route.setPackageId(id);
        route.setCity(city);
        route.setTime(time);
        routeDao.addRoute(route);
    }

    public void updateStatus(int id, String city, Date time) {
        routeDao = new RouteDao(new Configuration().configure().buildSessionFactory());
        Route route = new Route();
        route.setPackageId(id);
        route.setCity(city);
        route.setTime(time);
        routeDao.addRoute(route);
    }
}
