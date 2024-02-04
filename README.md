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
- Implementation:
    1. IncomeTaxReportReport and VehicleTaxReport implements ITaxReport
    2. IncomeTaxCreator and VehicleTaxCreator implements ITaxReportCreator (returns ITaxReport)
    3. TaxFactory returns IncomeTaxCreator(either IncomeTaxCreator or VehicleTaxCreator based on the current client)

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
- Implementation:
    1. ExpensiveEngine and CheapEngine implements IEngine
    2. ExpensiveWheel and CheapWheel implements IWheel
    3. CheapMotorCycleFactory and ExpensiveMotorcycleFactory implements MotorcycleFactory (returns IEngine and IWheel)
    4. CheapMotorCycleFactory produces CheapEngine and CheapWheel
    5. MotorcycleFactoryProducer returns MotorcycleFactory (either CheapMotorCycleFactory or ExpensiveMotorcycleFactory)

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
- Implementation
    1. Have a top class called PC
    2. PC has a private constructor which has PCBuilder as parameter:

  ```java
      private PC(PCBuilder pcBuilder){
        this.color = pcBuilder.color;
  ```

    3. Have a static subclass PCBuilder inside PC
    4. PCBuilder:
        - has the same fields as PC
        - has setters for fields
        - has a build() function which returns PC by calling private constructor of PC

  ```java
        public PC build(){
            return new PC(this);
        }
  ```

### Singleton

- Lets you define a class that has only one instance and provides a global point of access to it
- Used mostly for logging, DB connections
- Benefit: saves memory because the object is created once and used many times
- Disadvantage: Violates Single Responsibility Principle (SRP) by controlling their creation and lifecycle.
- Types:
    1. Early Instantiation: creation of instance at load time.
    2. Lazy Instantiation: creation of instance when required.
- Early Implementation:
    1. constructor is private and empty
    2. Has itself as a class variable; declared and initialized:
  ```java
      private static EarlyClass obj = new EarlyClass();//Early, instance will be created at load time
  ```

- Lazy Implementation:
    1. constructor is private and empty
    2. Has itself as a class variable; only declared
    3. getLazyClass initialize this class variable if it is not initialized before
  ```java
    private static LazyClass obj;

    public static LazyClass getLazyClass(){
        if (obj == null){
            obj = new LazyClass();
        }
        return obj;
    }
  ```

### Prototype

- Lets you clone an existing object instead of creating new one
- This pattern should be followed, if the cost of creating a new object is expensive and resource intensive.
- Implementation:
    1. TreePrototype is abstract and has `public abstract TreePrototype getClone();`
    2. PineTree and PlasticTree extends from TreePrototype
    3. PineTree and PlasticTree implements `getClone` by calling their own constructor and returning the new object
- Implementation with Clonable
    1. HousePrototype is abstract and implements Clonable
    2. HousePrototype overrides `clone()` and returns `Object clone = super.clone();`
    3. FlatHouse and Penthouse extends from HousePrototype

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
    - Circle and Rectangle implements IShape (Target)
    - Drawing (Client) uses IShape to draw
    - Rhombus and Triangle implements IGeometricShape (Adaptee)

    - Object Adapter Pattern:
        - Uses Java composition: adapter contains the source object
        - GeometricShapeObjectAdapter implements IShape (override methods create custom implementations for Rhombus and
          Triangle)
        - IGeometricShape is a private field inside GeometricShapeObjectAdapter
        - GeometricShapeObjectAdapter has a constructor which has a IGeometricShape as a parameter
        - Lets a single Adapter work with many Adaptees, that is, the Adaptee itself and all of its subclasses

    - Class Adapter Pattern:
        - we use the Java Inheritance for each implementation
        - RhombusClassAdapter and TriangleClassAdapter extends Rhombus/Triangle and implements Shape
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
- Implementation:
    - Sword is subclass of Weapon
    - Sword has Enhancement as a field
    - Enhancement has subclasses: FylingEnhancement, SoulEatingEnhacement

### Composite

- Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients
  treat individual objects and compositions of objects uniformly
- Ex:
    - BankManager, Cashier, Accountant are all employees
    - Only BankManager can have Cashier and Accountant as employees under it. for this BankManager
      has `List<Employee> employees = new ArrayList<Employee>();` as field

### Decorator

- Decorator pattern lets you dynamically change the behavior of an object at run time by wrapping
  them in an object of a decorator class.
- Ex: simulation of giving a Troll, a Club
- Implementation:
    - SimpleTroll implements the ITroll
    - ClubbedTroll implements the ITroll
    - ClubbedTroll has ITroll as a field which initialized by its constructor (you can create a SimpleTroll and send it
      as a constructor parameter to ClubbedTroll to get a troll with club)
    - Since ITroll is a filed inside ClubbedTroll; inside ClubbedTroll create attack(); you can call ITroll's attack()
      and also add +10 damage

### Facade

- Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level
  interface that makes the subsystem easier to use.
- Implementation:
    - DwarvenMineWorker is abstarct and has many methods: `goHome()`, `goSleep()`, `wakeUp()`. And also and abstarct
      method `doWork()`
    - DwarvenTunnelDigger, DwarvenGoldDigger, DwarvenCartOperator extends from DwarvenMineWorker and
      overrides `doWork()` in their own means
    - DwarvenGoldmineFacade:
        - has a list of DwarvenMineWorker
        - `startNewDay()` is called for each worker, which causes `wakeUp()` to be called for each worker
        - `work()` is called for each worker, which causes `work()` to be called for each worker. Each worker has
          different work: dig tunnel, dig gold, operate cart
    - Client is hidden from all the logic behind `work()`

### Flyweight

- It is used to minimize memory usage or computational expenses by sharing as much as possible with
  similar objects.
- Implementation:
    - HealingPotion and InvisibilityPotion both implements Potion
    - PotionFactory has a `Map<PotionType, Potion>`:
        - a new Potion is added only if that type is not created before.
        - Otherwise a reference to the same object is returned

### Proxy

- Provide a surrogate or placeholder for another object to control access to it.
- Implementation:
    - There is a Celebrity class
    - There is a ICeremony, which has `void enter(Celebrity celebrity);`
    - GoldenGlobe implements ICeremony
    - GoldenGlobeProxy implements ICeremony
    - GoldenGlobeProxy has a field ICeremony, which is set in constructor (assume you send GoldenGlobe to set it)
    - GoldenGlobeProxy overrides `void enter(Celebrity celebrity)`:
        - In this method a logic can be constructed to decide when to call ICeremony.enter() (GoldenGlobe's
          implementation)

___

## Behavioral Patterns

- concerned with the interaction and responsibility of objects.

### Chain of Responsibility

- Lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the
  request or to pass it to the next handler in the chain.
- Ex: The King gives loud orders to his army. The closest one to react is the commander, then an officer, and then a
  soldier. The commander, officer, and soldier form a chain of responsibility.
- Implementation:
    - Request is a class with fields: requestType, requestDesc, isHandled
    - IRequestHandler is an interface with:
        - priority field: can be 1,2 or 3
        - IRequestHandler nextHandler: to set a chain
        - setNextHandler(IRequestHandler)
        - handle(Request): iterates over IRequestHandler nextHandler, to handle each part of chain

    - Commander, Officer, Soldier implements IRequestHandler. (Their constructor sets priority)
    - ChainOfCommand is a class with single static method
      ```java
      private static IRequestHandler doChaining(){  
        IRequestHandler commander = new Commander(1);
        IRequestHandler officer = new Officer(2);
        IRequestHandler soldier = new Soldier(3);
  
        commander.setNextLogger(officer);
        officer.setNextLogger(soldier);
  
        return commander;	
      }
      ```
      ```java
      public static void main(String args[]){  
        IRequestHandler chainOfCommand = ChainOfCommand.doChaining();  
        chainOfCommand.handle();
      }  
      ```

### Command

- Encapsulate a request as an object, thereby letting you parameterize clients with different
  requests, queue or log requests, and support undoable operations.
- ex: There is a wizard casting spells on a goblin. The spells are executed on the goblin one by one.
  The first spell shrinks the goblin and the second makes him invisible. Then the wizard reverses
  the spells one by one. Each spell here is a command object that can be undone.

### Iterator

- Provide a way to access the elements of an aggregate object sequentially without exposing its
  underlying representation.
- Implementation:
    - Treasure class has:
        - a list of Item()
        - TreasureChestItemIterator getIterator()
        - TreasureChestItemIterator is a public static class which implements Iterable and hasNext(), next() methods
          overriden

### Mediator

- lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the objects
  and forces them to collaborate only via a mediator object.
- Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling
  by keeping objects from referring to each other explicitly, and it lets you vary their interaction
  independently.
- ex:
    - Rogue, wizard, hobbit, and hunter have decided to join their forces and travel in the same
      party. To avoid coupling each member with each other, they use the party interface to
      communicate with each other.

### Memento

- Without violating encapsulation, capture and externalize an object's internal state so that the
  object can be restored to this state later.

### Observer

- Define a one-to-many dependency between objects so that when one object changes state, all its
  dependents are notified and updated automatically.
- Ex: when a YouTube channel goes live it must send notification to all subscribers
- Implementation:
    - without Observable/Observer
        - Channel has a list of Subscriber(observers)
        - Subscriber has a method `notify()` which sends email
        - When Channel.update() is called, List<Subscriber> is iterated to call `notify()`
    - With Observer/Observable: depreciated as of Java 9
        - Subscriber implements Observer: override update()
        - Channel implements Observable

### State

- lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.
- Implementation:
    - AngryState and PeacefulState implements State
    - Tiger has a field: State state
    - Tiger has setter methods which sets state to AngryState and PeacefulState
    - When Tiger.look() is called if state is AngryState, it will look angry

### Strategy

- Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets
  the algorithm vary independently of the clients that use it
- State can be considered as an extension of Strategy. Both patterns are based on composition: they change the behavior
  of the context by delegating some work to helper objects. Strategy makes these objects completely independent and
  unaware of each other. However, State doesn’t restrict dependencies between concrete states, letting them alter the
  state of the context at will.

### Template Method

- defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm
  without changing its structure.
- ex:
    - The general steps in stealing an item are the same. First, you pick the target, next you confuse
      him somehow and finally, you steal the item. However, there are many ways to implement these
      steps.
- Implementation
    - StealingMethod is abstract class
        - with abstract methods: pickTarget(), confuseTarget(), stealTheItem()
        - with concrete method: steal()  (calls pickTarget(), confuseTarget(), stealTheItem())
    - SubtleMethod and HitAndRunMethod implements StealingMethod
    - Thief has a field StealingMethod (by setting this field, SubtleMethod or HitAndRunMethod is chosen)

### Visitor

- Represent an operation to be performed on the elements of an object structure. Visitor lets you
  define a new operation without changing the classes of the elements on which it operates.


