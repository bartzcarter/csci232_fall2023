/***
 * Class to model the Entity Contact
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: March 6, 2023
 * Last Date Modified: March 9, 2023
 */
public class Contact implements Comparable<Contact>{
    //data members
    private String name;
    private String phone;
    private String email;
    /***
    Default no-arg constructor
    initializes name, phone, and email to null
    @param  none
    @return none
     */
    public Contact(){
        name = null;
        phone = null;
        email = null;
    }
    /***
    3-arg constructor
    @param  name to set the data member name 
    @param  phone to set the data member phone
    @param  email to set the data member email
    @return none
    */
    public Contact(String name, String phone, String email){
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    /***
    Getter method for the data member name 
    @param  none
    @return name of the contact
     */
    public String getName(){
        return name;
    }
    /***
    Getter method for the data member phone
    @param  none
    @return phone the phone number for the contact
     */
    public String getPhone(){
        return phone;
    }
    /***
    Getter method for the data member email
    @param  none
    @return email the email of the contact
     */
    public String getEmail(){
        return email;
    }
    /***
    Setter method for the data member name
    @param  n to set the name of the contact
    @return none
     */
    public void setName(String n){
        name = n;
    }
    /***
    Setter method for the data member phone
    @param  p to se the phone number
    @return none
     */
    public void setPhone(String p){
        phone = p;
    }
    /***
    Setter method for the data member email
    @param  e to set the email of the contact
    @return none
     */
    public void setEmail(String e){
        email = e;
    }
    /***
    Overridden toStirng() method to return data members of Contact in formattde string
    @param  none
    @return formated stirng of data members for Contact objects
      */
    @Override
    public String toString(){
        return String.format("%-20s\t%-20s\t%-20s", name, phone, email);
    }
    /***
    equals method to check if two objects of type Contact are equal to eachother
    @param  o the object to be checked for type Contact and compared
    @return true if the Contacts are equal
    @return false if the contacts are not equal or o is not an instance of Contact
     */
    public boolean equals(Object o){
        if(o instanceof Contact){
            Contact c = (Contact)o;
            return this.getName().equals(c.getName()) && this.getPhone().equals(c.getPhone()) && this.getEmail().equals(c.getEmail());
        }
        else{
            return false;
        }
    }
    /***
    CompareTo method that is requird by Comparable
    Will order Contacts by Name
    @param  c the contact to be compared
    @return value that represents if c is to be ordered before or after this
     */
    public int compareTo(Contact c){
        if(this.getName().equals(c.getName())){
            return 0;
        }
        else if(this.getName().compareTo(c.getName()) > 0){
            return 1;
        }
        else{
            return -1;
        }
    }
}