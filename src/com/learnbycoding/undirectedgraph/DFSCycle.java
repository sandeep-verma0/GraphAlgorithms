package com.learnbycoding.undirectedgraph;

import java.util.Stack;

public class DFSCycle {

	private boolean marked[];
	private boolean hasCycle;
	private Stack<Integer> cycle;
	private int[] edgeTo;

	public DFSCycle(Graph G) {
		marked = new boolean[G.V()]; // Create a marked array of V vertices
		for (int i = 0; i < G.V(); i++)
			marked[i] = false; // Initialize all vertices as unvisited first
		this.hasCycle = false;
		// DFS for a connected Graph
		// IF Graph is not connected need to modify algorithm by doing iterator
		// for
		// Each vertext
		edgeTo = new int[G.V()];

		for (int s = 0; s < G.V(); s++) {
			int parent = s;
			if (!marked[s])
				DFS(G, parent, s);
		}
	}

	private void DFS(Graph G, int parent , int s){
		marked[s]=true;
//		Iterator<Integer> itr = G.adj[s].iterator();
//		while(itr.hasNext()){
		

//			int next =itr.next();
		for(int w : G.adj[s]){
			 if (cycle != null)
				 return;
			 
			if(!marked[w]){
				edgeTo[w] = s;
				DFS(G,s,w);
				}
			else if(w !=parent)   // If all edges incident from s are already visited and if any edge incident to s is 
			{ 
				hasCycle=true;  // not it's parent , then it's coming from somewhere else and it forms an edge
				cycle= new Stack<Integer>();
				for(int x=s; x !=w ; x=edgeTo[x])
					cycle.add(x);
				cycle.add(w);
				cycle.add(s);
				
			}
		}
	}

	public boolean hasCycle() {
		return hasCycle;
	}

}
