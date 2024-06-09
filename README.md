# homeEase
Clone of urban company

# API Documentation

## Create User

```bash
curl --location 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=6CC3E744908D647AEEF84F82E982A557' \
--data '{
  "username": "testuser2",
  "password": "password123"
}'
```

## Login User

```bash
curl --location 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=6CC3E744908D647AEEF84F82E982A557; JSESSIONID=335142808249D3F8077DF41A6862A238' \
--data '{
  "username": "testuser2",
  "password": "password123"
}'
```

## Create Services

```bash
curl --location 'http://localhost:8080/services' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=335142808249D3F8077DF41A6862A238' \
--data '{
  "name": "Plumbing",
  "description": "Fixing pipes and leaks",
  "price": 50.0
}'
```

## Get All Services

```bash
curl --location 'http://localhost:8080/services' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=335142808249D3F8077DF41A6862A238'
```

## Create Service Providers

```bash
curl --location 'http://localhost:8080/serviceProviders' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=335142808249D3F8077DF41A6862A238' \
--data '{
  "name": "Alice Johnson",
  "services": [
    {
      "id": 1,
      "name": "Plumbing",
      "description": "Fixing pipes and leaks",
      "price": 50.0
    },
    {
      "id": 2
    }
  ]
}'
```

## Create Time Slot of Service Providers

```bash
curl --location 'http://localhost:8080/serviceProviders/1/timeSlots' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=335142808249D3F8077DF41A6862A238; JSESSIONID=335142808249D3F8077DF41A6862A238' \
--data '{
  "startTime": "2024-06-02T10:00:00", 
  "endTime": "2024-06-02T12:00:00"
}'
```

## Create Service Provider and Time Slot Mapping

```bash
curl --location 'http://localhost:8080/serviceTimeSlotMapping/' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=335142808249D3F8077DF41A6862A238; JSESSIONID=335142808249D3F8077DF41A6862A238' \
--data '{
  "service": {
    "id": 1,
    "name": "Plumbing",
    "description": "Fixing pipes and leaks",
    "price": 50.0
  },
  "timeSlot": {
    "id": 1,
    "startTime": "2024-06-02T10:00:00",
    "endTime": "2024-06-02T12:00:00"
  },
  "status": "AVAILABLE"
}'
```

## Get Service Provider Time Slot Mapping

```bash
curl --location 'http://localhost:8080/serviceServiceProviderTimeSlotMapping/service/1/timeSlot/1' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=335142808249D3F8077DF41A6862A238; JSESSIONID=335142808249D3F8077DF41A6862A238'
```

## Get Service Providers

```bash
curl --location 'http://localhost:8080/serviceProviders/byService/1' \
--header 'Cookie: JSESSIONID=335142808249D3F8077DF41A6862A238'
```

## Add Item to Cart

```bash
curl --location --request POST 'http://localhost:8080/cart/1/add?serviceId=1&serviceProviderId=1&timeSlotId=1&address=123%20Main%20St' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: JSESSIONID=335142808249D3F8077DF41A6862A238; JSESSIONID=335142808249D3F8077DF41A6862A238' \
--data-urlencode 'address=123 Main St'
```

## Checkout

```bash
curl --location --request POST 'http://localhost:8080/orders/checkout/1?paymentMethod=credit_card' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: JSESSIONID=335142808249D3F8077DF41A6862A238; JSESSIONID=335142808249D3F8077DF41A6862A238'
```
