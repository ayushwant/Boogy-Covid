package sample;

public class indiaLatest {
    boolean success;
    String lastRefreshed;
    String lastOriginUpdate;
    latestData data;

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public class latestData {
        officialSummary summary;
        unofficialSum[] unofficialSummary;
        stateWise[] regional;

        public class officialSummary {
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

        public class unofficialSum {
            String source;
            int total;
            int recovered;
            int deaths;
            int active;
        }

        public class stateWise {
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
