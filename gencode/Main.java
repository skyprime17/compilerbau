


public class Main {

  static class T {

    public T() {
    }
  }


  public static void main(String[] args) {
    var t = new T();
    T[] tArray = new T[] {new T(), t};
  }
}