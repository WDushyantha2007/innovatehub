1. Product save with bad data

Request

tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

POST http://localhost:8080/product

{
"productId": 0,
"productName": "",
"brand": "t",
"description": "t",
"productUrl": "t"
}

Response :

Status : 400 Bad Request

{
"productId": 0,
"productName": "",
"brand": "t",
"description": "t",
"productUrl": "t",
"message": "Invalid product",
"statusCode": "BAD_REQUEST"
}

2. Order save with bad data

Request

tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

POST http://localhost:8080/order

{
"orderId": 1,
"orderName": ""
}

Response :

Status : 400 Bad Request

{
"orderId": 1,
"orderName": "",
"message": "Invalid order request",
"statusCode": "BAD_REQUEST"
}

3. member save with bad data

Request

tokenID: 2a0716a8-f107-423a-a1d3-f4478266311c

POST http://localhost:8080/member

{
"memberId": 1,
"memberName": "",
"memberUrl": "t"
}

Response :

Status : 400 Bad Request

{
"memberId": 1,
"memberName": "",
"memberUrl": "t",
"message": "User is not valid",
"statusCode": "BAD_REQUEST"
}