/** ExpenseAccount
------------------------
requirements: ArrayList is accessible
end result: can be used to fill an ArrayList with Bills
other important info: none
 */
public class  ExpenseAccount extends ArrayList{
    /** no args constructor
    ------------------------
    requirements: ArrayList is accessible
    end result: creates object
    other important info: uses ArrayList
     */
    public ExpenseAccount(){
        super();
    }

    /** append
    ------------------------
    requirements: ArrayList is accessible and newBill is not null
    end result: inserts newBill into the end of the ArrayList
    other important info: none
     */
    public void append(Bill newBill){
        super.insert(newBill, super.size());
    }

    /** getTotal
    ------------------------
    requirements: none
    end result: returns the total cost of outstanding bills as a double
    other important info: none
     */ 
    public double getTotal()throws CloneNotSupportedException{
        double total = 0;
        for(int i = 0; i<super.size() ; i++){
            Bill currentBill = (Bill)super.get(i);
            if(!currentBill.isPaid()){
                total = total+currentBill.getAmount().getMoney();
            }
        }
        return total;
    }

    /** sortExpenses
    ------------------------
    requirements: none
    end result: sorts the Bills in the array by date, if the dates are equal it sorts by amount descending
    other important info: none
     */
    public void sortExpenses(){
        boolean sorted = false;
        ArrayList tempList = new ArrayList();
        //filling tempList
        for(int i = 0; i<super.size() ; i++){
            tempList.insert(get(i), 0);
        }
        Bill tempBill = null;
        //sorting tempList
        while(!sorted){
            sorted  = true;
            for(int i = 0; i<size()-1 ; i++){
                if(((Bill)tempList.get(i)).compareTo((Bill)tempList.get(i+1)) == 1){
                    //   System.out.println(tempList.toString());
                    //  System.out.println("\nSorting...");
                    tempBill = (Bill)tempList.get(i);
                    tempList.remove(i);
                    tempList.insert(tempBill,i+1);
                    sorted = false;
                    //   System.out.println(tempList.toString());
                }
            }
        }
        //System.out.println("Sorted");
        //  System.out.println(tempList.toString());
        //deleting everything in the "real" arrayList
        while(!super.isEmpty()){
            super.remove(0);
        }
        //copying everything from tempList to the "real" arraylist
        for(int i = 0; i<tempList.size() ; i++){
            super.insert(tempList.get(i),i);
        }
    }

    /** toString
    ------------------------
    requirements: none
    end result: returns a string of all the Bills in ExpenseAccount seperated by line breaks
    other important info:
     */
    public String toString(){
        String returnString = "";
        for(int i = 0; i<size() ; i++){
            returnString = returnString + get(i).toString()+"\n";
        }
        return returnString;
    }
    /** equals
    ------------------------
    requirements: none
    end result: returns true if they are equal, otherwise false
    other important info: none
     */
    public boolean equals(Object o){
        if(o instanceof ExpenseAccount){
            ExpenseAccount newO = (ExpenseAccount)o;
            if(this == null && o == null){
                return true;
            }
            for(int i = 0 ; i<super.size() ; i++){
                if(!this.get(i).equals(newO.get(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
}