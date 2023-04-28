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
//      +neighbors(Linkedlist<Neighbor> - list of node's edges/neighbors

//------------------------------------------------------------------------
// Notes:
//   Comment character code - UTF-8.
//------------------------------------------------------------------------
//  Change Activities:
// tag  Reason   Ver  Rev Date       Author      Description.
//------------------------------------------------------------------------
// $000 -------  0.1  001 2023-03-25 cabrillosa  First Release.
import java.util.*;

public class Node {

    //---------------------------------------------------------------------
    // Attribute Definition.
    //---------------------------------------------------------------------
    //better to have getters and setters
    public String name;
    public boolean isVisited;
    public Node parent;
    public LinkedList<Neighbor> neighbors;
    private Map<String, Double> heuristicMap;
    public double heuristic;
    
    public Node(String n)
    {
        //constructor
        this.name = n;
        this.isVisited = false;
        neighbors = new LinkedList<Neighbor>();
        heuristicMap = new HashMap<>();
    }

    //------------------------------------------------------------------------
    //  Method Name : AddNeighbor
    //  Description : adds a neighbor to the current node
    //  Arguments   : Node n
    //  Return      : void
    //------------------------------------------------------------------------
    public void addNeighbor(Node n)
    {
        Neighbor neighbor = new Neighbor(n);
        neighbors.add(neighbor);
    }

    public void addNeighbor(Node n, double d)
    {
        Neighbor neighbor = new Neighbor(n);
        neighbors.add(neighbor);
        heuristicMap.put(n.name, d);
    }

    public int heuristic(){
        return (int)(heuristic*1000);
    }

    public void updateHeuristicValue(String position){
        heuristic = heuristicMap.get(position);
    }

    public int getCost(String neighbor){
        return (int)(heuristicMap.get(neighbor)*1000);
    }
}
