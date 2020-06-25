# 创建作者表
CREATE TABLE `dubbo_kafka`.`author`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '作者名称',
  `write_Name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '作者笔名',
  `age` int(4) UNSIGNED NOT NULL COMMENT '作者年龄',
  `gender` tinyint(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '性别。0：未知；1：男；2：女',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `deleted` tinyint(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态。0：有效；1：删除',
  PRIMARY KEY (`id`)
) COMMENT = '作者表';


# 创建书籍表
CREATE TABLE `dubbo_kafka`.`book`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '书名',
  `author_id` bigint(20) UNSIGNED NOT NULL COMMENT '书籍作者',
  `price` decimal(10, 2) NOT NULL DEFAULT 0 COMMENT '书籍单价',
  `deleted` tinyint(4) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态。0：有效；1：删除',
  PRIMARY KEY (`id`)
) COMMENT = '书籍表';