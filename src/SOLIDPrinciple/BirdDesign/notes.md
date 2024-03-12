## Design a Bird?
* Design is iterative
     > In the context of software design principles, iterative refers to a process of continuously improving a design or product through repeated cycles of development, testing, and refinement. 
* Design is interactive
* Design is subjective ``Pros and cons``


# `Requirement ` :
  Design a bird.

`Version 0` : 
  * Bird class and data members like weight, color, type, and so on.
  * Can have methods like eat, fly, and make sound methods.

makeSound() {
  if (type == 'Sparrow') {
    System.out.println("chi chi");
  } else if(type == 'pigeon') {
  System.out.println("goo goo");
  } else if(type == 'crow') {
  System.out.println("kaw kaw");
  }
  }

#### **Problem with version 0:**
1. **Readability** - If we have more than 500 birds, the code will have a lot of nested if-else statements, making it hard to read and understand.

2. **Testability** - If we want to test the makeSound() method for each bird, we will have to create 500 functions in the JUnit Testing Framework, which will make testing difficult and time-consuming.

3. **Parallel Development** - If multiple developers work on this codebase, there is a high chance of merge conflicts, which would require manual effort to resolve.

4. **SRP violation** - The code violates the Single Responsibility Principle (SRP), which states that every code unit (such as a method, class, or package) should have a clearly defined responsibility and a single reason for the code change.


`Version 1` :
void makeSound() {
if (type == 'Sparrow') {
  makeSparrowSound();
} else if(type == 'pigeon') {
  makePigeonSound();
} else if(type == 'crow') {
  makeCrowSound();
}
}

> Version 1 is handling SRP better than version 0.

**SRP code smells:** 
1. Lots of if-else 
2. Monster Methods
3. Common/ Shared/ Utility folder

**Requirement :** Add peacock

`Version 1.1` :

`void makeSound() {
if (type == 'Sparrow') {
makeSparrowSound();
} else if(type == 'pigeon') {
makePigeonSound();
} else if(type == 'crow') {
makeCrowSound();
}else if(type == 'peacock') {
makePeacockSound();
}
}`
#### **Problem with version 1.1:**
1. OCP violation

### **Open-Closed Principle:**

> The Open-Closed Principle (OCP) is a software design principle that emphasizes the importance of creating software entities such as classes, modules, and functions in a way that they are open for extension but closed for modification. This means that it should be possible to add new functionality to a software entity without having to modify its existing code.

* To achieve this, designers should use abstractions, interfaces, and inheritance to create modular and reusable code. For example, a class that represents a shape should not be modified if a new shape needs to be supported. Instead, a new class can be created that extends the base shape class and implements the method for the new shape.

`Version 2` :
Ocp violation solved in below example by adding new functionality without changing previous code.
* Both SRP and OCP violation is solved.

`abstract class Bird {
 int weight;
 String color;
 String type;
 void eat() { }
 void fly() { }
 void makeSound() { }
}`

`class Sparrow extends Bird {
void eat () { }
void fly () { }
void makeSound() { }
}`

`class Pigeon extends Bird {
void eat () { }
void fly () { }
void makeSound() { }
}`

`class Crow extends Bird {
void eat () { }
void fly () { }
void makeSound() { }
}
`

`class Peacock extends Bird {
void eat () { }
void fly () { }
void makeSound() { }
}
`

`Version 2.1` :

**Requirement :** Add penguin

* As per the requirement, I have created a new class for penguins. Since penguins cannot fly, the method for flying was left empty, which violates the Liskov substitution principle.

`abstract class Bird {
int weight;
String color;
String type;
void eat() { }
void fly() { }
void makeSound() { }
}`

`class Sparrow extends Bird {
void eat () { }
void fly () { }
void makeSound() { }
}`

`class Penguin extends Bird {
void eat () { }
void fly () { // Leave it empty leads to LSP violation }
void makeSound() { }
}
`

##### **LSP Violation:**

1. Don't surprise the client.
2. Don't advertise something that you can't do.
3. Abstractions should not be out of sync with implementations.

`Version 2.2` :

`abstract class Bird {
int weight;
String color;
String type;
void eat() { }
void makeSound() { }
}`

`abstract class FlyingBirds{
void Fly() { }
}`

`abstract class Non-FlyingBirds {
void () { }
}`

`class Sparrow extends Bird, FlyingBirds {
void eat () { }
void fly () { }
void makeSound() { }
}`

`class Penguin extends Bird, Non-FlyingBirds {
void eat() { }
void makeSound() { }
}`

`class Ostrich extends Bird, Non-FlyingBirds {
void eat() { }
void makeSound() { }
}`

`Version 2.3` :

**Requirement :** Add Kiwi.
* Kiwi don't fly and don't make a sound either.

`abstract class Bird {
int weight;
String color;
String type;
void eat() { }
}`

`abstract class FlyingBirdMakeSound{
    void Fly() { }
    void makeSound() { }
}`

`abstract class FlyingBirdNotMakeSound{
    void Fly() { }
}`

`abstract class Non-FlyingBirdsMakeSound {
    void makeSound() { }
}`

`abstract class Non-FlyingBirdsNotMakeSound {
}`

`class Sparrow extends Bird, FlyingBirdMakeSound {
void eat () { }
void fly () { }
void makeSound() { }
}`

`class penguin extends Bird, Non-FlyingBirdsMakeSound {
void eat () { }
void makeSound() { }
}`

* If there are 10 features then we will have 2^10 classes which leads to _**Class Explosion**_.

##### **LSP :**
> Child class should be able to substitute parent class

**Version 3 :**

`abstract class Bird {
int weight;
String color;
String type;
void eat() { }
}`

`interface Flyable {
Void fly();
}`

`interface Talkable {
void makeSound();
}`

`class Sparrow extends Bird implements Flyable, Talkabale {
void fly() { }
void eat() { }
void makeSound() { }
}`

`class Crow extends Bird implements Flyable, Talkable {
void fly() { }
void eat() { }
void makeSound() { }
}`

`class Penguin extends Bird implements Talkable {
void eat() { }
void makeSound() { }
}`

`class Kiwi extends Bird {
void eat() { }
}`


**Requirement :** All flying birds should dance also.

**Version 3.1 :**

`abstract class Bird {
int weight;
String color;
String type;
void eat() { }
}`

`interface Flyable {
Void fly();
void dance();
}`

`interface Talkable {
void makeSound();
}`

`class Sparrow extends Bird implements Flyable, Talkabale {
void fly() { }
void eat() { }
void dance() { }
void makeSound() { }
}`

`class Crow extends Bird implements Flyable, Talkable {
void fly() { }
void eat() { }
void dance() { }
void makeSound() { }
}`

`class Penguin extends Bird implements Talkable {
void eat() { }
void makeSound() { }
}`

`class Kiwi extends Bird {
void eat() { }
}`

* version 3.1 leads to violation of interface segregation principle.
* Try to keep interfaces as small as possible.(have related functions together.)
* ISP as SRP of interfaces.
* of all java interfaces with a single function.
    e.g : Runnable, Callable, Cloneable, Comparable, Comparator


**Version 4 :**

`abstract class Bird {
int weight;
String color;
String type;
void eat() { }
}`

`interface Flyable {
Void fly();
}`

`interface Talkable {
void makeSound();
}`

`interface DanceAble {
void dance();
}`

`class Sparrow extends Bird implements Flyable, Talkabale, DanceAble {
void fly() { }
void eat() { }
void makeSound() { }
void dance() { }
}`

`class Crow extends Bird implements Flyable, Talkable, DanceAble {
void fly() { }
void eat() { }
void makeSound() { }
void dance() { }
}`

`class Penguin extends Bird implements Talkable {
void eat() { }
void makeSound() { }
}`

`class Kiwi extends Bird {
void eat() { }
}`

* Now we will consider only fly method for all birds.

`class Sparrow {
L1
L2
L3
L4
}`

`class Peacock {
L1
L2
L3
L4
}`

`class Crow {
L1.1
L2.2
L3.3
L4.4
}`

`class Pigeon {
L1.1
L2.2
L3.3
L4.4
}`

* In the above code we can see duplicate of code which leads to **DRY -  Don't Reapeat Yourself** is violated.


**Version 4.1 :**

`interface Flyator {
    void flightAlgorithm();
}`

`class FastFlyator {
void flightAlgorithm() { 
L1;
L2;
L3;
L4;
}
}`

`class SlowFlyator {
void flightAlgorithm() {
L1.1;
L2.2;
L3.3;
L4.4;
}
}`


`class Sparrow {
void fly() {
Flyator r = new SlowFlyator();
r.flightAlgorithm();
}
}`

`class Peacock {
void fly() {
Flyator r = new SlowFlyator();
r.flightAlgorithm();
}
}`

`class Crow {
void fly() {
Flyator r = new FastFlyator();
r.flightAlgorithm();
}
}`

`class Pigeon {
void fly() {
Flyator r = new FastFlyator();
r.flightAlgorithm();
}
}`

* **Verion 4.1 leads to _DIP violation_ or _tight coupling_**.

Loose coupling : We can remove and change the device or interface.

* version 4.1 old code 
    client -> sparrow -> slowFlyator();
* **Client depends on sparrow and sparrow depends on SlowFlyator**
* Version 5 new code (Bird design)
    client -> sparrow 
    sparrow -> client (for dependency i.e ref)
    Dependency injected by the client
* **Client depends on sparrow but sparrow also depends upon client to get its dependency**

**_DIP_ :**
High level modules should not directly depend on low level modules instead they should both depend on abstractions.
High level module should provide a socket where low level modules can be plugged and switched.(loose coupling)


### Dependency Injection :
1. Method Injection
    Benefit : Switching is possible.
    Loss : Possible to create object with no dependency set.
2. Constructor Injection
    Benefit : Dependency is provided at object creation time.
    Loss : Cannot switch dependency in same object so need to create object again.


