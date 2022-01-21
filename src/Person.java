public class Person {
    private String id;
    private String userName;

    public Person(String id, String userName){
        this.id = id;
        this.userName = userName;
    }

    /**
     * Achieve the ID of the specific person.
     * 
     * @return the ID of this person
     */
    public String getId(){
        return this.id;
    }

    /**
     * Set a new ID for the specific person.
     * 
     * @param id the new ID will be set
     */
    public void setId(String id){
        this.id = id;
    }
    
    /**
     * Achieve the user name of the specific person.
     * 
     * @return the user name of this person
     */
    public String getUserName(){
        return this.userName;
    }

    /**
     * Set a new user name for the specific person.
     * 
     * @param userName the new user name will be set
     */
    public void setUserName(String userName){
        this.userName = userName;
    }
}
