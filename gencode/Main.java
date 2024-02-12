


public class Main {



  public static Integer[] test_array() {
    Integer[] var0 = new Integer[]{1, 2, 3, 4, 5};
    return var0;
  }

  public static Integer test_array3() {
    Integer[] var0 = test_array();
    return var0[2];
  }

  public static Integer test4() {
    return test_array()[2];
  }

  public static void main(String[] args) {
    System.out.println(test.min(1, 2));
    System.out.println(test.max(1, 2));
    System.out.println(test.equals(1, 2));
    System.out.println(test.test_true());
    System.out.println(test.test_false());
    System.out.println(test.test_int());
    System.out.println(test.test_eq());
    System.out.println(test.test2());
    Integer[] arr = test.test_array();
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]);
    }
    System.out.println();
    System.out.println(test.test_array2());
    System.out.println(test.test_array());
  }
}