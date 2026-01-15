USE aloha;

DROP TABLE IF EXISTS product;
-- 테이블 생성
CREATE TABLE `product` (
  `no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `id` varchar(64) NOT NULL UNIQUE,
  `product_name` varchar(64) NOT NULL,
  `price` INTEGER NOT NULL,
  `stock` INTEGER NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 샘플 데이터
TRUNCATE Table product;

INSERT INTO product (id, product_name, price, stock)
VALUES 
  ( UUID(), '상품1', '5000', '10'),
  ( UUID(), '상품2', '10000', '50'),
  ( UUID(), '상품3', '15000', '30'),
  ( UUID(), '상품4', '8000', '60'),
  ( UUID(), '상품5', '6000', '40')
;

SELECT * FROM product;