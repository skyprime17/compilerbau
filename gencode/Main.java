

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Integer[] arr = {1, 2, 3, 4, 5};
    System.out.println(Arrays.toString(arr));
    test.reverse(arr);
    System.out.println(Arrays.toString(arr));
    Integer[] arr2 = {1, 5, 3, 4, 2};
    Integer[] arr3 = {1, 5, 3, 4, 2};
    test.bubbleSort(arr2);
    System.out.println(Arrays.toString(arr2));

    test.quickSort(arr3, 0, arr2.length - 1);
    System.out.println(Arrays.toString(arr2));

    LinkedList l2 = test.addNodeToTail(test.createNode(1), 2);
    System.out.println(l2);
    for (LinkedList i = l2; i != null; i = i.next) {
      System.out.println("LinkedList value: " + i.value + " next: " + i.next);
    }

  }
}