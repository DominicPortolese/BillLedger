import java.io.Serializable;
/** Date
------------------------
requirements: none
end result: creates an object that stores ints describing day, month, and year
other important info: used by Bill
 */
public class Date implements Comparable, Cloneable, Serializable{
    private int day = 0;
    private int month = 0;
    private int year = 0;
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * METHOD: compareTo
     * Requires that to be  a Money object
     * Result: helps sort by date, returns -2 for uncomparable, -1 if that is first, 0 if equal, and 1 if this is first
     */
    public int compareTo(Object that){
        if(that instanceof Date){
            Date newThat = (Date)(that);
            if(year <= newThat.getYear()){
                if(year == newThat.getYear()){
                    if(month <= newThat.getMonth()){
                        if(month == newThat.getMonth()){
                            if(day <= newThat.getDay()){
                                if(day == newThat.getDay()){
                                    return 0; //equal
                                }
                                return -1; // this is first
                            }
                            return 1; //that is first
                        }
                        else{
                            return -1; //this is first
                        }
                    }
                    return 1; //that is first
                }
                else{
                    return -1; //this is first
                }
            }
            return 1; //that is first
        }
        return -2; //incomparable
    }

    public static void main(String[] args){
        Date date1 = new Date(1,15,2021);
        //   date1.printDate();
    }

    public Date(){
        setDay(1);
        setMonth(1);
        setYear(2000);
    }

    public Date(int newMonth, int newDay, int newYear){

        setDay(newDay);
        setMonth(newMonth);
        setYear(newYear);
    }

    public Date(Date other){

        if(other != null){

            setDay(other.getDay());
            setMonth(other.getMonth());
            setYear(other.getYear());

        }
    }

    public void  setDate(int newMonth, int newDay, int newYear){
        setDay(newDay);
        setMonth(newMonth);
        setYear(newYear);
    }

    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){

        return this.year;
    }

    /** setDay
    ------------------------
    requirements: day is between 1-31
    end result: sets day
    other important info: none
     */
    public void setDay(int newDay){
        try{

            if(newDay>0 && newDay<32){
                this.day = newDay;
            }
            else{
                throw new Exception("Unacceptable day value recieved, "+newDay);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    /** setMonth
    ------------------------
    requirements: month is between 1-12
    end result: sets month or spits error
    other important info: none
     */
    public void setMonth(int newMonth){
        try{
            if(newMonth>0 && newMonth < 13){
                this.month = newMonth;
            }
            else{
                throw new Exception("Unacceptable month value recieved, "+newMonth);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    /** setYear
    ------------------------
    requirements: year is between 2014-2024
    end result: year is set or it throws error
    other important info: none
     */
    public void setYear(int newYear){
        try{

            if(newYear>=2014 && newYear<=2024){
                this.year = newYear;
            }
            else{
                throw new Exception("Unacceptable year value recieved, "+newYear);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    /** toString
    ------------------------
    requirements: none
    end result: returns the date or INVALID if any of the variables have not been set
    other important info: none
     */
    @Override
    public String toString(){
        if(month == 0 || day == 0 || year == 0){
            return "INVALID";
        }
        return month+"/"+day+"/"+year;

    }

    /** equals
    ------------------------
    requirements: none
    end result: returns true if they are equal, false otherwise
    other important info: none
     */
    public boolean equals(Object o){

        if(o instanceof Date){
            Date newO = (Date)o;
            if(this == null && o == null){
                return true;
            }
            if(this.day == newO.day && this.month == newO.month && this.year == newO.year){
                return true;
            }
        }
        return false;
    }
}