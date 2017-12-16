using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Data;
using MySql.Data;
using MySql.Data.MySqlClient;
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]

public class ClientService : System.Web.Services.WebService
{
    public ClientService()
    {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    [WebMethod]
    public Client login(string username, string password)
    {
        string connStr = "server=localhost;user=root;database=assignment-four;port=3306;password=";
        MySqlConnection conn = new MySqlConnection(connStr);
        try
        {
            conn.Open();

            string sql = "SELECT * FROM Client WHERE username=@username AND password=@password";
            MySqlCommand cmd = new MySqlCommand(sql,conn);
            
            cmd.Parameters.AddWithValue("@username", username);
            cmd.Parameters.AddWithValue("@password", password);

            MySqlDataReader reader = cmd.ExecuteReader();
            Client client = null;

            while (reader.Read())
            {
                client = new Client((int)reader[0], (string)reader[1], (string)reader[2], (string)reader[3]);
            }

            return client;
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.ToString());
        }
        return null;
    }

    [WebMethod]
    public Package searchPackage(int id)
    {
        string connStr = "server=localhost;user=root;database=assignment-four;port=3306;password=";
        MySqlConnection conn = new MySqlConnection(connStr);

        try
        {
            conn.Open();

            string sql = "SELECT * FROM Package WHERE id=@id";
            MySqlCommand cmd = new MySqlCommand(sql, conn);

            cmd.Parameters.AddWithValue("@id", id);

            MySqlDataReader reader = cmd.ExecuteReader();
            Package package = null;

            while (reader.Read())
            {
                package = new Package((int)reader[0],
                    (int)reader[1], 
                    (int)reader[2], 
                    (string)reader[3], 
                    (string)reader[4], 
                    (string)reader[5],
                    (string)reader[6], 
                    (Boolean)reader[7]);
            }

            return package;
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.ToString());
        }
        return null;
    }

    [WebMethod]
    public List<Route> getRoutes(int id)
    {
        string connStr = "server=localhost;user=root;database=assignment-four;port=3306;password=";
        MySqlConnection conn = new MySqlConnection(connStr);

        try
        {
            conn.Open();

            string sql = "SELECT * FROM Route WHERE package_id=@id";
            MySqlCommand cmd = new MySqlCommand(sql, conn);

            cmd.Parameters.AddWithValue("@id", id);

            MySqlDataReader reader = cmd.ExecuteReader();
            List<Route> routes = new List<Route>();
            int i = 0;
            while (reader.Read())
            {
                DateTime time = (DateTime)reader[3];
                String stime = time.ToString("dd MMM HH:mm:ss");
                Console.WriteLine(stime);
                Route route = new Route((int)reader[0],
                    (int)reader[1],
                    (string)reader[2],
                    stime);
                routes.Add(route);
                i++;
            }

            return routes;
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.ToString());
        }
        return null;
    }

    [WebMethod]
    public void register(String username, String password)
    {
        string connStr = "server=localhost;user=root;database=assignment-four;port=3306;password=";
        MySqlConnection conn = new MySqlConnection(connStr);
        try
        {
            conn.Open();

            string sql = "INSERT INTO Client (username, password) VALUES (@username, @password)";
            MySqlCommand cmd = new MySqlCommand(sql, conn);

            cmd.Parameters.AddWithValue("@username", username);
            cmd.Parameters.AddWithValue("@password", password);
            //cmd.Parameters.AddWithValue("@id", null);
            //cmd.Parameters.AddWithValue("@role", null);

            cmd.ExecuteNonQuery();
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.ToString());
        }
    }

    [WebMethod]
    public List<Package> getPackages(int id)
    {
        string connStr = "server=localhost;user=root;database=assignment-four;port=3306;password=";
        MySqlConnection conn = new MySqlConnection(connStr);

        try
        {
            conn.Open();

            string sql = "SELECT * FROM Package WHERE sender_id=@id";
            MySqlCommand cmd = new MySqlCommand(sql, conn);

            cmd.Parameters.AddWithValue("@id", id);

            MySqlDataReader reader = cmd.ExecuteReader();
            List<Package> packages = new List<Package>();
            int i = 0;
            while (reader.Read())
            {
                Package package = new Package((int)reader[0],
                    (int)reader[1],
                    (int)reader[2],
                    (string)reader[3],
                    (string)reader[4],
                    (string)reader[5],
                    (string)reader[6],
                    (Boolean)reader[7]);
                packages.Add(package);
                i++;
            }

            return packages;
        }
        catch (Exception ex)
        {
            Console.WriteLine(ex.ToString());
        }
        return null;
    }
}