


public class Main {


  public static void main(String[] args) {
    var p = test.createPoint(1, 2);
    System.out.println("Point: " + p.x + " " + p.y);
    test.mutatePoint(p, 3, 4);
    System.out.println(p.x + " " + p.y);
  }
}