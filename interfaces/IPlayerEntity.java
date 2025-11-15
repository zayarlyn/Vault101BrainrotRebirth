// IPlayerEntity.java
// Player entity interface

interface IPlayerEntity extends ICoreStats {
    String getName();
    int getACC();
    int getENE();
    String getSPEC();
    String[] getInventory();

    void setACC(int acc);
    void setENE(int ene);
    void useEnergy(int amount);
    void gainEXP(int amount);
    void levelUp();
    int calculateTotalHP();
    int calculateTotalATK();
    int calculateTotalDEF();
    int calculateTotalRATK();
    int calculateTotalRDEF();
    int calculateTotalAGI();
    int calculateTotalACC();
    int calculateTotalENE();
}
