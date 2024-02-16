USE CASE 29: Retrieve   Population of the Country
---------------------------------

CHARACTERISTIC INFORMATION
------------------------------------------------------------------

Goal in Context
---------------------------------

As an analyst, I aim to provide the organization with timely and accurate demographic information, specifically focusing on the population of a country so that I can facilitate informed decision-making and strategic planning at a national level.


Scope
---------------------------------

organizational black box


Level
---------------------------------

Primary task


Preconditions
---------------------------------

The system has access to a comprehensive and up-to-date database containing population data for various countries.



Success End Condition
---------------------------------

The organization gains access to accurate and current information regarding the population of a specified country.


Failed End Condition
---------------------------------

No list is generated, or an error occurs during the retrieval process and the system will show "Failed to get country population details" message.

Primary Actor  
---------------------------------

Analyst

Trigger
---------------------------------

A request for demographic information, specifically focusing on the population of a country, is initiated by the organization.


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
