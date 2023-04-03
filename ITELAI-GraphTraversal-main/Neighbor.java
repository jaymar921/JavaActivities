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


public class Neighbor {
     //---------------------------------------------------------------------
    // Attribute Definition.
    //---------------------------------------------------------------------
    //should have getters and setters
    Node node;

    //------------------------------------------------------------------------
    //  Method Name : Neighbor
    //  Description : Constructor. Initialize the need attributes.
    //  Arguments   : Node n
    //  Return      : void.
    //------------------------------------------------------------------------
    public Neighbor(Node n)
    {
        this.node = n;
    }
}