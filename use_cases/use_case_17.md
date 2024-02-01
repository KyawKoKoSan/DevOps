Use case: 17 Retrieve All the capital cities in the world organized by largest population to smallest.
=============================================================================================================

CHARACTERISTIC INFORMATION
==========================


Goal in Context
==============================================================================

As a data analyst, I aim to retrieve a comprehensive list of all capital cities worldwide, organized by population from the largest to the smallest , so that I can use this information will be crucial for understanding the global urban population distribution and supporting decision-making processes related to urban planning and development.


Scope
==============================================================================


Organizational black box

Level
==============================================================================

Primary task

Preconditions
==============================================================================


The system has access to a database containing population data for capital cities.

Success End Condition
==============================================================================


A list of all capital cities around the world, organized by population from the largest to the smallest, is provided to the analyst.
Failed End Condition
==============================================================================


No list is generated, or an error occurs during the retrieval process.

Primary Actor
==============================================================================

Analyst

Trigger
==================

A request for population information is sent to the analyst by the organization. The analyst initiates the request to retrieve the list of capital cities organized by population order.

MAIN SUCCESS SCENARIO
==============================

1.  The analyst initiates the request to retrieve the list of all capital cities organized by population order.
2.  The system receives the request.
3.  The system retrieves the population data of all capital cities from the database.
4.  The system organizes a comprehensive list of all capital cities worldwide by population.
5.  The system provides the ordered list of capital cities to the analyst according to the organization's request.

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
