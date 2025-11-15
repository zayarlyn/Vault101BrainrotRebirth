// ICoreStats.java
// Core stats interface

interface ICoreStats {
    int getHP();
    int getATK();
    int getDEF();
    int getRATK();
    int getRDEF();
    int getAGI();
    int getLVL();
    int getEXP();
    boolean isAlive();

    void setHP(int hp);
    void setATK(int atk);
    void setDEF(int def);
    void setRATK(int ratk);
    void setRDEF(int rdef);
    void setAGI(int agi);
    void setEXP(int exp);
}
