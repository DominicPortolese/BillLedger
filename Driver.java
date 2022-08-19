/** Driver
------------------------
requirements: All relevant classes are accessible
end result: tests ExpenseAccount
other important info: none
 */
public class Driver{
    public static  void main(String[] args)throws CloneNotSupportedException{
        //    System.out.println("Hi");
        Money money1 = new Money(420, 69);
        Money money2 = new Money(20,32);
        Date date1 = new Date(3,28,2021);
        Date date2 = new Date(7,13, 2022);

        Money badMoney = new Money(-9,0);
        Date badDate = new Date(50,51,52);

        Bill bill1 = new Bill(money1, date1, "Robinhood");
        Bill bill2 = new Bill(money2, date2, "Spotify");
        Bill bill3 = new Bill(money1, date2, "Safeway");
        Bill bill4 = new Bill(money2, date1, "Amazon");
        Bill badBill = new Bill(badMoney,badDate, "bitCoin");

        ExpenseAccount expenses = new ExpenseAccount();

        expenses.append(bill1);
        expenses.append(bill2);
        expenses.append(bill3);
        expenses.append(bill4);
        expenses.append(badBill);

        ((Bill)(expenses.get(expenses.indexOfObject(bill2)))).setPaid(date1);

        //  System.out.println(money1.compareTo(money2));

        //  System.out.println("INDEX: "+expenses.indexOfObject(bill2));

        //   Bill toPay = (Bill)(expenses.get(expenses.indexOfObject(bill1)));
        //    toPay.setPaid(date2);

        //  expenses.append(new Bill(money1, date1, "Spotify"));

        expenses.sortExpenses();
        // System.out.println("\nBack into the driver, after sort before print\n");
        System.out.println(  expenses.toString());
        System.out.println("Total Due: $"+expenses.getTotal());
    }
}