# Balance Documentation

> GET

### Get user balance
````
Link: /api/balances/{userId}
Path parameter: ID of the user being founded 
Return: BigDecimal value of user balance from database
Success code: 200
````
*Returning example*
```json
50000.23
```

### Get user operations history
````
Link: /api/operations/{userId}
Path parameter: ID of the user being founded 
Param (required = false): Sorting from date
Return: list of all user operations 
Success code: 200
````

*Returning example*
```json
[
    {
        "id": 534534,
        "userId": 1,
        "sum": 2000.0,
        "dateCreatedAt": "2023-02-18",
        "timeCreatedAt": "21:45:34",
        "type": "ENTRANCE",
        "status": "SUCCESSFUL"
    },
    {
        "id": 534535,
        "userId": 1,
        "sum": 50000.23,
        "dateCreatedAt": "2023-02-18",
        "timeCreatedAt": "21:49:12",
        "type": "DEBITING",
        "status": "CANCELED"
    }
]
```

<hr>

>POST

### Debiting from user balance

````
Link: /api/balances/{userId}/deb
Path parameter: ID of the user being debited
Param: BigDecimal value of operation sum
Return: String report message
Success code: 200
Error code: 423
````

### Entrance to user balance

````
Link: /api/balances/{userId}/ent
Path parameter: ID of the user being entranced
Param: BigDecimal value of operation sum
Return: String report message
Success code: 200
````

> DELETE

### Delete operation by id

````
Link: /api/operations/{id}
Path parameter: ID of the operation being deleted
Return: String report message
Success code: 200
````
