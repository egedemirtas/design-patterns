# Java Design Patterns

**What is design pattern?**

- Design patterns are well-proved solution, programming language independent strategies for solving common
  object-oriented design problems
- By using the design patterns you can make your code more **flexible**, **reusable** and **maintainable**
- We must use the design patterns during the analysis and requirement phase of SDLC

## Creational Patterns

**What is creational pattern?**

- Creational design patterns provide various object creation mechanisms, which increase flexibility and reuse of
  existing code.

### Factory Method

- Define an interface for creating an object, but let subclasses decide which class to instantiate.
- Benefit:
    - Promotes **loose coupling**:
        - abstracting the creation of objects from their usage
        - Clients interact with the abstract factory or factory method, reducing dependencies on concrete
          implementations.
- Usage:
    - When a class doesn't know what subclasses will be required to create
    - When a class wants that its subclasses specify the objects to be created.
    - When the parent classes choose the creation of objects to its subclasses.
- Ex:
    1. Government issues different types of taxes to citizens: income tax, vehicle tax
    2. For a given citizen correct type of tax has to be created (vehicle tax should be issued to someone only with a
       vehicle)

### Abstract Factory

- Lets you produce families of related objects without specifying their concrete classes.
- Abstract Factory lets a class returns a factory of classes.
- Benefits:
    - isolates the client code from concrete (implementation) classes
- Usage:
    - When the system needs to be independent of how its object are created, composed, and represented.
    - When the family of related objects has to be used together, then this constraint needs to be enforced.
    - When you want to provide a library of objects that does not show implementations and only reveals interfaces.
- Ex:
    1. BMW and Honda both produces motorcycles and cars
    2. For simplicity a motorcycle is a combination of 2 parts: wheels, engine
    3. Create cheap motorcycle by using low quality wheels/engine; visa-versa for expensive motorcycle

### Builder

- Lets you construct complex objects step by step.
- The pattern allows you to produce different types and representations of an object using the same construction code.
- Benefits:
    - It provides clear separation between the construction and representation of an object.
    - Removes long constructors
    - Constructor for each combination of property is not needed anymore
- Ex:
    1. You are making a PC builder
    2. You may want a PC with RGB lightnings
    3. You may want a PC with liquid cooling
    4. You may want a PC with an integrated GPU or separate one
    5. You may want a PC with 2 monitors

### Singleton

- Lets you define a class that has only one instance and provides a global point of access to it
- Used mostly for logging, DB connections
- Benefit: saves memory because the object is created once and used many times
- Disadvantage: Violates Single Responsibility Principle (SRP) by controlling their creation and lifecycle.
- Types:
    1. Early Instantiation: creation of instance at load time.
    2. Lazy Instantiation: creation of instance when required.

### Prototype

- Lets you clone an existing object instead of creating new one
- This pattern should be followed, if the cost of creating a new object is expensive and resource intensive.

___

## Structural Patterns

- concerned with how classes and objects can be composed, to form larger structures.
- simplifies the structure by identifying the relationships.

### Adapter

- Converts the interface of a class into another interface that a client wants
- Benefits:
    - It allows two or more previously incompatible objects to interact.
    - It allows reusability of existing functionality.
- Problem:
    - Imagine that you’re creating a stock market monitoring app. The app downloads the stock data from multiple sources
      in XML format and then displays nice-looking charts and diagrams for the user. At some point, you decide to
      improve the app by integrating a smart 3rd-party analytics library. But there’s a catch: the analytics library
      only works with data in JSON format.
- Solution:
    - To solve the dilemma of incompatible formats, you can create XML-to-JSON adapters for every class of the analytics
      library that your code works with directly.
- Terms:
    - Target: This defines the domain-specific interface that the client uses. This is the Shape interface in our
      example.
    - Client: This collaborates with objects conforming to the Target interface. The Drawing class is the client in our
      example.
    - Adaptee: This defines an existing interface that needs adapting. This is the GeometricShape interface in our
      example.
    - Adapter: This adapts the interface from the adaptee to the target interface.
- Implementation approaches:
    - Object Adapter Pattern:
        - Uses Java composition: adapter contains the source object
        - we create an adapter class that implements the target ( Shape in this case) and references the adaptee:
          GeometricShape in this case.
        - Lets a single Adapter work with many Adaptees, that is, the Adaptee itself and all of its subclasses

        - Class Adapter Pattern:
            - we use the Java Inheritance, extend the source class.
            - So, for this approach, we have to create separate
              adapters for the Triangle and Rhombus classes
            - Adapts Adaptee to Target by committing to a concrete Adaptee class. As a consequence, a class adapter
              won’t work when we want to adapt a class and all its subclasses.

### Bridge

- Decouple an abstraction from its implementation so that the two can vary independently.
- Bridge pattern is about preferring composition to inheritance. Implementation details are pushed
  from a hierarchy to another object with a separate hierarchy.
- Ex:
    - Consider you have a weapon with different enchantments, and you are supposed to allow mixing
      different weapons with different enchantments. What would you do? Create multiple copies of each
      of the weapons for each of the enchantments or would you just create separate enchantment and set
      it for the weapon as needed? Bridge pattern allows you to do the second.
    - Sword is subclass of Weapon
    - Sword has Enhancement as a field
    - Enhancement has subclasses: FylingEnhancement, SoulEatingEnhacement

### Composite

- Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients
  treat individual objects and compositions of objects uniformly
- Ex:
    - BankManager, Cashier, Accountant are all employees
    - Only BankManager can have Cashier and Accountant as employees under it. for this BankManager
      has `         List<Employee> employees = new ArrayList<Employee>();  
      ` as field

### Decorator

### Facade

### Flyweight

### Proxy

## Behavioral Patterns

- Chain of Responsibility
- Command
- Iterator
- Mediator
- Memento
- Observer
- State
- Strategy
- Template Method
- Visitor