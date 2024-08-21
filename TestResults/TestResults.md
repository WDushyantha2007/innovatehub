1.Product Crud

a. Find All product

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

GET http://localhost:8080/product

Response

Status : 200 OK

[
{
"productId": 1,
"productName": "t",
"brand": "t",
"description": "t",
"productUrl": "t"
}
]

b. Create New Product

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

POST http://localhost:8080/product

{
"productId": 0,
"productName": "t",
"brand": "t",
"description": "t",
"productUrl": "t"
}

Response

Status : 200 OK

{
"productId": 0,
"productName": "t",
"brand": "t",
"description": "t",
"productUrl": "t",
"message": "Product saved successfully",
"statusCode": "OK"
}

c. Update new product

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

PUT http://localhost:8080/product

{
"productId": 2,
"productName": "e",
"brand": "t",
"description": "t",
"productUrl": "t"
}

Response

Status : 200 OK

d. Delete Product

Request : 

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

DELETE http://localhost:8080/product/2

Response
Status : 200 OK

2. Order Crud

a. Find All Orders 

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

GET http://localhost:8080/order

Response

Status : 200 OK

[
{
"orderId": 1,
"orderName": "t"
}
]

b. Create New Order

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

POST http://localhost:8080/order

    {
        "orderId": 1,
        "orderName": "u"
    }

Response :

Status : 200 OK

{
"orderId": 1,
"orderName": "u",
"message": "Order saved successfully",
"statusCode": "OK"
}

c. Update Order

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

PUT http://localhost:8080/order

    {
        "orderId": 2,
        "orderName": "m"
    }

Response : 

Status : 200 OK

Delete Order 

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

DELETE http://localhost:8080/order/2

Response : 

Status : 200 OK

3. User Crud

a. Find all members

GET http://localhost:8080/member

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

Response :

Status : 200 OK

[
{
"memberId": 1,
"memberName": "t",
"memberUrl": "t"
},
{
"memberId": 3,
"memberName": "b",
"memberUrl": "t"
}
]

b. Save a member

POST http://localhost:8080/member

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

{
"memberId": 1,
"memberName": "u",
"memberUrl": "t"
}

Response :

Status : 200 OK

{
"memberId": 1,
"memberName": "u",
"memberUrl": "t",
"message": "member saved sucessfully",
"statusCode": "OK"
}

c. Update a member :

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

{
"memberId": 2,
"memberName": "k",
"memberUrl": "t"
}

Response : Status : 200 OK

d. Delete member

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

DELETE http://localhost:8080/member/2

Response: Status : 200 OK

4. Authorization Request

a. Request POST http://localhost:8080/login

{
"userId": 1,
"bCryptPassword": "$2a$12$gUx/v.wOsIdFctF.vzZ4p.8/PlBMaTM.JKCI.yR/FCMSzxk2NHhIu"
}

Response : 2a0716a8-f107-423a-a1d3-f4478266311c

