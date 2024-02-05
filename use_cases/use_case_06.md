USE CASE: 6 Retrieve List of top ten populated countries in a region
================================================================================

CHARACTERISTIC INFORMATION
=================================

Goal in Context
===================

As an Analyst, I want to retrieve a list of top ten populated countries in a region, so that I can use this information to assist the understanding of the demographic distribution of the specific population of the countries in a region.

Scope
==========
 
organizational black box

Level
==========

Primary task.

Preconditions
=================

The system has access to a database containing data for populated countries in a region.

Success End Condition
=========================

A list of countries in a region, ordered by top ten, is provided to the Analyst.

Failed End Condition
======================

No list is generated, or an error occurs during the retrieval process the system will show "Failed to get top populated countries in the region" message.

Primary Actor
=================

Analyst 

Trigger
============

A request for population information is sent to Analyst by organization. Analyst initiates the request to retrieve the list of countries in a region organized by top 10.

MAIN SUCCESS SCENARIO
==========================

1. The analyst initiates the request to retrieve the list of countries in a region organized by top 10.
2. The system receives the request.
3. The system retrieves the population data of all countries in a region from the database.
4. The system organizes the list of countries in a region by top 10.
5. The system provides the ordered list of top ten populated countries in a region to the analyst according to organization request. 

EXTENSIONS
================

In step 3,

1. if there is an error during the retrieval or processing of data, the system informs the analyst about the issue.
2. In step 3.1, if the database does not contain the required population data, the system informs the analyst that the information is unavailable.

SUB-VARIATIONS
====================

None.

SCHEDULE
================

DUE DATE: 2/2/2024
