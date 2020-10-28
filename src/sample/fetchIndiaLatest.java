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

            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            if(urlcon.getConnectTimeout()==0)  // to check if network established
            {
                FileOutputStream fos = new FileOutputStream("indiaLatestJSON.json");

                int c;
                while ((c = br.read()) != -1) // write to file
                {
                    fos.write((char) c);     // writing characters
                }
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred in fetchIndiaLatest.java");
            System.out.println("Try checking your internet connection.");
        }

        //now gson handling
        try {
            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            indiaLatest response = gson.fromJson(br, indiaLatest.class); // created response object

            indiaLatest.latestData.officialSummary india = response.data.summary; // LHS: class names; RHS: object names
            System.out.println(("Total cases: " + india.total));

            indiaLatest.latestData.stateWise[] states = response.data.regional; // array of states

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
