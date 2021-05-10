DROP DATABASE `battle`;

SET SQL_MODE=NO_AUTO_VALUE_ON_ZERO;

CREATE DATABASE `battle`;
USE `battle`;

CREATE TABLE weapons(
	weapon_id int(10) AUTO_INCREMENT primary key,
    weapon_name varchar(255),
    weapon_image_path varchar(255),
    weapon_strength_boost int(10),
    weapon_speed_boost int(10),
    dwarf_use boolean,
    elf_use boolean,
    human_use boolean
);

CREATE TABLE warriors(
	warrior_id int(10) auto_increment primary key,
    warrior_name varchar(255),
    warrior_image_path varchar(255),
    race varchar(255),
	health_points int(10),
    strength int(10),
    defense int(10),
    agility int(10),
    speed int(10)
);

CREATE TABLE players(
	player_id int(10) auto_increment primary key,
    player_name varchar(255),
    global_points int(10),
    enemies_defeated int(10),
    damage_dealt int(10),
    damage_recieved int(10)
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
	battle_id int(10) auto_increment primary key,
    player_id int(10),
    warrior_id int (10),
    warrior_weapon_id int(10),
    oponent_id int(10),
    oponent_weapon_id int(10),
    injuries_caused int(10),
    injuries_suffered int(10),
    battle_points int(10),
    CONSTRAINT FK_Bplayer_id FOREIGN KEY (player_id)
		REFERENCES players(player_id),
    CONSTRAINT FK_BPwarrior FOREIGN KEY (warrior_id)
        REFERENCES warriors(warrior_id),
	CONSTRAINT FK_BPweapon FOREIGN KEY (warrior_weapon_id)
        REFERENCES weapons(weapon_id),
	CONSTRAINT FK_BOwarrior FOREIGN KEY (oponent_id)
        REFERENCES warriors(warrior_id),
	CONSTRAINT FK_BOweapon FOREIGN KEY (oponent_weapon_id)
        REFERENCES weapons(weapon_id)
);

insert into weapons(weapon_id,weapon_name,weapon_image_path,weapon_strength_boost,weapon_speed_boost,dwarf_use,elf_use,human_use) values 
(1,'Dagger','ejemplo.jpg',0,3,false,true,true),
(2,'Sword','ejemplo.jpg',1,1,true,true,true),
(3,'Axe','ejemplo.jpg',3,0,true,false,true),
(4,'Twin Swords','ejemplo.jpg',2,2,false,true,true),
(5,'Scimitar','ejemplo.jpg',1,2,false,true,true),
(6,'Bow','ejemplo.jpg',1,5,false,true,false),
(7,'Katana','ejemplo.jpg',2,3,false,false,true),
(8,'Knife','ejemplo.jpg',0,4,true,true,true),
(9,'Two-Handed Axe','ejemplo.jpg',5,0,true,false,false);

insert into warriors(warrior_id,warrior_name,warrior_image_path,race,health_points,strength,defense,agility,speed) values
(1,'Nedraec Forgeshaper','ejemplo.jpg','dwarf',60,6,4,5,3),
(2,'Safomli Platebreaker','ejemplo.jpg','dwarf',60,6,4,5,3),
(3,'Khekroc Heavyshoulder','ejemplo.jpg','dwarf',60,6,4,5,3),
(4,'Edwaradrin Ohmswis','ejemplo.jpg','elf',40,4,2,7,7),
(5,'Legomoreno','ejemplo.jpg','elf',40,4,2,7,7),
(6,'Rogerolas Elfbrooks','ejemplo.jpg','elf',40,4,2,7,7),
(3,'Maol-Chaluim Maoileanach','ejemplo.jpg','human',50,5,3,6,5),
(3,'Gillìosa Fòlais','ejemplo.jpg','human',60,5,3,6,5),
(3,'Seumas Forsàidh','ejemplo.jpg','human',60,5,4,6,5)



