package com.learnbycoding.graphAlgos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {

	int V;
	List<Integer> adjacencyList[];

	public DepthFirstSearch(int v) {
		this.V = v;
		adjacencyList = new List[v];
		for (int i = 0; i < v; ++i) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		adjacencyList[v].add(w);
	}

	void DFS() {

		boolean[] visited = new boolean[V];
		for(int k=0;k< V; k++)
			if(visited[k]==false)
				DFSUtil(k,visited);

	}

	void DFSUtil(int i, boolean[] visited){
		
		visited[i]=true;
		System.out.print(i+" ");
		
		Iterator<Integer> itr = adjacencyList[i].iterator();
		while(itr.hasNext()){
			int n= itr.next();
			if(!visited[n])
				DFSUtil(n, visited);
		}
		
	}
	public static void main(String[] args) {

		DepthFirstSearch dfs = new DepthFirstSearch(4);
		
		dfs.addEdge(0, 1);
		dfs.addEdge(0, 2);
		dfs.addEdge(1, 2);
		dfs.addEdge(2, 0);
		dfs.addEdge(2, 3);
		dfs.addEdge(3, 3);
		
		dfs.DFS();
	}

}
