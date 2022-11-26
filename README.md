# BingeWorthyShows 2

The app shows the most popular TV shows from The Movie Database.

From the architectural point of view we have 3 levels:

* Data level based on repository pattern - it can be easily extended to support multiple levels of cache - in memory,
  database etc.
* Domain with the UseCase.
* Presentation based on MVVM and observables: AndroidX ViewModel, coroutines, and LiveData.

Code is fully in Kotlin, auto-formatted from the IDE, and most of lint/detekt warnings have been addressed during the
development.

Most classes have been unit tested as example of the different situation: JUnit 5, Mockk, Test utilities for coroutines
and livedata

# Highlights about the  implementation

## Project Level / gradle

1. custom .gitignore .
1. minor improvements on gradle files to better support additional module - common versioning.
1. packages organised on architecture levels and on a per-feature basis.

## Architectural level

1. Clean approach: each different level (data, domain, and presentation) follows a clear dependency graph and could be easily separated in a different gradle
   sub-project to improve build time, decoupling, and modularisation.
   1. Domain level has no other dependencies - dependency inversion for data - Repository Interface
   2. Domain level has no Android dependencies for fast unit testing
2. Data level based on repository: more complex caching could be easily handled via specific logic and additional
   datasources implementation.
3. Presentation based on MVVM and observables: AndroidX ViewModel and LiveData.
4. Dependency Injection: a DI manager for each level handles instantiation, it could easily be replaced by Dagger in
   more complex projects.

## Code Level

1. Code fully kotlin
1. Static code analysis (Lint/Detekt) issues kept to a minimum.
1. Code was commented where more info seemed to be useful to the reader, generally speaking the code is written in a
   self-explanatory manner.
1. Unit test - almost all classes have been unit tested - using JUnit 5, Mockk, Test utilities for coroutines and
   livedata.

## Variants

An RxJava3 version can be found in [this branch](https://github.com/guidovezzoni/BingeWorthyShows2/tree/main-rxjava3)

A PR comparing the Coroutines+LiveData solution and the RxJava one can be
found [here](https://github.com/guidovezzoni/BingeWorthyShows2/pull/4/files)
