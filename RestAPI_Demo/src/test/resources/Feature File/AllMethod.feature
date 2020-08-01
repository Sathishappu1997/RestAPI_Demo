Feature: Vaidate all the method

Scenario Outline: Validate all Resource
Given Initialize uri
When Call "<method>" with "<request>" Method
Then API call got succes with status code 200
And "message" in Response body is "<responsemessage>"

Examples:
|method|request|responsemessage|
|PostAuthor|post|Data Inserted Successfully|
|UpdateAuthor|put|Data updated successfully|
|DeleteAuthor|delete|Post Deleted Successfully|