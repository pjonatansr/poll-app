# Welcome to Coop-Poll-App
That project solves a hypothetical situation where some cooperative members need an app to vote.

## Get started

### Create Poll
To create a poll, you can use the follows action in the endpoint "/api/v1/polls" with the HTTP POST method. That endpoint receives a body request with three parameters:

|Property|Type|Description|
|---|---|---|
|Description| String | Question of the poll|
|DurationMinutes| int | Total session duration|
|StartDate|LocalDateTime| Date to starts the poll|

RequestBody Example:
```JSON
{
  "description": "Shall we use blockchain?",
  "durationMinutes": 30,
  "startDate": "2022-03-04T08:53:49.758Z"
}
```

Whenever the user creates a poll, the application will generate a session and schedule a QuartzJobBean to the poll end date. That job will be responsible to call the method to calculate the result. 
The QuartzJobs aren't persisted in database, if the application stops when a QuartzJob is waiting to execute, the QuartzJob will only execute when the next access to the result occurs.

### Vote
To vote, do you need to wait until the respective poll start. After that, you only have the time given through the duration inserted with the registered pull.  You can use the POST method /api/v1/sessions/{sessionId}/votes, passing the sessionId in the URL and the request body with the follows parameters:

|Property|Type|Description|
|---|---|---|
|value| boolean| Value of the vote|
|member| Member | The member that vote|
|member.id| long | ID of the member|
|member.cpf|String| CPF of the member|

See the example:
```JSON 
{
    "value": true, 
    "member": {
        "id":11,
        "cpf":"85474096534"
    }
}
```
The property value above is our vote, so you need to set true for approve and false for reject the poll.

To improve the performance, the thought solution was to enable users to insert votes with no limitation before the session ends, therefore the user can input the vote many times but only the last vote of each member will be computed in the result calculation. That strategy prevent to excessive checks to know if the user can vote and the table only receives inserts.

### Result
Whenever a session closes, the app executes the job that was scheduled with the poll. When the job run, it executes a service method that consolidate the poll result. If the Pull isn't calculated after a minimum of 5 minutes, the service will calculate because it assumes that an error occurred. That action receives no parameters besides the Session Id in the URL. See: /api/v1/sessions/**1**/results

### Published version 
Here is the link for the published version that was deployed on heroku

URL: https://coop-poll.herokuapp.com/