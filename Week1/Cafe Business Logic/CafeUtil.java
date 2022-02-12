import java.text.DecimalFormat;
import java.util.ArrayList;

public class CafeUtil {
    
    //write a method that sums together every consecutive integer from 1 to 10 and returns the sum
    public int getStreakGoal() {
        
        int numWeeks = 10;
        int sum = 0;

        for ( int i = 1;i <= numWeeks; i++) {
            sum +=i;
        }

        return sum;
    }

    //Given an array of item prices from an order, sum all of the prices in the array and return the total
    public double getOrderTotal(double[] prices) {
        
        double sum = 0;

        for ( int i = 0;i < prices.length; i++) {
            sum +=prices[i];
        }

        return sum;
    }

    //Given an ArrayList of menu items (strings), print out each index and menu item.
    public void displayMenu(ArrayList<String> menuItems) {
        
        for ( int i = 0;i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i) );
        }
    }

    //
    public void addCustomer(ArrayList<String> customers) {
        
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        System.out.println("There are " + customers.size() + " people in front of you");
        customers.add(userName);
        System.out.println(customers);
    }

    //Given a product, price and a maxQuantity, create a method that prints the cost
    //Format the prices as currency.
    //Take $0.50 more off of the original price every time the quantity increases
    public void printPriceChart(String product, double price, int maxQuantity) {

        double cost = 0;
        double discount = 0;
        int count = 0;
        String fCost = new String();
        System.out.println(product);
        for (int i = 0; i < maxQuantity; i++) {
            count = i + 1;
            discount = i * 0.5;
            cost = (price * count) - discount;
            fCost = money(cost);
            System.out.println(count + " " + fCost);
        }


    }

    public String money(double value ) {
        DecimalFormat myFormatter = new DecimalFormat("$###.00");
        String output = myFormatter.format(value);
        return output;
    }

    //Given 2 arrays, an ArrayList of menu items (strings), and an ArrayList of prices (doubles) print a menu!
    //first check:  if the arrays are not the same size, immediately return false.
    //print the menu on the same line: The index, The menu item at that index, and The price at that index. then return true.
    boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        if ( menuItems.size() != prices.size() ) {
            return false;
        }
        String fPrice = new String();
        for(int i = 0; i < menuItems.size(); i++) {
            fPrice = money(prices.get(i));
            System.out.println(i + " " + menuItems.get(i) + " " + fPrice);
        }
        return true;
    }

    //Make a method addCustomers where a barista can enter multiple customers
    public void addCustomers() {
        boolean loop = true;
        String customer = new String();
        ArrayList<String> customers = new ArrayList<String>();

        while ( loop ) {
            System.out.println("Please enter your name or q if you have finished:");
            customer = System.console().readLine();
            if ( customer.equals("q") ) {
                loop = false;
            } else {
                System.out.println("Hello, " + customer);
                System.out.println("There are " + customers.size() + " people in front of " + customer);
                customers.add(customer);
                System.out.println(customers);
            }
        }
    }
}
