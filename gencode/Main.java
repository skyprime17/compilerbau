


public class Main {


  public static class T {
    private String s;
    private int i;

    public T(String s, int i) {
      this.s = s;
      this.i = i;
    }

    @java.lang.Override
    public java.lang.String toString() {
      return "T{" +
          "s='" + s + '\'' +
          ", i=" + i +
          '}';
    }
  }

  public static LinkedList make_linked_list() {
    return new LinkedList(1, null);
  }

  public static void main(String[] args) {
    System.out.println(new T("a", 12));
  }
}