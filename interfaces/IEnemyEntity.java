// IEnemyEntity.java
// Enemy entity interface

interface IEnemyEntity extends ICoreStats {
    String getEnemyName();
    String getEnemyType();
    String getDescription();
    int getExpAmount();
    void performAttack(ICoreStats target);
    void onDefeated();
}
