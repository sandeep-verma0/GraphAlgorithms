package com.learnbycoding.graphAlgos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DFSForDisconnectedGraphs {
	
	int V;
	List<Integer> adjacencyList[];
	
	public DFSForDisconnectedGraphs(int v){
		this.V=v;
		adjacencyList=new List[V];
		for(int i=0;i< V;i++){
			adjacencyList[i]= new LinkedList<Integer>();
		}
	}

	void addEdge(int src, int dest){
		adjacencyList[src].add(dest);
	}
	
	void isConnected(){
		boolean visited[]= new boolean[V];
		for(int i=0;i<V;i++){
			visited[i]=false;
		}
		
		 DFSUtil(0,visited);
		 boolean isDisConnected =false;
		 for(int i=0;i<V;i++)
			 if(!visited[i])
			 { isDisConnected=true;
				 System.out.println("Graph is disconnected at node " + i);
			   //return ;
			 }
		 if(!isDisConnected)
		System.out.println("Graph is connected");
	}
	
	void DFSUtil(int i,boolean[] visited){
		
		visited[i]=true;
		
		Iterator<Integer> itr = adjacencyList[i].iterator();
		while(itr.hasNext()){
			int n= itr.next();
			if(!visited[n])
				DFSUtil(n, visited);
		}
	    
	}
	public static void main(String[] args) {


		DFSForDisconnectedGraphs dfs = new DFSForDisconnectedGraphs(6);
		
		dfs.addEdge(0, 1);
		dfs.addEdge(0, 2);
		dfs.addEdge(1, 2);
		dfs.addEdge(2, 0);
		dfs.addEdge(2, 3);
		dfs.addEdge(3, 3);
		dfs.addEdge(4, 4);
		dfs.addEdge(4, 5);
		
		dfs.isConnected();
	}

}
