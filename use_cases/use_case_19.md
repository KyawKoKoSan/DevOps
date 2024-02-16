Use case: 19 Retrieve all the capital cities in a region organized by largest to smallest.
==============================================================================

CHARACTERISTIC INFORMATION
==========================


Goal in Context
==============================================================================

As an analyst, the goal is to acquire a detailed list of all capital cities within a specified region, organized in descending order based on population, so that I can use this information is crucial for understanding the population dynamics within the region, facilitating regional planning, and aiding policymakers in making informed decisions related to infrastructure, economic development, and public services.

Scope
==============================================================================


Organizational black box

Level
==============================================================================

Primary task

Preconditions
==============================================================================


The system has access to a database containing population data for capital cities in the region.

Success End Condition
==============================================================================


A list of all capital cities in the region, organized by population from the largest to the smallest, is provided to the analyst.

Failed End Condition
==============================================================================

No list is generated, or an error occurs during the retrieval process and the system will show "Failed to get capital city details by region" message.

Primary Actor
==============================================================================


 Analyst

Trigger
==================

A request for population information is sent to the analyst by the organization. The analyst initiates the request to retrieve the list of capital cities of the region organized by population order.

MAIN SUCCESS SCENARIO
==============================

1.  The analyst initiates the request to retrieve the list of all capital cities of the region organized by population order.
2.  The system receives the request.
3.  The system retrieves the population data of all capital cities of the region from the database.
4.  The system organizes a comprehensive list of all capital cities of the region by population.
5.  The system provides the ordered list of capital cities of the region to the analyst according to the organization's request.
   
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
