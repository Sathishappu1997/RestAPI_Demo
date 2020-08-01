Feature: Vaidate all the method

Scenario: Validate all Resource
Given Initialize uri
When Call "PostAuthor" with "post" Method
Then API call got succes with status code 200
And "message" in Response body is "Data Inserted Successfully"