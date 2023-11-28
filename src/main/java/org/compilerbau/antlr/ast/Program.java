package org.compilerbau.antlr.ast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public record Program(Attributes attributes, String name, List<Item> items, Map<String, FunDef> funDefs,
                      Set<String> interfaces) implements AST {
  public Program(String name, List<Item> items) {
    this(new Attributes(), name, items, new HashMap<>(), new HashSet<>());
    for (var def : items) {
      switch (def) {
        case FunDef fun:
          funDefs.put(fun.name(), fun);
          break;
      }
    }
  }

  public <R> R welcome(Visitor<R> vis) {
    return vis.visit(this);
  }

  @Override
  public boolean isStructured() {
    return false;
  }
}