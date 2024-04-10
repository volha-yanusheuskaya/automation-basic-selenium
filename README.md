Run the Smoke suite from command line: mvn -Dbrowser=chrome -Denv=nonprod -Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml clean test

Run the Regression suite from command line: mvn -Dbrowser=chrome -Denv=nonprod -Dsurefire.suiteXmlFiles=src/test/resources/testng-regression.xml clean test

Run the Api suite from command line: mvn -Dbrowser=chrome -Denv=nonprod -Dsurefire.suiteXmlFiles=src/test/resources/testng-api.xml clean test

Run the Cucumber suite from command line: mvn -Dbrowser=chrome -Denv=nonprod -Dsurefire.suiteXmlFiles=src/test/resources/testng-cucumber.xml clean test