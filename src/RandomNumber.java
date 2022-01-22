import java.util.*;
import java.text.*;
public class RandomNumber {
    /**
     * This is a random number generator depends on the current time to avoid
     * repetition in common random object.
     * @return a random object that avoid the repetition extremely
     */
    public static Random getRand(){
        Random rand = new Random();
        String randFormat = "MMddHHmmss";
        SimpleDateFormat formatter = new SimpleDateFormat(randFormat);
        Date crtDate = new Date();
        String dateString = formatter.format(crtDate);
        rand.setSeed(Long.parseLong(dateString));
        return rand;
    }
}
