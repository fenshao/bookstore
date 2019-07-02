/*
 Navicat Premium Data Transfer

 Source Server         : hwshop
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 114.116.156.29:3306
 Source Schema         : onlinebookstore

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 28/06/2019 18:55:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `uid` int(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (00001, 'wangziquan', '123');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `bid` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(60, 1) NULL DEFAULT NULL,
  `author` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cid` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE,
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '我喜欢我自己', 25.3, '卡尔森', 'images/book_7.jpg', '1', '《我喜欢自己》是2009年5月编辑出版的图书，作者是外研社儿童发展中心。');
INSERT INTO `book` VALUES ('10', 'Go程序设计语言', 88.8, 'www', 'images/go.jpg', '5', 'Go程序设计语言www');
INSERT INTO `book` VALUES ('11', 'Java语言导学', 121.6, 'wwas', 'images/java.jpg', '5', 'Java语言导学wwas');
INSERT INTO `book` VALUES ('12', '123', 123.0, '12', 'images/book_7.jpg', '5', '12312');
INSERT INTO `book` VALUES ('2', '窗边的小豆豆', 18.5, '黑柳彻子', 'images/book_3.jpg', '2', '《窗边的小豆豆》是日本作家、主持人黑柳彻子创作的儿童文学作品，首次出版于1981年。\r\n这本书讲述了作者上小学时的一段真实的故事：小豆豆（作者）因淘气被原学校退学后，来到巴学园。在小林校长的爱护和引导下，一般人眼里“怪怪”的小豆豆逐渐变成了一个大家都能接受的孩子。巴学园里亲切、随和的教学方式使这里的孩子们度过了人生最美好的时光。');
INSERT INTO `book` VALUES ('3', '神奇校车', 119.9, '乔安娜', 'images/book_2.jpg', '2', '《神奇校车》2005年四川少年儿童出版社出版的书籍，作者是柯尔。该书籍共有11部，分别是《神奇校车：海底探险》、《神奇校车：穿越飓风》、《神奇校车：在人体中游览》、《神奇校车：地球内部探秘》等。');
INSERT INTO `book` VALUES ('4', '哈利波特', 159.5, '罗琳', 'images/book_8.jpg', '2', '《哈利·波特》（Harry Potter）是英国作家J·K·罗琳（J. K. Rowling）于1997～2007年所著的魔幻文学系列小说，共7部。其中前六部以霍格沃茨魔法学校（Hogwarts School of Witchcraft and Wizardry）为主要舞台，描写的是主人公——年轻的巫师学生哈利·波特在霍格沃茨前后六年的学习生活和冒险故事；第七本描写的是哈利·波特在第二次魔法界大战中在外寻找魂器并消灭伏地魔的故事。');
INSERT INTO `book` VALUES ('5', '小熊宝宝绘本', 86.3, '佐佐木样子', 'images/book_5.jpg', '2', '《小熊宝宝绘本》为2007年连环画出版社出版的一套幼儿丛书，作者是日本画家佐佐木洋子。该丛书包括：《你好》《过生日》《拉巴巴》《睡觉》等共15本。书中内容丰富，涵盖了幼儿生活的各个方面：吃饭、睡觉、洗澡、穿衣、问好、交友等。在增长知识的同时能开发宝宝的智力潜能。该套丛书适合1岁以上亲子共读或幼儿自主阅读。');
INSERT INTO `book` VALUES ('6', '小熊很忙系列', 463.2, '本吉戴维斯', 'images/book_6.jpg', '2', '《小熊宝宝绘本》为2007年连环画出版社出版的一套幼儿丛书，作者是日本画家佐佐木洋子。该丛书包括：《你好》《过生日》《拉巴巴》《睡觉》等共15本。书中内容丰富，涵盖了幼儿生活的各个方面：吃饭、睡觉、洗澡、穿衣、问好、交友等。在增长知识的同时能开发宝宝的智力潜能。该套丛书适合1岁以上亲子共读或幼儿自主阅读。');
INSERT INTO `book` VALUES ('7', '蓝色小卡车', 30.0, '爱丽丝', 'images/book_4.jpg', '2', '自第一本《蓝色小卡车》出版7年以来，该系列的每一本都高居美国亚马逊早教儿童书排行榜。在《跟着蓝色小卡车》这次汽车大聚会中，各种喇叭声此起彼伏，让孩子过足汽车瘾，激发了他们的阅读兴趣，同时还让孩子明白了秩序的重要性，养成友善谦让的好品格');
INSERT INTO `book` VALUES ('8', '米菲绘本', 63.2, '迪克', 'images/book_1.jpg', '3', '《米菲绘本》是2010年人民邮电出版社出版的图书，作者是布鲁纳。');
INSERT INTO `book` VALUES ('9', '小牛顿科学馆', 300.0, '台湾牛顿出版社', 'images/book_11.jpg', '4', '《小牛顿科学馆》是台湾牛顿出版公司出版的期刊，作者是台湾牛顿出版公司。本书内容一般都是小孩阅读的科普类知识');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `cid` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '绘本');
INSERT INTO `category` VALUES ('2', '外国儿童文学');
INSERT INTO `category` VALUES ('3', '婴儿读物');
INSERT INTO `category` VALUES ('4', '科普/百科');
INSERT INTO `category` VALUES ('5', '计算机');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `iid` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `COUNT` int(11) NULL DEFAULT NULL,
  `subtotal` decimal(10, 2) NULL DEFAULT NULL,
  `oid` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bid` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`iid`) USING BTREE,
  INDEX `oid`(`oid`) USING BTREE,
  INDEX `bid`(`bid`) USING BTREE,
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`bid`) REFERENCES `book` (`bid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('1', 1, 18.50, '8f8719b9c5bf4060b19adbbf98729f4d', '2');
INSERT INTO `orderitem` VALUES ('101', 1, 63.20, 'e0b0e4a9caad43dc8d69a5afa7909716', '8');
INSERT INTO `orderitem` VALUES ('111', 1, 463.20, '075aa85ec4ae4ab08f178e1f7a56c4b1', '6');
INSERT INTO `orderitem` VALUES ('121', 1, 300.00, '808b215c7c784b09bbe59cc677f7507c', '9');
INSERT INTO `orderitem` VALUES ('14', 1, 88.80, 'ef26f9d14c444d5c8bce9da53b4bf4d8', '10');
INSERT INTO `orderitem` VALUES ('15', 1, 18.50, 'e73018a98b5d4cc9951133ccd0825a52', '2');
INSERT INTO `orderitem` VALUES ('16', 1, 359.70, '4fb6e77c21e44c4a963f19c7a2147d8d', '3');
INSERT INTO `orderitem` VALUES ('2', 1, 300.00, '8f8719b9c5bf4060b19adbbf98729f4d', '9');
INSERT INTO `orderitem` VALUES ('3', 1, 30.00, '26bc458362d248a4b0a0e306a162105f', '7');
INSERT INTO `orderitem` VALUES ('31', 1, 119.90, 'd7fec13148204d96961ea46e6bd6eea1', '3');
INSERT INTO `orderitem` VALUES ('5', 1, 63.20, '7fa71bc9c73448cbafaef67d2a6deca2', '8');
INSERT INTO `orderitem` VALUES ('51', 3, 478.50, 'd01b759f50df46bba980710a0e0e2386', '4');
INSERT INTO `orderitem` VALUES ('7', 1, 463.20, '75504e55b1fe4fc08f12788ca20cbf15', '6');
INSERT INTO `orderitem` VALUES ('71', 3, 189.60, 'e88725c312ab4caeb83c8d314096eca3', '8');
INSERT INTO `orderitem` VALUES ('9', 1, 25.30, 'e4d644e6d2c04fa1922e841d7e629f2f', '1');
INSERT INTO `orderitem` VALUES ('91', 1, 63.20, '966a1213ed2b4364bd36593fa93140a1', '8');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `oid` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ordertime` datetime(0) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `state` smallint(1) NULL DEFAULT NULL,
  `uid` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('075aa85ec4ae4ab08f178e1f7a56c4b1', '2019-06-19 16:44:51', 463.20, 2, 'ee986930299f40e89fd9488299b473ae', '云南民族大学');
INSERT INTO `orders` VALUES ('26bc458362d248a4b0a0e306a162105f', '2019-06-18 20:47:26', 30.00, 1, 'e1d7d75053564ea581e54e91ae615420', '云南民族大学芷苑4A604');
INSERT INTO `orders` VALUES ('4fb6e77c21e44c4a963f19c7a2147d8d', '2019-06-27 15:21:30', 359.70, 1, 'e1d7d75053564ea581e54e91ae615420', '云南民族大学芷苑4A604');
INSERT INTO `orders` VALUES ('75504e55b1fe4fc08f12788ca20cbf15', '2019-06-19 11:26:47', 463.20, 1, 'e1d7d75053564ea581e54e91ae615420', '云南民族大学芷苑4A604');
INSERT INTO `orders` VALUES ('7fa71bc9c73448cbafaef67d2a6deca2', '2019-06-19 10:48:00', 63.20, 1, 'e1d7d75053564ea581e54e91ae615420', '云南民族大学芷苑4A604');
INSERT INTO `orders` VALUES ('808b215c7c784b09bbe59cc677f7507c', '2019-06-21 21:23:31', 300.00, 1, '38aefbd5e8eb46d4804df306486d510b', NULL);
INSERT INTO `orders` VALUES ('8f8719b9c5bf4060b19adbbf98729f4d', '2019-06-18 09:32:32', 318.50, 1, 'e1d7d75053564ea581e54e91ae615420', '云南民族大学芷苑4A604');
INSERT INTO `orders` VALUES ('966a1213ed2b4364bd36593fa93140a1', '2019-06-19 16:43:03', 63.20, 0, 'ee986930299f40e89fd9488299b473ae', NULL);
INSERT INTO `orders` VALUES ('d01b759f50df46bba980710a0e0e2386', '2019-06-19 11:21:11', 478.50, 1, 'e1d7d75053564ea581e54e91ae615420', '云南民族大学芷苑4A604');
INSERT INTO `orders` VALUES ('d7fec13148204d96961ea46e6bd6eea1', '2019-06-18 22:17:33', 119.90, 1, 'e1d7d75053564ea581e54e91ae615420', '云南民族大学芷苑4A604');
INSERT INTO `orders` VALUES ('e0b0e4a9caad43dc8d69a5afa7909716', '2019-06-19 16:43:08', 63.20, 0, 'ee986930299f40e89fd9488299b473ae', NULL);
INSERT INTO `orders` VALUES ('e4d644e6d2c04fa1922e841d7e629f2f', '2019-06-19 14:46:23', 25.30, 1, 'e1d7d75053564ea581e54e91ae615420', '云南民族大学芷苑4A604');
INSERT INTO `orders` VALUES ('e73018a98b5d4cc9951133ccd0825a52', '2019-06-23 15:32:39', 18.50, 1, 'e1d7d75053564ea581e54e91ae615420', '云南民族大学芷苑4A604');
INSERT INTO `orders` VALUES ('e88725c312ab4caeb83c8d314096eca3', '2019-06-19 11:27:37', 189.60, 1, 'e1d7d75053564ea581e54e91ae615420', '云南民族大学芷苑4A604');
INSERT INTO `orders` VALUES ('ef26f9d14c444d5c8bce9da53b4bf4d8', '2019-06-21 22:23:50', 88.80, 1, 'e1d7d75053564ea581e54e91ae615420', '云南民族大学芷苑4A604');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `PASSWORD` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` char(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `state` tinyint(1) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('38aefbd5e8eb46d4804df306486d510b', 'hwc123456', '456', '2357300448@qq.com', '328715ec82564529ab93dbe73fcdf252', 1, '云南民族大学');
INSERT INTO `user` VALUES ('cf84d5aef65c42cfbc661b93c3657246', '201613446306', '123', '2501734853@qq.com', '23e47878532640769ed82669b7e09a47', 1, '云南民族大学芷苑A603');
INSERT INTO `user` VALUES ('e1d7d75053564ea581e54e91ae615420', '201613446315', '123', '13668705357@163.com', 'ecdf9ee193804910836a2b4aa2d8241d', 1, '云南民族大学芷苑4A604');
INSERT INTO `user` VALUES ('ee986930299f40e89fd9488299b473ae', '201713453342', '1234', '1325018570@qq.com', 'dae519c34bb4456299589cb6afa98689', 1, '云南民族大学');

SET FOREIGN_KEY_CHECKS = 1;
