// TungTungTungSahur.java
// TungTungTungSahur player character implementation

class TungTungTungSahur extends Player {
    public TungTungTungSahur() {
        super("Tung Tung Tung Sahur", 10, 8, 4, 7, 3, 4, 3, 15, "PowerHit");
    }

    protected int getHPBonusFromLevel() { return 3 * (LVL - 1); }
    protected int getATKBonusFromLevel() { return (int)(1.5 * (LVL - 1)); }
    protected int getDEFBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getRATKBonusFromLevel() { return (int)(1.5 * (LVL - 1)); }
    protected int getRDEFBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getAGIBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getACCBonusFromLevel() { return 1 * (LVL - 1); }
    protected int getENEBonusFromLevel() { return 3 * (LVL - 1); }
}
