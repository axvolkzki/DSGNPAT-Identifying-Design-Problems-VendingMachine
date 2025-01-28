public class Helper {

    // Method to scan user input for a specific denomination
    public static int scanDenominationCount(String description) {
        System.out.printf("How many %s: ", description);
        return InputCommands.ScanInt(0);
    }

    // Method to update the money in the vending machine
    public static void updateMoney(Money vmMoney, Denomination denomination, int count) {
        vmMoney.setMoney(denomination.ordinal() + 1, count); 
    }

    // Utility method to display all denominations
    public static void displayDenominations() {
        System.out.println("\nAvailable Money Denominations:");
        int i = 1;
        for (Denomination denomination : Denomination.values()) {
            System.out.printf("\t%d) %s%n", i++, denomination.getDescription());
        }
        
    }
}

