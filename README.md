<<<<<<< HEAD
# DataCollection

Data scrapping and REST apis

### REST

You will get practice interacting with a REST API in order to collect data. You can read more about REST apis [here](https://github.com/CSC-326/Course/raw/master/Slides/RESTAPI_Frameworks.pptx).


### 1. Get a token. 

Go to your profile page on github.

![image](https://cloud.githubusercontent.com/assets/742934/12955762/8d8ae346-cff2-11e5-83ac-21cae5dc8531.png)

![image](https://cloud.githubusercontent.com/assets/742934/12955783/a741d0b0-cff2-11e5-9f95-4cfebe421756.png)

<hr/>

### 2. Test sample code

This will install node packages into node_modules

```
npm install
```

Edit script.js to replace "YOUR TOKEN" with your generated token and your github username.

Now run the script. You should be able to see a list of your repos (may be empty, we'll fix that!).

```
node script.js
```

The code makes a call to get all of a user's repos.

```
   var options = {
		url: 'https://api.github.com/user/users/' + userName + "/repos",
		method: 'GET',
		headers: {
			"User-Agent": "EnableIssues",
			"content-type": "application/json",
			"Authorization": token
		}
	};
```

##### Debugging

You can also debug/implement REST api calls using `curl`. 

A simple example for getting all repos of authenicated user.

```
curl --request GET -H "Authorization: token YOURTOKEN" https://api.github.com/user/repos

```

A more complex example: Change a repositories settings to have issue support.

```
curl --request PATCH -H "Authorization: token YOURTOKEN" --data '{"name":"hw4","has_issues":"true"}' https://api.github.com/repos/cjparnin/hw4
```

Tips for extending.

* `-H` allows you to set headers as part of your request.
* Just replace the `--request` with your METHOD (e.g., GET, POST). 
* You need `--data` when using POST/PATCH, that will be the data sent to the server.

### 3. On your own

You will do the following tasks:

* Write code for listBranches in a given repo under an owner. See [list branches](https://developer.github.com/v3/repos/#list-branches)
* Write code for [create a new repo](https://developer.github.com/v3/repos/#create)
* Write code for [creating an issue](https://developer.github.com/v3/issues/#create-an-issue) for an existing repo.
* Write code for [editing a repo](https://developer.github.com/v3/repos/#edit) to enable wiki support.




## Data Collection

Not every dataset will have a nice REST api allowing you to get data. In addition, sometimes rate limits, or missing data will make it necessary to try something else. Sometimes, you need to learn how to scrap data.

*Scrapping* is a process for acquiring content through a scripted browser or user agent. There are many tools that support scrapping, such as [beautifulsoup](http://web.stanford.edu/~zlotnick/TextAsData/Web_Scraping_with_Beautiful_Soup.html). Scrapping can get tricky because content that you want may be deeply nested in a web page or it may be hidden behind several pages that require filling out forms or stepping through user interfaces.

For this workshop, will practice using Selenium, which is a powerful tool for scripting web browsers, such as Chrome.

### Setup

Preq: Make sure you have an [Eclipse environment with Maven](https://github.com/REU-SOS/EngineeringBasics).

* From Eclipse, use Import Existing Maven project. Locate Selenium folder and import.
* Run JUnit tests and make sure you can see 2 passing test cases.

### XPath

In a browser, a html page is represented by DOM, a document model consisting of a tree of elements, attributes, and values. XPath is a tree selector language that makes it easy to write a query to select all elements that match a criteria.

Let's play around in Chrome's console.  Search for anything, and go to google's search result page.  In a console, type: `$x("//a")`. This allows us to use a xpath expression to select all links.

**Exercise**: How could could you select search results links?

**Quick reference**:

* `//` Select all ancestors.
* `/` Select child
* `..` Select parent
* `//a[@data-href]` Select all links that have an attribute "data-href".
* `//h2[.='Search Results']` Select all h2 elements with value = "Search Results".
* `//h2/following-sibling::div"` Select the sibiling div after a h2 element.

### Using Selenium

Now that we know how to select elements. Lets automate the process of interacting and clicking through a webpage.

Will will use Selenium to locate several properties from the following site: http://checkbox.io/studies.html

We will walk through one example, and you will do the rest on your own:

* 1. The participant count of "Frustration of Software Developers" is 55
* 2. The total number of studies closed is 5.
* 3. If a status of a study is open, you can click on a "Participate" button.
=======
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
>>>>>>> 853af55f24e745a2c2570ac957ce76e5fe4c712f
