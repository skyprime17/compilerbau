### GRK

GRK ist eine Programmiersprache inspiriert von Golang / Rust / Kotlin und MojoLang.
Der Compiler ist in Java implementiert und erzeugt JVM Byte Code, der nach der Kompilation über die JVM ausgeführt werden kann.
Die Grammatik wurde mit ANTLR4 realisiert.


### Docs
Genauere Informationen zur Sprache und der Grammatik finden sich im Ordner `docs`



### Installation

#### Vorraussetzungen
- JDK 21

#### Projekt via git clone auschecken
```sh
git clone https://github.com/skyprime17/compilerbau.git
```
#### Compilation
Das Projekt wird mit gradle gebaut. Die kompilierte .jar befindet sich im Ordner `gencode` mit dem namen `grk.jar`
```gradle
./gradlew jar
```

Ausführen der Beispiele:
Im ordner `gencode` befinden sich einige Code-Beispiele

#### FizzBuzz.gr

```sh
./grk.jar ./fizzbuzz.gr 
java fizzbuzz
```

Erwartete Ausgabe(verkürzt dargestellt):
```rust
/*
1
2
fizz
4
......
buzz
fizz
97
98
fizz
buzz
```


#### Sort.gr
```sh
./grk.jar ./sort.gr 
java sort
```

```rust
// Erwartete Ausgabe
/*
Sorted array using bubble sort:
11
12
22
25
34
64
90
Sorted array using quick sort:
11
12
22
25
34
64
90
Reversed array:
10
9
8
7
6
5
4
3
2
1
*/
```