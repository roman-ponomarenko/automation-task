# TEST FRAMEWORK

This framework is intended to be used for automation of UI / API tests 

## Tests Execution

### Preconditions for Run
1) JDK 11 must be installed 
2) Chrome / Firefox browsers must be installed

### Tags (Test Suites)
- `all` - runs all tests by setting -DincludeTags=all
- `ui` - runs ui tests by setting -DincludeTags=ui
- `api` - runs api tests by setting -DincludeTags=api

### Browsers
You can specify browser for test execution by setting test.browser param e.g. :
- `chrome` - to execute tests for fantasy site set -Dbrowser=chrome
- `firefox` - to execute tests for league site set -Dbrowser=firefox

## How to Run
### Examples of Terminal Commands
 ```bash
 $ ./gradlew clean test -DincludeTags=all -Dbrowser=chrome
 ```
 ```bash
 $ ./gradlew clean test -DincludeTags=all -Dbrowser=firefox
 ```
 ```bash
 $ ./gradlew clean test -DincludeTags=ui -Dbrowser=chrome
 ```
 ```bash
 $ ./gradlew clean test -DincludeTags=ui -Dbrowser=firefox
 ```
 ```bash
 $ ./gradlew clean test -DincludeTags=api -Dbrowser=chrome
 ```
 ```bash
 $ ./gradlew clean test -DincludeTags=api -Dbrowser=firefox
 ```

## Test Reports 
- To generate and open report execute command below
 ```bash
 $ ./gradlew allureReport allureServe
 ```