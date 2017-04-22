package com.learnbycoding.undirectedgraph;

import java.util.Stack;

public class DepthFirstPaths {

	private boolean marked[];
	private int[] edgeTo; // last vertex on known path to this vertex
    private final int s;
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()]; // Create a marked array of V vertices
		edgeTo = new int[G.V()];
		this.s=s;
		for (int i = 0; i < G.V(); i++) {
			marked[i] = false; // Initialize all vertices as unvisited first
			edgeTo[i] = -1;
			
		}
		// DFS for a connected Graph
		// IF Graph is not connected need to modify algorithm by doing iterator
		// for
		// Each vertext
		DFP(G, s);
	}

	void DFP(Graph G, int s) {
		marked[s] = true;

		// Iterator<Integer> itr = G.adj[s].iterator();
		// while(itr.hasNext()){
		// int next =itr.next();
		for (int w : G.adj[s]) {
			if (marked[w] != true) {
				edgeTo[w] = s;
				DFP(G, w);
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v)
	{
		if(hasPathTo(v)==false)
			return null;
		
		Stack<Integer> path = new Stack<Integer>();
		int x;
		for( x=v; x!=s;x=edgeTo[x])
			path.push(x);
		path.push(s);
		
		return path;
	}
}
