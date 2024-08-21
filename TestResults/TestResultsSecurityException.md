1.Product Crud

a. Find All product

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

GET http://localhost:8080/product

Response

Status : 401 Unauthorized

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

Status : 401 Unauthorized

c. Update new product

Request

PUT http://localhost:8080/product

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

{
"productId": 2,
"productName": "e",
"brand": "t",
"description": "t",
"productUrl": "t"
}

Response

Status : 401 Unauthorized

d. Delete Product

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

DELETE http://localhost:8080/product/2

Response
Status : 401 Unauthorized

2. Order Crud

a. Find All Orders

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

GET http://localhost:8080/order

Response

Status : 401 Unauthorized

b. Create New Order

Request

POST http://localhost:8080/order

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

    {
        "orderId": 1,
        "orderName": "u"
    }

Response :

Status : 401 Unauthorized

c. Update Order

Request

PUT http://localhost:8080/order

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

    {
        "orderId": 2,
        "orderName": "m"
    }

Response

Status : 401 Unauthorized

Delete Order

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

DELETE http://localhost:8080/order/2

Response

Status : 401 Unauthorized

3. User Crud

a. Find all members

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

GET http://localhost:8080/member

Response :

Status : 401 Unauthorized

b. Save a member

POST http://localhost:8080/member

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

{
"memberId": 1,
"memberName": "u",
"memberUrl": "t"
}

Response :

Status : 401 Unauthorized

c. Update a member :

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

PUT http://localhost:8080/member

{
"memberId": 2,
"memberName": "k",
"memberUrl": "t"
}

Response :

status 401 Unauthorized

d. Delete member

Request

Header
tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

DELETE http://localhost:8080/member/2

Response :

401 Unauthorized

