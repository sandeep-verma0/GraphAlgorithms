package com.learnbycoding.graphAlgos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Back Edge : A back edge is an edge that is from a node to itself (selfloop) or one of its ancestor in the tree produced by DFS

 Depth First Traversal can be used to detect cycle in a Graph. DFS for a connected graph produces a tree. 
 There is a cycle in a graph only if there is a back edge present in the graph. 

 Keep track of the vertices already visited by DFS Traversal. While traversing further, 
 if we visit any of the vertex that is already visited then there is a back edge and hence there is cycle in the graph.
 */
public class CycleInDirectedGraph {

	int V;
	List<Integer> adjacencyList[];

	public CycleInDirectedGraph(int v) {
		this.V = v;
		adjacencyList = new List[v];
		for (int i = 0; i < v; ++i) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		adjacencyList[v].add(w);
	}

	boolean hasCycleUtil() {

		// Mark all node as visited as false and explored also as false
		boolean[] visited = new boolean[V];
		boolean[] explored = new boolean[V];

		// Check whether for each node there is cycle for not
		for (int k = 0; k < V; k++) {
			if (!visited[k])
				if (hasCycle(k, visited, explored)) {
					return true;
				}
		}
		return false;

	}

	// If node is visited previously and it is explored also then there is
	// surely a cycle
	// So we go through each univisited node and mark it as explored

	boolean hasCycle(int i, boolean[] visited, boolean[] explored) {

		visited[i] = true;
		explored[i] = true;

		// System.out.println("i is " + i);
		Iterator<Integer> itr = adjacencyList[i].iterator();
		while (itr.hasNext()) {
			int n = itr.next();
			if (!visited[n]) {
				if (hasCycle(n, visited, explored))
					return true;
			} else if (explored[n]) {
				return true;
			}
		}
		explored[i] = false;
		return false;
	}

	public static void main(String[] args) {
		CycleInDirectedGraph dfs = new CycleInDirectedGraph(4);
		dfs.addEdge(0, 1);
		//dfs.addEdge(0, 2);
		dfs.addEdge(1, 2);
		dfs.addEdge(2, 0);
		dfs.addEdge(2, 3);
		//dfs.addEdge(3, 3);

		System.out.println("Has Cycle : " + dfs.hasCycleUtil());

	}

}
