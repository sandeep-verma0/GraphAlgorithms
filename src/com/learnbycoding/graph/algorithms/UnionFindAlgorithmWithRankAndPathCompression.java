package com.learnbycoding.graph.algorithms;

public class UnionFindAlgorithmWithRankAndPathCompression {
	int V, E; // V-> no. of vertices & E->no.of edges
	Edge edge[]; // /collection of all edges

	class Edge {
		int src;
		int dest;
	}
	
	UnionFindAlgorithmWithRankAndPathCompression(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i)
			edge[i] = new Edge();
	}
	
	class Subset{
		int parent;
		int rank;
	}
	
	int find(Subset subsets[] , int x){
		
		if(subsets[x].parent !=x)
			subsets[x].parent = find(subsets, subsets[x].parent);
		
		return subsets[x].parent;
	}
	
	void union(Subset subsets[] , int x , int y){
		
		int xRoot = find(subsets, x);
		int yRoot = find(subsets, y);
		if(subsets[xRoot].rank < subsets[yRoot].rank)
			subsets[xRoot].parent = yRoot;
		
		else if(subsets[xRoot].rank > subsets[yRoot].rank)
			subsets[yRoot].parent = xRoot;
		
		else {
			subsets[yRoot].parent = xRoot;
			subsets[xRoot].rank++;
		}
	}
	
	int isCycle(UnionFindAlgorithmWithRankAndPathCompression g){
		
		Subset subset[] = new Subset[g.V];
		for(int i=0;i< g.V;i++){
			subset[i].parent=i;
			subset[i].rank=0;
		}
		
		for(int i=0;i<g.E;i++){
		int x= g.find(subset, g.edge[i].src);
		int y= g.find(subset, g.edge[i].dest);
		
		if(x==y)
			return 1;
	   
		union(subset, x, y);
				
		}
		return 0;
	}
	
	
	 // Driver Method
    public static void main (String[] args)
    {
        /* Let us create following graph
         0
        |  \
        |    \
        1-----2 */
        int V = 3, E = 3;
        UnionFindAlgorithmWithRankAndPathCompression graph = new UnionFindAlgorithmWithRankAndPathCompression(V, E);
 
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
