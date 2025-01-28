/**The given class, Money handles all the money denomination of the machine and transaction to user
 * <p>
 * It consists of ff. attributes :
 * <ul>
 *     <li><STRONG>{@code moneyArray[]}</STRONG> - In where the types of money denomination are stored</li>
 * </ul>
 * @author Tolentino, Maxene Allison R.
 * @author Villagarcia, Wilbert Shawn G.
 * </p>
 * */

public class Money {
    private int []moneyArray = new int[9];

    /**This constructor will set the initial value of an moneyArray into zero*/
    public Money(){ //will set as the default value
        for (int i=0; i < 9; i++)
            moneyArray[i]=0;
    }
    /**This method sets the money of the vending Machine
     * @param index inputted type of money of the user
     * @param tally how many counts does the type of money chosen
     * */
    public void setMoney (int index, int tally){
        switch (index-1){
            case 0 : this.moneyArray[0] += tally; break;
            case 1 : this.moneyArray[1] += tally; break;
            case 2 : this.moneyArray[2] += tally; break;
            case 3 : this.moneyArray[3] += tally; break;
            case 4 : this.moneyArray[4] += tally; break;
            case 5 : this.moneyArray[5] += tally; break;
            case 6 : this.moneyArray[6] += tally; break;
            case 7 : this.moneyArray[7] += tally; break;
            case 8 : this.moneyArray[8] += tally; break;
        }
    }
    /**This method gets the amount of total money of the vending machine
     * @return <@code> computed total amount of money </@code>
     * */
    public double totalMoney(){
        return (moneyArray[0])+(moneyArray[1]*5)+(moneyArray[2]*10)+(moneyArray[3]*20)+(moneyArray[4]*50)+(moneyArray[5]*100)+(moneyArray[6]*200)+(moneyArray[7]*500)+(moneyArray[8]*1000);
    }

    /**
     * Propose: Refactor the code to make use of helper/utility methods instead of many getters that deal with the same array.
     */
     
    public int getPeso(int index){
        return moneyArray[index];
    }
     
    


    // /**This method gets the amount stored in array zero which is One peso
    //  * @return <@code> the current stored amount </@code>
    //  * */
    // public int getOnePeso(){
    //     return moneyArray[0];
    // }
    // /**This method gets the amount stored in array one which is Five peso
    //  * @return <@code> the current stored amount </@code>
    //  * */
    // public int getFivePeso(){
    //     return moneyArray[1];
    // }
    // /**This method gets the amount stored in array two which is Ten peso
    //  * @return <@code> the current stored amount </@code>
    //  **/
    // public int getTenPeso(){
    //     return moneyArray[2];
    // }
    // /**This method gets the amount stored in array three which is Twenty peso
    //  * @return <@code> the current stored amount </@code>
    //  **/
    // public int getTwentyPeso(){
    //     return moneyArray[3];
    // }
    // /**This method gets the amount stored in array four which is Fifty peso
    //  * @return <@code> the current stored amount </@code>
    //  **/
    // public int getFiftyPeso(){
    //     return moneyArray[4];
    // }
    // /**This method gets the amount stored in array five which is One Hundred peso
    //  * @return <@code> the current stored amount </@code>
    //  **/
    // public int getOneHundredPeso(){
    //     return moneyArray[5];
    // }
    // /**This method gets the amount stored in array six which is Two Hundred peso
    //  * @return <@code> the current stored amount </@code>
    //  **/
    // public int getTwoHundredPeso(){
    //     return moneyArray[6];
    // }
    // /**This method gets the amount stored in array seven which is Five Hundred peso
    //  * @return <@code> the current stored amount </@code>
    //  **/
    // public int getFiveHudrendPeso(){
    //     return moneyArray[7];
    // }
    // /**This method gets the amount stored in array eight which is One Thousand peso
    //  * @return <@code> the current stored amount </@code>
    //  **/
    // public int getOneThousandPeso(){
    //     return moneyArray[8];
    // }

}
