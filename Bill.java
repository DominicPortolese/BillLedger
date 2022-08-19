import java.io.Serializable;
/** Bill
------------------------
requirements: none
end result: creates an object with an amount object, two date objects, and a String object
other important info: used by Bill
 */
public class Bill implements Comparable, Cloneable, Serializable{
    private Money amount= null;
    private Date dueDate = null;
    private Date paidDate = null;
    private String originator = "";
    /** clone
    ------------------------
    requirements: none
    end result: returns clone of existing object
    other important info: can throw error
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * METHOD: compareTo
     * Result: sorts by duedate, if the due dates are the same it sorts by amount. returns -2 if uncomparable or clone error
     */
    @Override
    public int compareTo(Object that){
        try{
            if(that instanceof Bill){
                Bill newThat = (Bill)(that);
                if(dueDate.compareTo(newThat.getDueDate()) == -2){
                    return -2; //uncomparable
                }
                else if(dueDate.compareTo(newThat.getDueDate()) == -1){
                    return -1; // this comes first
                }
                else if(dueDate.compareTo(newThat.getDueDate()) == 0){
                    return(amount.compareTo(newThat.getAmount())); // Bills have the same date so it is decided by amount
                }
                else if(dueDate.compareTo(newThat.getDueDate()) == 1){
                    return 1; // that comes first
                }
            }
            return -2; //uncomparable
        }catch(Exception e){
            System.out.println(e.getMessage());
            return -2; //clone error
        }
    }

    /** args constructor
    ------------------------
    requirements: args are not null
    end result: fills out Bill's instance variables
    other important info: can throw exception
     */
    public Bill(Money newAmount, Date newDueDate, String newOriginator)throws CloneNotSupportedException{
        //use of the new keyword prevents privacy leaks
        /*
        this.amount = new Money(newAmount);
        this.dueDate = new Date(newDueDate);
        this.originator = new String(newOriginator);
         */

        this.amount = (Money)newAmount.clone();
        this.dueDate = (Date)newDueDate.clone();
        this.originator = newOriginator;
    }

    /** copy constructor
    ------------------------
    requirements: toCopy isnt null
    end result: creates copy of bill
    other important info: is not used in the MoneyV2 version of this assignment
     */
    public Bill(Bill toCopy)throws CloneNotSupportedException{
        /*  this.amount = new Money(toCopy.getAmount());

        this.dueDate = new Date(toCopy.getDueDate());

        this.paidDate = new Date(toCopy.getPaidDate());

        this.originator = new String(toCopy.getOriginator());
         */
        this.amount = (Money)toCopy.getAmount().clone();
        this.dueDate = (Date)toCopy.getDueDate().clone();
        this.paidDate = (Date)toCopy.getPaidDate().clone();
        this.originator = toCopy.getOriginator();
        if(!toCopy.isPaid()){
            setUnpaid();
        }
    }

    /** getDueDate
    ------------------------
    requirements: none
    end result:returns a clone of the dueDate
    other important info: none
     */ 
    public Date getDueDate()throws CloneNotSupportedException{
        // Date temp = new Date(this.dueDate);

        return (Date)this.dueDate.clone();

    }

    /** getOriginator
    ------------------------
    requirements: none
    end result: returns the originator
    other important info: none
     */
    public String getOriginator(){
        return this.originator;
    }

    /** isPaid
    ------------------------
    requirements: none
    end result: returns true if the bill is paid, otherwise false
    other important info: none
     */
    public boolean isPaid(){
        if(this.paidDate == null){
            return false;
        }
        return true;
    }

    /** setPaid
    ------------------------
    requirements: onDay is not null
    end result: sets paid equal to onDay if onDay is before paid
    other important info: none
     */
    public void setPaid(Date onDay)throws CloneNotSupportedException{
        // Date currentDate = new Date(onDay);
        /* Date currentDate = (Date)onDay.clone();
        if(this.dueDate.getYear() >= currentDate.getYear() && this.dueDate.getMonth() >= currentDate.getMonth() && this.dueDate.getDay() >= this.dueDate.getDay()){
        paidDate = new Date(currentDate);
        System.out.println("Paid");
        }
        else{
        System.out.println("Too late to be paid");
        }*/
        //    System.out.println("compareTo: "+this.dueDate.compareTo(onDay));
        if(this.dueDate.compareTo(onDay) == 1 || this.dueDate.compareTo(onDay) == 0 ){
            paidDate = (Date)onDay.clone();
        }
        else{
            System.out.println("Too late to be paid");
        }
    }

    /** setUnpaid
    ------------------------
    requirements: none
    end result: makes paidDate null, effectively making it unpaid
    other important info: none
     */
    public void setUnpaid(){
        this.paidDate = null;
    }

    /** setDueDate
    ------------------------
    requirements: nextDate is a valid date
    end result: sets Duedate if its valid
    other important info: none
     */
    public void setDueDate(Date nextDate)throws CloneNotSupportedException{

        if(!isPaid()){
            if(dueDate.getYear() <= nextDate.getYear()){
                if(dueDate.getYear() == nextDate.getYear()){
                    if(dueDate.getMonth() <= nextDate.getMonth()){
                        if(dueDate.getMonth() == nextDate.getMonth()){
                            if(dueDate.getDay() <= nextDate.getDay()){
                                // this.dueDate = new Date(nextDate);
                                this.dueDate = (Date)nextDate.clone();
                            }
                            System.out.println("Cannot set due date before current due date");
                        }
                        else{
                            // this.dueDate = new Date(nextDate);
                            this.dueDate = (Date)nextDate.clone();
                        }
                    }
                    System.out.println("Cannot set due date before current due date");
                }
                else{
                    // this.dueDate = new Date(nextDate);
                    this.dueDate = (Date)nextDate.clone();
                }

            }
            System.out.println("Cannot set due date before current due date");
        }
        else{
            System.out.println("Cannot set due date when bill is already paid");
        }

    }

    /** setAmount
    ------------------------
    requirements: amount isnt null
    end result: sets a clone  of amount as amount
    other important info: none
     */ 
    public void setAmount(Money amount)throws CloneNotSupportedException{
        if(!isPaid()){
            //  this.amount = new Money(amount);
            this.amount = (Money)amount.clone();
        }
    }

    /** getPaidDate
    ------------------------
    requirements: none
    end result: returns clone of paidDate or null
    other important info: can throw exception
     */
    public Date getPaidDate()throws CloneNotSupportedException{

        if(this.paidDate == null){
            return null;
        }
        // return new Date(this.paidDate);
        return (Date)this.paidDate.clone();
    }

    /** getAmount
    ------------------------
    requirements: non
    end result:
    other important info:
     */
    public Money getAmount()throws CloneNotSupportedException{
        // Money returnAmount = new Money(this.amount);

        // return returnAmount;

        return (Money)this.amount.clone();
    }

    public void setOriginator(String newOriginator){
        this.originator = newOriginator;
    }

    @Override
    public String toString(){
        String buildString = ""+this.amount+" due "+this.dueDate.toString()+" to "+originator;
        if(isPaid()){
            buildString = buildString+" has been paid.";
        }
        else{
            buildString = buildString+" has not been paid.";
        }
        return buildString;
    }

    public boolean equals(Object that){
        if(that instanceof Bill){
            Bill newThat = (Bill)that;
        if(this.amount.equals(newThat.amount) && this.dueDate.equals(newThat.dueDate) && this.originator.equals(newThat.originator)){
            if((this.paidDate == null && newThat.paidDate == null) || (this.paidDate != null && newThat.paidDate != null)){
                return true;
            }
        }
        return false;
    }
    return false;
    }
}
