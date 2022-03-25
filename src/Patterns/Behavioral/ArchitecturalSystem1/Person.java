package Patterns.Behavioral.ArchitecturalSystem1;

public class Person {
    private int idPerson;
    private String lastName;
    private String firstName;
    private String phoneNumber;

    public Person() {
        this.idPerson = 0;
        this.lastName = "";
        this.firstName = "";
        this.phoneNumber = "";
    }

    public Person(int idPerson, String lastName, String firstName, String phoneNumber) {
        this.idPerson = idPerson;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
