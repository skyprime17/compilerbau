package org.compilerbau.ast;

public class Attributes {
  public Typ typ = new Typ.Unknown();
  public boolean nullable = false;
  public boolean needsBoxing = true;
  public ArgConvention argConvention = ArgConvention.BORROWED;

  @Override
  public String toString() {
    return "";
  }
}
