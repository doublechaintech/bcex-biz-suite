-- BUILD WITH MODEL TIME 191107T1853

drop database  if exists bcex;
create database bcex;
-- alter  database bcex  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use bcex;
set SESSION sql_mode='';

drop table  if exists platform_data;
create table platform_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	description                   	longtext                                 comment '描述',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "平台";
-- primary key will be created later for better import performance

drop table  if exists change_request_type_data;
create table change_request_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	code                          	varchar(40)                              comment '代码',
	icon                          	varchar(48)                              comment '图标',
	display_order                 	int                                      comment '显示顺序',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "变更请求类型";
-- primary key will be created later for better import performance

drop table  if exists change_request_data;
create table change_request_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '名称',
	create_time                   	datetime                                 comment '创建时间',
	remote_ip                     	varchar(40)                              comment '远程Ip',
	request_type                  	varchar(48)                              comment '请求类型',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "变更请求";
-- primary key will be created later for better import performance

drop table  if exists registration_data;
create table registration_data (
	id                            	varchar(48)          not null            comment 'ID',
	nick_name                     	varchar(200)                             comment '昵称',
	avatar                        	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '头像',
	change_request                	varchar(48)                              comment '变更请求',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "登记";
-- primary key will be created later for better import performance

drop table  if exists start_exam_data;
create table start_exam_data (
	id                            	varchar(48)          not null            comment 'ID',
	nick_name                     	varchar(200)                             comment '昵称',
	change_request                	varchar(48)                              comment '变更请求',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "开始考试";
-- primary key will be created later for better import performance

drop table  if exists answer_question_data;
create table answer_question_data (
	id                            	varchar(48)          not null            comment 'ID',
	nick_name                     	varchar(200)                             comment '昵称',
	user                          	varchar(48)                              comment '用户',
	question                      	varchar(48)                              comment '检查问题',
	answer                        	varchar(20)                              comment '回答',
	change_request                	varchar(48)                              comment '变更请求',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "回答问题";
-- primary key will be created later for better import performance

drop table  if exists exam_status_data;
create table exam_status_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	code                          	varchar(36)                              comment '代码',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "考试状态";
-- primary key will be created later for better import performance

drop table  if exists question_data;
create table question_data (
	id                            	varchar(48)          not null            comment 'ID',
	topic                         	varchar(80)                              comment '主题',
	level                         	varchar(4)                               comment '水平',
	option_a                      	varchar(16)                              comment 'A选项',
	option_b                      	varchar(16)                              comment 'B选项',
	option_c                      	varchar(16)                              comment 'C选项',
	option_d                      	varchar(16)                              comment 'D选项',
	option_e                      	varchar(16)                              comment 'E选项',
	right_answer                  	varchar(4)                               comment '正确的答案',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "检查问题";
-- primary key will be created later for better import performance

drop table  if exists exam_ranking_data;
create table exam_ranking_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(20)                              comment '名称',
	avatar                        	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '头像',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "考试排名";
-- primary key will be created later for better import performance

drop table  if exists answer_data;
create table answer_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '标题',
	comment                       	varchar(56)                              comment '评论',
	question                      	varchar(48)                              comment '检查问题',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "回答";
-- primary key will be created later for better import performance

drop table  if exists wechat_user_data;
create table wechat_user_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	avarta                        	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Avarta',
	create_time                   	datetime                                 comment '创建时间',
	platform                      	varchar(48)                              comment '平台',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "微信用户";
-- primary key will be created later for better import performance

drop table  if exists wechat_login_info_data;
create table wechat_login_info_data (
	id                            	varchar(48)          not null            comment 'ID',
	wechat_user                   	varchar(48)                              comment '微信用户',
	app_id                        	varchar(100)                             comment '应用程序Id',
	open_id                       	varchar(100)                             comment '开放Id',
	session_key                   	varchar(200)                             comment '会话密钥',
	last_update_time              	datetime                                 comment '最后更新时间',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "微信登录信息";
-- primary key will be created later for better import performance

drop table  if exists exam_data;
create table exam_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	create_time                   	datetime                                 comment '创建时间',
	status                        	varchar(48)                              comment '状态',
	user                          	varchar(48)                              comment '用户',
	score                         	int                                      comment '分数',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "考试";
-- primary key will be created later for better import performance

drop table  if exists user_answer_data;
create table user_answer_data (
	id                            	varchar(48)          not null            comment 'ID',
	topic                         	varchar(80)                              comment '主题',
	user_select                   	varchar(4)                               comment '用户选择',
	question                      	varchar(48)                              comment '检查问题',
	exam                          	varchar(48)                              comment '考试',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户的答案";
-- primary key will be created later for better import performance

drop table  if exists fault_answer_data;
create table fault_answer_data (
	id                            	varchar(48)          not null            comment 'ID',
	topic                         	varchar(80)                              comment '主题',
	your_answer                   	varchar(16)                              comment '你的答案',
	right_answer                  	varchar(16)                              comment '正确的答案',
	create_time                   	datetime                                 comment '创建时间',
	user                          	varchar(48)                              comment '用户',
	exam                          	varchar(48)                              comment '考试',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "错误的答案";
-- primary key will be created later for better import performance

drop table  if exists user_domain_data;
create table user_domain_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户域";
-- primary key will be created later for better import performance

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                            	varchar(48)          not null            comment 'ID',
	user_identity                 	varchar(40)                              comment '用户身份',
	user_special_functions        	varchar(200)                             comment '用户特殊功能',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户白名单";
-- primary key will be created later for better import performance

drop table  if exists sec_user_data;
create table sec_user_data (
	id                            	varchar(48)          not null            comment 'ID',
	login                         	varchar(256)                             comment '登录',
	mobile                        	varchar(11)                              comment '手机号码',
	email                         	varchar(256)                             comment '电子邮件',
	pwd                           	varchar(64)                              comment '密码',
	weixin_openid                 	varchar(128)                             comment '微信openid',
	weixin_appid                  	varchar(128)                             comment '微信Appid',
	access_token                  	varchar(128)                             comment '访问令牌',
	verification_code             	int                                      comment '验证码',
	verification_code_expire      	datetime                                 comment '验证码过期',
	last_login_time               	datetime                                 comment '最后登录时间',
	domain                        	varchar(48)                              comment '域',
	blocking                      	varchar(48)                              comment '屏蔽',
	current_status                	varchar(28)                              comment '当前状态',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "安全用户";
-- primary key will be created later for better import performance

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                            	varchar(48)          not null            comment 'ID',
	who                           	varchar(52)                              comment '谁',
	block_time                    	datetime                                 comment '块时间',
	comments                      	varchar(96)                              comment '评论',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户屏蔽";
-- primary key will be created later for better import performance

drop table  if exists user_app_data;
create table user_app_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(300)                             comment '标题',
	sec_user                      	varchar(48)                              comment '安全用户',
	app_icon                      	varchar(36)                              comment '应用程序图标',
	full_access                   	tinyint                                  comment '完全访问',
	permission                    	varchar(16)                              comment '许可',
	object_type                   	varchar(100)                             comment '访问对象类型',
	object_id                     	varchar(40)                              comment '对象ID',
	location                      	varchar(48)                              comment '位置',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户应用程序";
-- primary key will be created later for better import performance

drop table  if exists quick_link_data;
create table quick_link_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	icon                          	varchar(200)                             comment '图标',
	image_path                    	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '图片路径',
	link_target                   	varchar(200)                             comment '链接的目标',
	create_time                   	datetime                                 comment '创建时间',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "快速链接";
-- primary key will be created later for better import performance

drop table  if exists list_access_data;
create table list_access_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	internal_name                 	varchar(200)                             comment '内部名称',
	read_permission               	tinyint                                  comment '读权限',
	create_permission             	tinyint                                  comment '创建权限',
	delete_permission             	tinyint                                  comment '删除权限',
	update_permission             	tinyint                                  comment '更新权限',
	execution_permission          	tinyint                                  comment '执行权限',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "访问列表";
-- primary key will be created later for better import performance

drop table  if exists object_access_data;
create table object_access_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	object_type                   	varchar(112)                             comment '访问对象类型',
	list1                         	varchar(80)                              comment '列表1',
	list2                         	varchar(80)                              comment '列表2',
	list3                         	varchar(80)                              comment '列表3',
	list4                         	varchar(80)                              comment '列表4',
	list5                         	varchar(80)                              comment '列表5',
	list6                         	varchar(80)                              comment '列表6',
	list7                         	varchar(80)                              comment '列表7',
	list8                         	varchar(80)                              comment '列表8',
	list9                         	varchar(80)                              comment '列表9',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "对象访问";
-- primary key will be created later for better import performance

drop table  if exists login_history_data;
create table login_history_data (
	id                            	varchar(48)          not null            comment 'ID',
	login_time                    	datetime                                 comment '登录时间',
	from_ip                       	varchar(44)                              comment '来自IP',
	description                   	varchar(16)                              comment '描述',
	sec_user                      	varchar(48)                              comment '安全用户',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "登录历史";
-- primary key will be created later for better import performance

drop table  if exists generic_form_data;
create table generic_form_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(20)                              comment '标题',
	description                   	varchar(48)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "通用的形式";
-- primary key will be created later for better import performance

drop table  if exists form_message_data;
create table form_message_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(24)                              comment '标题',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单信息";
-- primary key will be created later for better import performance

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '标题',
	parameter_name                	varchar(16)                              comment '参数名称',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段的信息";
-- primary key will be created later for better import performance

drop table  if exists form_field_data;
create table form_field_data (
	id                            	varchar(48)          not null            comment 'ID',
	label                         	varchar(12)                              comment '标签',
	locale_key                    	varchar(44)                              comment '语言环境的关键',
	parameter_name                	varchar(16)                              comment '参数名称',
	type                          	varchar(36)                              comment '类型',
	form                          	varchar(48)                              comment '形式',
	placeholder                   	varchar(48)                              comment '占位符',
	default_value                 	varchar(12)                              comment '默认值',
	description                   	varchar(48)                              comment '描述',
	field_group                   	varchar(16)                              comment '字段组',
	minimum_value                 	varchar(60)                              comment '最小值',
	maximum_value                 	varchar(72)                              comment '最大值',
	required                      	tinyint                                  comment '要求',
	disabled                      	tinyint                                  comment '禁用',
	custom_rendering              	tinyint                                  comment '自定义渲染',
	candidate_values              	varchar(12)                              comment '候选人的价值观',
	suggest_values                	varchar(12)                              comment '建议值',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段";
-- primary key will be created later for better import performance

drop table  if exists form_action_data;
create table form_action_data (
	id                            	varchar(48)          not null            comment 'ID',
	label                         	varchar(8)                               comment '标签',
	locale_key                    	varchar(16)                              comment '语言环境的关键',
	action_key                    	varchar(24)                              comment '行动的关键',
	level                         	varchar(28)                              comment '水平',
	url                           	varchar(168)                             comment 'url',
	form                          	varchar(48)                              comment '形式',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单动作";
-- primary key will be created later for better import performance

drop table  if exists candidate_container_data;
create table candidate_container_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "候选人容器";
-- primary key will be created later for better import performance

drop table  if exists candidate_element_data;
create table candidate_element_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	type                          	varchar(200)                             comment '类型',
	image                         	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '图片',
	container                     	varchar(48)                              comment '容器',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "候选人元素";
-- primary key will be created later for better import performance




insert into platform_data values
	('P000001','链问链答考试中台','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','1');

insert into change_request_type_data values
	('REGISTER','注册','REGISTER','download','1','P000001','1'),
	('START_EXAM','开始考试','START_EXAM','swap','2','P000001','1'),
	('ANSWER','答题','ANSWER','upload','3','P000001','1');

insert into change_request_data values
	('CR000001','注册','2019-11-04 08:44:51','8.8.8.8','REGISTER','P000001','1'),
	('CR000002','开始考试','2019-11-02 15:45:56','8.8.8.8','REGISTER','P000001','1'),
	('CR000003','答题','2019-10-22 07:04:21','8.8.8.8','REGISTER','P000001','1'),
	('CR000004','注册','2019-11-03 20:10:21','8.8.8.8','REGISTER','P000001','1'),
	('CR000005','开始考试','2019-10-20 15:41:02','8.8.8.8','REGISTER','P000001','1'),
	('CR000006','答题','2019-11-05 04:25:04','8.8.8.8','REGISTER','P000001','1'),
	('CR000007','注册','2019-11-01 06:33:01','8.8.8.8','REGISTER','P000001','1'),
	('CR000008','开始考试','2019-10-26 04:38:55','8.8.8.8','REGISTER','P000001','1'),
	('CR000009','答题','2019-10-26 01:17:26','8.8.8.8','REGISTER','P000001','1'),
	('CR000010','注册','2019-10-27 17:09:19','8.8.8.8','REGISTER','P000001','1'),
	('CR000011','开始考试','2019-10-18 11:35:44','8.8.8.8','REGISTER','P000001','1'),
	('CR000012','答题','2019-10-25 15:13:24','8.8.8.8','REGISTER','P000001','1'),
	('CR000013','注册','2019-10-25 06:16:49','8.8.8.8','START_EXAM','P000001','1'),
	('CR000014','开始考试','2019-10-26 04:58:52','8.8.8.8','START_EXAM','P000001','1'),
	('CR000015','答题','2019-10-28 03:15:08','8.8.8.8','START_EXAM','P000001','1'),
	('CR000016','注册','2019-11-05 06:19:49','8.8.8.8','START_EXAM','P000001','1'),
	('CR000017','开始考试','2019-10-27 07:32:49','8.8.8.8','START_EXAM','P000001','1'),
	('CR000018','答题','2019-11-01 10:13:05','8.8.8.8','START_EXAM','P000001','1'),
	('CR000019','注册','2019-10-31 19:53:13','8.8.8.8','START_EXAM','P000001','1'),
	('CR000020','开始考试','2019-11-05 11:27:20','8.8.8.8','START_EXAM','P000001','1'),
	('CR000021','答题','2019-10-26 09:03:53','8.8.8.8','START_EXAM','P000001','1'),
	('CR000022','注册','2019-11-06 12:17:09','8.8.8.8','START_EXAM','P000001','1'),
	('CR000023','开始考试','2019-10-30 09:37:55','8.8.8.8','START_EXAM','P000001','1'),
	('CR000024','答题','2019-11-02 01:27:04','8.8.8.8','START_EXAM','P000001','1'),
	('CR000025','注册','2019-11-02 20:27:15','8.8.8.8','ANSWER','P000001','1'),
	('CR000026','开始考试','2019-10-17 20:18:31','8.8.8.8','ANSWER','P000001','1'),
	('CR000027','答题','2019-10-22 17:39:21','8.8.8.8','ANSWER','P000001','1'),
	('CR000028','注册','2019-10-31 16:43:49','8.8.8.8','ANSWER','P000001','1'),
	('CR000029','开始考试','2019-10-20 01:19:55','8.8.8.8','ANSWER','P000001','1'),
	('CR000030','答题','2019-10-20 14:47:23','8.8.8.8','ANSWER','P000001','1'),
	('CR000031','注册','2019-10-30 17:46:05','8.8.8.8','ANSWER','P000001','1'),
	('CR000032','开始考试','2019-11-03 23:59:20','8.8.8.8','ANSWER','P000001','1'),
	('CR000033','答题','2019-11-02 19:59:07','8.8.8.8','ANSWER','P000001','1'),
	('CR000034','注册','2019-11-04 11:42:43','8.8.8.8','ANSWER','P000001','1'),
	('CR000035','开始考试','2019-10-30 18:53:20','8.8.8.8','ANSWER','P000001','1'),
	('CR000036','答题','2019-10-25 01:30:52','8.8.8.8','ANSWER','P000001','1');

insert into registration_data values
	('R000001','豆豆鬼','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000001','1'),
	('R000002','豆豆鬼0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000001','1'),
	('R000003','豆豆鬼0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000001','1'),
	('R000004','豆豆鬼0004','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000001','1'),
	('R000005','豆豆鬼0005','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000001','1'),
	('R000006','豆豆鬼0006','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000001','1'),
	('R000007','豆豆鬼0007','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000002','1'),
	('R000008','豆豆鬼0008','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000002','1'),
	('R000009','豆豆鬼0009','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000002','1'),
	('R000010','豆豆鬼0010','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000002','1'),
	('R000011','豆豆鬼0011','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000002','1'),
	('R000012','豆豆鬼0012','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000002','1'),
	('R000013','豆豆鬼0013','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000003','1'),
	('R000014','豆豆鬼0014','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000003','1'),
	('R000015','豆豆鬼0015','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000003','1'),
	('R000016','豆豆鬼0016','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000003','1'),
	('R000017','豆豆鬼0017','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000003','1'),
	('R000018','豆豆鬼0018','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000003','1'),
	('R000019','豆豆鬼0019','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000004','1'),
	('R000020','豆豆鬼0020','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000004','1'),
	('R000021','豆豆鬼0021','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000004','1'),
	('R000022','豆豆鬼0022','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000004','1'),
	('R000023','豆豆鬼0023','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000004','1'),
	('R000024','豆豆鬼0024','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000004','1'),
	('R000025','豆豆鬼0025','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000005','1'),
	('R000026','豆豆鬼0026','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000005','1'),
	('R000027','豆豆鬼0027','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000005','1'),
	('R000028','豆豆鬼0028','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000005','1'),
	('R000029','豆豆鬼0029','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000005','1'),
	('R000030','豆豆鬼0030','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000005','1'),
	('R000031','豆豆鬼0031','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000006','1'),
	('R000032','豆豆鬼0032','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000006','1'),
	('R000033','豆豆鬼0033','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000006','1'),
	('R000034','豆豆鬼0034','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000006','1'),
	('R000035','豆豆鬼0035','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000006','1'),
	('R000036','豆豆鬼0036','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000006','1'),
	('R000037','豆豆鬼0037','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000007','1'),
	('R000038','豆豆鬼0038','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000007','1'),
	('R000039','豆豆鬼0039','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000007','1'),
	('R000040','豆豆鬼0040','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000007','1'),
	('R000041','豆豆鬼0041','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000007','1'),
	('R000042','豆豆鬼0042','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000007','1'),
	('R000043','豆豆鬼0043','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000008','1'),
	('R000044','豆豆鬼0044','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000008','1'),
	('R000045','豆豆鬼0045','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000008','1'),
	('R000046','豆豆鬼0046','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000008','1'),
	('R000047','豆豆鬼0047','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000008','1'),
	('R000048','豆豆鬼0048','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000008','1'),
	('R000049','豆豆鬼0049','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000009','1'),
	('R000050','豆豆鬼0050','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000009','1'),
	('R000051','豆豆鬼0051','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000009','1'),
	('R000052','豆豆鬼0052','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000009','1'),
	('R000053','豆豆鬼0053','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000009','1'),
	('R000054','豆豆鬼0054','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000009','1'),
	('R000055','豆豆鬼0055','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000010','1'),
	('R000056','豆豆鬼0056','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000010','1'),
	('R000057','豆豆鬼0057','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000010','1'),
	('R000058','豆豆鬼0058','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000010','1'),
	('R000059','豆豆鬼0059','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000010','1'),
	('R000060','豆豆鬼0060','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000010','1'),
	('R000061','豆豆鬼0061','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000011','1'),
	('R000062','豆豆鬼0062','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000011','1'),
	('R000063','豆豆鬼0063','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000011','1'),
	('R000064','豆豆鬼0064','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000011','1'),
	('R000065','豆豆鬼0065','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000011','1'),
	('R000066','豆豆鬼0066','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000011','1'),
	('R000067','豆豆鬼0067','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000012','1'),
	('R000068','豆豆鬼0068','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000012','1'),
	('R000069','豆豆鬼0069','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000012','1'),
	('R000070','豆豆鬼0070','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000012','1'),
	('R000071','豆豆鬼0071','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000012','1'),
	('R000072','豆豆鬼0072','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000012','1'),
	('R000073','豆豆鬼0073','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000013','1'),
	('R000074','豆豆鬼0074','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000013','1'),
	('R000075','豆豆鬼0075','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000013','1'),
	('R000076','豆豆鬼0076','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000013','1'),
	('R000077','豆豆鬼0077','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000013','1'),
	('R000078','豆豆鬼0078','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000013','1'),
	('R000079','豆豆鬼0079','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000014','1'),
	('R000080','豆豆鬼0080','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000014','1'),
	('R000081','豆豆鬼0081','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000014','1'),
	('R000082','豆豆鬼0082','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000014','1'),
	('R000083','豆豆鬼0083','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000014','1'),
	('R000084','豆豆鬼0084','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000014','1'),
	('R000085','豆豆鬼0085','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000015','1'),
	('R000086','豆豆鬼0086','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000015','1'),
	('R000087','豆豆鬼0087','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000015','1'),
	('R000088','豆豆鬼0088','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000015','1'),
	('R000089','豆豆鬼0089','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000015','1'),
	('R000090','豆豆鬼0090','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000015','1'),
	('R000091','豆豆鬼0091','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000016','1'),
	('R000092','豆豆鬼0092','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000016','1'),
	('R000093','豆豆鬼0093','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000016','1'),
	('R000094','豆豆鬼0094','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000016','1'),
	('R000095','豆豆鬼0095','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000016','1'),
	('R000096','豆豆鬼0096','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000016','1'),
	('R000097','豆豆鬼0097','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000017','1'),
	('R000098','豆豆鬼0098','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000017','1'),
	('R000099','豆豆鬼0099','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000017','1'),
	('R000100','豆豆鬼0100','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000017','1'),
	('R000101','豆豆鬼0101','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000017','1'),
	('R000102','豆豆鬼0102','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000017','1'),
	('R000103','豆豆鬼0103','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000018','1'),
	('R000104','豆豆鬼0104','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000018','1'),
	('R000105','豆豆鬼0105','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000018','1'),
	('R000106','豆豆鬼0106','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000018','1'),
	('R000107','豆豆鬼0107','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000018','1'),
	('R000108','豆豆鬼0108','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000018','1'),
	('R000109','豆豆鬼0109','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000019','1'),
	('R000110','豆豆鬼0110','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000019','1'),
	('R000111','豆豆鬼0111','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000019','1'),
	('R000112','豆豆鬼0112','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000019','1'),
	('R000113','豆豆鬼0113','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000019','1'),
	('R000114','豆豆鬼0114','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000019','1'),
	('R000115','豆豆鬼0115','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000020','1'),
	('R000116','豆豆鬼0116','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000020','1'),
	('R000117','豆豆鬼0117','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000020','1'),
	('R000118','豆豆鬼0118','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000020','1'),
	('R000119','豆豆鬼0119','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000020','1'),
	('R000120','豆豆鬼0120','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000020','1'),
	('R000121','豆豆鬼0121','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000021','1'),
	('R000122','豆豆鬼0122','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000021','1'),
	('R000123','豆豆鬼0123','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000021','1'),
	('R000124','豆豆鬼0124','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000021','1'),
	('R000125','豆豆鬼0125','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000021','1'),
	('R000126','豆豆鬼0126','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000021','1'),
	('R000127','豆豆鬼0127','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000022','1'),
	('R000128','豆豆鬼0128','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000022','1'),
	('R000129','豆豆鬼0129','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000022','1'),
	('R000130','豆豆鬼0130','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000022','1'),
	('R000131','豆豆鬼0131','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000022','1'),
	('R000132','豆豆鬼0132','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000022','1'),
	('R000133','豆豆鬼0133','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000023','1'),
	('R000134','豆豆鬼0134','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000023','1'),
	('R000135','豆豆鬼0135','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000023','1'),
	('R000136','豆豆鬼0136','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000023','1'),
	('R000137','豆豆鬼0137','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000023','1'),
	('R000138','豆豆鬼0138','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000023','1'),
	('R000139','豆豆鬼0139','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000024','1'),
	('R000140','豆豆鬼0140','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000024','1'),
	('R000141','豆豆鬼0141','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000024','1'),
	('R000142','豆豆鬼0142','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000024','1'),
	('R000143','豆豆鬼0143','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000024','1'),
	('R000144','豆豆鬼0144','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000024','1'),
	('R000145','豆豆鬼0145','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000025','1'),
	('R000146','豆豆鬼0146','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000025','1'),
	('R000147','豆豆鬼0147','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000025','1'),
	('R000148','豆豆鬼0148','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000025','1'),
	('R000149','豆豆鬼0149','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000025','1'),
	('R000150','豆豆鬼0150','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000025','1'),
	('R000151','豆豆鬼0151','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000026','1'),
	('R000152','豆豆鬼0152','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000026','1'),
	('R000153','豆豆鬼0153','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000026','1'),
	('R000154','豆豆鬼0154','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000026','1'),
	('R000155','豆豆鬼0155','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000026','1'),
	('R000156','豆豆鬼0156','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000026','1'),
	('R000157','豆豆鬼0157','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000027','1'),
	('R000158','豆豆鬼0158','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000027','1'),
	('R000159','豆豆鬼0159','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000027','1'),
	('R000160','豆豆鬼0160','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000027','1'),
	('R000161','豆豆鬼0161','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000027','1'),
	('R000162','豆豆鬼0162','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000027','1'),
	('R000163','豆豆鬼0163','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000028','1'),
	('R000164','豆豆鬼0164','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000028','1'),
	('R000165','豆豆鬼0165','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000028','1'),
	('R000166','豆豆鬼0166','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000028','1'),
	('R000167','豆豆鬼0167','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000028','1'),
	('R000168','豆豆鬼0168','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000028','1'),
	('R000169','豆豆鬼0169','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000029','1'),
	('R000170','豆豆鬼0170','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000029','1'),
	('R000171','豆豆鬼0171','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000029','1'),
	('R000172','豆豆鬼0172','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000029','1'),
	('R000173','豆豆鬼0173','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000029','1'),
	('R000174','豆豆鬼0174','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000029','1'),
	('R000175','豆豆鬼0175','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000030','1'),
	('R000176','豆豆鬼0176','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000030','1'),
	('R000177','豆豆鬼0177','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000030','1'),
	('R000178','豆豆鬼0178','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000030','1'),
	('R000179','豆豆鬼0179','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000030','1'),
	('R000180','豆豆鬼0180','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000030','1'),
	('R000181','豆豆鬼0181','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000031','1'),
	('R000182','豆豆鬼0182','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000031','1'),
	('R000183','豆豆鬼0183','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000031','1'),
	('R000184','豆豆鬼0184','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000031','1'),
	('R000185','豆豆鬼0185','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000031','1'),
	('R000186','豆豆鬼0186','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000031','1'),
	('R000187','豆豆鬼0187','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000032','1'),
	('R000188','豆豆鬼0188','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000032','1'),
	('R000189','豆豆鬼0189','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000032','1'),
	('R000190','豆豆鬼0190','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000032','1'),
	('R000191','豆豆鬼0191','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000032','1'),
	('R000192','豆豆鬼0192','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000032','1'),
	('R000193','豆豆鬼0193','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000033','1'),
	('R000194','豆豆鬼0194','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000033','1'),
	('R000195','豆豆鬼0195','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000033','1'),
	('R000196','豆豆鬼0196','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000033','1'),
	('R000197','豆豆鬼0197','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000033','1'),
	('R000198','豆豆鬼0198','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000033','1'),
	('R000199','豆豆鬼0199','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000034','1'),
	('R000200','豆豆鬼0200','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000034','1'),
	('R000201','豆豆鬼0201','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000034','1'),
	('R000202','豆豆鬼0202','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000034','1'),
	('R000203','豆豆鬼0203','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000034','1'),
	('R000204','豆豆鬼0204','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000034','1'),
	('R000205','豆豆鬼0205','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000035','1'),
	('R000206','豆豆鬼0206','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000035','1'),
	('R000207','豆豆鬼0207','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000035','1'),
	('R000208','豆豆鬼0208','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000035','1'),
	('R000209','豆豆鬼0209','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000035','1'),
	('R000210','豆豆鬼0210','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000035','1'),
	('R000211','豆豆鬼0211','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000036','1'),
	('R000212','豆豆鬼0212','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000036','1'),
	('R000213','豆豆鬼0213','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000036','1'),
	('R000214','豆豆鬼0214','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000036','1'),
	('R000215','豆豆鬼0215','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000036','1'),
	('R000216','豆豆鬼0216','https://demo.doublechaintech.com/demodata/imageManager/genImage/share00/400/200/grey/','CR000036','1');

insert into start_exam_data values
	('SE000001','豆豆鬼参与考试','CR000001','1'),
	('SE000002','豆豆鬼参与考试0002','CR000001','1'),
	('SE000003','豆豆鬼参与考试0003','CR000001','1'),
	('SE000004','豆豆鬼参与考试0004','CR000001','1'),
	('SE000005','豆豆鬼参与考试0005','CR000001','1'),
	('SE000006','豆豆鬼参与考试0006','CR000001','1'),
	('SE000007','豆豆鬼参与考试0007','CR000002','1'),
	('SE000008','豆豆鬼参与考试0008','CR000002','1'),
	('SE000009','豆豆鬼参与考试0009','CR000002','1'),
	('SE000010','豆豆鬼参与考试0010','CR000002','1'),
	('SE000011','豆豆鬼参与考试0011','CR000002','1'),
	('SE000012','豆豆鬼参与考试0012','CR000002','1'),
	('SE000013','豆豆鬼参与考试0013','CR000003','1'),
	('SE000014','豆豆鬼参与考试0014','CR000003','1'),
	('SE000015','豆豆鬼参与考试0015','CR000003','1'),
	('SE000016','豆豆鬼参与考试0016','CR000003','1'),
	('SE000017','豆豆鬼参与考试0017','CR000003','1'),
	('SE000018','豆豆鬼参与考试0018','CR000003','1'),
	('SE000019','豆豆鬼参与考试0019','CR000004','1'),
	('SE000020','豆豆鬼参与考试0020','CR000004','1'),
	('SE000021','豆豆鬼参与考试0021','CR000004','1'),
	('SE000022','豆豆鬼参与考试0022','CR000004','1'),
	('SE000023','豆豆鬼参与考试0023','CR000004','1'),
	('SE000024','豆豆鬼参与考试0024','CR000004','1'),
	('SE000025','豆豆鬼参与考试0025','CR000005','1'),
	('SE000026','豆豆鬼参与考试0026','CR000005','1'),
	('SE000027','豆豆鬼参与考试0027','CR000005','1'),
	('SE000028','豆豆鬼参与考试0028','CR000005','1'),
	('SE000029','豆豆鬼参与考试0029','CR000005','1'),
	('SE000030','豆豆鬼参与考试0030','CR000005','1'),
	('SE000031','豆豆鬼参与考试0031','CR000006','1'),
	('SE000032','豆豆鬼参与考试0032','CR000006','1'),
	('SE000033','豆豆鬼参与考试0033','CR000006','1'),
	('SE000034','豆豆鬼参与考试0034','CR000006','1'),
	('SE000035','豆豆鬼参与考试0035','CR000006','1'),
	('SE000036','豆豆鬼参与考试0036','CR000006','1'),
	('SE000037','豆豆鬼参与考试0037','CR000007','1'),
	('SE000038','豆豆鬼参与考试0038','CR000007','1'),
	('SE000039','豆豆鬼参与考试0039','CR000007','1'),
	('SE000040','豆豆鬼参与考试0040','CR000007','1'),
	('SE000041','豆豆鬼参与考试0041','CR000007','1'),
	('SE000042','豆豆鬼参与考试0042','CR000007','1'),
	('SE000043','豆豆鬼参与考试0043','CR000008','1'),
	('SE000044','豆豆鬼参与考试0044','CR000008','1'),
	('SE000045','豆豆鬼参与考试0045','CR000008','1'),
	('SE000046','豆豆鬼参与考试0046','CR000008','1'),
	('SE000047','豆豆鬼参与考试0047','CR000008','1'),
	('SE000048','豆豆鬼参与考试0048','CR000008','1'),
	('SE000049','豆豆鬼参与考试0049','CR000009','1'),
	('SE000050','豆豆鬼参与考试0050','CR000009','1'),
	('SE000051','豆豆鬼参与考试0051','CR000009','1'),
	('SE000052','豆豆鬼参与考试0052','CR000009','1'),
	('SE000053','豆豆鬼参与考试0053','CR000009','1'),
	('SE000054','豆豆鬼参与考试0054','CR000009','1'),
	('SE000055','豆豆鬼参与考试0055','CR000010','1'),
	('SE000056','豆豆鬼参与考试0056','CR000010','1'),
	('SE000057','豆豆鬼参与考试0057','CR000010','1'),
	('SE000058','豆豆鬼参与考试0058','CR000010','1'),
	('SE000059','豆豆鬼参与考试0059','CR000010','1'),
	('SE000060','豆豆鬼参与考试0060','CR000010','1'),
	('SE000061','豆豆鬼参与考试0061','CR000011','1'),
	('SE000062','豆豆鬼参与考试0062','CR000011','1'),
	('SE000063','豆豆鬼参与考试0063','CR000011','1'),
	('SE000064','豆豆鬼参与考试0064','CR000011','1'),
	('SE000065','豆豆鬼参与考试0065','CR000011','1'),
	('SE000066','豆豆鬼参与考试0066','CR000011','1'),
	('SE000067','豆豆鬼参与考试0067','CR000012','1'),
	('SE000068','豆豆鬼参与考试0068','CR000012','1'),
	('SE000069','豆豆鬼参与考试0069','CR000012','1'),
	('SE000070','豆豆鬼参与考试0070','CR000012','1'),
	('SE000071','豆豆鬼参与考试0071','CR000012','1'),
	('SE000072','豆豆鬼参与考试0072','CR000012','1'),
	('SE000073','豆豆鬼参与考试0073','CR000013','1'),
	('SE000074','豆豆鬼参与考试0074','CR000013','1'),
	('SE000075','豆豆鬼参与考试0075','CR000013','1'),
	('SE000076','豆豆鬼参与考试0076','CR000013','1'),
	('SE000077','豆豆鬼参与考试0077','CR000013','1'),
	('SE000078','豆豆鬼参与考试0078','CR000013','1'),
	('SE000079','豆豆鬼参与考试0079','CR000014','1'),
	('SE000080','豆豆鬼参与考试0080','CR000014','1'),
	('SE000081','豆豆鬼参与考试0081','CR000014','1'),
	('SE000082','豆豆鬼参与考试0082','CR000014','1'),
	('SE000083','豆豆鬼参与考试0083','CR000014','1'),
	('SE000084','豆豆鬼参与考试0084','CR000014','1'),
	('SE000085','豆豆鬼参与考试0085','CR000015','1'),
	('SE000086','豆豆鬼参与考试0086','CR000015','1'),
	('SE000087','豆豆鬼参与考试0087','CR000015','1'),
	('SE000088','豆豆鬼参与考试0088','CR000015','1'),
	('SE000089','豆豆鬼参与考试0089','CR000015','1'),
	('SE000090','豆豆鬼参与考试0090','CR000015','1'),
	('SE000091','豆豆鬼参与考试0091','CR000016','1'),
	('SE000092','豆豆鬼参与考试0092','CR000016','1'),
	('SE000093','豆豆鬼参与考试0093','CR000016','1'),
	('SE000094','豆豆鬼参与考试0094','CR000016','1'),
	('SE000095','豆豆鬼参与考试0095','CR000016','1'),
	('SE000096','豆豆鬼参与考试0096','CR000016','1'),
	('SE000097','豆豆鬼参与考试0097','CR000017','1'),
	('SE000098','豆豆鬼参与考试0098','CR000017','1'),
	('SE000099','豆豆鬼参与考试0099','CR000017','1'),
	('SE000100','豆豆鬼参与考试0100','CR000017','1'),
	('SE000101','豆豆鬼参与考试0101','CR000017','1'),
	('SE000102','豆豆鬼参与考试0102','CR000017','1'),
	('SE000103','豆豆鬼参与考试0103','CR000018','1'),
	('SE000104','豆豆鬼参与考试0104','CR000018','1'),
	('SE000105','豆豆鬼参与考试0105','CR000018','1'),
	('SE000106','豆豆鬼参与考试0106','CR000018','1'),
	('SE000107','豆豆鬼参与考试0107','CR000018','1'),
	('SE000108','豆豆鬼参与考试0108','CR000018','1'),
	('SE000109','豆豆鬼参与考试0109','CR000019','1'),
	('SE000110','豆豆鬼参与考试0110','CR000019','1'),
	('SE000111','豆豆鬼参与考试0111','CR000019','1'),
	('SE000112','豆豆鬼参与考试0112','CR000019','1'),
	('SE000113','豆豆鬼参与考试0113','CR000019','1'),
	('SE000114','豆豆鬼参与考试0114','CR000019','1'),
	('SE000115','豆豆鬼参与考试0115','CR000020','1'),
	('SE000116','豆豆鬼参与考试0116','CR000020','1'),
	('SE000117','豆豆鬼参与考试0117','CR000020','1'),
	('SE000118','豆豆鬼参与考试0118','CR000020','1'),
	('SE000119','豆豆鬼参与考试0119','CR000020','1'),
	('SE000120','豆豆鬼参与考试0120','CR000020','1'),
	('SE000121','豆豆鬼参与考试0121','CR000021','1'),
	('SE000122','豆豆鬼参与考试0122','CR000021','1'),
	('SE000123','豆豆鬼参与考试0123','CR000021','1'),
	('SE000124','豆豆鬼参与考试0124','CR000021','1'),
	('SE000125','豆豆鬼参与考试0125','CR000021','1'),
	('SE000126','豆豆鬼参与考试0126','CR000021','1'),
	('SE000127','豆豆鬼参与考试0127','CR000022','1'),
	('SE000128','豆豆鬼参与考试0128','CR000022','1'),
	('SE000129','豆豆鬼参与考试0129','CR000022','1'),
	('SE000130','豆豆鬼参与考试0130','CR000022','1'),
	('SE000131','豆豆鬼参与考试0131','CR000022','1'),
	('SE000132','豆豆鬼参与考试0132','CR000022','1'),
	('SE000133','豆豆鬼参与考试0133','CR000023','1'),
	('SE000134','豆豆鬼参与考试0134','CR000023','1'),
	('SE000135','豆豆鬼参与考试0135','CR000023','1'),
	('SE000136','豆豆鬼参与考试0136','CR000023','1'),
	('SE000137','豆豆鬼参与考试0137','CR000023','1'),
	('SE000138','豆豆鬼参与考试0138','CR000023','1'),
	('SE000139','豆豆鬼参与考试0139','CR000024','1'),
	('SE000140','豆豆鬼参与考试0140','CR000024','1'),
	('SE000141','豆豆鬼参与考试0141','CR000024','1'),
	('SE000142','豆豆鬼参与考试0142','CR000024','1'),
	('SE000143','豆豆鬼参与考试0143','CR000024','1'),
	('SE000144','豆豆鬼参与考试0144','CR000024','1'),
	('SE000145','豆豆鬼参与考试0145','CR000025','1'),
	('SE000146','豆豆鬼参与考试0146','CR000025','1'),
	('SE000147','豆豆鬼参与考试0147','CR000025','1'),
	('SE000148','豆豆鬼参与考试0148','CR000025','1'),
	('SE000149','豆豆鬼参与考试0149','CR000025','1'),
	('SE000150','豆豆鬼参与考试0150','CR000025','1'),
	('SE000151','豆豆鬼参与考试0151','CR000026','1'),
	('SE000152','豆豆鬼参与考试0152','CR000026','1'),
	('SE000153','豆豆鬼参与考试0153','CR000026','1'),
	('SE000154','豆豆鬼参与考试0154','CR000026','1'),
	('SE000155','豆豆鬼参与考试0155','CR000026','1'),
	('SE000156','豆豆鬼参与考试0156','CR000026','1'),
	('SE000157','豆豆鬼参与考试0157','CR000027','1'),
	('SE000158','豆豆鬼参与考试0158','CR000027','1'),
	('SE000159','豆豆鬼参与考试0159','CR000027','1'),
	('SE000160','豆豆鬼参与考试0160','CR000027','1'),
	('SE000161','豆豆鬼参与考试0161','CR000027','1'),
	('SE000162','豆豆鬼参与考试0162','CR000027','1'),
	('SE000163','豆豆鬼参与考试0163','CR000028','1'),
	('SE000164','豆豆鬼参与考试0164','CR000028','1'),
	('SE000165','豆豆鬼参与考试0165','CR000028','1'),
	('SE000166','豆豆鬼参与考试0166','CR000028','1'),
	('SE000167','豆豆鬼参与考试0167','CR000028','1'),
	('SE000168','豆豆鬼参与考试0168','CR000028','1'),
	('SE000169','豆豆鬼参与考试0169','CR000029','1'),
	('SE000170','豆豆鬼参与考试0170','CR000029','1'),
	('SE000171','豆豆鬼参与考试0171','CR000029','1'),
	('SE000172','豆豆鬼参与考试0172','CR000029','1'),
	('SE000173','豆豆鬼参与考试0173','CR000029','1'),
	('SE000174','豆豆鬼参与考试0174','CR000029','1'),
	('SE000175','豆豆鬼参与考试0175','CR000030','1'),
	('SE000176','豆豆鬼参与考试0176','CR000030','1'),
	('SE000177','豆豆鬼参与考试0177','CR000030','1'),
	('SE000178','豆豆鬼参与考试0178','CR000030','1'),
	('SE000179','豆豆鬼参与考试0179','CR000030','1'),
	('SE000180','豆豆鬼参与考试0180','CR000030','1'),
	('SE000181','豆豆鬼参与考试0181','CR000031','1'),
	('SE000182','豆豆鬼参与考试0182','CR000031','1'),
	('SE000183','豆豆鬼参与考试0183','CR000031','1'),
	('SE000184','豆豆鬼参与考试0184','CR000031','1'),
	('SE000185','豆豆鬼参与考试0185','CR000031','1'),
	('SE000186','豆豆鬼参与考试0186','CR000031','1'),
	('SE000187','豆豆鬼参与考试0187','CR000032','1'),
	('SE000188','豆豆鬼参与考试0188','CR000032','1'),
	('SE000189','豆豆鬼参与考试0189','CR000032','1'),
	('SE000190','豆豆鬼参与考试0190','CR000032','1'),
	('SE000191','豆豆鬼参与考试0191','CR000032','1'),
	('SE000192','豆豆鬼参与考试0192','CR000032','1'),
	('SE000193','豆豆鬼参与考试0193','CR000033','1'),
	('SE000194','豆豆鬼参与考试0194','CR000033','1'),
	('SE000195','豆豆鬼参与考试0195','CR000033','1'),
	('SE000196','豆豆鬼参与考试0196','CR000033','1'),
	('SE000197','豆豆鬼参与考试0197','CR000033','1'),
	('SE000198','豆豆鬼参与考试0198','CR000033','1'),
	('SE000199','豆豆鬼参与考试0199','CR000034','1'),
	('SE000200','豆豆鬼参与考试0200','CR000034','1'),
	('SE000201','豆豆鬼参与考试0201','CR000034','1'),
	('SE000202','豆豆鬼参与考试0202','CR000034','1'),
	('SE000203','豆豆鬼参与考试0203','CR000034','1'),
	('SE000204','豆豆鬼参与考试0204','CR000034','1'),
	('SE000205','豆豆鬼参与考试0205','CR000035','1'),
	('SE000206','豆豆鬼参与考试0206','CR000035','1'),
	('SE000207','豆豆鬼参与考试0207','CR000035','1'),
	('SE000208','豆豆鬼参与考试0208','CR000035','1'),
	('SE000209','豆豆鬼参与考试0209','CR000035','1'),
	('SE000210','豆豆鬼参与考试0210','CR000035','1'),
	('SE000211','豆豆鬼参与考试0211','CR000036','1'),
	('SE000212','豆豆鬼参与考试0212','CR000036','1'),
	('SE000213','豆豆鬼参与考试0213','CR000036','1'),
	('SE000214','豆豆鬼参与考试0214','CR000036','1'),
	('SE000215','豆豆鬼参与考试0215','CR000036','1'),
	('SE000216','豆豆鬼参与考试0216','CR000036','1');

insert into answer_question_data values
	('AQ000001','豆豆鬼参与考试','WU000001','Q000001','A','CR000001','1'),
	('AQ000002','豆豆鬼参与考试0002','WU000001','Q000001','B','CR000001','1'),
	('AQ000003','豆豆鬼参与考试0003','WU000001','Q000001','C','CR000001','1'),
	('AQ000004','豆豆鬼参与考试0004','WU000001','Q000001','A','CR000001','1'),
	('AQ000005','豆豆鬼参与考试0005','WU000001','Q000001','B','CR000001','1'),
	('AQ000006','豆豆鬼参与考试0006','WU000001','Q000001','C','CR000001','1'),
	('AQ000007','豆豆鬼参与考试0007','WU000001','Q000001','A','CR000002','1'),
	('AQ000008','豆豆鬼参与考试0008','WU000001','Q000001','B','CR000002','1'),
	('AQ000009','豆豆鬼参与考试0009','WU000001','Q000001','C','CR000002','1'),
	('AQ000010','豆豆鬼参与考试0010','WU000001','Q000001','A','CR000002','1'),
	('AQ000011','豆豆鬼参与考试0011','WU000001','Q000001','B','CR000002','1'),
	('AQ000012','豆豆鬼参与考试0012','WU000001','Q000001','C','CR000002','1'),
	('AQ000013','豆豆鬼参与考试0013','WU000001','Q000001','A','CR000003','1'),
	('AQ000014','豆豆鬼参与考试0014','WU000001','Q000001','B','CR000003','1'),
	('AQ000015','豆豆鬼参与考试0015','WU000001','Q000001','C','CR000003','1'),
	('AQ000016','豆豆鬼参与考试0016','WU000001','Q000001','A','CR000003','1'),
	('AQ000017','豆豆鬼参与考试0017','WU000001','Q000001','B','CR000003','1'),
	('AQ000018','豆豆鬼参与考试0018','WU000001','Q000001','C','CR000003','1'),
	('AQ000019','豆豆鬼参与考试0019','WU000001','Q000001','A','CR000004','1'),
	('AQ000020','豆豆鬼参与考试0020','WU000001','Q000001','B','CR000004','1'),
	('AQ000021','豆豆鬼参与考试0021','WU000001','Q000001','C','CR000004','1'),
	('AQ000022','豆豆鬼参与考试0022','WU000001','Q000001','A','CR000004','1'),
	('AQ000023','豆豆鬼参与考试0023','WU000001','Q000001','B','CR000004','1'),
	('AQ000024','豆豆鬼参与考试0024','WU000001','Q000001','C','CR000004','1'),
	('AQ000025','豆豆鬼参与考试0025','WU000001','Q000001','A','CR000005','1'),
	('AQ000026','豆豆鬼参与考试0026','WU000001','Q000001','B','CR000005','1'),
	('AQ000027','豆豆鬼参与考试0027','WU000001','Q000001','C','CR000005','1'),
	('AQ000028','豆豆鬼参与考试0028','WU000001','Q000001','A','CR000005','1'),
	('AQ000029','豆豆鬼参与考试0029','WU000001','Q000001','B','CR000005','1'),
	('AQ000030','豆豆鬼参与考试0030','WU000001','Q000001','C','CR000005','1'),
	('AQ000031','豆豆鬼参与考试0031','WU000001','Q000001','A','CR000006','1'),
	('AQ000032','豆豆鬼参与考试0032','WU000001','Q000001','B','CR000006','1'),
	('AQ000033','豆豆鬼参与考试0033','WU000001','Q000001','C','CR000006','1'),
	('AQ000034','豆豆鬼参与考试0034','WU000001','Q000001','A','CR000006','1'),
	('AQ000035','豆豆鬼参与考试0035','WU000001','Q000001','B','CR000006','1'),
	('AQ000036','豆豆鬼参与考试0036','WU000001','Q000001','C','CR000006','1'),
	('AQ000037','豆豆鬼参与考试0037','WU000002','Q000002','A','CR000007','1'),
	('AQ000038','豆豆鬼参与考试0038','WU000002','Q000002','B','CR000007','1'),
	('AQ000039','豆豆鬼参与考试0039','WU000002','Q000002','C','CR000007','1'),
	('AQ000040','豆豆鬼参与考试0040','WU000002','Q000002','A','CR000007','1'),
	('AQ000041','豆豆鬼参与考试0041','WU000002','Q000002','B','CR000007','1'),
	('AQ000042','豆豆鬼参与考试0042','WU000002','Q000002','C','CR000007','1'),
	('AQ000043','豆豆鬼参与考试0043','WU000002','Q000002','A','CR000008','1'),
	('AQ000044','豆豆鬼参与考试0044','WU000002','Q000002','B','CR000008','1'),
	('AQ000045','豆豆鬼参与考试0045','WU000002','Q000002','C','CR000008','1'),
	('AQ000046','豆豆鬼参与考试0046','WU000002','Q000002','A','CR000008','1'),
	('AQ000047','豆豆鬼参与考试0047','WU000002','Q000002','B','CR000008','1'),
	('AQ000048','豆豆鬼参与考试0048','WU000002','Q000002','C','CR000008','1'),
	('AQ000049','豆豆鬼参与考试0049','WU000002','Q000002','A','CR000009','1'),
	('AQ000050','豆豆鬼参与考试0050','WU000002','Q000002','B','CR000009','1'),
	('AQ000051','豆豆鬼参与考试0051','WU000002','Q000002','C','CR000009','1'),
	('AQ000052','豆豆鬼参与考试0052','WU000002','Q000002','A','CR000009','1'),
	('AQ000053','豆豆鬼参与考试0053','WU000002','Q000002','B','CR000009','1'),
	('AQ000054','豆豆鬼参与考试0054','WU000002','Q000002','C','CR000009','1'),
	('AQ000055','豆豆鬼参与考试0055','WU000002','Q000002','A','CR000010','1'),
	('AQ000056','豆豆鬼参与考试0056','WU000002','Q000002','B','CR000010','1'),
	('AQ000057','豆豆鬼参与考试0057','WU000002','Q000002','C','CR000010','1'),
	('AQ000058','豆豆鬼参与考试0058','WU000002','Q000002','A','CR000010','1'),
	('AQ000059','豆豆鬼参与考试0059','WU000002','Q000002','B','CR000010','1'),
	('AQ000060','豆豆鬼参与考试0060','WU000002','Q000002','C','CR000010','1'),
	('AQ000061','豆豆鬼参与考试0061','WU000002','Q000002','A','CR000011','1'),
	('AQ000062','豆豆鬼参与考试0062','WU000002','Q000002','B','CR000011','1'),
	('AQ000063','豆豆鬼参与考试0063','WU000002','Q000002','C','CR000011','1'),
	('AQ000064','豆豆鬼参与考试0064','WU000002','Q000002','A','CR000011','1'),
	('AQ000065','豆豆鬼参与考试0065','WU000002','Q000002','B','CR000011','1'),
	('AQ000066','豆豆鬼参与考试0066','WU000002','Q000002','C','CR000011','1'),
	('AQ000067','豆豆鬼参与考试0067','WU000002','Q000002','A','CR000012','1'),
	('AQ000068','豆豆鬼参与考试0068','WU000002','Q000002','B','CR000012','1'),
	('AQ000069','豆豆鬼参与考试0069','WU000002','Q000002','C','CR000012','1'),
	('AQ000070','豆豆鬼参与考试0070','WU000002','Q000002','A','CR000012','1'),
	('AQ000071','豆豆鬼参与考试0071','WU000002','Q000002','B','CR000012','1'),
	('AQ000072','豆豆鬼参与考试0072','WU000002','Q000002','C','CR000012','1'),
	('AQ000073','豆豆鬼参与考试0073','WU000003','Q000003','A','CR000013','1'),
	('AQ000074','豆豆鬼参与考试0074','WU000003','Q000003','B','CR000013','1'),
	('AQ000075','豆豆鬼参与考试0075','WU000003','Q000003','C','CR000013','1'),
	('AQ000076','豆豆鬼参与考试0076','WU000003','Q000003','A','CR000013','1'),
	('AQ000077','豆豆鬼参与考试0077','WU000003','Q000003','B','CR000013','1'),
	('AQ000078','豆豆鬼参与考试0078','WU000003','Q000003','C','CR000013','1'),
	('AQ000079','豆豆鬼参与考试0079','WU000003','Q000003','A','CR000014','1'),
	('AQ000080','豆豆鬼参与考试0080','WU000003','Q000003','B','CR000014','1'),
	('AQ000081','豆豆鬼参与考试0081','WU000003','Q000003','C','CR000014','1'),
	('AQ000082','豆豆鬼参与考试0082','WU000003','Q000003','A','CR000014','1'),
	('AQ000083','豆豆鬼参与考试0083','WU000003','Q000003','B','CR000014','1'),
	('AQ000084','豆豆鬼参与考试0084','WU000003','Q000003','C','CR000014','1'),
	('AQ000085','豆豆鬼参与考试0085','WU000003','Q000003','A','CR000015','1'),
	('AQ000086','豆豆鬼参与考试0086','WU000003','Q000003','B','CR000015','1'),
	('AQ000087','豆豆鬼参与考试0087','WU000003','Q000003','C','CR000015','1'),
	('AQ000088','豆豆鬼参与考试0088','WU000003','Q000003','A','CR000015','1'),
	('AQ000089','豆豆鬼参与考试0089','WU000003','Q000003','B','CR000015','1'),
	('AQ000090','豆豆鬼参与考试0090','WU000003','Q000003','C','CR000015','1'),
	('AQ000091','豆豆鬼参与考试0091','WU000003','Q000003','A','CR000016','1'),
	('AQ000092','豆豆鬼参与考试0092','WU000003','Q000003','B','CR000016','1'),
	('AQ000093','豆豆鬼参与考试0093','WU000003','Q000003','C','CR000016','1'),
	('AQ000094','豆豆鬼参与考试0094','WU000003','Q000003','A','CR000016','1'),
	('AQ000095','豆豆鬼参与考试0095','WU000003','Q000003','B','CR000016','1'),
	('AQ000096','豆豆鬼参与考试0096','WU000003','Q000003','C','CR000016','1'),
	('AQ000097','豆豆鬼参与考试0097','WU000003','Q000003','A','CR000017','1'),
	('AQ000098','豆豆鬼参与考试0098','WU000003','Q000003','B','CR000017','1'),
	('AQ000099','豆豆鬼参与考试0099','WU000003','Q000003','C','CR000017','1'),
	('AQ000100','豆豆鬼参与考试0100','WU000003','Q000003','A','CR000017','1'),
	('AQ000101','豆豆鬼参与考试0101','WU000003','Q000003','B','CR000017','1'),
	('AQ000102','豆豆鬼参与考试0102','WU000003','Q000003','C','CR000017','1'),
	('AQ000103','豆豆鬼参与考试0103','WU000003','Q000003','A','CR000018','1'),
	('AQ000104','豆豆鬼参与考试0104','WU000003','Q000003','B','CR000018','1'),
	('AQ000105','豆豆鬼参与考试0105','WU000003','Q000003','C','CR000018','1'),
	('AQ000106','豆豆鬼参与考试0106','WU000003','Q000003','A','CR000018','1'),
	('AQ000107','豆豆鬼参与考试0107','WU000003','Q000003','B','CR000018','1'),
	('AQ000108','豆豆鬼参与考试0108','WU000003','Q000003','C','CR000018','1'),
	('AQ000109','豆豆鬼参与考试0109','WU000004','Q000004','A','CR000019','1'),
	('AQ000110','豆豆鬼参与考试0110','WU000004','Q000004','B','CR000019','1'),
	('AQ000111','豆豆鬼参与考试0111','WU000004','Q000004','C','CR000019','1'),
	('AQ000112','豆豆鬼参与考试0112','WU000004','Q000004','A','CR000019','1'),
	('AQ000113','豆豆鬼参与考试0113','WU000004','Q000004','B','CR000019','1'),
	('AQ000114','豆豆鬼参与考试0114','WU000004','Q000004','C','CR000019','1'),
	('AQ000115','豆豆鬼参与考试0115','WU000004','Q000004','A','CR000020','1'),
	('AQ000116','豆豆鬼参与考试0116','WU000004','Q000004','B','CR000020','1'),
	('AQ000117','豆豆鬼参与考试0117','WU000004','Q000004','C','CR000020','1'),
	('AQ000118','豆豆鬼参与考试0118','WU000004','Q000004','A','CR000020','1'),
	('AQ000119','豆豆鬼参与考试0119','WU000004','Q000004','B','CR000020','1'),
	('AQ000120','豆豆鬼参与考试0120','WU000004','Q000004','C','CR000020','1'),
	('AQ000121','豆豆鬼参与考试0121','WU000004','Q000004','A','CR000021','1'),
	('AQ000122','豆豆鬼参与考试0122','WU000004','Q000004','B','CR000021','1'),
	('AQ000123','豆豆鬼参与考试0123','WU000004','Q000004','C','CR000021','1'),
	('AQ000124','豆豆鬼参与考试0124','WU000004','Q000004','A','CR000021','1'),
	('AQ000125','豆豆鬼参与考试0125','WU000004','Q000004','B','CR000021','1'),
	('AQ000126','豆豆鬼参与考试0126','WU000004','Q000004','C','CR000021','1'),
	('AQ000127','豆豆鬼参与考试0127','WU000004','Q000004','A','CR000022','1'),
	('AQ000128','豆豆鬼参与考试0128','WU000004','Q000004','B','CR000022','1'),
	('AQ000129','豆豆鬼参与考试0129','WU000004','Q000004','C','CR000022','1'),
	('AQ000130','豆豆鬼参与考试0130','WU000004','Q000004','A','CR000022','1'),
	('AQ000131','豆豆鬼参与考试0131','WU000004','Q000004','B','CR000022','1'),
	('AQ000132','豆豆鬼参与考试0132','WU000004','Q000004','C','CR000022','1'),
	('AQ000133','豆豆鬼参与考试0133','WU000004','Q000004','A','CR000023','1'),
	('AQ000134','豆豆鬼参与考试0134','WU000004','Q000004','B','CR000023','1'),
	('AQ000135','豆豆鬼参与考试0135','WU000004','Q000004','C','CR000023','1'),
	('AQ000136','豆豆鬼参与考试0136','WU000004','Q000004','A','CR000023','1'),
	('AQ000137','豆豆鬼参与考试0137','WU000004','Q000004','B','CR000023','1'),
	('AQ000138','豆豆鬼参与考试0138','WU000004','Q000004','C','CR000023','1'),
	('AQ000139','豆豆鬼参与考试0139','WU000004','Q000004','A','CR000024','1'),
	('AQ000140','豆豆鬼参与考试0140','WU000004','Q000004','B','CR000024','1'),
	('AQ000141','豆豆鬼参与考试0141','WU000004','Q000004','C','CR000024','1'),
	('AQ000142','豆豆鬼参与考试0142','WU000004','Q000004','A','CR000024','1'),
	('AQ000143','豆豆鬼参与考试0143','WU000004','Q000004','B','CR000024','1'),
	('AQ000144','豆豆鬼参与考试0144','WU000004','Q000004','C','CR000024','1'),
	('AQ000145','豆豆鬼参与考试0145','WU000005','Q000005','A','CR000025','1'),
	('AQ000146','豆豆鬼参与考试0146','WU000005','Q000005','B','CR000025','1'),
	('AQ000147','豆豆鬼参与考试0147','WU000005','Q000005','C','CR000025','1'),
	('AQ000148','豆豆鬼参与考试0148','WU000005','Q000005','A','CR000025','1'),
	('AQ000149','豆豆鬼参与考试0149','WU000005','Q000005','B','CR000025','1'),
	('AQ000150','豆豆鬼参与考试0150','WU000005','Q000005','C','CR000025','1'),
	('AQ000151','豆豆鬼参与考试0151','WU000005','Q000005','A','CR000026','1'),
	('AQ000152','豆豆鬼参与考试0152','WU000005','Q000005','B','CR000026','1'),
	('AQ000153','豆豆鬼参与考试0153','WU000005','Q000005','C','CR000026','1'),
	('AQ000154','豆豆鬼参与考试0154','WU000005','Q000005','A','CR000026','1'),
	('AQ000155','豆豆鬼参与考试0155','WU000005','Q000005','B','CR000026','1'),
	('AQ000156','豆豆鬼参与考试0156','WU000005','Q000005','C','CR000026','1'),
	('AQ000157','豆豆鬼参与考试0157','WU000005','Q000005','A','CR000027','1'),
	('AQ000158','豆豆鬼参与考试0158','WU000005','Q000005','B','CR000027','1'),
	('AQ000159','豆豆鬼参与考试0159','WU000005','Q000005','C','CR000027','1'),
	('AQ000160','豆豆鬼参与考试0160','WU000005','Q000005','A','CR000027','1'),
	('AQ000161','豆豆鬼参与考试0161','WU000005','Q000005','B','CR000027','1'),
	('AQ000162','豆豆鬼参与考试0162','WU000005','Q000005','C','CR000027','1'),
	('AQ000163','豆豆鬼参与考试0163','WU000005','Q000005','A','CR000028','1'),
	('AQ000164','豆豆鬼参与考试0164','WU000005','Q000005','B','CR000028','1'),
	('AQ000165','豆豆鬼参与考试0165','WU000005','Q000005','C','CR000028','1'),
	('AQ000166','豆豆鬼参与考试0166','WU000005','Q000005','A','CR000028','1'),
	('AQ000167','豆豆鬼参与考试0167','WU000005','Q000005','B','CR000028','1'),
	('AQ000168','豆豆鬼参与考试0168','WU000005','Q000005','C','CR000028','1'),
	('AQ000169','豆豆鬼参与考试0169','WU000005','Q000005','A','CR000029','1'),
	('AQ000170','豆豆鬼参与考试0170','WU000005','Q000005','B','CR000029','1'),
	('AQ000171','豆豆鬼参与考试0171','WU000005','Q000005','C','CR000029','1'),
	('AQ000172','豆豆鬼参与考试0172','WU000005','Q000005','A','CR000029','1'),
	('AQ000173','豆豆鬼参与考试0173','WU000005','Q000005','B','CR000029','1'),
	('AQ000174','豆豆鬼参与考试0174','WU000005','Q000005','C','CR000029','1'),
	('AQ000175','豆豆鬼参与考试0175','WU000005','Q000005','A','CR000030','1'),
	('AQ000176','豆豆鬼参与考试0176','WU000005','Q000005','B','CR000030','1'),
	('AQ000177','豆豆鬼参与考试0177','WU000005','Q000005','C','CR000030','1'),
	('AQ000178','豆豆鬼参与考试0178','WU000005','Q000005','A','CR000030','1'),
	('AQ000179','豆豆鬼参与考试0179','WU000005','Q000005','B','CR000030','1'),
	('AQ000180','豆豆鬼参与考试0180','WU000005','Q000005','C','CR000030','1'),
	('AQ000181','豆豆鬼参与考试0181','WU000006','Q000006','A','CR000031','1'),
	('AQ000182','豆豆鬼参与考试0182','WU000006','Q000006','B','CR000031','1'),
	('AQ000183','豆豆鬼参与考试0183','WU000006','Q000006','C','CR000031','1'),
	('AQ000184','豆豆鬼参与考试0184','WU000006','Q000006','A','CR000031','1'),
	('AQ000185','豆豆鬼参与考试0185','WU000006','Q000006','B','CR000031','1'),
	('AQ000186','豆豆鬼参与考试0186','WU000006','Q000006','C','CR000031','1'),
	('AQ000187','豆豆鬼参与考试0187','WU000006','Q000006','A','CR000032','1'),
	('AQ000188','豆豆鬼参与考试0188','WU000006','Q000006','B','CR000032','1'),
	('AQ000189','豆豆鬼参与考试0189','WU000006','Q000006','C','CR000032','1'),
	('AQ000190','豆豆鬼参与考试0190','WU000006','Q000006','A','CR000032','1'),
	('AQ000191','豆豆鬼参与考试0191','WU000006','Q000006','B','CR000032','1'),
	('AQ000192','豆豆鬼参与考试0192','WU000006','Q000006','C','CR000032','1'),
	('AQ000193','豆豆鬼参与考试0193','WU000006','Q000006','A','CR000033','1'),
	('AQ000194','豆豆鬼参与考试0194','WU000006','Q000006','B','CR000033','1'),
	('AQ000195','豆豆鬼参与考试0195','WU000006','Q000006','C','CR000033','1'),
	('AQ000196','豆豆鬼参与考试0196','WU000006','Q000006','A','CR000033','1'),
	('AQ000197','豆豆鬼参与考试0197','WU000006','Q000006','B','CR000033','1'),
	('AQ000198','豆豆鬼参与考试0198','WU000006','Q000006','C','CR000033','1'),
	('AQ000199','豆豆鬼参与考试0199','WU000006','Q000006','A','CR000034','1'),
	('AQ000200','豆豆鬼参与考试0200','WU000006','Q000006','B','CR000034','1'),
	('AQ000201','豆豆鬼参与考试0201','WU000006','Q000006','C','CR000034','1'),
	('AQ000202','豆豆鬼参与考试0202','WU000006','Q000006','A','CR000034','1'),
	('AQ000203','豆豆鬼参与考试0203','WU000006','Q000006','B','CR000034','1'),
	('AQ000204','豆豆鬼参与考试0204','WU000006','Q000006','C','CR000034','1'),
	('AQ000205','豆豆鬼参与考试0205','WU000006','Q000006','A','CR000035','1'),
	('AQ000206','豆豆鬼参与考试0206','WU000006','Q000006','B','CR000035','1'),
	('AQ000207','豆豆鬼参与考试0207','WU000006','Q000006','C','CR000035','1'),
	('AQ000208','豆豆鬼参与考试0208','WU000006','Q000006','A','CR000035','1'),
	('AQ000209','豆豆鬼参与考试0209','WU000006','Q000006','B','CR000035','1'),
	('AQ000210','豆豆鬼参与考试0210','WU000006','Q000006','C','CR000035','1'),
	('AQ000211','豆豆鬼参与考试0211','WU000006','Q000006','A','CR000036','1'),
	('AQ000212','豆豆鬼参与考试0212','WU000006','Q000006','B','CR000036','1'),
	('AQ000213','豆豆鬼参与考试0213','WU000006','Q000006','C','CR000036','1'),
	('AQ000214','豆豆鬼参与考试0214','WU000006','Q000006','A','CR000036','1'),
	('AQ000215','豆豆鬼参与考试0215','WU000006','Q000006','B','CR000036','1'),
	('AQ000216','豆豆鬼参与考试0216','WU000006','Q000006','C','CR000036','1');

insert into exam_status_data values
	('STARTED','考试中','STARTED','P000001','1'),
	('COMPLETED','考试完成','COMPLETED','P000001','1');

insert into question_data values
	('Q000001','区块链是什么技术，下面最接近的回答是什么','低','网络技术','电子技术','机械技术','太空技术','建筑技术','A','P000001','1'),
	('Q000002','区块链是什么技术，下面最接近的回答是什么0002','中','网络技术0002','电子技术0002','机械技术0002','太空技术0002','建筑技术0002','B','P000001','1'),
	('Q000003','区块链是什么技术，下面最接近的回答是什么0003','高','网络技术0003','电子技术0003','机械技术0003','太空技术0003','建筑技术0003','C','P000001','1'),
	('Q000004','区块链是什么技术，下面最接近的回答是什么0004','低','网络技术0004','电子技术0004','机械技术0004','太空技术0004','建筑技术0004','D','P000001','1'),
	('Q000005','区块链是什么技术，下面最接近的回答是什么0005','中','网络技术0005','电子技术0005','机械技术0005','太空技术0005','建筑技术0005','E','P000001','1'),
	('Q000006','区块链是什么技术，下面最接近的回答是什么0006','高','网络技术0006','电子技术0006','机械技术0006','太空技术0006','建筑技术0006','A','P000001','1');

insert into exam_ranking_data values
	('ER000001','张喜来**','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','P000001','1'),
	('ER000002','张喜来**0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','P000001','1'),
	('ER000003','张喜来**0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','P000001','1'),
	('ER000004','张喜来**0004','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','P000001','1'),
	('ER000005','张喜来**0005','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','P000001','1'),
	('ER000006','张喜来**0006','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','P000001','1');

insert into answer_data values
	('A000001','网络技术','区块链是基于现有互联网的技术','Q000001','1'),
	('A000002','网络技术0002','区块链是基于现有互联网的技术0002','Q000001','1'),
	('A000003','网络技术0003','区块链是基于现有互联网的技术0003','Q000001','1'),
	('A000004','网络技术0004','区块链是基于现有互联网的技术0004','Q000001','1'),
	('A000005','网络技术0005','区块链是基于现有互联网的技术0005','Q000001','1'),
	('A000006','网络技术0006','区块链是基于现有互联网的技术0006','Q000001','1'),
	('A000007','网络技术0007','区块链是基于现有互联网的技术0007','Q000002','1'),
	('A000008','网络技术0008','区块链是基于现有互联网的技术0008','Q000002','1'),
	('A000009','网络技术0009','区块链是基于现有互联网的技术0009','Q000002','1'),
	('A000010','网络技术0010','区块链是基于现有互联网的技术0010','Q000002','1'),
	('A000011','网络技术0011','区块链是基于现有互联网的技术0011','Q000002','1'),
	('A000012','网络技术0012','区块链是基于现有互联网的技术0012','Q000002','1'),
	('A000013','网络技术0013','区块链是基于现有互联网的技术0013','Q000003','1'),
	('A000014','网络技术0014','区块链是基于现有互联网的技术0014','Q000003','1'),
	('A000015','网络技术0015','区块链是基于现有互联网的技术0015','Q000003','1'),
	('A000016','网络技术0016','区块链是基于现有互联网的技术0016','Q000003','1'),
	('A000017','网络技术0017','区块链是基于现有互联网的技术0017','Q000003','1'),
	('A000018','网络技术0018','区块链是基于现有互联网的技术0018','Q000003','1'),
	('A000019','网络技术0019','区块链是基于现有互联网的技术0019','Q000004','1'),
	('A000020','网络技术0020','区块链是基于现有互联网的技术0020','Q000004','1'),
	('A000021','网络技术0021','区块链是基于现有互联网的技术0021','Q000004','1'),
	('A000022','网络技术0022','区块链是基于现有互联网的技术0022','Q000004','1'),
	('A000023','网络技术0023','区块链是基于现有互联网的技术0023','Q000004','1'),
	('A000024','网络技术0024','区块链是基于现有互联网的技术0024','Q000004','1'),
	('A000025','网络技术0025','区块链是基于现有互联网的技术0025','Q000005','1'),
	('A000026','网络技术0026','区块链是基于现有互联网的技术0026','Q000005','1'),
	('A000027','网络技术0027','区块链是基于现有互联网的技术0027','Q000005','1'),
	('A000028','网络技术0028','区块链是基于现有互联网的技术0028','Q000005','1'),
	('A000029','网络技术0029','区块链是基于现有互联网的技术0029','Q000005','1'),
	('A000030','网络技术0030','区块链是基于现有互联网的技术0030','Q000005','1'),
	('A000031','网络技术0031','区块链是基于现有互联网的技术0031','Q000006','1'),
	('A000032','网络技术0032','区块链是基于现有互联网的技术0032','Q000006','1'),
	('A000033','网络技术0033','区块链是基于现有互联网的技术0033','Q000006','1'),
	('A000034','网络技术0034','区块链是基于现有互联网的技术0034','Q000006','1'),
	('A000035','网络技术0035','区块链是基于现有互联网的技术0035','Q000006','1'),
	('A000036','网络技术0036','区块链是基于现有互联网的技术0036','Q000006','1');

insert into wechat_user_data values
	('WU000001','张三','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','2019-11-02 02:45:39','P000001','1'),
	('WU000002','李四','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','2019-10-24 11:08:28','P000001','1'),
	('WU000003','王五','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','2019-11-02 17:23:23','P000001','1'),
	('WU000004','张三','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','2019-10-19 19:47:39','P000001','1'),
	('WU000005','李四','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','2019-10-26 01:26:16','P000001','1'),
	('WU000006','王五','https://demo.doublechaintech.com/demodata/imageManager/genImage/wechat00/400/200/grey/','2019-10-31 13:10:31','P000001','1');

insert into wechat_login_info_data values
	('WLI000001','WU000001','user123','user123','session123','2019-10-23 20:35:35','1'),
	('WLI000002','WU000001','user1230002','user1230002','session1230002','2019-10-31 06:23:56','1'),
	('WLI000003','WU000001','user1230003','user1230003','session1230003','2019-10-27 02:09:08','1'),
	('WLI000004','WU000001','user1230004','user1230004','session1230004','2019-10-30 04:51:46','1'),
	('WLI000005','WU000001','user1230005','user1230005','session1230005','2019-10-25 18:02:04','1'),
	('WLI000006','WU000001','user1230006','user1230006','session1230006','2019-10-18 13:12:58','1'),
	('WLI000007','WU000002','user1230007','user1230007','session1230007','2019-11-07 18:45:55','1'),
	('WLI000008','WU000002','user1230008','user1230008','session1230008','2019-10-31 11:18:59','1'),
	('WLI000009','WU000002','user1230009','user1230009','session1230009','2019-10-26 09:25:41','1'),
	('WLI000010','WU000002','user1230010','user1230010','session1230010','2019-10-19 16:49:28','1'),
	('WLI000011','WU000002','user1230011','user1230011','session1230011','2019-10-19 18:19:24','1'),
	('WLI000012','WU000002','user1230012','user1230012','session1230012','2019-11-03 12:17:15','1'),
	('WLI000013','WU000003','user1230013','user1230013','session1230013','2019-10-29 03:38:22','1'),
	('WLI000014','WU000003','user1230014','user1230014','session1230014','2019-11-04 20:44:40','1'),
	('WLI000015','WU000003','user1230015','user1230015','session1230015','2019-11-04 22:01:39','1'),
	('WLI000016','WU000003','user1230016','user1230016','session1230016','2019-10-26 14:18:54','1'),
	('WLI000017','WU000003','user1230017','user1230017','session1230017','2019-10-30 18:09:37','1'),
	('WLI000018','WU000003','user1230018','user1230018','session1230018','2019-11-03 21:04:30','1'),
	('WLI000019','WU000004','user1230019','user1230019','session1230019','2019-10-28 03:08:06','1'),
	('WLI000020','WU000004','user1230020','user1230020','session1230020','2019-10-22 14:15:13','1'),
	('WLI000021','WU000004','user1230021','user1230021','session1230021','2019-11-01 19:59:23','1'),
	('WLI000022','WU000004','user1230022','user1230022','session1230022','2019-10-29 18:12:48','1'),
	('WLI000023','WU000004','user1230023','user1230023','session1230023','2019-10-18 01:50:23','1'),
	('WLI000024','WU000004','user1230024','user1230024','session1230024','2019-11-06 22:53:09','1'),
	('WLI000025','WU000005','user1230025','user1230025','session1230025','2019-11-02 06:03:55','1'),
	('WLI000026','WU000005','user1230026','user1230026','session1230026','2019-10-18 04:34:53','1'),
	('WLI000027','WU000005','user1230027','user1230027','session1230027','2019-11-02 09:13:48','1'),
	('WLI000028','WU000005','user1230028','user1230028','session1230028','2019-10-23 21:27:30','1'),
	('WLI000029','WU000005','user1230029','user1230029','session1230029','2019-11-03 06:51:21','1'),
	('WLI000030','WU000005','user1230030','user1230030','session1230030','2019-11-04 08:19:19','1'),
	('WLI000031','WU000006','user1230031','user1230031','session1230031','2019-10-18 00:17:45','1'),
	('WLI000032','WU000006','user1230032','user1230032','session1230032','2019-10-27 09:44:23','1'),
	('WLI000033','WU000006','user1230033','user1230033','session1230033','2019-11-07 04:00:22','1'),
	('WLI000034','WU000006','user1230034','user1230034','session1230034','2019-10-31 21:47:55','1'),
	('WLI000035','WU000006','user1230035','user1230035','session1230035','2019-10-20 17:15:44','1'),
	('WLI000036','WU000006','user1230036','user1230036','session1230036','2019-11-02 00:22:37','1');

insert into exam_data values
	('E000001','区块链技术考试','2019-10-17 03:38:49','STARTED','WU000001','97','1'),
	('E000002','区块链技术考试0002','2019-10-24 03:14:49','STARTED','WU000001','79','1'),
	('E000003','区块链技术考试0003','2019-10-31 23:31:02','STARTED','WU000001','73','1'),
	('E000004','区块链技术考试0004','2019-10-20 19:11:40','STARTED','WU000001','94','1'),
	('E000005','区块链技术考试0005','2019-10-22 12:48:23','STARTED','WU000001','93','1'),
	('E000006','区块链技术考试0006','2019-10-24 11:24:45','STARTED','WU000001','80','1'),
	('E000007','区块链技术考试0007','2019-10-22 23:01:14','STARTED','WU000002','92','1'),
	('E000008','区块链技术考试0008','2019-10-19 12:50:25','STARTED','WU000002','79','1'),
	('E000009','区块链技术考试0009','2019-10-17 18:58:49','STARTED','WU000002','82','1'),
	('E000010','区块链技术考试0010','2019-10-18 13:35:57','STARTED','WU000002','74','1'),
	('E000011','区块链技术考试0011','2019-10-27 19:42:13','STARTED','WU000002','83','1'),
	('E000012','区块链技术考试0012','2019-10-24 08:37:56','STARTED','WU000002','93','1'),
	('E000013','区块链技术考试0013','2019-11-07 13:23:13','STARTED','WU000003','75','1'),
	('E000014','区块链技术考试0014','2019-10-25 09:30:39','STARTED','WU000003','80','1'),
	('E000015','区块链技术考试0015','2019-10-24 00:35:08','STARTED','WU000003','88','1'),
	('E000016','区块链技术考试0016','2019-11-02 04:59:28','STARTED','WU000003','92','1'),
	('E000017','区块链技术考试0017','2019-11-02 23:24:42','STARTED','WU000003','88','1'),
	('E000018','区块链技术考试0018','2019-11-02 10:37:25','STARTED','WU000003','87','1'),
	('E000019','区块链技术考试0019','2019-10-23 03:18:01','COMPLETED','WU000004','91','1'),
	('E000020','区块链技术考试0020','2019-10-30 03:16:36','COMPLETED','WU000004','97','1'),
	('E000021','区块链技术考试0021','2019-11-02 05:15:43','COMPLETED','WU000004','94','1'),
	('E000022','区块链技术考试0022','2019-10-19 11:48:18','COMPLETED','WU000004','90','1'),
	('E000023','区块链技术考试0023','2019-10-31 23:43:38','COMPLETED','WU000004','99','1'),
	('E000024','区块链技术考试0024','2019-10-27 12:41:47','COMPLETED','WU000004','75','1'),
	('E000025','区块链技术考试0025','2019-10-30 11:18:10','COMPLETED','WU000005','74','1'),
	('E000026','区块链技术考试0026','2019-11-06 00:09:28','COMPLETED','WU000005','78','1'),
	('E000027','区块链技术考试0027','2019-10-24 04:35:33','COMPLETED','WU000005','83','1'),
	('E000028','区块链技术考试0028','2019-10-26 23:45:04','COMPLETED','WU000005','92','1'),
	('E000029','区块链技术考试0029','2019-10-20 06:18:28','COMPLETED','WU000005','78','1'),
	('E000030','区块链技术考试0030','2019-10-29 21:21:44','COMPLETED','WU000005','84','1'),
	('E000031','区块链技术考试0031','2019-10-28 04:58:24','COMPLETED','WU000006','87','1'),
	('E000032','区块链技术考试0032','2019-10-17 09:47:42','COMPLETED','WU000006','80','1'),
	('E000033','区块链技术考试0033','2019-10-29 07:02:58','COMPLETED','WU000006','81','1'),
	('E000034','区块链技术考试0034','2019-10-18 11:11:54','COMPLETED','WU000006','78','1'),
	('E000035','区块链技术考试0035','2019-10-27 11:37:58','COMPLETED','WU000006','82','1'),
	('E000036','区块链技术考试0036','2019-10-24 15:41:27','COMPLETED','WU000006','73','1');

insert into user_answer_data values
	('UA000001','区块链是什么技术，下面最接近的回答是什么','A','Q000001','E000001','1'),
	('UA000002','区块链是什么技术，下面最接近的回答是什么0002','A000','Q000001','E000001','1'),
	('UA000003','区块链是什么技术，下面最接近的回答是什么0003','A000','Q000001','E000001','1'),
	('UA000004','区块链是什么技术，下面最接近的回答是什么0004','A000','Q000001','E000001','1'),
	('UA000005','区块链是什么技术，下面最接近的回答是什么0005','A000','Q000001','E000001','1'),
	('UA000006','区块链是什么技术，下面最接近的回答是什么0006','A000','Q000001','E000001','1'),
	('UA000007','区块链是什么技术，下面最接近的回答是什么0007','A000','Q000001','E000002','1'),
	('UA000008','区块链是什么技术，下面最接近的回答是什么0008','A000','Q000001','E000002','1'),
	('UA000009','区块链是什么技术，下面最接近的回答是什么0009','A000','Q000001','E000002','1'),
	('UA000010','区块链是什么技术，下面最接近的回答是什么0010','A001','Q000001','E000002','1'),
	('UA000011','区块链是什么技术，下面最接近的回答是什么0011','A001','Q000001','E000002','1'),
	('UA000012','区块链是什么技术，下面最接近的回答是什么0012','A001','Q000001','E000002','1'),
	('UA000013','区块链是什么技术，下面最接近的回答是什么0013','A001','Q000001','E000003','1'),
	('UA000014','区块链是什么技术，下面最接近的回答是什么0014','A001','Q000001','E000003','1'),
	('UA000015','区块链是什么技术，下面最接近的回答是什么0015','A001','Q000001','E000003','1'),
	('UA000016','区块链是什么技术，下面最接近的回答是什么0016','A001','Q000001','E000003','1'),
	('UA000017','区块链是什么技术，下面最接近的回答是什么0017','A001','Q000001','E000003','1'),
	('UA000018','区块链是什么技术，下面最接近的回答是什么0018','A001','Q000001','E000003','1'),
	('UA000019','区块链是什么技术，下面最接近的回答是什么0019','A001','Q000001','E000004','1'),
	('UA000020','区块链是什么技术，下面最接近的回答是什么0020','A002','Q000001','E000004','1'),
	('UA000021','区块链是什么技术，下面最接近的回答是什么0021','A002','Q000001','E000004','1'),
	('UA000022','区块链是什么技术，下面最接近的回答是什么0022','A002','Q000001','E000004','1'),
	('UA000023','区块链是什么技术，下面最接近的回答是什么0023','A002','Q000001','E000004','1'),
	('UA000024','区块链是什么技术，下面最接近的回答是什么0024','A002','Q000001','E000004','1'),
	('UA000025','区块链是什么技术，下面最接近的回答是什么0025','A002','Q000001','E000005','1'),
	('UA000026','区块链是什么技术，下面最接近的回答是什么0026','A002','Q000001','E000005','1'),
	('UA000027','区块链是什么技术，下面最接近的回答是什么0027','A002','Q000001','E000005','1'),
	('UA000028','区块链是什么技术，下面最接近的回答是什么0028','A002','Q000001','E000005','1'),
	('UA000029','区块链是什么技术，下面最接近的回答是什么0029','A002','Q000001','E000005','1'),
	('UA000030','区块链是什么技术，下面最接近的回答是什么0030','A003','Q000001','E000005','1'),
	('UA000031','区块链是什么技术，下面最接近的回答是什么0031','A003','Q000001','E000006','1'),
	('UA000032','区块链是什么技术，下面最接近的回答是什么0032','A003','Q000001','E000006','1'),
	('UA000033','区块链是什么技术，下面最接近的回答是什么0033','A003','Q000001','E000006','1'),
	('UA000034','区块链是什么技术，下面最接近的回答是什么0034','A003','Q000001','E000006','1'),
	('UA000035','区块链是什么技术，下面最接近的回答是什么0035','A003','Q000001','E000006','1'),
	('UA000036','区块链是什么技术，下面最接近的回答是什么0036','A003','Q000001','E000006','1'),
	('UA000037','区块链是什么技术，下面最接近的回答是什么0037','A003','Q000002','E000007','1'),
	('UA000038','区块链是什么技术，下面最接近的回答是什么0038','A003','Q000002','E000007','1'),
	('UA000039','区块链是什么技术，下面最接近的回答是什么0039','A003','Q000002','E000007','1'),
	('UA000040','区块链是什么技术，下面最接近的回答是什么0040','A004','Q000002','E000007','1'),
	('UA000041','区块链是什么技术，下面最接近的回答是什么0041','A004','Q000002','E000007','1'),
	('UA000042','区块链是什么技术，下面最接近的回答是什么0042','A004','Q000002','E000007','1'),
	('UA000043','区块链是什么技术，下面最接近的回答是什么0043','A004','Q000002','E000008','1'),
	('UA000044','区块链是什么技术，下面最接近的回答是什么0044','A004','Q000002','E000008','1'),
	('UA000045','区块链是什么技术，下面最接近的回答是什么0045','A004','Q000002','E000008','1'),
	('UA000046','区块链是什么技术，下面最接近的回答是什么0046','A004','Q000002','E000008','1'),
	('UA000047','区块链是什么技术，下面最接近的回答是什么0047','A004','Q000002','E000008','1'),
	('UA000048','区块链是什么技术，下面最接近的回答是什么0048','A004','Q000002','E000008','1'),
	('UA000049','区块链是什么技术，下面最接近的回答是什么0049','A004','Q000002','E000009','1'),
	('UA000050','区块链是什么技术，下面最接近的回答是什么0050','A005','Q000002','E000009','1'),
	('UA000051','区块链是什么技术，下面最接近的回答是什么0051','A005','Q000002','E000009','1'),
	('UA000052','区块链是什么技术，下面最接近的回答是什么0052','A005','Q000002','E000009','1'),
	('UA000053','区块链是什么技术，下面最接近的回答是什么0053','A005','Q000002','E000009','1'),
	('UA000054','区块链是什么技术，下面最接近的回答是什么0054','A005','Q000002','E000009','1'),
	('UA000055','区块链是什么技术，下面最接近的回答是什么0055','A005','Q000002','E000010','1'),
	('UA000056','区块链是什么技术，下面最接近的回答是什么0056','A005','Q000002','E000010','1'),
	('UA000057','区块链是什么技术，下面最接近的回答是什么0057','A005','Q000002','E000010','1'),
	('UA000058','区块链是什么技术，下面最接近的回答是什么0058','A005','Q000002','E000010','1'),
	('UA000059','区块链是什么技术，下面最接近的回答是什么0059','A005','Q000002','E000010','1'),
	('UA000060','区块链是什么技术，下面最接近的回答是什么0060','A006','Q000002','E000010','1'),
	('UA000061','区块链是什么技术，下面最接近的回答是什么0061','A006','Q000002','E000011','1'),
	('UA000062','区块链是什么技术，下面最接近的回答是什么0062','A006','Q000002','E000011','1'),
	('UA000063','区块链是什么技术，下面最接近的回答是什么0063','A006','Q000002','E000011','1'),
	('UA000064','区块链是什么技术，下面最接近的回答是什么0064','A006','Q000002','E000011','1'),
	('UA000065','区块链是什么技术，下面最接近的回答是什么0065','A006','Q000002','E000011','1'),
	('UA000066','区块链是什么技术，下面最接近的回答是什么0066','A006','Q000002','E000011','1'),
	('UA000067','区块链是什么技术，下面最接近的回答是什么0067','A006','Q000002','E000012','1'),
	('UA000068','区块链是什么技术，下面最接近的回答是什么0068','A006','Q000002','E000012','1'),
	('UA000069','区块链是什么技术，下面最接近的回答是什么0069','A006','Q000002','E000012','1'),
	('UA000070','区块链是什么技术，下面最接近的回答是什么0070','A007','Q000002','E000012','1'),
	('UA000071','区块链是什么技术，下面最接近的回答是什么0071','A007','Q000002','E000012','1'),
	('UA000072','区块链是什么技术，下面最接近的回答是什么0072','A007','Q000002','E000012','1'),
	('UA000073','区块链是什么技术，下面最接近的回答是什么0073','A007','Q000003','E000013','1'),
	('UA000074','区块链是什么技术，下面最接近的回答是什么0074','A007','Q000003','E000013','1'),
	('UA000075','区块链是什么技术，下面最接近的回答是什么0075','A007','Q000003','E000013','1'),
	('UA000076','区块链是什么技术，下面最接近的回答是什么0076','A007','Q000003','E000013','1'),
	('UA000077','区块链是什么技术，下面最接近的回答是什么0077','A007','Q000003','E000013','1'),
	('UA000078','区块链是什么技术，下面最接近的回答是什么0078','A007','Q000003','E000013','1'),
	('UA000079','区块链是什么技术，下面最接近的回答是什么0079','A007','Q000003','E000014','1'),
	('UA000080','区块链是什么技术，下面最接近的回答是什么0080','A008','Q000003','E000014','1'),
	('UA000081','区块链是什么技术，下面最接近的回答是什么0081','A008','Q000003','E000014','1'),
	('UA000082','区块链是什么技术，下面最接近的回答是什么0082','A008','Q000003','E000014','1'),
	('UA000083','区块链是什么技术，下面最接近的回答是什么0083','A008','Q000003','E000014','1'),
	('UA000084','区块链是什么技术，下面最接近的回答是什么0084','A008','Q000003','E000014','1'),
	('UA000085','区块链是什么技术，下面最接近的回答是什么0085','A008','Q000003','E000015','1'),
	('UA000086','区块链是什么技术，下面最接近的回答是什么0086','A008','Q000003','E000015','1'),
	('UA000087','区块链是什么技术，下面最接近的回答是什么0087','A008','Q000003','E000015','1'),
	('UA000088','区块链是什么技术，下面最接近的回答是什么0088','A008','Q000003','E000015','1'),
	('UA000089','区块链是什么技术，下面最接近的回答是什么0089','A008','Q000003','E000015','1'),
	('UA000090','区块链是什么技术，下面最接近的回答是什么0090','A009','Q000003','E000015','1'),
	('UA000091','区块链是什么技术，下面最接近的回答是什么0091','A009','Q000003','E000016','1'),
	('UA000092','区块链是什么技术，下面最接近的回答是什么0092','A009','Q000003','E000016','1'),
	('UA000093','区块链是什么技术，下面最接近的回答是什么0093','A009','Q000003','E000016','1'),
	('UA000094','区块链是什么技术，下面最接近的回答是什么0094','A009','Q000003','E000016','1'),
	('UA000095','区块链是什么技术，下面最接近的回答是什么0095','A009','Q000003','E000016','1'),
	('UA000096','区块链是什么技术，下面最接近的回答是什么0096','A009','Q000003','E000016','1'),
	('UA000097','区块链是什么技术，下面最接近的回答是什么0097','A009','Q000003','E000017','1'),
	('UA000098','区块链是什么技术，下面最接近的回答是什么0098','A009','Q000003','E000017','1'),
	('UA000099','区块链是什么技术，下面最接近的回答是什么0099','A009','Q000003','E000017','1'),
	('UA000100','区块链是什么技术，下面最接近的回答是什么0100','A010','Q000003','E000017','1'),
	('UA000101','区块链是什么技术，下面最接近的回答是什么0101','A010','Q000003','E000017','1'),
	('UA000102','区块链是什么技术，下面最接近的回答是什么0102','A010','Q000003','E000017','1'),
	('UA000103','区块链是什么技术，下面最接近的回答是什么0103','A010','Q000003','E000018','1'),
	('UA000104','区块链是什么技术，下面最接近的回答是什么0104','A010','Q000003','E000018','1'),
	('UA000105','区块链是什么技术，下面最接近的回答是什么0105','A010','Q000003','E000018','1'),
	('UA000106','区块链是什么技术，下面最接近的回答是什么0106','A010','Q000003','E000018','1'),
	('UA000107','区块链是什么技术，下面最接近的回答是什么0107','A010','Q000003','E000018','1'),
	('UA000108','区块链是什么技术，下面最接近的回答是什么0108','A010','Q000003','E000018','1'),
	('UA000109','区块链是什么技术，下面最接近的回答是什么0109','A010','Q000004','E000019','1'),
	('UA000110','区块链是什么技术，下面最接近的回答是什么0110','A011','Q000004','E000019','1'),
	('UA000111','区块链是什么技术，下面最接近的回答是什么0111','A011','Q000004','E000019','1'),
	('UA000112','区块链是什么技术，下面最接近的回答是什么0112','A011','Q000004','E000019','1'),
	('UA000113','区块链是什么技术，下面最接近的回答是什么0113','A011','Q000004','E000019','1'),
	('UA000114','区块链是什么技术，下面最接近的回答是什么0114','A011','Q000004','E000019','1'),
	('UA000115','区块链是什么技术，下面最接近的回答是什么0115','A011','Q000004','E000020','1'),
	('UA000116','区块链是什么技术，下面最接近的回答是什么0116','A011','Q000004','E000020','1'),
	('UA000117','区块链是什么技术，下面最接近的回答是什么0117','A011','Q000004','E000020','1'),
	('UA000118','区块链是什么技术，下面最接近的回答是什么0118','A011','Q000004','E000020','1'),
	('UA000119','区块链是什么技术，下面最接近的回答是什么0119','A011','Q000004','E000020','1'),
	('UA000120','区块链是什么技术，下面最接近的回答是什么0120','A012','Q000004','E000020','1'),
	('UA000121','区块链是什么技术，下面最接近的回答是什么0121','A012','Q000004','E000021','1'),
	('UA000122','区块链是什么技术，下面最接近的回答是什么0122','A012','Q000004','E000021','1'),
	('UA000123','区块链是什么技术，下面最接近的回答是什么0123','A012','Q000004','E000021','1'),
	('UA000124','区块链是什么技术，下面最接近的回答是什么0124','A012','Q000004','E000021','1'),
	('UA000125','区块链是什么技术，下面最接近的回答是什么0125','A012','Q000004','E000021','1'),
	('UA000126','区块链是什么技术，下面最接近的回答是什么0126','A012','Q000004','E000021','1'),
	('UA000127','区块链是什么技术，下面最接近的回答是什么0127','A012','Q000004','E000022','1'),
	('UA000128','区块链是什么技术，下面最接近的回答是什么0128','A012','Q000004','E000022','1'),
	('UA000129','区块链是什么技术，下面最接近的回答是什么0129','A012','Q000004','E000022','1'),
	('UA000130','区块链是什么技术，下面最接近的回答是什么0130','A013','Q000004','E000022','1'),
	('UA000131','区块链是什么技术，下面最接近的回答是什么0131','A013','Q000004','E000022','1'),
	('UA000132','区块链是什么技术，下面最接近的回答是什么0132','A013','Q000004','E000022','1'),
	('UA000133','区块链是什么技术，下面最接近的回答是什么0133','A013','Q000004','E000023','1'),
	('UA000134','区块链是什么技术，下面最接近的回答是什么0134','A013','Q000004','E000023','1'),
	('UA000135','区块链是什么技术，下面最接近的回答是什么0135','A013','Q000004','E000023','1'),
	('UA000136','区块链是什么技术，下面最接近的回答是什么0136','A013','Q000004','E000023','1'),
	('UA000137','区块链是什么技术，下面最接近的回答是什么0137','A013','Q000004','E000023','1'),
	('UA000138','区块链是什么技术，下面最接近的回答是什么0138','A013','Q000004','E000023','1'),
	('UA000139','区块链是什么技术，下面最接近的回答是什么0139','A013','Q000004','E000024','1'),
	('UA000140','区块链是什么技术，下面最接近的回答是什么0140','A014','Q000004','E000024','1'),
	('UA000141','区块链是什么技术，下面最接近的回答是什么0141','A014','Q000004','E000024','1'),
	('UA000142','区块链是什么技术，下面最接近的回答是什么0142','A014','Q000004','E000024','1'),
	('UA000143','区块链是什么技术，下面最接近的回答是什么0143','A014','Q000004','E000024','1'),
	('UA000144','区块链是什么技术，下面最接近的回答是什么0144','A014','Q000004','E000024','1'),
	('UA000145','区块链是什么技术，下面最接近的回答是什么0145','A014','Q000005','E000025','1'),
	('UA000146','区块链是什么技术，下面最接近的回答是什么0146','A014','Q000005','E000025','1'),
	('UA000147','区块链是什么技术，下面最接近的回答是什么0147','A014','Q000005','E000025','1'),
	('UA000148','区块链是什么技术，下面最接近的回答是什么0148','A014','Q000005','E000025','1'),
	('UA000149','区块链是什么技术，下面最接近的回答是什么0149','A014','Q000005','E000025','1'),
	('UA000150','区块链是什么技术，下面最接近的回答是什么0150','A015','Q000005','E000025','1'),
	('UA000151','区块链是什么技术，下面最接近的回答是什么0151','A015','Q000005','E000026','1'),
	('UA000152','区块链是什么技术，下面最接近的回答是什么0152','A015','Q000005','E000026','1'),
	('UA000153','区块链是什么技术，下面最接近的回答是什么0153','A015','Q000005','E000026','1'),
	('UA000154','区块链是什么技术，下面最接近的回答是什么0154','A015','Q000005','E000026','1'),
	('UA000155','区块链是什么技术，下面最接近的回答是什么0155','A015','Q000005','E000026','1'),
	('UA000156','区块链是什么技术，下面最接近的回答是什么0156','A015','Q000005','E000026','1'),
	('UA000157','区块链是什么技术，下面最接近的回答是什么0157','A015','Q000005','E000027','1'),
	('UA000158','区块链是什么技术，下面最接近的回答是什么0158','A015','Q000005','E000027','1'),
	('UA000159','区块链是什么技术，下面最接近的回答是什么0159','A015','Q000005','E000027','1'),
	('UA000160','区块链是什么技术，下面最接近的回答是什么0160','A016','Q000005','E000027','1'),
	('UA000161','区块链是什么技术，下面最接近的回答是什么0161','A016','Q000005','E000027','1'),
	('UA000162','区块链是什么技术，下面最接近的回答是什么0162','A016','Q000005','E000027','1'),
	('UA000163','区块链是什么技术，下面最接近的回答是什么0163','A016','Q000005','E000028','1'),
	('UA000164','区块链是什么技术，下面最接近的回答是什么0164','A016','Q000005','E000028','1'),
	('UA000165','区块链是什么技术，下面最接近的回答是什么0165','A016','Q000005','E000028','1'),
	('UA000166','区块链是什么技术，下面最接近的回答是什么0166','A016','Q000005','E000028','1'),
	('UA000167','区块链是什么技术，下面最接近的回答是什么0167','A016','Q000005','E000028','1'),
	('UA000168','区块链是什么技术，下面最接近的回答是什么0168','A016','Q000005','E000028','1'),
	('UA000169','区块链是什么技术，下面最接近的回答是什么0169','A016','Q000005','E000029','1'),
	('UA000170','区块链是什么技术，下面最接近的回答是什么0170','A017','Q000005','E000029','1'),
	('UA000171','区块链是什么技术，下面最接近的回答是什么0171','A017','Q000005','E000029','1'),
	('UA000172','区块链是什么技术，下面最接近的回答是什么0172','A017','Q000005','E000029','1'),
	('UA000173','区块链是什么技术，下面最接近的回答是什么0173','A017','Q000005','E000029','1'),
	('UA000174','区块链是什么技术，下面最接近的回答是什么0174','A017','Q000005','E000029','1'),
	('UA000175','区块链是什么技术，下面最接近的回答是什么0175','A017','Q000005','E000030','1'),
	('UA000176','区块链是什么技术，下面最接近的回答是什么0176','A017','Q000005','E000030','1'),
	('UA000177','区块链是什么技术，下面最接近的回答是什么0177','A017','Q000005','E000030','1'),
	('UA000178','区块链是什么技术，下面最接近的回答是什么0178','A017','Q000005','E000030','1'),
	('UA000179','区块链是什么技术，下面最接近的回答是什么0179','A017','Q000005','E000030','1'),
	('UA000180','区块链是什么技术，下面最接近的回答是什么0180','A018','Q000005','E000030','1'),
	('UA000181','区块链是什么技术，下面最接近的回答是什么0181','A018','Q000006','E000031','1'),
	('UA000182','区块链是什么技术，下面最接近的回答是什么0182','A018','Q000006','E000031','1'),
	('UA000183','区块链是什么技术，下面最接近的回答是什么0183','A018','Q000006','E000031','1'),
	('UA000184','区块链是什么技术，下面最接近的回答是什么0184','A018','Q000006','E000031','1'),
	('UA000185','区块链是什么技术，下面最接近的回答是什么0185','A018','Q000006','E000031','1'),
	('UA000186','区块链是什么技术，下面最接近的回答是什么0186','A018','Q000006','E000031','1'),
	('UA000187','区块链是什么技术，下面最接近的回答是什么0187','A018','Q000006','E000032','1'),
	('UA000188','区块链是什么技术，下面最接近的回答是什么0188','A018','Q000006','E000032','1'),
	('UA000189','区块链是什么技术，下面最接近的回答是什么0189','A018','Q000006','E000032','1'),
	('UA000190','区块链是什么技术，下面最接近的回答是什么0190','A019','Q000006','E000032','1'),
	('UA000191','区块链是什么技术，下面最接近的回答是什么0191','A019','Q000006','E000032','1'),
	('UA000192','区块链是什么技术，下面最接近的回答是什么0192','A019','Q000006','E000032','1'),
	('UA000193','区块链是什么技术，下面最接近的回答是什么0193','A019','Q000006','E000033','1'),
	('UA000194','区块链是什么技术，下面最接近的回答是什么0194','A019','Q000006','E000033','1'),
	('UA000195','区块链是什么技术，下面最接近的回答是什么0195','A019','Q000006','E000033','1'),
	('UA000196','区块链是什么技术，下面最接近的回答是什么0196','A019','Q000006','E000033','1'),
	('UA000197','区块链是什么技术，下面最接近的回答是什么0197','A019','Q000006','E000033','1'),
	('UA000198','区块链是什么技术，下面最接近的回答是什么0198','A019','Q000006','E000033','1'),
	('UA000199','区块链是什么技术，下面最接近的回答是什么0199','A019','Q000006','E000034','1'),
	('UA000200','区块链是什么技术，下面最接近的回答是什么0200','A020','Q000006','E000034','1'),
	('UA000201','区块链是什么技术，下面最接近的回答是什么0201','A020','Q000006','E000034','1'),
	('UA000202','区块链是什么技术，下面最接近的回答是什么0202','A020','Q000006','E000034','1'),
	('UA000203','区块链是什么技术，下面最接近的回答是什么0203','A020','Q000006','E000034','1'),
	('UA000204','区块链是什么技术，下面最接近的回答是什么0204','A020','Q000006','E000034','1'),
	('UA000205','区块链是什么技术，下面最接近的回答是什么0205','A020','Q000006','E000035','1'),
	('UA000206','区块链是什么技术，下面最接近的回答是什么0206','A020','Q000006','E000035','1'),
	('UA000207','区块链是什么技术，下面最接近的回答是什么0207','A020','Q000006','E000035','1'),
	('UA000208','区块链是什么技术，下面最接近的回答是什么0208','A020','Q000006','E000035','1'),
	('UA000209','区块链是什么技术，下面最接近的回答是什么0209','A020','Q000006','E000035','1'),
	('UA000210','区块链是什么技术，下面最接近的回答是什么0210','A021','Q000006','E000035','1'),
	('UA000211','区块链是什么技术，下面最接近的回答是什么0211','A021','Q000006','E000036','1'),
	('UA000212','区块链是什么技术，下面最接近的回答是什么0212','A021','Q000006','E000036','1'),
	('UA000213','区块链是什么技术，下面最接近的回答是什么0213','A021','Q000006','E000036','1'),
	('UA000214','区块链是什么技术，下面最接近的回答是什么0214','A021','Q000006','E000036','1'),
	('UA000215','区块链是什么技术，下面最接近的回答是什么0215','A021','Q000006','E000036','1'),
	('UA000216','区块链是什么技术，下面最接近的回答是什么0216','A021','Q000006','E000036','1');

insert into fault_answer_data values
	('FA000001','区块链是什么技术，下面最接近的回答是什么','网络技术','电子技术','2019-10-18 04:39:29','WU000001','E000001','1'),
	('FA000002','区块链是什么技术，下面最接近的回答是什么0002','网络技术0002','电子技术0002','2019-10-31 16:02:59','WU000001','E000001','1'),
	('FA000003','区块链是什么技术，下面最接近的回答是什么0003','网络技术0003','电子技术0003','2019-10-17 20:55:34','WU000001','E000001','1'),
	('FA000004','区块链是什么技术，下面最接近的回答是什么0004','网络技术0004','电子技术0004','2019-10-30 04:56:16','WU000001','E000001','1'),
	('FA000005','区块链是什么技术，下面最接近的回答是什么0005','网络技术0005','电子技术0005','2019-10-30 16:30:39','WU000001','E000001','1'),
	('FA000006','区块链是什么技术，下面最接近的回答是什么0006','网络技术0006','电子技术0006','2019-10-31 16:36:19','WU000001','E000001','1'),
	('FA000007','区块链是什么技术，下面最接近的回答是什么0007','网络技术0007','电子技术0007','2019-11-04 17:31:57','WU000001','E000002','1'),
	('FA000008','区块链是什么技术，下面最接近的回答是什么0008','网络技术0008','电子技术0008','2019-11-06 03:48:29','WU000001','E000002','1'),
	('FA000009','区块链是什么技术，下面最接近的回答是什么0009','网络技术0009','电子技术0009','2019-11-04 21:22:44','WU000001','E000002','1'),
	('FA000010','区块链是什么技术，下面最接近的回答是什么0010','网络技术0010','电子技术0010','2019-10-31 23:54:26','WU000001','E000002','1'),
	('FA000011','区块链是什么技术，下面最接近的回答是什么0011','网络技术0011','电子技术0011','2019-10-18 02:59:58','WU000001','E000002','1'),
	('FA000012','区块链是什么技术，下面最接近的回答是什么0012','网络技术0012','电子技术0012','2019-10-28 06:46:01','WU000001','E000002','1'),
	('FA000013','区块链是什么技术，下面最接近的回答是什么0013','网络技术0013','电子技术0013','2019-10-18 12:06:09','WU000001','E000003','1'),
	('FA000014','区块链是什么技术，下面最接近的回答是什么0014','网络技术0014','电子技术0014','2019-11-02 13:36:28','WU000001','E000003','1'),
	('FA000015','区块链是什么技术，下面最接近的回答是什么0015','网络技术0015','电子技术0015','2019-10-19 21:37:16','WU000001','E000003','1'),
	('FA000016','区块链是什么技术，下面最接近的回答是什么0016','网络技术0016','电子技术0016','2019-10-23 21:00:25','WU000001','E000003','1'),
	('FA000017','区块链是什么技术，下面最接近的回答是什么0017','网络技术0017','电子技术0017','2019-10-29 04:45:09','WU000001','E000003','1'),
	('FA000018','区块链是什么技术，下面最接近的回答是什么0018','网络技术0018','电子技术0018','2019-10-31 14:23:07','WU000001','E000003','1'),
	('FA000019','区块链是什么技术，下面最接近的回答是什么0019','网络技术0019','电子技术0019','2019-11-01 02:59:42','WU000001','E000004','1'),
	('FA000020','区块链是什么技术，下面最接近的回答是什么0020','网络技术0020','电子技术0020','2019-11-01 23:16:16','WU000001','E000004','1'),
	('FA000021','区块链是什么技术，下面最接近的回答是什么0021','网络技术0021','电子技术0021','2019-10-26 11:50:57','WU000001','E000004','1'),
	('FA000022','区块链是什么技术，下面最接近的回答是什么0022','网络技术0022','电子技术0022','2019-10-29 15:12:10','WU000001','E000004','1'),
	('FA000023','区块链是什么技术，下面最接近的回答是什么0023','网络技术0023','电子技术0023','2019-11-02 20:39:53','WU000001','E000004','1'),
	('FA000024','区块链是什么技术，下面最接近的回答是什么0024','网络技术0024','电子技术0024','2019-10-17 21:23:05','WU000001','E000004','1'),
	('FA000025','区块链是什么技术，下面最接近的回答是什么0025','网络技术0025','电子技术0025','2019-10-29 17:39:00','WU000001','E000005','1'),
	('FA000026','区块链是什么技术，下面最接近的回答是什么0026','网络技术0026','电子技术0026','2019-10-30 03:57:15','WU000001','E000005','1'),
	('FA000027','区块链是什么技术，下面最接近的回答是什么0027','网络技术0027','电子技术0027','2019-10-26 04:37:47','WU000001','E000005','1'),
	('FA000028','区块链是什么技术，下面最接近的回答是什么0028','网络技术0028','电子技术0028','2019-10-19 06:14:13','WU000001','E000005','1'),
	('FA000029','区块链是什么技术，下面最接近的回答是什么0029','网络技术0029','电子技术0029','2019-11-06 14:52:26','WU000001','E000005','1'),
	('FA000030','区块链是什么技术，下面最接近的回答是什么0030','网络技术0030','电子技术0030','2019-10-27 06:06:55','WU000001','E000005','1'),
	('FA000031','区块链是什么技术，下面最接近的回答是什么0031','网络技术0031','电子技术0031','2019-10-31 05:23:12','WU000001','E000006','1'),
	('FA000032','区块链是什么技术，下面最接近的回答是什么0032','网络技术0032','电子技术0032','2019-10-29 07:17:51','WU000001','E000006','1'),
	('FA000033','区块链是什么技术，下面最接近的回答是什么0033','网络技术0033','电子技术0033','2019-10-22 05:59:21','WU000001','E000006','1'),
	('FA000034','区块链是什么技术，下面最接近的回答是什么0034','网络技术0034','电子技术0034','2019-10-30 06:45:32','WU000001','E000006','1'),
	('FA000035','区块链是什么技术，下面最接近的回答是什么0035','网络技术0035','电子技术0035','2019-11-04 01:21:09','WU000001','E000006','1'),
	('FA000036','区块链是什么技术，下面最接近的回答是什么0036','网络技术0036','电子技术0036','2019-10-23 20:00:28','WU000001','E000006','1'),
	('FA000037','区块链是什么技术，下面最接近的回答是什么0037','网络技术0037','电子技术0037','2019-10-20 13:47:07','WU000002','E000007','1'),
	('FA000038','区块链是什么技术，下面最接近的回答是什么0038','网络技术0038','电子技术0038','2019-10-20 20:52:11','WU000002','E000007','1'),
	('FA000039','区块链是什么技术，下面最接近的回答是什么0039','网络技术0039','电子技术0039','2019-10-31 08:18:52','WU000002','E000007','1'),
	('FA000040','区块链是什么技术，下面最接近的回答是什么0040','网络技术0040','电子技术0040','2019-10-17 15:04:46','WU000002','E000007','1'),
	('FA000041','区块链是什么技术，下面最接近的回答是什么0041','网络技术0041','电子技术0041','2019-10-30 06:57:30','WU000002','E000007','1'),
	('FA000042','区块链是什么技术，下面最接近的回答是什么0042','网络技术0042','电子技术0042','2019-11-03 17:16:51','WU000002','E000007','1'),
	('FA000043','区块链是什么技术，下面最接近的回答是什么0043','网络技术0043','电子技术0043','2019-10-24 00:58:40','WU000002','E000008','1'),
	('FA000044','区块链是什么技术，下面最接近的回答是什么0044','网络技术0044','电子技术0044','2019-10-21 12:37:31','WU000002','E000008','1'),
	('FA000045','区块链是什么技术，下面最接近的回答是什么0045','网络技术0045','电子技术0045','2019-10-17 11:40:48','WU000002','E000008','1'),
	('FA000046','区块链是什么技术，下面最接近的回答是什么0046','网络技术0046','电子技术0046','2019-10-18 05:34:42','WU000002','E000008','1'),
	('FA000047','区块链是什么技术，下面最接近的回答是什么0047','网络技术0047','电子技术0047','2019-11-06 19:08:03','WU000002','E000008','1'),
	('FA000048','区块链是什么技术，下面最接近的回答是什么0048','网络技术0048','电子技术0048','2019-10-23 16:11:31','WU000002','E000008','1'),
	('FA000049','区块链是什么技术，下面最接近的回答是什么0049','网络技术0049','电子技术0049','2019-10-18 23:10:51','WU000002','E000009','1'),
	('FA000050','区块链是什么技术，下面最接近的回答是什么0050','网络技术0050','电子技术0050','2019-11-04 22:58:00','WU000002','E000009','1'),
	('FA000051','区块链是什么技术，下面最接近的回答是什么0051','网络技术0051','电子技术0051','2019-10-30 07:39:04','WU000002','E000009','1'),
	('FA000052','区块链是什么技术，下面最接近的回答是什么0052','网络技术0052','电子技术0052','2019-10-22 19:30:45','WU000002','E000009','1'),
	('FA000053','区块链是什么技术，下面最接近的回答是什么0053','网络技术0053','电子技术0053','2019-11-05 18:40:22','WU000002','E000009','1'),
	('FA000054','区块链是什么技术，下面最接近的回答是什么0054','网络技术0054','电子技术0054','2019-11-01 06:08:54','WU000002','E000009','1'),
	('FA000055','区块链是什么技术，下面最接近的回答是什么0055','网络技术0055','电子技术0055','2019-10-22 01:34:51','WU000002','E000010','1'),
	('FA000056','区块链是什么技术，下面最接近的回答是什么0056','网络技术0056','电子技术0056','2019-11-05 14:11:12','WU000002','E000010','1'),
	('FA000057','区块链是什么技术，下面最接近的回答是什么0057','网络技术0057','电子技术0057','2019-10-30 06:50:30','WU000002','E000010','1'),
	('FA000058','区块链是什么技术，下面最接近的回答是什么0058','网络技术0058','电子技术0058','2019-10-22 16:10:43','WU000002','E000010','1'),
	('FA000059','区块链是什么技术，下面最接近的回答是什么0059','网络技术0059','电子技术0059','2019-10-25 12:48:48','WU000002','E000010','1'),
	('FA000060','区块链是什么技术，下面最接近的回答是什么0060','网络技术0060','电子技术0060','2019-10-24 05:05:37','WU000002','E000010','1'),
	('FA000061','区块链是什么技术，下面最接近的回答是什么0061','网络技术0061','电子技术0061','2019-11-07 00:04:53','WU000002','E000011','1'),
	('FA000062','区块链是什么技术，下面最接近的回答是什么0062','网络技术0062','电子技术0062','2019-10-22 02:45:45','WU000002','E000011','1'),
	('FA000063','区块链是什么技术，下面最接近的回答是什么0063','网络技术0063','电子技术0063','2019-10-30 18:02:59','WU000002','E000011','1'),
	('FA000064','区块链是什么技术，下面最接近的回答是什么0064','网络技术0064','电子技术0064','2019-10-19 02:11:09','WU000002','E000011','1'),
	('FA000065','区块链是什么技术，下面最接近的回答是什么0065','网络技术0065','电子技术0065','2019-10-30 08:24:41','WU000002','E000011','1'),
	('FA000066','区块链是什么技术，下面最接近的回答是什么0066','网络技术0066','电子技术0066','2019-11-02 10:13:03','WU000002','E000011','1'),
	('FA000067','区块链是什么技术，下面最接近的回答是什么0067','网络技术0067','电子技术0067','2019-10-20 16:38:59','WU000002','E000012','1'),
	('FA000068','区块链是什么技术，下面最接近的回答是什么0068','网络技术0068','电子技术0068','2019-10-18 08:45:31','WU000002','E000012','1'),
	('FA000069','区块链是什么技术，下面最接近的回答是什么0069','网络技术0069','电子技术0069','2019-11-07 04:35:35','WU000002','E000012','1'),
	('FA000070','区块链是什么技术，下面最接近的回答是什么0070','网络技术0070','电子技术0070','2019-11-04 13:05:04','WU000002','E000012','1'),
	('FA000071','区块链是什么技术，下面最接近的回答是什么0071','网络技术0071','电子技术0071','2019-10-20 01:54:08','WU000002','E000012','1'),
	('FA000072','区块链是什么技术，下面最接近的回答是什么0072','网络技术0072','电子技术0072','2019-11-06 13:46:53','WU000002','E000012','1'),
	('FA000073','区块链是什么技术，下面最接近的回答是什么0073','网络技术0073','电子技术0073','2019-10-26 06:23:24','WU000003','E000013','1'),
	('FA000074','区块链是什么技术，下面最接近的回答是什么0074','网络技术0074','电子技术0074','2019-10-30 08:22:25','WU000003','E000013','1'),
	('FA000075','区块链是什么技术，下面最接近的回答是什么0075','网络技术0075','电子技术0075','2019-10-19 21:41:59','WU000003','E000013','1'),
	('FA000076','区块链是什么技术，下面最接近的回答是什么0076','网络技术0076','电子技术0076','2019-11-04 03:22:30','WU000003','E000013','1'),
	('FA000077','区块链是什么技术，下面最接近的回答是什么0077','网络技术0077','电子技术0077','2019-10-24 06:32:33','WU000003','E000013','1'),
	('FA000078','区块链是什么技术，下面最接近的回答是什么0078','网络技术0078','电子技术0078','2019-10-21 08:26:35','WU000003','E000013','1'),
	('FA000079','区块链是什么技术，下面最接近的回答是什么0079','网络技术0079','电子技术0079','2019-11-03 10:26:48','WU000003','E000014','1'),
	('FA000080','区块链是什么技术，下面最接近的回答是什么0080','网络技术0080','电子技术0080','2019-11-02 05:15:33','WU000003','E000014','1'),
	('FA000081','区块链是什么技术，下面最接近的回答是什么0081','网络技术0081','电子技术0081','2019-10-30 13:53:59','WU000003','E000014','1'),
	('FA000082','区块链是什么技术，下面最接近的回答是什么0082','网络技术0082','电子技术0082','2019-10-28 06:21:30','WU000003','E000014','1'),
	('FA000083','区块链是什么技术，下面最接近的回答是什么0083','网络技术0083','电子技术0083','2019-10-26 06:54:10','WU000003','E000014','1'),
	('FA000084','区块链是什么技术，下面最接近的回答是什么0084','网络技术0084','电子技术0084','2019-11-06 06:44:51','WU000003','E000014','1'),
	('FA000085','区块链是什么技术，下面最接近的回答是什么0085','网络技术0085','电子技术0085','2019-10-18 15:49:49','WU000003','E000015','1'),
	('FA000086','区块链是什么技术，下面最接近的回答是什么0086','网络技术0086','电子技术0086','2019-11-03 21:50:52','WU000003','E000015','1'),
	('FA000087','区块链是什么技术，下面最接近的回答是什么0087','网络技术0087','电子技术0087','2019-11-06 02:58:18','WU000003','E000015','1'),
	('FA000088','区块链是什么技术，下面最接近的回答是什么0088','网络技术0088','电子技术0088','2019-10-23 21:38:48','WU000003','E000015','1'),
	('FA000089','区块链是什么技术，下面最接近的回答是什么0089','网络技术0089','电子技术0089','2019-10-25 22:57:35','WU000003','E000015','1'),
	('FA000090','区块链是什么技术，下面最接近的回答是什么0090','网络技术0090','电子技术0090','2019-10-22 02:15:57','WU000003','E000015','1'),
	('FA000091','区块链是什么技术，下面最接近的回答是什么0091','网络技术0091','电子技术0091','2019-10-24 04:57:45','WU000003','E000016','1'),
	('FA000092','区块链是什么技术，下面最接近的回答是什么0092','网络技术0092','电子技术0092','2019-10-25 04:13:54','WU000003','E000016','1'),
	('FA000093','区块链是什么技术，下面最接近的回答是什么0093','网络技术0093','电子技术0093','2019-11-06 07:36:22','WU000003','E000016','1'),
	('FA000094','区块链是什么技术，下面最接近的回答是什么0094','网络技术0094','电子技术0094','2019-10-31 22:05:22','WU000003','E000016','1'),
	('FA000095','区块链是什么技术，下面最接近的回答是什么0095','网络技术0095','电子技术0095','2019-10-20 23:36:33','WU000003','E000016','1'),
	('FA000096','区块链是什么技术，下面最接近的回答是什么0096','网络技术0096','电子技术0096','2019-10-21 04:05:31','WU000003','E000016','1'),
	('FA000097','区块链是什么技术，下面最接近的回答是什么0097','网络技术0097','电子技术0097','2019-10-22 13:51:45','WU000003','E000017','1'),
	('FA000098','区块链是什么技术，下面最接近的回答是什么0098','网络技术0098','电子技术0098','2019-10-27 11:37:36','WU000003','E000017','1'),
	('FA000099','区块链是什么技术，下面最接近的回答是什么0099','网络技术0099','电子技术0099','2019-10-20 16:30:16','WU000003','E000017','1'),
	('FA000100','区块链是什么技术，下面最接近的回答是什么0100','网络技术0100','电子技术0100','2019-10-31 22:30:17','WU000003','E000017','1'),
	('FA000101','区块链是什么技术，下面最接近的回答是什么0101','网络技术0101','电子技术0101','2019-11-04 12:50:58','WU000003','E000017','1'),
	('FA000102','区块链是什么技术，下面最接近的回答是什么0102','网络技术0102','电子技术0102','2019-10-27 22:46:44','WU000003','E000017','1'),
	('FA000103','区块链是什么技术，下面最接近的回答是什么0103','网络技术0103','电子技术0103','2019-10-24 14:36:24','WU000003','E000018','1'),
	('FA000104','区块链是什么技术，下面最接近的回答是什么0104','网络技术0104','电子技术0104','2019-10-25 01:52:33','WU000003','E000018','1'),
	('FA000105','区块链是什么技术，下面最接近的回答是什么0105','网络技术0105','电子技术0105','2019-10-21 11:41:20','WU000003','E000018','1'),
	('FA000106','区块链是什么技术，下面最接近的回答是什么0106','网络技术0106','电子技术0106','2019-10-29 10:05:43','WU000003','E000018','1'),
	('FA000107','区块链是什么技术，下面最接近的回答是什么0107','网络技术0107','电子技术0107','2019-11-06 07:30:25','WU000003','E000018','1'),
	('FA000108','区块链是什么技术，下面最接近的回答是什么0108','网络技术0108','电子技术0108','2019-10-23 21:53:29','WU000003','E000018','1'),
	('FA000109','区块链是什么技术，下面最接近的回答是什么0109','网络技术0109','电子技术0109','2019-10-29 16:46:24','WU000004','E000019','1'),
	('FA000110','区块链是什么技术，下面最接近的回答是什么0110','网络技术0110','电子技术0110','2019-10-27 01:46:35','WU000004','E000019','1'),
	('FA000111','区块链是什么技术，下面最接近的回答是什么0111','网络技术0111','电子技术0111','2019-11-04 18:35:12','WU000004','E000019','1'),
	('FA000112','区块链是什么技术，下面最接近的回答是什么0112','网络技术0112','电子技术0112','2019-10-27 03:45:24','WU000004','E000019','1'),
	('FA000113','区块链是什么技术，下面最接近的回答是什么0113','网络技术0113','电子技术0113','2019-10-31 03:22:58','WU000004','E000019','1'),
	('FA000114','区块链是什么技术，下面最接近的回答是什么0114','网络技术0114','电子技术0114','2019-11-02 06:31:59','WU000004','E000019','1'),
	('FA000115','区块链是什么技术，下面最接近的回答是什么0115','网络技术0115','电子技术0115','2019-11-05 22:17:00','WU000004','E000020','1'),
	('FA000116','区块链是什么技术，下面最接近的回答是什么0116','网络技术0116','电子技术0116','2019-11-02 20:27:24','WU000004','E000020','1'),
	('FA000117','区块链是什么技术，下面最接近的回答是什么0117','网络技术0117','电子技术0117','2019-10-19 09:46:40','WU000004','E000020','1'),
	('FA000118','区块链是什么技术，下面最接近的回答是什么0118','网络技术0118','电子技术0118','2019-10-26 07:27:56','WU000004','E000020','1'),
	('FA000119','区块链是什么技术，下面最接近的回答是什么0119','网络技术0119','电子技术0119','2019-10-31 22:58:13','WU000004','E000020','1'),
	('FA000120','区块链是什么技术，下面最接近的回答是什么0120','网络技术0120','电子技术0120','2019-10-22 23:33:25','WU000004','E000020','1'),
	('FA000121','区块链是什么技术，下面最接近的回答是什么0121','网络技术0121','电子技术0121','2019-10-27 01:01:02','WU000004','E000021','1'),
	('FA000122','区块链是什么技术，下面最接近的回答是什么0122','网络技术0122','电子技术0122','2019-10-23 23:50:15','WU000004','E000021','1'),
	('FA000123','区块链是什么技术，下面最接近的回答是什么0123','网络技术0123','电子技术0123','2019-11-06 18:53:32','WU000004','E000021','1'),
	('FA000124','区块链是什么技术，下面最接近的回答是什么0124','网络技术0124','电子技术0124','2019-10-27 05:39:40','WU000004','E000021','1'),
	('FA000125','区块链是什么技术，下面最接近的回答是什么0125','网络技术0125','电子技术0125','2019-10-18 16:41:10','WU000004','E000021','1'),
	('FA000126','区块链是什么技术，下面最接近的回答是什么0126','网络技术0126','电子技术0126','2019-11-04 16:31:27','WU000004','E000021','1'),
	('FA000127','区块链是什么技术，下面最接近的回答是什么0127','网络技术0127','电子技术0127','2019-10-19 02:20:38','WU000004','E000022','1'),
	('FA000128','区块链是什么技术，下面最接近的回答是什么0128','网络技术0128','电子技术0128','2019-10-19 08:41:24','WU000004','E000022','1'),
	('FA000129','区块链是什么技术，下面最接近的回答是什么0129','网络技术0129','电子技术0129','2019-11-03 13:04:51','WU000004','E000022','1'),
	('FA000130','区块链是什么技术，下面最接近的回答是什么0130','网络技术0130','电子技术0130','2019-10-16 23:28:08','WU000004','E000022','1'),
	('FA000131','区块链是什么技术，下面最接近的回答是什么0131','网络技术0131','电子技术0131','2019-11-07 02:51:17','WU000004','E000022','1'),
	('FA000132','区块链是什么技术，下面最接近的回答是什么0132','网络技术0132','电子技术0132','2019-11-05 23:59:03','WU000004','E000022','1'),
	('FA000133','区块链是什么技术，下面最接近的回答是什么0133','网络技术0133','电子技术0133','2019-10-28 18:11:15','WU000004','E000023','1'),
	('FA000134','区块链是什么技术，下面最接近的回答是什么0134','网络技术0134','电子技术0134','2019-11-06 09:38:47','WU000004','E000023','1'),
	('FA000135','区块链是什么技术，下面最接近的回答是什么0135','网络技术0135','电子技术0135','2019-10-22 20:20:50','WU000004','E000023','1'),
	('FA000136','区块链是什么技术，下面最接近的回答是什么0136','网络技术0136','电子技术0136','2019-10-26 15:43:56','WU000004','E000023','1'),
	('FA000137','区块链是什么技术，下面最接近的回答是什么0137','网络技术0137','电子技术0137','2019-11-07 13:48:29','WU000004','E000023','1'),
	('FA000138','区块链是什么技术，下面最接近的回答是什么0138','网络技术0138','电子技术0138','2019-10-17 05:49:43','WU000004','E000023','1'),
	('FA000139','区块链是什么技术，下面最接近的回答是什么0139','网络技术0139','电子技术0139','2019-11-05 14:27:27','WU000004','E000024','1'),
	('FA000140','区块链是什么技术，下面最接近的回答是什么0140','网络技术0140','电子技术0140','2019-11-03 07:55:16','WU000004','E000024','1'),
	('FA000141','区块链是什么技术，下面最接近的回答是什么0141','网络技术0141','电子技术0141','2019-10-30 23:24:51','WU000004','E000024','1'),
	('FA000142','区块链是什么技术，下面最接近的回答是什么0142','网络技术0142','电子技术0142','2019-10-31 23:03:59','WU000004','E000024','1'),
	('FA000143','区块链是什么技术，下面最接近的回答是什么0143','网络技术0143','电子技术0143','2019-11-04 19:15:39','WU000004','E000024','1'),
	('FA000144','区块链是什么技术，下面最接近的回答是什么0144','网络技术0144','电子技术0144','2019-11-01 04:32:37','WU000004','E000024','1'),
	('FA000145','区块链是什么技术，下面最接近的回答是什么0145','网络技术0145','电子技术0145','2019-10-20 19:11:18','WU000005','E000025','1'),
	('FA000146','区块链是什么技术，下面最接近的回答是什么0146','网络技术0146','电子技术0146','2019-11-06 14:02:42','WU000005','E000025','1'),
	('FA000147','区块链是什么技术，下面最接近的回答是什么0147','网络技术0147','电子技术0147','2019-10-23 13:55:11','WU000005','E000025','1'),
	('FA000148','区块链是什么技术，下面最接近的回答是什么0148','网络技术0148','电子技术0148','2019-11-06 22:21:11','WU000005','E000025','1'),
	('FA000149','区块链是什么技术，下面最接近的回答是什么0149','网络技术0149','电子技术0149','2019-10-18 19:11:08','WU000005','E000025','1'),
	('FA000150','区块链是什么技术，下面最接近的回答是什么0150','网络技术0150','电子技术0150','2019-10-18 02:44:33','WU000005','E000025','1'),
	('FA000151','区块链是什么技术，下面最接近的回答是什么0151','网络技术0151','电子技术0151','2019-10-17 07:16:16','WU000005','E000026','1'),
	('FA000152','区块链是什么技术，下面最接近的回答是什么0152','网络技术0152','电子技术0152','2019-10-21 22:38:16','WU000005','E000026','1'),
	('FA000153','区块链是什么技术，下面最接近的回答是什么0153','网络技术0153','电子技术0153','2019-11-05 00:52:28','WU000005','E000026','1'),
	('FA000154','区块链是什么技术，下面最接近的回答是什么0154','网络技术0154','电子技术0154','2019-10-25 05:42:53','WU000005','E000026','1'),
	('FA000155','区块链是什么技术，下面最接近的回答是什么0155','网络技术0155','电子技术0155','2019-10-20 10:30:00','WU000005','E000026','1'),
	('FA000156','区块链是什么技术，下面最接近的回答是什么0156','网络技术0156','电子技术0156','2019-10-27 22:53:41','WU000005','E000026','1'),
	('FA000157','区块链是什么技术，下面最接近的回答是什么0157','网络技术0157','电子技术0157','2019-10-26 20:02:32','WU000005','E000027','1'),
	('FA000158','区块链是什么技术，下面最接近的回答是什么0158','网络技术0158','电子技术0158','2019-10-21 14:38:47','WU000005','E000027','1'),
	('FA000159','区块链是什么技术，下面最接近的回答是什么0159','网络技术0159','电子技术0159','2019-10-25 23:11:23','WU000005','E000027','1'),
	('FA000160','区块链是什么技术，下面最接近的回答是什么0160','网络技术0160','电子技术0160','2019-11-04 12:30:37','WU000005','E000027','1'),
	('FA000161','区块链是什么技术，下面最接近的回答是什么0161','网络技术0161','电子技术0161','2019-10-26 04:37:31','WU000005','E000027','1'),
	('FA000162','区块链是什么技术，下面最接近的回答是什么0162','网络技术0162','电子技术0162','2019-11-02 19:45:26','WU000005','E000027','1'),
	('FA000163','区块链是什么技术，下面最接近的回答是什么0163','网络技术0163','电子技术0163','2019-10-31 01:01:26','WU000005','E000028','1'),
	('FA000164','区块链是什么技术，下面最接近的回答是什么0164','网络技术0164','电子技术0164','2019-10-24 15:49:27','WU000005','E000028','1'),
	('FA000165','区块链是什么技术，下面最接近的回答是什么0165','网络技术0165','电子技术0165','2019-11-02 08:12:07','WU000005','E000028','1'),
	('FA000166','区块链是什么技术，下面最接近的回答是什么0166','网络技术0166','电子技术0166','2019-10-30 12:49:08','WU000005','E000028','1'),
	('FA000167','区块链是什么技术，下面最接近的回答是什么0167','网络技术0167','电子技术0167','2019-10-23 01:48:28','WU000005','E000028','1'),
	('FA000168','区块链是什么技术，下面最接近的回答是什么0168','网络技术0168','电子技术0168','2019-10-25 22:01:09','WU000005','E000028','1'),
	('FA000169','区块链是什么技术，下面最接近的回答是什么0169','网络技术0169','电子技术0169','2019-10-17 04:06:25','WU000005','E000029','1'),
	('FA000170','区块链是什么技术，下面最接近的回答是什么0170','网络技术0170','电子技术0170','2019-10-19 06:31:59','WU000005','E000029','1'),
	('FA000171','区块链是什么技术，下面最接近的回答是什么0171','网络技术0171','电子技术0171','2019-11-06 09:54:31','WU000005','E000029','1'),
	('FA000172','区块链是什么技术，下面最接近的回答是什么0172','网络技术0172','电子技术0172','2019-10-18 10:59:48','WU000005','E000029','1'),
	('FA000173','区块链是什么技术，下面最接近的回答是什么0173','网络技术0173','电子技术0173','2019-11-02 22:21:46','WU000005','E000029','1'),
	('FA000174','区块链是什么技术，下面最接近的回答是什么0174','网络技术0174','电子技术0174','2019-10-28 22:14:26','WU000005','E000029','1'),
	('FA000175','区块链是什么技术，下面最接近的回答是什么0175','网络技术0175','电子技术0175','2019-10-29 05:39:41','WU000005','E000030','1'),
	('FA000176','区块链是什么技术，下面最接近的回答是什么0176','网络技术0176','电子技术0176','2019-10-23 18:07:51','WU000005','E000030','1'),
	('FA000177','区块链是什么技术，下面最接近的回答是什么0177','网络技术0177','电子技术0177','2019-11-04 16:16:50','WU000005','E000030','1'),
	('FA000178','区块链是什么技术，下面最接近的回答是什么0178','网络技术0178','电子技术0178','2019-10-23 13:34:47','WU000005','E000030','1'),
	('FA000179','区块链是什么技术，下面最接近的回答是什么0179','网络技术0179','电子技术0179','2019-10-23 22:57:51','WU000005','E000030','1'),
	('FA000180','区块链是什么技术，下面最接近的回答是什么0180','网络技术0180','电子技术0180','2019-11-03 17:44:35','WU000005','E000030','1'),
	('FA000181','区块链是什么技术，下面最接近的回答是什么0181','网络技术0181','电子技术0181','2019-10-20 08:05:02','WU000006','E000031','1'),
	('FA000182','区块链是什么技术，下面最接近的回答是什么0182','网络技术0182','电子技术0182','2019-10-19 06:34:17','WU000006','E000031','1'),
	('FA000183','区块链是什么技术，下面最接近的回答是什么0183','网络技术0183','电子技术0183','2019-10-30 01:59:16','WU000006','E000031','1'),
	('FA000184','区块链是什么技术，下面最接近的回答是什么0184','网络技术0184','电子技术0184','2019-11-07 01:19:37','WU000006','E000031','1'),
	('FA000185','区块链是什么技术，下面最接近的回答是什么0185','网络技术0185','电子技术0185','2019-10-30 00:48:26','WU000006','E000031','1'),
	('FA000186','区块链是什么技术，下面最接近的回答是什么0186','网络技术0186','电子技术0186','2019-10-26 09:55:08','WU000006','E000031','1'),
	('FA000187','区块链是什么技术，下面最接近的回答是什么0187','网络技术0187','电子技术0187','2019-10-20 02:38:53','WU000006','E000032','1'),
	('FA000188','区块链是什么技术，下面最接近的回答是什么0188','网络技术0188','电子技术0188','2019-10-31 01:57:42','WU000006','E000032','1'),
	('FA000189','区块链是什么技术，下面最接近的回答是什么0189','网络技术0189','电子技术0189','2019-10-19 16:16:16','WU000006','E000032','1'),
	('FA000190','区块链是什么技术，下面最接近的回答是什么0190','网络技术0190','电子技术0190','2019-10-17 12:36:45','WU000006','E000032','1'),
	('FA000191','区块链是什么技术，下面最接近的回答是什么0191','网络技术0191','电子技术0191','2019-10-17 19:02:50','WU000006','E000032','1'),
	('FA000192','区块链是什么技术，下面最接近的回答是什么0192','网络技术0192','电子技术0192','2019-10-28 22:58:41','WU000006','E000032','1'),
	('FA000193','区块链是什么技术，下面最接近的回答是什么0193','网络技术0193','电子技术0193','2019-10-18 20:29:43','WU000006','E000033','1'),
	('FA000194','区块链是什么技术，下面最接近的回答是什么0194','网络技术0194','电子技术0194','2019-10-20 16:05:14','WU000006','E000033','1'),
	('FA000195','区块链是什么技术，下面最接近的回答是什么0195','网络技术0195','电子技术0195','2019-10-25 06:15:07','WU000006','E000033','1'),
	('FA000196','区块链是什么技术，下面最接近的回答是什么0196','网络技术0196','电子技术0196','2019-10-30 17:12:10','WU000006','E000033','1'),
	('FA000197','区块链是什么技术，下面最接近的回答是什么0197','网络技术0197','电子技术0197','2019-10-26 15:41:37','WU000006','E000033','1'),
	('FA000198','区块链是什么技术，下面最接近的回答是什么0198','网络技术0198','电子技术0198','2019-10-31 16:20:39','WU000006','E000033','1'),
	('FA000199','区块链是什么技术，下面最接近的回答是什么0199','网络技术0199','电子技术0199','2019-11-04 00:59:42','WU000006','E000034','1'),
	('FA000200','区块链是什么技术，下面最接近的回答是什么0200','网络技术0200','电子技术0200','2019-10-30 12:11:23','WU000006','E000034','1'),
	('FA000201','区块链是什么技术，下面最接近的回答是什么0201','网络技术0201','电子技术0201','2019-10-18 01:37:16','WU000006','E000034','1'),
	('FA000202','区块链是什么技术，下面最接近的回答是什么0202','网络技术0202','电子技术0202','2019-10-18 16:02:35','WU000006','E000034','1'),
	('FA000203','区块链是什么技术，下面最接近的回答是什么0203','网络技术0203','电子技术0203','2019-11-04 17:29:55','WU000006','E000034','1'),
	('FA000204','区块链是什么技术，下面最接近的回答是什么0204','网络技术0204','电子技术0204','2019-10-25 13:56:54','WU000006','E000034','1'),
	('FA000205','区块链是什么技术，下面最接近的回答是什么0205','网络技术0205','电子技术0205','2019-10-16 22:27:51','WU000006','E000035','1'),
	('FA000206','区块链是什么技术，下面最接近的回答是什么0206','网络技术0206','电子技术0206','2019-10-18 13:11:30','WU000006','E000035','1'),
	('FA000207','区块链是什么技术，下面最接近的回答是什么0207','网络技术0207','电子技术0207','2019-10-27 19:04:24','WU000006','E000035','1'),
	('FA000208','区块链是什么技术，下面最接近的回答是什么0208','网络技术0208','电子技术0208','2019-10-25 06:49:06','WU000006','E000035','1'),
	('FA000209','区块链是什么技术，下面最接近的回答是什么0209','网络技术0209','电子技术0209','2019-10-24 21:08:55','WU000006','E000035','1'),
	('FA000210','区块链是什么技术，下面最接近的回答是什么0210','网络技术0210','电子技术0210','2019-10-30 14:30:18','WU000006','E000035','1'),
	('FA000211','区块链是什么技术，下面最接近的回答是什么0211','网络技术0211','电子技术0211','2019-10-26 18:13:38','WU000006','E000036','1'),
	('FA000212','区块链是什么技术，下面最接近的回答是什么0212','网络技术0212','电子技术0212','2019-10-19 23:29:30','WU000006','E000036','1'),
	('FA000213','区块链是什么技术，下面最接近的回答是什么0213','网络技术0213','电子技术0213','2019-11-07 10:24:24','WU000006','E000036','1'),
	('FA000214','区块链是什么技术，下面最接近的回答是什么0214','网络技术0214','电子技术0214','2019-11-06 18:34:24','WU000006','E000036','1'),
	('FA000215','区块链是什么技术，下面最接近的回答是什么0215','网络技术0215','电子技术0215','2019-10-19 15:30:31','WU000006','E000036','1'),
	('FA000216','区块链是什么技术，下面最接近的回答是什么0216','网络技术0216','电子技术0216','2019-11-01 05:09:57','WU000006','E000036','1');

insert into user_domain_data values
	('UD000001','用户区域','1');

insert into user_white_list_data values
	('UWL000001','clariones','tester;ios-spokesperson','UD000001','1'),
	('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1'),
	('UWL000003','clariones','tester;ios-spokesperson0003','UD000001','1'),
	('UWL000004','13808188512','tester;ios-spokesperson0004','UD000001','1'),
	('UWL000005','clariones','tester;ios-spokesperson0005','UD000001','1'),
	('UWL000006','13808188512','tester;ios-spokesperson0006','UD000001','1');

insert into sec_user_data values
	('SU000001','login','13900000001','suddy_chang@163.com','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','wx123456789abcdefghijklmn','wxapp12098410239840','jwt_token_12345678','0','2019-11-05 04:52:40','2019-10-17 19:28:25','UD000001',NULL,'BLOCKED','1'),
	('SU000002','login0002','13900000002','2@qq.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','wx123456789abcdefghijklmn0002','wxapp120984102398400002','jwt_token_123456780002','9999999','2019-11-01 15:02:45','2019-10-21 22:37:20','UD000001',NULL,'BLOCKED0002','1'),
	('SU000003','login0003','13900000003','3@qq.com','1A39AE05E011CF4B6ADE19307698831F4303CEB3FF5A9E21EEC0B21FB19B1050','wx123456789abcdefghijklmn0003','wxapp120984102398400003','jwt_token_123456780003','0','2019-11-01 04:02:28','2019-10-17 08:58:58','UD000001',NULL,'BLOCKED0003','1'),
	('SU000004','login0004','13900000004','4@qq.com','331D0B81C261072AB3E01D2D09A3D1F9B03F1E5F095D6BF7284F32BF85135D59','wx123456789abcdefghijklmn0004','wxapp120984102398400004','jwt_token_123456780004','9999999','2019-10-30 19:53:16','2019-10-20 07:51:08','UD000001',NULL,'BLOCKED0004','1'),
	('SU000005','login0005','13900000005','5@qq.com','CBDC109937F570CA1D5F223EC59F5368AF9380F9DBF7E553124132BB402ED457','wx123456789abcdefghijklmn0005','wxapp120984102398400005','jwt_token_123456780005','0','2019-10-18 19:08:56','2019-10-26 07:29:14','UD000001',NULL,'BLOCKED0005','1'),
	('SU000006','login0006','13900000006','6@qq.com','69A610F10CE3333E0767CAEEB075A88B6B63E286F8BEBB9271C3EA6DF0CB2F7B','wx123456789abcdefghijklmn0006','wxapp120984102398400006','jwt_token_123456780006','9999999','2019-11-04 11:13:38','2019-11-04 18:18:45','UD000001',NULL,'BLOCKED0006','1');

insert into sec_user_blocking_data values
	('SUB000001','currentUser()','2019-10-25 11:18:55','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

insert into user_app_data values
	('UA000001','审车平台','SU000001','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1'),
	('UA000002','账户管理','SU000001','bank','1','MXWR','UserDomain','UD000001','/link/to/app0002','1'),
	('UA000003','接车公司','SU000001','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1'),
	('UA000004','审车公司','SU000001','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1'),
	('UA000005','维修公司','SU000001','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1'),
	('UA000006','顾客','SU000001','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0006','1'),
	('UA000007','审车平台','SU000002','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app0007','1'),
	('UA000008','账户管理','SU000002','bank','1','MXWR','UserDomain','UD000001','/link/to/app0008','1'),
	('UA000009','接车公司','SU000002','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0009','1'),
	('UA000010','审车公司','SU000002','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0010','1'),
	('UA000011','维修公司','SU000002','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0011','1'),
	('UA000012','顾客','SU000002','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0012','1'),
	('UA000013','审车平台','SU000003','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app0013','1'),
	('UA000014','账户管理','SU000003','bank','1','MXWR','UserDomain','UD000001','/link/to/app0014','1'),
	('UA000015','接车公司','SU000003','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0015','1'),
	('UA000016','审车公司','SU000003','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0016','1'),
	('UA000017','维修公司','SU000003','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0017','1'),
	('UA000018','顾客','SU000003','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0018','1'),
	('UA000019','审车平台','SU000004','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app0019','1'),
	('UA000020','账户管理','SU000004','bank','1','MXWR','UserDomain','UD000001','/link/to/app0020','1'),
	('UA000021','接车公司','SU000004','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0021','1'),
	('UA000022','审车公司','SU000004','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0022','1'),
	('UA000023','维修公司','SU000004','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0023','1'),
	('UA000024','顾客','SU000004','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0024','1'),
	('UA000025','审车平台','SU000005','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app0025','1'),
	('UA000026','账户管理','SU000005','bank','1','MXWR','UserDomain','UD000001','/link/to/app0026','1'),
	('UA000027','接车公司','SU000005','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0027','1'),
	('UA000028','审车公司','SU000005','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0028','1'),
	('UA000029','维修公司','SU000005','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0029','1'),
	('UA000030','顾客','SU000005','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0030','1'),
	('UA000031','审车平台','SU000006','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app0031','1'),
	('UA000032','账户管理','SU000006','bank','1','MXWR','UserDomain','UD000001','/link/to/app0032','1'),
	('UA000033','接车公司','SU000006','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0033','1'),
	('UA000034','审车公司','SU000006','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0034','1'),
	('UA000035','维修公司','SU000006','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0035','1'),
	('UA000036','顾客','SU000006','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0036','1');

insert into quick_link_data values
	('QL000001','列表','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表','2019-10-17 20:27:37','UA000001','1'),
	('QL000002','列表0002','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0002','2019-10-24 15:35:41','UA000001','1'),
	('QL000003','列表0003','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0003','2019-11-02 02:46:18','UA000001','1'),
	('QL000004','列表0004','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0004','2019-11-07 14:55:53','UA000001','1'),
	('QL000005','列表0005','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0005','2019-11-01 14:58:14','UA000001','1'),
	('QL000006','列表0006','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0006','2019-11-04 21:31:40','UA000001','1'),
	('QL000007','列表0007','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0007','2019-10-27 00:37:05','UA000002','1'),
	('QL000008','列表0008','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0008','2019-10-31 16:36:29','UA000002','1'),
	('QL000009','列表0009','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0009','2019-10-25 20:42:11','UA000002','1'),
	('QL000010','列表0010','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0010','2019-11-07 03:40:53','UA000002','1'),
	('QL000011','列表0011','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0011','2019-11-06 17:25:59','UA000002','1'),
	('QL000012','列表0012','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0012','2019-10-17 16:07:31','UA000002','1'),
	('QL000013','列表0013','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0013','2019-10-24 18:25:22','UA000003','1'),
	('QL000014','列表0014','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0014','2019-10-26 23:00:29','UA000003','1'),
	('QL000015','列表0015','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0015','2019-11-03 01:47:07','UA000003','1'),
	('QL000016','列表0016','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0016','2019-10-25 09:08:08','UA000003','1'),
	('QL000017','列表0017','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0017','2019-10-22 03:16:21','UA000003','1'),
	('QL000018','列表0018','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0018','2019-10-24 04:33:20','UA000003','1'),
	('QL000019','列表0019','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0019','2019-10-25 23:59:24','UA000004','1'),
	('QL000020','列表0020','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0020','2019-11-06 12:54:14','UA000004','1'),
	('QL000021','列表0021','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0021','2019-11-05 14:24:15','UA000004','1'),
	('QL000022','列表0022','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0022','2019-11-05 10:19:53','UA000004','1'),
	('QL000023','列表0023','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0023','2019-11-04 21:22:44','UA000004','1'),
	('QL000024','列表0024','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0024','2019-10-16 23:41:10','UA000004','1'),
	('QL000025','列表0025','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0025','2019-10-22 14:56:46','UA000005','1'),
	('QL000026','列表0026','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0026','2019-11-01 13:15:39','UA000005','1'),
	('QL000027','列表0027','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0027','2019-10-23 21:39:46','UA000005','1'),
	('QL000028','列表0028','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0028','2019-11-02 20:19:26','UA000005','1'),
	('QL000029','列表0029','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0029','2019-11-03 06:28:10','UA000005','1'),
	('QL000030','列表0030','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0030','2019-11-04 16:13:08','UA000005','1'),
	('QL000031','列表0031','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0031','2019-10-24 01:25:26','UA000006','1'),
	('QL000032','列表0032','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0032','2019-11-06 14:00:53','UA000006','1'),
	('QL000033','列表0033','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0033','2019-11-07 04:16:20','UA000006','1'),
	('QL000034','列表0034','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0034','2019-10-27 09:55:42','UA000006','1'),
	('QL000035','列表0035','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0035','2019-10-21 18:15:18','UA000006','1'),
	('QL000036','列表0036','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0036','2019-10-30 17:50:03','UA000006','1'),
	('QL000037','列表0037','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0037','2019-10-18 23:12:17','UA000007','1'),
	('QL000038','列表0038','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0038','2019-10-22 09:56:34','UA000007','1'),
	('QL000039','列表0039','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0039','2019-10-31 03:46:23','UA000007','1'),
	('QL000040','列表0040','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0040','2019-10-24 19:25:17','UA000007','1'),
	('QL000041','列表0041','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0041','2019-11-04 00:22:32','UA000007','1'),
	('QL000042','列表0042','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0042','2019-10-23 11:10:36','UA000007','1'),
	('QL000043','列表0043','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0043','2019-10-18 08:40:03','UA000008','1'),
	('QL000044','列表0044','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0044','2019-11-02 07:54:27','UA000008','1'),
	('QL000045','列表0045','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0045','2019-11-05 17:19:04','UA000008','1'),
	('QL000046','列表0046','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0046','2019-10-20 20:31:44','UA000008','1'),
	('QL000047','列表0047','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0047','2019-10-26 16:29:40','UA000008','1'),
	('QL000048','列表0048','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0048','2019-10-22 18:50:44','UA000008','1'),
	('QL000049','列表0049','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0049','2019-10-27 09:40:23','UA000009','1'),
	('QL000050','列表0050','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0050','2019-10-24 03:38:23','UA000009','1'),
	('QL000051','列表0051','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0051','2019-10-27 02:06:58','UA000009','1'),
	('QL000052','列表0052','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0052','2019-11-06 09:01:40','UA000009','1'),
	('QL000053','列表0053','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0053','2019-11-01 08:44:20','UA000009','1'),
	('QL000054','列表0054','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0054','2019-11-01 19:33:12','UA000009','1'),
	('QL000055','列表0055','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0055','2019-11-04 03:29:28','UA000010','1'),
	('QL000056','列表0056','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0056','2019-10-19 06:12:00','UA000010','1'),
	('QL000057','列表0057','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0057','2019-10-23 11:08:45','UA000010','1'),
	('QL000058','列表0058','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0058','2019-10-17 08:12:06','UA000010','1'),
	('QL000059','列表0059','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0059','2019-10-29 02:44:59','UA000010','1'),
	('QL000060','列表0060','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0060','2019-10-29 18:27:23','UA000010','1'),
	('QL000061','列表0061','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0061','2019-11-06 18:04:49','UA000011','1'),
	('QL000062','列表0062','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0062','2019-10-22 17:00:31','UA000011','1'),
	('QL000063','列表0063','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0063','2019-10-25 23:44:55','UA000011','1'),
	('QL000064','列表0064','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0064','2019-10-18 20:52:47','UA000011','1'),
	('QL000065','列表0065','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0065','2019-11-01 05:25:36','UA000011','1'),
	('QL000066','列表0066','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0066','2019-10-26 11:42:41','UA000011','1'),
	('QL000067','列表0067','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0067','2019-10-17 10:58:48','UA000012','1'),
	('QL000068','列表0068','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0068','2019-11-02 20:24:38','UA000012','1'),
	('QL000069','列表0069','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0069','2019-10-29 03:24:49','UA000012','1'),
	('QL000070','列表0070','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0070','2019-10-24 19:06:57','UA000012','1'),
	('QL000071','列表0071','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0071','2019-10-28 15:37:07','UA000012','1'),
	('QL000072','列表0072','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0072','2019-11-06 03:33:50','UA000012','1'),
	('QL000073','列表0073','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0073','2019-10-17 00:21:07','UA000013','1'),
	('QL000074','列表0074','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0074','2019-10-23 15:57:53','UA000013','1'),
	('QL000075','列表0075','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0075','2019-10-18 09:01:08','UA000013','1'),
	('QL000076','列表0076','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0076','2019-10-18 09:04:32','UA000013','1'),
	('QL000077','列表0077','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0077','2019-10-20 10:18:39','UA000013','1'),
	('QL000078','列表0078','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0078','2019-10-28 12:21:51','UA000013','1'),
	('QL000079','列表0079','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0079','2019-11-02 07:20:15','UA000014','1'),
	('QL000080','列表0080','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0080','2019-11-02 18:50:55','UA000014','1'),
	('QL000081','列表0081','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0081','2019-11-05 04:38:04','UA000014','1'),
	('QL000082','列表0082','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0082','2019-10-20 01:55:12','UA000014','1'),
	('QL000083','列表0083','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0083','2019-10-25 20:43:50','UA000014','1'),
	('QL000084','列表0084','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0084','2019-10-19 21:41:11','UA000014','1'),
	('QL000085','列表0085','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0085','2019-10-22 19:42:36','UA000015','1'),
	('QL000086','列表0086','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0086','2019-10-25 22:15:16','UA000015','1'),
	('QL000087','列表0087','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0087','2019-10-31 23:59:18','UA000015','1'),
	('QL000088','列表0088','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0088','2019-10-28 05:37:55','UA000015','1'),
	('QL000089','列表0089','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0089','2019-10-29 07:06:22','UA000015','1'),
	('QL000090','列表0090','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0090','2019-10-20 00:08:13','UA000015','1'),
	('QL000091','列表0091','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0091','2019-10-31 08:54:04','UA000016','1'),
	('QL000092','列表0092','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0092','2019-10-23 13:06:03','UA000016','1'),
	('QL000093','列表0093','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0093','2019-11-01 11:57:05','UA000016','1'),
	('QL000094','列表0094','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0094','2019-10-19 11:25:24','UA000016','1'),
	('QL000095','列表0095','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0095','2019-11-03 14:06:09','UA000016','1'),
	('QL000096','列表0096','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0096','2019-11-01 22:46:59','UA000016','1'),
	('QL000097','列表0097','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0097','2019-10-26 02:23:22','UA000017','1'),
	('QL000098','列表0098','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0098','2019-11-02 06:36:34','UA000017','1'),
	('QL000099','列表0099','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0099','2019-10-29 18:01:36','UA000017','1'),
	('QL000100','列表0100','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0100','2019-10-28 14:41:45','UA000017','1'),
	('QL000101','列表0101','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0101','2019-11-07 03:56:37','UA000017','1'),
	('QL000102','列表0102','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0102','2019-11-03 14:49:44','UA000017','1'),
	('QL000103','列表0103','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0103','2019-10-30 20:06:41','UA000018','1'),
	('QL000104','列表0104','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0104','2019-11-05 08:13:20','UA000018','1'),
	('QL000105','列表0105','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0105','2019-10-28 15:14:38','UA000018','1'),
	('QL000106','列表0106','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0106','2019-10-18 10:34:16','UA000018','1'),
	('QL000107','列表0107','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0107','2019-10-19 07:43:33','UA000018','1'),
	('QL000108','列表0108','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0108','2019-10-30 04:36:46','UA000018','1'),
	('QL000109','列表0109','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0109','2019-10-23 22:12:27','UA000019','1'),
	('QL000110','列表0110','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0110','2019-11-03 01:52:31','UA000019','1'),
	('QL000111','列表0111','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0111','2019-10-28 19:26:39','UA000019','1'),
	('QL000112','列表0112','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0112','2019-11-01 03:20:21','UA000019','1'),
	('QL000113','列表0113','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0113','2019-10-26 03:14:48','UA000019','1'),
	('QL000114','列表0114','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0114','2019-10-28 09:03:27','UA000019','1'),
	('QL000115','列表0115','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0115','2019-10-19 09:16:41','UA000020','1'),
	('QL000116','列表0116','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0116','2019-10-25 14:58:51','UA000020','1'),
	('QL000117','列表0117','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0117','2019-11-05 00:21:16','UA000020','1'),
	('QL000118','列表0118','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0118','2019-10-30 03:33:05','UA000020','1'),
	('QL000119','列表0119','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0119','2019-10-20 09:41:00','UA000020','1'),
	('QL000120','列表0120','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0120','2019-10-31 13:16:46','UA000020','1'),
	('QL000121','列表0121','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0121','2019-10-17 01:39:25','UA000021','1'),
	('QL000122','列表0122','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0122','2019-10-25 07:11:37','UA000021','1'),
	('QL000123','列表0123','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0123','2019-10-24 13:11:28','UA000021','1'),
	('QL000124','列表0124','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0124','2019-10-28 19:32:57','UA000021','1'),
	('QL000125','列表0125','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0125','2019-11-05 23:21:03','UA000021','1'),
	('QL000126','列表0126','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0126','2019-10-18 00:27:57','UA000021','1'),
	('QL000127','列表0127','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0127','2019-11-06 00:58:11','UA000022','1'),
	('QL000128','列表0128','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0128','2019-10-22 02:37:34','UA000022','1'),
	('QL000129','列表0129','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0129','2019-10-27 09:43:10','UA000022','1'),
	('QL000130','列表0130','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0130','2019-10-20 04:59:41','UA000022','1'),
	('QL000131','列表0131','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0131','2019-10-17 17:30:04','UA000022','1'),
	('QL000132','列表0132','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0132','2019-11-06 01:20:58','UA000022','1'),
	('QL000133','列表0133','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0133','2019-10-20 22:43:20','UA000023','1'),
	('QL000134','列表0134','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0134','2019-11-06 12:39:18','UA000023','1'),
	('QL000135','列表0135','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0135','2019-10-25 22:16:22','UA000023','1'),
	('QL000136','列表0136','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0136','2019-10-17 14:12:15','UA000023','1'),
	('QL000137','列表0137','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0137','2019-11-01 02:39:23','UA000023','1'),
	('QL000138','列表0138','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0138','2019-11-05 14:03:01','UA000023','1'),
	('QL000139','列表0139','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0139','2019-11-06 20:18:28','UA000024','1'),
	('QL000140','列表0140','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0140','2019-10-31 21:01:28','UA000024','1'),
	('QL000141','列表0141','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0141','2019-11-06 01:27:01','UA000024','1'),
	('QL000142','列表0142','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0142','2019-10-19 03:26:27','UA000024','1'),
	('QL000143','列表0143','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0143','2019-10-27 09:55:06','UA000024','1'),
	('QL000144','列表0144','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0144','2019-10-20 14:08:15','UA000024','1'),
	('QL000145','列表0145','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0145','2019-10-20 21:00:24','UA000025','1'),
	('QL000146','列表0146','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0146','2019-11-07 17:16:32','UA000025','1'),
	('QL000147','列表0147','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0147','2019-10-18 22:38:58','UA000025','1'),
	('QL000148','列表0148','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0148','2019-11-04 05:02:45','UA000025','1'),
	('QL000149','列表0149','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0149','2019-11-05 01:54:51','UA000025','1'),
	('QL000150','列表0150','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0150','2019-10-17 05:49:05','UA000025','1'),
	('QL000151','列表0151','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0151','2019-10-22 12:35:04','UA000026','1'),
	('QL000152','列表0152','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0152','2019-10-31 04:05:05','UA000026','1'),
	('QL000153','列表0153','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0153','2019-11-07 09:57:39','UA000026','1'),
	('QL000154','列表0154','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0154','2019-11-05 05:06:17','UA000026','1'),
	('QL000155','列表0155','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0155','2019-10-20 20:49:09','UA000026','1'),
	('QL000156','列表0156','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0156','2019-10-28 16:27:00','UA000026','1'),
	('QL000157','列表0157','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0157','2019-10-30 11:13:57','UA000027','1'),
	('QL000158','列表0158','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0158','2019-11-06 12:50:54','UA000027','1'),
	('QL000159','列表0159','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0159','2019-10-29 18:21:53','UA000027','1'),
	('QL000160','列表0160','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0160','2019-10-21 16:59:05','UA000027','1'),
	('QL000161','列表0161','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0161','2019-11-04 04:44:45','UA000027','1'),
	('QL000162','列表0162','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0162','2019-11-03 04:54:17','UA000027','1'),
	('QL000163','列表0163','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0163','2019-10-31 17:01:32','UA000028','1'),
	('QL000164','列表0164','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0164','2019-10-31 01:19:24','UA000028','1'),
	('QL000165','列表0165','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0165','2019-11-03 02:33:24','UA000028','1'),
	('QL000166','列表0166','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0166','2019-10-28 20:08:23','UA000028','1'),
	('QL000167','列表0167','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0167','2019-10-28 07:18:09','UA000028','1'),
	('QL000168','列表0168','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0168','2019-10-22 08:02:03','UA000028','1'),
	('QL000169','列表0169','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0169','2019-10-26 21:30:55','UA000029','1'),
	('QL000170','列表0170','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0170','2019-10-29 22:11:26','UA000029','1'),
	('QL000171','列表0171','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0171','2019-10-16 21:30:10','UA000029','1'),
	('QL000172','列表0172','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0172','2019-10-21 02:51:30','UA000029','1'),
	('QL000173','列表0173','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0173','2019-10-19 22:16:07','UA000029','1'),
	('QL000174','列表0174','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0174','2019-10-23 12:41:21','UA000029','1'),
	('QL000175','列表0175','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0175','2019-11-03 18:36:04','UA000030','1'),
	('QL000176','列表0176','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0176','2019-10-29 00:02:06','UA000030','1'),
	('QL000177','列表0177','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0177','2019-11-06 01:23:41','UA000030','1'),
	('QL000178','列表0178','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0178','2019-10-20 18:00:53','UA000030','1'),
	('QL000179','列表0179','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0179','2019-10-19 06:34:11','UA000030','1'),
	('QL000180','列表0180','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0180','2019-11-03 00:37:08','UA000030','1'),
	('QL000181','列表0181','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0181','2019-10-29 16:26:15','UA000031','1'),
	('QL000182','列表0182','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0182','2019-10-22 06:58:05','UA000031','1'),
	('QL000183','列表0183','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0183','2019-10-31 06:42:38','UA000031','1'),
	('QL000184','列表0184','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0184','2019-10-20 23:13:41','UA000031','1'),
	('QL000185','列表0185','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0185','2019-10-25 15:32:14','UA000031','1'),
	('QL000186','列表0186','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0186','2019-11-07 05:30:58','UA000031','1'),
	('QL000187','列表0187','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0187','2019-11-01 10:08:48','UA000032','1'),
	('QL000188','列表0188','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0188','2019-10-19 17:37:48','UA000032','1'),
	('QL000189','列表0189','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0189','2019-10-28 01:17:21','UA000032','1'),
	('QL000190','列表0190','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0190','2019-11-03 13:43:27','UA000032','1'),
	('QL000191','列表0191','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0191','2019-10-17 01:29:47','UA000032','1'),
	('QL000192','列表0192','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0192','2019-10-29 15:33:07','UA000032','1'),
	('QL000193','列表0193','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0193','2019-11-02 12:02:33','UA000033','1'),
	('QL000194','列表0194','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0194','2019-10-30 21:35:53','UA000033','1'),
	('QL000195','列表0195','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0195','2019-10-31 21:37:34','UA000033','1'),
	('QL000196','列表0196','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0196','2019-10-21 11:43:58','UA000033','1'),
	('QL000197','列表0197','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0197','2019-10-18 13:02:10','UA000033','1'),
	('QL000198','列表0198','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0198','2019-11-03 14:23:02','UA000033','1'),
	('QL000199','列表0199','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0199','2019-10-23 19:05:29','UA000034','1'),
	('QL000200','列表0200','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0200','2019-10-30 23:50:50','UA000034','1'),
	('QL000201','列表0201','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0201','2019-11-02 14:35:28','UA000034','1'),
	('QL000202','列表0202','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0202','2019-11-06 09:55:21','UA000034','1'),
	('QL000203','列表0203','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0203','2019-10-29 00:00:22','UA000034','1'),
	('QL000204','列表0204','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0204','2019-11-02 03:01:25','UA000034','1'),
	('QL000205','列表0205','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0205','2019-10-24 08:37:47','UA000035','1'),
	('QL000206','列表0206','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0206','2019-11-05 07:19:51','UA000035','1'),
	('QL000207','列表0207','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0207','2019-10-27 11:50:06','UA000035','1'),
	('QL000208','列表0208','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0208','2019-10-30 09:08:20','UA000035','1'),
	('QL000209','列表0209','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0209','2019-11-05 18:50:54','UA000035','1'),
	('QL000210','列表0210','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0210','2019-10-23 20:23:27','UA000035','1'),
	('QL000211','列表0211','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0211','2019-10-17 01:35:16','UA000036','1'),
	('QL000212','列表0212','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0212','2019-11-07 07:48:36','UA000036','1'),
	('QL000213','列表0213','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0213','2019-10-24 15:34:48','UA000036','1'),
	('QL000214','列表0214','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0214','2019-11-05 02:08:07','UA000036','1'),
	('QL000215','列表0215','facebook','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0215','2019-10-24 01:06:12','UA000036','1'),
	('QL000216','列表0216','google','https://demo.doublechaintech.com/demodata/imageManager/genImage/y00/200/200/red/','列表0216','2019-11-04 12:55:21','UA000036','1');

insert into list_access_data values
	('LA000001','列表','levelOneCategoryList','1','1','1','1','1','UA000001','1'),
	('LA000002','列表0002','levelOneCategoryList0002','1','1','1','1','1','UA000001','1'),
	('LA000003','列表0003','levelOneCategoryList0003','1','1','1','1','1','UA000001','1'),
	('LA000004','列表0004','levelOneCategoryList0004','1','1','1','1','1','UA000001','1'),
	('LA000005','列表0005','levelOneCategoryList0005','1','1','1','1','1','UA000001','1'),
	('LA000006','列表0006','levelOneCategoryList0006','1','1','1','1','1','UA000001','1'),
	('LA000007','列表0007','levelOneCategoryList0007','1','1','1','1','1','UA000002','1'),
	('LA000008','列表0008','levelOneCategoryList0008','1','1','1','1','1','UA000002','1'),
	('LA000009','列表0009','levelOneCategoryList0009','1','1','1','1','1','UA000002','1'),
	('LA000010','列表0010','levelOneCategoryList0010','1','1','1','1','1','UA000002','1'),
	('LA000011','列表0011','levelOneCategoryList0011','1','1','1','1','1','UA000002','1'),
	('LA000012','列表0012','levelOneCategoryList0012','1','1','1','1','1','UA000002','1'),
	('LA000013','列表0013','levelOneCategoryList0013','1','1','1','1','1','UA000003','1'),
	('LA000014','列表0014','levelOneCategoryList0014','1','1','1','1','1','UA000003','1'),
	('LA000015','列表0015','levelOneCategoryList0015','1','1','1','1','1','UA000003','1'),
	('LA000016','列表0016','levelOneCategoryList0016','1','1','1','1','1','UA000003','1'),
	('LA000017','列表0017','levelOneCategoryList0017','1','1','1','1','1','UA000003','1'),
	('LA000018','列表0018','levelOneCategoryList0018','1','1','1','1','1','UA000003','1'),
	('LA000019','列表0019','levelOneCategoryList0019','1','1','1','1','1','UA000004','1'),
	('LA000020','列表0020','levelOneCategoryList0020','1','1','1','1','1','UA000004','1'),
	('LA000021','列表0021','levelOneCategoryList0021','1','1','1','1','1','UA000004','1'),
	('LA000022','列表0022','levelOneCategoryList0022','1','1','1','1','1','UA000004','1'),
	('LA000023','列表0023','levelOneCategoryList0023','1','1','1','1','1','UA000004','1'),
	('LA000024','列表0024','levelOneCategoryList0024','1','1','1','1','1','UA000004','1'),
	('LA000025','列表0025','levelOneCategoryList0025','1','1','1','1','1','UA000005','1'),
	('LA000026','列表0026','levelOneCategoryList0026','1','1','1','1','1','UA000005','1'),
	('LA000027','列表0027','levelOneCategoryList0027','1','1','1','1','1','UA000005','1'),
	('LA000028','列表0028','levelOneCategoryList0028','1','1','1','1','1','UA000005','1'),
	('LA000029','列表0029','levelOneCategoryList0029','1','1','1','1','1','UA000005','1'),
	('LA000030','列表0030','levelOneCategoryList0030','1','1','1','1','1','UA000005','1'),
	('LA000031','列表0031','levelOneCategoryList0031','1','1','1','1','1','UA000006','1'),
	('LA000032','列表0032','levelOneCategoryList0032','1','1','1','1','1','UA000006','1'),
	('LA000033','列表0033','levelOneCategoryList0033','1','1','1','1','1','UA000006','1'),
	('LA000034','列表0034','levelOneCategoryList0034','1','1','1','1','1','UA000006','1'),
	('LA000035','列表0035','levelOneCategoryList0035','1','1','1','1','1','UA000006','1'),
	('LA000036','列表0036','levelOneCategoryList0036','1','1','1','1','1','UA000006','1'),
	('LA000037','列表0037','levelOneCategoryList0037','1','1','1','1','1','UA000007','1'),
	('LA000038','列表0038','levelOneCategoryList0038','1','1','1','1','1','UA000007','1'),
	('LA000039','列表0039','levelOneCategoryList0039','1','1','1','1','1','UA000007','1'),
	('LA000040','列表0040','levelOneCategoryList0040','1','1','1','1','1','UA000007','1'),
	('LA000041','列表0041','levelOneCategoryList0041','1','1','1','1','1','UA000007','1'),
	('LA000042','列表0042','levelOneCategoryList0042','1','1','1','1','1','UA000007','1'),
	('LA000043','列表0043','levelOneCategoryList0043','1','1','1','1','1','UA000008','1'),
	('LA000044','列表0044','levelOneCategoryList0044','1','1','1','1','1','UA000008','1'),
	('LA000045','列表0045','levelOneCategoryList0045','1','1','1','1','1','UA000008','1'),
	('LA000046','列表0046','levelOneCategoryList0046','1','1','1','1','1','UA000008','1'),
	('LA000047','列表0047','levelOneCategoryList0047','1','1','1','1','1','UA000008','1'),
	('LA000048','列表0048','levelOneCategoryList0048','1','1','1','1','1','UA000008','1'),
	('LA000049','列表0049','levelOneCategoryList0049','1','1','1','1','1','UA000009','1'),
	('LA000050','列表0050','levelOneCategoryList0050','1','1','1','1','1','UA000009','1'),
	('LA000051','列表0051','levelOneCategoryList0051','1','1','1','1','1','UA000009','1'),
	('LA000052','列表0052','levelOneCategoryList0052','1','1','1','1','1','UA000009','1'),
	('LA000053','列表0053','levelOneCategoryList0053','1','1','1','1','1','UA000009','1'),
	('LA000054','列表0054','levelOneCategoryList0054','1','1','1','1','1','UA000009','1'),
	('LA000055','列表0055','levelOneCategoryList0055','1','1','1','1','1','UA000010','1'),
	('LA000056','列表0056','levelOneCategoryList0056','1','1','1','1','1','UA000010','1'),
	('LA000057','列表0057','levelOneCategoryList0057','1','1','1','1','1','UA000010','1'),
	('LA000058','列表0058','levelOneCategoryList0058','1','1','1','1','1','UA000010','1'),
	('LA000059','列表0059','levelOneCategoryList0059','1','1','1','1','1','UA000010','1'),
	('LA000060','列表0060','levelOneCategoryList0060','1','1','1','1','1','UA000010','1'),
	('LA000061','列表0061','levelOneCategoryList0061','1','1','1','1','1','UA000011','1'),
	('LA000062','列表0062','levelOneCategoryList0062','1','1','1','1','1','UA000011','1'),
	('LA000063','列表0063','levelOneCategoryList0063','1','1','1','1','1','UA000011','1'),
	('LA000064','列表0064','levelOneCategoryList0064','1','1','1','1','1','UA000011','1'),
	('LA000065','列表0065','levelOneCategoryList0065','1','1','1','1','1','UA000011','1'),
	('LA000066','列表0066','levelOneCategoryList0066','1','1','1','1','1','UA000011','1'),
	('LA000067','列表0067','levelOneCategoryList0067','1','1','1','1','1','UA000012','1'),
	('LA000068','列表0068','levelOneCategoryList0068','1','1','1','1','1','UA000012','1'),
	('LA000069','列表0069','levelOneCategoryList0069','1','1','1','1','1','UA000012','1'),
	('LA000070','列表0070','levelOneCategoryList0070','1','1','1','1','1','UA000012','1'),
	('LA000071','列表0071','levelOneCategoryList0071','1','1','1','1','1','UA000012','1'),
	('LA000072','列表0072','levelOneCategoryList0072','1','1','1','1','1','UA000012','1'),
	('LA000073','列表0073','levelOneCategoryList0073','1','1','1','1','1','UA000013','1'),
	('LA000074','列表0074','levelOneCategoryList0074','1','1','1','1','1','UA000013','1'),
	('LA000075','列表0075','levelOneCategoryList0075','1','1','1','1','1','UA000013','1'),
	('LA000076','列表0076','levelOneCategoryList0076','1','1','1','1','1','UA000013','1'),
	('LA000077','列表0077','levelOneCategoryList0077','1','1','1','1','1','UA000013','1'),
	('LA000078','列表0078','levelOneCategoryList0078','1','1','1','1','1','UA000013','1'),
	('LA000079','列表0079','levelOneCategoryList0079','1','1','1','1','1','UA000014','1'),
	('LA000080','列表0080','levelOneCategoryList0080','1','1','1','1','1','UA000014','1'),
	('LA000081','列表0081','levelOneCategoryList0081','1','1','1','1','1','UA000014','1'),
	('LA000082','列表0082','levelOneCategoryList0082','1','1','1','1','1','UA000014','1'),
	('LA000083','列表0083','levelOneCategoryList0083','1','1','1','1','1','UA000014','1'),
	('LA000084','列表0084','levelOneCategoryList0084','1','1','1','1','1','UA000014','1'),
	('LA000085','列表0085','levelOneCategoryList0085','1','1','1','1','1','UA000015','1'),
	('LA000086','列表0086','levelOneCategoryList0086','1','1','1','1','1','UA000015','1'),
	('LA000087','列表0087','levelOneCategoryList0087','1','1','1','1','1','UA000015','1'),
	('LA000088','列表0088','levelOneCategoryList0088','1','1','1','1','1','UA000015','1'),
	('LA000089','列表0089','levelOneCategoryList0089','1','1','1','1','1','UA000015','1'),
	('LA000090','列表0090','levelOneCategoryList0090','1','1','1','1','1','UA000015','1'),
	('LA000091','列表0091','levelOneCategoryList0091','1','1','1','1','1','UA000016','1'),
	('LA000092','列表0092','levelOneCategoryList0092','1','1','1','1','1','UA000016','1'),
	('LA000093','列表0093','levelOneCategoryList0093','1','1','1','1','1','UA000016','1'),
	('LA000094','列表0094','levelOneCategoryList0094','1','1','1','1','1','UA000016','1'),
	('LA000095','列表0095','levelOneCategoryList0095','1','1','1','1','1','UA000016','1'),
	('LA000096','列表0096','levelOneCategoryList0096','1','1','1','1','1','UA000016','1'),
	('LA000097','列表0097','levelOneCategoryList0097','1','1','1','1','1','UA000017','1'),
	('LA000098','列表0098','levelOneCategoryList0098','1','1','1','1','1','UA000017','1'),
	('LA000099','列表0099','levelOneCategoryList0099','1','1','1','1','1','UA000017','1'),
	('LA000100','列表0100','levelOneCategoryList0100','1','1','1','1','1','UA000017','1'),
	('LA000101','列表0101','levelOneCategoryList0101','1','1','1','1','1','UA000017','1'),
	('LA000102','列表0102','levelOneCategoryList0102','1','1','1','1','1','UA000017','1'),
	('LA000103','列表0103','levelOneCategoryList0103','1','1','1','1','1','UA000018','1'),
	('LA000104','列表0104','levelOneCategoryList0104','1','1','1','1','1','UA000018','1'),
	('LA000105','列表0105','levelOneCategoryList0105','1','1','1','1','1','UA000018','1'),
	('LA000106','列表0106','levelOneCategoryList0106','1','1','1','1','1','UA000018','1'),
	('LA000107','列表0107','levelOneCategoryList0107','1','1','1','1','1','UA000018','1'),
	('LA000108','列表0108','levelOneCategoryList0108','1','1','1','1','1','UA000018','1'),
	('LA000109','列表0109','levelOneCategoryList0109','1','1','1','1','1','UA000019','1'),
	('LA000110','列表0110','levelOneCategoryList0110','1','1','1','1','1','UA000019','1'),
	('LA000111','列表0111','levelOneCategoryList0111','1','1','1','1','1','UA000019','1'),
	('LA000112','列表0112','levelOneCategoryList0112','1','1','1','1','1','UA000019','1'),
	('LA000113','列表0113','levelOneCategoryList0113','1','1','1','1','1','UA000019','1'),
	('LA000114','列表0114','levelOneCategoryList0114','1','1','1','1','1','UA000019','1'),
	('LA000115','列表0115','levelOneCategoryList0115','1','1','1','1','1','UA000020','1'),
	('LA000116','列表0116','levelOneCategoryList0116','1','1','1','1','1','UA000020','1'),
	('LA000117','列表0117','levelOneCategoryList0117','1','1','1','1','1','UA000020','1'),
	('LA000118','列表0118','levelOneCategoryList0118','1','1','1','1','1','UA000020','1'),
	('LA000119','列表0119','levelOneCategoryList0119','1','1','1','1','1','UA000020','1'),
	('LA000120','列表0120','levelOneCategoryList0120','1','1','1','1','1','UA000020','1'),
	('LA000121','列表0121','levelOneCategoryList0121','1','1','1','1','1','UA000021','1'),
	('LA000122','列表0122','levelOneCategoryList0122','1','1','1','1','1','UA000021','1'),
	('LA000123','列表0123','levelOneCategoryList0123','1','1','1','1','1','UA000021','1'),
	('LA000124','列表0124','levelOneCategoryList0124','1','1','1','1','1','UA000021','1'),
	('LA000125','列表0125','levelOneCategoryList0125','1','1','1','1','1','UA000021','1'),
	('LA000126','列表0126','levelOneCategoryList0126','1','1','1','1','1','UA000021','1'),
	('LA000127','列表0127','levelOneCategoryList0127','1','1','1','1','1','UA000022','1'),
	('LA000128','列表0128','levelOneCategoryList0128','1','1','1','1','1','UA000022','1'),
	('LA000129','列表0129','levelOneCategoryList0129','1','1','1','1','1','UA000022','1'),
	('LA000130','列表0130','levelOneCategoryList0130','1','1','1','1','1','UA000022','1'),
	('LA000131','列表0131','levelOneCategoryList0131','1','1','1','1','1','UA000022','1'),
	('LA000132','列表0132','levelOneCategoryList0132','1','1','1','1','1','UA000022','1'),
	('LA000133','列表0133','levelOneCategoryList0133','1','1','1','1','1','UA000023','1'),
	('LA000134','列表0134','levelOneCategoryList0134','1','1','1','1','1','UA000023','1'),
	('LA000135','列表0135','levelOneCategoryList0135','1','1','1','1','1','UA000023','1'),
	('LA000136','列表0136','levelOneCategoryList0136','1','1','1','1','1','UA000023','1'),
	('LA000137','列表0137','levelOneCategoryList0137','1','1','1','1','1','UA000023','1'),
	('LA000138','列表0138','levelOneCategoryList0138','1','1','1','1','1','UA000023','1'),
	('LA000139','列表0139','levelOneCategoryList0139','1','1','1','1','1','UA000024','1'),
	('LA000140','列表0140','levelOneCategoryList0140','1','1','1','1','1','UA000024','1'),
	('LA000141','列表0141','levelOneCategoryList0141','1','1','1','1','1','UA000024','1'),
	('LA000142','列表0142','levelOneCategoryList0142','1','1','1','1','1','UA000024','1'),
	('LA000143','列表0143','levelOneCategoryList0143','1','1','1','1','1','UA000024','1'),
	('LA000144','列表0144','levelOneCategoryList0144','1','1','1','1','1','UA000024','1'),
	('LA000145','列表0145','levelOneCategoryList0145','1','1','1','1','1','UA000025','1'),
	('LA000146','列表0146','levelOneCategoryList0146','1','1','1','1','1','UA000025','1'),
	('LA000147','列表0147','levelOneCategoryList0147','1','1','1','1','1','UA000025','1'),
	('LA000148','列表0148','levelOneCategoryList0148','1','1','1','1','1','UA000025','1'),
	('LA000149','列表0149','levelOneCategoryList0149','1','1','1','1','1','UA000025','1'),
	('LA000150','列表0150','levelOneCategoryList0150','1','1','1','1','1','UA000025','1'),
	('LA000151','列表0151','levelOneCategoryList0151','1','1','1','1','1','UA000026','1'),
	('LA000152','列表0152','levelOneCategoryList0152','1','1','1','1','1','UA000026','1'),
	('LA000153','列表0153','levelOneCategoryList0153','1','1','1','1','1','UA000026','1'),
	('LA000154','列表0154','levelOneCategoryList0154','1','1','1','1','1','UA000026','1'),
	('LA000155','列表0155','levelOneCategoryList0155','1','1','1','1','1','UA000026','1'),
	('LA000156','列表0156','levelOneCategoryList0156','1','1','1','1','1','UA000026','1'),
	('LA000157','列表0157','levelOneCategoryList0157','1','1','1','1','1','UA000027','1'),
	('LA000158','列表0158','levelOneCategoryList0158','1','1','1','1','1','UA000027','1'),
	('LA000159','列表0159','levelOneCategoryList0159','1','1','1','1','1','UA000027','1'),
	('LA000160','列表0160','levelOneCategoryList0160','1','1','1','1','1','UA000027','1'),
	('LA000161','列表0161','levelOneCategoryList0161','1','1','1','1','1','UA000027','1'),
	('LA000162','列表0162','levelOneCategoryList0162','1','1','1','1','1','UA000027','1'),
	('LA000163','列表0163','levelOneCategoryList0163','1','1','1','1','1','UA000028','1'),
	('LA000164','列表0164','levelOneCategoryList0164','1','1','1','1','1','UA000028','1'),
	('LA000165','列表0165','levelOneCategoryList0165','1','1','1','1','1','UA000028','1'),
	('LA000166','列表0166','levelOneCategoryList0166','1','1','1','1','1','UA000028','1'),
	('LA000167','列表0167','levelOneCategoryList0167','1','1','1','1','1','UA000028','1'),
	('LA000168','列表0168','levelOneCategoryList0168','1','1','1','1','1','UA000028','1'),
	('LA000169','列表0169','levelOneCategoryList0169','1','1','1','1','1','UA000029','1'),
	('LA000170','列表0170','levelOneCategoryList0170','1','1','1','1','1','UA000029','1'),
	('LA000171','列表0171','levelOneCategoryList0171','1','1','1','1','1','UA000029','1'),
	('LA000172','列表0172','levelOneCategoryList0172','1','1','1','1','1','UA000029','1'),
	('LA000173','列表0173','levelOneCategoryList0173','1','1','1','1','1','UA000029','1'),
	('LA000174','列表0174','levelOneCategoryList0174','1','1','1','1','1','UA000029','1'),
	('LA000175','列表0175','levelOneCategoryList0175','1','1','1','1','1','UA000030','1'),
	('LA000176','列表0176','levelOneCategoryList0176','1','1','1','1','1','UA000030','1'),
	('LA000177','列表0177','levelOneCategoryList0177','1','1','1','1','1','UA000030','1'),
	('LA000178','列表0178','levelOneCategoryList0178','1','1','1','1','1','UA000030','1'),
	('LA000179','列表0179','levelOneCategoryList0179','1','1','1','1','1','UA000030','1'),
	('LA000180','列表0180','levelOneCategoryList0180','1','1','1','1','1','UA000030','1'),
	('LA000181','列表0181','levelOneCategoryList0181','1','1','1','1','1','UA000031','1'),
	('LA000182','列表0182','levelOneCategoryList0182','1','1','1','1','1','UA000031','1'),
	('LA000183','列表0183','levelOneCategoryList0183','1','1','1','1','1','UA000031','1'),
	('LA000184','列表0184','levelOneCategoryList0184','1','1','1','1','1','UA000031','1'),
	('LA000185','列表0185','levelOneCategoryList0185','1','1','1','1','1','UA000031','1'),
	('LA000186','列表0186','levelOneCategoryList0186','1','1','1','1','1','UA000031','1'),
	('LA000187','列表0187','levelOneCategoryList0187','1','1','1','1','1','UA000032','1'),
	('LA000188','列表0188','levelOneCategoryList0188','1','1','1','1','1','UA000032','1'),
	('LA000189','列表0189','levelOneCategoryList0189','1','1','1','1','1','UA000032','1'),
	('LA000190','列表0190','levelOneCategoryList0190','1','1','1','1','1','UA000032','1'),
	('LA000191','列表0191','levelOneCategoryList0191','1','1','1','1','1','UA000032','1'),
	('LA000192','列表0192','levelOneCategoryList0192','1','1','1','1','1','UA000032','1'),
	('LA000193','列表0193','levelOneCategoryList0193','1','1','1','1','1','UA000033','1'),
	('LA000194','列表0194','levelOneCategoryList0194','1','1','1','1','1','UA000033','1'),
	('LA000195','列表0195','levelOneCategoryList0195','1','1','1','1','1','UA000033','1'),
	('LA000196','列表0196','levelOneCategoryList0196','1','1','1','1','1','UA000033','1'),
	('LA000197','列表0197','levelOneCategoryList0197','1','1','1','1','1','UA000033','1'),
	('LA000198','列表0198','levelOneCategoryList0198','1','1','1','1','1','UA000033','1'),
	('LA000199','列表0199','levelOneCategoryList0199','1','1','1','1','1','UA000034','1'),
	('LA000200','列表0200','levelOneCategoryList0200','1','1','1','1','1','UA000034','1'),
	('LA000201','列表0201','levelOneCategoryList0201','1','1','1','1','1','UA000034','1'),
	('LA000202','列表0202','levelOneCategoryList0202','1','1','1','1','1','UA000034','1'),
	('LA000203','列表0203','levelOneCategoryList0203','1','1','1','1','1','UA000034','1'),
	('LA000204','列表0204','levelOneCategoryList0204','1','1','1','1','1','UA000034','1'),
	('LA000205','列表0205','levelOneCategoryList0205','1','1','1','1','1','UA000035','1'),
	('LA000206','列表0206','levelOneCategoryList0206','1','1','1','1','1','UA000035','1'),
	('LA000207','列表0207','levelOneCategoryList0207','1','1','1','1','1','UA000035','1'),
	('LA000208','列表0208','levelOneCategoryList0208','1','1','1','1','1','UA000035','1'),
	('LA000209','列表0209','levelOneCategoryList0209','1','1','1','1','1','UA000035','1'),
	('LA000210','列表0210','levelOneCategoryList0210','1','1','1','1','1','UA000035','1'),
	('LA000211','列表0211','levelOneCategoryList0211','1','1','1','1','1','UA000036','1'),
	('LA000212','列表0212','levelOneCategoryList0212','1','1','1','1','1','UA000036','1'),
	('LA000213','列表0213','levelOneCategoryList0213','1','1','1','1','1','UA000036','1'),
	('LA000214','列表0214','levelOneCategoryList0214','1','1','1','1','1','UA000036','1'),
	('LA000215','列表0215','levelOneCategoryList0215','1','1','1','1','1','UA000036','1'),
	('LA000216','列表0216','levelOneCategoryList0216','1','1','1','1','1','UA000036','1');

insert into object_access_data values
	('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1'),
	('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1'),
	('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1'),
	('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1'),
	('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1'),
	('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1'),
	('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1'),
	('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1'),
	('OA000009','控制访问列表10009','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1'),
	('OA000010','控制访问列表10010','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1'),
	('OA000011','控制访问列表10011','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1'),
	('OA000012','控制访问列表10012','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1'),
	('OA000013','控制访问列表10013','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1'),
	('OA000014','控制访问列表10014','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1'),
	('OA000015','控制访问列表10015','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1'),
	('OA000016','控制访问列表10016','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1'),
	('OA000017','控制访问列表10017','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1'),
	('OA000018','控制访问列表10018','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1'),
	('OA000019','控制访问列表10019','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1'),
	('OA000020','控制访问列表10020','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1'),
	('OA000021','控制访问列表10021','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1'),
	('OA000022','控制访问列表10022','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1'),
	('OA000023','控制访问列表10023','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1'),
	('OA000024','控制访问列表10024','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1'),
	('OA000025','控制访问列表10025','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1'),
	('OA000026','控制访问列表10026','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000005','1'),
	('OA000027','控制访问列表10027','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1'),
	('OA000028','控制访问列表10028','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000005','1'),
	('OA000029','控制访问列表10029','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1'),
	('OA000030','控制访问列表10030','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000005','1'),
	('OA000031','控制访问列表10031','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000006','1'),
	('OA000032','控制访问列表10032','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1'),
	('OA000033','控制访问列表10033','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000006','1'),
	('OA000034','控制访问列表10034','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1'),
	('OA000035','控制访问列表10035','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000006','1'),
	('OA000036','控制访问列表10036','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1'),
	('OA000037','控制访问列表10037','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1'),
	('OA000038','控制访问列表10038','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000007','1'),
	('OA000039','控制访问列表10039','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1'),
	('OA000040','控制访问列表10040','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000007','1'),
	('OA000041','控制访问列表10041','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1'),
	('OA000042','控制访问列表10042','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000007','1'),
	('OA000043','控制访问列表10043','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000008','1'),
	('OA000044','控制访问列表10044','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1'),
	('OA000045','控制访问列表10045','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000008','1'),
	('OA000046','控制访问列表10046','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1'),
	('OA000047','控制访问列表10047','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000008','1'),
	('OA000048','控制访问列表10048','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1'),
	('OA000049','控制访问列表10049','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1'),
	('OA000050','控制访问列表10050','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000009','1'),
	('OA000051','控制访问列表10051','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1'),
	('OA000052','控制访问列表10052','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000009','1'),
	('OA000053','控制访问列表10053','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1'),
	('OA000054','控制访问列表10054','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000009','1'),
	('OA000055','控制访问列表10055','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000010','1'),
	('OA000056','控制访问列表10056','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1'),
	('OA000057','控制访问列表10057','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000010','1'),
	('OA000058','控制访问列表10058','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1'),
	('OA000059','控制访问列表10059','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000010','1'),
	('OA000060','控制访问列表10060','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1'),
	('OA000061','控制访问列表10061','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1'),
	('OA000062','控制访问列表10062','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000011','1'),
	('OA000063','控制访问列表10063','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1'),
	('OA000064','控制访问列表10064','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000011','1'),
	('OA000065','控制访问列表10065','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1'),
	('OA000066','控制访问列表10066','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000011','1'),
	('OA000067','控制访问列表10067','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000012','1'),
	('OA000068','控制访问列表10068','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1'),
	('OA000069','控制访问列表10069','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000012','1'),
	('OA000070','控制访问列表10070','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1'),
	('OA000071','控制访问列表10071','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000012','1'),
	('OA000072','控制访问列表10072','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1'),
	('OA000073','控制访问列表10073','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1'),
	('OA000074','控制访问列表10074','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000013','1'),
	('OA000075','控制访问列表10075','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1'),
	('OA000076','控制访问列表10076','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000013','1'),
	('OA000077','控制访问列表10077','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1'),
	('OA000078','控制访问列表10078','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000013','1'),
	('OA000079','控制访问列表10079','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000014','1'),
	('OA000080','控制访问列表10080','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1'),
	('OA000081','控制访问列表10081','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000014','1'),
	('OA000082','控制访问列表10082','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1'),
	('OA000083','控制访问列表10083','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000014','1'),
	('OA000084','控制访问列表10084','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1'),
	('OA000085','控制访问列表10085','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1'),
	('OA000086','控制访问列表10086','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000015','1'),
	('OA000087','控制访问列表10087','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1'),
	('OA000088','控制访问列表10088','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000015','1'),
	('OA000089','控制访问列表10089','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1'),
	('OA000090','控制访问列表10090','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000015','1'),
	('OA000091','控制访问列表10091','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000016','1'),
	('OA000092','控制访问列表10092','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1'),
	('OA000093','控制访问列表10093','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000016','1'),
	('OA000094','控制访问列表10094','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1'),
	('OA000095','控制访问列表10095','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000016','1'),
	('OA000096','控制访问列表10096','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1'),
	('OA000097','控制访问列表10097','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1'),
	('OA000098','控制访问列表10098','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000017','1'),
	('OA000099','控制访问列表10099','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1'),
	('OA000100','控制访问列表10100','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000017','1'),
	('OA000101','控制访问列表10101','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1'),
	('OA000102','控制访问列表10102','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000017','1'),
	('OA000103','控制访问列表10103','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000018','1'),
	('OA000104','控制访问列表10104','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1'),
	('OA000105','控制访问列表10105','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000018','1'),
	('OA000106','控制访问列表10106','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1'),
	('OA000107','控制访问列表10107','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000018','1'),
	('OA000108','控制访问列表10108','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1'),
	('OA000109','控制访问列表10109','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1'),
	('OA000110','控制访问列表10110','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000019','1'),
	('OA000111','控制访问列表10111','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1'),
	('OA000112','控制访问列表10112','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000019','1'),
	('OA000113','控制访问列表10113','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1'),
	('OA000114','控制访问列表10114','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000019','1'),
	('OA000115','控制访问列表10115','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000020','1'),
	('OA000116','控制访问列表10116','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1'),
	('OA000117','控制访问列表10117','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000020','1'),
	('OA000118','控制访问列表10118','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1'),
	('OA000119','控制访问列表10119','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000020','1'),
	('OA000120','控制访问列表10120','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1'),
	('OA000121','控制访问列表10121','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1'),
	('OA000122','控制访问列表10122','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000021','1'),
	('OA000123','控制访问列表10123','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1'),
	('OA000124','控制访问列表10124','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000021','1'),
	('OA000125','控制访问列表10125','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1'),
	('OA000126','控制访问列表10126','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000021','1'),
	('OA000127','控制访问列表10127','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000022','1'),
	('OA000128','控制访问列表10128','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1'),
	('OA000129','控制访问列表10129','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000022','1'),
	('OA000130','控制访问列表10130','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1'),
	('OA000131','控制访问列表10131','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000022','1'),
	('OA000132','控制访问列表10132','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1'),
	('OA000133','控制访问列表10133','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1'),
	('OA000134','控制访问列表10134','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000023','1'),
	('OA000135','控制访问列表10135','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1'),
	('OA000136','控制访问列表10136','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000023','1'),
	('OA000137','控制访问列表10137','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1'),
	('OA000138','控制访问列表10138','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000023','1'),
	('OA000139','控制访问列表10139','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000024','1'),
	('OA000140','控制访问列表10140','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1'),
	('OA000141','控制访问列表10141','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000024','1'),
	('OA000142','控制访问列表10142','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1'),
	('OA000143','控制访问列表10143','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000024','1'),
	('OA000144','控制访问列表10144','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1'),
	('OA000145','控制访问列表10145','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1'),
	('OA000146','控制访问列表10146','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000025','1'),
	('OA000147','控制访问列表10147','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1'),
	('OA000148','控制访问列表10148','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000025','1'),
	('OA000149','控制访问列表10149','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1'),
	('OA000150','控制访问列表10150','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000025','1'),
	('OA000151','控制访问列表10151','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000026','1'),
	('OA000152','控制访问列表10152','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000026','1'),
	('OA000153','控制访问列表10153','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000026','1'),
	('OA000154','控制访问列表10154','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000026','1'),
	('OA000155','控制访问列表10155','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000026','1'),
	('OA000156','控制访问列表10156','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000026','1'),
	('OA000157','控制访问列表10157','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000027','1'),
	('OA000158','控制访问列表10158','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000027','1'),
	('OA000159','控制访问列表10159','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000027','1'),
	('OA000160','控制访问列表10160','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000027','1'),
	('OA000161','控制访问列表10161','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000027','1'),
	('OA000162','控制访问列表10162','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000027','1'),
	('OA000163','控制访问列表10163','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000028','1'),
	('OA000164','控制访问列表10164','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000028','1'),
	('OA000165','控制访问列表10165','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000028','1'),
	('OA000166','控制访问列表10166','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000028','1'),
	('OA000167','控制访问列表10167','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000028','1'),
	('OA000168','控制访问列表10168','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000028','1'),
	('OA000169','控制访问列表10169','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000029','1'),
	('OA000170','控制访问列表10170','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000029','1'),
	('OA000171','控制访问列表10171','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000029','1'),
	('OA000172','控制访问列表10172','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000029','1'),
	('OA000173','控制访问列表10173','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000029','1'),
	('OA000174','控制访问列表10174','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000029','1'),
	('OA000175','控制访问列表10175','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000030','1'),
	('OA000176','控制访问列表10176','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000030','1'),
	('OA000177','控制访问列表10177','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000030','1'),
	('OA000178','控制访问列表10178','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000030','1'),
	('OA000179','控制访问列表10179','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000030','1'),
	('OA000180','控制访问列表10180','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000030','1'),
	('OA000181','控制访问列表10181','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000031','1'),
	('OA000182','控制访问列表10182','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000031','1'),
	('OA000183','控制访问列表10183','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000031','1'),
	('OA000184','控制访问列表10184','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000031','1'),
	('OA000185','控制访问列表10185','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000031','1'),
	('OA000186','控制访问列表10186','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000031','1'),
	('OA000187','控制访问列表10187','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000032','1'),
	('OA000188','控制访问列表10188','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000032','1'),
	('OA000189','控制访问列表10189','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000032','1'),
	('OA000190','控制访问列表10190','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000032','1'),
	('OA000191','控制访问列表10191','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000032','1'),
	('OA000192','控制访问列表10192','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000032','1'),
	('OA000193','控制访问列表10193','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000033','1'),
	('OA000194','控制访问列表10194','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000033','1'),
	('OA000195','控制访问列表10195','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000033','1'),
	('OA000196','控制访问列表10196','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000033','1'),
	('OA000197','控制访问列表10197','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000033','1'),
	('OA000198','控制访问列表10198','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000033','1'),
	('OA000199','控制访问列表10199','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000034','1'),
	('OA000200','控制访问列表10200','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000034','1'),
	('OA000201','控制访问列表10201','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000034','1'),
	('OA000202','控制访问列表10202','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000034','1'),
	('OA000203','控制访问列表10203','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000034','1'),
	('OA000204','控制访问列表10204','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000034','1'),
	('OA000205','控制访问列表10205','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000035','1'),
	('OA000206','控制访问列表10206','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000035','1'),
	('OA000207','控制访问列表10207','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000035','1'),
	('OA000208','控制访问列表10208','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000035','1'),
	('OA000209','控制访问列表10209','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000035','1'),
	('OA000210','控制访问列表10210','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000035','1'),
	('OA000211','控制访问列表10211','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000036','1'),
	('OA000212','控制访问列表10212','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000036','1'),
	('OA000213','控制访问列表10213','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000036','1'),
	('OA000214','控制访问列表10214','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000036','1'),
	('OA000215','控制访问列表10215','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000036','1'),
	('OA000216','控制访问列表10216','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000036','1');

insert into login_history_data values
	('LH000001','2019-10-19 08:05:24','192.168.1.1','登陆成功','SU000001','1'),
	('LH000002','2019-11-03 18:29:40','192.168.1.2','登陆成功0002','SU000001','1'),
	('LH000003','2019-11-05 07:32:14','192.168.1.1','登陆成功0003','SU000001','1'),
	('LH000004','2019-10-17 16:06:37','192.168.1.2','登陆成功0004','SU000001','1'),
	('LH000005','2019-10-29 14:48:03','192.168.1.1','登陆成功0005','SU000001','1'),
	('LH000006','2019-11-06 16:49:07','192.168.1.2','登陆成功0006','SU000001','1'),
	('LH000007','2019-11-06 03:25:54','192.168.1.1','登陆成功0007','SU000002','1'),
	('LH000008','2019-11-03 15:11:05','192.168.1.2','登陆成功0008','SU000002','1'),
	('LH000009','2019-11-03 02:30:21','192.168.1.1','登陆成功0009','SU000002','1'),
	('LH000010','2019-10-20 22:54:41','192.168.1.2','登陆成功0010','SU000002','1'),
	('LH000011','2019-10-19 03:25:13','192.168.1.1','登陆成功0011','SU000002','1'),
	('LH000012','2019-10-21 11:31:31','192.168.1.2','登陆成功0012','SU000002','1'),
	('LH000013','2019-10-23 14:13:55','192.168.1.1','登陆成功0013','SU000003','1'),
	('LH000014','2019-10-28 15:01:34','192.168.1.2','登陆成功0014','SU000003','1'),
	('LH000015','2019-10-29 22:08:06','192.168.1.1','登陆成功0015','SU000003','1'),
	('LH000016','2019-11-05 09:28:59','192.168.1.2','登陆成功0016','SU000003','1'),
	('LH000017','2019-10-17 17:37:37','192.168.1.1','登陆成功0017','SU000003','1'),
	('LH000018','2019-10-26 05:07:32','192.168.1.2','登陆成功0018','SU000003','1'),
	('LH000019','2019-10-25 03:00:32','192.168.1.1','登陆成功0019','SU000004','1'),
	('LH000020','2019-10-17 14:54:35','192.168.1.2','登陆成功0020','SU000004','1'),
	('LH000021','2019-11-05 04:47:24','192.168.1.1','登陆成功0021','SU000004','1'),
	('LH000022','2019-10-23 16:59:24','192.168.1.2','登陆成功0022','SU000004','1'),
	('LH000023','2019-10-25 16:01:36','192.168.1.1','登陆成功0023','SU000004','1'),
	('LH000024','2019-11-06 13:24:57','192.168.1.2','登陆成功0024','SU000004','1'),
	('LH000025','2019-10-16 22:44:23','192.168.1.1','登陆成功0025','SU000005','1'),
	('LH000026','2019-10-19 13:51:03','192.168.1.2','登陆成功0026','SU000005','1'),
	('LH000027','2019-11-03 22:27:46','192.168.1.1','登陆成功0027','SU000005','1'),
	('LH000028','2019-10-17 10:16:18','192.168.1.2','登陆成功0028','SU000005','1'),
	('LH000029','2019-11-06 20:00:14','192.168.1.1','登陆成功0029','SU000005','1'),
	('LH000030','2019-11-03 10:21:27','192.168.1.2','登陆成功0030','SU000005','1'),
	('LH000031','2019-10-25 15:26:25','192.168.1.1','登陆成功0031','SU000006','1'),
	('LH000032','2019-10-29 05:48:30','192.168.1.2','登陆成功0032','SU000006','1'),
	('LH000033','2019-10-29 01:31:56','192.168.1.1','登陆成功0033','SU000006','1'),
	('LH000034','2019-10-22 09:38:03','192.168.1.2','登陆成功0034','SU000006','1'),
	('LH000035','2019-11-01 19:59:35','192.168.1.1','登陆成功0035','SU000006','1'),
	('LH000036','2019-10-24 16:19:46','192.168.1.2','登陆成功0036','SU000006','1');

insert into generic_form_data values
	('GF000001','登记输入单','姓名就是你身份证上的名字','1');

insert into form_message_data values
	('FM000001','字段组合错误','GF000001','success','1'),
	('FM000002','字段组合错误0002','GF000001','info','1'),
	('FM000003','字段组合错误0003','GF000001','warning','1'),
	('FM000004','字段组合错误0004','GF000001','danger','1'),
	('FM000005','字段组合错误0005','GF000001','success','1'),
	('FM000006','字段组合错误0006','GF000001','info','1');

insert into form_field_message_data values
	('FFM000001','输入错误','name','GF000001','success','1'),
	('FFM000002','输入错误0002','name0002','GF000001','info','1'),
	('FFM000003','输入错误0003','name0003','GF000001','warning','1'),
	('FFM000004','输入错误0004','name0004','GF000001','danger','1'),
	('FFM000005','输入错误0005','name0005','GF000001','success','1'),
	('FFM000006','输入错误0006','name0006','GF000001','info','1');

insert into form_field_data values
	('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression','1','1','1','','','1'),
	('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002','1','1','1','','','1'),
	('FF000003','出生地','birth_place','name0003','date','GF000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003','1','1','1','','','1'),
	('FF000004','国籍','country','name0004','date_time','GF000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004','1','1','1','男,女','男,女','1'),
	('FF000005','姓名','name','name0005','money','GF000001','姓名就是你身份证上的名字0005','李一一0005','姓名就是你身份证上的名字0005','基础信息','maybe any value0005','a value expression0005','1','1','1','高,矮','高,矮','1'),
	('FF000006','年龄','age','name0006','url','GF000001','姓名就是你身份证上的名字0006','李一一0006','姓名就是你身份证上的名字0006','扩展信息','maybe any value0006','a value expression0006','1','1','1','','','1');

insert into form_action_data values
	('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1'),
	('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1'),
	('FA000003','功能0003','name0003','remove','danger','genericFormManager/name/name0002/name0003/0003','GF000001','1'),
	('FA000004','功能0004','name0004','save','primary','genericFormManager/name/name0002/name0003/0004','GF000001','1'),
	('FA000005','功能0005','name0005','update','default','genericFormManager/name/name0002/name0003/0005','GF000001','1'),
	('FA000006','功能0006','name0006','remove','warning','genericFormManager/name/name0002/name0003/0006','GF000001','1');

insert into candidate_container_data values
	('CC000001','我只是一个容器','1');

insert into candidate_element_data values
	('CE000001','搜索到的匹配字段','类型描述','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1'),
	('CE000002','搜索到的匹配字段0002','类型描述0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1'),
	('CE000003','搜索到的匹配字段0003','类型描述0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1'),
	('CE000004','搜索到的匹配字段0004','类型描述0004','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1'),
	('CE000005','搜索到的匹配字段0005','类型描述0005','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1'),
	('CE000006','搜索到的匹配字段0006','类型描述0006','https://demo.doublechaintech.com/demodata/imageManager/genImage/100/400/200/grey/','CC000001','1');



-- Mysql innodb's foreign key has index automatically 
create unique index idx4id_ver_of_platform on platform_data (id, version);

create unique index idx4id_ver_of_change_request_type on change_request_type_data (id, version);
create unique index idx4code_of_change_request_type on change_request_type_data (code);
create  index idx4display_order_of_change_request_type on change_request_type_data (display_order);

create unique index idx4id_ver_of_change_request on change_request_data (id, version);
create  index idx4create_time_of_change_request on change_request_data (create_time);

create unique index idx4id_ver_of_registration on registration_data (id, version);

create unique index idx4id_ver_of_start_exam on start_exam_data (id, version);

create unique index idx4id_ver_of_answer_question on answer_question_data (id, version);

create unique index idx4id_ver_of_exam_status on exam_status_data (id, version);
create unique index idx4code_of_exam_status on exam_status_data (code);

create unique index idx4id_ver_of_question on question_data (id, version);

create unique index idx4id_ver_of_exam_ranking on exam_ranking_data (id, version);

create unique index idx4id_ver_of_answer on answer_data (id, version);

create unique index idx4id_ver_of_wechat_user on wechat_user_data (id, version);
create  index idx4create_time_of_wechat_user on wechat_user_data (create_time);

create unique index idx4id_ver_of_wechat_login_info on wechat_login_info_data (id, version);
create  index idx4app_id_of_wechat_login_info on wechat_login_info_data (app_id);
create  index idx4open_id_of_wechat_login_info on wechat_login_info_data (open_id);
create  index idx4last_update_time_of_wechat_login_info on wechat_login_info_data (last_update_time);

create unique index idx4id_ver_of_exam on exam_data (id, version);
create  index idx4create_time_of_exam on exam_data (create_time);
create  index idx4score_of_exam on exam_data (score);

create unique index idx4id_ver_of_user_answer on user_answer_data (id, version);

create unique index idx4id_ver_of_fault_answer on fault_answer_data (id, version);
create  index idx4create_time_of_fault_answer on fault_answer_data (create_time);

create unique index idx4id_ver_of_user_domain on user_domain_data (id, version);

create unique index idx4id_ver_of_user_white_list on user_white_list_data (id, version);

create unique index idx4id_ver_of_sec_user on sec_user_data (id, version);
create unique index idx4login_of_sec_user on sec_user_data (login);
create unique index idx4email_of_sec_user on sec_user_data (email);
create unique index idx4mobile_of_sec_user on sec_user_data (mobile);
create  index idx4verification_code_of_sec_user on sec_user_data (verification_code);
create  index idx4verification_code_expire_of_sec_user on sec_user_data (verification_code_expire);
create  index idx4last_login_time_of_sec_user on sec_user_data (last_login_time);

create unique index idx4id_ver_of_sec_user_blocking on sec_user_blocking_data (id, version);
create  index idx4block_time_of_sec_user_blocking on sec_user_blocking_data (block_time);

create unique index idx4id_ver_of_user_app on user_app_data (id, version);
create  index idx4object_id_of_user_app on user_app_data (object_id);

create unique index idx4id_ver_of_quick_link on quick_link_data (id, version);
create  index idx4create_time_of_quick_link on quick_link_data (create_time);

create unique index idx4id_ver_of_list_access on list_access_data (id, version);

create unique index idx4id_ver_of_object_access on object_access_data (id, version);

create unique index idx4id_ver_of_login_history on login_history_data (id, version);
create  index idx4login_time_of_login_history on login_history_data (login_time);

create unique index idx4id_ver_of_generic_form on generic_form_data (id, version);

create unique index idx4id_ver_of_form_message on form_message_data (id, version);

create unique index idx4id_ver_of_form_field_message on form_field_message_data (id, version);

create unique index idx4id_ver_of_form_field on form_field_data (id, version);

create unique index idx4id_ver_of_form_action on form_action_data (id, version);

create unique index idx4id_ver_of_candidate_container on candidate_container_data (id, version);

create unique index idx4id_ver_of_candidate_element on candidate_element_data (id, version);
alter table platform_data add constraint pk4id_of_platform_data primary key (id);

alter table change_request_type_data add constraint pk4id_of_change_request_type_data primary key (id);
alter table change_request_type_data add constraint 
	fk4platform_of_change_request_type_data foreign key (platform) references platform_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table change_request_data add constraint pk4id_of_change_request_data primary key (id);
alter table change_request_data add constraint 
	fk4request_type_of_change_request_data foreign key (request_type) references change_request_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table change_request_data add constraint 
	fk4platform_of_change_request_data foreign key (platform) references platform_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table registration_data add constraint pk4id_of_registration_data primary key (id);
alter table registration_data add constraint 
	fk4change_request_of_registration_data foreign key (change_request) references change_request_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table start_exam_data add constraint pk4id_of_start_exam_data primary key (id);
alter table start_exam_data add constraint 
	fk4change_request_of_start_exam_data foreign key (change_request) references change_request_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table answer_question_data add constraint pk4id_of_answer_question_data primary key (id);
alter table answer_question_data add constraint 
	fk4user_of_answer_question_data foreign key (user) references wechat_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table answer_question_data add constraint 
	fk4question_of_answer_question_data foreign key (question) references question_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table answer_question_data add constraint 
	fk4change_request_of_answer_question_data foreign key (change_request) references change_request_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table exam_status_data add constraint pk4id_of_exam_status_data primary key (id);
alter table exam_status_data add constraint 
	fk4platform_of_exam_status_data foreign key (platform) references platform_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table question_data add constraint pk4id_of_question_data primary key (id);
alter table question_data add constraint 
	fk4platform_of_question_data foreign key (platform) references platform_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table exam_ranking_data add constraint pk4id_of_exam_ranking_data primary key (id);
alter table exam_ranking_data add constraint 
	fk4platform_of_exam_ranking_data foreign key (platform) references platform_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table answer_data add constraint pk4id_of_answer_data primary key (id);
alter table answer_data add constraint 
	fk4question_of_answer_data foreign key (question) references question_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table wechat_user_data add constraint pk4id_of_wechat_user_data primary key (id);
alter table wechat_user_data add constraint 
	fk4platform_of_wechat_user_data foreign key (platform) references platform_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table wechat_login_info_data add constraint pk4id_of_wechat_login_info_data primary key (id);
alter table wechat_login_info_data add constraint 
	fk4wechat_user_of_wechat_login_info_data foreign key (wechat_user) references wechat_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table exam_data add constraint pk4id_of_exam_data primary key (id);
alter table exam_data add constraint 
	fk4status_of_exam_data foreign key (status) references exam_status_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table exam_data add constraint 
	fk4user_of_exam_data foreign key (user) references wechat_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user_answer_data add constraint pk4id_of_user_answer_data primary key (id);
alter table user_answer_data add constraint 
	fk4question_of_user_answer_data foreign key (question) references question_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table user_answer_data add constraint 
	fk4exam_of_user_answer_data foreign key (exam) references exam_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table fault_answer_data add constraint pk4id_of_fault_answer_data primary key (id);
alter table fault_answer_data add constraint 
	fk4user_of_fault_answer_data foreign key (user) references wechat_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table fault_answer_data add constraint 
	fk4exam_of_fault_answer_data foreign key (exam) references exam_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user_domain_data add constraint pk4id_of_user_domain_data primary key (id);

alter table user_white_list_data add constraint pk4id_of_user_white_list_data primary key (id);
alter table user_white_list_data add constraint 
	fk4domain_of_user_white_list_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table sec_user_data add constraint pk4id_of_sec_user_data primary key (id);
alter table sec_user_data add constraint 
	fk4domain_of_sec_user_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table sec_user_blocking_data add constraint pk4id_of_sec_user_blocking_data primary key (id);

alter table user_app_data add constraint pk4id_of_user_app_data primary key (id);
alter table user_app_data add constraint 
	fk4sec_user_of_user_app_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table quick_link_data add constraint pk4id_of_quick_link_data primary key (id);
alter table quick_link_data add constraint 
	fk4app_of_quick_link_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table list_access_data add constraint pk4id_of_list_access_data primary key (id);
alter table list_access_data add constraint 
	fk4app_of_list_access_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table object_access_data add constraint pk4id_of_object_access_data primary key (id);
alter table object_access_data add constraint 
	fk4app_of_object_access_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table login_history_data add constraint pk4id_of_login_history_data primary key (id);
alter table login_history_data add constraint 
	fk4sec_user_of_login_history_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table generic_form_data add constraint pk4id_of_generic_form_data primary key (id);

alter table form_message_data add constraint pk4id_of_form_message_data primary key (id);
alter table form_message_data add constraint 
	fk4form_of_form_message_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_field_message_data add constraint pk4id_of_form_field_message_data primary key (id);
alter table form_field_message_data add constraint 
	fk4form_of_form_field_message_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_field_data add constraint pk4id_of_form_field_data primary key (id);
alter table form_field_data add constraint 
	fk4form_of_form_field_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_action_data add constraint pk4id_of_form_action_data primary key (id);
alter table form_action_data add constraint 
	fk4form_of_form_action_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table candidate_container_data add constraint pk4id_of_candidate_container_data primary key (id);

alter table candidate_element_data add constraint pk4id_of_candidate_element_data primary key (id);
alter table candidate_element_data add constraint 
	fk4container_of_candidate_element_data foreign key (container) references candidate_container_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
-- create extra index for time, number and mobile phone







delete from list_access_data ;
delete from object_access_data ;
delete from user_app_data ;
delete from login_history_data ;
delete from sec_user_data ;
delete from user_domain_data ;
insert into user_domain_data values ('UD000001','用户区域','1');



insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','24327F1C00D22210298A18D0DB9AA6C4C22DEAC4BEAE7C02E616442CA7764246', 'weixin_openid_000001', 'weixin_appid_000001', 'jwt_token_000001' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000001','链问链答考试中台','SU000001','university',1,'MXWR','Platform','P000001','/link/to/app','1');
insert into user_app_data values('UA000002','我的账户','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into user_app_data values('UA000003','用户管理','SU000001','lock',1,'MXWR','UserDomain','UD000001','/link/to/app','1');

/* ------------------------------------------------------------------------ */
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','BB5210DAE99659C7164D7DBCFC51FB2D167D0DA372D58EF26A9F8533EEA2967C', 'weixin_openid_000002', 'weixin_appid_000002', 'jwt_token_000002' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000004','微信用户: 张三','SU000002','store',1,'MXWR','WechatUser','WU000001','/link/to/app','1');
insert into user_app_data values('UA000005','我的账户','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1');
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','9D4104DF2774FDEAAE074CA35B052D8F664F4F99064C7BEAB0B589C2605C4EDA', 'weixin_openid_000003', 'weixin_appid_000003', 'jwt_token_000003' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000006','微信用户: 李四','SU000003','store',1,'MXWR','WechatUser','WU000002','/link/to/app','1');
insert into user_app_data values('UA000007','我的账户','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1');
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','9B223EBD008D7B544A3A640739EBE47459D3A4C5296DDA00F594FAF60FE88B28', 'weixin_openid_000004', 'weixin_appid_000004', 'jwt_token_000004' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000008','微信用户: 王五','SU000004','store',1,'MXWR','WechatUser','WU000003','/link/to/app','1');
insert into user_app_data values('UA000009','我的账户','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1');


select mobile as `可用于登录的账号`, 'admin123' as `密码` from sec_user_data;

/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|平台|13900000001|admin123|


*/


create table info_lines(line varchar(400));

insert into info_lines values( '   SSSSSSSSSSSSSSS                                                                                                                  !!! ');
insert into info_lines values( ' SS:::::::::::::::S                                                                                                                !!:!!');
insert into info_lines values( 'S:::::SSSSSS::::::S                                                                                                                !:::!');
insert into info_lines values( 'S:::::S     SSSSSSS                                                                                                                !:::!');
insert into info_lines values( 'S:::::S            uuuuuu    uuuuuu      cccccccccccccccc    cccccccccccccccc    eeeeeeeeeeee        ssssssssss       ssssssssss   !:::!');
insert into info_lines values( 'S:::::S            u::::u    u::::u    cc:::::::::::::::c  cc:::::::::::::::c  ee::::::::::::ee    ss::::::::::s    ss::::::::::s  !:::!');
insert into info_lines values( ' S::::SSSS         u::::u    u::::u   c:::::::::::::::::c c:::::::::::::::::c e::::::eeeee:::::eess:::::::::::::s ss:::::::::::::s !:::!');
insert into info_lines values( '  SS::::::SSSSS    u::::u    u::::u  c:::::::cccccc:::::cc:::::::cccccc:::::ce::::::e     e:::::es::::::ssss:::::ss::::::ssss:::::s!:::!');
insert into info_lines values( '    SSS::::::::SS  u::::u    u::::u  c::::::c     cccccccc::::::c     ccccccce:::::::eeeee::::::e s:::::s  ssssss  s:::::s  ssssss !:::!');
insert into info_lines values( '       SSSSSS::::S u::::u    u::::u  c:::::c             c:::::c             e:::::::::::::::::e    s::::::s         s::::::s      !:::!');
insert into info_lines values( '            S:::::Su::::u    u::::u  c:::::c             c:::::c             e::::::eeeeeeeeeee        s::::::s         s::::::s   !!:!!');
insert into info_lines values( '            S:::::Su:::::uuuu:::::u  c::::::c     cccccccc::::::c     ccccccce:::::::e           ssssss   s:::::s ssssss   s:::::s  !!! ');
insert into info_lines values( 'SSSSSSS     S:::::Su:::::::::::::::uuc:::::::cccccc:::::cc:::::::cccccc:::::ce::::::::e          s:::::ssss::::::ss:::::ssss::::::s     ');
insert into info_lines values( 'S::::::SSSSSS:::::S u:::::::::::::::u c:::::::::::::::::c c:::::::::::::::::c e::::::::eeeeeeee  s::::::::::::::s s::::::::::::::s  !!! ');
insert into info_lines values( 'S:::::::::::::::SS   uu::::::::uu:::u  cc:::::::::::::::c  cc:::::::::::::::c  ee:::::::::::::e   s:::::::::::ss   s:::::::::::ss  !!:!!');
insert into info_lines values( ' SSSSSSSSSSSSSSS       uuuuuuuu  uuuu    cccccccccccccccc    cccccccccccccccc    eeeeeeeeeeeeee    sssssssssss      sssssssssss     !!! ');

select * from info_lines;
/* start with data patch */
/* The sql file is not found from: /Users/Philip/githome/web-code-generator/sky/data-patch/bcex.sql */



/*
http://patorjk.com/software/taag/#p=testall&h=0&v=0&f=Graceful&t=Success!
   _____                                            _ 
  / ____|                                          | |
 | (___    _   _    ___    ___    ___   ___   ___  | |
  \\___   | | | |  / __|  / __|  / _  / __| / __| | |
  ____) | | |_| | | (__  | (__  |  __/ \\__  \\__  |_|
 |_____/   \\__,_|  \\___|  \\___|  \\___| |___/ |___/ (_)  
+----------+---------------------------------+---------------------+--------+
| Charset  | Description                     | Default collation   | Maxlen |
+----------+---------------------------------+---------------------+--------+
| gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
| gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
| utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
| utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
| gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
+----------+---------------------------------+---------------------+--------+

*/

