1. Product Crud

a. Find All product

Request GET http://localhost:8080/product

Response

{
"productId": 0,
"productName": "t",
"brand": "t",
"description": "t",
"productUrl": "t"
}

b. Create New Product

Request POST http://localhost:8080/product

Response

{
"productId": 0,
"productName": "t",
"brand": "t",
"description": "t",
"productUrl": "t"
}

c. Update

PUT http://localhost:8080/product

{
"productId": 2,
"productName": "e",
"brand": "t",
"description": "t",
"productUrl": "t"
}

Response

Status : OK

d. Delete Product

DELETE http://localhost:8080/product/2

Response
Status : OK

2. Order Crud

a. Find All Orders GET http://localhost:8080/order

Response

[
{
"orderId": 1,
"orderName": "t"
}
]

e. Try to create invalid product

POST http://localhost:8080/product

{
"productId": 0,
"productName": "",
"brand": "t",
"description": "t",
"productUrl": "t"
}

Response

{
"productId": 0,
"productName": "",
"brand": "t",
"description": "t",
"productUrl": "t",
"message": "Invalid product"
}

b. Create New Order

    {
        "orderId": 1,
        "orderName": "u"
    }

Response :

Status : OK

c. Update Order

    {
        "orderId": 2,
        "orderName": "m"
    }

Response : Status : OK

Delete Order DELETE http://localhost:8080/order/2

Response : Status OK

3. User Crud

a. Find all members

GET http://localhost:8080/member

Response :

[
{
"memberId": 1,
"memberName": "t",
"memberUrl": "t"
}
]

b. Save a member

POST http://localhost:8080/member

{
"memberId": 1,
"memberName": "u",
"memberUrl": "t"
}

Response :

{
"memberId": 1,
"memberName": "u",
"memberUrl": "t"
}

c. Update a member :

{
"memberId": 2,
"memberName": "k",
"memberUrl": "t"
}

Response : status ok

d. Delete member

DELETE http://localhost:8080/member/2

Response: Status OK



