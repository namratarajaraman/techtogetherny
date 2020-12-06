/**
 * 
 */
package User;

/**
 * Creates a general user that branches off into students and faculty.
 * 
 * @author Catherine, Chitra, Namrata, Rachel
 *
 */
public abstract class User {

	/**
     * The user's first name
     */
    private String firstName;
    /**
     * The user's last name
     */
    private String lastName;
    /**
     * The user's chosen user name.
     */
    private String userName;
    /**
     * The user's to the student's NCSU account.
     */
    private String password;
    
    /**
     * Constructs the User object
     * 
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param userName the user's user name
     * @param password the user's password
     */
    public User(String firstName, String lastName, String userName,  String password) {
        super();
        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setPassword(password);
    }
    
    /**
     * Returns the first name of the student.
     * 
     * @return firstName the student's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Changes the first name of the student if a valid string is given.
     * 
     * @param firstName student's new first name
     * @throws IllegalArgumentException if no first name was given
     */
    public void setFirstName(String firstName) {
        if (firstName == null || "".equals(firstName)) // checks to see if valid first name was given
        {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the student.
     * 
     * @return lastName student's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Changes the student's last name if a valid string is given.
     * 
     * @param lastName student's new last name
     */
    public void setLastName(String lastName) {
        if (lastName == null || "".equals(lastName)) // checks to see if valid last name was given
        {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;

    }

    /**
     * Returns the student's ID number
     * 
     * @return id the student's id number
     */
    public String getId() {
        return userName;
    }

    /**
     * Changes the student's id number if a valid string is given.
     * 
     * @param id student's new id number
     */
    protected void setUserName(String id) {
        if (id == null || "".equals(id)) // checks to see if valid id was given
        {
            throw new IllegalArgumentException("Invalid id");
        }
        this.userName = id;
    }

    /**
     * Returns student's NCSU password
     * 
     * @return password student's NCSU password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Changes password if a valid password is given
     * 
     * @param password student's new NCSU password
     */
    public void setPassword(String password) {
        if (password == null || "".equals(password)) // checks to see if valid password was given
        {
            throw new IllegalArgumentException("Invalid password");
        }
        this.password = password;

    }

    /**
     * finds the hashcode value for the object
     * @return the result of the hashcode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    /**
     * Checks if the two objects are equal and returns true if they are and false if they are not
     * @return true if they are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }
}