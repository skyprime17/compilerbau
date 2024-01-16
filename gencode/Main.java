


public class Main {

  public static LinkedList make_linked_list() {
    return new LinkedList(1, null);
  }

  public static void main(String[] args) {
    LinkedList list = make_linked_list();
    System.out.println(list.value);
    System.out.println(list.next);
  }
}