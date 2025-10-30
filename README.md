# 🛒 E-Commerce Order Management Microservices

This project demonstrates a **scalable microservices-based Order Management System (OMS)** built using **Spring Boot**, **MySQL (RDS)**, and deployed on **AWS Elastic Beanstalk**.

It consists of two core services:
1. **Inventory Service** — Manages product stock levels  
2. **Order Service** — Handles order creation, status updates, and communicates with Inventory Service via Feign client  

---

## 🧩 Tech Stack
- **Language:** Java 17  
- **Framework:** Spring Boot  
- **Database:** MySQL (AWS RDS)  
- **Architecture:** Microservices  
- **Communication:** Feign Client (REST)  
- **Deployment:** AWS Elastic Beanstalk  
- **API Testing:** Postman  

---

## 🚀 Features
- Place orders and update order status  
- Validate inventory before confirming order  
- Reduce stock atomically to avoid overselling  
- Error handling for insufficient inventory  
- Independent databases for each microservice  
- AWS-hosted deployment for scalability  

---

## 🧪 API Testing

Use Postman to test all endpoints.

1. Import files from `/postman` folder:
   - `E-Commerce-OMS-Microservices.json`
   - `E-Commerce-OMS-Prod-Environment.json`
2. Select the **Prod** environment.
3. Use sample requests to test:
   - **POST** `/api/orders`
   - **PUT** `/api/orders/{id}/status`
   - **GET** `/api/inventory`

---

## 🗄 Database Schema
Refer `/docs/DDL_Scripts.sql` for SQL DDL scripts.

| Service | Database | Key Tables |
|----------|-----------|-------------|
| Inventory | inventory_db | inventory |
| Order | order_db | orders, order_items |

---

## 📦 Deployment

Each microservice is deployed on AWS Elastic Beanstalk and connected to separate MySQL RDS instances.

| Service | Environment URL |
|----------|----------------|
| Inventory Service | http://65.0.244.55 |
| Order Service | http://13.200.70.246 |

---

## 📬 Postman Testing
The `/postman` folder contains a ready-to-use collection and environment for API testing.

| File | Description |
|------|--------------|
| `E-Commerce-OMS-Microservices.json` | All API endpoints |
| `E-Commerce-OMS-Prod-Environment.json` | Base IPs for AWS environments |

---

## 📜 Author
**Sundar Mandali**  
Backend Developer (Java, Spring Boot, Microservices)

---

## ✅ Deliverables Summary
| Deliverable | Description | File |
|--------------|--------------|------|
| Postman Collection | All APIs | `/postman/E-Commerce-OMS-Microservices.json` |
| Environment File | Base IPs for AWS deployments | `/postman/E-Commerce-OMS-Prod-Environment.json` |
| GitHub Repo | Source code of both microservices | Repo root |
| DDL | SQL script for tables | `/docs/DDL_Scripts.sql` |
