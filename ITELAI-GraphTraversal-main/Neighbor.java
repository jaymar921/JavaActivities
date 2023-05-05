//------------------------------------------------------------------------
// 2023 IT-ELAI Introduction to AI
// Topic : Informed Search Algorithms
//------------------------------------------------------------------------
//
// File Name    :   Neighbor.java
// Class Name:  :   Edge 
// Stereotype   :   
//
// Edge class:
//  Methods:
//  Utility:w
//  Attributes:
//      +node(Node)          - Node connected to the parent

//------------------------------------------------------------------------
// Notes:
//   Comment character code - UTF-8.
//------------------------------------------------------------------------
//  Change Activities:
// tag  Reason   Ver  Rev Date       Author      Description.
//------------------------------------------------------------------------
// $000 -------  0.1  001 2023-03-25 cabrillosa  First Release.
// $001 -------  0.5  002 2023-04-29 cabrillosa  Added Greedy BFS and A*


public class Neighbor {
     //---------------------------------------------------------------------
    // Attribute Definition.
    //---------------------------------------------------------------------
    //should have getters and setters
    Node node;

    float distance;

    //------------------------------------------------------------------------
    //  Method Name : Neighbor
    //  Description : Constructor. Initialize the need attributes.
    //  Arguments   : Node n
    //                float d
    //  Return      : void.
    //------------------------------------------------------------------------
    public Neighbor(Node n, float d)
    {
        this.node = n;
        this.distance = d;
    }
}
