# Proyecto Battle

[![Java CI with Maven](https://github.com/JGomezSimon/ProyectoBattle/actions/workflows/maven.yml/badge.svg)](https://github.com/JGomezSimon/ProyectoBattle/actions/workflows/maven.yml) [![GitHub pull requests](https://img.shields.io/github/issues-pr/JGomezSimon/ProyectoBattle.svg)](https://github.com/JGomezSimon/ProyectoBattle/pulls) [![GitHub issues](https://img.shields.io/github/issues-raw/JGomezSimon/ProyectoBattle.svg)](https://github.com/JGomezSimon/ProyectoBattle/issues) [![PRs Welcome](https://img.shields.io/github/license/JGomezSimon/ProyectoBattle.svg)](http://makeapullrequest.com) ![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/JGomezSimon/ProyectoBattle.svg) ![](https://img.shields.io/github/release/JGomezSimon/ProyectoBattle.svg?style=flat) ![Github All Releases](https://img.shields.io/github/downloads/JGomezSimon/ProyectoBattle/total.svg)


The project involves simulating a battle (one on one) between different people
characters.

### Table of Contents

- [Resume](#resume)
- [Requirements](#requirements)
- [Compiling](#compiling)
- [Configuration](#configuration)
- [Contact](#contact)

### Resume
- There are three types of characters: humans, dwarves and elves.

- The characters have the following characteristics: id, name, life points, strength, speed, agility, defense, a url attribute that will represent the image of the character and an attribute of the weapon type.

- When the game starts, a window should appear with the 4 options (play, choose character, choose weapon and exit). The play option cannot be selected unless a character with a weapon has been selected. Similarly, a weapon cannot be chosen unless the character has been chosen before.

- Once the user has chosen their character and weapon, they can start playing. The weapon brings a series of improvements to the characteristics of each character. (plus speed and plus strength).

- Once the option to play is chosen, the battle against a randomly chosen enemy (with a random weapon) will begin. The one that attacks first will be the one that has more speed or in case of having the same speeds, the one that has more agility.

- To calculate the damage that each character will do in turn, the
following formula:
  * Attack = base force + plus weapon strength - defense - plus weapon defense.

- On the fight screen, the image of the 2 characters who are playing must appear, below them their characteristics and above a life bar that will decrease depending on the damage the character receives.

- The character who loses the battle will be the one who runs out of life points.

- When the battle is over, there should be a final screen, showing the summary of the fight and the option to return to the beginning or end of the application.


### Requirements
- [java11](https://openjdk.java.net/)
- [git(build)](https://git-scm.com/downloads)
- [maven(build)](https://maven.apache.org/)

### Compiling

Clone the git repository `ProyectoBattle` and run the program:

```
$ git clone git://github.com/JGomezSimon/ProyectoBattle.git
$ cd ProyectoBattle/m3
$ maven clean compile assembly:single
$ java -jar target/ProyectoBattle-*.jar
```

> NOTE: if you use intellij go to settings > editor > gui desiginer, and change 'generate gui into' value to 'java source code'.

### Configuration

- `players.json`:  contains player stats

```
{
  "player": {
    "password":"example1234",
    "warrior": "Nedraec Forgeshaper",
    "lost":5.0,
    "won":3.0,
    "name":"example",
    "points":104.0
  }
}
```

- `warriors.json`: contains information of the warriors

```
{
  "warrior": {
    "strength": 6,
    "defense": 4,
    "race_id": 1,
    "name": "Nedraec Forgeshaper",
    "agility": 5,
    "url": "src\/main\/resources\/warriors\/nedraec.jpeg",
    "life": 60,
    "speed": 3,
    "points": 21
  }
}
```

- `weapons.json`: contains information of the weapons

```
{
  "weapon": {
    "strength": 2,
    "name": "Katana",
    "speed": 3,
    "url": "src\/main\/resources\/weapons\/katana.jpg",
    "points": 18
  }
}
```
### Contact

- AlexDltg: dltgalex@gmail.com
- Jaume Gómez Simón: jgomezsimon13@gmail.com
- Javier Durán de las Morenas: javidm01@hotmail.com
