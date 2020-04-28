package io.github.nisanthmp.dsnalgo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class TestGraphAdjMatrix {
    Graph graph;
    Graph graphSimple;
    Graph graphWeighted;

    @BeforeEach
    void setup() throws Exception {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("graphInput01.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        bufferedReader.readLine();
        int numVertices = Integer.parseInt(bufferedReader.readLine());
        System.out.println("numVertices: " + numVertices);
        bufferedReader.readLine();
        String isDirectedString = bufferedReader.readLine();
        boolean isDirected = isDirectedString.equals("false") ? false : isDirectedString.equals("true") ? true : false;
        System.out.println("isDirected: " + isDirected);
        bufferedReader.readLine();
        String isWeightedString = bufferedReader.readLine();
        boolean isWeighted = isWeightedString.equals("false") ? false : isWeightedString.equals("true") ? true : false;
        bufferedReader.readLine();
        String[] edges = bufferedReader.readLine().split(",");

        graph = new GraphAdjMatrix(numVertices, isDirected);
        Pattern pattern = Pattern.compile("\\d+");
        for (String edge : edges) {
            Matcher matcher = pattern.matcher(edge);
            matcher.find();
            int source = Integer.parseInt(matcher.group());
            matcher.find();
            int dest = Integer.parseInt(matcher.group());
            int weight = 1;
            if (isWeighted) {
                matcher.find();
                weight = Integer.parseInt(matcher.group());
            }
            graph.addEdge(source, dest, weight);
        }

        graphSimple = new GraphAdjMatrix(7, false);
        graphSimple.addEdge(0, 1);
        graphSimple.addEdge(0, 2);
        graphSimple.addEdge(1, 2);
        graphSimple.addEdge(1, 3);
        graphSimple.addEdge(1, 4);
        graphSimple.addEdge(2, 5);
        graphSimple.addEdge(2, 6);
        graphSimple.addEdge(5, 6);

        graphWeighted = new GraphAdjMatrix(7, true);
        graphWeighted.addEdge(0, 1, 1);
        graphWeighted.addEdge(0, 2, 5);
        graphWeighted.addEdge(1, 2, 2);
        graphWeighted.addEdge(1, 3, 3);
        graphWeighted.addEdge(1, 4, 2);
        graphWeighted.addEdge(5, 6, 4);
    }

    @Test
    void TestAddEdge() {
        Graph graphSimple = new GraphAdjMatrix(10);
        assertTrue(graphSimple.addEdge(0, 1));
        assertFalse(graphSimple.addEdge(0, 10)); // Vertex 10 doesn't exist
        assertTrue(graphSimple.addEdge(0, 2, 1));
        assertTrue(graphSimple.addEdge(1, 3, 5));
        assertFalse(graphSimple.addEdge(3, 2, 0)); // 0 weight is not allowed
        assertFalse(graphSimple.addEdge(4, 6, -1)); // negative weight is not allowed
        assertFalse(graphSimple.addEdge(0, 1)); // Edge already present
        assertFalse(graphSimple.addEdge(0, 0)); // Source and destination vertices can't be the same;
    }

    @Test
    void testBFS() {
        System.out.println("graphSimple BFS:");
        graphSimple.bfs();
        System.out.println("Complex graph BFS");
        graph.bfs();
    }

    @Test
    void testDFS() {
        System.out.println("graphSimple DFS:");
        graphSimple.dfs();
        System.out.println("Complex graph DFS");
        graph.dfs();
    }

    @Test
    void testMST() {
        System.out.println("graphSimple MST:");
        graphSimple.mst();
        System.out.println("Complex graph MST");
        graph.mst();
        System.out.println("Weighted Directed Graph MST");
        graphWeighted.mst();
    }

    @Test
    void testShortestPath() {
        graphSimple.shortestPath(0, 5);
        graphSimple.shortestPath(3, 1);
        graphWeighted.shortestPath(0, 2);
        graphWeighted.shortestPath(0, 4);
        graphWeighted.shortestPath(0, 6);
    }

    @Test
    void createConnectivityMatrix() {
    }
}