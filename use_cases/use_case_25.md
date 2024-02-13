USE CASE 25: Retrieve population of people, people living in cities, and people not living in cities in each country.
---------------------------------------------------------------------------------------------------

CHARACTERISTIC INFORMATION
------------------------------------------------------------------

Goal in Context
---------------------------------

As an analyst, I aim to analyze and present a detailed overview of the population, distinguishing between people living in cities and those not living in cities, for each country so that I can provide valuable insights into the demographic composition of individual countries.



Scope
---------------------------------

organizational black box

Level
---------------------------------

Primary task

Preconditions
---------------------------------

The system has access to a database containing the population data for all countries.


Success End Condition
---------------------------------

A detailed analytical report is generated, presenting population data for people, people living in cities, and people not living in cities, organized by continent.


Failed End Condition
---------------------------------

No list is generated, or an error occurs during the retrieval process.


Primary Actor
---------------------------------


Analyst


Trigger
---------------------------------

A request for demographic analysis, specifically focusing on population data categorized by people, people living in cities, and people not living in cities in each country, is initiated.


MAIN SUCCESS SCENARIO
---------------------------------

1. The manager initiates the request to retrieve the list of countries organized by population order.
2. The system receives the request.
3. The system retrieves the population data of all countries from the database.
4. The system organizes the list of countries from largest population to smallest.
5. The system provides the ordered list of countries to the manager according to organization request. 



EXTENSIONS
---------------------------------

In step 3,

1. if there is an error during the retrieval or processing of data, the system informs the analyst about the issue.
2. if the database does not contain the required population data, the system informs the analyst that the information is unavailable.


SUB-VARIATIONS
---------------------------------
  
None.


SCHEDULE
---------------------------------

DUE DATE: 16/2/2024
