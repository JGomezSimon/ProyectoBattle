package proyecto.battle;

public class Weapon {
    String name,url;
    int speed, strength, dwarf_use,elf_use,human_use, weapon_id;

    public Weapon(String name, String url, int speed, int strength, int dwarf_use, int elf_use, int human_use, int weapon_id) {
        this.name = name;
        this.url = url;
        this.speed = speed;
        this.strength = strength;
        this.dwarf_use = dwarf_use;
        this.elf_use = elf_use;
        this.human_use = human_use;
        this.weapon_id = weapon_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) { this.speed = speed; }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) { this.strength = strength; }

    public int getDwarf_use() {
        return dwarf_use;
    }

    public void setDwarf_use(int dwarf_use) {
        this.dwarf_use = dwarf_use;
    }

    public int getElf_use() {
        return elf_use;
    }

    public void setElf_use(int elf_use) {
        this.elf_use = elf_use;
    }

    public int getHuman_use() {
        return human_use;
    }

    public void setHuman_use(int human_use) {
        this.human_use = human_use;
    }

    public int getWeapon_id() { return weapon_id; }

    public void setWeapon_id(int weapon_id) { this.weapon_id = weapon_id; }
}
