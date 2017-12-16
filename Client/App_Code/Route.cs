using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for Route
/// </summary>
public class Route
{
    public int id;

    public int packageId;

    public String city;

    public String time;

    public Route()
    {
        //
        // TODO: Add constructor logic here
        //
    }

    public Route(int id, int packageId, string city, string time)
    {
        this.id = id;
        this.packageId = packageId;
        this.city = city;
        this.time = time;
    }
}