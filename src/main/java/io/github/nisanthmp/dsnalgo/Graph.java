package io.github.nisanthmp.dsnalgo;

public interface Graph {
    public boolean addEdge(int source, int dest, int weight);
    public boolean addEdge(int source, int dest);
    public void bfs();
    public void dfs();
    public void mst();
    public int shortestPath(int source, int dest);
    public void createConnectivityMatrix();
}
