public class Students {
    private String SID ;
    private String firstName ;
    private String lastName ;

    public Students(String SID,String firstName ,String lastName){
        this.SID = SID;
        this.firstName = firstName;
        this.lastName = lastName ;
    }
    
    public String getSID(){
        return this.SID;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }


    public String toString(){
        return this.SID + " " + this.firstName + " " + this.lastName;
    }
}