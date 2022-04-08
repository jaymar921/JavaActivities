public class Months{
  public static void main(String... args){
    String input = "";

    System.out.println("Enter a month [jan,feb,mar,apr,may,june,july,aug,sep,oct,nov,dec]: ");
    input = new java.util.Scanner(System.in).next();
    
    switch(StringToNum(input)){
      case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        System.out.println("No of days: 31");
        break;
      case 2:
        System.out.println("No of days: 28");
        break;
      default:
        System.out.println("No of days: 30");
    }
  }

  private static int StringToNum(String str){
    if(str.contains("jan"))
      return 1;
    if(str.contains("feb"))
      return 2;
    if(str.contains("mar"))
      return 3;
    if(str.contains("apr"))
      return 4;
    if(str.contains("may"))
      return 5;
    if(str.contains("june"))
      return 6;
    if(str.contains("july"))
      return 7;
    if(str.contains("aug"))
      return 8;
    if(str.contains("sept"))
      return 9;
    if(str.contains("oct"))
      return 10;
    if(str.contains("nov"))
      return 11;
    if(str.contains("dec"))
      return 12;
    return -1;
  }
}