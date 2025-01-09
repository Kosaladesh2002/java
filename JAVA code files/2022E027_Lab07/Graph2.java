import java.util.*;
import java.util.Scanner;

public class Graph2 {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    
    private static int ROWS;
    private static int COLS;
    private static int[][] maze;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rows in the maze: ");
        ROWS = scanner.nextInt();
        
        System.out.print("Enter the number of columns in the maze: ");
        COLS = scanner.nextInt();
        
        maze = new int[ROWS][COLS];
        
        System.out.println("Enter the maze:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                maze[i][j] = scanner.nextInt();
            }
        }
        
        System.out.print("Enter the start coordinates (x y): ");
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();
        
        System.out.print("Enter the end coordinates (x y): ");
        int endX = scanner.nextInt();
        int endY = scanner.nextInt();
        
        List<int[]> path = bfs(startX, startY, endX, endY);

        if (path != null) {
            System.out.println("Shortest Path: ");
            for (int[] point : path) {
                System.out.println(Arrays.toString(point));
            }
            System.out.println("Path Length: " + path.size());
        } else {
            System.out.println("No path found!");
        }
    }

    public static List<int[]> bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});
        
        boolean[][] visited = new boolean[ROWS][COLS];
        visited[startX][startY] = true;
        
        int[][] parent = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            Arrays.fill(parent[i], -1);
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
                return reconstructPath(parent, startX, startY, endX, endY);
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (isValid(newX, newY) && !visited[newX][newY] && maze[newX][newY] == 0) {
                    queue.offer(new int[] {newX, newY});
                    visited[newX][newY] = true;
                    parent[newX][newY] = x * COLS + y;
                }
            }
        }

        return null;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS;
    }

    private static List<int[]> reconstructPath(int[][] parent, int startX, int startY, int endX, int endY) {
        List<int[]> path = new ArrayList<>();
        int x = endX, y = endY;

        while (x != startX || y != startY) {
            path.add(new int[] {x, y});
            int parentIdx = parent[x][y];
            x = parentIdx / COLS;
            y = parentIdx % COLS;
        }

        path.add(new int[] {startX, startY});
        Collections.reverse(path);

        return path;
    }
}
