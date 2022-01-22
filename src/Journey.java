import java.util.*;

public class Journey {
    
    private String journeyId;
    private String journeyName;
    private Date journeyStartDate;
    private Date journeyEndDate;
    private String journeyDescription;

    /*private ArrayList<Event> eventList;
    private ArrayList<Traveler> travelerList;*/
    private HashMap<String, Event> idToEvent;
    private HashMap<String, Event> nameToEvent;
    private HashMap<String, Traveler> idToTraveler;
    private HashMap<String, Traveler> nameToTraveler;

    /**
     * Achieve the id of the current journey
     * 
     * @return the id of the current journey
     */
    public String getJourneyId(){
        return this.journeyId;
    }

    /**
     * Set a new id for the current journey
     * 
     * @param journeyId the new journey id will be set
     */
    public void setJourneyID(String journeyId){
        this.journeyId = journeyId;
    }

    /**
     * Achieve the name of the current journey
     * 
     * @return the name of the current journey
     */
    public String getJourneyName(){
        return this.journeyName;
    }

    /**
     * Set a new name for the current journey
     * 
     * @param journeyName the new journey name will be set
     */
    public void setJourneyName(String journeyName){
        this.journeyName = journeyName;
    }

    /**
     * Achieve the start date of the current journey.
     * 
     * @return the start date of the current journey
     */
    public Date getJourneyStartDate(){
        return this.journeyStartDate;
    }

    /**
     * Set a new start date for the current journey.
     * 
     * @param journeyStartDate the new journey start date will be set
     */
    public void setJourneyStartDate(Date journeyStartDate){
        this.journeyStartDate = journeyStartDate;
    }

    /**
     * Achieve the end date of the current journey.
     * 
     * @return the end date of the current journey
     */
    public Date getJourneyEndDate(){
        return this.journeyEndDate;
    }

    /**
     * Set a end start date for the current journey.
     * 
     * @param journeyEndDate the new journey end date will be set
     * @return 0 if the start date is after the end date, 1 if the end date is after 
     * the start date
     */
    public int setJourneyEndDate(Date journeyEndDate){
        if(!journeyEndDate.after(this.journeyStartDate)){
            return 0;
        }
        this.journeyEndDate = journeyEndDate;
        return 1;
    }

    /**
     * Achieve the description of the current journey.
     * 
     * @return the description of the current journey
     */
    public String getJourneyDescription(){
        return this.journeyDescription;
    }

    /**
     * Set a new journey description for the current journey.
     * 
     * @param journeyDescription the new description to the current journey
     */
    public void setJourneyDescription(String journeyDescription){
        this.journeyDescription = journeyDescription;
    }

    public int addEvent(String eventName){
        if(nameToEvent.containsKey(eventName)){
            return 0;
        }
        String eventId = GenerateId.generateEventId(this.journeyId);
        Event ev1 = new Event(eventId, eventName);
        idToEvent.put(ev1.getEventId(),ev1);
        nameToEvent.put(ev1.getEventName(), ev1);
        return 1;
    }

    public int removeEvent(String eventName){
        if(!nameToEvent.containsKey(eventName)){
            return 0;
        }
        
    }

}