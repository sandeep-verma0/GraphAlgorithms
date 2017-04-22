package com.learnbycoding.undirectedgraph;


public class DepthFirstSearch {

	private boolean marked[];
	private int count;
	
	public DepthFirstSearch(Graph G , int s) {
			marked= new boolean[G.V()];          // Create a marked array of V vertices 
			for(int i=0;i<G.V();i++)
				marked[i]=false;   //Initialize all vertices as unvisited first
			this.count=0;
			//DFS for a connected Graph
			//IF Graph is not connected need to modify algorithm by doing iterator for
			// Each vertext
			DFS(G,s);
	}
	
	
	void DFS(Graph G, int s){
		marked[s]=true;
		count++;
//		Iterator<Integer> itr = G.adj[s].iterator();
//		while(itr.hasNext()){
//			int next =itr.next();
		for(int w: G.adj[s])
			if(marked[w]!=true)
				DFS(G,w);
		}
	
	
	public boolean marked(int vertex){
		return marked[vertex];
	}
	
	public int getCount(){
		return count;
	}
	
}
