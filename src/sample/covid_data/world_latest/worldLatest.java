package sample.covid_data.world_latest;

public class worldLatest
{

        Object infected;
        Object tested;
        Object recovered;
        Object deceased;
        String country;
        String moreData;
        String historyData;
        String sourceUrl;
        String lastUpdatedSource;
        String lastUpdatedApify;

        public int getInfected() {
                return (int) infected;
        }

        public int getTested() {
                return (int) tested;
        }

        public int getRecovered() {
                return (int)recovered;
        }

        public int getDeceased() {
                return (int) deceased;
        }


        public int getActive()
        {
            return ((int)infected - (int)recovered - (int)deceased);
        }

}
