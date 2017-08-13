Feature: Successful Jogging Time Listing
  Background:
    Given User sends registration request
    And User sends login request

#Date format: DD-MM-YYYY
  Scenario: User registers a jogging time and get list with date range filter including it
    Given User registers jogging time for "27-7-2017"
    When User sends request to get jogging times from "24-7-2017" to "31-7-2017"
    Then The response should be successful
    And The response should contain array object of size 1

  Scenario: User registers two jogging times and get list with date range filter including them
    Given User registers jogging time for "27-7-2017"
    And User registers jogging time for "28-7-2017"
    When User sends request to get jogging times from "24-7-2017" to "31-7-2017"
    Then The response should be successful
    And The response should contain array object of size 2

  Scenario: User registers two jogging times for the same date and get list with date range filter including them
    Given User registers jogging time for "27-7-2017"
    And User registers jogging time for "27-7-2017"
    When User sends request to get jogging times from "24-7-2017" to "31-7-2017"
    Then The response should be successful
    And The response should contain array object of size 2

  Scenario: User registers two jogging times for the same date as date range filter bounds
    Given User registers jogging time for "24-7-2017"
    And User registers jogging time for "31-7-2017"
    When User sends request to get jogging times from "24-7-2017" to "31-7-2017"
    Then The response should be successful
    And The response should contain array object of size 2

  Scenario: User registers one of the jogging times outside the date range filter
    Given User registers jogging time for "23-7-2017"
    And User registers jogging time for "31-7-2017"
    When User sends request to get jogging times from "24-7-2017" to "31-7-2017"
    Then The response should be successful
    And The response should contain array object of size 1

  Scenario: User registers both jogging times outside the date range filter
    Given User registers jogging time for "23-7-2017"
    And User registers jogging time for "1-8-2017"
    When User sends request to get jogging times from "24-7-2017" to "31-7-2017"
    Then The response should be successful
    And The response should contain array object of size 0

  Scenario: User registers three jogging times for the same date as date range filter bounds
    Given User registers jogging time for "24-7-2017"
    Given User registers jogging time for "24-7-2017"
    And User registers jogging time for "31-7-2017"
    When User sends request to get jogging times from "24-7-2017" to "31-7-2017"
    Then The response should be successful
    And The response should contain array object of size 3
