/**The given class, Item handles all the information that was given by the user in creation and modifying its contents
 * <p>
 * It consists of ff. attributes :
 * <ul>
 *     <li><STRONG>{@code itemName}</STRONG> - receives the item Name</li>
 *     <li><STRONG>{@code itemPrice}</STRONG>- receives the item Price </li>
 *     <li><STRONG>{@code itemCalories}</STRONG> - receives the item Calories </li>
 *     <li><STRONG>{@code itemCount}</STRONG>- receives the item Count/Quantity </li>
 * </ul>
 * @author Tolentino, Maxene Allison R.
 * @author Villagarcia, Wilbert Shawn G.
 * </p>
 * */
public class Item {
    private String itemName;
    private double itemPrice, itemCalories;
    private int itemCount;

    /** This Item constructor serves as default value
     **/
    public Item(String itemName, double itemPrice, int itemCount, double itemCalories) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
        this.itemCalories = itemCalories;
    }
    /**This method sets/modify the item's Price
     * @param price user inputted value
     * */
    public void setItemPrice(double price){
        this.itemPrice = price;
    }
    public void addQuantity(int quantity){
        this.itemCount += quantity;
    }
    /**This method gets the stored value to the item's Name
     * @return itemName
     * */
    public String getItemName(){
        return itemName;
    }
    /**This method gets the stored value to the item's Price
     * @return itemPrice
     * */
    public double getItemPrice(){
        return itemPrice;
    }
    /**This method gets the stored value to the item's Calories
     * @return itemCalories
     * */
    public double getItemCalories(){
        return itemCalories;
    }
    /**This method gets the stored value to the item's Count/Quantity
     * @return itemCount
     * */
    public int getItemCount(){
        return itemCount;
    }
    /**This method decrements by one to the Quantity of item in each purchase of the user
     **/
    public void currentItemCount(){
        if (itemCount > 0)
            this.itemCount--;
    }
    /**This method displays the items created
     **/
    public void printAll(int slotNum){
        System.out.println("[" + (slotNum+1) + "] " + getItemName() + " (" + getItemCount() + " items)\n" + "    Price : " + getItemPrice() + " | Calories : " + getItemCalories());
    }
    /**This method displays the item's name created
     **/
    public void printName(){
        System.out.println("> Item Name : " + getItemName());
    }
    /**This method displays the item's price created
     **/
    public void printPrice(){
        System.out.println("> Item Price : " + getItemPrice());
    }
    /**This method displays the item's count/quantity created
     **/
    public void printItemCount(){
        System.out.println("> Item count : " + getItemCount());
    }
    /**This method displays the item's calories created
     **/
    public void printCalories(){
        System.out.println("> Item calories : " + getItemCalories());
    }

}
