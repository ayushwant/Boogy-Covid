package sample.fetchClasses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class fetchIndiaHistory {
    public static void main(String[] args) {

        String searchUrl = "https://api.rootnet.in/covid19-in/stats/history";
        Gson gson = new GsonBuilder().create();

        // creating and writing to file
        try
        {
            File myFile = new File("indiaHistoryJSON.json");

            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            if(urlcon.getConnectTimeout()==0)  // to check if network established
            {
                FileOutputStream fos = new FileOutputStream("indiaHistoryJSON.json");

                int c;
                while ((c = br.read()) != -1) // write to file
                {
                    fos.write((char) c);     // writing characters
                }
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred in fetchIndiaHistory.java");
            System.out.println("Try checking your internet connection."); }
        
    }

}
