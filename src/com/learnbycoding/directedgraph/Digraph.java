package com.learnbycoding.directedgraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Digraph {

	private int V;
	private int E;
	public List<Integer> adj[] ;
	
	public Digraph(int V){
		
		this.V = V;
		adj = new ArrayList[V];
		
		for(int i=0;i<V;i++)
			adj[i]= new LinkedList<Integer>();
		this.E=0;
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		E++;
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v] ;
	}
	
	public Digraph reverse(){
		Digraph R = new Digraph(V);
		for(int i=0;i<V;i++){
			for(int w: adj[i])
				R.addEdge(w, i);
		}
		
		return R;
	}
}
