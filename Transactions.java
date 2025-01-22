/** The given class, Transactions is where the details of an item's price, name, the payment made by the user, and the resulting change.
 * <p>
 * It consists of ff. attributes :
 * <ul>
 *     <li><STRONG>{@code itemPrice}</STRONG> - price of an item </li>
 *     <li><STRONG>{@code itemName}</STRONG> - item Name </li>
 *     <li><STRONG>{@code payment}</STRONG> - user's payment </li>
 *     <li><STRONG>{@code change}</STRONG> -  user's received change  </li>
 * </ul>
 * @author Tolentino, Maxene Allison R.
 * @author Villagarcia, Wilbert Shawn G.
 * </p>
 * */
public class Transactions{
    private double itemPrice;
    private String itemName;
    private int payment;
    private double change;

    /**
     * This constructor that takes the attributes as parameters and initializes the corresponding instance variables
     * @param itemPrice represent as variable for the price of item
     * @param itemName represent as variable for the name of item
     * @param payment represent as variable for the payment gave by the user
     * @param change represent as variable for the amount of change received by the user
     * */
    public Transactions(double itemPrice, String itemName, int payment, double change){
        this.itemPrice = itemPrice;
        this.itemName = itemName;
        this.payment = payment;
        this.change = change;
    }
    /**
    * this method offers a practical way to retrieve and present transaction information.
    **/
    public void getTransactionDetails(){
        System.out.println("Item Name: " + this.itemName);
        System.out.println("Item Price: " + this.itemPrice);
        System.out.println("User Payment: " + this.payment);
        System.out.println("User Change: " + this.change + "\n");
    }
}
