Feature: To perform all the CRUD operations

  Scenario: To Perform the GET Operation on Employe DB
    Given The base URI is "http://localhost:3000"
    When I perform the Get Operation
    Then Response code should be 200

  Scenario: To Perform the POST Operation on Employe DB
    Given The base URI is "http://localhost:3000"
    When I enter the name as "Mary" and Salary as "5000"
    Then Response code should be 201

  Scenario: To Perform the DELETE Operation on Employe DB
    Given The base URI is "http://localhost:3000"
    When I perform the Delete operation
    Then Response code should be 200

    Scenario: To Perform the PUT Operation on Employe DB
    Given The base URI is "http://localhost:3000"
    When I update the name as "Mary2"  and salaryas "8000"
    Then Response code should be 200