# Retailer App (Backend)

### Description
A program to calculate the reward points earned for each customer per month and total based on their 3 months transactions (reading sample transactions from resources path). The backend logic is developed using Spring Boot with Rest API.

#### Rest API Documentation
![image](https://user-images.githubusercontent.com/112087209/187037885-d6551c8a-cbef-41d2-a2ec-579ed0e779fd.png)

#### Sample Response Data Format
[
  {
    "customerName": "string",
    "transactionDate": "string",
    "price": 0,
    "rewardPoints": 0
  }
]

![image](https://user-images.githubusercontent.com/112087209/187037920-479f8106-d55e-4541-b44c-870da9f19b48.png)

#### Invoke the API using Swagger
![image](https://user-images.githubusercontent.com/112087209/187190149-728f702f-b62b-4c32-9b6e-e6384a449581.png)

#### Invoke the API using Postman client
![image](https://user-images.githubusercontent.com/112087209/187189786-92e2e41c-c7af-487e-b1e8-ac4c09396c3c.png)

#### Junit Test Case and Test Coverage
![image](https://user-images.githubusercontent.com/112087209/187182347-a58e181b-5cb3-4102-b7ff-aacc2768f0eb.png)

#### Data Model Design
![image](https://user-images.githubusercontent.com/112087209/187181945-b64f4463-1e15-40d2-86ed-b18e4b20c566.png)

#### Dataset in a table format that shows the customer list, transaction list, monthly total per customer, and 3 months summary
![image](https://user-images.githubusercontent.com/112087209/187033458-88bff196-31c3-4627-bbea-c98a42ed607b.png)

![image](https://user-images.githubusercontent.com/112087209/187033519-39fc5a87-7f53-478d-9bb0-1622cd8cc94d.png)

#### A Health Check Endpoint to check whether the service is running or not using Actuator
![image](https://user-images.githubusercontent.com/112087209/187043911-e1d4d989-9114-4d49-b7e6-f1aa3f140f8d.png)

#### Containerizing the app and pushing the Docker image into Docker Hub using Google jib maven plugin
![image](https://user-images.githubusercontent.com/112087209/187180894-49bb88db-0967-435b-80f1-d647b1545655.png)

![image](https://user-images.githubusercontent.com/112087209/187181238-b3dbe887-7064-48e9-80a6-1e0d6774032c.png)

#### Steps to run the dockerized API
Step 1:- run this command, docker run -it -p 8080:8080 malaipo/retailer-app to run the docker image

![image](https://user-images.githubusercontent.com/112087209/187239912-8b5ca530-375c-4e54-ab19-f8e2e6b2198d.png)

![image](https://user-images.githubusercontent.com/112087209/187241218-faced9f2-6ac1-487f-8629-7e17ef8d7cfb.png)

