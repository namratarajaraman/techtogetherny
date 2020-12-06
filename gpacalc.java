import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class calculates the GPA for the student in the four provided courses
 * 
 * @author Catherine, Chitra, Namrata, Rachel
 *
 */
public class GPACalc {

	public static final double  A_PLUSPOINTS = 4.333;
	public static final double  A_POINTS = 4.0;
	public static final double  A_MINUSPOINTS = 3.667;
	public static final double  B_PLUSPOINTS = 3.333;
	public static final double  B_POINTS = 3.0;
	public static final double  B_MINUSPOINTS = 2.667;
	public static final double  C_PLUSPOINTS = 2.333;
	public static final double  C_POINTS = 2.0;
	public static final double  C_MINUSPOINTS = 1.667;
	public static final double  D_PLUSPOINTS = 1.333;
	public static final double  D_POINTS = 1.0;
	public static final double  D_MINUSPOINTS = 0.667;
	public static final double  F_POINTS = 0.0;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		String[] courses = {"Science", "Math", "English", "History"};
		double[] grades = {0.0, 0.0, 0.0, 0.0};
		int rollingCredits = 0;
		for (int i = 0; i < courses.length; i++) {
			System.out.print("Please enter grade for " + courses[i] + ":");
			String letterGrade = scan.next().toUpperCase();
			//error checking for the letter grade input
			if (letterGrade.length() != 1 && letterGrade.length() != 2) {
				throw new IllegalArgumentException("Enter valid letter grade");
			} else if (!(Character.isLetter(letterGrade.charAt(0)))) {
				throw new IllegalArgumentException("Enter valid letter grade");
			} else if (!((int)letterGrade.charAt(0) >= 65 && (int)letterGrade.charAt(0) <= 70 && (int)letterGrade.charAt(0) != 69)) {
				throw new IllegalArgumentException("Enter valid letter grade");
			} else if (letterGrade.length() == 2) {
				if (letterGrade.charAt(1) != '+' && letterGrade.charAt(1) != '-') {
					throw new IllegalArgumentException("Enter valid letter grade");
				}
			}
			try {
				System.out.print("Please enter the number of credits for " + courses[i] + ":");
				int credits = scan.nextInt();
				//some error checking for the credits
				if (credits < 1 || credits > 7) {
					throw new IllegalArgumentException("Enter valid number of credits");
				}
				rollingCredits += credits;
				
				double courseGrade = 0;
				
				if (letterGrade.equals("A+")) {
					 courseGrade = credits * A_PLUSPOINTS;
				}
				if (letterGrade.equals("A")) {
					 courseGrade = credits * A_POINTS;
				}
				if (letterGrade.equals("A-")) {
					 courseGrade = credits * A_MINUSPOINTS;
				}
				if (letterGrade.equals("B+")) {
					 courseGrade = credits * B_PLUSPOINTS;
				}
				if (letterGrade.equals("B")) {
					 courseGrade = credits * B_POINTS;
				}
				if (letterGrade.equals("B-")) {
					 courseGrade = credits * B_MINUSPOINTS;
				}
				if (letterGrade.equals("C+")) {
					 courseGrade = credits * C_PLUSPOINTS;
				}
				if (letterGrade.equals("C")) {
					 courseGrade = credits * C_POINTS;
				}
				if (letterGrade.equals("C-")) {
					 courseGrade = credits * C_MINUSPOINTS;
				}
				if (letterGrade.equals("D+")) {
					 courseGrade = credits * D_PLUSPOINTS;
				}
				if (letterGrade.equals("D")) {
					 courseGrade = credits * D_POINTS;
				}
				if (letterGrade.equals("D-")) {
					 courseGrade = credits * D_MINUSPOINTS;
				}
				if (letterGrade.equals("F")) {
					 courseGrade = credits * F_POINTS;
				}
				
				grades[i] = courseGrade;
			} catch (InputMismatchException e) {
				throw new IllegalArgumentException("Enter valid number of credits");
			}
		}
		scan.close();
			
		double gpa = (grades[0] + grades[1] + grades[2] + grades[3]) / rollingCredits;
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.DOWN);
		if (gpa > 4) {
			gpa = 4.0;
		}
		System.out.println();
		System.out.println("Your GPA is " + df.format(gpa));
		df.setRoundingMode(RoundingMode.DOWN);
		if (gpa < 2.5) {
			System.out.println("Great effort. Try going to a study group to improve your grade :)");
		}
		df.setRoundingMode(RoundingMode.DOWN);
		if (gpa > 3.5) {
			System.out.println("You are doing FAB!");
		}
	}
}