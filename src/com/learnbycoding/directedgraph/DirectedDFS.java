package com.learnbycoding.directedgraph;

import java.util.Iterator;

public class DirectedDFS {

	private boolean marked[];
	
	public DirectedDFS(Digraph G , int source){
		marked = new boolean[G.V()];
		for(int i=0;i< G.V();i++)
			marked[i]=false;
		
		if(!marked[source])
			DFS(G,source);
	}
	
	private void DFS(Digraph G,int s){
		marked[s]=true;
		for(int w : G.adj(s))
			if(!marked[w])
				DFS(G,w);
	}
	
	
	public DirectedDFS(Digraph G , Iterable<Integer> source){
		marked = new boolean[G.V()];
		for(int i=0;i< G.V();i++)
			marked[i]=false;
		
		for(int s: source)
			if(!marked[s])
				DFS(G,s);		
	}
	
	public boolean isMarked(int v)
	{
		return marked[v];
	}
	
}
