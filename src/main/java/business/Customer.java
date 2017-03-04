package business;

/**
 * Created by Vijai3D on 04.03.2017.
 */
public class Customer {

    Integer ID;
    String custName;
    String custLastName;
    String custEmail;
    Boolean custSubscribed;
    //...


    public Customer() {
        ID = null;
        custName ="";
        custLastName = "";
        custEmail = "";
        custSubscribed = null;
    }

    public Customer(Integer ID, String custName, String custLastName, String custEmail, Boolean custSubscribed) {
        this.ID = ID;
        this.custName = custName;
        this.custLastName = custLastName;
        this.custEmail = custEmail;
        this.custSubscribed = custSubscribed;
    }

    public Integer getID() {
        return ID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public Boolean getCustSubscribed() {
        return custSubscribed;
    }

    public void setCustSubscribed(Boolean custSubscribed) {
        this.custSubscribed = custSubscribed;
    }
}
