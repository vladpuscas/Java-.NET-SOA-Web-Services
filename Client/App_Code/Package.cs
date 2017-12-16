using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for Package
/// </summary>
public class Package
{

    public int id;

    public int sender_id;

    public int receiver_id;

    public String name;

    public String description;

    public String senderCity;

    public String destinationCity;

    public Boolean tracking;


    public Package()
    {
        //
        // TODO: Add constructor logic here
        //
    }

    public Package(int id, int sender_id, int receiver_id, string name, string description, string senderCity, string destinationCity, bool tracking)
    {
        this.id = id;
        this.sender_id = sender_id;
        this.receiver_id = receiver_id;
        this.name = name;
        this.description = description;
        this.senderCity = senderCity;
        this.destinationCity = destinationCity;
        this.tracking = tracking;
    }
}