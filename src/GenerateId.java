import java.text.*;
import java.util.*;
public class GenerateId {
    /**
     * This function means to give a string that contains the date information
     * based on the given format.
     * 
     * @param dateFormat 
     * @return
     */
    public static String getDate(String dateFormat){
        Date crtDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        String dateString  = formatter.format(crtDate);
        return dateString;
    }
    /**
     * Generate string with random numbers by the given length.
     * 
     * @param len the length expected the number has.
     * @return a string with a given length
     */
    public static String getRandomNum(int len){
        String str = "";
        for(int i = 0; i < len; ++i){
            str += RandomNumber.getRand().nextInt(10);
        }
        return str;
    }
    /**
     * Generate an id for a journey based on the given format - "yyyyMMddHHmmss".
     * 
     * @return a string that contains the journey's id
     */
    public static String generateJourneyId(){
        String dateFormat = "yyyyMMddHHmmss";
        int len = 3;
        String journeyId = getDate(dateFormat) + getRandomNum(len);
        return journeyId;
    }

    public static String generateEventId(String journeyId){
        int len = 5;
        return (journeyId + getRandomNum(len));
    }

    public static String generateTravelerId(String journeyId){
        int len = 4;
        return (journeyId + getRandomNum(len));
    }
}
