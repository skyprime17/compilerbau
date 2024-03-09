### Standard Funktionen

### println
Standard Ausgabe-Funktion um eine Nachricht in der Konsole auszugeben.

```rust
fn println()
```
Printet den Line-Seperator in die Standard-Konsole aus

```
fn println(message: T)
```

#### Beispiele:
```rust
pub fn main(args: [String]) {  
  println();  // Printet eine leere Zeile
  println("Hello World"); // Printet "Hello World" + Line Seperator aus.

  let s = 5;
  println("s=%s", s); // s=5

  let f = "hello";  
  println("f = %s", f); // f= hello
  
  
  let t = T{ s: 5 };  
  println("t.s = %s", t.s);  //t.s = 5
  
  println("t = %s", t); // t =  T@5b2133b1
}
```


### len
Len funktioniert auf dem Array-Typen und gibt die Länge des Arrays zurück

#### Beispiele:
```rust
pub fn main(args: [String]) {  
  let s = [1,2,3];
  println("s.len=%s", s.len()); // s.len=3

}
```

