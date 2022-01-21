public class Participant extends Person{
    /**
     * 
     * 
     * @param id
     * @param userName
     */
    public Participant(String id, String userName) {
        super(id, userName);
        this.amount = 0.0;
        this.status = false;
    }
    private Boolean status;
    private Double amount;
    
    public Boolean getStatus(){
        return this.status;
    }
    
    public void setStatus(Boolean status){
        this.status = status;
    }
    
    public Double getAmount() {
    	return this.amount;
    }
    
    public void setAmount(Double amount) {
    	this.amount = amount;
    }
}
