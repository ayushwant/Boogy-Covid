package Networking;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class fetchCovidLatest {
    public static void main(String[] args) {
        String searchUrl = "https://api.rootnet.in/covid19-in/stats/latest";
        Gson gson = new GsonBuilder().create();

        try {
            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            covidLatest latest = gson.fromJson(br, covidLatest.class);

            System.out.println(latest.isSuccess());
            System.out.println(latest.getLastRefreshed());

            System.out.println("Total Summary:");
            covidLatest.latestData.officialSummary official =  latest.data.summary; //gson.fromJson(, covidLatest.latestData.officialSummary.class);
            System.out.println("Total cases: "+official.getTotal());
            System.out.println("Total deaths: "+official.getDeaths());

            System.out.println("State-wise data: ");
            covidLatest.latestData.stateWise[] states = latest.data.regional;
            for(covidLatest.latestData.stateWise state : states)
            {
                System.out.println("Name: " + state.getLoc());
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
