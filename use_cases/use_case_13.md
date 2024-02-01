
Use case: 13 Retrieve the top ten populated cities in a continent . 
==============================================================================

CHARACTERISTIC INFORMATION


Goal in Context
==============================================================================

As an analyst, I want to obtain a list of the top ten populated cities in a continent, so that I can use this information to aid in understanding the urban population distribution of a specified continent.

Scope
==============================================================================


Organizational black box

Level
==============================================================================

Primary task

Preconditions
==============================================================================


The system has access to a database containing population data for cities in a continent.

Success End Condition
==============================================================================


A list of the top  populated cities in a continent is provided to the analyst.

Failed End Condition
==============================================================================


No list is generated, or an error occurs during the retrieval process.

Primary Actor
==============================================================================


 Analyst

Trigger
==================

A request for population information is sent to the analyst by the organization. The analyst initiates the request to retrieve the list of cities in the continent organized by population order.

MAIN SUCCESS SCENARIO
==============================

1.  The analyst initiates the request to retrieve the list of top ten populated cities in a continent.
2.  The system receives the request.
3.  The system retrieves the population data of all cities in a specified continent from the database.
4.  The system organizes a list of the top ten populated cities in the continent.
5.  The system provides the ordered list of cities to the analyst according to the organization's request.

EXTENSIONS
==============================================================================


In step 3, if there is an error during the retrieval or processing of data, the system informs the analyst about the issue.

In step 3.1, if the database does not contain the required population data, the system informs the analyst that the information is unavailable.


SUB-VARIATIONS
==============================================================================


None.

SCHEDULE
==============================================================================


DUE DATE: 2/2/2024
