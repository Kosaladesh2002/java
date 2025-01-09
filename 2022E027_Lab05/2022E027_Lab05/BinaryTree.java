import java.util.Scanner;

class BinaryTree {

    
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

 
    Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    
    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

   
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

   
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        }
        return value < root.data ? searchRec(root.left, value) : searchRec(root.right, value);
    }

    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();

        
        System.out.println("Enter the values for the binary tree nodes:");
        int[] nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = scanner.nextInt();
        }

       
        for (int node : nodes) {
            tree.insert(node);
        }

        int choice, value;

        
        while (true) {
            System.out.println("\nBinary Tree Operations:");
            System.out.println("1. Inorder Traversal");
            System.out.println("2. Preorder Traversal");
            System.out.println("3. Postorder Traversal");
            System.out.println("4. Search Node");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Inorder Traversal: ");
                    tree.inorder();
                    break;

                case 2:
                    System.out.println("Preorder Traversal: ");
                    tree.preorder();
                    break;

                case 3:
                    System.out.println("Postorder Traversal: ");
                    tree.postorder();
                    break;

                case 4:
                    System.out.print("Enter value to search: ");
                    value = scanner.nextInt();
                    if (tree.search(value)) {
                        System.out.println(value + " found in the tree.");
                    } else {
                        System.out.println(value + " not found in the tree.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!.");
            }
        }
    }
}
