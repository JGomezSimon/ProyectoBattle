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
    dwarf_use int,
    elf_use int,
    human_use int
);

CREATE TABLE races(
	race_id int auto_increment primary key,
    race_name varchar(255),
	health_points int,
    strength int,
    defense int,
    agility int,
    speed int
);

CREATE TABLE warriors(
	warrior_id int auto_increment primary key,
    warrior_name varchar(255),
    warrior_image_path varchar(255),
    race_id int,
    CONSTRAINT Wrace_id FOREIGN KEY (race_id)
		REFERENCES races(race_id)
);

CREATE TABLE players(
	player_id int auto_increment primary key,
    player_name varchar(255),
    global_points int,
    enemies_defeated int,
    damage_dealt int,
    damage_recieved int,
    warrior_id int
);

CREATE TABLE weapons_available(
	warrior_id int(10),
    weapon_id int(10),
	CONSTRAINT FK_WAwarrior FOREIGN KEY (warrior_id)
        REFERENCES warriors(warrior_id),
	CONSTRAINT FK_WAweapon FOREIGN KEY (weapon_id)
        REFERENCES weapons(weapon_id)
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

insert into weapons(weapon_id,weapon_name,weapon_image_path,weapon_strength_boost,weapon_speed_boost,dwarf_use,elf_use,human_use) values 
(1,'Dagger','ejemplo.jpg',0,3,0,2,3),
(2,'Sword','ejemplo.jpg',1,1,1,2,3),
(3,'Axe','ejemplo.jpg',3,0,1,0,3),
(4,'Twin Swords','ejemplo.jpg',2,2,0,2,3),
(5,'Scimitar','ejemplo.jpg',1,2,0,2,3),
(6,'Bow','ejemplo.jpg',1,5,0,2,0),
(7,'Katana','ejemplo.jpg',2,3,0,0,3),
(8,'Knife','ejemplo.jpg',0,4,1,2,3),
(9,'Two-Handed Axe','ejemplo.jpg',5,0,1,0,0);

insert into races(race_id, race_name,health_points,strength,defense,agility,speed) values 
(1,'Dwarf',60,6,4,5,3),
(2,'Elf',40,4,2,7,7),
(3,'Human',50,5,4,6,5);

insert into warriors(warrior_id,warrior_name,warrior_image_path,race_id) values
(1,'Nedraec Forgeshaper','ejemplo.jpg',1),
(2,'Safomli Platebreaker','ejemplo.jpg',1),
(3,'Khekroc Heavyshoulder','ejemplo.jpg',1),
(4,'Edwaradrin Ohmswis','ejemplo.jpg',2),
(5,'Legomoreno','ejemplo.jpg',2),
(6,'Rogerolas Elfbrooks','ejemplo.jpg',2),
(7,'Maol-Chaluim Maoileanach','ejemplo.jpg',3),
(8,'Gillìosa Fòlais','ejemplo.jpg',3),
(9,'Seumas Forsàidh','ejemplo.jpg',3)


