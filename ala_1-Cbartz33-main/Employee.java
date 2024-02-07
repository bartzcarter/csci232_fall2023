/**
 * class to model the entity Employee
 * @author Carter Bartz
 * @version 0.1
 * Date of creation: Jan 24, 2023
 * Last date modified: jan 24, 2023
 */
public class Employee extends Person {
    // Data members
    private int id;
    private String position;
    private double salary;

    /**
     * Default constructor
     * No parameters
     * Initializes id, position, and salary to null values or 0 for ints or doubles
     */
    public Employee() {
        super();
        this.id = 0;
        this.position = "null";
        this.salary = 0;
    }

    /**
     * Constructor with 7 parameters
     * @param name     for the name of the employee
     * @param adress   for the adress of the employee
     * @param phone    for the phone number of the employee
     * @param email    for the email of the employee
     * @param id       for the id of the employee
     * @param position for the postion of the employee
     * @param salary   for the salary of the employee
     */
    public Employee(String name, String adress, String phone, String email, int id, String position, double salary) {
        super(name, adress, phone, email);
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    /**
     * Getter method for the id
     * @param none
     * @return the integer value of the id
     */
    public int getID() {
        return this.id;
    }

    /**
     * Getter method for the employees position
     * @param none
     * @return the string value position
     */
    public String getPosition() {
        return this.position;
    }

    /**
     * Getter method for the employees salary
     * @param none
     * @return the double value salary
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * Setter method for the employee id
     * @param id to set the data member id
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Setter method for the employee position
     * @param p to set the data member position
     */
    public void setPosition(String p) {
        this.position = p;
    }

    /**
     * Setter method for the employee salary
     * @param salary to set the data member salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Overriden method for the toString() method to get employee information
     * @param none
     * @return formatted string containing the data members
     */
    @Override
    public String toString() {
        return String.format("%s\nID: %d\nPosition: %s\nSalary: $%.2f\n", super.toString(), id, position, salary);
    }
}