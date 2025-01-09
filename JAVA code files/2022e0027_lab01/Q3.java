//2022e027
import java.util.Scanner;

public class Q3 {


    public static int countShifts(int[] arr) {
        int shifts = 0;
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;


            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                shifts++;
            }
            arr[j + 1] = key;
        }

        return shifts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of test cases: ");
        int n = scanner.nextInt();


        int[][] arrays = new int[n][];
        for (int i = 0; i < n; i++) {
            System.out.print("Array length " + (i + 1) + ": ");
            int m = scanner.nextInt();
            arrays[i] = new int[m];

            System.out.print("Enter the numbers " + (i + 1) + ": ");
            for (int j = 0; j < m; j++) {
                arrays[i][j] = scanner.nextInt();
            }
        }


        for (int i = 0; i < n; i++) {
            int[] arr = arrays[i];


            System.out.print("Sorted array: ");
            for (int num : arr) {
                System.out.print(num + " ");
            }


            int shiftCount = countShifts(arr);
            System.out.println(": " + shiftCount);
        }

        scanner.close();
    }
}
