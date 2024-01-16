Navigation Module - `navigation`

This module orchestrates the screen transitions and manages the navigation routes within the app. The Navigator class is equipped with functions that facilitate navigation to different screens, while AppNavigation is responsible for setting up the navigation routes.

Advantages:

Centralized Navigation Handling: A dedicated class for navigation streamlines all navigation-related logic into a single, manageable location.
Separation of Concerns: AppNavigation focuses exclusively on route configuration, allowing Navigator to handle the execution of navigation commands without interference.
Flexibility: Supports dynamic navigation flows and is readily extensible to incorporate new features or screens, catering to the evolving needs of the application.

Disadvantages:

Startup Time: While @Composable screen functions are only invoked when necessary, the impact on the app's startup time can vary depending on project complexity and screen content it needs to be tried with its project.
Documentation: Without well-documented argument-passing systems,  may find it challenging to grasp the navigation logic.
