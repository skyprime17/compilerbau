package org.compilerbau.ast;

public class Attributes {
  public Typ typ = new Typ.Unknown();
  public boolean nullable = false;
  public boolean needsBoxing = true;
  public String structCallFieldName = null;

  @Override
  public String toString() {
    return "";
  }
}
