import java.util.ArrayList;
/** The given class, RegularVM is where the creation of vending machine for regular machine will be done
 * <p>
 * It consists of ff. attributes :
 * <ul>
 *     <li><STRONG>{@code itemSlot}</STRONG> - slots for item </li>
 *     <li><STRONG>{@code vmMoneyDenomination}</STRONG> - The class can store and manipulate the specific money denomination used by the vending machine. </li>
 *     <li><STRONG>{@code filledSlots}</STRONG> - will count how many slots are taken </li>
 *     <li><STRONG>{@code transactionList}</STRONG> -  list of transaction made by the user </li>
 *     <li><STRONG>{@code transactionIndex}</STRONG> -  number of transactions made   </li>
 * </ul>
 * @author Tolentino, Maxene Allison R.
 * @author Villagarcia, Wilbert Shawn G.
 * </p>
 * */
public class RegularVM {
    private final Slots[] itemSlot;
    private Money vmMoneyDenomination;
    private int filledSlots = 0;
    private ArrayList<Transactions> transactionList;
    private int transactionIndex = 0;

    /**<p>The relevant characteristics, such as the slots for items, the list of transactions, and the money denomination, are initialized in the constructor of a RegularVM object to build up the object's initial state.</p>
     * */
    public RegularVM() {
        itemSlot = new Slots[10]; // limit for the number of items at Least 8 slots.
        transactionList = new ArrayList<>(); //list of made transactions
        vmMoneyDenomination = new Money();
    }
    /**
     * This method is used to create a vending machine. It sets up the slots for items, prompts for item information, and adds money to the vending machine
     * @param money utilizes this initial money to prompt for additional money denominations and add them to the vending machine's current money balance during the creation process
     * */
    public void createRVM(Money money){
        int slotPlace = 0;
        while (filledSlots < 8 || slotPlace != 11){
            slotPlace = selectSlot(filledSlots);
            if (slotPlace <= 10){
                setItemInformation(slotPlace - 1);
                filledSlots++;
            } else if(filledSlots < 8){
                System.out.println("\nCannot exit, Slots must be at least 8.\n");
            }
        }
        System.out.println(">> Add Money to the Vending Machine <<");
        System.out.println("Select type of Money Denomination for Vending Machine:");
        do {
            setVMDenomination(putMoneyInVM(money));
            System.out.println("\nVending Machine Current Money : ");
            displayMoney(getVendingMachineMoney());
            System.out.println("\nAdd more money in creation of this Vending Machine?\n\t1) Yes\n\t2) No");
            System.out.print("choose : ");
        } while (InputCommands.ScanInt(1, 2) == 1);
    }
    /**
     * Will ask the user in which slot to create Item
     * @return InputCommands.ScanInt(1, 15)
     */
    public int selectSlot(int filledSlots) {
        System.out.println("\nSelect a slot [" + filledSlots + " created]");
        for (int i = 0; i < 10; i++) {
            if (!(isSlotNull(i)))
                System.out.println((i + 1) + ") " + getItemDetails(i).getItemName());
            else
                System.out.println((i + 1) + ") " + "--");
        }
        System.out.println("11) Done");
        System.out.print("choose : ");
        return (InputCommands.ScanInt(1, 11));
    }

    /**
     * This will ask the user to input Item details
     * @param slotNumber the selcted slot for Item creation
     */
    public void setItemInformation(int slotNumber) {
        int quantity;
        System.out.println("-------------------------------");
        System.out.print("Enter Item Name : ");
        String str = InputCommands.ScanStr();
        System.out.print("Enter Item Price : ");
        double price = InputCommands.ScanDouble(0);
        do {
            System.out.print("Enter Item Quantity : ");
            quantity = InputCommands.ScanInt(0);
            if (quantity <=9 || quantity > 30)
                System.out.println("Item quantity must be at least (10) and must not exceed (30) items, Try Again.\n");
        }while (quantity <= 9 || quantity > 30);
        System.out.print("Enter Item Calories : ");
        double calorie = InputCommands.ScanDouble(0);
        setItem(str, price, quantity, calorie, slotNumber);
    }
    /** This method will display the information of an specific item selected by user
     * @param slotNum specific slot of an item
     * */
    public void displayDetails(int slotNum){
        itemSlot[slotNum].getMainItem().printName();
        itemSlot[slotNum].getMainItem().printPrice();
        itemSlot[slotNum].getMainItem().printItemCount();
        itemSlot[slotNum].getMainItem().printCalories();
    }

    /**
     * This method is to check if the specific chosen slot is empty
     * @param slotNum number of index slot
     * @return itemSlot[slotNum] == null;
     */
    public boolean isSlotNull(int slotNum) {
        return itemSlot[slotNum] == null;
    }
    /**
     * This method checks if all slots in a vending machine are empty over the slots and counting the number of null slots. It returns true if all slots are null (empty), indicating that the vending machine is empty, and false otherwise.
     * */
    public boolean isEmpty() {
        int empty = 0;
        for (int i = 0; i < 8; i++) {
            if (isSlotNull(i))
                empty++;
        }
        return empty == 8;
    }
    /**
     * The method setItem is used to set the information of an item at a specific slot in the vending machine.
     * @param itemName     represents the item name
     * @param itemPrice    represents the item price
     * @param itemCount    represents the quantity of items
     * @param itemCalories represents the calorie amount of the item
     * @param slotNumber   represents in which slot the creation of item belongs
     */
    public void setItem(String itemName, double itemPrice, int itemCount, double itemCalories, int slotNumber) {
        itemSlot[slotNumber] = new Slots(itemName, itemPrice, itemCount, itemCalories);
    }
    /**
     * This method is to access Item class through Slot class
     * @param slotNum number of index slot
     * @return itemSlot[slotNum].getMainItem();
     */
    public Item getItemDetails(int slotNum) {
        return itemSlot[slotNum].getMainItem();
    }

    /*============================ Money Denomination ================================*/
    /** This method shows the availability of money deomination for creation
     * @param vmMoney access and manipulate the money information specific to the vending machine being operated.
     */
    public static Money putMoneyInVM(Money vmMoney) {
        System.out.println("\t1) 1 PHP Coins");
        System.out.println("\t2) 5 PHP Coins");
        System.out.println("\t3) 10 PHP Coins");
        System.out.println("\t4) 20 PHP Bills");
        System.out.println("\t5) 50 PHP Bills");
        System.out.println("\t6) 100 PHP Bills");
        System.out.println("\t7) 200 PHP Bills");
        System.out.println("\t8) 500 PHP Bills");
        System.out.println("\t9) 1000 PHP Bills");
        System.out.println("\t10) Done");
        System.out.print("choose : ");
        int choice = InputCommands.ScanInt(1, 10);
        switch (choice) {
            case 1:
                System.out.print("How many 1 peso coin : ");
                vmMoney.setMoney(choice, InputCommands.ScanInt(0));
                break;
            case 2:
                System.out.print("How many 5 peso coin : ");
                vmMoney.setMoney(choice, InputCommands.ScanInt(0));
                break;
            case 3:
                System.out.print("How many 10 peso coin : ");
                vmMoney.setMoney(choice, InputCommands.ScanInt(0));
                break;
            case 4:
                System.out.print("How many 20 peso bill : ");
                vmMoney.setMoney(choice, InputCommands.ScanInt(0));
                break;
            case 5:
                System.out.print("How many 50 peso bill : ");
                vmMoney.setMoney(choice, InputCommands.ScanInt(0));
                break;
            case 6:
                System.out.print("How many 100 peso bill : ");
                vmMoney.setMoney(choice, InputCommands.ScanInt(0));
                break;
            case 7:
                System.out.print("How many 200 peso bill : ");
                vmMoney.setMoney(choice, InputCommands.ScanInt(0));
                break;
            case 8:
                System.out.print("How many 500 peso : ");
                vmMoney.setMoney(choice, InputCommands.ScanInt(0));
                break;
            case 9:
                System.out.print("How many 1,000 peso bill : ");
                vmMoney.setMoney(choice, InputCommands.ScanInt(0));
                break;
            case 10:
                break;
            default:
                putMoneyInVM(vmMoney);
                break;
        }
        return vmMoney;
    }

    /*
     * This method will be affected by the proposed refactor of the Money class.
     * Propose: Perform State refactoring (if statement) in displaying only the money denominations greater than zero.
     *  public static void displayMoney(Money money) {
            for (int i=0; i<9; i++){
                if (money.getPeso(i) > 0){
                    switch (i){
                        case 0 -> System.out.println("\t1) 1 PHP Coins    [" + money.getOnePeso() + "] : " + (money.getOnePeso()));
                        case 1 -> System.out.println("\t2) 5 PHP Coins    [" + money.getFivePeso() + "] : " + (money.getFivePeso() *5));
                        case 2 -> System.out.println("\t3) 10 PHP Coins   [" + money.getTenPeso() + "] : " + (money.getTenPeso() * 10));
                        case 3 -> System.out.println("\t4) 20 PHP Bills   [" + money.getTwentyPeso() + "] : " + (money.getTwentyPeso() * 20));
                        case 4 -> System.out.println("\t5) 50 PHP Bills   [" + money.getFiftyPeso() + "] : " + (money.getFiftyPeso() * 50));
                        case 5 -> System.out.println("\t6) 100 PHP Bills  [" + money.getOneHundredPeso() + "] : " + (money.getOneHundredPeso() * 100));
                        case 6 -> System.out.println("\t7) 200 PHP Bills  [" + money.getTwoHundredPeso() + "] : " + (money.getTwoHundredPeso() * 200));
                        case 7 -> System.out.println("\t8) 500 PHP Bills  [" + money.getFiveHudrendPeso() + "] : " + (money.getFiveHudrendPeso() * 500));
                        case 8 -> System.out.println("\t9) 1000 PHP Bills [" + money.getOneThousandPeso() + "] : " + (money.getOneThousandPeso() * 1000));
                    }
                }
            }
        }
     */
    
    /** This method will display the total computed money of each money denomination
     * @param money that contains information about the denominations and quantities of money in a vending machine.
     * */
    public static void displayMoney(Money money) {
        System.out.println(">> Total Money in Vending Machine <<");
        System.out.println("\t1) 1 PHP Coins    [" + money.getOnePeso() + "] : " + (money.getOnePeso()));
        System.out.println("\t2) 5 PHP Coins    [" + money.getFivePeso() + "] : " + (money.getFivePeso() *5));
        System.out.println("\t3) 10 PHP Coins   [" + money.getTenPeso() + "] : " + (money.getTenPeso() * 10));
        System.out.println("\t4) 20 PHP Bills   [" + money.getTwentyPeso() + "] : " + (money.getTwentyPeso() * 20));
        System.out.println("\t5) 50 PHP Bills   [" + money.getFiftyPeso() + "] : " + (money.getFiftyPeso() * 50));
        System.out.println("\t6) 100 PHP Bills  [" + money.getOneHundredPeso() + "] : " + (money.getOneHundredPeso() * 100));
        System.out.println("\t7) 200 PHP Bills  [" + money.getTwoHundredPeso() + "] : " + (money.getTwoHundredPeso() * 200));
        System.out.println("\t8) 500 PHP Bills  [" + money.getFiveHudrendPeso() + "] : " + (money.getFiveHudrendPeso() * 500));
        System.out.println("\t9) 1000 PHP Bills [" + money.getOneThousandPeso() + "] : " + (money.getOneThousandPeso() * 1000));
        System.out.println("\t= Total Money  \t\t  : " + money.totalMoney() + "\n");
    }

    /**
     * This method is passing a Money object, it can update or set the money denomination for the vending machine
     * @param money entered amount of the user
     */
    public void setVMDenomination(Money money) {
        this.vmMoneyDenomination = money;
    }
    /**
    * This method prompts to the user to select an item, displays item details, allows the user to purchase the item by providing payment, calculates and gives change, updates the vending machine's money balance, and keeps track of the transaction history.
    *@param vmMoney can access and manipulate the money information specific to the vending machine being operated.
     **/
    public void vmFeatures(Money vmMoney){
        int choice;
        System.out.println("Welcome! Select an Item you want to purchase :");
        while (filledSlots != 0){
            do {
                choice = selectSlot(filledSlots);
                if(choice != 11 && isSlotNull(choice-1))
                    System.out.println("This Slot is empty, please try again.");
            }while(choice != 11 && isSlotNull(choice-1));
            
            if (choice != 11){ //not Exit
                double userChoice;
                displayDetails(choice - 1);
                if (itemSlot[choice-1].getMainItem().getItemCount() <= 0){
                    System.out.println("No More Stock!\n");
                }
                else {
                    System.out.println("Would you like to buy this item ?\n\t1) Yes\n\t2) No");
                    System.out.print("choose : ");

                    if (InputCommands.ScanInt(1, 2) == 1){
                        double price = getItemDetails(choice - 1).getItemPrice(); //price of selected item
                        int temp = (int)price;
                        System.out.println("Item price : " + price);
                        System.out.print("Input payment : ");
                        int payment = InputCommands.ScanInt(0);

                        if(payment > price){ //payment is greater than price
                            userChoice = changeCalculator(payment, (int)price, vmMoney);
                            //will decrement the item value
                            itemSlot[choice-1].getMainItem().currentItemCount();
                            System.out.println("Your Change : " + (payment-price));
                            System.out.println("\nTransaction is Successfully Completed!\n");
                            Transactions receipt = new Transactions(price,getItemDetails(choice-1).getItemName(),payment,payment-price);
                            transactionList.add(receipt);
                            transactionIndex++;
                        }
                        else if(payment==price){
                            userChoice = changeCalculator(payment, (int)price, vmMoney);
                            //will decrement the item value
                            itemSlot[choice-1].getMainItem().currentItemCount();
                            System.out.println("\nYou have 0 change ");
                            System.out.println("Transaction is Successfully Completed!\n");
                            Transactions receipt = new Transactions(price,getItemDetails(choice-1).getItemName(),payment,0);
                            transactionList.add(receipt);
                            transactionIndex++;
                        }
                        else {
                            System.out.println("\nInsufficient funds, Try again.");
                            System.out.println("Transaction is Unsuccessful.");
                        }
                    }
                }
            }
            else
                break;
        }
    }

    /*
     * Propose: Helper class in the changeCalculator method to make it more readable and maintainable by utilizing arrays and loops.
     * 
     * private static double changeCalculator(int payment, int price, Money vmMoney) {
            int[] moneyArray = {1, 5, 10, 20, 50, 100, 200, 500, 1000};
            int temp = 0;

            for (int i = 8; i >= 0; i--) {
                if (price > moneyArray[i]) {
                    temp = price / moneyArray[i];
                    vmMoney.setMoney(i + 1, temp);
                    price = price - (temp * moneyArray[i]);

                    if (moneyArray[i] == 1) {
                        temp = price;
                        vmMoney.setMoney(1, temp);
                    }
                }
            }

            if (payment > price)
                return payment - price;
            else if (payment == price)
                return 0;

            return -1;
        }
     */
    /** This method calculates the change to be given to a customer after they make a payment for a given price.
     * @param payment amount of money payment given by the user
     * @param price amount of the item the user buys
     * @param vmMoney access and manipulate the money information specific to the vending machine being operated.
     * @return <code> depending on the given situation </code>
     **/
    private static double changeCalculator(int payment, int price, Money vmMoney){
        int temp;

        if(price/1000 > 0){
            temp = (price/1000);
            vmMoney.setMoney(9, temp);
            price = price-(temp*1000);
        }
       if(price/500 > 0) {
            temp = (price / 500);
            vmMoney.setMoney(8, temp);
            price = price-(temp*500);
        }
        if(price/200 > 0){
            temp = (price / 200);
            vmMoney.setMoney(7, temp);
            price = price-(temp*200);
        }
        if(price/100 > 0) {
            temp = (price / 100);
            vmMoney.setMoney(6, temp);
            price = price-(temp*100);
        }
        if(price/50 > 0) {
            temp = (price / 50);
            vmMoney.setMoney(5, temp);
            price = price-(temp*50);
        }
        if(price/20 > 0) {
            temp = (price / 20);
            vmMoney.setMoney(4, temp);
            price = price-(temp*20);
        }
        if(price/10 > 0) {
            temp = (price / 10);
            vmMoney.setMoney(3, temp);
            price = price-(temp*10);
        }
        if(price/5 > 0) {
            temp = (price / 5);
            vmMoney.setMoney(2, temp);
            price = price-(temp*5);
        }
        if(price > 0) {
            temp = (price);
            vmMoney.setMoney(1, temp);
        }
        if (payment > price)
            return payment - price;
        if (payment == price)
            return 0;

        return -1;
    }

    /**This method allows to read the value of vmMoneyDenomination for the current object.
     * @return this.vmMoneyDenomination;
     * */
    public Money getVendingMachineMoney(){
        return this.vmMoneyDenomination;
    }
   /** This method shows the availability of choice for maintenance feature
    * @param money access and manipulate the money information specific to the vending machine being operated.
     */
    public void maintenance(Money money){
        int choice, choice2;
        System.out.println("\nOptions to perform maintenance: ");
        System.out.println("\t1) Restock Slots/Quantity");
        System.out.println("\t2) Add Item");
        System.out.println("\t3) Change Item Prices");
        System.out.println("\t4) Collect Vending Machine Money");
        System.out.println("\t5) Add Vending Machine Money");
        System.out.println("\t6) Print Vending Machine Transactions");

        System.out.print("Enter Choice: ");
        choice = InputCommands.ScanInt(1,6);

        switch (choice){
            case 1 -> {
                do {
                    System.out.println("\t   >> LIST OF ITEMS <<\n===================================");
                    showItems();
                    do{
                        System.out.print("Enter Choice: ");
                        choice = InputCommands.ScanInt(1,11);
                    }while(choice != 11 && isSlotNull(choice-1));
                    if(choice != 11){
                        System.out.print("Enter How many Quantity will be Added: ");
                        choice2 = InputCommands.ScanInt(0); //gets new quantity
                        itemSlot[choice-1].getMainItem().addQuantity(choice2); //adds the entered new quantity to current

                        System.out.println("New total count " + getItemDetails(choice-1).getItemCount() + " of " + getItemDetails(choice-1).getItemName());
                        System.out.println("\nDo you want to add more?\n\t1) Yes\n\t2) No ");
                        System.out.print("Enter Choice: ");
                    }
                }while(InputCommands.ScanInt(1,2) == 1);
            }
            case 2 -> {
                do {
                    System.out.println("\t   >> LIST OF ITEMS <<\n===================================");
                    showItems();
                    do{
                        System.out.print("Enter Slot Choice: ");
                        choice = InputCommands.ScanInt(1,11);
                    }while(choice != 11 && !isSlotNull(choice-1));
                    if (choice!=11){
                        setItemInformation(choice-1);
                        System.out.println("Do you want to add more?\n1) Yes\n2) No ");
                        System.out.print("Enter Choice: ");
                        choice= InputCommands.ScanInt(1,2);
                    }
                }while(choice == 1);
            }
            case 3 -> {
                do {
                    System.out.println("\t   >> LIST OF ITEMS <<\n===================================");
                    showItems();
                    do{
                        System.out.print("Enter Slot Choice: ");
                        choice = InputCommands.ScanInt(1,11);
                    }while(choice != 11 && isSlotNull(choice-1));
                    if (choice != 11){
                        System.out.print("Enter New Price: ");
                        int price = InputCommands.ScanInt(0);
                        itemSlot[choice - 1].getMainItem().getItemPrice();
                        itemSlot[choice - 1].getMainItem().setItemPrice(price);
                        System.out.println("Do you want to change more?\n\t1) Yes\n\t2) No ");
                        System.out.print("Enter Choice: ");
                        choice = InputCommands.ScanInt(1, 2);
                    }
                }while(choice == 1);
            }
            case 4 -> {
                displayMoney(money);
                money = new Money();
                setVMDenomination(money);
            }
            case 5 -> {
                do{
                    setVMDenomination(putMoneyInVM(money));
                    System.out.println("\nDo you want to add more?\n1) Yes\n2) No ");
                    System.out.print("Enter Choice: ");
                }while(InputCommands.ScanInt(1,2) == 1);
            }
            case 6 ->{
                System.out.println("\nTransaction History: ");
                showTransaction();
            }
        }
    }
    /**This method shows the items that have been created or a slot that's empty
     **/
    public void showItems(){
        for (int i = 0; i < 10; i++){
            if (!isSlotNull(i))
                itemSlot[i].getMainItem().printAll(i);
            else
                System.out.println("[" + (i+1) + "] " + "Empty\n");
        }
        System.out.println("[11] " + "Exit");
    }
    /**This method shows the transaction made by the user in the vending machine
     **/
    private void showTransaction(){
        for (int i=0; i<transactionIndex; i++){
            System.out.println("[" + (i+1) + "]");
            transactionList.get(i).getTransactionDetails();
        }
    }
}
