// TralaleroTralala.java
// TralaleroTralala player character implementation

class TralaleroTralala extends Player {
    public TralaleroTralala() {
        super("Tralalero Tralala", 15, 7, 3, 5, 2, 2, 2, 15, "Heal");
    }

    protected int getHPBonusFromLevel() { return 4 * (LVL - 1); }
    protected int getATKBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getDEFBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getRATKBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getRDEFBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getAGIBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getACCBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getENEBonusFromLevel() { return (int)(2.5 * (LVL - 1)); }
}
