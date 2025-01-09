import java.util.Scanner;
import java.util.ArrayList;

public class Q2 {


    public static void mergeSort(int[][] questions, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;


            mergeSort(questions, left, mid);
            mergeSort(questions, mid + 1, right);


            merge(questions, left, mid, right);
        }
    }

    private static void merge(int[][] questions, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[][] leftArray = new int[n1][2];
        int[][] rightArray = new int[n2][2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = questions[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = questions[mid + 1 + j];
        }


        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i][1] >= rightArray[j][1]) {
                questions[k] = leftArray[i];
                i++;
            } else {
                questions[k] = rightArray[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            questions[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            questions[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        int N = scanner.nextInt();
        int Q = scanner.nextInt();


        int[] T = new int[N];
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            S[i] = scanner.nextInt();
        }

        int[] queries = new int[Q];
        for (int i = 0; i < Q; i++) {
            queries[i] = scanner.nextInt();
        }

        int[][] questions = new int[N][2];
        for (int i = 0; i < N; i++) {
            questions[i][0] = T[i]; // Time
            questions[i][1] = S[i]; // Score
        }


        mergeSort(questions, 0, N - 1);


        int[] prefixTime = new int[N];
        prefixTime[0] = questions[0][0];
        for (int i = 1; i < N; i++) {
            prefixTime[i] = prefixTime[i - 1] + questions[i][0];
        }


        for (int k : queries) {
            System.out.println(prefixTime[k-1]);
        }

        scanner.close();
    }
}
