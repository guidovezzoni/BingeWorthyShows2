# Highlights about the  implementation

## Project Level / gradle

1. custom .gitignore
1. minor improvements on gradle files to better support additional module (common versioning)
1. packages organised on a architecture-level and per-feature basis

## Architectural level
1. Clean approach: each different level (data, domain, and presentation) could be separated in a
   different gradle sub-project to improve build time, de-coupling, and modularisation
1. Data level based on repository: more complex caching could be easily handled via specific logic
   and additional datasources implementation
1. Presentation based on MVVM and observables: AndroidX ViewModel and LiveData
1. Dependency Injection: a DI manager handles instantiation, it could easily be replaced by Dagger
   in more complex projects

## Code Level
1. Static code analysis (Lint/Detekt) issues kept to a minimum
1. Code was commented where not self-explanatory, always trying to stick with javadoc syntax
1. Fully kotlin
1. Unit test TODO
