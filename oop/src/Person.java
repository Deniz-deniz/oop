import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private String userID;

    // Encapsulation
    public Person(String firstName, String lastName, String userID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;

    }

    //Polymorphism override.


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;

    }

    public String getUserID() {
        return userID;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(userID, person.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID);
    }


}
