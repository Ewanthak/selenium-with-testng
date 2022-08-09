# selenium-with-testng
Skeleton for a selenium UI test framework with TestNG

##  Prerequisites to run the tests

* java version 17.0.4 [Download here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* Apache Maven 3.8.6 [Download here](https://maven.apache.org/download.cgi)
* IDE (Eclipse is preferred) [Download here](https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers)
* Install TestNG in Eclipse

## Importing the project or IDE

* Clone the repository and open in your preferred IDE
	* If eclipse
	    ```
		Import -> Existing Maven Project -> Select the project folder -> Finish 
		```

## How to execute the tests

* Tests can be executed both from IDE or Commandline
	* IDE
		* Right-Click on the test file select Run As -> TestNG Test
	
	* Commandline
		* Execute the following command from root directory 
			```command
			mvn clean test
			```

#Errors & Trobleshooting

* **Class file has wrong version 52.0, should be 50.0**
	* If you get this error update the JAVA_HOME in your environment variable with the Java version mentioned in the Prerequisites
	* Reopen the CMD of Git Bash then execute java -version command if it gives you the version on you just updated
	* Run the test execution command if successfull you should get the following output
	```
	[INFO] Results:
	[INFO]
	[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
	```