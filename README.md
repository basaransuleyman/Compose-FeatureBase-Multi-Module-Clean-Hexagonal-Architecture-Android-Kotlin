# Module Descriptions

## Why and What is aim?

The aim of this project is to demonstrate a feature-based modularization by managing the inter-feature dependencies through a dedicated navigation module. By utilizing a navigation module, the project seeks to eliminate the dependencies between features, ensuring that each feature remains self-contained and unaware of the others. This approach not only reinforces the principles of modularity but also showcases how Jetpack Compose can be effectively used to manage and orchestrate the user interface in a modular architecture.
![1](https://github.com/basaransuleyman/suleyman-basaranoglu-json/blob/main/AppFlow.png)
 
In addition, the project adopts a Hexagonal Architecture with Clean Architecture approach between the domain and data layers. By establishing domain implementation (domain-impl) as the adapter that connects to the domain port, the project leverages certain aspects of various architectural patterns without being strictly bound to any single one. This hybrid approach allows the application to benefit from the strengths of different architectures while maintaining the flexibility to adapt to specific project needs.

![1](https://github.com/basaransuleyman/suleyman-basaranoglu-json/blob/main/FeatureFlow.png)
 
## Feature Module - `home`
![1](https://github.com/basaransuleyman/suleyman-basaranoglu-json/blob/main/Home.png)
 
 Each feature module is divided into data, domain and presentation layers. The data layer is further divided into API, DomainImpl and Persistence. The main reason for this distinction is the principle of single responsibility and the management of the resource from a single point. For example, while the API module is only responsible for communicating with remote services, with domainimpl we prevent the dependency of the domain layer on the API layer. 
 This structure shows how an Android application can be developed in a sustainable and scalable way, inspired by architectural principles such as Clean Architecture and Hexagonal Architecture ( Like Adapter is domain-impl and port is domain) .

 
### Advantages:
- **Single-Stop Management of Resources:** Managing data and functions from a central point provides consistency and order within the system.
- **Independence Between Layers:** Thanks to the independence between layers, it is possible to develop each module on its own without being affected by changes.
- **Modularity:** Since the system has a modular structure, it is easier to integrate new features or changes.
- **Testability:** The independence of each layer makes testing processes more efficient and focused.

### Disadvantages:
- **Configuration Complexity:** The multitude of layers and modules.
- **Dependency Management:** Maintaining the independence of each module can become difficult as the project grows.

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

### App Screens:

![1](https://github.com/basaransuleyman/suleyman-basaranoglu-json/blob/main/dynamichome.png)
![1](https://github.com/basaransuleyman/suleyman-basaranoglu-json/blob/main/detailhome.png)
![1](https://github.com/basaransuleyman/suleyman-basaranoglu-json/blob/main/listpage.png)

 
