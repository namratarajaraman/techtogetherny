/**
 * 
 */
package User;

/**
 * Creates an object that stores and retrieves a students 
 * information.
 * 
 * @author Catherine, Chitra, Namrata, Rachel
 *
 */
public class Student extends User {

	/**
	 * Constructs a student object
	 * @param firstName of the student
	 * @param lastName of the student
	 * @param userName of the student
	 * @param password of the student
	 */
	public Student(String firstName, String lastName, String userName, String password) {
		super(firstName, lastName, userName, password);
	}
	
	// something to ensure another student does not have the same
	// user name as another?

}