-- 관리자 계정
INSERT INTO `user` (id, username, password, name, email)
VALUES (UUID(), 'admin', '$2a$10$6f5kvQeRECCL9ZQOIdwgwuIWLOHAgskPMu6JT58wb5/74Z5y35wHC', '관리자', 'admin@naver.com');

INSERT INTO `user_auth` (id, username, auth )
VALUES ( UUID(), 'admin', 'ROLE_USER'),
	   ( UUID(), 'admin', 'ROLE_ADMIN')
;