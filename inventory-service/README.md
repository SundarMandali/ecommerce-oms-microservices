# 📦 Inventory Service

The **Inventory Service** is a core microservice of the E-Commerce Order Management System (OMS).  
It manages product data — including stock levels, pricing, and last updated timestamps — and ensures consistent inventory handling across the platform.

The service provides REST APIs for adding new products, viewing inventory, and updating stock quantities.  
It is also used by the **Order Service** (via Feign Client) to validate and reduce product stock when new orders are placed.

---

## ⚙️ Tech Stack
- **Language:** Java 17  
- **Framework:** Spring Boot  
- **Persistence:** Spring Data JPA  
- **Database:** MySQL (AWS RDS)  
- **Build Tool:** Maven  
- **Deployment:** AWS Elastic Beanstalk  

---

## 🚀 Key Features
- Add new products to inventory  
- Retrieve all products or by ID  
- Increase or decrease stock quantities  
- Prevent overselling using synchronized updates  
- Update product timestamp automatically on changes  

---

## 🧩 API Endpoints

| Method | Endpoint | Description |
|---------|-----------|-------------|
| **POST** | `/api/inventory` | Add a new product |
| **GET** | `/api/inventory` | Get all products |
| **GET** | `/api/inventory/{id}` | Get product by ID |
| **PUT** | `/api/inventory/{id}/add-stock?quantity={q}` | Increase stock quantity |
| **PUT** | `/api/inventory/{id}/reduce?quantity={q}` | Reduce stock quantity (called by Order Service) |

### 🧪 Sample Request – Add Product
```json
{
  "productName": "Pen",
  "stockQuantity": 75,
  "price": 15
}
