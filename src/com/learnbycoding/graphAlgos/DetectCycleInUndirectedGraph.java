package com.learnbycoding.graphAlgos;

import java.awt.print.Book;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleInUndirectedGraph {

	int V;
	List<Integer> adjacencyList[];
	public DetectCycleInUndirectedGraph(int v){
		this.V = v;
		adjacencyList = new LinkedList[v];
		for(int i=0;i< v;i++)
		{
			adjacencyList[i]=new LinkedList<Integer>();
		}
	}
	
	void addEdge(int v , int w){
		adjacencyList[v].add(w);
		adjacencyList[w].add(v);
	}
	
	 // Returns true if the graph contains a cycle, else false.
	boolean hasCycleUtil(){

        // Mark all the vertices as not visited and not part of
        // recursion stac
		boolean[] visited = new boolean[V];
		
		for(int i=0;i<V;i++){
			if(!visited[i])

		        // Call the recursive helper function to detect cycle in
		        // different DFS trees
				if(hasCycle(i,visited, -1)) return true;
		}
		
		return false;
	}
	
	// A recursive function that uses visited[] and parent to detect
    // cycle in subgraph reachable from vertex v.
	boolean hasCycle(int i, boolean[] visited,int parent){
		
		 // Mark the current node as visited
		visited[i]=true;

        // Recur for all the vertices adjacent to this vertex
		Iterator<Integer> itr =  adjacencyList[i].iterator();
		while(itr.hasNext()){
			int n= itr.next();
			
			// If an adjacent is not visited, then recur for that
            // adjacent
			if(!visited[n]){
				if(hasCycle(n, visited, i)) return true;
			}
			else if(n!=parent)
				return true;
		}
		
		return false;
		
	}
	public static void main(String[] args) {

		 // Create a graph given in the above diagram
        DetectCycleInUndirectedGraph g1 = new DetectCycleInUndirectedGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.hasCycleUtil())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
 
        DetectCycleInUndirectedGraph g2 = new DetectCycleInUndirectedGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.hasCycleUtil())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
	}

}
