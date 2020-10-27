package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class fetchDistrictLatest
{
    public static void main(String[] args) {

        String searchUrl = "https://api.covid19india.org/state_district_wise.json";

        // creating and writing to file
        try
        {
            File myFile = new File("districtLatestJSON.json");

            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            if(urlcon.getConnectTimeout()==0)  // to check if network established
            {
                FileOutputStream fos = new FileOutputStream("districtLatestJSON.json");

                int c;
                while ((c = br.read()) != -1) // write to file
                {
                    fos.write((char)c);
                    //System.out.print((char) c);
                }
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        //now gson handling
        Gson gson = new GsonBuilder().create();
        try
        {
            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
