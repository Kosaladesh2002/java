import java.util.*;


class Graph1 {

    static class Edge {
        char src, dest;
        int weight;

        public Edge(char src, char dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private Map<Character, List<Edge>> adjList;

    // Constructor
    public Graph1() {
        adjList = new HashMap<>();
    }

    public void addEdge(char src, char dest, int weight) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());

        adjList.get(src).add(new Edge(src, dest, weight));
        adjList.get(dest).add(new Edge(dest, src, weight));
    }

    public void displayAdjList() {
        for (char vertex : adjList.keySet()) {
            System.out.print(vertex + " -> ");
            for (Edge edge : adjList.get(vertex)) {
                System.out.print("(" + edge.dest + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Prim's 
    public void primMST() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<Character> visited = new HashSet<>();
        char startVertex = adjList.keySet().iterator().next(); 

        visited.add(startVertex);
        adjList.get(startVertex).forEach(pq::add);

        int totalWeight = 0;
        List<Edge> mstEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited.contains(edge.dest)) {
                continue;
            }

            visited.add(edge.dest);
            mstEdges.add(edge);
            totalWeight += edge.weight;

            adjList.get(edge.dest).forEach(pq::add);
        }

        System.out.println("Edges in MST:");
        for (Edge mstEdge : mstEdges) {
            System.out.println(mstEdge.src + "-" + mstEdge.dest + " (" + mstEdge.weight + ")");
        }
        System.out.println("Total weight of MST: " + totalWeight);
    }

    // Main 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        Graph1 graph = new Graph1();

       
        System.out.println("Enter the number of edges:");
        int numEdges = scanner.nextInt();
        scanner.nextLine(); 

        
        for (int i = 0; i < numEdges; i++) {
            System.out.println("Enter edge " + (i + 1) + " in the format (src dest weight):");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            char src = parts[0].charAt(0);
            char dest = parts[1].charAt(0);
            int weight = Integer.parseInt(parts[2]);

            graph.addEdge(src, dest, weight);
        }

     
        System.out.println("\nAdjacency List Representation of the Graph:");
        graph.displayAdjList();

       
        System.out.println("\nMinimum Spanning Tree using Prim's Algorithm:");
        graph.primMST();

        scanner.close();
    }
}
