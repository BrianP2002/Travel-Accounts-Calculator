import java.util.*;
public class Event {
    private String eventId;
    private String eventName;
    private Date eventDate;
    private String eventDescription;
    private String payerId;
    private String payerUserName;
    private Double costAmount;
    private Boolean equalDivide;

    private ArrayList<Participant> participantsList = new ArrayList<Participant>();
    private HashMap<String, Boolean> chkParticipants = new HashMap<>();


    /**
     * 
     * @param eventId
     * @param eventName
     * @param eventDate
     * @param eventDescription
     * @param payerId
     * @param payerUserName
     * @param costAmount
     * @param equalDivide
     */
    public Event(String eventId, String eventName, Date eventDate, String eventDescription, String payerId, String payerUserName, Double costAmount, Boolean equalDivide){
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.payerId = payerId;
        this.payerUserName = payerUserName;
        this.costAmount = costAmount;
        this.equalDivide = equalDivide;
    }
    
    /**
     * Achieve the id of the current event
     * 
     * @return the id of the current event
     */
    public String getEventId(){
        return this.eventId;
    }

    /**
     * Set a new id for the current event
     * 
     * @param eventId the new event id will be set
     */
    public void setEventID(String eventId){
        this.eventId = eventId;
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
    /**
     * Achieve the description of the current event.
     * 
     * @return the description of the current event
     */
    public String getEventDescription(){
        return this.eventDescription;
    }

    /**
     * Set a new event description for the current event.
     * 
     * @param eventDescription the new description to the current event
     */
    public void setEventDescription(String eventDescription){
        this.eventDescription = eventDescription;
    }

    /**
     * Achieve the id of the payer of this event.
     * 
     * @return the id of the payer
     */
    public String getPayerId(){
        return this.payerId;
    }
    
    /**
     * Update the Id for the payer of this event.
     * 
     * @param payerId the new payer id will be set
     */
    public void setPayerId(String payerId){
        this.payerId = payerId;
    }

    /**
     * Achieve the userName of the payer.
     * 
     * @return the userName of the payer
     */
    public String getPayerUserName(){
        return this.payerUserName;
    }

    /**
     * Update the userName of the payer.
     * 
     * @param payerUserName the new userName of the payer
     */
    public void setPayerUserName(String payerUserName){
        this.payerUserName = payerUserName;
    }
    
    /**
     * Achieve the cost amount of this event
     * 
     * @return the cost amount of this event
     */
    public Double getCostAmount(){
        return this.costAmount;
    }

    /**
     * Update the cost amount of current event
     * 
     * @param costAmount the new cost Amount of this current event
     */
    public void setCostAmount(Double costAmount){
        this.costAmount = costAmount;
    }
    
    /**
     * Check that whether the current event is equally split or not.
     * 
     * @return whether the current event is equally split or not
     */
    public boolean getEqualDivide() {
    	return this.getEqualDivide();
    }
    
    /**
     * Update the status of current event to check that whether it is equally divided.
     * 
     * @param equalDivide the new status
     */
    public void setEqualDivide(boolean equalDivide) {
    	this.equalDivide = equalDivide;
    	if(this.equalDivide == true) {
    		this.autoFill();
    	}
    }
    /**
     * Add a new participant to this event.
     * 
     * @param t1 a traveler, a new participant will be created based on this traveler
     * object
     * @return 0 if this traveler have already joined this evnet, 1 if this traveler is
     * added to this event successfully
     */
    public int addParticipant(Traveler t1){
    	if(chkParticipants.containsKey(t1.getId())) {
    		return 0;
    	}
    	else {
    		chkParticipants.put(t1.getId(), true);
    	}
    	Participant p1 = new Participant(t1.getId(), t1.getUserName());
        participantsList.add(p1);

        if(getEqualDivide()){
            this.autoFill();
        }
        return 1;
        
    }
    
    /**
     * Remove a participant from this event.
     * 
     * @param id the id of the participant will be removed from the event
     * @return 0 if this participant does not exist, 1 if this participant is removed successfully
     */
    public int removeParticipant(String id) {
        if(!chkParticipants.containsKey(id)){
            return 0;
        }
    	for(int i = 0; i < participantsList.size(); ++i) {
    		if(participantsList.get(i).getId().equals(id)) {
    			participantsList.remove(i);
    			chkParticipants.remove(id);
    			if(getEqualDivide()){
    	            this.autoFill();
    	        }
                return 1;
    		}
    	}
        return 0;
    }

    /**
     * Set the given participant with a given amount. 
     * 
     * @param Id the id of the given participant
     * @param amount the amount this participant need to pay in this event
     * @return 0 if such participant does not exist, 1 if the amount of that participant
     * is revised sucessfully
     */
    public int setParticipantAmount(String Id, Double amount) {
        if(!chkParticipants.containsKey(Id)){
            return 0;
        }
    	for(int i = 0; i < participantsList.size(); ++i) {
    		if(participantsList.get(i).getId().equals(Id)) {
    			participantsList.get(i).setAmount(amount);
                return 1;
    		}
    	}
        return 0;
    }
    
    /**
     * This function will automatically given each participants an amount in
     * the circumstance that this event is equally divided by all participants.
     */
    public void autoFill(){
    	if(participantsList.size() == 0) {
    		return;
    	}
        Double avgAmount = costAmount/participantsList.size();
        for(int i = 0; i < participantsList.size(); ++i){
        	participantsList.get(i).setAmount(avgAmount);
        }
    }
}