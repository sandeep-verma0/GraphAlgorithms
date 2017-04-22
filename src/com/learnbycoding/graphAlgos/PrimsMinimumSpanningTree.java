package com.learnbycoding.graphAlgos;

public class PrimsMinimumSpanningTree {

	int V=5;
	
	// A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
	int minKey(int key[] , boolean mstSet[]){
		
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=0;i<V;i++){
			if(mstSet[i]==false && key[i] < min){
				min = key[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
	
	
	 // Function to construct and print MST for a graph represented
    //  using adjacency matrix representation
    void primMST(int graph[][]){
    	
    	int parent[] = new int[V];
    	
    	int key[] = new int[V];
    	
    	boolean mstSet[]= new boolean[V];
    	
    	for(int i=0;i<V;i++){
    		key[i]=Integer.MAX_VALUE; 
    		mstSet[i]=false;
    	}
    	
    	
    	key[0]=0;
    	parent[0]=-1;
    	
    	for(int count=0;count<V-1;count++){
    		
    		int u=minKey(key, mstSet);
    		
    		mstSet[u]=true;
    		
    		for(int v=0;v<V;v++){
    			if(graph[u][v]!=0 && mstSet[v]==false && graph[u][v] < key[v])
    			{
    				parent[v]=u;
    				key[v]=graph[u][v];
    			}	
    		}
    	}
    	
    	  // print the constructed MST
        printMST(parent, V, graph);
    }
	
    // A utility function to print the constructed MST stored in
    // parent[]
    void printMST(int parent[], int n, int graph[][])
    {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i]+" - "+ i+"    "+
                               graph[i][parent[i]]);
    }
	
	
	public static void main(String[] args) {

		PrimsMinimumSpanningTree t = new PrimsMinimumSpanningTree();
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0},
                                   };
 
        // Print the solution
        t.primMST(graph);
		
	}

}
