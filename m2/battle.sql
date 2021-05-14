DROP DATABASE IF EXISTS `battle`;

SET SQL_MODE=NO_AUTO_VALUE_ON_ZERO;

CREATE DATABASE `battle`;
USE `battle`;

CREATE TABLE weapons(
    weapon_id int AUTO_INCREMENT primary key,
    weapon_name varchar(255),
    weapon_image_path varchar(255),
    weapon_strength_boost int,
    weapon_speed_boost int,
    weapon_points int
);

CREATE TABLE warriors(
	warrior_id int auto_increment primary key,
    warrior_name varchar(255),
    warrior_image_path varchar(255),
    race_id int,
    health_points int,
    strength int,
    defense int,
    agility int,
    speed int,
    race_points int
);

CREATE TABLE players(
	player_id int auto_increment primary key,
    player_name varchar(255)
);

CREATE TABLE weapons_available(
	warrior_id int(10),
    weapon_id int(10),
	CONSTRAINT FK_WAwarrior FOREIGN KEY (warrior_id)
        REFERENCES warriors(warrior_id),
	CONSTRAINT FK_WAweapon FOREIGN KEY (weapon_id)
        REFERENCES weapons(weapon_id)
);

CREATE TABLE rankings(
	player_id int,
    global_points int,
    warrior_id int,
    CONSTRAINT RWarrior_ID FOREIGN KEY (warrior_id)
        REFERENCES warriors(warrior_id),
	CONSTRAINT RPlayer_id FOREIGN KEY (RPlayer_id)
        REFERENCES players(player_id)
);

CREATE TABLE battles(
	battle_id int auto_increment primary key,
    player_id int,
    warrior_id int,
    warrior_weapon_id int,
    oponent_id int,
    oponent_weapon_id int,
    injuries_caused int,
    injuries_suffered int,
    battle_points int
);

insert into weapons(weapon_id,weapon_name,weapon_image_path,weapon_strength_boost,weapon_speed_boost,weapon_points) values 
(1,'Dagger','ejemplo.jpg',0,3,10),
(2,'Sword','ejemplo.jpg',1,110),
(3,'Axe','ejemplo.jpg',3,0,10),
(4,'Twin Swords','ejemplo.jpg',2,2,14),
(5,'Scimitar','ejemplo.jpg',1,2,14),
(6,'Bow','ejemplo.jpg',1,5,15),
(7,'Katana','ejemplo.jpg',2,3,18),
(8,'Knife','ejemplo.jpg',0,4,12),
(9,'Two-Handed Axe','ejemplo.jpg',5,0,20);

insert into warriors(warrior_id,warrior_name,warrior_image_path,race_id,strength,defense,agility,speed) values
(1,'Nedraec Forgeshaper','ejemplo.jpg',1,60,6,4,5,3,21),
(2,'Safomli Platebreaker','ejemplo.jpg',1,60,6,4,5,3,21),
(3,'Khekroc Heavyshoulder','ejemplo.jpg',1,60,6,4,5,3,21),
(4,'Edwaradrin Ohmswis','ejemplo.jpg',2,40,4,2,7,7,19),
(5,'Legomoreno','ejemplo.jpg',2,40,4,2,7,7,19),
(6,'Rogerolas Elfbrooks','ejemplo.jpg',2,40,4,2,7,7,19),
(7,'Maol-Chaluim Maoileanach','ejemplo.jpg',3,50,5,4,6,20),
(8,'Gillìosa Fòlais','ejemplo.jpg',3,50,5,4,6,5,20),
(9,'Seumas Forsàidh','ejemplo.jpg',3,50,5,4,6,5,20)

