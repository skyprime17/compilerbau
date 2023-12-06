


public class Main {
  public static int compare(int a, int b) {
    if (a > b) {
      return 1;
    } else {
      return 0;
    }
  }
  public static void test2() {
    if (compare(1, 2) == 1) {
      System.out.println("Hello World!");
    } else {
      System.out.println("2");
    }
  }
}