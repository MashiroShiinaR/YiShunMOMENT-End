/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost
 Source Database       : YiShun

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 06/30/2018 10:51:53 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bgm`
-- ----------------------------
DROP TABLE IF EXISTS `bgm`;
CREATE TABLE `bgm` (
  `id` varchar(64) NOT NULL,
  `author` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL COMMENT '播放地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `bgm`
-- ----------------------------
BEGIN;
INSERT INTO `bgm` VALUES ('1001', 'ラムジ', 'PLANET', '/bgm/PLANET.mp3'), ('1002', '岑宁儿', '追光者', '/bgm/zhuiguangzhe.mp3'), ('1003', '胡66', '空空如也', '/bgm/kkry.mp3'), ('1004', '鞠文娴', 'BINGBIAN病变', '/bgm/BINGBIANBB.mp3'), ('1005', '买辣椒也用券', '起风了', '/bgm/qifengle.mp3');
COMMIT;

-- ----------------------------
--  Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` varchar(20) NOT NULL,
  `father_comment_id` varchar(20) DEFAULT NULL,
  `to_user_id` varchar(20) DEFAULT NULL,
  `video_id` varchar(20) NOT NULL COMMENT '视频id',
  `from_user_id` varchar(20) NOT NULL COMMENT '留言者，评论的用户id',
  `comment` text NOT NULL COMMENT '评论内容',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程评论表';

-- ----------------------------
--  Table structure for `search_records`
-- ----------------------------
DROP TABLE IF EXISTS `search_records`;
CREATE TABLE `search_records` (
  `id` varchar(64) NOT NULL,
  `content` varchar(255) NOT NULL COMMENT '搜索的内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='视频搜索的记录表';

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(64) NOT NULL,
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `face_image` varchar(255) DEFAULT NULL COMMENT '我的头像，如果没有默认给一张',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `fans_counts` int(11) DEFAULT '0' COMMENT '我的粉丝数量',
  `follow_counts` int(11) DEFAULT '0' COMMENT '我关注的人总数',
  `receive_like_counts` int(11) DEFAULT '0' COMMENT '我接受到的赞美/收藏 的数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('180624FCN0MA5YFW', 'test', '4QrcOUm6Wau+VuBX8g+IPg==', '/180624FCN0MA5YFW/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.REMLwXAelDOgc72f3684d9c1218cc0c92e1871b314e4.png', 'test', '0', '0', '0'), ('180625HBMBK2NZMW', 'registTest', '4QrcOUm6Wau+VuBX8g+IPg==', '', 'registTest', '0', '0', '0'), ('1806269RXW4XYAY8', 'userFaceTest', '4QrcOUm6Wau+VuBX8g+IPg==', '/1806269RXW4XYAY8/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.hsgoRrgSWbF2c72f3684d9c1218cc0c92e1871b314e4.png', 'userFaceTest', '0', '0', '0'), ('180626AW58W8Z44H', 'userInfoTest', '4QrcOUm6Wau+VuBX8g+IPg==', '/180626AW58W8Z44H/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.oOQX0T9FgvcZedbef1168621737d6a388e6c8ac78e48.png', 'userInfoTest', '12', '46', '55'), ('180628A97P438PH0', 'videoTest', '4QrcOUm6Wau+VuBX8g+IPg==', '/180628A97P438PH0/face/wxc53363d3270a93f6..RHN8AW2yCf5cc72f3684d9c1218cc0c92e1871b314e4.png', 'videoTest', '0', '0', '0'), ('180628BNXAGC8RGC', 'test01', '4QrcOUm6Wau+VuBX8g+IPg==', '/180628BNXAGC8RGC/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.Zbj2SZmN8YXDc72f3684d9c1218cc0c92e1871b314e4.png', 'test01', '0', '0', '0'), ('180628H77RMW72FW', 'videoTest01', '4QrcOUm6Wau+VuBX8g+IPg==', '/180628H77RMW72FW/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.LXDnWjkB14tXa1cf474adf5b061016530a4d1140a391.png', 'videoTest01', '0', '0', '0'), ('180628H7F9TDFXKP', 'videoTest02', '4QrcOUm6Wau+VuBX8g+IPg==', '/180628H7F9TDFXKP/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.AyWUvGHVBJEYc72f3684d9c1218cc0c92e1871b314e4.png', 'videoTest02', '0', '0', '0'), ('180628H7RFRHXBTC', 'videoTest03', '4QrcOUm6Wau+VuBX8g+IPg==', '/180628H7RFRHXBTC/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.bpo5aVhYpTMSedbef1168621737d6a388e6c8ac78e48.png', 'videoTest03', '0', '0', '0'), ('180628H7YWGY8ZC0', 'videoTest04', '4QrcOUm6Wau+VuBX8g+IPg==', '/180628H7YWGY8ZC0/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.nHwtOw80l3QV552603298562c151e977535f166706a5.png', 'videoTest04', '0', '0', '0'), ('180628H827RADA5P', 'videoTest05', '4QrcOUm6Wau+VuBX8g+IPg==', '/180628H827RADA5P/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.tfsAERl7w0AJbe5c1a3bcf7d86c34970f7337efefc78.png', 'videoTest05', '0', '0', '0'), ('180628H87YXNF04H', 'videoTest06', '4QrcOUm6Wau+VuBX8g+IPg==', '/180628H87YXNF04H/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.smbnp9xtdv1Xbee516a3dc3ce85ed26ede26629f97dd.png', 'videoTest06', '0', '0', '0'), ('180628H8F341XA5P', 'videoTest08', '4QrcOUm6Wau+VuBX8g+IPg==', '/180628H8F341XA5P/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.iuBPVqdEDUOPc72f3684d9c1218cc0c92e1871b314e4.png', 'videoTest08', '0', '0', '0'), ('180628H8P9NWF6A8', 'videoTest09', '4QrcOUm6Wau+VuBX8g+IPg==', '/180628H8P9NWF6A8/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.3nXCGJl5dmF9552603298562c151e977535f166706a5.png', 'videoTest09', '0', '0', '0'), ('180628HDR0HNMSNC', 'videoTest10', '4QrcOUm6Wau+VuBX8g+IPg==', '/180628HDR0HNMSNC/face/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.zXnBjYWKhV79a1cf474adf5b061016530a4d1140a391.png', 'videoTest10', '0', '0', '0');
COMMIT;

-- ----------------------------
--  Table structure for `users_fans`
-- ----------------------------
DROP TABLE IF EXISTS `users_fans`;
CREATE TABLE `users_fans` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL COMMENT '用户',
  `fan_id` varchar(64) NOT NULL COMMENT '粉丝',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`,`fan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户粉丝关联关系表';

-- ----------------------------
--  Table structure for `users_like_videos`
-- ----------------------------
DROP TABLE IF EXISTS `users_like_videos`;
CREATE TABLE `users_like_videos` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL COMMENT '用户',
  `video_id` varchar(64) NOT NULL COMMENT '视频',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_video_rel` (`user_id`,`video_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户喜欢的/赞过的视频';

-- ----------------------------
--  Table structure for `users_report`
-- ----------------------------
DROP TABLE IF EXISTS `users_report`;
CREATE TABLE `users_report` (
  `id` varchar(64) NOT NULL,
  `deal_user_id` varchar(64) NOT NULL COMMENT '被举报用户id',
  `deal_video_id` varchar(64) NOT NULL,
  `title` varchar(128) NOT NULL COMMENT '类型标题，让用户选择，详情见 枚举',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `userid` varchar(64) NOT NULL COMMENT '举报人的id',
  `create_date` datetime NOT NULL COMMENT '举报时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='举报用户表';

-- ----------------------------
--  Table structure for `videos`
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos` (
  `id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL COMMENT '发布者id',
  `audio_id` varchar(64) DEFAULT NULL COMMENT '用户使用音频的信息',
  `video_desc` varchar(128) DEFAULT NULL COMMENT '视频描述',
  `video_path` varchar(255) NOT NULL COMMENT '视频存放的路径',
  `video_seconds` float(6,2) DEFAULT NULL COMMENT '视频秒数',
  `video_width` int(6) DEFAULT NULL COMMENT '视频宽度',
  `video_height` int(6) DEFAULT NULL COMMENT '视频高度',
  `cover_path` varchar(255) DEFAULT NULL COMMENT '视频封面图',
  `like_counts` bigint(20) NOT NULL DEFAULT '0' COMMENT '喜欢/赞美的数量',
  `status` int(1) NOT NULL COMMENT '视频状态：\r\n1、发布成功\r\n2、禁止播放，管理员操作',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='视频信息表';

-- ----------------------------
--  Records of `videos`
-- ----------------------------
BEGIN;
INSERT INTO `videos` VALUES ('180628ADS3BNN3TC', '180628A97P438PH0', '1001', 'get video cover', '/180628A97P438PH0/video/f82d5754-9d72-4f74-a9b9-11581466c2fc.mp4', '6.05', '960', '544', '/180628A97P438PH0/video/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.8peFqOq2wtBE379e460b69aa1a114529ca3a5e018244.jpg', '0', '1', '2018-06-28 14:42:06'), ('1806297TKGS3K680', '180628H7F9TDFXKP', '', 'wsnd', '/180628H7F9TDFXKP/video/wxc53363d3270a93f6..3eYwRk30S0N847f8fc7442c1053d486b6196cc5bc7b3.mp4', '4.44', '544', '960', '/180628H7F9TDFXKP/video/wxc53363d3270a93f6..RHzbSKrqobyE5232be7d344c025abf19859bd4915f44.jpg', '0', '1', '2018-06-29 10:59:26'), ('1806297WGR4D94ZC', '180628H77RMW72FW', '1005', 'testVideo01', '/180628H77RMW72FW/video/145d8557-0b14-4604-b7c1-9a544d5a7a9e.mp4', '14.81', '544', '960', '/180628H77RMW72FW/video/wxc53363d3270a93f6..aQ3PBtcVuIMh998d893d584eeb95300ce5f2bb3923cc.jpg', '0', '1', '2018-06-29 11:02:14'), ('1806297WZ4ZB8HM8', '180628H7RFRHXBTC', '', 'testVideo03', '/180628H7RFRHXBTC/video/wxc53363d3270a93f6..6VCW99u38TUc26c74f5f6e82f56ffb22eb9b5e15f9b5.mp4', '10.05', '960', '544', '/180628H7RFRHXBTC/video/wxc53363d3270a93f6..eRUaPqP9HSn8cacc10928eb73ae245ef7e2bbe845a8d.jpg', '0', '1', '2018-06-29 11:03:28'), ('1806297X3362CARP', '180628H7YWGY8ZC0', '1002', 'testVideo04', '/180628H7YWGY8ZC0/video/82b89725-e1da-4ccd-b797-d4cbf21dcc6e.mp4', '8.85', '544', '960', '/180628H7YWGY8ZC0/video/wxc53363d3270a93f6..Qc68P6SONxNW52476c5b29ad8f2078c5c0170ba730ad.jpg', '0', '1', '2018-06-29 11:03:53'), ('1806297X7Z2DPM80', '180628H827RADA5P', '1005', 'testVideo05', '/180628H827RADA5P/video/c8a88fc0-e963-45fa-89f5-6460f3f10d18.mp4', '10.05', '540', '928', '/180628H827RADA5P/video/wxc53363d3270a93f6..06nsHjCZm4JN97da7bad80484fc26b5ad9e56415f871.jpg', '0', '1', '2018-06-29 11:04:24'), ('1806297XB50DDD40', '180628H87YXNF04H', '1002', 'testVideo06', '/180628H87YXNF04H/video/b84c7d96-9ffa-4452-9db1-b0ff002fe16c.mp4', '10.05', '960', '540', '/180628H87YXNF04H/video/wxc53363d3270a93f6..H7QpqC1rCpZObe8be5a387dae3cd4e61eaca1a1d0af8.jpg', '0', '1', '2018-06-29 11:04:45'), ('1806297XSWN6GAA8', '180628H8F341XA5P', '1001', 'testVideo08', '/180628H8F341XA5P/video/3ca352e4-5297-46a7-baab-3e0339a7f6ec.mp4', '5.69', '544', '960', '/180628H8F341XA5P/video/wxc53363d3270a93f6..OBxlaD56P8mlc658b5a39fe6f45955f7b444189cfab0.jpg', '0', '1', '2018-06-29 11:06:00'), ('1806297Y0N3GGT2W', '180628H8P9NWF6A8', '1002', 'testVideo09', '/180628H8P9NWF6A8/video/a6b40f8b-692d-4bde-a56a-d87ee42caf34.mp4', '9.90', '960', '544', '/180628H8P9NWF6A8/video/wxc53363d3270a93f6..IXWjdIyEFyRc717fe4444b2af2333e2b448f2659011b.jpg', '0', '1', '2018-06-29 11:06:38'), ('1806297Y433X4FA8', '180628HDR0HNMSNC', '', 'testVideo10', '/180628HDR0HNMSNC/video/wxc53363d3270a93f6..k6JqcPYOHn7hf487eed0161d1c6cd30a81423342f3d4.mp4', '15.04', '960', '544', '/180628HDR0HNMSNC/video/wxc53363d3270a93f6..SNczC9qlPnftf4fa5bd517ec2571f8cb68950b3be639.jpg', '0', '1', '2018-06-29 11:07:00'), ('1806297Y91GD0A3C', '180628H7F9TDFXKP', '', 'testVideo11', '/180628H7F9TDFXKP/video/wxc53363d3270a93f6..0O232EHdhrEK26c74f5f6e82f56ffb22eb9b5e15f9b5.mp4', '10.05', '960', '544', '/180628H7F9TDFXKP/video/wxc53363d3270a93f6..2WaWZZ1rC8tH3695923d7f67ad9fb3a03faff3065fec.jpg', '0', '1', '2018-06-29 11:07:32'), ('180629B20ADHA3C0', '180628A97P438PH0', '1002', 'afsdfsdf', '/180628A97P438PH0/video/61dabc89-f18f-4eb4-994c-159da4b82314.mp4', '10.05', '540', '928', '/180628A97P438PH0/video/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.hk0nHiCWt7hu07954c090b23deac901d5870290bb812.jpg', '0', '1', '2018-06-29 15:30:49'), ('180629B3M6W312A8', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/a9c77692-0051-41b7-8efc-504b3de5ed8b.mp4', '15.00', '544', '960', '/180628A97P438PH0/video/tmp_8480e277bb0991660b9fbf82490a36c2.jpg', '0', '1', '2018-06-29 15:35:44'), ('180629B4YH23W8SW', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/7bc47d72-fad1-43c4-b285-18a27ee758fd.mp4', '3.00', '360', '480', '/180628A97P438PH0/video/tmp_2dd41823a8f89db5c80b13fba8a9d2f9.jpg', '0', '1', '2018-06-29 15:39:38'), ('180629B91N91CG0H', '180628A97P438PH0', '1001', 'sjsjjsjs', '/180628A97P438PH0/video/1d65ad49-2200-4611-9a10-31d2486c69e4.mp4', '12.00', '544', '960', '/180628A97P438PH0/video/tmp_feae1b6dd79f2ced378dda54da93a7a2.jpg', '0', '1', '2018-06-29 15:51:58'), ('180629BCAAMF4RWH', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/be2cfb09-27a5-4800-b4e4-74fa0e3c6257.mp4', '10.00', '960', '544', '/180628A97P438PH0/video/tmp_3f390d48882aa6724bdc984797efe9de.jpg', '0', '1', '2018-06-29 16:01:55'), ('180629BCXFXCAPBC', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/e6f157be-d2ce-4848-8c10-ca418227c28f.mp4', '10.00', '960', '544', '/180628A97P438PH0/video/tmp_527f6911d46885531761c576aaaabc12.jpg', '0', '1', '2018-06-29 16:03:32'), ('180629BDPDP05Z54', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/1a51c613-09a2-47e8-8767-df637a4060d9.mp4', '10.00', '960', '544', '/180628A97P438PH0/video/tmp_dd667e95a25e83f2800a8d3be7245adb.jpg', '0', '1', '2018-06-29 16:06:00'), ('180629BFCS70A0SW', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/36c4cf84-dedf-4486-85e9-8d9d6b6204d2.mp4', '10.00', '960', '544', '/180628A97P438PH0/video/tmp_851f8ce5fb9491efc44e5770efd770e5.jpg', '0', '1', '2018-06-29 16:08:11'), ('180629BHAB5DBCZC', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/ae489cee-0d95-4c34-a59b-436258859ce6.mp4', '10.00', '960', '544', '/180628A97P438PH0/video/tmp_db00cfa34ee99d9147ed4904f02a1b8a.jpg', '0', '1', '2018-06-29 16:13:56'), ('180629BHFRBKG1GC', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/7a961a06-4f56-4062-a0ed-534affe2991f.mp4', '10.00', '960', '540', '/180628A97P438PH0/video/tmp_72d423ed710eb5ff9ccf8fad6fe9e6fd.jpg', '0', '1', '2018-06-29 16:14:24'), ('180629BHNT0ZZ354', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/46a514e7-a372-4871-8d6e-1b51dac5abb2.mp4', '14.81', '544', '960', '/180628A97P438PH0/video/wxc53363d3270a93f6.o6zAJsxF3dMC248NSIioirINeOXg.xYZ2lXAFiTyJ998d893d584eeb95300ce5f2bb3923cc.jpg', '0', '1', '2018-06-29 16:14:56'), ('180629BM3TF3ST0H', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/e3134e35-d795-47ad-b8f1-0879cca2b737.mp4', '4.00', '360', '480', '/180628A97P438PH0/video/tmp_39b41146f2b3fa0c7764bb40fba51c28.jpg', '0', '1', '2018-06-29 16:19:14'), ('180629BMZFTK16Y8', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/5c1135b7-c638-432d-abc0-7d34da310afc.mp4', '7.00', '360', '480', '/180628A97P438PH0/video/tmp_3a1fa746572021731d7bc73bc24e3e44.jpg', '0', '1', '2018-06-29 16:21:46'), ('180629BSHT7M7B0H', '180628A97P438PH0', '1005', '', '/180628A97P438PH0/video/b3d15eab-bf7c-4e88-8057-2bf5faf6f91b.mp4', '2.00', '360', '480', '/180628A97P438PH0/video/tmp_11a7ca300c78b871594f849d874fc05d.jpg', '0', '1', '2018-06-29 16:32:38');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
