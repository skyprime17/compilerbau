import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;

import org.compilerbau.Main;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestBool {

  @BeforeAll
  public static void setUp() throws Exception {
    Main.compile("build/classes/java/test/", new FileReader("src/test/resources/boolean.gr"));
  }

  @Test
  public void testTrue() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("t").invoke(null));
  }

  @Test
  public void testFalse() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("f").invoke(null));
  }

  @Test
  public void testAnd() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("and", Boolean.class, Boolean.class).invoke(null, Boolean.TRUE, Boolean.TRUE));
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("and", Boolean.class, Boolean.class).invoke(null, Boolean.TRUE, Boolean.FALSE));
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("and", Boolean.class, Boolean.class).invoke(null, Boolean.FALSE, Boolean.TRUE));
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("and", Boolean.class, Boolean.class).invoke(null, Boolean.FALSE, Boolean.FALSE));
  }

  @Test
  public void testOr() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("or", Boolean.class, Boolean.class).invoke(null, Boolean.TRUE, Boolean.TRUE));
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("or", Boolean.class, Boolean.class).invoke(null, Boolean.TRUE, Boolean.FALSE));
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("or", Boolean.class, Boolean.class).invoke(null, Boolean.FALSE, Boolean.TRUE));
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("or", Boolean.class, Boolean.class).invoke(null, Boolean.FALSE, Boolean.FALSE));
  }


  @Test
  public void testEq() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("eq", Boolean.class, Boolean.class).invoke(null, Boolean.TRUE, Boolean.TRUE));
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("eq", Boolean.class, Boolean.class).invoke(null, Boolean.TRUE, Boolean.FALSE));
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("eq", Boolean.class, Boolean.class).invoke(null, Boolean.FALSE, Boolean.TRUE));
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("eq", Boolean.class, Boolean.class).invoke(null, Boolean.FALSE, Boolean.FALSE));
  }

  @Test
  public void testNeq() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("neq", Boolean.class, Boolean.class).invoke(null, Boolean.TRUE, Boolean.TRUE));
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("neq", Boolean.class, Boolean.class).invoke(null, Boolean.TRUE, Boolean.FALSE));
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("neq", Boolean.class, Boolean.class).invoke(null, Boolean.FALSE, Boolean.TRUE));
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("neq", Boolean.class, Boolean.class).invoke(null, Boolean.FALSE, Boolean.FALSE));
  }

  @Test
  public void testNot() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("not", Boolean.class).invoke(null, Boolean.TRUE));
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("not", Boolean.class).invoke(null, Boolean.FALSE));
  }


  @Test
  public void testNot2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("not2", Boolean.class).invoke(null, Boolean.TRUE));
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("not2", Boolean.class).invoke(null, Boolean.FALSE));
  }


  @Test
  public void ifCallTrue() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
      IllegalAccessException {
    assertEquals(Boolean.TRUE, Class.forName("boolTest").getMethod("ifCallTrue").invoke(null));
    assertEquals(Boolean.FALSE, Class.forName("boolTest").getMethod("ifCallFalse").invoke(null));
  }




}
