


public class Main {

  public static void change_point(Point p) {
    p.x = "hello";
  }

  public static void main(String[] args) {
    var s = new Point("a", 1);
    System.out.println(s.x);
    change_point(s);
    System.out.println(s.x);
    test.change_point(s);
    System.out.println(s.x);
  }
}