public class employee extends Person{
    private String firstName;
    private String lastName;
    private String userID;

    public employee(String firstName, String lastName, String userID) {
        super(firstName, lastName, userID);
    }

    public employee() {
        super("burak","can","0122");
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getUserID() {
        return userID;
    }

    @Override
    public void setUserID(String userID) {
        this.userID = userID;
    }
}
