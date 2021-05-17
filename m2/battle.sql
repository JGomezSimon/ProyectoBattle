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
    player_name varchar(255),
    passwd varchar(255),
    points int,
    wins int,
    losses int,
    warrior_id int,
    CONSTRAINT PFK_WArrior FOREIGN KEY (warrior_id)
		REFERENCES warriors(warrior_id)
);

CREATE TABLE weapons_available(
	warrior_id int,
    weapon_id int,
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

insert into weapons(weapon_id, weapon_name, weapon_image_path, weapon_strength_boost, weapon_speed_boost, weapon_points) values 
(1, 'Dagger', 'assets/weapons/dagger.jpg', 0, 3, 10),
(2, 'Sword', 'assets/weapons/sword.jpg', 1, 1, 10),
(3, 'Axe', 'assets/weapons/axe.png', 3, 0, 10),
(4, 'Twin Swords', 'assets/weapons/twinSword.jpg',2 ,2 ,14),
(5, 'Scimitar', 'assets/weapons/scimitar.jpg',1 ,2 , 14),
(6, 'Bow', 'assets/weapons/bow.jpg', 1, 5, 15),
(7, 'Katana', 'assets/weapons/katana.jpg', 2, 3, 18),
(8, 'Knife', 'assets/weapons/knife.jpg', 0, 4, 12),
(9, 'Two-Handed Axe', 'assets/weapons/twoHandedAxe.jpg', 5, 0, 20);



insert into warriors(warrior_id, warrior_name, warrior_image_path, race_id, health_points, strength, defense, agility, speed, race_points) values
(1, 'Nedraec Forgeshaper', 'assets/warriors/nedraec.jpeg', 1, 60, 6, 4, 5, 3, 21),
(2, 'Safomli Platebreaker', 'assets/warriors/samfoli.jpg', 1, 60, 6, 4, 5, 3, 21),
(3, 'Khekroc Heavyshoulder', 'assets/warriors/khekroc.png', 1, 60, 6, 4, 5, 3, 21),
(4, 'Edwaradrin Ohmswis', 'assets/warriors/edwaradrin.jpg', 2, 40, 4, 2, 7, 7, 19),
(5, 'Legomoreno', 'assets/warriors/legomoreno.jpg', 2, 40, 4, 2, 7, 7, 19),
(6, 'Rogerolas Elfbrooks', 'assets/warriors/roferolas.jpg', 2, 40, 4, 2, 7, 7, 19),
(7, 'Maol-Chaluim Maoileanach', 'assets/warriors/maol-chaluim.jpg', 3, 50, 5, 4, 6, 5, 20),
(8, 'Gillìosa Fòlais', 'assets/warriors/gilliosa.jpg', 3, 50, 5, 4, 6, 5, 20),
(9, 'Seumas Forsàidh', 'assets/warriors/seumas.jpg', 3, 50, 5, 4, 6, 5, 20);

insert into players(player_id, player_name, passwd, points, wins, losses, warrior_id) values (1,'test','test', 176, 7, 3, 5);



