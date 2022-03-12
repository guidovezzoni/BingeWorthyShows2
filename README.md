# BingeWorthyShows 2

The app shows the most popular TV shows from The Movie Database.

From the architectural point of view we have 3 levels:

* Data level based on repository pattern - which can be easily extended to support multiple levels of cache
* Domain with the UseCase
* Presentation based on MVVM and observables: AndroidX ViewModel and LiveData

Code is fully in Kotlin, auto-formatted from the IDE, and most of lint/detekt warnings have been addressed during the
development

Most classes have been unit tested as example of the different situation: JUnit 5, Mockk, Test utilities for coroutines and livedata

# Highlights about the  implementation

## Project Level / gradle

1. custom .gitignore
1. minor improvements on gradle files to better support additional module (common versioning)
1. packages organised on a architecture-level and per-feature basis

## Architectural level

1. Clean approach: each different level (data, domain, and presentation) could be separated in a different gradle
   sub-project to improve build time, decoupling, and modularisation
1. Data level based on repository: more complex caching could be easily handled via specific logic and additional
   datasources implementation
1. Presentation based on MVVM and observables: AndroidX ViewModel and LiveData
1. Dependency Injection: a DI manager for each level handles instantiation, it could easily be replaced by Dagger in
   more complex projects

## Code Level

1. Fully kotlin code
1. Static code analysis (Lint/Detekt) issues kept to a minimum
1. Code was commented where more info seemed to be useful, generally speaking the code is written trying to be
   self-explanatory
1. Unit test - most classes have been unit tested - using JUnit 5, Mockk, Test utilities for coroutines and livedata

## Variants

An RxJava3 version can be found in this branch: [https://github.com/guidovezzoni/BingeWorthyShows2/tree/main-rxjava3]

If you wish to compare the difference between Coroutines+LiveData and RxJava, you can check them here: [link]
