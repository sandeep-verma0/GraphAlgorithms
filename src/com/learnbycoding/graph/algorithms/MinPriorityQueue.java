package com.learnbycoding.graph.algorithms;

import com.learnbycoding.graph.algorithms.DijkstraWithPriorityQueue.Node;
import com.learnbycoding.graph.algorithms.DijkstraWithPriorityQueue.State;
import com.learnbycoding.undirectedgraph.Graph;

public class MinPriorityQueue {
    Node[] queue;
    int maxSize;
    int rear = -1, front = -1;

    MinPriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new Node[maxSize];
    }

    public void add(Node node) {
        queue[++rear] = node;
    }

    public Node remove() {
        Node minValuedNode = null;
        int minValue = Integer.MAX_VALUE;
        int minValueIndex = -1;
        front++;
        for (int i = front; i <= rear; i++) {
            if (queue[i].state == State.IN_Q && queue[i].cost < minValue) {
                minValue = queue[i].cost;
                minValuedNode = queue[i];
                minValueIndex = i;
            }
        }

        swap(front, minValueIndex); // this ensures deletion is still done
                                    // from front;
        queue[front] = null;// lets not hold up unnecessary references in
                            // the queue
        return minValuedNode;
    }

    public void swap(int index1, int index2) {
        Node temp = queue[index1];
        queue[index1] = queue[index2];
        queue[index2] = temp;
    }

    public boolean isEmpty() {
        return front == rear;
    }


public static void main(String[] args) {
	DijkstraWithPriorityQueue graph = new DijkstraWithPriorityQueue(11);
    graph.addEdge(1, 3, 1);
    graph.addEdge(1, 2, 3);
    graph.addEdge(2, 5, 5);
    graph.addEdge(2, 4, 3);
    graph.addEdge(3, 5, 8);
    graph.addEdge(3, 6, 5);
    graph.addEdge(4, 5, 1);
    graph.addEdge(4, 7, 10);
    graph.addEdge(5, 6, 2);
    graph.addEdge(5, 8, 8);
    graph.addEdge(5, 7, 2);
    graph.addEdge(6, 8, 15);
    graph.addEdge(7, 8, 5);
    graph.addEdge(9, 11, 2);
    graph.computeSortestPathsFrom(1);
}
}