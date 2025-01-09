public class Q2 {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int swapCount = 0;

        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapCount++;
                }
            }
        }

        
        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        
        System.out.println("Total number of swaps: " + swapCount);

      
        System.out.println("First element: " + arr[0]);

        
        System.out.println("Last element: " + arr[n - 1]);
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(array);
    }
}
