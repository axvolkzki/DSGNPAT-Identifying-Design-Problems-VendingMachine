import java.util.ArrayList;

/**The given class, Slots is where the items, and it's information in Item class is stored
 * <p>
 * It consists of ff. attributes :
 * <ul>
 *     <li><STRONG>{@code numItems}</STRONG> - number of items </li>
 *     <li><STRONG>{@code mainItem}</STRONG> - It allows the class to store and manipulate an instance of the "Item" class internally </li>
 *     <li><STRONG>{@code inputItems}</STRONG> - The whole info of an item will be added in a list  </li>
 * </ul>
 * @author Tolentino, Maxene Allison R.
 * @author Villagarcia, Wilbert Shawn G.
 * </p>
 * */
public class Slots {
    private int numItems;
    private Item mainItem;
    private ArrayList<Item> inputItems = new ArrayList <Item>();

    /** The purpose of this constructor is to initialize an instance of the Slots class.
     * <p>Within the constructor, a new Item object is created using these parameters and assigned to the mainItem variable
     * @param prodName product name
     * @param prodPrice product price
     * @param prodItemCount quantity of the product
     * @param prodCalories calorie of a product
     * */
    public Slots(String prodName, double prodPrice, int prodItemCount, double prodCalories){
        mainItem = new Item(prodName, prodPrice, prodItemCount, prodCalories);
        this.numItems = prodItemCount;
        for(int i = 0; i < numItems; i++)
            inputItems.add(mainItem);
    }
    /**This getter method's function is to give users outside the class access to the private mainItem variable. Other sections of the code can access
     * @return mainItem
     **/
    public Item getMainItem(){
        return mainItem;
    }
}
