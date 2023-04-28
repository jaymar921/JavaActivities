//------------------------------------------------------------------------
// 2023 IT-ELAI Introduction to AI
// Topic : Informed Search Algorithms
//------------------------------------------------------------------------
//
// File Name    :   GraphTraversal.java
// Class Name:  :   GraphTraversal 
// Stereotype   :   
//
// GraphTraversal class:
//  Methods:
//      +addPlace                        - Add a place in string format.
//      +connect                         - Connect one vertex to another vertex.
//      +displayAdjacencyList            - Display adjacency list.
//      +breadthFirstSearch              - Traverse the map using BFS
//      +depththFirstSearch              - Traverse the map using DFS
//  Utility:
//      -getNodeByName                   - search the map using the string name
//      -reconstruct_path                - reconstruct the solution/path
//  Attributes:
//      -graph(LinkedList<Node>)         - Number of places/vertices in the map.

//------------------------------------------------------------------------
// Notes:
//   Comment character code - UTF-8.
//------------------------------------------------------------------------
//  Change Activities:
// tag  Reason   Ver  Rev Date       Author      Description.
//------------------------------------------------------------------------
// $000 -------  0.1  001 2023-03-25 cabrillosa  First Release.
import java.util.*;
import java.util.concurrent.atomic.*;
class GraphTraversal 
{
    //---------------------------------------------------------------------
    // Attribute Definition.
    //---------------------------------------------------------------------
    private LinkedList<Node> graph;

    //------------------------------------------------------------------------
    //  Method Name : GraphTraversal
    //  Description : Constructor. Initialize the need attributes.
    //  Arguments   : void.
    //  Return      : void.
    //------------------------------------------------------------------------
    public GraphTraversal()
    {
        graph = new LinkedList<Node>();
    }

    //------------------------------------------------------------------------
    //  Method Name : addPlace
    //  Description : Adds a place in string format.
    //  Arguments   : String place
    //  Return      : void
    //------------------------------------------------------------------------
    public void addPlace(String name) {
        Node newnode = new Node(name.toLowerCase());
        graph.add(newnode);
    }
    
    //------------------------------------------------------------------------
    //  Method Name : connect
    //  Description : Connect one vertex to another vertex.
    //  Arguments   : string v1
    //                string v2
    //                int dist
    //  Return      : 0 (OK)
    //               -1 (NG - place is not in the list)
    //------------------------------------------------------------------------

    public int connect(String place1, String place2) 
    {
        Node p1 = getNodeByName(place1.toLowerCase());
        Node p2 = getNodeByName(place2.toLowerCase());

        if(p1 == null || p2 == null) {
            System.out.println("Error: Could'nt find the places!");
            return -1;
        } else { /* nothing todo */ }

        p1.addNeighbor(p2);
        p2.addNeighbor(p1);

        return 0;
    }

    //------------------------------------------------------------------------
    //  Method Name : connect
    //  Description : Connect one vertex to another vertex.
    //  Arguments   : string v1
    //                string v2
    //                int dist
    //  Return      : 0 (OK)
    //               -1 (NG - place is not in the list)
    //------------------------------------------------------------------------

    public int connect(String place1, String place2, double distance) 
    {
        Node p1 = getNodeByName(place1.toLowerCase());
        Node p2 = getNodeByName(place2.toLowerCase());

        if(p1 == null || p2 == null) {
            System.out.println("Error: Could'nt find the places!");
            return -1;
        } else { /* nothing todo */ }

        p1.addNeighbor(p2, distance);
        p2.addNeighbor(p1, distance);

        return 0;
    }

    //------------------------------------------------------------------------
    //  Method Name : displayAdjacencyList
    //  Description : Display adjacency list.
    //  Arguments   : None.
    //  Return      : None.
    //------------------------------------------------------------------------
    public void displayAdjacencyList()
    {
        Iterator<Node> node_ite = graph.iterator();

        while(node_ite.hasNext()) {
            Node                n = node_ite.next(); //temp = temp.next
            Iterator<Neighbor>  neighbor_ite = n.neighbors.iterator();

            System.out.print(n.name +"::>");
            while(neighbor_ite.hasNext()) {
                Neighbor neighbor = neighbor_ite.next();
                System.out.print(neighbor.node.name + "->");
            }
            System.out.println();//print newline
        }
    }

    //------------------------------------------------------------------------
    //  Method Name : breadthFirstSearch
    //  Description : Traverse the map using BFS
    //  Arguments   : String s
    //                String g
    //  Return      : Void
    //------------------------------------------------------------------------
    public void breadthFirstSearch(String s, String g)
    {
        Queue<Node> q = new LinkedList<Node>();
        Node start_node = getNodeByName(s.toLowerCase());
        if(start_node == null) {
            System.out.println("Error: unable to find the string place!");
            return;
        } else {/*nothing todo */}

        q.add(start_node);
        
        start_node.isVisited = true;
        
        while(q.size() > 0) 
        {
            Node v = q.remove();

            if(v.name.equals(g.toLowerCase())) {
                reconstruct_path(v);
                //System.out.println("Found!");
                unvisit();
                return;
            }

            //System.out.print(v.name + "->");
            Iterator<Neighbor> neighbor_ite = v.neighbors.iterator();

            while(neighbor_ite.hasNext()){
                Neighbor neighbor = neighbor_ite.next();
                if( neighbor.node.isVisited != true)
                {
                    q.add(neighbor.node);
                    neighbor.node.parent = v;
                    neighbor.node.isVisited = true;
                }
            }
        }
        unvisit();
        //System.out.println();
        System.out.println("No solution!");
    }

    //------------------------------------------------------------------------
    //  Method Name : depththFirstSearch
    //  Description : Traverse the map using BFS
    //  Arguments   : String s
    //                String g
    //  Return      : Void
    //------------------------------------------------------------------------
    public void depthFirstSearch(String s, String g)
    {
        Stack<Node> st = new Stack<Node>();
        Node start_node = getNodeByName(s.toLowerCase());
        if(start_node == null) {
            System.out.println("Error: unable to find the string place!");
            return;
        } else {/*nothing todo */}

        st.push(start_node);
        
        start_node.isVisited = true;
        
        while(st.size() > 0) 
        {
            Node v = st.pop();

            if(v.name.equals(g.toLowerCase())) {
                reconstruct_path(v);
                //System.out.println("Found!");
                unvisit();
                return;
            }
            //System.out.print(v.name + "->");
            Iterator<Neighbor> neighbor_ite = v.neighbors.iterator();

            while(neighbor_ite.hasNext()){
                Neighbor neighbor = neighbor_ite.next();
                if( neighbor.node.isVisited != true)
                {
                    st.push(neighbor.node);
                    neighbor.node.parent = v;
                    neighbor.node.isVisited = true;
                }
            }
        }
        unvisit();
        System.out.println();
        System.out.println("No solution!");

    }

    //UTILITY FUNCTIONS

    //------------------------------------------------------------------------
    //  Method Name : getNodeByName
    //  Description : get the node by its name
    //  Arguments   : String name
    //  Return      : Node, if name is found
    //                null, if name is not found
    //------------------------------------------------------------------------
    public Node getNodeByName(String name) {
        

        Iterator<Node> node_ite = graph.iterator();

        while(node_ite.hasNext()) { // while(temp != null)
            Node n = node_ite.next(); // temp = temp.next
            
            //found
            if(n.name.equals(name)) {
                return n;
            }
        }

        return null;
    }

    //------------------------------------------------------------------------
    //  Method Name : unvisit
    //  Description : reconstruct the path from goal to start
    //  Arguments   : void
    //  Return      : Node, if name is found
    //                null, if name is not found
    //------------------------------------------------------------------------
    private void unvisit(){
        Iterator<Node> node_ite = graph.iterator();

        while(node_ite.hasNext()) {
            Node n = node_ite.next();
            n.isVisited = false;
        }
    }

    //------------------------------------------------------------------------
    //  Method Name : reconstruct_path
    //  Description : reconstruct the path from goal to start
    //  Arguments   : String lastnode
    //  Return      : Node, if name is found
    //                null, if name is not found
    //------------------------------------------------------------------------
    private void reconstruct_path(Node lastnode)
    {
        System.out.println("Reconstructing path.");
        LinkedList<Node> path = new LinkedList<Node>();
        while(lastnode != null) {
            path.addFirst(lastnode);
            lastnode = lastnode.parent; // move backward
        }
        
        Iterator<Node> node_ite = path.iterator();
        while(node_ite.hasNext()) {
            Node temp = node_ite.next();
            System.out.print(temp.name + "->");
        }

        System.out.println();
    }
    
    /*
        DFS-recursive(G, s):
        mark s as visited
        for all neighbours w of s in Graph G:
            if w is not visited:
                DFS-recursive(G, w)
    */
    
    public void depthFirstSearchRecursive(String s, String g){
      /*
      
        PSEUDOCODE
      
        DFS-recursive(G, s):
        mark s as visited
        for all neighbours w of s in Graph G:
            if w is not visited:
                DFS-recursive(G, w)
    */
      AtomicBoolean found = new AtomicBoolean(false);
      Node start = getNodeByName(s.toLowerCase());
      Node goal = getNodeByName(g.toLowerCase());
      
      if(start == null || goal == null){
         System.out.println("Path not found");
         return;
      }
      start.parent = null;
      goal.parent = null;
      
      //depthFirstSearchRecursive_helper(s,g, found); // calling the recursive function
      depthFirstSearchR_helper(start, goal, found);
      
      if(!found.get())
         System.out.println("No solution!");
      
      unvisit();          // unvisit all the nodes
    }
    
    public void depthFirstSearchR_helper(Node start, Node goal, AtomicBoolean found){
      
      
      if(start.isVisited && found.get())
         return;
      
      start.isVisited = true;
      
      if(start.name.equalsIgnoreCase(goal.name)) {
         System.out.println("Found in DFS_recursive!");
         reconstruct_path(start);
         found.set(true);
         return;
      }
      
      
      Iterator<Neighbor> n_ite = start.neighbors.iterator();
      while(n_ite.hasNext()){
         Node neighbor = n_ite.next().node;
         neighbor.parent = start;
         
         depthFirstSearchR_helper(neighbor,goal,found);
      }
      
      start.parent = null;
    }

    public void GBFS(String start_place, String goal_place){
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(Node::heuristic));
        HashSet<Node> closedList = new HashSet<>();
        
        Node starting_position = getNodeByName(start_place);
        starting_position.parent = null;

        openList.add(starting_position);
        while(!openList.isEmpty()){
            Node current = openList.poll();
            
            /*
            
            [DEBUGGING PURPOSE]
            
            System.out.println("\n========================");
            for(Node node : openList){
               System.out.println("Val: "+node.heuristic+"  | N: "+node.name+" ");
            }
            
            */

            if(current.name.equalsIgnoreCase(goal_place)){
                reconstruct_path_with_distance(current);
                return;
            }

            closedList.add(current);

            for(Neighbor neighborNode : current.neighbors){
                Node neighbor = neighborNode.node;

                if(closedList.contains(neighbor)){
                    continue;
                }

                if(!openList.contains(neighbor)){
                    neighbor.parent = current;

                    neighbor.updateHeuristicValue(current.name);
                    //neighbor.heuristic = current.heuristic;
                    
                    //System.out.println("Heuristic Value from "+neighbor.name+" to "+current.name+" is "+(neighbor.heuristic*1000)+"m");
                    openList.add(neighbor);
                }
            }
        }
    }
    
    
    public void Astar(String start_place, String goal_place){
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(Node::heuristic));
        HashSet<Node> closedList = new HashSet<>();
        HashMap<String, Integer> gValueMap = new HashMap<>();
            
        Node starting_position = getNodeByName(start_place);
        starting_position.parent = null;

        openList.add(starting_position);
        gValueMap.put(starting_position.name, 0);
        
        while(!openList.isEmpty()){
            Node current = openList.poll();
            
            if(current.name.equalsIgnoreCase(goal_place)){
                reconstruct_path_with_distance(current);
                return;
            }

            closedList.add(current);
            
            for(Neighbor neighborNode : current.neighbors){
                Node neighbor = neighborNode.node;

                int tentativeGValue = gValueMap.get(current.name) + current.getCost(neighbor.name);

                if(closedList.contains(neighbor)){
                    if(tentativeGValue >= gValueMap.get(neighbor.name))
                        continue;
                    closedList.remove(neighbor);
                }

                if(!openList.contains(neighbor) || tentativeGValue < gValueMap.get(neighbor.name)){
                    neighbor.parent = current;

                    neighbor.updateHeuristicValue(current.name);
                    //neighbor.heuristic = current.heuristic;
                    
                    //System.out.println("Heuristic Value from "+neighbor.name+" to "+current.name+" is "+(neighbor.heuristic*1000)+"m");
                    gValueMap.put(neighbor.name, tentativeGValue);
                    openList.add(neighbor);
                }
            }
            
        }

    }
    
    
    private void reconstruct_path_with_distance(Node lastnode)
    {
        System.out.println("Reconstructing path.");
        LinkedList<Node> path = new LinkedList<Node>();
        while(lastnode != null) {
            path.addFirst(lastnode);
            lastnode = lastnode.parent; // move backward
        }
        
        Iterator<Node> node_ite = path.iterator();
        System.out.printf("%15s %25s\n","Place", "Distance");
        int total = 0;
        while(node_ite.hasNext()) {
            Node temp = node_ite.next();
            String formatted_name = String.format("%-30s", temp.name);
            int distance = temp.parent!=null?temp.getCost(temp.parent.name):0;
            total+=distance;
            System.out.println("-> "+ formatted_name +" "+distance+"m");
        }
        
        System.out.printf("%15s %22dm | %.2fkm\n","TOTAL", total, (float)(total/1000.0f));

        System.out.println();
    }
    
   
}