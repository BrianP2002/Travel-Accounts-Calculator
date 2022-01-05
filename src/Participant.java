public class Participant extends Traveler{
    /**
     * 
     * 
     * @param id
     * @param userName
     */
    public Participant(String id, String userName) {
        super(id, userName);
        
    }
    private Boolean status;

    
    public Boolean getStatus(){
        return this.status;
    }
    public void setStatus(Boolean status){
        this.status = status;
    }
}
