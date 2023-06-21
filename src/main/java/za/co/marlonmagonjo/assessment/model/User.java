package za.co.marlonmagonjo.assessment.model;

public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String contactNumber;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public User() {
    }

    public User(String userId, String firstName, String lastName, String contactNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
    }
}
