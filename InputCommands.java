import java.util.Scanner;
/** The given class, InputCommands, provides a set of static methods that handle user input.<p>
 * </p>
 * It consists of ff. attributes :
 * <ul>
 *     <li><STRONG>{@code sc}</STRONG>- represents as the Scanner object for Scanner class.This object is used to read input from the standard input stream (System.in)</li>
 * </ul>
 *  @author Tolentino, Maxene Allison R.
 *  @author Villagarcia, Wilbert Shawn G.
 * */
public class InputCommands {
    private static Scanner sc = new Scanner(System.in);

    /**
     * This method reads an integer from the user and checks to make sure it does not exceed the input value that has been set.<p>
     * It constantly asks for input from the user until a valid value is entered, at which point it returns the selected value.
     * </p>
     * @param input user Integer input
     * @return <code>chosen value </code>*/
    public static int ScanInt(int input){
        int choice;
        do {
            choice = sc.nextInt();
        }while (input > choice);
        return choice;
    }

    /**This method takes a user-provided integer input and checks to see if it is within the given range, including the minimum and maximum choices. <p>In addition, it disqualifies the number zero as an option. It keeps asking for input from the user until an appropriate value is entered, at which point it returns the selected value.</p>
     * @param minChoice minimum choice the user can input based from the given range
     * @param maxChoice maximum choice the user can input based from the given range
     * @return <code>choice - user chosen value</code>
     * */
    public static int ScanInt (int minChoice, int maxChoice){
        int choice;
        do {
            choice = sc.nextInt();
        }while(choice > maxChoice|| choice < minChoice || choice==0);
        return choice;
    }
    
    /**
     * This method is to read a string input from the user.<br>It reads a single word, which is a string of letters without any spaces, and outputs it.</br>
     * @return <code>String input of the user </code>
     * */
    public static String ScanStr(){
        return sc.next();
    }
    /**
     * This method reads a double value from the user and checks to make sure it does not exceed the input value that has been set.<p>
     * It constantly asks for input from the user until a valid value is entered, at which point it returns the selected value.
     * </p>
     * @param input user double input
     * @return <code>chosen value </code>*/
    public static double ScanDouble(double input){
        double choice;
        do {
            choice = sc.nextInt();
            if (input > choice)
                System.out.println("Number Input Error!");
        }while (input > choice);
        return choice;
    }
    /**
     * This method closes the underlying Scanner object.*/
    public static void ScanClose(){
        sc.close();
    }
}
