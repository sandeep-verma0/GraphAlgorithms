package com.learnbycoding.graph.algorithms;

public class UnionFindAlgorithmToDetectCycle {

	
	int V, E; // V-> no. of vertices & E->no.of edges
	Edge edge[]; // /collection of all edges

	class Edge {
		int src;
		int dest;
	}

	UnionFindAlgorithmToDetectCycle(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}

	int find(int[] parent, int x) {
		if (parent[x] == -1)
			return x;
		else
			return find(parent, parent[x]);
	}

	void union(int[] parent, int x, int y) {
		int xSet = find(parent, x);
		int ySet = find(parent, y);

		parent[xSet] = ySet;

	}

	int isCycle(UnionFindAlgorithmToDetectCycle g){
		 int parent[] = new int[V];
		for(int i=0;i<V;i++)
			parent[i]=-1;
		
		for(int i=0;i<E;i++){
			
			int x= find(parent , g.edge[i].src);
			int y= find(parent , g.edge[i].dest);
			
			if(x==y)
				return 1;
			else 
				union(parent, x, y);
		}
		
		return 0;
	}
	
	  public static void main (String[] args)
	    {
	        /* Let us create following graph
	         0
	        |  \
	        |   \
	        1-----2 */
	        int V = 3, E = 3;
	        UnionFindAlgorithmToDetectCycle graph = new UnionFindAlgorithmToDetectCycle(V, E);
	 
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
