drop database if exists cafe;
create database cafe;
use cafe;
-- 用户表
drop table if exists users;

CREATE TABLE users
( 
	UserId int auto_increment primary key not null ,
  UserPassword char(36) not null,
	UserName char(18) not null ,
	UserSex	tinyint null ,
	UserTelephone char(11) null 
) auto_increment = 1000;
insert into users(UserId, UserPassword, UserName, UserSex, UserTelephone)
	values(null,'123456','彼方林夕',1,'17884955085'),
				(null,'123456','arknights','1',null);
        
-- 商店表
drop table if exists store;
CREATE TABLE store
( 
	StoreId int auto_increment primary key NOT NULL ,
  StoreName char(50) null,
  StoreAdress char(50) null
) auto_increment=1;
insert into store(StoreId, StoreName, StoreAdress)
	values(null,'星光桌游店','上海奉贤'),(null,'上师大桌游店','上海徐汇');
  
-- 桌子表
drop table if exists desk;
CREATE TABLE desk
( 
	DeskId int not null ,
  StoreId int not null,
  DeskCapacity tinyint null,
  DeskStatus tinyint null
);
alter table desk add constraint PK_desk_store primary key (DeskId, StoreId); 
alter table desk add constraint FK_desk_store foreign key (StoreId) references store(StoreId);

insert into desk(DeskId, StoreId, DeskCapacity, DeskStatus)
	values(1,1,2,1),(2,1,2,1),(3,1,2,1),(4,1,4,1),(5,1,4,1),(6,1,4,1),
				(7,1,6,1),(8,1,6,1),(9,1,6,1),(10,1,8,1),(11,1,8,1),(12,1,8,1),
        (1,2,2,1),(2,2,2,1),(3,2,2,1),(4,2,4,1),(5,2,4,1),(6,2,4,1),
				(7,2,6,1),(8,2,6,1),(9,2,6,1),(10,2,8,1),(11,2,8,1),(12,2,8,1);
        
-- 桌游表
drop table if exists game;
create table game
(
	GameId int primary key auto_increment not null,
  GameName char(30) null,
  GameImage char(100) null,
  GameNumber char(10) null,
  GameDescription char(255) null,
  GameDetails char(255) null,
  GameStatus tinyint null
)	auto_increment = 1;

insert into game(GameId, GameName, GameImage, GameNumber, GameDescription, GameDetails, GameStatus)
	values
  (null, '三国杀', 'image/game/三国杀.png', '3-8', '这是世界上最好的游戏' , 
  '你将扮演三个不同阵营的英雄人物，并操纵他们进行卡牌对抗', 1),
  (null, '三国杀2', 'image/game/三国杀.png', '3-8', '这是世界上最好的游戏' , 
  '你将扮演三个不同阵营的英雄人物，并操纵他们进行卡牌对抗', 1),
  (null, '三国杀3', 'image/game/三国杀.png', '3-8', '这是世界上最好的游戏' , 
  '你将扮演三个不同阵营的英雄人物，并操纵他们进行卡牌对抗', 1),
  (null, '三国杀5', 'image/game/三国杀.png', '3-8', '这是世界上最好的游戏' , 
  '你将扮演三个不同阵营的英雄人物，并操纵他们进行卡牌对抗', 1),
  (null, '三国杀6', 'image/game/三国杀.png', '3-8', '这是世界上最好的游戏' , 
  '你将扮演三个不同阵营的英雄人物，并操纵他们进行卡牌对抗', 1);
  
-- 桌游副本表
create table gamecopy
(
	GameCopyId int not null,
  GameId int not null,
  StoreId int not null,
  GameCopyStatus tinyint null
);
alter table gamecopy add primary key (GameCopyId, GameId);
alter table gamecopy
	add constraint FK_gamecopy_game
		foreign key (GameId) references game(GameId),
	add constraint FK_gamecopy_store
		foreign key (StoreId) references store(StoreId);
    
insert into gamecopy(GameCopyId, GameId, StoreId, GameCopyStatus)
	values(1,1,1,1),(1,2,1,1),(2,1,2,1),(1,3,1,1),(1,4,1,1),(1,5,1,1);
-- tag表
drop table if exists tag;
create table tag
(
	tagId int primary key auto_increment not null,
  tagName char(255) null
);
insert into tag(tagId, tagName)
	values(null,'合作'),(null,'解密'),(null,'冒险'),(null,'探索'),
				(null,'投资'),(null,'卡牌'),(null,'格斗'),(null,'发展');
        
-- 桌游tag表
drop table if exists gametag;
create table gametag
(
	tagGameId int primary key auto_increment not null,
  GameId int not null,
  tagName char(255) null
);
alter table gametag
	add constraint FK_gametag_game
		foreign key (GameId) references game(GameId);

insert into gametag(tagGameId, GameId, tagName)
	values(null, 1, '合作'),(null, 2, '冒险'),(null, 3, '格斗'),(null, 4, '探索');

-- 桌子预约表
drop table if exists user_desk;
create table user_desk
(
	OrderId int auto_increment primary key not null,
	UserId int not null,
	DeskId int not null,
  StoreId int not null,
  
  StartTime timestamp null,
  EndTime timestamp null,
  Price int null,
  OrderStatus tinyint null
) auto_increment = 1;
alter table user_desk
	add constraint FK_user_desk1
		foreign key (UserId) references users(UserId),
	add constraint FK_user_desk2
		foreign key (DeskId) references desk(deskId),
	add constraint FK_user_desk3
		foreign key (StoreId) references desk(StoreId);
    
insert into user_desk(OrderId, UserId, DeskId, StoreId, StartTime, EndTime, Price, OrderStatus)
	values(null,1000,1,1,now(),now(),45,1),(null,1000,1,1,now(),now(),45,1),
				(null,1000,1,1,now(),now(),45,1),(null,1000,1,1,now(),now(),45,1);
  
-- 桌游预约表
drop table if exists user_game;
create table user_game
(
	ObserveId int auto_increment primary key not null,
  UserId int not null,
  GameCopyId int not null,
  GameId int not null,
  
  StartTime timestamp null,
  EndTime timestamp null,
  ObserveStatus tinyint null
)auto_increment=1;
alter table user_game
	add constraint FK_user_game1
		foreign key (UserId) references users(UserId),
	add constraint FK_user_game2
		foreign key (GameCopyId) references gamecopy(GameCopyId),
	add constraint FK_user_game3
		foreign key (GameId) references gamecopy(GameId);
    
insert into user_game(ObserveId, UserId, GameCopyId, GameId, StartTime, EndTime, ObserveStatus)
	values(null,1000,1,1,now(),now(),1),(null,1000,1,1,now(),now(),1),
				(null,1000,1,1,now(),now(),1),(null,1000,1,1,now(),now(),1),
        (null,1000,1,1,'2024-12-21 08:00:00','2024-12-21 09:00:00',0);
  
-- 快讯表
drop table if exists news;
create table news
(
	newId int auto_increment primary key not null,
  dataTime char(255) null,
  title char(255) null,
  content char(255) null,
  author char(255) null,
	newDescription text null,
  newDetail text null
);

insert into news(newId, datatime, title, content, author, newDescription, newDetail)
	values(null,'2024/12/10','星光咖啡馆与桌游之蝶今日正式营业！！','经过长期的筹备，星光咖啡馆与桌游之蝶终于在今天开业了，为大家带来独特的餐饮与桌游体验。','明月栞那','123','测试'),
	(null, '2024/12/10', '咖啡馆推荐菜品速递', '今日推荐：拿铁咖啡搭配经典甜点，享受午后的悠闲时光。', '四季夏目', null, null),
	(null, '2024/12/11', '桌游上新！', '新增多款热门桌游，欢迎各位玩家来店体验，共同享受欢乐时光。', '墨染希', null, null),
	(null, '2024/12/12', '周末特惠活动预告', '本周末将有特别优惠活动，敬请期待我们的官方公告。', '火打谷爱衣', null, null),
	(null, '2024/12/13', '咖啡馆环境升级', '我们对店内环境进行了全面升级，为您打造更加舒适的休闲空间。', '明月栞那', null, null),
	(null, '2024/12/14', '桌游高手挑战赛', '热爱桌游的您不容错过，桌游高手挑战赛即将开赛，快来展现您的技巧吧！', '四季夏目', null, null),
	(null, '2024/12/15', '会员专享福利', '为了感谢会员的支持，我们将提供专属福利，敬请关注您的会员账户。', '墨染希', null, null),
	(null, '2024/12/16', '新品咖啡品尝会', '新品咖啡上市，邀请您来店免费品尝，给我们提出宝贵的意见。', '火打谷爱衣', null, null),
	(null, '2024/12/17', '节日特别菜单', '为迎接即将到来的节日，我们特别推出了节日特别菜单，与您共度佳节。', '明月栞那', null, null),
	(null, '2024/12/18', '桌游主题夜活动', '本周五晚，我们将在咖啡馆举办桌游主题夜活动，欢迎您的参与。', '四季夏目', null, null),
	(null, '2024/12/19', '咖啡知识讲座', '对咖啡文化感兴趣的您，不要错过我们的咖啡知识讲座，了解咖啡的历史与制作工艺。', '墨染希', null, null),
	(null, '2024/12/20', '桌游新手教学', '专为桌游新手准备的免费教学活动，学习新桌游，结交新朋友。', '火打谷爱衣', null, null),
	(null, '2024/12/21', '会员生日会', '为庆祝会员生日，我们将举办会员生日会，邀请会员共度生日快乐时光。', '明月栞那', null, null),
	(null, '2024/12/22', '冬季限定饮品', '推出冬季限定饮品，为您带来温暖口感，抵御寒冷。', '四季夏目', null, null),
	(null, '2024/12/23', '桌游团购优惠', '桌游团购优惠活动来袭，邀请您的朋友一起来享受折扣。', '墨染希', null, null),
	(null, '2024/12/24', '节日派对预告', '节日派对即将举行，届时将有精彩表演和美味佳肴，敬请期待。', '火打谷爱衣', null, null),
	(null, '2024/12/25', '圣诞节特别活动', '圣诞节特别活动即将开始，与我们一起欢度圣诞。', '明月栞那', null, null),
	(null, '2024/12/26', '咖啡豆知识普及', '了解不同咖啡豆的特点，品尝我们的特色咖啡豆。', '四季夏目', null, null),
	(null, '2024/12/27', '桌游试玩活动', '多种桌游免费试玩，快来体验吧！', '墨染希', null, null),
	(null, '2024/12/28', '会员积分兑换', '会员积分可以兑换精美礼品，快来兑换吧！', '火打谷爱衣', null, null),
	(null, '2024/12/29', '冬季限定甜点', '冬季限定甜点上市，为您的冬季带来甜蜜。', '明月栞那', null, null),
	(null, '2024/12/30', '桌游竞技赛', '桌游竞技赛开始报名，欢迎桌游高手前来挑战。', '四季夏目', null, null),
	(null, '2024/12/31', '年末庆典活动', '年末庆典活动即将举行，让我们一起迎接新的一年。', '墨染希', null, null),
	(null, '2025/01/01', '新年特别优惠', '新年第一天，我们为您准备了特别优惠，祝您新年快乐！', '火打谷爱衣', null, null),
	(null, '2025/01/02', '桌游全新主题包', '全新桌游主题包上市，为您的游戏增添更多乐趣。', '明月栞那', null, null);