### Task: Design a bird

1. Requirements
2. The Bird class currently violates the Single Responsibility Principle (SRP) due to the presence of if-else statements.
3. Adding new functionality to the existing codebase would also violate the Open-Closed Principle (OCP).
4. Creating a separate class for new functionality may lead to a class explosion, which may not be desirable.


### Design Pattern :
* Design => Software System 
* Pattern => Repetitive/template

**What are design pattern ?** 
Design patterns are commonly encountered design problems with well establoished solutions.

**Why should we learn Design Pattern ?**
* To clear interview
* Save time - Increasing shared vocabulary

**Categories of Design Pattern :**
1. Creational Design Pattern
2. Structural Design Pattern
3. Behavioural Design Pattern

#### Creational Design Pattern
* Bothers about creation of objects.(how many and how to create?)
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

stack - local 
heap - object level
PermGen - class 

private **static** DBconnection dbcon;
Here if we dont declare static we can create multiple objects.
If we use **static** we can store it in **PERMGEN**