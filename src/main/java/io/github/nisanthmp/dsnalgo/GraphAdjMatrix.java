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
            return;
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
        boolean[] visited = new boolean[numVertices];
        int[] predecessor = new int[numVertices];
        Arrays.fill(predecessor, -1);
        SortedArrayMST priorityQ = new SortedArrayMST(numVertices, false, true, false);

        for (int i = 0; i < numVertices; i++) {
            if (visited[i]) {
                continue;
            }
            int currentVertex = i;
            visited[i] = true;
            while (currentVertex != -1) {
                for (int j = 0; j < numVertices; j++) {
                    if (adjMatrix[currentVertex][j] == 0 || visited[j]){
                        continue;
                    }
                    priorityQ.addElement(currentVertex, j, adjMatrix[currentVertex][j]);
                }
                Edge edge = priorityQ.removeElement();
                if (edge == null) {
                    currentVertex = -1;
                } else {
                    //Edge edge = priorityQ.getAtIndex(numElementsInQ - 1);
                    currentVertex = edge.dest;
                    visited[edge.dest] = true;
                    System.out.println("Edge: " + edge.source + " " + edge.dest + "; Weight = " + edge.weight);
                }

            }
        }

    }

    @Override
    public int shortestPath(int source, int dest) {
        if (isWeighted) {
            return weightedShortestPath(source, dest);
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

    private int weightedShortestPath(int source, int dest) {
        if (source < 0 || source >= numVertices || dest < 0 || dest >= numVertices) {
            System.out.println("Source and/or Dest not on the Graph");
            return -1;
        }
        if (source == dest) {
            System.out.println("Source and Destination are same");
            return 0;
        }
        GraphVertex[] vertices = new GraphVertex[numVertices];
        for (int i = 0; i < numVertices; i++) {
            vertices[i] = new GraphVertex(i);
        }
        //int predecessor = -1;
        int vertex = source;
        vertices[vertex].distance = 0;
        while (vertex != -1) {
            //vertices[vertex].predecessor = predecessor;
            vertices[vertex].visited = true;

            /*if (predecessor != -1) {
                vertices[vertex].distance = vertices[predecessor].distance + adjMatrix[predecessor][vertex];
            }*/
            int minDistance = Integer.MAX_VALUE;
            int minI = -1;
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[vertex][i] == 0 || vertices[i].visited) {
                    continue;
                }
                int newDistance = adjMatrix[vertex][i] + vertices[vertex].distance;
                if (vertices[i].distance > newDistance) {
                    vertices[i].distance = newDistance;
                    vertices[i].predecessor = vertex;
                }
                if (vertices[i].distance < minDistance) {
                    minDistance = vertices[i].distance;
                    minI = i;
                }
            }
            vertex = minI;
            if (vertex == dest) {
                break;
            }
        }
        if (vertices[dest].predecessor == -1) {
            System.out.println("There is no path from " + source + " to " + dest);
            return -1;
        } else {
            StackLLObj stack = new StackLLObj();
            vertex = dest;
            int predecessor = vertices[vertex].predecessor;
            while (predecessor != -1) {
                stack.push(new Edge(predecessor, vertex, adjMatrix[predecessor][vertex]));
                vertex = predecessor;
                predecessor = vertices[vertex].predecessor;
            }
            Edge edge = (Edge)stack.pop();
            System.out.println("The shortest path from " + source + " to " + dest + " has length " + vertices[dest].distance);
            System.out.println("The shortest path has the following edges:");
            while (edge != null) {
                System.out.println("Edge: " + edge.source + " " + edge.dest + "; weight = " + edge.weight);
                edge = (Edge)stack.pop();
            }
            return vertices[dest].distance;
        }
    }

    @Override
    public void createConnectivityMatrix() {

    }
}
class GraphVertex {
    public int vertex;
    public int distance;
    public boolean visited;
    public int predecessor;
    public GraphVertex (int vertex) {
        this.vertex = vertex;
        distance = Integer.MAX_VALUE;
        visited = false;
        predecessor = -1;
    }
}

class Edge {
    public int source;
    public int dest;
    public int weight;
    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

class SortedArrayMST {
    private Edge[] data;
    private int size;
    private int numElements;
    private int nearestIdx;
    private boolean extendable;
    private boolean allowsDuplicate;
    private boolean ascending;

    public SortedArrayMST(int size) {
        this(size, true, true, false);
    }

    public SortedArrayMST() {
        this(10, true, true, false);
    }

    public SortedArrayMST(int size, boolean extendable, boolean allowsDuplicate, boolean ascending) {
        data  = new Edge[size];
        this.size = size;
        this.numElements = 0;
        this.extendable = extendable;
        this.allowsDuplicate = allowsDuplicate;
        this.ascending = ascending;
    }

    public int getSize() {
        return size;
    }
    public int sayHello() {
        System.out.println("Hello, World!");
        return 0;
    }
    public int getNumElements() {
        return numElements;
    }

    public void addElement(int source, int dest, int weight) {
        //int element = weight;
        Edge edge = new Edge(source, dest, weight);
        if (numElements == size) grow();
        //display();
        int present = find(weight, 0, numElements - 1);
        //System.out.println("nearestIdx = " + nearestIdx);
        if (allowsDuplicate || present == -1) {
            for (int j = numElements; j > nearestIdx; j--) {
                data[j] = data[j - 1];
            }
            data[nearestIdx] = edge;
            numElements++;
            // Remove redundant edges
            for (int i = 0; i < numElements; i++) {
                if (i == nearestIdx) continue;
                if (data[i].dest == dest) {
                    if (data[i].weight >= weight) removeIthElement(i);
                    else removeIthElement(nearestIdx);
                    break;
                }
            }
        }
    }

    public Edge removeElement() {
        if (numElements == 0) return null;
        return data[--numElements];
    }

    private void removeIthElement(int i) {
        for (int j = i; j < numElements - 1; j ++){
            data[j] = data[j + 1];
        }
        numElements --;
    }

    private void grow() {
        Edge[] newData = new Edge[size * 2];
        for(int i = 0; i < size; i ++) {
            newData[i] = data[i];
        }
        data = newData;
        size *= 2;
    }

    public Edge getFirst() {
        return data[0];
    }

    public Edge getAtIndex(int idx) {
        return data[idx];
    }

    public int findElement(int element) {
        return find(element, 0, numElements - 1);
    }

    private boolean compare(boolean ascending, int a, int b) {
        return ascending ? a > b : a < b;
    }

    private int find(int element, int start, int end) {
        if (start > end) {
            nearestIdx = 0;
            return -1;
        }
        int i = start + (end - start)/2;
        if (data[i].weight == element) {
            nearestIdx = i;
            return i;
        }
        else if (compare(ascending, data[i].weight, element)) {
            if (i > start) return find(element, start, i - 1);
            else {
                nearestIdx = i;
                return -1;
            }
        }
        else {
            if (i < end) return find(element, i + 1, end);
            else {
                nearestIdx = i + 1;
                return -1;
            }
        }
    }

    public boolean removeElement(int element) {
        int i = findElement(element);
        if (i == -1) return false;
        else {
            for (int j = i; j < numElements - 1; j ++){
                data[j] = data[j + 1];
            }
            numElements --;
            return true;
        }
    }

    public void display() {
        if(numElements == 0) {
            System.out.println("The array is empty!");
            return;
        }
        System.out.print(data[0]);
        for(int i = 1; i < numElements; i ++) {
            System.out.print(" " + data[i]);
        }
        System.out.print("\n");
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}
