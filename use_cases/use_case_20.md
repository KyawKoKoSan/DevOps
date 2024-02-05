Use case: 20 Retrieve top ten populated capital cities in the world. 
==============================================================================

CHARACTERISTIC INFORMATION
==========================


Goal in Context
==============================================================================

As an analyst , I aim to retrieve information on the top ten populated capital cities worldwide, so that I can use this functionality  for obtaining a customizable overview of the most densely populated capital cities globally, facilitating research, and aiding in comparative analyses.

Scope
==============================================================================


Organizational black box

Level
==============================================================================

Primary task

Preconditions
==============================================================================


The system has access to a  database containing population data for capital cities. 

Success End Condition
==============================================================================

A list of the top ten populated capital cities worldwide,  is provided to the analyst.

Failed End Condition
==============================================================================


No list is generated, or an error occurs during the retrieval process.

Primary Actor
==============================================================================


 Analyst

Trigger
==================
The analyst initiates a request to retrieve the list of the top ten populated capital cities globally.

MAIN SUCCESS SCENARIO
==============================
1.  The analyst initiates the request to retrieve the list of the top ten populated capital cities globally.
2.  The system receives the request.
3.  The system retrieves the population data of all capital cities from the database.
4.  The system organizes a list of the top ten populated capital cities.
6.  The system provides the ordered list of capital cities to the analyst according to the organization's request.
   

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
