package com.learnbycoding.undirectedgraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph {

	private int V;  // Number of vertices
	private int E;  // Number of Edges 
	List<Integer> adj[];  // Adjacency Lists
	
	public Graph(int V){    //Create array of Linked List, Initialise all lists to empty
		this.V=V;
		
		for(int i=0;i<V;i++)
			adj[i]= new LinkedList<Integer>();
		this.E=0;
	}
	
	public Graph(Scanner in){   
		this(in.nextInt());   // Read V and contrust Graph
		int E=in.nextInt();   // Read E
		for(int i=0;i<E;i++)
		{
			int v= in.nextInt(); //Read a vertex
			int w=in.nextInt();  // Read another Vertex
			addEdge(v,w);
		}
	}
	
	public void addEdge(int v,int w){
		adj[v].add(w);      // Add w to v’s list.  
		adj[w].add(v);      // Add v to w’s list.
		E++;
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
}
