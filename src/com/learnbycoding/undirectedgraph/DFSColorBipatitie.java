package com.learnbycoding.undirectedgraph;


public class DFSColorBipatitie {
	private boolean marked[];
	private boolean isTwoColourable;
	private int colour[];
	private int[] edgeTo;

	public DFSColorBipatitie(Graph G) {
		marked = new boolean[G.V()]; // Create a marked array of V vertices
		colour = new int[G.V()];
		for (int i = 0; i < G.V(); i++)
			marked[i] = false; // Initialize all vertices as unvisited first
		this.isTwoColourable = true;
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
			if(!marked[w]){
				colour[w]= 1-colour[s];
				edgeTo[w] = s;
				DFS(G,s,w);
				}
			else if(colour[w]==colour[s])   // If all edges incident from s are already visited and if any edge incident to s is 
			{ 
			       isTwoColourable=false;
			}
		}
	}

	public boolean isTwoColourable() {
		return isTwoColourable;
	}

}
