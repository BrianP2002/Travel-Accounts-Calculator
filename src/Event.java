import java.util.*;
public class Event {
    private String eventName;
    private Date eventDate;
    private String eventDescription;
    private String payerId;
    private String payerUserName;
    private Double costAmount;

    private ArrayList<Participant> participantsList = new ArrayList<Participant>();


    /**
     * 
     * 
     * @param eventName
     * @param eventDate
     * @param eventDescription
     * @param payerId
     * @param payerUserName
     * @param costAmount
     */
    public Event(String eventName, Date eventDate, String eventDescription, String payerId, String payerUserName, Double costAmount){
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.payerId = payerId;
        this.payerUserName = payerUserName;
        this.costAmount = costAmount;
    }
    
    /**
     * Achieve the name of the current event
     * 
     * @return the name of the current event
     */
    public String getEventName(){
        return this.eventName;
    }

    /**
     * Set a new name for the current event
     * 
     * @param eventName the new event name will be set
     */
    public void setEventName(String eventName){
        this.eventName = eventName;
    }

    /**
     * Achieve the date of the current event.
     * 
     * @return the date of the current event
     */
    public Date getEventDate(){
        return this.eventDate;
    }

    /**
     * Set a new date for the current event.
     * 
     * @param eventName the new event date will be set
     */
    public void setEventDate(Date eventDate){
        this.eventDate = eventDate;
    }

}