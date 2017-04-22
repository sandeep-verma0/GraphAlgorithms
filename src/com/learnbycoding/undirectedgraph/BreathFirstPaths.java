package com.learnbycoding.undirectedgraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreathFirstPaths {
	private boolean marked[];
	private int[] edgeTo; // last vertex on known path to this vertex
    private final int s;
	public BreathFirstPaths(Graph G, int s) {
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
		BFP(G, s);
	}

	private void BFP(Graph G, int s) {
		marked[s] = true;

		Queue<Integer> queue = new LinkedList <Integer>();		
		queue.add(s);
		marked[s]=true;
		while(!queue.isEmpty()){
			int v=queue.poll();
			for(int w: G.adj[v])
				if(!marked[w]){
					marked[w]=true;
					edgeTo[w]=v;
					queue.add(w);
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
