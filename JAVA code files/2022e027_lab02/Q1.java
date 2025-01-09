import java.util.Scanner;

import static java.io.ObjectInputFilter.merge;

public class Q1 {
    public static void mergesort(int[] inputArray) {
        int inputlength = inputArray.length;

        if (inputlength < 2) {
            return;
        }
        int midIndex = inputlength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputlength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int j = midIndex; j < inputlength; j++) {
            rightHalf[j-midIndex] = inputArray[j];

        }
        mergesort(leftHalf);
        mergesort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);

    }
public static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf){
        int i =0, j=0,k=0;
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        while(i<leftSize && j<rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
            while(i<leftSize) {
                inputArray[k] = leftHalf[i];
                i++;
                k++;
            }
            while(j<rightSize) {
                inputArray[k] = rightHalf[j];
                j++;
                k++;





        }
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sample input: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int k = 0; k < size; k++) {
            arr[k] = scanner.nextInt();

        }
        mergesort(arr);
        System.out.println("Sample Output");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}