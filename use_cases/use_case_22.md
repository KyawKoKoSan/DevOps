Use case: 22 Retrieve top ten populated capital cities in a region. 
==============================================================================

CHARACTERISTIC INFORMATION
===

Goal in Context
==============================================================================

As an analyst I aim to retrieve a list of the top ten most populated capital cities within a specified region so that I can use this information which  is essential for gaining insights into the demographic distribution within the region, assisting in regional planning, and supporting decision-making processes related to infrastructure development, economic policies, and resource allocation within the specific regional context.

Scope
==============================================================================


Organizational black box

Level
==============================================================================

Primary task

Preconditions
==============================================================================


The system has access to a database containing population data for capital cities of the region. 

Success End Condition
==============================================================================

A list of the top ten populated capital cities of the region ,  is provided to the analyst.

Failed End Condition
==============================================================================

No list is generated, or an error occurs during the retrieval process and the system will show "Failed to get top populated capital cities in the region" message.

Primary Actor
==============================================================================


 Analyst

Trigger
==================

The analyst initiates a request to retrieve the list of the top ten populated capital cities of the region.

MAIN SUCCESS SCENARIO
==============================

1.  The analyst initiates the request to retrieve the list of the top ten populated capital cities of the region.
2.  The system receives the request.
3.  The system retrieves the population data of all capital cities of the region from the database.
4.  The system organizes a list of the top ten populated capital cities of the region.
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
