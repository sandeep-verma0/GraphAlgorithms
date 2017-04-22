package com.learnbycoding.graphAlgos;

import java.util.LinkedList;

public class Bipartite {
	
	int V=4;
	
	public boolean isBipartite(int G[][] , int src){
		
		int colour[] = new int[V];
		
		for(int i=0;i< V ;i++)
			colour[i]=-1;
		
		colour[src]=1;
		
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(src);
		
		while(!q.isEmpty()){
			
			int t=q.poll();
			
			for(int k=0;k<V;k++){
				
				if(G[t][k]==1 && colour[k]==-1)
				{
					colour[k]=1-colour[t];
					q.add(k);
				}
				else if(G[t][k]==1 && colour[k]==colour[t])
					return false;
			}
		}
		return true;
	}
	
	
public static void main(String[] args) {
	int G[][] = {{0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };
        Bipartite b = new Bipartite();
        if (b.isBipartite(G, 0))
           System.out.println("Yes");
        else
           System.out.println("No");
}
}
