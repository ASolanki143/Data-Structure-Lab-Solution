import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lab16_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number of nodes");
        int node = sc.nextInt();

        Graph g = new Graph(node);
        g.createGraph();

        boolean[] visited = new boolean[node];
        System.out.println("---------- DFS ----------");
        g.dfs(0, visited);
        System.out.println();
        System.out.println("---------- BFS ----------");
        g.bfs();

    }
}

class Graph {
    int node;
    ArrayList<Integer>[] graph;

    public Graph(int node) {
        this.node = node;
        this.graph = new ArrayList[node];

        for (int i = 0; i < node; i++) {
            graph[i] = new ArrayList<Integer>();
        }
    }

    public void createGraph() {
        Scanner sc = new Scanner(System.in);
        int x;
        for (int i = 0; i < node; i++) {
            System.out.println("Enter adjecent nodes of " + i);
            System.out.println("Enter -1 for break");
            while (true) {
                x = sc.nextInt();
                if (x == -1) {
                    break;
                }
                graph[i].add(x);
            }
        }

        // for (int i = 0; i < node; i++) {
        //     System.out.println("Node" + i + " : " + graph[i].toString());
        // }
    }

    public void dfs(int n, boolean[] visited) {
        visited[n] = true;

        System.out.print(n + " ");

        for (int i = 0; i < graph[n].size(); i++) {
            if (!visited[graph[n].get(i)]) {
                dfs(graph[n].get(i), visited);
            }
        }
    }

    public void bfs(){
        boolean[] visited = new boolean[node];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0 ; i < graph[curr].size() ; i++){
                    q.add(graph[curr].get(i));
                }
            }
        }
    }
}