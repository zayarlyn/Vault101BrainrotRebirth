// BaseStats.java
// Base stats implementation

class BaseStats implements ICoreStats {
    protected int HP, ATK, DEF, RATK, RDEF, AGI, LVL, EXP;
    protected String name;

    public BaseStats(String name, int hp, int atk, int def, int ratk, int rdef, int agi, int lvl) {
        this.name = name;
        this.HP = hp;
        this.ATK = atk;
        this.DEF = def;
        this.RATK = ratk;
        this.RDEF = rdef;
        this.AGI = agi;
        this.LVL = lvl;
        this.EXP = 0;
    }

    public int getHP() { return HP; }
    public int getATK() { return ATK; }
    public int getDEF() { return DEF; }
    public int getRATK() { return RATK; }
    public int getRDEF() { return RDEF; }
    public int getAGI() { return AGI; }
    public int getLVL() { return LVL; }
    public int getEXP() { return EXP; }
    public String getName() { return name; }

    public void setHP(int hp) { this.HP = hp; }
    public void setATK(int atk) { this.ATK = atk; }
    public void setDEF(int def) { this.DEF = def; }
    public void setRATK(int ratk) { this.RATK = ratk; }
    public void setRDEF(int rdef) { this.RDEF = rdef; }
    public void setAGI(int agi) { this.AGI = agi; }
    public void setEXP(int exp) { this.EXP = exp; }
    public boolean isAlive() { return HP > 0; }
}
