package dz20;

import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addVertex(int vertex) {
        if (!graph.containsKey(vertex)) {
            graph.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        if (graph.containsKey(source) && graph.containsKey(destination)) {
            graph.get(source).add(destination);
        }
    }

    public void removeVertex(int vertex) {
        if (!graph.containsKey(vertex))
            return;
        graph.remove(vertex);

        for (List<Integer> edges : graph.values()) {
            edges.remove(Integer.valueOf(vertex));
        }
    }

    public void removeEdge(int source, int destination) {
        if (graph.containsKey(source)) {
            graph.get(source).remove(Integer.valueOf(destination));
        }
    }

    public boolean hasVertex(int vertex) {
        return graph.containsKey(vertex);
    }

    public boolean hasEdge(int source, int destination) {
        if (!graph.containsKey(source)) return false;
        return graph.get(source).contains(destination);
    }

    public void printGraph() {
        System.out.println(graph);
    }
}