# 🛒 Order Service

The **Order Service** handles order creation, retrieval, and status updates.  
It communicates with the **Inventory Service** (via Feign Client) to validate stock and reduce product quantity before confirming the order.

---

## ⚙️ Tech Stack
- Java 17  
- Spring Boot  
- Spring Data JPA  
- MySQL (AWS RDS)  
- OpenFeign (for inter-service communication)

---

## 🚀 Features
- Place new orders  
- Validate inventory via Feign client  
- Update order status (e.g., PENDING → SHIPPED)  
- Transactional order placement (rollback on failure)  

---

## 🧱 Database Tables
- **orders**
- **order_items**

Refer `../docs/DDL_Scripts.sql` for table DDL scripts.

---

## 🧪 APIs

| Method | Endpoint | Description |
|---------|-----------|-------------|
| **POST** | `/api/orders` | Place a new order |
| **GET** | `/api/orders/{id}` | Get order by ID |
| **PUT** | `/api/orders/{id}/status?status={STATUS}` | Update order status |

**Sample Request:**
```json
{
  "userId": 1,
  "items": [
    {
      "productId": 2,
      "quantity": 1,
      "pricePerUnit": 15
    }
  ]
}
