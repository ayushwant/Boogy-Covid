package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class fetchNews
{
    public static void main(String[] args)
    {
        String searchUrl = "http://newsapi.org/v2/everything?q=covid&from=2020-10-16&to=2020-10-16&" +
                "sortBy=popularity&apiKey=40b7f5be4e1d455e8c4c1b2420e5d404";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // creating and writing to file
        try
        {
            File myFile = new File("newsJSON.json");
            FileOutputStream fos = new FileOutputStream("newsJSON.json");

            URL url = new URL(searchUrl);
            URLConnection urlcon = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

            int c;
            while((c=br.read())!=-1) // write to file
            {
                fos.write(br.read());
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

            covidNews news = gson.fromJson(br, covidNews.class);

            System.out.println("Total results: " + news.totalResults);

            covidNews.allArticles[] arts = news.articles;

            for(covidNews.allArticles art : arts)
            {
                //covidNews.allArticles.source = news.articles.;
                System.out.println("Title: " + art.title);
                System.out.println("url: " + art.url);
                System.out.println();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
