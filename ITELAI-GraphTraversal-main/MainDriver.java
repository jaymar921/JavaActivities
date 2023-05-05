public class MainDriver {
    public static void main(String[]args){
        GraphTraversal gt = new GraphTraversal();

            gt.addPlace("atlantic hardware", 10.268354432988096, 123.84371926010935);
            gt.addPlace("jollibee gaisano tabunok", 10.265630715520413, 123.8417666120147);
            gt.addPlace("tabunok", 10.263561519104673, 123.83944918341606);
            gt.addPlace("lagtang barangay hall", 10.266052998805462, 123.83539368352713);
            gt.addPlace("simbajon medical clinic", 10.26166122472484, 123.83693863571521);
            gt.addPlace("wilcon depot", 10.260521042658501, 123.834084765423);
            gt.addPlace("robinsons supermarket", 10.259423085653145, 123.8298790616412);
            gt.addPlace("yahay foodpark", 10.258916334983434, 123.82666041086829);
            gt.addPlace("starmall talisay", 10.258620730051595, 123.82369925216679);                 // must have custom distance to yasco               == 2.02km
            gt.addPlace("j&t express", 10.262230607210903, 123.841306944075);                        // must have custom distance to victoria's          == 0.27km
            gt.addPlace("victoria's halo halo", 10.260752595248753, 123.84055592544144);             // must have custom distance to simbajon            == 0.54km
            gt.addPlace("montery school inc", 10.256740813821498, 123.83980490694348);
            gt.addPlace("cebu south medical center", 10.253721386787959, 123.83845307360522);        // must have custom distance to yasco               == 0.29km
            gt.addPlace("yasco motor parts corp", 10.252158874795047, 123.83989073754957);           // must have custom distance to 7/11                == 0.45km
            gt.addPlace("7/11 dumlog", 10.249054943073022, 123.83909680370888);
            gt.addPlace("cebu cardinal bakeshop", 10.24084099059728, 123.83989073754583);
            gt.addPlace("sao joseph fab & signage trading", 10.239088371588307, 123.84012677198781); // must have custom distance to rafols resort       == 0.27km
            gt.addPlace("rafols resort", 10.237356859043613, 123.84094216349986);                    // must have custom distance to south covina        == 0.30km
            gt.addPlace("south covina", 10.23904613968746, 123.84287335392315);
            gt.addPlace("sta. teresa de avila church", 10.243818308895287, 123.84761549929597);
            gt.addPlace("adelante pizza", 10.251454399060757, 123.84810421142203);                   // must have custom distance to sta. teresa church  == 1.29km | cansojong gym == 1.22km  | maglasang == 0.67km
            gt.addPlace("cansojong basketball gym", 10.250205474819978, 123.85641647417874);         // must have custom distance to maglasang           == 0.48km
            gt.addPlace("paz beach resort", 10.247903908730619, 123.85755373076137);
            gt.addPlace("maglasang subd.", 10.24084099059728, 123.83989073754583);                   // must have custom distance to rafael rabaya rd.   == 0.43km
            gt.addPlace("tanke", 10.251103854691042, 123.8605836648895);                             // must have custom distance to cansojong gym       == 0.51km | san roque     == 0.67km
            gt.addPlace("rafael rabaya rd.", 10.253338662175727, 123.85650084641514);
            gt.addPlace("san roque", 10.25598310467346, 123.86034407131581);                      
            gt.addPlace("rex kandingan sa srp", 10.254758442548468, 123.85779060842277);
            gt.addPlace("gaisano capital srp", 10.257249991542832, 123.85987200254567);
            gt.addPlace("paseo ricardo commercial center", 10.259530375194347, 123.84611763478024);


            gt.connect("atlantic hardware", "jollibee gaisano tabunok");
            gt.connect("jollibee gaisano tabunok", "tabunok");
            gt.connect("j&t express", "jollibee gaisano tabunok");
            gt.connect("j&t express", "tabunok");
            gt.connect("tabunok", "lagtang barangay hall");
            gt.connect("tabunok", "simbajon medical clinic");
            gt.connect("simbajon medical clinic", "victoria's halo halo", 0.54f);
            gt.connect("victoria's halo halo", "j&t express", 0.27f);
            gt.connect("victoria's halo halo", "montery school inc");
            gt.connect("simbajon medical clinic", "wilcon depot");
            gt.connect("wilcon depot", "robinsons supermarket");
            gt.connect("robinsons supermarket", "yahay foodpark");
            gt.connect("yahay foodpark", "starmall talisay");
            gt.connect("starmall talisay", "yasco motor parts corp", 2.02f);
            gt.connect("montery school inc", "cebu south medical center");
            gt.connect("cebu south medical center", "yasco motor parts corp", 0.29f);
            gt.connect("yasco motor parts corp", "7/11 dumlog", 0.45f);
            gt.connect("7/11 dumlog", "cebu cardinal bakeshop");
            gt.connect("7/11 dumlog", "sta. teresa de avila church");
            gt.connect("cebu cardinal bakeshop", "sao joseph fab & signage trading");
            gt.connect("sao joseph fab & signage trading", "rafols resort", 0.27f);
            gt.connect("rafols resort", "south covina", 0.30f);
            gt.connect("south covina", "sta. teresa de avila church");
            gt.connect("adelante pizza", "sta. teresa de avila church", 1.29f);
            gt.connect("adelante pizza", "cansojong basketball gym", 1.22f);
            gt.connect("adelante pizza", "maglasang subd.", 0.67f);
            gt.connect("maglasang subd.", "cansojong basketball gym", 0.48f);
            gt.connect("sta. teresa de avila church", "cansojong basketball gym");
            gt.connect("cansojong basketball gym", "paz beach resort");
            gt.connect("cansojong basketball gym", "tanke", 0.51f);
            gt.connect("tanke", "san roque", 0.67f);
            gt.connect("san roque", "gaisano capital srp");
            gt.connect("gaisano capital srp", "rex kandingan sa srp");
            gt.connect("rex kandingan sa srp", "rafael rabaya rd.");
            gt.connect("rafael rabaya rd.", "tanke");
            gt.connect("rafael rabaya rd.", "maglasang subd.", 0.43f);
            gt.connect("rafael rabaya rd.", "paseo ricardo commercial center");
            gt.connect("paseo ricardo commercial center", "j&t express");
            
            String starting_place = "lagtang barangay hall";
            String goal_place = "rafols resort";
            System.out.println("\n    Greedy Best-First-Search result:");
            gt.greedyBestFirstSearch(starting_place, goal_place);
            
            System.out.println("\n    A* result:");
            gt.aStar(starting_place, goal_place);

    }
}
