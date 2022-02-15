//Circle class has an instance of Point class
/*
 Abejar, Jayharron Mar C.
 BSIT - 2 OOPROG21

 Write a program that accepts 4 values(x1,y1,x2,y2) representing two points on a circle
 Compute the distance between two points, let distance represent the radius of a circle.
 Then given that radius, compute the area, diameter and circumference of
 the circle
 To compute the distance: use Euclidean distance formula
*/
import java.text.DecimalFormat;
public class Circle{

	private Point p1;
	private Point p2;


	public Circle(Point p1, Point p2){
		this.p1 = p1;
		this.p2 = p2;
		}
	public Circle(int x1, int y1, int x2, int y2){
		this(new Point(x1,y1), new Point(x2,y2));
		}

	public Circle(){
		this(0,0,0,0);
		}

	public void setP1(Point p1){this.p1 = p1;}
	public void setP2(Point p2){this.p2 = p2;}
	public Point getP1(){return p1;}
	public Point getP2(){return p2;}

	public String toString(){
		return p1 + " " + p2;
		}

     //distance
     public double getDistance(){
     //attributes
     //base on my own logic, I did it this way, getting the x and y elements in the point1 & point2 class
         int x1 = p1.getX();
         int x2 = p2.getX();
         int y1 = p1.getY();
         int y2 = p2.getY();
         double distance = 0;
         
         //I am using the euclidean formula, getting the radius is to get the distance
         distance = ((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2));
         distance = Math.pow(distance, 0.5); //using Math.pow to get the square root of distance
         return distance;
     }
     //diameter
     public double getDiameter(double distance){
         return 2*distance; //multiply distance by 2 to get diameter
     }
     //area
     public double getArea(double radius){
         final double Pi = 3.141592653589793; //instantiate Pi.. I know there is Math.Pi but I'll just use this for now
         return Pi * (radius * radius); //multiply Pi by radius^2 to get the area
     }
     //circumference
     public double getCircumference(double radius){
         final double Pi = 3.141592653589793;
         return 2 * Pi * radius; //multiply Pi, radius and 2 to get circumference
     }

    public static void main(String [] args){
          DecimalFormat fmt = new DecimalFormat("#.###");
          Circle circle = new Circle(3,4,4,5); // here I put circle 3,4,4,5 which is point 1 is (3,4) while point 2 is (4,5)
       /*
          Point p1;
          Point p2;
            //If you want an input, remove the block comment
            System.out.print("Point1\nEnter X1: ");
            int x1 = new java.util.Scanner(System.in).nextInt();
            System.out.print("Enter Y1: ");
            int y1 = new java.util.Scanner(System.in).nextInt();
            circle.setP1(new Point(x1,y1));
            System.out.print("Point2\nEnter X2: ");
            int x2 = new java.util.Scanner(System.in).nextInt();
            System.out.print("Enter Y2: ");
            int y2 = new java.util.Scanner(System.in).nextInt();
            circle.setP2(new Point(x2,y2));
         */
          //here is the display
          System.out.println("Point1: "+circle.p1);
          System.out.println("Point2: "+circle.p2);
          System.out.println("Distance: " + fmt.format(circle.getDistance()));
          System.out.println("Diameter: " + fmt.format(circle.getDiameter(circle.getDistance())));
          System.out.println("Area:     " + fmt.format(circle.getArea(circle.getDistance())));
          System.out.println("Circumference: " + fmt.format(circle.getCircumference(circle.getDistance())));
		}
	}