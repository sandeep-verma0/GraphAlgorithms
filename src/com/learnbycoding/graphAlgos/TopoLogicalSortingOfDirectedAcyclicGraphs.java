package com.learnbycoding.graphAlgos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TopoLogicalSortingOfDirectedAcyclicGraphs {

	int V;
	List<Integer> adjacencyList[];
	
	public TopoLogicalSortingOfDirectedAcyclicGraphs(int v){
		
		this.V = v;
		adjacencyList = new LinkedList[this.V];
		for(int i=0;i< this.V;i++){
			adjacencyList[i]= new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v , int w){
		adjacencyList[v].add(w);
	}
	
	void topoSortUtil(){
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i< V;i++){
			if(!visited[i])
				topoSort(i,visited, stack);
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}
	
	void topoSort(int i, boolean[] visited , Stack<Integer> stack ){
		
		visited[i]=true;
		int n;
		Iterator<Integer> itr = adjacencyList[i].iterator();
		while(itr.hasNext()){
			 n=itr.next();
			if(!visited[n])
				topoSort(n,visited, stack);
		}
		
		stack.push(i);
	}
	
	public static void main(String[] args) {

		
		TopoLogicalSortingOfDirectedAcyclicGraphs g = new TopoLogicalSortingOfDirectedAcyclicGraphs(6);
	        g.addEdge(5, 2);
	        g.addEdge(5, 0);
	        g.addEdge(4, 0);
	        g.addEdge(4, 1);
	        g.addEdge(2, 3);
	        g.addEdge(3, 1);
	 
	        System.out.println("Following is a Topological " +
	                           "sort of the given graph");
	        g.topoSortUtil();
	}

}
