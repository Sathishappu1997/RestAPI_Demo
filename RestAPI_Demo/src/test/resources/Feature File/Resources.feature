Feature: To validate the Resources

@PostMethod
Scenario Outline: Validate the Post Method
Given Initialize base uri and base path
Then Call the pojo class 
Then Get the Response for Post Method with "<body>" "<title>" and "<author>"
And validate the Response using jsonpath

Examples: 
|body|title|author|
|API Rest|Automation|Franklin|
|Rest Assured|Automation|Joshi|

@PutMethod
Scenario: Validate the Put Method
Given Initialize base uri and base path
When call the put pojo class
Then Get the Response for Put Method
And validate the put Response using jsonpath

@DeleteMethod
Scenario: Validate the Delete Method
Given Initialize base uri and base path
When call the delete pojo class
Then Get the Response for delete Method
And validate the delete Response using jsonpath