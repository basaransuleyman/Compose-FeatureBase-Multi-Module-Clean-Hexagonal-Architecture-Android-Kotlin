# Module Descriptions


## Feature Module - `home`

 Each feature module is divided into data, domain and presentation layers. The data layer is further divided into API, DomainImpl and Persistence. The main reason for this distinction is the principle of single responsibility and the management of the resource from a single point. For example, while the API module is only responsible for communicating with remote services, with domainimpl we prevent the dependency of the domain layer on the API layer. 
 This structure shows how an Android application can be developed in a sustainable and scalable way, inspired by architectural principles such as Clean Architecture and Hexagonal Architecture ( Like Adapter is domain-impl and port is domain) .

![1](https://github.com/basaransuleyman/suleyman-basaranoglu-json/blob/main/Home.png)



## Navigation Module - `navigation`
![1](https://github.com/basaransuleyman/suleyman-basaranoglu-json/blob/main/navigation-module.png)
This module orchestrates the screen transitions and manages the navigation routes within the app. The Navigator class is equipped with functions that facilitate navigation to different screens, while AppNavigation is responsible for setting up the navigation routes. Crucially, the Navigation module operates independently of other modules, which plays a key role in decoupling feature modules from one another. This means that individual features do not have direct knowledge of each other, and all inter-feature navigation is coordinated through the Navigation module. 

### Navigation Flow:
![1](https://github.com/basaransuleyman/suleyman-basaranoglu-json/blob/main/NavigationfLow.png)

### Advantages:

- **Decoupling of Feature Modules:** The Navigation module's independence ensures that feature modules do not depend on each other, allowing for more modular and interchangeable components within the application.
- **Centralized Navigation Handling:** A dedicated class for navigation streamlines all navigation-related logic into a single, manageable location.
- **Separation of Concerns:** AppNavigation focuses exclusively on route configuration, allowing Navigator to handle the execution of navigation commands without interference.
- **Flexibility:** Supports dynamic navigation flows and is readily extensible to incorporate new features or screens, catering to the evolving needs of the application.

### Disadvantages:

- **Startup Time:** While @Composable screen functions are only invoked when necessary, the impact on the app's startup time can vary depending on project complexity and screen content it needs to be tried with its project.
- **Documentation:** Without well-documented argument-passing systems,  may find it challenging to grasp the navigation logic.

### Screen Adding Mechanism:

![1](https://github.com/basaransuleyman/suleyman-basaranoglu-json/blob/main/AddNewScreen.png)


 ## Network Module - `network`

The Network Module is a critical component of the architecture, encompassing all aspects of networking logic. It is crafted to function independently, sourcing its constants from the core module while remaining detached from other modules.

### Advantages:

- **Isolation:** Isolating network operations allows the rest of the application to be indifferent to the data's origin, whether it's fetched from a remote server or local database.
- **Single Responsibility:** Dedicated to network transactions, the module serves as a centralized point for implementing changes related to network operations.
- **Reusability:** With consistent data contracts, the Network Module can be repurposed across various projects or features within the same project.

### Disadvantages:

- **Modular Overhead:** An extensive number of modules can introduce complexity in the build configuration and may lead to longer build times.
- **Dependency Management:** Ensuring that the Network Module remains fully decoupled requires meticulous management of dependencies, which can be challenging as the project grows.
