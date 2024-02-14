package org.compilerbau.ast;

public interface Visibility {

  Visibility PUBLIC = new Public();
  Visibility PRIVATE = new Private();


  record Public() implements Visibility {
    @Override
    public String toString() {
      return "public";
    }
  }

  record Private() implements Visibility {
    @Override
    public String toString() {
      return "private";
    }
  }

}
