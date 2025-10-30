-- =============================================================
-- DDL Scripts for E-Commerce Order Management Microservices
-- =============================================================

-- =============================================================
-- INVENTORY SERVICE TABLES
-- =============================================================

CREATE TABLE `inventory` (
  `product_id` BIGINT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(255) DEFAULT NULL,
  `stock_quantity` INT DEFAULT NULL,
  `price` DOUBLE DEFAULT NULL,
  `last_updated` DATETIME(6) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB 
AUTO_INCREMENT=4 
DEFAULT CHARSET=utf8mb4 
COLLATE=utf8mb4_0900_ai_ci;

-- =============================================================
-- ORDER SERVICE TABLES
-- =============================================================

CREATE TABLE `orders` (
  `order_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT DEFAULT NULL,
  `total_amount` DOUBLE DEFAULT NULL,
  `order_status` ENUM('PENDING','CONFIRMED','SHIPPED','DELIVERED','CANCELLED','SUCCESS') DEFAULT NULL,
  `created_at` DATETIME(6) DEFAULT NULL,
  `updated_at` DATETIME(6) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB 
AUTO_INCREMENT=4 
DEFAULT CHARSET=utf8mb4 
COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order_items` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT DEFAULT NULL,
  `quantity` INT DEFAULT NULL,
  `price_per_unit` DOUBLE DEFAULT NULL,
  `total_price` DOUBLE DEFAULT NULL,
  `order_id` BIGINT DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_items_orders` (`order_id`),
  CONSTRAINT `FK_order_items_orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB 
AUTO_INCREMENT=4 
DEFAULT CHARSET=utf8mb4 
COLLATE=utf8mb4_0900_ai_ci;
