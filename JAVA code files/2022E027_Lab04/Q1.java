import java.util.*;

class Order {
    int orderNumber;
    int finishTime;

    
    Order(int orderNumber, int finishTime) {
        this.orderNumber = orderNumber;
        this.finishTime = finishTime;
    }
}

public class Q1{

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

       
        int n = scanner.nextInt();

        
        List<Order> orders = new ArrayList<>();

        
        for (int i = 1; i <= n; i++) {
            int ti = scanner.nextInt();
            int di = scanner.nextInt();
            int finishTime = ti + di;
            orders.add(new Order(i, finishTime));
        }

      
        orders.sort((a, b) -> {
            if (a.finishTime == b.finishTime) {
                return Integer.compare(a.orderNumber, b.orderNumber);
            }
            return Integer.compare(a.finishTime, b.finishTime);
        });

       System.out.println("Sample Output");
        for (Order order : orders) {
            System.out.print(order.orderNumber + " ");
        }

       
        scanner.close();
    }
}
