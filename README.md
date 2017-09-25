# HW2

### OO Design Patterns    
    
1. Creational Patterns: They are all about class instantiation and are divided into class creation and object creation patterns.  
Examples of Creational Patterns:  
a) Singleton Pattern: It ensures that a class has only one instance, and provide a global point of access to it.    
It is useful in situations where:   
* application needs one, and only one, instance of an object,   
* lazy initialization, and    
* global access are necessary.    
    
Checklist for Singleton Design Pattern:   
* Define a private static attribute in the "single instance" class.   
* Define a public static accessor function in the class.    
* Do "lazy initialization" (creation on first use) in the accessor function.    
* Define all constructors to be protected or private.     
* Clients may only use the accessor function to manipulate the Singleton.   
    
b)  Factory Method Pattern: It lets a class defer instantiation to subclasses. Define an interface for creating an object, but let subclasses decide which class to instantiate.    
It is useful in scenarios like this: A framework needs to standardize the architectural model for a range of applications, but allow for individual applications to define their own domain objects and provide for their instantiation.     
    
Checklist for Factory Design Pattern:    
* If you have an inheritance hierarchy that exercises polymorphism, consider adding a polymorphic creation capability by defining a static factory method in the base class.    
* Design the arguments to the factory method. What qualities or characteristics are necessary and sufficient to identify the correct derived class to instantiate?    
* Consider designing an internal "object pool" that will allow objects to be reused instead of created from scratch.    
* Consider making all constructors private or protected.    
      
          
2. Structural Design Patterns: These design patterns are all about class and object composition. Structural class-creation patterns use inheritance to compose interfaces.    
a) Proxy Design Pattern: It provides a surrogate or placeholder for another object to control access to it.   
There are four common situations in which the Proxy pattern is applicable:    
* A virtual proxy is a placeholder for "expensive to create" objects. The real object is only created when a client first requests/accesses the object.   
* A remote proxy provides a local representative for an object that resides in a different address space.     
* A protective proxy controls access to a sensitive master object. The "surrogate" object checks that the caller has the access permissions required prior to forwarding the request.   
* A smart proxy interposes additional actions when an object is accessed.   
    
b) Decorator Design Pattern: It provide a flexible alternative to subclassing for extending functionality. It attaches additional responsibilities to an object dynamically.    
When we want to add behavior or state to individual objects at run-time, inheritance is not feasible because it is static and applies to an entire class.   
Example: The ornaments that are added to pine or fir trees are examples of Decorators. Lights, garland, candy canes, glass ornaments, etc., can be added to a tree to give it a festive look. The ornaments do not change the tree itself which is recognizable as a Christmas tree regardless of particular ornaments used. As an example of additional functionality, the addition of lights allows one to "light up" a Christmas tree.   
      
3. Behavioral Patterns: They are most specifically concerned with communication between objects.    
a) Visitor Pattern: Visitor lets you define a new operation without changing the classes of the elements on which it operates.    
Situation where it is useful: Many distinct and unrelated operations need to be performed on node objects in a heterogeneous aggregate structure. You want to avoid "polluting" the node classes with these operations. And, you don't want to have to query the type of each node and cast the pointer to the correct type before performing the desired operation.    
    
b) Observer Pattern: It is a way to notify a change to number of classes. It defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. Procedure it follows: Define an object that is the "keeper" of the data model and/or business logic (the Subject). Delegate all "view" functionality to decoupled and distinct Observer objects. Observers register themselves with the Subject as they are created. Whenever the Subject changes, it broadcasts to all registered Observers that it has changed, and each Observer queries the Subject for that subset of the Subject's state that it is responsible for monitoring.   
Examples include bidding system, stock exchange where observers are notified of the bid.
