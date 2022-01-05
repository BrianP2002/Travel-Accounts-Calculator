public class Traveler {
    private String id;
    private String userName;
    private Double totalAmount;
    private Double payForOthers;
    private Double payByOthers;

    public Traveler(String id, String userName){
        this.id = id;
        this.userName = userName;
        this.totalAmount = 0.0;
        this.payForOthers = 0.0;
        this.payByOthers = 0.0;
    }

    /**
     * Achieve the ID of the specific traveler.
     * 
     * @return the ID of this traveler
     */
    public String getId(){
        return this.id;
    }

    /**
     * Set a new ID for the specific traveler.
     * 
     * @param id the new ID will be set
     */
    public void setId(String id){
        this.id = id;
    }
    
    /**
     * Achieve the user name of the specific traveler.
     * 
     * @return the user name of this traveler
     */
    public String getUserName(){
        return this.userName;
    }

    /**
     * Set a new user name for the specific traveler.
     * 
     * @param userName the new user name will be set
     */
    public void setUserName(String userName){
        this.userName = userName;
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
     * set a new amount that this traveler paid by others in total.
     * 
     * @param payByOthers the new amount that this traveler paid by others in total
     */
    public void setPayByOthers(Double payByOthers){
        this.payByOthers = payByOthers;
        this.generateTotalAmount();
    }
}