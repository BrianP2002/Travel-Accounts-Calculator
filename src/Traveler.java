import java.util.*;
public class Traveler extends Person{
    private Double totalAmount;
    private Double payForOthers;
    private Double payByOthers;
    
    private HashMap<String, Boolean> chkEvents;

    public Traveler(String id, String userName){
        super(id, userName);
        this.totalAmount = 0.0;
        this.payForOthers = 0.0;
        this.payByOthers = 0.0;
        this.chkEvents = new HashMap<>();
    }

    /**
     * Achieve the total amount the traveler should pay.
     * 
     * @return the total amount should pay
     */
    public Double getTotalAmount(){
        return this.totalAmount;
    }

    /**
     * This method can automatically generate the total amount of this traveler
     * should pay or owed by others.
     * Should be called after every change of payByOthers and payForOthers.
     */
    public void generateTotalAmount(){
        this.totalAmount = this.payByOthers - this.payForOthers;
    }

    /**
     * Set a new total amount for the specific traveler.
     * 
     * @param totalAmount the new total amount this traveler should pay
     */
    public void setTotalAmount(Double totalAmount){
        this.totalAmount = totalAmount;
    }

    /**
     * Achieve the amount that this traveler pay for others in total.
     * 
     * @return the amount that this traveler pay for others in total
     */
    public Double getPayForOthers(){
        return this.payForOthers;
    }

    /**
     * Set a new amount that this traveler paid by others in total.
     * 
     * @param payForOthers the new amount that this traveler paid by others in total
     */
    public void setPayForOthers(Double payForOthers){
        this.payForOthers = payForOthers;
        this.generateTotalAmount();
    }

    /**
     * Achieve the amount that this traveler pay for others in total.
     * 
     * @return the amount that this traveler pay for others in total
     */
    public Double getPayByOthers(){
        return this.payByOthers;
    }

    /**
     * Set a new amount that this traveler paid by others in total.
     * 
     * @param payByOthers the new amount that this traveler paid by others in total
     */
    public void setPayByOthers(Double payByOthers){
        this.payByOthers = payByOthers;
        this.generateTotalAmount();
    }

    /**
     * Set up a mapping relationship between the traveler and the event.
     * 
     * @param eventId the event of this traveler will join into
     * @return 1 if joined successfully, 0 if the traveler is alreay in the event
     */
    public int joinEvent(String eventId){
        if(chkEvents.containsKey(eventId)){
            return 0;
        }
        chkEvents.put(eventId, true);
        return 1;
    }
    
    /**
     * Remove the mapping relationship between the traveler and the event.
     * 
     * @param eventId the id of the specfic event
     * @return 1 if the traveler leaves the event successfully, 0 if the traveler is not 
     * in the event originally.
     */
    public int leaveEvent(String eventId){
        if(!chkEvents.containsKey(eventId)){
            return 0;
        }
        chkEvents.remove(eventId);
        return 1;
    }
}