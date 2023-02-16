# User Documentation

<hr>

> GET
 
#### Get user list
````
Link: /api/users
Return: all users from database
Responces: 200 :red_circle:
````

#### Get user by ID
````
Link: /api/users/{id}
Path parameters: ID of the user being returned 
Return: founded user
Success code: 200
Error code: 404
````

<hr>

>POST

#### Add new user
````
Link: /api/users
Return: String successful message
Success code: 201
````
Required @RequestBody example:
````json
{
  "name": "Alexey",
  "surname": "Burak",
  "password": "password"
}
````

<hr>

> DELETE

#### Delete user
````
Link: /api/users/{id}
Path parameters: ID of the user being deleted 
Return: String successful message
Success code: 200
````

<hr>

> PUT

#### Update user
````
Link: /api/users/{id}
Path parameters: ID of the user being updated  
Return: String successful message
Success code: 200
````
Required @RequestBody example:
````json
{
  "name": "Alexey",
  "surname": "Burak",
  "password": "password"
}
````