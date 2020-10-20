package sample;

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

        //when using this method, it shows this error
        //java.lang.Double cannot be cast to java.lang.Integer
        public int getActive()
        {
            return (
                    ((Integer)infected).intValue()
                            - ((Integer)recovered).intValue()
                            - ((Integer)deceased).intValue()
            );
        }

}
