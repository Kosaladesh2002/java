import java.util.Scanner;

public class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }


    public void insert(int data) {
        root = insertRec(root, data);
    }


    public void insertFromArray(int[] data) {
        for (int value : data) {
            insert(value);
        }
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }


    public void InorderTraversal() {
        InorderTraversalRec(root);
        System.out.println();
    }

    private void InorderTraversalRec(Node root) {
        if (root != null) {
            InorderTraversalRec(root.left);
            System.out.print(root.data + " ");
            InorderTraversalRec(root.right);
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


    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        return key < root.data ? searchRec(root.left, key) : searchRec(root.right, key);
    }


    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(heightRec(root.left), heightRec(root.right));
    }
    
    public int countLeafNodes() {
        return countLeafNodesRec(root);
    }

    private int countLeafNodesRec(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return countLeafNodesRec(root.left) + countLeafNodesRec(root.right);
    }


    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null)
            return null;

        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            root.data = findMin(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int findMin(Node root) {
        int min = root.data;
        while (root.left != null) {
            root = root.left;
            min = root.data;
        }
        return min;
    }

 
    public void printTree() {
        printTreeRec(root, 0);
    }

    private void printTreeRec(Node root, int space) {
        if (root == null)
            return;

        space += 5;
        printTreeRec(root.right, space);
        System.out.println();
        for (int i = 5; i < space; i++)
            System.out.print(" ");
        System.out.println(root.data);
        printTreeRec(root.left, space);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        while (true) {
            System.out.println("1. Insert nodes from array");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Preorder Traversal");
            System.out.println("4. Postorder Traversal");
            System.out.println("5. Search node");
            System.out.println("6. Tree height");
            System.out.println("7. Leaf node count");
            System.out.println("8. Delete node");
            System.out.println("9. Print tree structure");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the number of elements in the array: ");
                    int n = sc.nextInt();
                    int[] arr = new int[n];
                    System.out.println("Enter the elements of the array:");
                    for (int i = 0; i < n; i++) {
                        arr[i] = sc.nextInt();
                    }
                    tree.insertFromArray(arr);
                    break;
                case 2:
                    System.out.println("Inorder Traversal:");
                    tree.InorderTraversal();
                    break;
                case 3:
                    System.out.println("Preorder Traversal:");
                    tree.preorder();
                    break;
                case 4:
                    System.out.println("Postorder Traversal:");
                    tree.postorder();
                    break;
                case 5:
                    System.out.print("Enter value to search: ");
                    int key = sc.nextInt();
                    System.out.println(tree.search(key) ? "Found" : "Not Found");
                    break;
                case 6:
                    System.out.println("Tree height: " + tree.height());
                    break;
                case 7:
                    System.out.println("Leaf node count: " + tree.countLeafNodes());
                    break;
                case 8:
                    System.out.print("Enter value to delete: ");
                    int delKey = sc.nextInt();
                    tree.delete(delKey);
                    break;
                case 9:
                    System.out.println("Tree structure:");
                    tree.printTree();
                    break;
                case 10:
                    System.out.println("Exit");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
