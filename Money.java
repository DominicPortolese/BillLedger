import java.io.Serializable;
/** Money
------------------------
requirements: none
end result: creates a Money object that stores dollars and cents
other important info: used in the Bill class
 */
public class Money implements Comparable, Cloneable, Serializable{
    private int dollars = 0;
    private int cents = 0;
    /** clone
    ------------------------
    requirements: none
    end result: returns clone of object
    other important info: can throw error
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * METHOD: compareTo
     * Requirements: that is a Money object 
     * Result: sorts in descending order in contrast to how most compareTos work. It just makes more sense this way in my opinion because its about money
     * 0 if they are equal, -1 if this is more than that, 1 if this is less than that
     */
    public int compareTo(Object that){

        if(that instanceof Money){
            Money newThat = (Money)(that);
            if(this.dollars >= newThat.getDollars()){
                if(this.dollars == newThat.getDollars()){
                    if(this.cents >= newThat.getCents()){
                        if(this.cents == newThat.getCents()){
                            return 0; //equal
                        }
                        return -1; //this is smaller
                    }
                    return 1; //that is smaller
                }
                return -1; //this is smaller
            }
            return 1; //that is smaller
        }
        return -2; //incomparable (could be null)
    }

    /** args constructor
    ------------------------
    requirements: dol is positive
    end result: sets dol and cent
    other important info: uses setDollars and setCents
     */
    public Money(int dol){
        setDollars(dol);
        setCents(0);
    }

    /** args constructor
    ------------------------
    requirements: dol and cent are positive
    end result: sets money and dollars
    other important info: none
     */
    public Money(int dol, int cent){
        setDollars(dol);
        setCents(cent);
    }

    /** copy constructor
    ------------------------
    requirements: other is not null
    end result: sets dollars and cents
    other important info: none
     */
    Money(Money other){
        setDollars(other.dollars);
        setCents(other.cents);
    }

    /** getMoney()
    ------------------------
    requirements:none
    end result: returns dollars and cents as one combined double type
    other important info: none
     */
    public double getMoney(){
        double doubleCents = this.cents;

        double returnMoney = 0+this.dollars+(doubleCents/100);
        return returnMoney;
    }

    /** getDollars
    ------------------------
    requirements: none
    end result: returns dollars
    other important info: none
     */
    public double getDollars(){
        return this.dollars;
    }

    /** getCents
    ------------------------
    requirements:  none
    end result:returns cents
    other important info: none
     */
    public double getCents(){
        return this.cents;
    }

    /** setMoney
    ------------------------
    requirements: none
    end result: sets dollars and cents
    other important info: uses set Dollars and setCents
     */
    public void setMoney(int dol, int cent){
        setDollars(dol);
        setCents(cent);
    }

    /** setDollars
    ------------------------
    requirements: int dol is a positive whole number
    end result: sets dollars equal to dol, or sends an error
    other important info: none
     */
    private void setDollars(int dol){
        try{
            if(dol>=0){
                this.dollars = dol;

            }
            else{
                throw new Exception("Unacceptable dollar amount recieved. No change has been made to the dollar amount");

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** setCents()
    ------------------------
    requirements: cent is between 0-99
    end result: sets cents or sends error
    other important info: used by add()
     */
    private void setCents(int cent){

        try{
            if(cent>=0 && cent<= 99){
                this.cents = cent;

            }

            else{

                throw new Exception("Unacceptable cent amount recieved. No change has been made to the cent amount");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** add
    ------------------------
    requirements: dol is positive
    end result: adds dol to dollars
    other important info: used by the other add()
     */
    public void add(int dol){
        try{
            if(dol>=0){
                setDollars(dol+this.dollars);
            }
            else{
                throw new Exception("Unacceptable dollar amount recieved. No change has been made to the dollar amount");  
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** add
    ------------------------
    requirements: cent is positive
    end result: adds the appropriate amount of dollars to add(), sets the appropriate amount of cents with setcents
    other important info:
     */
    public void add(int dol, int cent){
        add(dol);
        try{
            if(cent>=0 && cent<= 99){
                setCents(cent+this.cents);

            }
            else if(cent>99){
                //For every 100 cents, a dollar is added to the total and 100 cents are deducted
                int extraDollars = cent/100;
                add(extraDollars);
                setCents((cent%100)+this.cents);

            }
            else{

                throw new Exception("Unacceptable cent amount recieved. No change has been made to the cent amount");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** add
    ------------------------
    requirements: cent is positive
    end result: adds the appropriate amount of dollars to add(), sets the appropriate amount of cents with setcents
    other important info:
     */
    public void add(Money newMoney){
        add((int)(newMoney.getDollars()));
        try{
            if(newMoney.getCents()>=0 && newMoney.getCents()<= 99){
                setCents((int)(newMoney.getCents()+this.cents));

            }
            else if(newMoney.getCents()>99){
                //For every 100 cents, a dollar is added to the total and 100 cents are deducted
                int extraDollars = (int)(newMoney.getCents()/100);
                add(extraDollars);
                setCents((int)((newMoney.getCents()%100)+this.cents));

            }
            else{

                throw new Exception("Unacceptable cent amount recieved. No change has been made to the cent amount");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /** equals
    ------------------------
    requirements: none
    end result: returns true if it matches, false otherwise
    other important info: none
     */ 
    public boolean equals(Object o){

        if(o instanceof Money){
            Money newO = (Money)o;
            if(this == null && o == null){
                return true;
            }
            if(this.dollars == newO.getDollars() && this.cents == newO.getCents()){
                return true;
            }
        }

        return false;
    }

    /** toString
    ------------------------
    requirements: none
    end result: returns string of the object
    other important info: none
     */
    @Override
    public String toString(){
        return "$"+this.getMoney();
    }
}