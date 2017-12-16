package app.entity;

/**
 * Created by Vlad on 10-Dec-17.
 */
public class Package {

    private int id;

    private int sender_id;

    private int receiver_id;

    private String name;

    private String description;

    private String senderCity;

    private String destinationCity;

    private Boolean tracking;

    public Package() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Boolean getTracking() {
        return tracking;
    }

    public void setTracking(Boolean tracking) {
        this.tracking = tracking;
    }
}
