package org.compilerbau.ast;

import java.util.List;

public interface Typ {
  Typ BOXED_INT = new Ref("java/lang/Integer");
  Typ BOXED_BOOLEAN = new Ref("java/lang/Boolean");
  Typ BOXED_VOID = new Ref("java/lang/Void");
  FunTyp ARITH = new FunTyp(List.of(Typ.BOXED_INT, Typ.BOXED_INT), Typ.BOXED_INT);
  FunTyp CMP = new FunTyp(List.of(Typ.BOXED_INT, Typ.BOXED_INT), Typ.BOXED_BOOLEAN);
  FunTyp LOGIC = new FunTyp(List.of(Typ.BOXED_BOOLEAN, Typ.BOXED_BOOLEAN), Typ.BOXED_BOOLEAN);
  Typ BOXED_STRING = new Ref("java/lang/String");

  default int stackPos() {
    return 1;
  }

  String jvmType();

  static boolean isPrimitive(Typ typ) {
    boolean primitive = typ == Typ.BOXED_INT || typ == Typ.BOXED_BOOLEAN || typ == Typ.BOXED_VOID || typ == Typ.BOXED_STRING;
    if (primitive) {
      return true;
    }
    if (typ instanceof Array x) {
      return isPrimitive(x.typ);
    }
    return false;
  }


  record Ref(String name, String outer) implements Typ {

    public Ref(String name) {
      this(name, null);
    }

    @Override
    public String toString() {
      return name;
    }

    @Override
    public String jvmType() {
      return "L" + (outer() == null ? "" : outer + "$") + name() + ";";
    }

  }


  record FunTyp(List<Typ> args, Typ typ) implements Typ {
    @Override
    public String jvmType() {
      return null;
    }

  }

  record Unknown() implements Typ {
    @Override
    public String jvmType() {
      return null;
    }

  }

  record Array(Typ typ) implements Typ {
    @Override
    public String jvmType() {
      return "[" + typ.jvmType();
    }

  }
}
