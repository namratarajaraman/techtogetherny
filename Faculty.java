/**
 * 
 */
package User;

/**
 * Creates an object that stores and retrieves a faculty 
 * member's information.
 * 
 * @author Catherine, Chitra, Namrata, Rachel
 *
 */
public class Faculty extends User {

	/**
	 * Constructs a student object
	 * @param firstName of the student
	 * @param lastName of the student
	 * @param userName of the student
	 * @param password of the student
	 */
	public Faculty(String firstName, String lastName, String userName, String password) {
		super(firstName, lastName, userName, password);
	}
	
	// something to ensure another faculty member does not have 
	// the same user name as another?

}