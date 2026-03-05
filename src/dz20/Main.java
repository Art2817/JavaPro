package dz20;

public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        System.out.println("Graph:");
        graph.printGraph();
        System.out.println("Has vertex 2: " + graph.hasVertex(2));
        System.out.println("Has edge 1-3: " + graph.hasEdge(1, 3));

        graph.removeEdge(1, 3);
        System.out.println("After removing edge 1-3:");
        graph.printGraph();

        graph.removeVertex(2);
        System.out.println("After removing vertex 2:");
        graph.printGraph();
    }
}