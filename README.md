### Task: Design a bird

1. Requirements
2. The Bird class currently violates the Single Responsibility Principle (SRP) due to the presence of if-else statements.
3. Adding new functionality to the existing codebase would also violate the Open-Closed Principle (OCP).
4. Creating a separate class for new functionality may lead to a class explosion, which may not be desirable.


### Design Pattern :
* Design => Software System 
* Pattern => Repetitive/template

**What are design patterns?** 
Design patterns are commonly encountered design problems with well-established solutions.

**Why should we learn Design Patterns?**
* To clear interview
* Save time - Increasing shared vocabulary

**Categories of Design Pattern:**
1. Creational Design Pattern
2. Structural Design Pattern
3. Behavioural Design Pattern

#### Creational Design Pattern
* Bothers about the creation of objects. (how many and how to create?)
    - Singleton
    - Builder
    - Prototype
    - Factory Method
    - Abstract Factory
    - Practical Factory

#### Structural Design Pattern
* Bothers about how to structure a class (means what attributes or data members)
    - Composite 

#### Behavioural Design Pattern
*  Bothers 

    - Iterator Design 

* Understanding the different areas of memory in Java is crucial for any programmer. Here are the main ones:
stack - local

heap - object level

PermGen - class 

- Stack: Every thread in a Java program has its own stack, which is a memory region used to store local variables and function call information. Whenever a function is called, a new frame is created on the stack to store the local variables and parameters of that function. Once the function returns, the frame is destroyed and the memory is freed.

- Heap: The heap is a memory region that stores objects created by the program. It is shared among all threads, and when a new object is created, memory is allocated from the heap to store it. The garbage collector is responsible for freeing up memory in the heap by identifying and removing objects that are no longer being used.

- PermGen/Metaspace: In earlier versions of Java, class metadata (such as the name of the class, its fields, and its methods) was stored in a memory region called PermGen (Permanent Generation). However, starting with Java 8, PermGen was replaced with Metaspace, which is a similar memory region that stores class metadata but is allocated natively and can grow or shrink as needed.


private **static** DBconnection dbcon;
Here if we don't declare static we can create multiple objects.
If we use **static** we can store it in **PERMGEN**


- **class -> class** -> **_extends_**
- **class -> interface** -> **_implements_**
- **interface -> interface** -> **_extends_**
