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
        gt.connect("atlantic hardware", "jollibee gaisano tabunok");
        gt.connect("jollibee gaisano tabunok", "tabunok");
        gt.connect("jollibee gaisano tabunok", "j&t express");
        gt.connect("tabunok", "j&t express");
        gt.connect("tabunok", "lagtang barangay hall");
        gt.connect("tabunok", "simbajon medical clinic");
        gt.connect("simbajon medical clinic", "wilcon depot");
        gt.connect("wilcon depot", "robinsons supermarket");
        gt.connect("robinsons supermarket", "yahay foodpark");
        gt.connect("yahay foodpark", "starmall talisay");
        gt.connect("simbajon medical clinic", "victoria's halo halo");
        gt.connect("victoria's halo halo", "j&t express");
        gt.connect("victoria's halo halo", "montery school inc");
        gt.connect("montery school inc", "cebu south medical center");
        gt.connect("cebu south medical center", "yasco motor parts corporation");
        gt.connect("j&t express", "paseo ricardo commercial center");
        gt.connect("paseo ricardo commercial center", "rafael rabaya rd.");

        gt.connect("gaisano capital srp", "rex kandingan sa srp");
        gt.connect("gaisano capital srp", "san roque");
        gt.connect("rex kandingan sa srp", "rafael rabaya rd.");
        gt.connect("rafael rabaya rd.", "maglasang subd.");
        gt.connect("rafael rabaya rd.", "tanke");
        gt.connect("maglasang subd.", "cansojong basketball gym");
        gt.connect("maglasang subd.", "adelante pizza");
        gt.connect("adelante pizza", "yasco motor parts corporation");
        gt.connect("yasco motor parts corporation", "starmall talisay");

        gt.connect("yasco motor parts corporation", "7-eleven dumlog");
        gt.connect("7-eleven dumlog", "sta. teresa de avila church");
        System.out.println("Connected: "+gt.connect("7-eleven dumlog", "cebu cardinal bakeshop"));
        gt.connect("sta. teresa de avila church", "cansojong basketball gym");
        gt.connect("cansojong basketball gym", "tanke");
        gt.connect("san roque", "tanke");
        gt.connect("cansojong basketball gym", "paz beach resort");
        gt.connect("sta. teresa de avila church", "adelante pizza");
        gt.connect("cebu cardinal bakeshop", "sao joseph fab & signage trading");
        gt.connect("sao joseph fab & signage trading", "rafols resort");
        gt.connect("rafols resort", "south covina");
        gt.connect("south covina", "sta. teresa de avila church");

        String origin = "adelante pizza";
        String goal = "atlantic hardware";
        
        System.out.println("ADJACENCY LIST");
        gt.displayAdjacencyList();
        System.out.println("\n\nOrigin: "+origin+"\nGoal: "+goal);
        
        System.out.println("\n");
        System.out.println("Breadth First Search\nTRAVERSAL");
        gt.breadthFirstSearch(origin, goal);
        
        
        
        System.out.println("\n\nDepth First Search\nTRAVERSAL");
        gt.depthFirstSearch(origin, goal);
        
        // It can sometimes get stuck! and idk why HAHAHA
        System.out.println("\n\nDepth First Search [RECURSIVE]");
        gt.depthFirstSearchRecursive(origin, goal);
        
        
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