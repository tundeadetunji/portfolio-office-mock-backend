## Microservices Sample

When a payment is made from the Android app by the user, the Java Spring Boot backend API captures the call and transmits the information to both the **Client Service** (which determines how much the user has spent on our products so far and is used for interacting with the client - like rewards, coupons etc) and the **Product Service** (which keeps track of how many products have been sold so far). Any member of staff with right privileges sees the information in real time.
