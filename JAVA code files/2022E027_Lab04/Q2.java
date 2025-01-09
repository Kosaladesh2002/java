import java.util.*;

public class Q2 {
    private static Map<String, Integer> inventory = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Sample Input");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "1":
                    String item1 = parts[1];
                    int quantity1 = Integer.parseInt(parts[2]);
                    inventory.put(item1, inventory.getOrDefault(item1, 0) + quantity1);
                    break;
                case "2":
                    String item2 = parts[1];
                    int quantity2 = Integer.parseInt(parts[2]);
                    if (inventory.containsKey(item2)) {
                        inventory.put(item2, quantity2);
                    } else {
                        System.out.println("Item not found");
                    }
                    break;
                case "3":
                    String item3 = parts[1];
                    if (inventory.containsKey(item3)) {
                        System.out.println(inventory.get(item3));
                    } else {
                        System.out.println(item3 + " is out of stock.");
                    }
                    break;
                case "4":
                    List<String> items = new ArrayList<>(inventory.keySet());
                    Collections.sort(items);
                    System.out.println("Sample Output");
                    for (String item : items) {
                        System.out.println(item + ": " + inventory.get(item));
                    }
                    break;
            }
        }

        sc.close();
    }
}
