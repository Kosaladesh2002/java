import java.util.*;

class BST {
    // Node definition
    class Node {
        String word;
        Node left, right;

        public Node(String word) {
            this.word = word;
            this.left = this.right = null;
        }
    }

    private Node root;

    public BST() {
        root = null;
    }

    public void insert(String word) {
        root = insertRec(root, word);
    }

    private Node insertRec(Node root, String word) {
        if (root == null) {
            root = new Node(word);
            return root;
        }
        if (word.compareTo(root.word) < 0) {
            root.left = insertRec(root.left, word);
        } else if (word.compareTo(root.word) > 0) {
            root.right = insertRec(root.right, word);
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.word + " ");
            inorderRec(root.right);
        }
    }

    public String[] autocomplete(String prefix) {
        List<String> result = new ArrayList<>();
        autocompleteRec(root, prefix.toLowerCase(), result);
        return result.toArray(new String[0]);
    }

    private void autocompleteRec(Node root, String prefix, List<String> result) {
        if (root == null) {
            return;
        }

        if (root.word.toLowerCase().startsWith(prefix)) {
            result.add(root.word);
        }

        if (root.word.compareToIgnoreCase(prefix) > 0) {
            autocompleteRec(root.left, prefix, result);
        }

        if (root.word.compareToIgnoreCase(prefix) <= 0 || root.word.toLowerCase().startsWith(prefix)) {
            autocompleteRec(root.right, prefix, result);
        }
    }

    public void delete(String word) {
        root = deleteRec(root, word);
    }

    private Node deleteRec(Node root, String word) {
        if (root == null) {
            return root;  
        }

        
        if (word.compareTo(root.word) < 0) {
            root.left = deleteRec(root.left, word); 
			
        } else if (word.compareTo(root.word) > 0) {
            root.right = deleteRec(root.right, word);  
        } else {
			
            

            // Case 1: 
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: 
            if (root.left == null) {
                return root.right;  
            } else if (root.right == null) {
                return root.left;  
            }

            // Case 3:
           
            root.word = minValue(root.right);

            
            root.right = deleteRec(root.right, root.word);
        }

        return root;
    }

   
    private String minValue(Node root) {
        String minValue = root.word;
        while (root.left != null) {
            minValue = root.left.word;
            root = root.left;
        }
        return minValue;
    }
}

public class BST027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST tree = new BST();

        String[] words = {"apple", "banana", "grape", "mango", "peach", "pear", 
                          "pineapple", "melon", "plum", "orange"};
        
        
        for (String word : words) {
            tree.insert(word);
        }

        while (true) {
            // Menu 
            System.out.println("\nSelect an option:");
            System.out.println("1. In-order traversal");
            System.out.println("2. Autocomplete for a prefix");
            System.out.println("3. Add new word(s)");
            System.out.println("4. Delete a word");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // In-order traversal of the BST
                    System.out.println("\nIn-order traversal of the BST:");
                    tree.inorder();
                    System.out.println();
                    break;

                case 2:
                    // Autocomplete 
                    System.out.print("\nEnter a prefix for autocomplete: ");
                    String prefix = scanner.nextLine();
                    String[] suggestions = tree.autocomplete(prefix);
                    System.out.println("Autocomplete suggestions for '" + prefix + "':");
                    System.out.println(Arrays.toString(suggestions));
                    break;

                case 3:
                    // Add new 
                    System.out.print("\nEnter new word(s) to add to the BST (comma-separated): ");
                    String wordsToAdd = scanner.nextLine();
                    String[] newWords = wordsToAdd.split(",");
                    for (String word : newWords) {
                        tree.insert(word.trim());  // Add each new word
                    }
                    System.out.println("New words added.");
                    break;

                case 4:
                    // Delete 
                    System.out.print("\nEnter a word to delete from the BST: ");
                    String wordToDelete = scanner.nextLine();
                    tree.delete(wordToDelete);
                    System.out.println("Word deleted.");
                    break;

                case 5:
                    // Exit 
                    System.out.println("\nExiting...");
                    scanner.close();
                    return;

                default:
                    // Invalid 
                    System.out.println("\nInvalid option. Please try again.");
            }
        }
    }
}
