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
        // active cases ko lite lo filhal
        public Integer getActive()
        {
                Integer active = (Integer) ( ((Integer)infected).intValue() - ((Integer)recovered).intValue() - ((Integer)deceased).intValue() );

            /*return (
                    (Integer)(((Integer)infected).intValue()
                            - ((Integer)recovered).intValue()
                            - ((Integer)deceased).intValue()
            )); */
                return (Integer) active.intValue();
        }

}
