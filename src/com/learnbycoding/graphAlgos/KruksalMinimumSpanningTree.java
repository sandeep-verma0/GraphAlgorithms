package com.learnbycoding.graphAlgos;

import java.util.Arrays;

public class KruksalMinimumSpanningTree {

	class Edge implements Comparable<Edge> {
		int src, dest, weight;

		@Override
		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	}

	class Subset {
		int parent, rank;
	}

	int V, E;
	Edge edge[];

	KruksalMinimumSpanningTree(int V, int E) {
		this.V = V;
		this.E = E;
		edge = new Edge[E];
		for (int i = 0; i < E; i++)
			edge[i] = new Edge();
	}

	int find(Subset subsets[], int i) {

		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}

	void Union(Subset subset[], int x, int y) {

		int xRoot = find(subset, x);
		int yRoot = find(subset, y);

		if (subset[xRoot].rank > subset[yRoot].rank)
			subset[yRoot].parent = xRoot;

		else if (subset[xRoot].rank < subset[yRoot].rank)
			subset[xRoot].parent = yRoot;

		else {

			subset[xRoot].parent = yRoot;
			subset[xRoot].rank++;
		}
	}

	void KruskalMST() {
		Edge[] result = new Edge[V];  // This will store the resultant MST

		int e = 0;
		int i = 0;

		for (i = 0; i < V; i++)
			result[i] = new Edge();

		 // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
		Arrays.sort(edge);

		// Allocate memory for creating V subsets
		Subset subsets[] = new Subset[V];
		for (i = 0; i < V; ++i)
			subsets[i] = new Subset();

		// Create V subsets with single elements
		for (int v = 0; v < V; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		i = 0; // Index used to pick next edge

		while (e < V - 1) {

			Edge next_edge = new Edge();
			next_edge = edge[i++];

			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);

			if (x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}
		}

		System.out.println("Following are the edges in the constructed MST");
		for (i = 0; i < e; ++i)
			System.out.println(result[i].src + " -- " + result[i].dest + " == "
					+ result[i].weight);

	}

	public static void main(String[] args) {
		 /* Let us create following weighted graph
        10
   		0--------1
   		|  \     |
  	   6|   5\  |15
   		|      \ |
   		2--------3
       4       */
		int V = 4; // Number of vertices in graph
		int E = 5; // Number of edges in graph
		KruksalMinimumSpanningTree graph = new KruksalMinimumSpanningTree(V, E);

		// add edge 0-1
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = 10;

		// add edge 0-2
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 6;

		// add edge 0-3
		graph.edge[2].src = 0;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = 5;

		// add edge 1-3
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 15;

		// add edge 2-3
		graph.edge[4].src = 2;
		graph.edge[4].dest = 3;
		graph.edge[4].weight = 4;

		graph.KruskalMST();
	}
}
