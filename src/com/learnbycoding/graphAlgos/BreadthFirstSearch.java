package com.learnbycoding.graphAlgos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {

	int V;
	List<Integer> adjacentList[];

	public BreadthFirstSearch(int v) {
		this.V = v;
		adjacentList = new List[v];
		for (int i = 0; i < v; ++i)
			adjacentList[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		adjacentList[v].add(w);
	}

	void BFS(int s) {

		// Mark all the vertices as not visited(By default
		// set as false)
		boolean[] visited = new boolean[V];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {

			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");

			Iterator<Integer> itr = adjacentList[s].iterator();

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			while (itr.hasNext()) {

				int n = itr.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

	}

	public static void main(String[] args) {

		BreadthFirstSearch bfs = new BreadthFirstSearch(4);
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal "
				+ "(starting from vertex 2)");
		bfs.BFS(2);
	}

}
