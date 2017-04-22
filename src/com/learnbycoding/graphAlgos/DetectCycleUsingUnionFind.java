package com.learnbycoding.graphAlgos;

public class DetectCycleUsingUnionFind {

	int V, E;    // V-> no. of vertices & E->no.of edges
    Edge edge[]; // /collection of all edges
 
    class Edge
    {
        int src, dest;
    };
 
    // Creates a graph with V vertices and E edges
    DetectCycleUsingUnionFind(int v,int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
    
    int find(int[] parent , int i)
    {
    	if(parent[i]==-1)
    		return i;
    	else
    		return
    			find(parent, parent[i]);
    }
    
    void union(int[] parent , int x , int y){
    	
    	int parentX= find(parent,x);
    	int parentY=find(parent, y);
    	
    	parent[parentX]=parentY;
    }
    
    int isCycle(DetectCycleUsingUnionFind graph){
    	
    	int parent[] = new int[graph.V];
    	
    	for(int i=0;i < graph.V;i++){
    		parent[i]=-1;
    	}
    	
    	for(int i=0;i<graph.E;i++){
    		int x= graph.find(parent, graph.edge[i].src);
    		int y=graph.find(parent, graph.edge[i].dest);
    		
    		if(x==y)
    			return 1;
    		
    		graph.union(parent, x, y);
    	}
    	return 0;
    }
	
	public static void main(String[] args) {
		 int V = 3, E = 3;
	        DetectCycleUsingUnionFind graph = new DetectCycleUsingUnionFind(V, E);
	 
	        // add edge 0-1
	        graph.edge[0].src = 0;
	        graph.edge[0].dest = 1;
	 
	        // add edge 1-2
	        graph.edge[1].src = 1;
	        graph.edge[1].dest = 2;
	 
	        // add edge 0-2
	        graph.edge[2].src = 0;
	        graph.edge[2].dest = 2;
	 
	        if (graph.isCycle(graph)==1)
	            System.out.println( "graph contains cycle" );
	        else
	            System.out.println( "graph doesn't contain cycle" );
	}

}
