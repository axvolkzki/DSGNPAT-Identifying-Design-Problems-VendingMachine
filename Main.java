import java.util.ArrayList;
/**This class will be the driver for the codes and classes to run and perform the vending machine
 * @author Tolentino, Maxene Allison R.
 * @author Villagarcia, Wilbert Shawn G.
 * */
public class Main {
    public static void main(String[] args) {
        startProgram();
    }
    /**This method is where all the instantiation of vending machine object
     * */
    public static void startProgram() {
        ArrayList<RegularVM> cvm = new ArrayList<>();
        ArrayList <Money> finance = new ArrayList<>();
        int i=0;
        while (true){
            RegularVM vm = new RegularVM();
            Money money = new Money();
            switch (mainOption()) {
                case 1 -> {
                    createVM(vm, money);
                    cvm.add(vm);
                    finance.add(money);
                    i++;
                }
                case 2 -> {
                    if (i <= 0)
                        System.out.println("\nNo existing Vending Machine.\nVending Machine Testing cannot be performed.\nRedirecting back to Main Menu...\n");
                    else
                        testVM(cvm.get(i-1), finance.get(i-1));
                }
                case 3 -> {
                    System.out.println("Program Terminated...");
                    InputCommands.ScanClose();
                    return;
                }
            }
        }
    }
    /**This method will display the available choices can do in this vending machine program
     * @return <code>input choice of the user</code>
     * */
    public static int mainOption() {
        System.out.println("\nWhat type of Vending Machine\n==========================");
        System.out.println("[1] Create Vending Machine");
        System.out.println("[2] Test Vending Machine");
        System.out.println("[3] Exit");
        System.out.print("choose : ");
        return InputCommands.ScanInt(1, 3); //choice
    }
    /**This method is used to create a vending machine based on user choices. It prompts the user to select a vending machine type, and depending on the choice,
     * @param vm to have access to RegularVM class
     * @param money
     * */
    public static RegularVM createVM(RegularVM vm, Money money) {
        switch (createVMChoices()) {
            // Pass the RegularVM object to createRVM()
            case 1: vm.createRVM(money); break;
            case 2: System.out.println("Sorry, Special Vending Machine is still not available"); break;
            case 3 : break;
        }
        return vm;
    }
    /**This method will display the available choices for Create Vending Machine Option
     * @return <code>input choice of the user</code>
     * */
    public static int createVMChoices() {
        System.out.println("\n       What to Create\n==========================");
        System.out.println("[1] Regular Vending Machine");
        System.out.println("[2] Special Vending Machine");
        System.out.print("choose : ");
        return InputCommands.ScanInt(1, 3); //choice
    }
    /**This method is used in testing the created vending machine based on user choices. It prompts the user to select a vending machine type, and depending on the choice,
     * @param vm to have access to RegularVM class
     * @param money
     * */
    public static void testVM(RegularVM vm, Money money){
        if (vm.isEmpty()) // Vending Machine is Empty
                System.out.println("\nNo existing Vending Machine.\nVending Machine Testing cannot be performed.\nRedirecting back to Main Menu...\n");
        else{
            switch (testVMChoices()) {
                case 1 -> vm.vmFeatures(money);
                case 2 -> vm.maintenance(money);
            }
        }
    }
    /**This method will display the available choices for Test Vending Machine Option
     * @return <code>input choice of the user</code>
     * */
    public static int testVMChoices (){
        System.out.println("\n       What to Test\n==========================");
        System.out.println("[1] Test Vending Machine Features");
        System.out.println("[2] Perform Vending Machine Maintenance");
        System.out.println("[3] Exit");
        System.out.print("choose : ");
        return InputCommands.ScanInt(1, 3); //choice
    }
}
