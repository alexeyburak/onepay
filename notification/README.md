# Notification Documentation

> POST

### Send notification

````
Link: /api/notifications/{userId}
Path parameters: ID of the user
Param: "type" - email type
Return: Message report
Success code: 200
````

*Email types*
```
GREETING, 
CHANGE_PASSWORD, 
DAILY
```