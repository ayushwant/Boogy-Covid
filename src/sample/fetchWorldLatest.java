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
        String searchUrl = "https://api.apify.com/v2/key-value-stores/" +
                "tVaYRsPHLjNdNBu7S/records/LATEST?disableRedirect=true";

        // creating and writing to file
        try
        {
            File myFile = new File("worldLatestJSON.json");
            FileOutputStream fos = new FileOutputStream("worldLatestJSON.json");

            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            int c;
            while((c=br.read())!=-1) // write to file
            {
                //fos.write(br.read());
                fos.write((char) c);
                //System.out.print((char) c);
            }
            fos.close();
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

            worldLatest[] response = gson.fromJson(br, worldLatest[].class);

            //worldLatest[] counts = response.countries;
      /*      for(worldLatest count : counts)
            {
                System.out.println("Country: " + count.country);
                System.out.println("Total infected: " +count.infected);
                System.out.println(("Active cases: " +count.getActive()));
                System.out.println();
            }*/

            // for entire world data, we have to add all the stats from each country
            int number=0;
            for(worldLatest country : response)
            {
                System.out.println(++number);
                System.out.println("Country: " + country.country);
                System.out.println("Infected: " +country.infected);
                //System.out.println("Total recovered: " +country.getRecovered());
                //System.out.println("Total active: "+ country.getActive()); // getActive kaam ni kar raha abhi.
                System.out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
