Feature: Successful Jogging Time Listing
  Background:
    Given User sends registration request
    And User sends login request

#Date format: DD-MM-YYYY
  Scenario: User gets report for a single year
    Given User registers jogging time for "27-7-2017"
    When User sends request to get speed average report
    Then The response should be successful
    And The response should contain array object of size 1

  Scenario: User gets report for a two years
    Given User registers jogging time for "27-7-2016"
    And User registers jogging time for "27-7-2015"
    When User sends request to get speed average report
    Then The response should be successful
    And The response should contain array object of size 2

  Scenario: User gets report with two jogging times in one year for different weeks
    Given User registers jogging time for "27-7-2016"
    And User registers jogging time for "27-12-2016"
    When User sends request to get speed average report
    Then The response should be successful
    And The response should contain array object of size 1
    And The response should have 2 in path "$[0].weeks.length()"

  Scenario: User gets report with two jogging times in one year for same weeks
    Given User registers jogging time for "27-7-2016"
    And User registers jogging time for "26-7-2016"
    When User sends request to get speed average report
    Then The response should be successful
    And The response should contain array object of size 1
    And The response should have 1 in path "$[0].weeks.length()"

  Scenario: User gets report with two jogging times in one year for different at the beginning and end of the year
    Given User registers jogging time for "31-12-2016"
    And User registers jogging time for "1-1-2017"
    When User sends request to get speed average report
    Then The response should be successful
    And The response should contain array object of size 2
    And The response should have 1 in path "$[0].weeks.length()"

  Scenario: Verify averageData sum from jogging times in the same week
    Given User registers jogging time for "27-7-2016" with distance 1000 and seconds 3600
    And User registers jogging time for "26-7-2016" with distance 2000 and seconds 3600
    When User sends request to get speed average report
    Then The response should be successful
    And The response should contain array object of size 1
    And The response should have 3000 in path "$[0].weeks[0].averageData.distance"
    And The response should have 7200 in path "$[0].weeks[0].averageData.time"
    And The response should have 1.5 in path "$[0].weeks[0].averageData.averageSpeed"

  Scenario: Verify averageData sum from 3 jogging times in the same week
    Given User registers jogging time for "1-1-2016" with distance 400 and seconds 600
    Given User registers jogging time for "1-1-2016" with distance 200 and seconds 700
    Given User registers jogging time for "1-1-2016" with distance 100 and seconds 1000
    And User registers jogging time for "26-7-2016" with distance 500 and seconds 1800
    And User registers jogging time for "26-7-2016" with distance 1000 and seconds 1800
    And User registers jogging time for "26-7-2016" with distance 1500 and seconds 1800
    When User sends request to get speed average report
    Then The response should be successful
    And The response should contain array object of size 1
    And The response should have 700 in path "$[0].weeks[0].averageData.distance"
    And The response should have 2300 in path "$[0].weeks[0].averageData.time"
    And The response should have 1.0956521739130436 in path "$[0].weeks[0].averageData.averageSpeed"
    And The response should have 3000 in path "$[0].weeks[1].averageData.distance"
    And The response should have 5400 in path "$[0].weeks[1].averageData.time"
    And The response should have 2 in path "$[0].weeks[1].averageData.averageSpeed"
