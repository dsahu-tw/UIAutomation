# README #

It is a boilerplate code for UI automation framework. It is V1.0.It can help any team to start UI automation quickly. 

### About Framework ###
* This code base will boost to start a UI automation project quickly.
* Here are some major features/functionalities provided by the boilerplate code
* * Thread safe driver object
* * Usage of enum where required
* * Controllable explicit wait strategy
* * Configurable data
* * Test data supply using data provider
* * Usage of method chaining in test steps,assertions and page functions
* * Detailed and beautiful report
* * Robust and reliable code base
* * Clean and Modular code
* * Custom annotations implementation
* * Retry of mailed test cases

### Tools ###
* Java 11
* Selenium
* Maven
* TestNG
* ExtentReport

### How to set up or run? ###
* Clone the repo
* From the root directory run `mvn clean test -PAll` to run all test cases
* All dependencies are included in pox.xml. Java 11 is required to run this application.

### Major external libraries used in the application ###
* Aeonbits --> Configuration management
* Bonigarcia --> For webdriver version management
* Lombork --> For Getter, Setter and Constructor managment
* TestNG--> Test execution, parallel test exectuion,
* joda-time--> For date time manipulation
* assertj-joda-time --> For date time assesrtions
* assertj --> Fluent assesrtions


### Reporting ###
* Extent report generated at /extent-report-out/

### About Major classes ###
* FrameworkAnnotations : It helps to implement custom annotation to add Authors and Category in test cases which reflects in extent report.
* FrameworkConstants : It helps to get all constant values required in the framework like driver path,report path, timeout etc.
* Driver and DriverManager : These classes help to create driver and make it thread-safe.
* WaitFactory : Implements explicit wait conditions 
* ListenerClass : Overrides methods from ITestListener, ISuiteListener and IRetryAnalyzer. Helps in better reporting
* ExtentReportManager, ExtentLogger and ExtentReport : Help in generating extent report.
* Configs, FrameworkConfigs : Help to read config values from properties file. 
* BasePage : It contains all wrapper functions around Selenium methods  

### What Next ###
* In next versions following features are planned to be added
* * Running automation from Docker
* * Parallel execution using Grid
* * Any suggestions / defect fixes



