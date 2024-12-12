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
  DeskCapacity tinyint null 
);
alter table desk add constraint PK_desk_store primary key (DeskId, StoreId); 
alter table desk add constraint FK_desk_store foreign key (StoreId) references store(StoreId);

insert into desk(DeskId, StoreId, DeskCapacity)
	values(1,1,2),(2,1,2),(3,1,2),(4,1,4),(5,1,4),(6,1,4),
				(7,1,6),(8,1,6),(9,1,6),(10,1,8),(11,1,8),(12,1,8),
        (1,2,2),(2,2,2),(3,2,2),(4,2,4),(5,2,4),(6,2,4),
				(7,2,6),(8,2,6),(9,2,6),(10,2,8),(11,2,8),(12,2,8);
        
-- 桌游表
drop table if exists game;
create table game
(
	GameId int primary key auto_increment not null,
  GameName char(30) null,
  GameCategory char(50) null,
  GameImage char(100) null,
  GameNumber char(10) null
)	auto_increment = 1;

insert into game(GameId, GameName, GameCategory, GameImage, GameNumber)
	values(null, '三国杀', '卡牌', 'image/game/三国杀.png', '3-8'),(null, '三国杀', '卡牌', 'image/game/三国杀.png', '3-8'),
				(null, '三国杀', '卡牌', 'image/game/三国杀.png', '3-8'),(null, '三国杀', '卡牌', 'image/game/三国杀.png', '3-8'),
        (null, '三国杀', '卡牌', 'image/game/三国杀.png', '3-8'),(null, '三国杀', '卡牌', 'image/game/三国杀.png', '3-8'),
        (null, '三国杀', '卡牌', 'image/game/三国杀.png', '3-8'),(null, '三国杀', '卡牌', 'image/game/三国杀.png', '3-8');
  
-- 桌游副本表
create table gamecopy
(
	GameCopyId int not null,
  GameId int not null,
  StoreId int not null
);
alter table gamecopy add primary key (GameCopyId, GameId);
alter table gamecopy
	add constraint FK_gamecopy_game
		foreign key (GameId) references game(GameId),
	add constraint FK_gamecopy_store
		foreign key (StoreId) references store(StoreId);
    
insert into gamecopy(GameCopyId, GameId, StoreId)
	values(1,1,1),(2,1,1),(3,1,1),
				(1,2,1),(2,2,1),(3,2,1);
        
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
	values(null,1000,1,1,null,null,null,null);
  
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
	values(null,1000,1,1,null,null,null),(null,1000,2,1,null,null,null),
				(null,1000,3,1,null,null,null),(null,1000,1,2,null,null,null);