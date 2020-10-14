package Networking;

public class covidLatest
{
    boolean success;
    String lastRefreshed;
    String lastOriginUpdate;

    public boolean isSuccess() {
        return success;
    }

    public String getLastOriginUpdate() {
        return lastOriginUpdate;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    latestData data;

    public static class latestData
    {
        officialSummary summary;
        unofficialSum[] unofficialSummary;
        stateWise[] regional;

        public class officialSummary
        {
            //public int total;
            int total;
            int confirmedCasesIndian;
            int confirmedCasesForeign;
            int discharged;
            int deaths;
            int confirmedButLocationUnidentified;

            public int getTotal() {
                return total;
            }

            public int getDischarged() {
                return discharged;
            }

            public int getDeaths() {
                return deaths;
            }
        }

        public class unofficialSum
        {
            String source;
            int total;
            int recovered;
            int deaths;
            int active;

        }

        public class stateWise
        {
            String loc;
            int confirmedCasesIndian;
            int confirmedCasesForeign;
            int discharged;
            int deaths;
            int totalConfirmed;

            public String getLoc() {
                return loc;
            }

            public int getDischarged() {
                return discharged;
            }

            public int getDeaths() {
                return deaths;
            }
        }



    }

}
