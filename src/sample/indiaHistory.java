package sample;

public class indiaHistory
{
    boolean success;
    String lastRefreshed;
    String lastOriginUpdate;
    datewiseHistory[] data;

    public class datewiseHistory
    {
        String day;
        indiaThisDay summary;
        statesThisDay[] regional;

        public class indiaThisDay
        {
            int total;
            int confirmedCasesIndian;
            int confirmedCasesForeign;
            int discharged;
            int deaths;
            int confirmedButLocationUnidentified;

            public int getIndiaActive() {
                return total - discharged - deaths;
            }
        }

        public class statesThisDay
        {
            String loc;
            int confirmedCasesIndian;
            int confirmedCasesForeign;
            int discharged;
            int deaths;
            int totalConfirmed;

            public int getActive() {
                return totalConfirmed - discharged - deaths;
            }

        }


    }

}
