drop database if exists c0222g2_coffee;
create database c0222g2_coffee;
use c0222g2_coffee;

CREATE TABLE `app_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_deleted` bit(1) DEFAULT b'0',
  `role_name` varchar(255) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
);
CREATE TABLE `app_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `password` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL ,
  PRIMARY KEY (`id`)
);
CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL UNIQUE,
  `creation_date` date DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
);
CREATE TABLE `coffee_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL UNIQUE,
  `is_deleted` bit(1) DEFAULT b'0',
  `is_empty` bit(1) DEFAULT b'0',
  `status` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
);
CREATE TABLE `dish_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL UNIQUE,
  `is_deleted` bit(1) DEFAULT b'0',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `dish` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) NOT NULL UNIQUE,
  `creation_date` date DEFAULT NULL,
  `image` text,
  `is_deleted` bit(1) DEFAULT b'0',
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `dish_type_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`dish_type_id`) REFERENCES `dish_type` (`id`)
);
CREATE TABLE `position` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `image` text,
  `is_deleted` bit(1) DEFAULT b'0',
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL UNIQUE,
  `salary` double DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `position_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  FOREIGN KEY (`position_id`) REFERENCES `position` (`id`)
);
CREATE TABLE `dish_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT b'0',
  `quantity` int DEFAULT NULL,
  `bill_id` int DEFAULT NULL,
  `coffee_table_id` int DEFAULT NULL,
  `dish_id` int DEFAULT NULL,
  `employee_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`),
  FOREIGN KEY (`dish_id`) REFERENCES `dish` (`id`),
  FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  FOREIGN KEY (`coffee_table_id`) REFERENCES `coffee_table` (`id`)
);
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `content` text,
  `creator` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `feedback_date` varchar(255) DEFAULT NULL,
  `image` text,
  `is_deleted` int DEFAULT '0',
  `rating` int NOT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_deleted` bit(1) DEFAULT b'0',
  `role_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `app_user` (`id`),
  FOREIGN KEY (`role_id`) REFERENCES `app_role` (`id`)
);

-- App Role
INSERT INTO app_role (role_name) VALUES ('ROLE_ADMIN'); 
INSERT INTO app_role (role_name) VALUES ('ROLE_STAFF');
INSERT INTO app_role (role_name) VALUES ('ROLE_USER');

-- App User
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'manager', '2022-08-08');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'tunhutuyen', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'nguyentrungthuc', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'phamlelong', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'nguyentrungkien', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'dohuyhoang', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'buinhatminh', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'trantrongcung', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'nguyenminhquang', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'tranxuancung', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'phamhuynhnhatvuong', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'nguyennhattruongsinh', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'duongquangsinh', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'trantrongsinh', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'nguyenquangtruc', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table1', '2022-08-09');
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table2', '2022-08-09'); 
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table3', '2022-08-09'); 
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table4', '2022-08-09'); 
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table5', '2022-08-09'); 
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table6', '2022-08-09'); 
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table7', '2022-08-09'); 
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table8', '2022-08-09'); 
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table9', '2022-08-09'); 
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table10', '2022-08-09'); 
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table11', '2022-08-09'); 
INSERT INTO app_user (`password`, user_name, creation_date) 
VALUES ('$2a$10$NaPco7fYsB2Y/0xbQaOruum.w9V1nzHKqNYQ98/GQr7jCkKdZEg6q', 'table12', '2022-08-09'); 

-- User Role
-- admin account
INSERT INTO user_role (role_id, user_id) VALUES ('1', '1'); 
INSERT INTO user_role (role_id, user_id) VALUES ('2', '1');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '1');

-- staff acount
INSERT INTO user_role (role_id, user_id) VALUES ('2', '2');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '2');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '3');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '3');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '4');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '4');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '5');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '5');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '6');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '6');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '7');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '7');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '8');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '8');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '9');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '9');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '10');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '10');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '11');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '11');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '12');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '12');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '13');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '13');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '14');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '14');
INSERT INTO user_role (role_id, user_id) VALUES ('2', '15');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '15');

-- user account
INSERT INTO user_role (role_id, user_id) VALUES ('3', '16');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '17');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '18');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '19');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '20');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '21');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '22');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '23');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '24');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '25');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '26');
INSERT INTO user_role (role_id, user_id) VALUES ('3', '27');

-- Dish Type
INSERT INTO `dish_type` (`id`, `code`, `is_deleted`, `name`) VALUES ('1', 'CF-001', 0, 'Cà phê');
INSERT INTO `dish_type` (`id`, `code`, `is_deleted`, `name`) VALUES ('2', 'TS-001', 0, 'Trà sữa');
INSERT INTO `dish_type` (`id`, `code`, `is_deleted`, `name`) VALUES ('3', 'T-001', 0, 'Trà');
INSERT INTO `dish_type` (`id`, `code`, `is_deleted`, `name`) VALUES ('4', 'DU-001', 0, 'Nước ép');

-- Dish
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('1', 'CF-001', '2022-08-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20phe%CC%82%20du%CC%9B%CC%80a.jpeg?alt=media&token=ffd4f49e-d3c3-49b4-8165-57265745a9ff\n', 0, 'Cà Phê Dừa', '10000', '1');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('2', 'CF-002', '2022-08-15', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20phe%CC%82%20bo%CC%A3t%20bie%CC%82%CC%89n.jpeg?alt=media&token=532203fb-3864-41eb-9d3f-0c014396ae01\n', 0, 'Cà Phê Bọt Biển', '15000', '1');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('3', 'TS-003', '2022-08-14', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYa%CC%89nh%20ca%CC%80%20.jpeg?alt=media&token=0f534faa-01ce-4047-9feb-e897941fa6c6\n', 0, 'Trà Sữa Nóng', '10000', '2');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('4', 'CF-004', '2022-08-13', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYcf%20%C4%91en.jpeg?alt=media&token=d1250e75-3858-4e12-99f7-5283b2d43f38\n', 0, 'Cà Phê Đen', '10000', '1');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('5', 'CF-005', '2022-08-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20phe%CC%82.jpeg?alt=media&token=8daab48d-4be7-44e2-95a9-f56c09318356\n', 0, 'Cà Phê Sữa Nóng', '20000', '1');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('6', 'TS-006', '2022-08-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYtra%CC%80%20Su%CC%9B%CC%83as.jpeg?alt=media&token=34ec9ebc-8454-40f8-91d9-fdb19442d8d1\n', 0, 'Trà Sữa Đá', '20000', '2');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('7', 'CF-007', '2022-08-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYba%CC%A3c%20xi%CC%89u.jpeg?alt=media&token=f3c3d8b5-1f44-482c-acfb-d302b4cc0e9e\n', 0, 'Cà Phê Nóng', '23000', '1');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('8', 'NE-008', '2022-08-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnuoc-ep-xoai.jpeg?alt=media&token=64b1a854-b875-43ef-a572-f7a85bdbff65\n', 0, 'Nước Ép Xoài', '10000', '4');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('9', 'NE-009', '2022-08-15', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnu%CC%9Bo%CC%9B%CC%81c%20cam.jpeg?alt=media&token=f7aa02ed-7911-4387-9dff-e4f0e2b36f9e\n', 0, 'Nước Ép Cam', '25000', '4');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('10', 'NE-0010', '2022-08-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnu%CC%9Bo%CC%9B%CC%81c%20va%CC%83i.jpeg?alt=media&token=741ca70f-48f9-415e-94e8-5561fb9bfcb9\n', 0, 'Nước Ép Vải', '10000', '4');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('11', 'CF-0011', '2022-08-11', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20Phe%CC%82%20tru%CC%9B%CC%81ng.webp?alt=media&token=b3115e66-854b-412c-905e-5f700e28aacd', 0, 'Cà Phê Trứng', '25000', '1');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('12', 'CF-0012', '2022-08-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYba%CC%A3c%20xi%CC%89u.jpeg?alt=media&token=f3c3d8b5-1f44-482c-acfb-d302b4cc0e9e', 0, 'Bạc xỉu', '25000', '1');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('13', 'CF-0014', '2022-08-10', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYcf%20%C4%91en.jpeg?alt=media&token=d1250e75-3858-4e12-99f7-5283b2d43f38\n', 0, 'Cà Phê Đen', '15000', '1');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('14', 'CF-0015', '2022-08-09', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20phe%CC%82.jpeg?alt=media&token=8daab48d-4be7-44e2-95a9-f56c09318356\n', 0, 'Cà Phê Sữa Nóng', '25000', '1');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('15', 'TS-0016', '2022-08-07', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYtra%CC%80%20Su%CC%9B%CC%83as.jpeg?alt=media&token=34ec9ebc-8454-40f8-91d9-fdb19442d8d1\n', 0, 'Trà Sữa Đá', '25000', '2');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('16', 'CF-0017', '2022-08-09', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYba%CC%A3c%20xi%CC%89u.jpeg?alt=media&token=f3c3d8b5-1f44-482c-acfb-d302b4cc0e9e\n', 0, 'Cà Phê Nóng', '15000', '1');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('17', 'NE-0018', '2022-08-01', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnuoc-ep-xoai.jpeg?alt=media&token=64b1a854-b875-43ef-a572-f7a85bdbff65\n', 0, 'Nước Ép Xoài', '10000', '4');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('18', 'NE-0019', '2022-08-17', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16082022_07%3A01%3A54PM_soda.png?alt=media&token=fa591728-3f3f-49d8-9b69-f1f123acc7df', 0, 'Soda', '10000', '4');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('19', 'NE-0020', '2022-08-11', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnu%CC%9Bo%CC%9B%CC%81c%20va%CC%83i.jpeg?alt=media&token=741ca70f-48f9-415e-94e8-5561fb9bfcb9\n', 0, 'Nước Ép Vải', '15000', '4');
INSERT INTO `dish` (`id`, `code`, `creation_date`, `image`, `is_deleted`, `name`, `price`, `dish_type_id`) VALUES ('20', 'NE-0049', '2022-08-12', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnu%CC%9Bo%CC%9B%CC%81c%20cam.jpeg?alt=media&token=f7aa02ed-7911-4387-9dff-e4f0e2b36f9e\n', 0, 'Nước Ép Cam', '10000', '4');

-- Dish order 
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('1', '2', '1');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('2', '3', '1');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('3', '1', '2');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('4', '2', '2');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('5', '3', '3');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('6', '2', '3');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('7', '2', '3');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('8', '4', '3');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('9', '2', '4');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('10', '2', '4');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('11', '1', '4');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('12', '3', '2');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('13', '2', '2');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('14', '5', '3');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('15', '2', '3');
INSERT INTO `dish_order` (`code`, `quantity`, `dish_id`) VALUES ('16', '1', '1');



-- Position
INSERT INTO `position` VALUES
(1,'Quản Lý'),(2,'Phục Vụ'),(3,'Bảo Vệ'),(4,'Thu Ngân');

-- Employee
INSERT INTO employee VALUES
(1, '27-28, ngõ 294 Vạn Phúc, Kim Mã, Hà Nội', '1998-11-21', 'kinhcan@gmail.com',0,'https://kenh14cdn.com/thumb_w/660/2019/3/7/5301629225053921961409043040056750658027520n-1551924968498331276673.jpg', 0, 'Từ Thị Tài', '0935934232', 15000000,1,1),
(2, '27-28, ngõ 294 Vạn Phúc, Kim Mã, Hà Nội', '1990-01-01', 'anhchangcan@gmail.com',1,'https://toigingiuvedep.vn/mau-anh-the-dep/', 0, 'Từ Như Tuyến', '0935933888', 15000000,2,3),
(3, '63 – 65 Nguyễn Kiệm, F.3, Q. Gò Vấp, Tp.HCM', '1999-11-21', 'cuocsongso@gmail.com',1,'https://kenh14cdn.com/2020/6/30/img0096-1592366363868430058761-1593507888983990295582.jpeg', 0, 'Nguyễn Trung Thực', '0935912341', 7500000, 3,2),
(4, ' 237/6 Đỗ Ngọc Thạnh, F.6, Q.11, Tp.HCM', '1993-02-01', 'timdau@gmail.com',1,'https://bizweb.dktcdn.net/100/175/849/files/chup-anh-the-nen-de-toc-nhu-the-nao-cho-dep-chuan-02.jpg?v=1606888304037', 0, 'Phạm Lê Long', '0935943678', 7500000, 4,2),
(5, ' 500 Nguyễn Thị Thập, Kp1, F. Tân Quy, Q.7, Tp.HCM', '2000-01-01', 'ngaynanglen@gmail.com',1,'https://phunugioi.com/wp-content/uploads/2021/09/Mau-anh-the-dep-cho-nam-phong-trang.jpg', 0, 'Nguyễn Trung Kiên', '0935980756', 7500000, 5,2),
(6, '56-58 Nguyễn Trãi, F.7, TP. Mỹ Tho, Tiền Giang', '2002-01-01', 'timve@gmail.com',1,'https://toplist.vn/images/800px/tiem-chup-anh-the-334-321384.jpg', 0, 'Đỗ Huy Hoàng', '0935835435', 6500000, 6,3),
(7, '484 ĐL Bình Dương, Thủ Dầu Một, Tỉnh Bình Dương', '2001-12-10', 'cristiaronaldo@gmail.com',1,'https://toplist.vn/images/800px/studio-hong-ngoc-318809.jpg', 0, 'Bùi Nhật Minh', '0935980462', 6500000, 7,3),
(8, '193/5 Tân Thới 3, Xã Tân Hiệp, H. Hóc Môn', '1998-01-09', 'messi@gmail.com',1,'https://ss-images.saostar.vn/wp700/2020/05/26/7542385/photo-1-1590311162571565188046.jpg', 0, 'Trần Trọng Cung', '0935658679', 8000000, 8,4),
(9, ' 14 Nguyễn Hữu Thọ, Phường Phước Trung, TP.Bà Rịa, Vũng Tàu', '1996-08-07', 'henry@gmail.com',1,'https://3.bp.blogspot.com/-ckaz8OGT99Q/WrJ4BOLtQkI/AAAAAAAAA24/vZaL--YusZEK_C117-S7PQXhW1Ri-myHgCEwYBhgL/s1600/cach%2Bchup%2Banh%2Bthe%2Bdep%2B2.jpg', 0, 'Nguyễn Minh Quang', '0931244225', 8500000,9,2),
(10, '21/4 Xuân Bình, Long Khánh, Đồng Nai', '1998-08-08', 'rooney@gmail.com',1,'https://toplist.vn/images/800px/tiem-chup-anh-the-lay-ngay-dep-nhat-pleiku-gia-lai-chu-de-da-duoc-nhan-tran-minh-phuong-318152.jpg', 0, 'Trần Xuân Cung', '0942627721', 1500000, 10,2),
(11, '136A Đường 30/4 Phường An Phú, Quận Ninh Kiều, TP. Cần Thơ', '1999-03-29', 'mohamett@gmail.com',1,'https://we25.vn/media2018/Img_News/2020/08/19/anh-the-3_20200819144021.jpg', 0, 'Phạm Huỳnh Nhật Vượng', '0965842525', 8000000, 11,2),
(12, 'Bãi Bắc, phường Thọ Quang, bán đảo Sơn Trà, Đà Nẵng', '1995-07-30', 'napoleon@gmail.com',1,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQ27Wgvss6J-xsGO5hT0sbiOKlAGTxzGJzdQ&usqp=CAU', 0, 'Nguyễn Nhật Trường Sinh', '0945757345', 7500000, 12,2),
(13, '35 Trường Sa, quận Ngũ Hành Sơn, Đà Nẵng', '1994-06-08', 'nangchangconxanh@gmail.com',1,'https://demoda.vn/wp-content/uploads/2022/03/mau-anh-the-ong-chu-so-mi-trang.jpg', 0, 'Dương Quang Sinh', '0933467342', 7500000, 13,4),
(14, 'Lô 5 -6 Võ Nguyên Giáp, Phước Mỹ, Đà Nẵng', '1997-02-09', 'ngaydaubuoisang@gmail.com',1,'https://toplist.vn/images/800px/dino-studio-anh-vien-cho-be-va-gia-dinh-317623.jpg', 0, 'Trần Trọng Sinh', '0765756753', 7500000, 14,3),
(15, '150 – 152 Bạch Đằng, quận Hải Châu, Đà Nẵng', '1993-02-01', 'luctungthungrac@gmail.com',1,'https://chuphinhthe.com/thumbs/360x360x2/upload/product/903-phat-7991.jpg', 0, 'Nguyễn Quang Trực', '08065764334', 7500000, 15,4);

-- Feedback
INSERT INTO `feedback` (`code`, `content`, `creator`, `email`, `feedback_date`, `image`, `is_deleted`, `rating`) VALUES
('FB0001', 'Đồ uống ngon', 'Lê Văn Tài', 'tailevandn@gmail.com', '2022-02-01', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20Phe%CC%82%20tru%CC%9B%CC%81ng.webp?alt=media&token=b3115e66-854b-412c-905e-5f700e28aacd', 0, 3),
('FB0002', 'View đẹp', 'Trần Đức Phương', 'phuongtrandn@gmail.com', '2022-02-01', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnuoc-ep-xoai.jpeg?alt=media&token=64b1a854-b875-43ef-a572-f7a85bdbff65', 0, 4),
('FB0003', 'Giá đồ uống rẻ', 'Quỳnh Thị Điệp', 'quynhdiepdiepdn@gmail.com', '2022-02-01', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20phe%CC%82%20bo%CC%A3t%20bie%CC%82%CC%89n.jpeg?alt=media&token=d9c32f95-b80e-4a20-8f35-64992b37d344', 0, 3),
('FB0004', 'Nhân viên khó chịu khi mình muốn đổi món', 'Nguyễn Thụy Thiên Hương Giang', 'nguyenthuythienhuonggiangdn@gmail.com', '2022-02-01', '', 0, 1),
('FB0005', 'Không gian thoáng mát, rộng rãi Ghế ngồi lóc cóc cafe tán ngẫu Milano luôn có những bạn nhân viên dễ thương ghê :heart_eyes::heart_eyes::heart_eyes::heart_eyes: Nhà gần nên cứ đi bộ ra cafe miết', 'Trà Thị Thuỳ Trang', 'trathithuytrangdn@gmail.com', '2022-02-01', 'https://banghegiare.com.vn/data/news/2422/thiet-ke-cho-quan-cafe.jpg', 0, 5),
('FB0006', 'Quán đẹp. Nước uống ngon', 'Quỳnh Thị Trang', 'quynhtrangdn@gmail.com', '2022-02-04', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20Phe%CC%82%20tru%CC%9B%CC%81ng.webp?alt=media&token=b3115e66-854b-412c-905e-5f700e28aacd', 0, 5),
('FB0007', 'Cafe ngon, không gian xanh rất yên tĩnh và đẹp', 'Chu Đức Hiếu', 'hieuchudn@gmail.com', '2022-02-04', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYcf%20%C4%91en.jpeg?alt=media&token=d1250e75-3858-4e12-99f7-5283b2d43f38', 0, 4),
('FB0008', 'Được uống tách cà phê đúng điệu mộc 100%. Môi trường giao tiếp thân như người tri kỉ. Giá cả hợp lýÂm nhạc , nghệ thuật ảnh, kệ sách thư giản , các trò chơi giải trí nhẹ lành mạnh .Mỗi ngày là một niềm vui khi đến đây', 'Quỳnh Quốc Bảo', 'baoquynhdn@gmail.com', '2022-02-04', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnuoc-ep-xoai.jpeg?alt=media&token=64b1a854-b875-43ef-a572-f7a85bdbff65', 0, 5),
('FB0009', 'Không gian ấm áp, có các loại nhạc cụ, nhân viên vui vẻ thân thiện.', 'Quỳnh Mạnh Tiến', 'manhtiendn@gmail.com', '2022-02-04', 'https://banghegiare.com.vn/data/news/2422/thiet-ke-cho-quan-cafe.jpg', 0, 4),
('FB0010', 'Nơi này rất tuyệt cho các bạn đam mê âm nhạc, quán có không gian rất ấm áp, chủ quán rất vui vẻ và nhiệt tình, ngoài ra quán còn nhiều loại nhạc cụ khác nhau như đàn guitar, piano, sáo trúc, saxophone, violin, ..... các bạn có thể sử dụng tự nhiên, ngoài ra còn có các loại sách, máy ảnh và lens máy cho các bạn khám phá, về thức uống ở quán rất ngon và giá cả rất hợp lí
Đặc biệt hơn tại quán thường có những bạn yêu âm nhạc, những cao thủ đàn , ca sĩ hạng A, Du khách nước ngoài ở cần thơ thường đến chơi, các bạn có thể đến đây để thưởng thức cũng như giao lưu với mọi người, ngoài ra còn nhiều điều thú vị nữa,
Nếu bạn đến Cần Thơ, hãy một lần đến nơi này để khám phá nhiều điều thú vị hơn nữa nhé!
( mách nhỏ với bạn là đặc biệt vào chiều và tối, quán rất là vui và náo nhiệt luôn!)', 'Nguyễn Văn Phúc', 'phucxoxodn@gmail.com', '2022-02-06', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20phe%CC%82%20bo%CC%A3t%20bie%CC%82%CC%89n.jpeg?alt=media&token=d9c32f95-b80e-4a20-8f35-64992b37d344', 0, 5),
('FB0011', 'Giá hình dân, thức uống ngon, cafe sạch.', 'Trương Văn Lợi', 'truongloiloidn@gmail.com', '2022-02-06', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnu%CC%9Bo%CC%9B%CC%81c%20cam.jpeg?alt=media&token=f7aa02ed-7911-4387-9dff-e4f0e2b36f9e', 0, 4),
('FB0012', 'Quán có view khá đẹp... thức uống ngon và có xe bánh mì Plus ngoài trước rất ngon... Đến ăn bánh mì và cafe buổi sáng rất phù hợp', 'Đặng Quốc Hùng', 'danghungdn@gmail.com', '2022-02-06', 'https://banghegiare.com.vn/data/news/2422/thiet-ke-cho-quan-cafe.jpg', 0, 4),
('FB0013', 'Wifi mạnh, nước giá hạt dẻ, siêu đông vui. Đặc biệt là ở đây nhạc cụ gì cũng có.', 'Hồ Văn Thị Diệp', 'diephothivandn@gmail.com', '2022-02-06', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYcf%20%C4%91en.jpeg?alt=media&token=d1250e75-3858-4e12-99f7-5283b2d43f38', 0, 4),
('FB0014', 'Mọi điều thiệt dễ thương khi ở đây, cứ như có thêm người thân vậy đó, tui hay gọi là nhà hơn là quán coffee', 'Phạm Thị Hoa', 'hoaphamdn@gmail.com', '2022-02-06', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20Phe%CC%82%20tru%CC%9B%CC%81ng.webp?alt=media&token=b3115e66-854b-412c-905e-5f700e28aacd', 0, 5),
('FB0015', 'Quán nhỏ ấm cũng, khách ở quán thân thiện, nhiệt tình, tự nhiên, đồ uống ngon chất lượng', 'Võ Hoàng Yến', 'yenvohoangdn@gmail.com', '2022-02-06', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20phe%CC%82%20bo%CC%A3t%20bie%CC%82%CC%89n.jpeg?alt=media&token=d9c32f95-b80e-4a20-8f35-64992b37d344', 0, 5),
('FB0016', 'Là nơi có thể xã tress sau 1 ngày làm việc mệt mỏi rất thích quán', 'Lê Văn Phúc', 'phucledn@gmail.com', '2022-03-06', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYba%CC%A3c%20xi%CC%89u.jpeg?alt=media&token=f3c3d8b5-1f44-482c-acfb-d302b4cc0e9e', 0, 5),
('FB0017', 'Điểm cafe lý tưởng!', 'Nguyễn Văn An', 'annguyendn@gmail.com', '2022-03-06', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnuoc-ep-xoai.jpeg?alt=media&token=64b1a854-b875-43ef-a572-f7a85bdbff65', 0, 4),
('FB0018', 'Điểm đến giải toả stress mọi người nhé', 'Lê Văn Bình', 'binhlvdn@gmail.com', '2022-03-06', 'https://banghegiare.com.vn/data/news/2422/thiet-ke-cho-quan-cafe.jpg', 0, 5),
('FB0019', 'Hoài cổ và dễ chịu', 'Hồ Thị Yến', 'thiyendn@gmail.com', '2022-03-06', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYba%CC%A3c%20xi%CC%89u.jpeg?alt=media&token=f3c3d8b5-1f44-482c-acfb-d302b4cc0e9e', 0, 5),
('FB0020', 'Thư giãn', 'Võ Công Toản', 'toan0404dn@gmail.com', '2022-04-12', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYcf%20%C4%91en.jpeg?alt=media&token=d1250e75-3858-4e12-99f7-5283b2d43f38', 0, 3),
('FB0021', 'Lịch sự, rẻ. Polite staff, inexpensive', 'Nguyễn Bỉnh Phát', 'phatphatdn@gmail.com', '2022-04-12', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20phe%CC%82%20bo%CC%A3t%20bie%CC%82%CC%89n.jpeg?alt=media&token=d9c32f95-b80e-4a20-8f35-64992b37d344', 0, 5),
('FB0022', 'View đẹp', 'Khúc Nguyễn An Nghi', 'annghi20dn@gmail.com', '2022-04-12', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnuoc-ep-xoai.jpeg?alt=media&token=64b1a854-b875-43ef-a572-f7a85bdbff65', 0, 4),
('FB0023', 'Best coffee shop in the town! Great coffee, low prices, good atmosphere full of live music and really lovely owner. Must visit if you are around.', 'Nguyễn Hữu Hà', 'nhh0101dn@gmail.com', '2022-04-12', '', 0, 4),
('FB0024', 'We asked if they had soy milk instead of regular milk for coffee. Despite some language barriers they sorted it and served us some amazing and even good looking coffee!', 'Nguyễn Hà Đông', 'donghanguyendn@gmail.com', '2022-04-12', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20phe%CC%82%20bo%CC%A3t%20bie%CC%82%CC%89n.jpeg?alt=media&token=d9c32f95-b80e-4a20-8f35-64992b37d344', 0, 5),
('FB0025', '......', 'Tòng Hoang', 'hoangtongdn@gmail.com', '2022-04-24', '', 0, 2),
('FB0026', 'Cafe uống không ngon có vị bắp. Giá bình thường. Không gian quán trang trí đẹp và rộng. Quán có hồ cá nhỏ và phòng lạnh. Quán nằm ngay mặt tiền đường nên tìm cũng dễ', 'Nguyễn Công Đạo', 'nguyencongdao12dn@gmail.com', '2022-04-24', '', 0, 2),
('FB0027', 'Quán phù hợp cho gia đình có các bé, có khu vui chơi cho trẻ em, có phục vụ các món ăn sán, có bàn bia, có phòng lạnh cho những người cần sự yên tĩnh riêng tư nên trang bị thêm máy để phục vụ cho những khách muốn uống cà phê ép máy mảng phục vụ cần chuyên nghiệp hơn', 'Nguyễn Thị Hào', 'thihao07dn@gmail.com', '2022-04-24', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20Phe%CC%82%20tru%CC%9B%CC%81ng.webp?alt=media&token=b3115e66-854b-412c-905e-5f700e28aacd', 0, 4),
('FB0028', 'Rất thoáng và mát mẻ ! Nhân viên phục vụ nhanh nhẹn và dễ thương ! Cà phê uống ngon , món khác thì mình ko biết ! Ghế ngồi ko được thoải mái lắm .', 'Phạm Xuân Diệu', 'xuandieu92dn@gmail.com', '2022-04-24', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYba%CC%A3c%20xi%CC%89u.jpeg?alt=media&token=f3c3d8b5-1f44-482c-acfb-d302b4cc0e9e', 0, 4),
('FB0029', 'Ngon, bổ rẻ', 'Trương Đình Nghệ', 'nghenhan2702dn@gmail.com', '2022-05-24', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYa%CC%89nh%20ca%CC%80%20.jpeg?alt=media&token=0f534faa-01ce-4047-9feb-e897941fa6c6', 0, 4),
('FB0030', 'Ngon, bổ rẻ', 'Dương Văn Quan', 'duongquandn@gmail.com', '2022-05-24', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYba%CC%A3c%20xi%CC%89u.jpeg?alt=media&token=f3c3d8b5-1f44-482c-acfb-d302b4cc0e9e', 0, 4),
('FB0031', 'Đồ uống ngon', 'Hoàng Trần Nhi Nhi', 'nhinhi123dn@gmail.com', '2022-05-24', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYba%CC%A3c%20xi%CC%89u.jpeg?alt=media&token=f3c3d8b5-1f44-482c-acfb-d302b4cc0e9e', 0, 3),
('FB0032', 'View đẹp', 'Tôn Nữ Mộc Châu', 'tonnuchaudn@gmail.com', '2022-05-24', '', 0, 4),
('FB0033', 'Giá tiền vừa đủ', 'Nguyễn Mỹ Kim', 'kimcuong84dn@gmail.com', '2022-05-24', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYa%CC%89nh%20ca%CC%80%20.jpeg?alt=media&token=0f534faa-01ce-4047-9feb-e897941fa6c6', 0, 3),
('FB0034', 'Đã tới đây 2 lần. Đồ uống ngon. Giá vừa phải. Quán khá đông nên hơi ồn. Những bạn nào muốn tới làm việc thì ko phù hợp lắm', 'Nguyễn Thị Hào', 'haohao99dn@gmail.com', '2022-05-24', '', 0, 5),
('FB0035', 'Một nơi rất tuyệt để nhâm nhi cà phê buổi sáng. Cà phê đúng vị Việt Nam. Ở đây còn có một khu vực làm việc chung working space rất đẹp. Không gian đầy chất thiên nhiên và xanh. Giá cả phải chăng và nhân viên rất nhiệt tình. Highly recommended!!!', 'Trần Đại Danh', 'danhhai99dn@gmail.com', '2022-05-24', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYca%CC%80%20Phe%CC%82%20tru%CC%9B%CC%81ng.webp?alt=media&token=b3115e66-854b-412c-905e-5f700e28aacd', 0, 4),
('FB0036', 'Quán thiết kế đẹp và thoáng đãng, giá tương đối cao nhưng xứng đáng vì đồ uống ngon, vị trí dễ tìm', 'Nguyễn Tâm Đắc', 'dactamdn@gmail.com', '2022-05-24', 'https://banghegiare.com.vn/data/news/2422/thiet-ke-cho-quan-cafe.jpg', 0, 5),
('FB0037', 'Tuyệt vời không gian làm việc tập trung. Sách vở đầy đủ. Nhân viên nhiệt tình. Người quản lí trong phòng làm việc cách nói chuyện hơi cộc cằn.', 'Trương Văn Lợi', 'truongloiloidn@gmail.com', '2022-05-28', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYa%CC%89nh%20ca%CC%80%20.jpeg?alt=media&token=0f534faa-01ce-4047-9feb-e897941fa6c6', 0, 3),
('FB0038', 'Quán phù hợp để ngồi coffee cùng bạn bè cũng như có không gian mở để có thể ngồi làm việc, mình biết local beans qua 1 project được featured bởi cộng đồng design và có ghé qua thì thật sự ấn tượng về không gian, coffee cũng như chất lượng phục vụ tại quán', 'Nguyễn Văn Trường', 'truongdoinedn@gmail.com', '2022-05-28', '', 0, 5),
('FB0039', 'Ngon, bổ rẻ', 'Trà Văn Luận', 'travanluandn@gmail.com', '2022-05-28', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnuoc-ep-xoai.jpeg?alt=media&token=64b1a854-b875-43ef-a572-f7a85bdbff65', 0, 4),
('FB0040', 'Đang bùn', 'Nguyễn Văn Tài', 'taioxssdn@gmail.com', '2022-05-28', '', 0, 1),
('FB0041', 'Quán thức uống ổn, không gian ấm áp, có chỗ đỗ oto. Thích hợp cho cả gia đình và nhóm bạn gặp nhau.', 'Đặng Thị Trà', 'tradtdn@gmail.com', '2022-05-28', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnu%CC%9Bo%CC%9B%CC%81c%20va%CC%83i.jpeg?alt=media&token=741ca70f-48f9-415e-94e8-5561fb9bfcb9', 0, 5),
('FB0042', 'View đẹp', 'Đỗ Văn Danh', 'dangvdn@gmail.com', '2022-05-28', '', 0, 4),
('FB0043', 'Giá tiền vừa đủ', 'Lê Dương Bảo Lâm', 'lamldbdn@gmail.com', '2022-05-28', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnu%CC%9Bo%CC%9B%CC%81c%20cam.jpeg?alt=media&token=f7aa02ed-7911-4387-9dff-e4f0e2b36f9e', 0, 3),
('FB0044', 'Good', 'Bùi Phúc Ngọc', 'ngocdddn@gmail.com', '2022-06-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnu%CC%9Bo%CC%9B%CC%81c%20cam.jpeg?alt=media&token=f7aa02ed-7911-4387-9dff-e4f0e2b36f9e', 0, 4),
('FB0045', 'Quán đẹp, mát thức uống ngon ở Đà Nẵng', 'Phạm Hoàng Bình', 'binhphamdn@gmail.com', '2022-06-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnu%CC%9Bo%CC%9B%CC%81c%20va%CC%83i.jpeg?alt=media&token=741ca70f-48f9-415e-94e8-5561fb9bfcb9', 0, 5),
('FB0046', 'Không gian ấm cúng, có nhạc acoustic vào thứ 5 và thứ 7 hàng tuần.', 'Nguyễn Như Hoà', 'hoann22dn@gmail.com', '2022-06-16', '', 0, 4),
('FB0047', 'Nước cũng được mà nhạc hay, nên ghé thử:))', 'Trần Quốc Tuấn', 'trantuan311dn@gmail.com', '2022-06-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnuoc-ep-xoai.jpeg?alt=media&token=64b1a854-b875-43ef-a572-f7a85bdbff65', 0, 4),
('FB0048', 'Quán đẹp, dễ thương. Giá cả hợp lý', 'Nguyễn Quốc Toàn', 'toannguyen333dn@gmail.com', '2022-06-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16-08-YYYnu%CC%9Bo%CC%9B%CC%81c%20va%CC%83i.jpeg?alt=media&token=741ca70f-48f9-415e-94e8-5561fb9bfcb9', 0, 3),
('FB0049', 'Ngày âm nhạc khá ổn, âm thanh tốt, ban nhạc chất lượng ', 'Trần Đại Danh', 'danhaidn@gmail.com', '2022-06-16', '', 0, 3),
('FB0050', 'Ngon, bổ rẻ', 'Nguyễn Văn Phúc', 'phucxoxodn@gmail.com', '2022-06-16', 'https://firebasestorage.googleapis.com/v0/b/c0222g2-4cf09.appspot.com/o/16082022_04%3A00%3A04PM_Yaourt%20cafe.png?alt=media&token=640d28d0-a265-4590-b723-4b6d2ee6d82b', 0, 4);


insert into bill value
(1,'1000','2022-08-16',0),
(2,'13510','2022-08-16',0),
(3,'26083','2022-08-16',0),
(4,'78503','2022-08-16',0),
(5,'31955','2022-08-16',0),
(6,'18536','2022-08-16',0),
(7,'76765','2022-08-16',0),
(8,'72315','2022-08-16',0),
(9,'26499','2022-08-16',0),
(10,'86196','2022-08-16',0),
(11,'74282','2022-08-16',0),
(12,'23790','2022-08-16',0),
(13,'67850','2022-08-16',0),
(14,'55142','2022-08-16',0),
(15,'55784','2022-08-16',0),
(16,'27172','2022-08-16',0),
(17,'57924','2022-08-16',0),
(18,'29202','2022-08-16',0),
(19,'41675','2022-08-16',0),
(20,'36232','2022-08-16',0),
(21,'53707','2022-08-16',0),
(22,'89705','2022-08-16',0),
(23,'78970','2022-08-16',0),
(24,'47308','2022-08-16',0),
(25,'96375','2022-08-16',0),
(26,'53325','2022-08-16',0),
(27,'61259','2022-08-16',0),
(28,'89856','2022-08-16',0),
(29,'51646','2022-08-16',0),
(30,'23073','2022-08-16',0),
(31,'26892','2022-08-16',0),
(32,'21645','2022-08-16',0),
(33,'76289','2022-08-16',0),
(34,'78501','2022-08-16',0),
(35,'31921','2022-08-16',0),
(36,'18111','2022-08-16',0),
(37,'76762','2022-08-16',0),
(38,'72311','2022-08-16',0),
(39,'26492','2022-08-16',0),
(40,'86194','2022-08-16',0),
(41,'74244','2022-08-16',0),
(42,'23744','2022-08-16',0),
(43,'67844','2022-08-16',0),
(44,'55144','2022-08-16',0),
(45,'55744','2022-08-16',0),
(46,'27144','2022-08-16',0),
(47,'57944','2022-08-16',0),
(48,'29222','2022-08-16',0),
(49,'41612','2022-08-16',0),
(50,'19952','2022-08-16',0),
(51,'19956','2022-08-16',0),
(52,'20001','2022-08-16',0),
(53,'1999','2022-08-16',0),
(54,'1998','2022-08-16',0),
(55,'12356','2022-08-16',0),
(56,'23000','2022-08-16',0),
(57,'2300','2022-08-16',0),
(58,'2002','2022-08-16',0),
(59,'1222','2022-08-16',0),
(60,'1221','2022-08-16',0),
(61,'125','2022-08-16',0),
(62,'124','2022-08-16',0),
(63,'123','2022-08-16',0);

insert into coffee_table value
(1,"A-01",1,1,0),
(2,"A-02",1,1,0),
(3,"A-03",0,1,0),
(4,"A-04",0,1,0),
(5,"A-05",0,1,0),
(6,"A-06",0,1,0),
(7,"A-07",0,1,0),
(8,"A-08",0,1,0),
(9,"A-09",1,1,0),
(10,"A-10",1,1,0),
(11,"A-11",0,1,0),
(12,"A-12",0,1,0),
(13,"A-13",0,1,0),
(14,"A-14",0,1,0),
(15,"A-15",0,1,0),
(16,"A-16",0,1,0);


