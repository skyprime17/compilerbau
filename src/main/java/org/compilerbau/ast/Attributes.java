package org.compilerbau.ast;

public class Attributes {
  public Typ typ = new Typ.Unknown();
  public boolean nullable = false;
  public boolean needsBoxing = true;
  public boolean mutable = false;

  @Override
  public String toString() {
    return "";
  }
}
