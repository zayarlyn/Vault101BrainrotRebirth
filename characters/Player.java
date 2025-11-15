// Player.java
// Player character implementation

class Player extends BaseStats implements IPlayerEntity {
    protected int ACC, ENE;
    protected String SPEC;
    protected String[] inventory;
    protected int baseHP, baseATK, baseDEF, baseRATK, baseRDEF, baseAGI, baseACC, baseENE;
    protected int expReach;

    public Player(String name, int hp, int atk, int def, int ratk, int rdef, int agi, int acc, int ene, String spec) {
        super(name, hp, atk, def, ratk, rdef, agi, 1);
        this.ACC = acc;
        this.ENE = ene;
        this.SPEC = spec;
        this.inventory = new String[10];
        for (int i = 0; i < inventory.length; i++) inventory[i] = "Empty";
        
        this.baseHP = hp;
        this.baseATK = atk;
        this.baseDEF = def;
        this.baseRATK = ratk;
        this.baseRDEF = rdef;
        this.baseAGI = agi;
        this.baseACC = acc;
        this.baseENE = ene;
        this.expReach = 40;
        
        // Initialize current stats to calculated totals
        resetBattleStats();
    }

    public String getName() { return name; }
    public int getACC() { return ACC; }
    public int getENE() { return ENE; }
    public String getSPEC() { return SPEC; }
    public String[] getInventory() { return inventory; }

    public void setACC(int acc) { this.ACC = acc; }
    public void setENE(int ene) { this.ENE = ene; }

    public void useEnergy(int amount) { 
        this.ENE = Math.max(0, this.ENE - amount);
    }

    public void gainEXP(int amount) {
        this.EXP += amount;
        while (this.EXP >= expReach) {
            levelUp();
        }
    }

    public void levelUp() {
        this.LVL++;
        this.EXP -= expReach;
        this.expReach = 20 + (LVL * 5);
        System.out.println(name + " leveled up to Level " + LVL + "!");
        updateStats();
    }

    protected void updateStats() {
        // Update all stats based on level and equipment
        this.HP = calculateTotalHP();
        this.ATK = calculateTotalATK();
        this.DEF = calculateTotalDEF();
        this.RATK = calculateTotalRATK();
        this.RDEF = calculateTotalRDEF();
        this.AGI = calculateTotalAGI();
        this.ACC = calculateTotalACC();
        this.ENE = calculateTotalENE();
    }

    // Total stat calculations
    public int calculateTotalHP() {
        int bonus = 0;
        if (inventory[2] != null && inventory[2].equals("Tactical Headset")) bonus += 4;
        return baseHP + getHPBonusFromLevel() + bonus;
    }

    public int calculateTotalATK() {
        int bonus = 0;
        if (inventory[0] != null) {
            if (inventory[0].equals("Steel Bar")) bonus += 1;
            if (inventory[0].equals("Machete")) bonus += 2;
        }
        return baseATK + getATKBonusFromLevel() + bonus;
    }

    public int calculateTotalDEF() {
        int bonus = 0;
        if (inventory[2] != null) {
            if (inventory[2].equals("Leather Head Gear")) bonus += 1;
            if (inventory[2].equals("Tactical Headset")) bonus += 1;
        }
        if (inventory[3] != null && inventory[3].equals("Sentinel Vest")) bonus += 2;
        if (inventory[4] != null && inventory[4].equals("Vanguard Tacticals")) bonus += 2;
        return baseDEF + getDEFBonusFromLevel() + bonus;
    }

    public int calculateTotalRATK() {
        int bonus = 0;
        if (inventory[1] != null) {
            if (inventory[1].equals("Crossbow")) bonus += 1;
            if (inventory[1].equals("Hunting Rifle")) bonus += 2;
        }
        return baseRATK + getRATKBonusFromLevel() + bonus;
    }

    public int calculateTotalRDEF() {
        int bonus = 0;
        if (inventory[2] != null && inventory[2].equals("Tactical Headset")) bonus += 1;
        if (inventory[4] != null && inventory[4].equals("Ranger Greaves")) bonus += 2;
        return baseRDEF + getRDEFBonusFromLevel() + bonus;
    }

    public int calculateTotalAGI() {
        return baseAGI + getAGIBonusFromLevel();
    }

    public int calculateTotalACC() {
        int bonus = 0;
        if (inventory[1] != null) {
            if (inventory[1].equals("Crossbow")) bonus += 1;
            if (inventory[1].equals("Hunting Rifle")) bonus += 2; // Hunting Rifle now gives +2 ACC
        }
        return baseACC + getACCBonusFromLevel() + bonus;
    }

    public int calculateTotalENE() {
        return baseENE + getENEBonusFromLevel();
    }

    // Level bonus methods to override
    protected int getHPBonusFromLevel() { return 0; }
    protected int getATKBonusFromLevel() { return 0; }
    protected int getDEFBonusFromLevel() { return 0; }
    protected int getRATKBonusFromLevel() { return 0; }
    protected int getRDEFBonusFromLevel() { return 0; }
    protected int getAGIBonusFromLevel() { return 0; }
    protected int getACCBonusFromLevel() { return 0; }
    protected int getENEBonusFromLevel() { return 0; }

    public void resetBattleStats() {
        updateStats(); // Reset all stats to calculated totals
    }
}