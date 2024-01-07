


public class Main {

  public static boolean point_equals(Point p1, Point p2) {
    return p1.x == p2.x && p1.y == p2.y;
  }

  public static void main(String[] args) {
    var p1 = new Point(1, 2);
    var p2 = new Point(1, 2);
    System.out.println(point_equals(p1, p2));
    System.out.println(test.point_equals(p1, p2));
  }
}