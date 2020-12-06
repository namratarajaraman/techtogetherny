/**
 * 
 */
package Manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import User.Faculty;
import User.Student;
import User.User;

/**
 * Handles important functionality for all users including adding them
 * to the database, etc - does not need to remove them
 * 
 * Overall, this class handles logging in and creating accounts
 * 
 * Some code is based on previous school work from Chitra and Rachel
 * 
 * @author Catherine, Chitra, Namrata, Rachel
 *
 */
public class UserManager {

	/** SortedList of students in the directory */
    private ArrayList<Student> studentList;
    /** LinkedList of Faculty members */
	private ArrayList<Faculty> facultyList;
    /** Hashing algorithm */
    private static final String HASH_ALGORITHM = "SHA-256";
	
	/**
     * Searches studentDirectory for a student by the id provided
     * 
     * @param id the studentId of the student being searched
     * @return the student found or null if student is not found
     */
    public Student getStudentById(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            String currentID = s.getId();
            if (currentID.equals(id)) {
                return s;
            }
        }
        return null;
    }
	
	/**
     * This method is called when an account is created
     * 
     * Adds a Student to the directory. Returns true if the student is added and
     * false if the student is unable to be added because their id matches another
     * student's id.
     * 
     * This method also hashes the student's password for internal storage.
     * 
     * @param firstName student's first name
     * @param lastName student's last name
     * @param userName student's user name
     * @param password student's password
     * @param repeatPassword student's repeated password
     * @param maxCredits student's max credits.
     * @return true if added
     */
    public boolean addStudent(String firstName, String lastName, String userName, String password,
        String repeatPassword, int maxCredits) {
        String hashPW = "";
        String repeatHashPW = "";
        if (password == null || repeatPassword == null || "".equals(password) || "".equals(repeatPassword)) {
            throw new IllegalArgumentException("Invalid password");
        }
        try {
            MessageDigest digest1 = MessageDigest.getInstance(HASH_ALGORITHM);
            digest1.update(password.getBytes());
            hashPW = new String(digest1.digest());

            MessageDigest digest2 = MessageDigest.getInstance(HASH_ALGORITHM);
            digest2.update(repeatPassword.getBytes());
            repeatHashPW = new String(digest2.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Cannot hash password");
        }

        if (!hashPW.equals(repeatHashPW)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        // If an IllegalArgumentException is thrown, it's passed up from Student
        // to the GUI
        Student student = null;
        if (maxCredits < 3) {
            student = new Student(firstName, lastName, userName, hashPW);
        } else {
            student = new Student(firstName, lastName, userName, hashPW);
        }

        //no duplicates
        for (int i = 0; i < studentList.size(); i++) {
            User s = studentList.get(i);
            if (s.getId().equals(student.getId())) {
                return false;
            }
        }
        return studentList.add(student);
    }
    
    
    /**
	 * This method is called when an account is created
	 * 
	 * Adds a Faculty member to the list and checks for errors.
	 * 
	 * @param firstName first name of the faculty member
	 * @param lastName last name of the faculty member
	 * @param userName user name of the faculty member
	 * @param password password of the faculty member
	 * @param repeatPassword password of the faculty member again
	 * @param maxCredits max credits specific to the faculty member
	 * @return whether or not the faculty member has been added
	 * @throws IllegalArgumentException if invalid password, cannot hash the password, or
	 * the passwords don't match, 
	 */
	public boolean addFaculty(String firstName, String lastName, String userName, String email, String password, String repeatPassword) {
		String hashPW = "";
		String repeatHashPW = "";
		if (password == null || repeatPassword == null || "".equals(password) || "".equals(repeatPassword)) {
            throw new IllegalArgumentException("Invalid password");
        }
		try {
            MessageDigest digest1 = MessageDigest.getInstance(HASH_ALGORITHM);
            digest1.update(password.getBytes());
            hashPW = new String(digest1.digest());

            MessageDigest digest2 = MessageDigest.getInstance(HASH_ALGORITHM);
            digest2.update(repeatPassword.getBytes());
            repeatHashPW = new String(digest2.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Cannot hash password");
        }
		
        if (!hashPW.equals(repeatHashPW)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        Faculty faculty = new Faculty(firstName, lastName, userName, hashPW);

        for (int i = 0; i < facultyList.size(); i++) {
            User f = facultyList.get(i);
            if (f.getId().equals(faculty.getId())) {
                return false;
            }
        }
        return facultyList.add(faculty);
	}
	
	
	//needs to handle functionality for logging in as well
    
}