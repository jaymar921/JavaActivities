public class MainDriver {
    public static void main(String[]args){
        GraphTraversal gt = new GraphTraversal();
        gt.addPlace("atlantic hardware");
        gt.addPlace("jollibee gaisano tabunok");
        gt.addPlace("tabunok");
        gt.addPlace("lagtang barangay hall");
        gt.addPlace("simbajon medical clinic");
        gt.addPlace("wilcon depot");
        gt.addPlace("robinsons supermarket");
        gt.addPlace("yahay foodpark");
        gt.addPlace("starmall talisay");
        
        gt.addPlace("j&t express");
        gt.addPlace("victoria's halo halo");
        gt.addPlace("montery school inc");
        gt.addPlace("cebu south medical center");
        gt.addPlace("paseo ricardo commercial center");

        gt.addPlace("gaisano capital srp");
        gt.addPlace("rex kandingan sa srp");
        gt.addPlace("rafael rabaya rd.");
        gt.addPlace("maglasang subd.");
        gt.addPlace("adelante pizza");
        gt.addPlace("yasco motor parts corporation");

        gt.addPlace("san roque");
        gt.addPlace("tanke");
        gt.addPlace("cansojong basketball gym");
        gt.addPlace("paz beach resort");
        gt.addPlace("sta. teresa de avila church");
        gt.addPlace("south covina");
        gt.addPlace("rafols resort");
        gt.addPlace("sao joseph fab & signage trading");
        gt.addPlace("cebu cardinal bakeshop");
        gt.addPlace("7-eleven dumlog");
        // gt.connect("F", "H");
        gt.connect("atlantic hardware", "jollibee gaisano tabunok", 0.383);
        gt.connect("jollibee gaisano tabunok", "tabunok", 0.34);
        gt.connect("jollibee gaisano tabunok", "j&t express", 0.41);
        gt.connect("tabunok", "j&t express", 0.25);
        gt.connect("tabunok", "lagtang barangay hall", 0.51);
        gt.connect("tabunok", "simbajon medical clinic", 0.35);
        gt.connect("simbajon medical clinic", "wilcon depot", 0.36);
        gt.connect("wilcon depot", "robinsons supermarket", 0.51);
        gt.connect("robinsons supermarket", "yahay foodpark", 0.33);
        gt.connect("yahay foodpark", "starmall talisay", 0.33);
        gt.connect("simbajon medical clinic", "victoria's halo halo", 0.54);
        gt.connect("victoria's halo halo", "j&t express", 0.28);
        gt.connect("victoria's halo halo", "montery school inc", 0.45);
        gt.connect("montery school inc", "cebu south medical center", 0.34);
        gt.connect("cebu south medical center", "yasco motor parts corporation", 0.29);
        gt.connect("j&t express", "paseo ricardo commercial center", 0.61);
        gt.connect("paseo ricardo commercial center", "rafael rabaya rd.", 0.132);

        gt.connect("gaisano capital srp", "rex kandingan sa srp", 0.35);
        gt.connect("gaisano capital srp", "san roque", 0.178);
        gt.connect("rex kandingan sa srp", "rafael rabaya rd.", 0.22);
        gt.connect("rafael rabaya rd.", "maglasang subd.", 0.34);
        gt.connect("rafael rabaya rd.", "tanke", 0.58);
        gt.connect("maglasang subd.", "cansojong basketball gym", 0.44);
        gt.connect("maglasang subd.", "adelante pizza", 0.61);
        gt.connect("adelante pizza", "yasco motor parts corporation", 0.9);
        gt.connect("yasco motor parts corporation", "starmall talisay", 2.02);

        gt.connect("yasco motor parts corporation", "7-eleven dumlog", 0.43);
        gt.connect("7-eleven dumlog", "sta. teresa de avila church", 1.19);
        gt.connect("7-eleven dumlog", "cebu cardinal bakeshop", 0.92);
        gt.connect("sta. teresa de avila church", "cansojong basketball gym", 1.22);
        gt.connect("cansojong basketball gym", "tanke", 0.515);
        gt.connect("san roque", "tanke", 0.67);
        gt.connect("cansojong basketball gym", "paz beach resort", 0.26);
        gt.connect("sta. teresa de avila church", "adelante pizza", 1.29);
        gt.connect("cebu cardinal bakeshop", "sao joseph fab & signage trading", 0.19);
        gt.connect("sao joseph fab & signage trading", "rafols resort", 0.27);
        gt.connect("rafols resort", "south covina", 0.31);
        gt.connect("south covina", "sta. teresa de avila church", 0.76);

        String origin = "starmall talisay";
        String goal = "atlantic hardware";
        System.out.println("ADJACENCY LIST");
        gt.displayAdjacencyList();
        System.out.println("\n\nOrigin: "+origin+"\nGoal: "+goal);
        System.out.println("\n");
        System.out.println("Breadth First Search");
        gt.breadthFirstSearch(origin, goal);
        
       
        
        System.out.println("\n\nDepth First Search");
        gt.depthFirstSearch("starmall talisay", "atlantic hardware");
        
        // It can sometimes get stuck! and idk why HAHAHA
        System.out.println("\n\nDepth First Search [RECURSIVE]");
        gt.depthFirstSearchRecursive("starmall talisay", "atlantic hardware");
        System.out.println("\n\nGreedy Best-First-Search");
        gt.GBFS(origin,goal);
        System.out.println("\n\nA* Algorithm");
        gt.Astar(origin,goal);
        //gt.breadthFirstSearch("A", "H");
        // gt.addPlace("Cebu");
        // gt.addPlace("Talisay");
        // gt.addPlace("Minglanilla");
        // gt.addPlace("Naga");
        // gt.addPlace("Mandaue");
        // gt.addPlace("Cordova");
        // gt.addPlace("Ubos sa 2nd bridge");


        // gt.connect("cebu", "talisay");
        // gt.connect("cebu", "Mandaue");
        // gt.connect("Ubos sa 2nd bridge", "Mandaue");
        // gt.connect("Ubos sa 2nd bridge", "Cordova");
        // gt.connect("cebu", "Cordova");
        // gt.connect("Minglanilla", "talisay");
        // gt.connect("Minglanilla", "Naga");

        // gt.displayAdjacencyList();

        // System.out.println("BFS");
        // gt.breadthFirstSearch("cebu", "Naga");

        // System.out.println("DFS");
        // gt.depthFirstSearch("cebu","Naga");
    }
}
