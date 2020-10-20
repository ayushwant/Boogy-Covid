package sample.covid_data.news;

public class covidNews
{
    String status;
    int totalResults;
    allArticles[] articles;

    public class allArticles
    {
        String author;
        String title;
        String description;
        String url;
        String urlToImage;
        String publishedAt;
        String content;
        public class source
        {
            boolean id;
            String name;
        }
    }

}
