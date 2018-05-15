Feature: Testing OMDB API

Scenario: Test the API
Given a film exists wuth the Title IT
When a user retreives the film by title
Then the status code reads 200
 