Feature: Successful Jogging Time By User Listing
  Background:
    Given Admin user sends login request

#Date format: DD-MM-YYYY
  Scenario: Admin registers a jogging time and get list with date range filter including it
    Given Admin creates USER
    Given Admin registers jogging time by user for "27-7-2017" for last created user
    When Admin sends request to get jogging times by user from "24-7-2017" to "31-7-2017" for last created user
    Then The response should be successful
    And The response should contain array object of size 1

  Scenario: Admin registers two jogging times and get list with date range filter including them
    Given Admin creates USER
    Given Admin registers jogging time by user for "27-7-2017" for last created user
    Given Admin registers jogging time by user for "28-7-2017" for last created user
    When Admin sends request to get jogging times by user from "24-7-2017" to "31-7-2017" for last created user
    Then The response should be successful
    And The response should contain array object of size 2

  Scenario: Admin registers two jogging times for the same date and get list with date range filter including them
    Given Admin creates USER
    Given Admin registers jogging time by user for "27-7-2017" for last created user
    Given Admin registers jogging time by user for "27-7-2017" for last created user
    When Admin sends request to get jogging times by user from "24-7-2017" to "31-7-2017" for last created user
    Then The response should be successful
    And The response should contain array object of size 2

  Scenario: Admin registers two jogging times for the same date as date range filter bounds
    Given Admin creates USER
    Given Admin registers jogging time by user for "24-7-2017" for last created user
    Given Admin registers jogging time by user for "31-7-2017" for last created user
    When Admin sends request to get jogging times by user from "24-7-2017" to "31-7-2017" for last created user
    Then The response should be successful
    And The response should contain array object of size 2

  Scenario: Admin registers one of the jogging times outside the date range filter
    Given Admin creates USER
    Given Admin registers jogging time by user for "23-7-2017" for last created user
    Given Admin registers jogging time by user for "31-7-2017" for last created user
    When Admin sends request to get jogging times by user from "24-7-2017" to "31-7-2017" for last created user
    Then The response should be successful
    And The response should contain array object of size 1

  Scenario: Admin registers both jogging times outside the date range filter
    Given Admin creates USER
    Given Admin registers jogging time by user for "23-7-2017" for last created user
    Given Admin registers jogging time by user for "1-8-2017" for last created user
    When Admin sends request to get jogging times by user from "24-7-2017" to "31-7-2017" for last created user
    Then The response should be successful
    And The response should contain array object of size 0

  Scenario: Admin registers three jogging times for the same date as date range filter bounds
    Given Admin creates USER
    Given Admin registers jogging time by user for "24-7-2017" for last created user
    Given Admin registers jogging time by user for "24-7-2017" for last created user
    Given Admin registers jogging time by user for "31-7-2017" for last created user
    When Admin sends request to get jogging times by user from "24-7-2017" to "31-7-2017" for last created user
    Then The response should be successful
    And The response should contain array object of size 3
