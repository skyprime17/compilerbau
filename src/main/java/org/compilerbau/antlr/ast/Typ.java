package org.compilerbau.antlr.ast;

import java.util.List;

public interface Typ {
  Typ INT = new PrimInt();
  Typ BOOLEAN = new PrimBool();
  Typ VOID = new Void();
  FunTyp ARITH = new FunTyp(List.of(Typ.INT, Typ.INT), Typ.INT);
  FunTyp CMP = new FunTyp(List.of(Typ.INT, Typ.INT), Typ.BOOLEAN);
  FunTyp LOGIC = new FunTyp(List.of(Typ.BOOLEAN, Typ.BOOLEAN), Typ.BOOLEAN);

  default int stackPos() {
    return 2;
  }

  String jvmType();

  record Void() implements Typ {
    @Override
    public String toString() {
      return "void";
    }

    @Override
    public String jvmType() {
      return "V";
    }
  }

  record PrimBool() implements Typ {
    @Override
    public String toString() {
      return "boolean";
    }

    @Override
    public int stackPos() {
      return 1;
    }

    @Override
    public String jvmType() {
      return "Z";
    }
  }

  record PrimInt() implements Typ {
    @Override
    public String toString() {
      return "int";
    }

    @Override
    public String jvmType() {
      return "J";
    }
  }

  record Ref(String name) implements Typ {
    @Override
    public String toString() {
      return name;
    }

    @Override
    public String jvmType() {
      return "L" + name() + ";";
    }
  }

  record FunTyp(List<Typ> args, Typ result) implements Typ {
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
}
