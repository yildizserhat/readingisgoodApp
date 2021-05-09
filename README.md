
# Reading Is Good

ReadinIsGood is an online book retail firm which operates only on internet. Main target of ReadingIsGood is deliver to their customer within the same day. That is why stock consistency is the first priority for their vision operations.



## API Reference


#### Login with JWT token

```http
  POST /login
```
| Parametre | Tip     | Açıklama                       |
| :-------- | :------- | :-------------------------------- |
| `email`      | `string` | **Must**. Login email to get token  |
| `password`      | `string` | Login psw to get token |


#### RegisterCustomer

```http
  POST /api/customers
```

#### Get Customers

```http
  GET /api/customers
```

#### Get Customer By Id

```http
  GET /api/customers/{id}
```
#### Purchase

```http
  POST /api/checkout/purchase
```

#### Get Detailed Order By trackingNumber

```http
  GET /api/orders/search/findByOrderTrackingNumber?trackingNumber={trackingNumber}
```

#### Get All Order By Customer Email

```http
  GET /api/order/{email}
```

#### Get Product and stock info

```http
  GET /api/products
```


  
## Tech Stack

* Java 11
* Spring Boot
* Docker
* H2 database
## Postman

All Postman Requests are shared within the project.
  