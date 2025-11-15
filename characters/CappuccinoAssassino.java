// CappuccinoAssassino.java
// CappuccinoAssassino player character implementation

class CappuccinoAssassino extends Player {
    public CappuccinoAssassino() {
        super("Cappuccino Assassino", 8, 6, 4, 10, 4, 8, 7, 14, "Snipe");
    }

    protected int getHPBonusFromLevel() { return 2 * (LVL - 1); }
    protected int getATKBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getDEFBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getRATKBonusFromLevel() { return 2 * (LVL - 1); }
    protected int getRDEFBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getAGIBonusFromLevel() { return 2 * (LVL - 1); }
    protected int getACCBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getENEBonusFromLevel() { return (int)(3.5 * (LVL - 1)); }
}
