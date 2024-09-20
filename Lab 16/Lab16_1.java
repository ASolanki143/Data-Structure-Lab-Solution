import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u); // For undirected graph
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");
        for (int neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for (int neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);

        System.out.println("DFS starting from vertex 0:");
        g.dfs(0);

        System.out.println("\nBFS starting from vertex 0:");
        g.bfs(0);
    }
}

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Scanner;

// // Main class to perform DFS and BFS on a graph
// public class Lab16_1 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in); // Scanner object to read input from user
//         System.out.println("Enter a number of nodes");
//         int node = sc.nextInt(); // Read the number of nodes

//         Graph g = new Graph(node); // Create a Graph object with the specified number of nodes
//         g.createGraph(); // Create the graph by taking input for edges

//         boolean[] visited = new boolean[node]; // Array to keep track of visited nodes for DFS
//         System.out.println("---------- DFS ----------");
//         g.dfs(0, visited); // Perform DFS starting from node 0
//         System.out.println();
//         System.out.println("---------- BFS ----------");
//         g.bfs(); // Perform BFS starting from node 0
//     }
// }

// // Class to represent a graph
// class Graph {
//     int node; // Number of nodes in the graph
//     ArrayList<Integer>[] graph; // Adjacency list representation of the graph

//     // Constructor to initialize the graph with the given number of nodes
//     public Graph(int node) {
//         this.node = node;
//         this.graph = new ArrayList[node];

//         for (int i = 0; i < node; i++) {
//             graph[i] = new ArrayList<Integer>(); // Initialize each adjacency list
//         }
//     }

//     // Method to create the graph by taking input from the user
//     public void createGraph() {
//         Scanner sc = new Scanner(System.in);
//         int x;
//         for (int i = 0; i < node; i++) {
//             System.out.println("Enter adjecent nodes of " + i);
//             System.out.println("Enter -1 for break");
//             while (true) {
//                 x = sc.nextInt(); // Read adjacent node
//                 if (x == -1) {
//                     break; // Break if user enters -1
//                 }
//                 graph[i].add(x); // Add the edge to the adjacency list
//             }
//         }
//     }

//     // Method to perform Depth First Search (DFS)
//     public void dfs(int n, boolean[] visited) {
//         visited[n] = true; // Mark the current node as visited
//         System.out.print(n + " "); // Print the current node

//         // Recur for all the adjacent nodes
//         for (int i = 0; i < graph[n].size(); i++) {
//             if (!visited[graph[n].get(i)]) {
//                 dfs(graph[n].get(i), visited); // Recursively call DFS on unvisited adjacent nodes
//             }
//         }
//     }

//     // Method to perform Breadth First Search (BFS)
//     public void bfs() {
//         boolean[] visited = new boolean[node]; // Array to keep track of visited nodes
//         Queue<Integer> q = new LinkedList<>(); // Queue to manage the BFS

//         q.add(0); // Start BFS from node 0

//         while (!q.isEmpty()) {
//             int curr = q.remove(); // Dequeue a node
//             if (!visited[curr]) {
//                 System.out.print(curr + " "); // Print the current node
//                 visited[curr] = true; // Mark the current node as visited

//                 // Enqueue all adjacent nodes
//                 for (int i = 0; i < graph[curr].size(); i++) {
//                     q.add(graph[curr].get(i));
//                 }
//             }
//         }
//     }
// }
