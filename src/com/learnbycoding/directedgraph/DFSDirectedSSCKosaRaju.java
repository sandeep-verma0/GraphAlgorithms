package com.learnbycoding.directedgraph;

import com.learnbycoding.undirectedgraph.Graph;


public class DFSDirectedSSCKosaRaju {

	private boolean marked[];
	private int count;
	private int id[];

	public DFSDirectedSSCKosaRaju(Digraph G) {
		marked = new boolean[G.V()]; // Create a marked array of V vertices
		for (int i = 0; i < G.V(); i++)
			marked[i] = false; // Initialize all vertices as unvisited first
		this.count = 0;
		id = new int[G.V()];
		// DFS for a connected Graph
		// IF Graph is not connected need to modify algorithm by doing iterator
		// for
		// Each vertext
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for (int s : order.reversePost()) {
			DFS(G, s);
			count++;
		}
	}

	private void DFS(Digraph G, int s) {
		marked[s] = true;
		id[s] = count;

		// Iterator<Integer> itr = G.adj[s].iterator();
		// while(itr.hasNext()){
		// int next =itr.next();
		for (int w : G.adj[s])
			if (marked[w] != true)
				DFS(G, w);
	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public boolean marked(int vertex) {
		return marked[vertex];
	}

	public int getCount() {
		return count;
	}
}

