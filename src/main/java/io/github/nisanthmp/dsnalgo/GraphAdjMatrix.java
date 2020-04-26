package io.github.nisanthmp.dsnalgo;

import java.util.Arrays;

public class GraphAdjMatrix implements Graph {
    private int numVertices;
    private int[][] adjMatrix;
    private boolean isWeighted = false;
    private boolean isDirected;

    public GraphAdjMatrix(int numVertices, boolean isDirected) {
        this.numVertices = numVertices;
        this.isDirected = isDirected;
        adjMatrix = new int[numVertices][numVertices];
    }

    public GraphAdjMatrix(int numVertices) {
        this(numVertices, false);
    }

    @Override
    public boolean addEdge(int source, int dest, int weight) {
        if (source < 0 || source >= numVertices || dest < 0 || dest >= numVertices) {
            System.out.println("Vertex is not present");
            return false;
        }
        if (weight <= 0) {
            System.out.println("Non-positive weights are not allowed");
            return false;
        }
        if (adjMatrix[source][dest] != 0) {
            System.out.println("Edge already exists");
            return false;
        }
        if (source == dest) {
            System.out.println("Source and destination vertices can't be the same");
            return false;
        }
        if (weight != 1) {
            isWeighted = true;
            System.out.println("Graph is set as weighted graph");
        }

        adjMatrix[source][dest] = weight;
        if (!isDirected) {
            adjMatrix[dest][source] = weight;
        }
        return true;
    }

    @Override
    public boolean addEdge(int source, int dest) {
        return addEdge(source, dest, 1);
    }

    @Override
    public void bfs() {
        boolean[] visited = new boolean[numVertices];
        Queue queue = new QueueArrayObj(numVertices + 1);

        for (int i = 0; i < numVertices; i++) {
            if (visited[i]) {
                continue;
            }
            queue.add(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                int vertex = ((Integer) queue.remove()).intValue();
                System.out.println("Vertex " + vertex + " is processed.");
                for (int j = 0; j < numVertices; j++) {
                    if (adjMatrix[vertex][j] == 0 || visited[j]) {
                        continue;
                    }
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }

    }

    @Override
    public void dfs() {
        boolean[] visited = new boolean[numVertices];
        StackArray stack = new StackArray(numVertices + 1);

        for (int i = 0; i < numVertices; i++) {
            if (visited[i]) {
                continue;
            }
            stack.push(i);
            visited[i] = true;
            int vertex = stack.pop();
            while (vertex != -1) {
                System.out.println("Vertex " + vertex + " is processed.");
                for (int j = 0; j < numVertices; j++) {
                    if (visited[j] || adjMatrix[vertex][j] == 0) {
                        continue;
                    }
                    stack.push(j);
                    visited[j] = true;
                }
                vertex = stack.pop();
            }
        }
    }

    @Override
    public void mst() {
        if (isWeighted) {
            weightedMST();
        }
        boolean[] visited = new boolean[numVertices];
        int[] predecessor = new int[numVertices];
        Arrays.fill(predecessor, -1);
        StackArray stack = new StackArray(numVertices + 1);

        for (int i = 0; i < numVertices; i++) {
            if (visited[i]) {
                continue;
            }
            stack.push(i);
            visited[i] = true;
            int vertex = stack.pop();
            while (vertex != -1) {
                if (predecessor[vertex] != -1) {
                    System.out.println("Edge: " + predecessor[vertex] + " " + vertex);
                }
                for (int j = 0; j < numVertices; j++) {
                    if (visited[j] || adjMatrix[vertex][j] == 0) {
                        continue;
                    }
                    stack.push(j);
                    visited[j] = true;
                    predecessor[j] = vertex;
                }
                vertex = stack.pop();
            }
        }

    }

    private void weightedMST() {
        ;
    }

    @Override
    public int shortestPath(int source, int dest) {
        if (isWeighted) {
            return weightedShortedPath(source, dest);
        }
        if (source == dest) {
            System.out.println("Source and Destination are same");
            return 0;
        }
        boolean[] visited = new boolean[numVertices];
        int[] predecessor = new int[numVertices];
        Arrays.fill(predecessor, -1);
        Queue queue = new QueueArrayObj(numVertices + 1);

        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int vertex = ((Integer) queue.remove()).intValue();
            //System.out.println("Vertex " + vertex + " is processed.");
            int j = 0;
            for (; j < numVertices; j++) {
                if (adjMatrix[vertex][j] == 0 || visited[j]) {
                    continue;
                }
                queue.add(j);
                visited[j] = true;
                predecessor[j] = vertex;
                if (j == dest) {
                    break;
                }
            }
            if (j == dest) {
                break;
            }
        }
        int pathLength = 0;
        StackLLObj stack = new StackLLObj();
        int vertex = dest;
        while (predecessor[vertex] != -1) {
            int[] edge = {predecessor[vertex], vertex};
            stack.push(edge);
            pathLength ++;
            vertex = predecessor[vertex];
        }
        if (pathLength == 0) {
            System.out.println("There is no path from " + source + " to " + dest);
            return -1;
        }
        int[] edge = (int[]) stack.pop();
        System.out.println("Shortest Path from " + source + " to " + dest + ":");
        System.out.println("Shortest Path has length: " + pathLength);
        System.out.println("Edges of the shortest path are:");
        while (edge != null) {
            System.out.println("Edge: " + edge[0] + " " + edge[1]);
            edge = (int[]) stack.pop();
        }
        return pathLength;
    }

    private int weightedShortedPath(int source, int dest) {
        return -1;
    }

    @Override
    public void createConnectivityMatrix() {

    }
}
