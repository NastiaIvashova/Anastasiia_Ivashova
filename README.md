# Selenium Home task (3 variant)

Откройте https://opensource-demo.orangehrmlive.com/
- Ваш скрипт должен выполнить вход на сайт с учетными данными, указанными чуть выше форма входа (вход чуствительный к регистру - при присутствии пробелов).
Сценарий:
1. Add New record 
    1) RandomName  (Go to Admin -> Job - Pay Grades -> Click on the Add button)
    2) Add RandomName
    3) Save changes
2. Click on Add button in the section Assigned Currencies
    1) Select Currency
    2) Add Minimum and Maximum Salary
    3) Save changes          
5. Check that your changes are visible on the Pay Grades page [chech Pay Grade and Currency fields]
6. Select your field, click the Remove button and make sure your field is removed.

- Ivashova folder contains all my software project for Selenium Home task.

1) Selenium scenario is located in the test folder in the WebUI.Main package.
Path: https://github.com/NastiaIvashova/Anastasiia_Ivashova/tree/WebUI/Ivashova/src/test/java/WebUser/Main
   1. There is Authorization.java, which fills in the Username and Password text fields. Then he clicks on the Login button and successfully logs in as an Admin. 
   2. There is AddPayGradeRecord.java, which goes to Pay Grande page, adds Random name and saves this record.
   3. There is AddAssignedCurrency.java, which adds Assigned Currency for new created record ( it adds Currency, Min and Max salaries) and saves that record.
   4. There is DeleteAndCheckRecord.java, which checks User's record and deletes selected record (new user's created record).
   5. There is Main.java, which launches Chrome Browser, opens site and runs class methods (Authorization.java, AddPayGradeRecord.java, AddAssignedCurrency.java and DeleteAndCheckRecord.java)

2) Cucumber scenario is located in the test folder in the resources package and in the test folder in the CucumerSteps package.
    1. There is Cucumber.feature, which contains scenario. User authorizes, adds random name and assigned currency, saves record and then deletes it.
       Path: https://github.com/NastiaIvashova/Anastasiia_Ivashova/blob/WebUI/Ivashova/src/test/resources/Cucumber.feature
    2. There is CucumberStep.java, which contains all steps for Cucumber.feature.
       Path: https://github.com/NastiaIvashova/Anastasiia_Ivashova/blob/WebUI/Ivashova/src/test/java/CucumberSteps/CucumberStep.java

3) pom.xml contains information for a software project maintained by Maven. During execution, Maven first of all checks whether this file contains all the necessary data and whether all the data is syntactically correct. 
Path: https://github.com/NastiaIvashova/Anastasiia_Ivashova/blob/WebUI/Ivashova/pom.xml
