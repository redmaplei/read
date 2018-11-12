/*
 Navicat Premium Data Transfer

 Source Server         : 127
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : read

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 12/11/2018 16:54:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for markdown
-- ----------------------------
DROP TABLE IF EXISTS `markdown`;
CREATE TABLE `markdown`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `blogtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `markdowninfo` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mdcontent` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `mdsrc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `writetime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of markdown
-- ----------------------------
INSERT INTO `markdown` VALUES (1, 'jdl使用1', 'jdl', 'JDL是一种JHipster特定的域语言', '**jdl的使用**\r\n\r\n官方使用网站\r\nhttps://www.jhipster.tech/jdl/\r\n\r\n## 一、jdl是什么\r\n\r\n**jdl官方解释**\r\n\r\n  JDL是一种JHipster特定的域语言，我们在其中添加了使用简单且用户友好的语法在单个文件（或多个）中描述所有实体及其关系的可能性。\r\n\r\n您可以使用我们的在线JDL-Studio IDE来创建JDL及其UML可视化。您也可以创建，导出或共享JDL模型的URL。\r\n\r\n---\r\n### 其实jdl就是jhipster官网提供的，用来管理你的jhipster项目实体的域语言\r\n\r\n## 二、怎么使用\r\n\r\n**1.先创建一个jdl或者jh文件，在jhipster官网提供的JDL-Studio里创建jh文件**\r\n\r\n```java\r\n/** 书 */\r\nentity Book {\r\n    bookName String /** book name */\r\n    writerName String /** author */\r\n}\r\n\r\n/**   作者entity   */\r\nentity Author {\r\n    writerName String /** Author name */\r\n    writerBook String /** some write book */\r\n}\r\n\r\nrelationship OneToMany {\r\n	Author {book} to Book {writer(writerName) required}\r\n}\r\n```\r\n这就是一个简单的jdl文件\r\n\r\n说明:这个表示有一个Book的实体，一个Author的实体，Book和Author是一对多的关系\r\n在实体Book里写的注释，在java代码里也会跟着生成有，并且在Swagger前端也看的到\r\n\r\n**2.然后用jhipster运行这个文件，写入你的项目中**\r\n\r\n把jh文件下载下来，直接放在项目目录下，然后运行命令行 输入\r\n\r\njhipster import-jdl my_file.jdl 或 jhipster-uml my_file.jdl\r\n\r\n这两个命令是直接帮你在项目中生成所有需要的文件，包括实体类，配置类，非常的到位。。。\r\n\r\n如果不想在导入jdl文件时创建实体，可以加--json-only 这个命令\r\n\r\njhipster import-jdl ./my-jdl-file.jdl --json-only\r\n\r\n默认情况下，import-jdl仅重新生成已更改的实体，如果要重新生成所有实体，则传入--force 标志。请注意，这将覆盖对实体文件的所有本地更改\r\n\r\njhipster import-jdl ./my-jdl-file.jdl --force\r\n\r\n然后运行命令\r\n\r\n运行成功就会生成代码。\r\n\r\n**3.实体之间的关系，一对多  多对多 什么鬼的**\r\n\r\n就自己的一个一对多小例子   更多的可以对着官方语法来写\r\n\r\n\r\n```java\r\n/** 书 */\r\n\r\n\r\nentity Book {\r\n\r\n    bookName String /** book name */\r\n    writerName String /** author */\r\n}\r\n\r\n/**   作者entity   */\r\n\r\nentity Author {\r\n\r\n    writerName String /** Author name */\r\n    writerBook String /** some write book */\r\n}\r\n\r\nrelationship OneToMany {\r\n	Author {book} to Book {writer(writerName) required}\r\n}\r\n```\r\n\r\n\r\n\r\n``` java\r\n\r\n```\r\n\r\n![sddsf](df)\r\n\r\n\r\njdl对于实体添加验证字段限制，添加实体关系,创建实体还是很方便好用的。。。\r\n\r\n\r\njdl不可以删除实体的字段，不可以添加  执行这两个操作会报错\r\njdl删除不了已经存在的实体\r\n\r\n加dto 要和加service一起加\r\n\r\n\r\ndto * with mapstruct\r\n\r\nservice * with serviceClass\r\n\r\n时间 2018-8-18', '', '2018-08-08 17:56:14');
INSERT INTO `markdown` VALUES (2, 'jhipster-demo-使用', 'jhipster', 'jhipster-demo-使用1', 'dev开发环境数据库\r\nprod生产运行环境中数据库\r\n填好 账号密码，自动生成数据库\r\n\r\n自动创建实体的类:  比如Round实体\r\n\r\ndomain Round\r\nrest RoundResource \r\nrepository RoundRepository\r\n\r\nconfig CacheConfiguration配置类   cm.createCache(com.mycompany.myapp.domain.Round.class.getName(), jcacheConfiguration);\r\nconfig 配置xml    20180722013637_added_entity_RoundC.xml   \r\n\r\nservice 自己创建    打上注解@Service  即可一样使用 RoundService\r\n数据库中的实体表不用自己手动创建\r\n一旦创建了实体，，，目前删除不了\r\n\r\n手动创建实体\r\ndomain RoundC\r\nrest RoundCResource \r\nrepository RoundCRepository\r\nservice RoundCService\r\n\r\n配置文件\r\nconfig CacheConfiguration   cm.createCache(com.mycompany.myapp.domain.RoundC.class.getName(), jcacheConfiguration);\r\n20180722013637_added_entity_RoundC.xml   \r\nmaster.xml\r\n\r\n注解，配置文件  写好，就可以自己手动创建\r\n\r\n\r\nFull authentication is required to access this resource 访问此资源需要完全的身份验证\r\nhttp://192.168.3.234:8080/api/calculatePi?radius=3\r\n\r\n修改 SecurityConfiguration\r\n\r\n.antMatchers(\"/api/**\").authenticated()\r\n.antMatchers(\"/management/health\").permitAll()\r\n\r\n修改权限\r\n消除访问此资源需要完全的身份验证            \r\n\r\n\r\n', NULL, '2018-08-03 00:17:55');

-- ----------------------------
-- Table structure for markdown_category
-- ----------------------------
DROP TABLE IF EXISTS `markdown_category`;
CREATE TABLE `markdown_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_sb8bbouer5wak8vyiiy4pf2bx`(`username`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '202cb962ac59075b964b07152d234b70', 'root');

SET FOREIGN_KEY_CHECKS = 1;
