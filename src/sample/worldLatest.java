package sample;

public class worldLatest {
        String Message;
        GlobalData Global;
        CountryWiseData[] Countries;
        String Date;

        public class GlobalData {
                int NewConfirmed;
                int TotalConfirmed;
                int NewDeaths;
                int TotalDeaths;
                int NewRecovered;
                int TotalRecovered;

                public int getActive(){
                        return TotalConfirmed-TotalDeaths-TotalRecovered;
                }
        }

        public class CountryWiseData {
                String Country;
                String CountryCode;
                String Slug;
                int NewConfirmed;
                int TotalConfirmed;
                int NewDeaths;
                int TotalDeaths;
                int NewRecovered;
                int TotalRecovered;
                String Date;

                public int getActive(){
                        return TotalConfirmed-TotalDeaths-TotalRecovered;
                }

        }
}
