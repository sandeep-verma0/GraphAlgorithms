package com.learnbycoding.directedgraph;

import java.util.Stack;

public class DirectedCycle {
 
	private boolean marked[];
	private boolean onStack[];
	private int edgeTo[];
	private Stack<Integer> cycle;
	
	public  DirectedCycle(Digraph G){
		
		marked = new boolean[G.V()];
		onStack=new boolean[G.V()];
		edgeTo = new int[G.V()];
		
		for(int v=0;v<G.V();v++)
			if(!marked[v])
				DFS(G,v);
		
	}
	
	private void DFS(Digraph G, int s){
		
		marked[s]=true;
		onStack[s]=true;
		
		for(int w: G.adj(s))
		{
			if(this.hasCycle())
				return;
			else if(!marked[w]){
				edgeTo[w]=s;
				DFS(G,w);
				}
			else if(onStack[w]){
				cycle = new Stack<Integer>();
				for(int x=s; x!=w;x=edgeTo[x])
					cycle.push(x);
				cycle.push(w);
				cycle.push(s);
			}
		}
		
		onStack[s]=false;
	}
	
	public boolean hasCycle(){
		return cycle!=null;
	}

}
