//------------------------------------------------------------------------
// 2023 IT-ELAI Introduction to AI
// Topic : Informed Search Algorithms
//------------------------------------------------------------------------
//
// File Name    :   Node.java
// Class Name:  :   Node 
// Stereotype   :   
//
// Node class:
//  Methods:
//      +AddNeighbors                   - adds a neighbor to the current node
//  Utility:
//  Attributes:
//      +name(string)                   - text name of a place
//      +parent(Node)                   - pointer to the parent
//      +isVisited(bool)                - visited status
//      +f                              - f(n) value
//      +g                              - g(n) value
//      +h                              - h(n) value
//      +neighbors(Linkedlist<Neighbor> - list of node's edges/neighbors

//------------------------------------------------------------------------
// Notes:
//   Comment character code - UTF-8.
//------------------------------------------------------------------------
//  Change Activities:
// tag  Reason   Ver  Rev Date       Author      Description.
//------------------------------------------------------------------------
// $000 -------  0.1  001 2023-03-25 cabrillosa  First Release.
// $001 -------  0.5  002 2023-04-29 cabrillosa  Added Greedy BFS and A*

import java.util.*;

public class Node implements Comparable<Node>{ //<-- implement Comparable interface for PQ

    //---------------------------------------------------------------------
    // Attribute Definition.
    //---------------------------------------------------------------------
    //better to have getters and setters
    public String name;
    public boolean isVisited;
    public Node parent;
    public float f = 0;
    public float h = 0;
    public float g = 0;
    public float latitude = 0;
    public float longitude = 0;

    public LinkedList<Neighbor> neighbors;
    
    public Node(String n)
    {
        //constructor
        this.name = n;
        this.isVisited = false;
        neighbors = new LinkedList<Neighbor>();
    }

    //------------------------------------------------------------------------
    //  Method Name : AddNeighbor
    //  Description : adds a neighbor to the current node
    //  Arguments   : Node n
    //                float d
    //  Return      : void
    //------------------------------------------------------------------------
    public void addNeighbor(Node n, float d)
    {
        Neighbor neighbor = new Neighbor(n, d);
        neighbors.add(neighbor);
    }

    //this is need for PQ when dealing with objects
    @Override
    public int compareTo(Node n){
        if(this.h > n.h) {
            return 1;
        } else if (this.h < n.h) {
            return -1;
        } else {
            return 0;
        }
    }
}
