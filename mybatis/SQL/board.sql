-- Active: 1767920846202@@127.0.0.1@3306@aloha
-- 데이터 베이스 생성
CREATE DATABASE IF NOT EXISTS aloha;

-- 테이블 생성
CREATE TABLE `board` (
	`no` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`id` VARCHAR(64) DEFAULT NULL UNIQUE,
	`title` VARCHAR(100) NOT NULL,
	`wirter` VARCHAR(100) NOT NULL,
	`content` TEXT,
	`created_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_at` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 샘플 데이터
TRUNCATE Table board;

INSERT INTO board (id, title, writer, content)
VALUES
	(UUID(), '제목1', '작성자1', '내용1'),
	(UUID(), '제목2', '작성자2', '내용2'),
	(UUID(), '제목3', '작성자3', '내용3'),
	(UUID(), '제목4', '작성자4', '내용4'),
	(UUID(), '제목5', '작성자5', '내용5')
;