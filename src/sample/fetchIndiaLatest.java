package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class fetchIndiaLatest
{
    public static void main(String[] args) throws IOException {

        String searchUrl = "https://api.rootnet.in/covid19-in/stats/latest";
        Gson gson = new GsonBuilder().create();

        // creating and writing to file
        try
        {
            File myFile = new File("indiaLatestJSON.json");
            FileOutputStream fos = new FileOutputStream("indiaLatestJSON.json");

            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            int c;
            while((c=br.read())!=-1) // write to file
            {
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
        try {
            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            indiaLatest response = gson.fromJson(br, indiaLatest.class); // created response object

            System.out.println("Success: " + response.success); // you can directly use variable name
            System.out.println("Last refreshed: " + response.getLastRefreshed() + "\n"); // or you can use a getter

            indiaLatest.latestData.officialSummary india = response.data.summary; // LHS: class names; RHS: object names
            System.out.println(("Total cases: " + india.total));
            System.out.println("India Total Active: " + india.getIndiaActive() + "\n");

            indiaLatest.latestData.stateWise[] states = response.data.regional; // array of states
            for(indiaLatest.latestData.stateWise state: states)
            {
                System.out.println("Name: "+state.loc);
                System.out.println(("Total cases: " + state.totalConfirmed));
                System.out.println("Active cases: " + state.getActive() + "\n");
            }


            //indiaLatest.latestData
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

}
