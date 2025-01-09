import java.util.Scanner;

public class Q3 {


    public static boolean binarySearch(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;


            if (array[mid] == x) {
                return true;
            }


            if (array[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("sample input 0:");


        int N = scanner.nextInt();
        int Q = scanner.nextInt();


        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        boolean[] results = new boolean[Q];


        for (int i = 0; i < Q; i++) {
            int X = scanner.nextInt();
            results[i] = binarySearch(A, X);
        }

        for (boolean result : results) {
            System.out.println(result);
        }

        scanner.close();
    }
}
