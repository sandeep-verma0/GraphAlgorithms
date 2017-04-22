package com.learnbycoding.graph.algorithms;

public class DijkstraWithPriorityQueue {

    private Node[] vertices; // stores the nodes of the graph
    private int size; // number of nodes in the graph
    private MinPriorityQueue queue;

    public DijkstraWithPriorityQueue(int size) {
        this.size = size;
        vertices = new Node[size];
        addNodes();
        queue = new MinPriorityQueue(size);
    }

    public class Node {
        int name;
        int cost;
        Neighbour neighbourList;
        State state;

        Node(int name) {
            this.name = name;
            state = State.NEW;
            cost = Integer.MAX_VALUE;
        }
    }

    public class Neighbour {
        int index;
        int weight;
        Neighbour next;

        public Neighbour(int index, Neighbour next, int weight) {
            this.index = index;
            this.next = next;
            this.weight = weight;
        }
    }

    private void addNodes() {
        for (int i = 1; i <= size; i++) {
            addNode(i);
        }
    }

    public void addNode(int name) {
        vertices[name - 1] = new Node(name);
    }

    public void addEdge(int sourceName, int destiName, int weight) {
        int srcIndex = sourceName - 1;
        int destiIndex = destiName - 1;
        Node srcNode = vertices[srcIndex];
        Node destiNode = vertices[destiIndex];
        srcNode.neighbourList = new Neighbour(destiIndex, srcNode.neighbourList, weight);
        // the graph is non directional so if from S, D is reachable then vice
        // versa is also true
        destiNode.neighbourList = new Neighbour(srcIndex, destiNode.neighbourList, weight);
    }

    public void computeSortestPathsFrom(int sourceNodeName) {
        for (int i = 0; i < size; i++) {
            if (vertices[i].name == sourceNodeName) {
                applyDijkstraAlgorithm(vertices[i]);
                break;// in this case we need not traverse the nodes which are
                        // not reachable from the source Node
            }
        }
    }

    /**
     * The algorithm is based upon BFS.
     */
    private void applyDijkstraAlgorithm(Node sourceNode) {
        queue.add(sourceNode);
        sourceNode.state = State.IN_Q;
        sourceNode.cost = 0; // cost of reaching Source from Source Node itself
                                // is 0, for all others we still need to
                                // discover the cost so the cost for them has
                                // been already initialized to Integer.MAX_VALUE
        while (!queue.isEmpty()) {
            Node visitedNode = queue.remove();
            visitedNode.state = State.VISITED;
            Neighbour connectedEdge = visitedNode.neighbourList;
            while (connectedEdge != null) {
                Node neighbour = vertices[connectedEdge.index];
                // adding the not enqued neighbor nodes in the queue
                if (neighbour.state == State.NEW) {
                    queue.add(neighbour);
                    neighbour.state = State.IN_Q;
                }
                // updating [relaxing] the costs of each non visited neighbor
                // node if its
                // have been made lesser.
                if (neighbour.state != State.VISITED && ((connectedEdge.weight + visitedNode.cost) < neighbour.cost)) {
                    neighbour.cost = connectedEdge.weight + visitedNode.cost;
                }
                connectedEdge = connectedEdge.next;
            }
        }
        
        //now printing the shortest distances
        for(int i = 0; i < size; i++){
            if(vertices[i].cost != Integer.MAX_VALUE){
                System.out.println("distance from "+sourceNode.name +" to "+vertices[i].name+" is " +vertices[i].cost);
            }else{
                System.out.println(vertices[i].name +" is not reachable from "+sourceNode.name);
            }
        }
    }

    public enum State {
        NEW, IN_Q, VISITED
    };
}