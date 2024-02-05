
Use case: 21 Retrieve top ten populated capital cities in a continent. 
==============================================================================

CHARACTERISTIC INFORMATION
===========================

Goal in Context
==============================================================================

As a analyst, I aim to obtain a list of the top ten most populated capital cities within a specified continents, so that I can use  this information  which is crucial for understanding the demographic landscape of the continent, facilitating regional planning, and aiding policymakers in making informed decisions related to infrastructure, economic development, and public services within that specific continental context.

Scope
==============================================================================


Organizational black box

Level
==============================================================================

Primary task
Preconditions
==============================================================================


The system has access to a database containing population data for capital cities of the continent.
Success End Condition
==============================================================================

A list of the top ten populated capital cities of the continent,  is provided to the analyst.
Failed End Condition
==============================================================================


No list is generated, or an error occurs during the retrieval process.

Primary Actor
==============================================================================


 Analyst

Trigger
==================

The analyst initiates a request to retrieve the list of the top ten populated capital cities of the continent.

MAIN SUCCESS SCENARIO
==============================
1.  The analyst initiates the request to retrieve the list of the top ten populated capital cities of the continent.
2.  The system receives the request.
3.  The system retrieves the population data of all capital cities of the continent from the database.
4.  The system organizes a list of the top ten populated capital cities of the continent.
5.  The system provides the ordered list of capital cities of the continent to the analyst according to the organization's request.
  

EXTENSIONS
==============================================================================


In step 3,

1. if there is an error during the retrieval or processing of data, the system informs the analyst about the issue.
2. if the database does not contain the required population data, the system informs the analyst that the information is unavailable.


SUB-VARIATIONS
==============================================================================


None.

SCHEDULE
==============================================================================


DUE DATE: 16/2/2024
