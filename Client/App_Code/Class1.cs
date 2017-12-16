using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for Class1
/// </summary>
public class Client
{
    public int id;

    public string username;

    public string password;

    public string role;

    public Client()
    {
        //
        // TODO: Add constructor logic here
        //
    }

    public int setId()
    {
        return id;
    }

    public Client(int id, string username, string password, string role)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}