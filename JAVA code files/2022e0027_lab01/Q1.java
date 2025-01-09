import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter the length of the array (N): ");
        int n = scanner.nextInt();

        
        int[] numbers = new int[n];
        System.out.println("Enter the integers for the array:");

        
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

       
        System.out.print("Enter the target integer (x): ");
        int x = scanner.nextInt();

        
        boolean found = false;

       
        for (int num : numbers) {
            if (num == x) {
                found = true;
                break;
            }
        }

        // Display the result
        if (found) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        scanner.close();
    }
}
