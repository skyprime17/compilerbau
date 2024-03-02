import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;

import org.compilerbau.Main;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestInteger {

  @BeforeAll
  public static void setUp() throws Exception {
    Main.compile("build/classes/java/test/", new FileReader("src/test/resources/integer.gr"));
    System.out.println("TestInteger.setUp");
  }

  @Test
  public void testAdd() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Integer.valueOf(3),
        Class.forName("intTest").getMethod("add", Integer.class, Integer.class).invoke(null, Integer.valueOf(1),
            Integer.valueOf(2)));

    assertEquals(Integer.valueOf(3),
        Class.forName("intTest").getMethod("add", Integer.class, Integer.class).invoke(null, Integer.valueOf(-2),
            Integer.valueOf(5)));
  }

  @Test
  public void testSub() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Integer.valueOf(1),
        Class.forName("intTest").getMethod("sub", Integer.class, Integer.class).invoke(null, Integer.valueOf(3),
            Integer.valueOf(2)));

    assertEquals(Integer.valueOf(-7),
        Class.forName("intTest").getMethod("sub", Integer.class, Integer.class).invoke(null, Integer.valueOf(-2),
            Integer.valueOf(5)));
  }

  @Test
  public void testMul() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Integer.valueOf(6),
        Class.forName("intTest").getMethod("mul", Integer.class, Integer.class).invoke(null, Integer.valueOf(3),
            Integer.valueOf(2)));

    assertEquals(Integer.valueOf(-10),
        Class.forName("intTest").getMethod("mul", Integer.class, Integer.class).invoke(null, Integer.valueOf(-2),
            Integer.valueOf(5)));
  }

  @Test
  public void testDiv() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Integer.valueOf(3),
        Class.forName("intTest").getMethod("div", Integer.class, Integer.class).invoke(null, Integer.valueOf(6),
            Integer.valueOf(2)));

    assertEquals(Integer.valueOf(-2),
        Class.forName("intTest").getMethod("div", Integer.class, Integer.class).invoke(null, Integer.valueOf(-10),
            Integer.valueOf(5)));
  }

  @Test
  public void testMod() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Integer.valueOf(1),
        Class.forName("intTest").getMethod("mod", Integer.class, Integer.class).invoke(null, Integer.valueOf(3),
            Integer.valueOf(2)));

    assertEquals(Integer.valueOf(0),
        Class.forName("intTest").getMethod("mod", Integer.class, Integer.class).invoke(null, Integer.valueOf(10),
            Integer.valueOf(5)));
  }

  @Test
  public void testNeg() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Integer.valueOf(-3),
        Class.forName("intTest").getMethod("neg", Integer.class).invoke(null, Integer.valueOf(3)));

    assertEquals(Integer.valueOf(3),
        Class.forName("intTest").getMethod("neg", Integer.class).invoke(null, Integer.valueOf(-3)));
  }






}
