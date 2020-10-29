package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class fetchWorldLatest
{
    public static void main(String[] args) throws IOException
    {
        String searchUrl = "https://api.covid19api.com/summary";

        // creating and writing to file
        try
        {
            File myFile = new File("worldLatestJSON.json");

            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            if(urlcon.getConnectTimeout()==0)  // to check if network established
            {
                FileOutputStream fos = new FileOutputStream("worldLatestJSON.json");

                int c;
                while ((c = br.read()) != -1) // write to file
                {
                    fos.write((char) c);
                }
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred in fetchWorldLatest.java");
            e.printStackTrace();
        }


        //now gson handling
//        Gson gson = new GsonBuilder().create();
//        try
//        {
//            URL url = new URL(searchUrl);
//            URLConnection urlcon = url.openConnection();
//            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
//
//            worldLatest response = gson.fromJson(br, worldLatest.class);
//
//            System.out.println("Date:" +response.Date);
//            worldLatest.GlobalData worldData = response.Global;
//
//            System.out.println("World Data: ");
//            System.out.println("Total confirmed: "  +worldData.TotalConfirmed);
//
//            worldLatest.CountryWiseData[] countries = response.Countries;
//            System.out.println("Country wise Data:");
//            int num=0;
//            for(worldLatest.CountryWiseData country : countries)
//            {
//                System.out.println(++num);
//                System.out.println("Country: " +country.Country);
//                System.out.println("Total Confirmed: " +country.TotalConfirmed);
//                System.out.println();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
