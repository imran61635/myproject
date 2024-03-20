#  Selenium GUI Automation Using Cucumber BDD 
  This is a Java Selenium Maven project using Cucumber Java BDD framework, TestNG and Extent Report. 
  The Scenario is given below
  Scenario: Bill wants to travel from DXB to LHR
       Given that Bill has decided to check available flights.
       When he looks at a return trip from DXB to LHR leaving one week from now.
       Then he should be shown the cheapest return ticket from DXB to LHR.
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for  testing purposes. 
### Prerequisites
Windows OS, JDK 1.8 or higher, Apache Maven 3.6, Latest Chrome browser ver 70 onwards / Mozilla firefox quantum ver 60.2 or higher
### Installing
Setup JAVA_HOME and MAVEN_HOME in environment variables of the local machine. Download the project in local machine and unzip it.
## Running the tests Using windows command prompt
Open the command prompt by typing cmd on run. Navigate to the directory where the project is.
Type command: mvn clean test
To run on Chrome or Firefox vice versa just update it in property file of the project.
## Running the tests Using Jenkins
Create the project in jenkins, Go to the build environment,  select top level maven targets in build section, provide path of POM.xml into the POM section and give "clean test" into the goal section and save. Go to the jenkins home, click the project and click build now.
