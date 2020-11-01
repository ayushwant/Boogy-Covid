package sample.fetchClasses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

public class fetchNews
{
    public static void main(String[] args)
    {

        Calendar calendar = Calendar.getInstance();

        String toDate = calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE);
        String fromDate =calendar.get(Calendar.YEAR) +"-"+(calendar.get(Calendar.MONTH)+1)+"-"+(calendar.get(Calendar.DATE)-1);

        String searchUrl = "http://newsapi.org/v2/everything?q=covid&from="+fromDate+"&to="+toDate+"&sortBy=popularity&apiKey=40b7f5be4e1d455e8c4c1b2420e5d404";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // creating and writing to file
        try
        {
            File myFile = new File("newsJSON.json");

            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            if(urlcon.getConnectTimeout()==0)  // to check if network established
            {
                FileOutputStream fos = new FileOutputStream("newsJSON.json");

                int c;
                while ((c = br.read()) != -1) // write to file
                {
                    fos.write((char) c);     // writing characters
                }
                fos.close();
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred in fetchNews.java ");
            e.printStackTrace();
        }
    }
}