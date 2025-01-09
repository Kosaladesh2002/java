import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sample Input:");
        int t = scanner.nextInt();
        scanner.nextLine();

        String[] expressions = new String[t];

        for (int i = 0; i < t; i++) {
            expressions[i] = scanner.nextLine();
        }

        System.out.println();
        System.out.println("Sample Output:");
        for (int i = 0; i < t; i++) {
            String expression = expressions[i];


            CustomStack stack = new CustomStack(expression.length());
            boolean isBalanced = true;

            for (int j = 0; j < expression.length(); j++) {
                char current = expression.charAt(j);

                if (current == '{' || current == '[' || current == '(') {
                    stack.push(current);
                } else if (current == '}' || current == ']' || current == ')') {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    }
                    char top = stack.pop();

                    if ((current == '}' && top != '{') ||
                            (current == ']' && top != '[') ||
                            (current == ')' && top != '(')) {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (isBalanced && stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}

class CustomStack {
    private char[] elements;
    private int top;

    public CustomStack(int size) {
        elements = new char[size];
        top = -1;
    }

    public void push(char item) {
        if (top == elements.length - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        elements[++top] = item;
    }

    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return elements[top--];
    }

    public boolean isEmpty() {
        return top == -1;

    }
}