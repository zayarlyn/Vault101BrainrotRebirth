// IFlyingUnit.java
// Flying unit interface

interface IFlyingUnit extends IEnemyEntity {
    default void applyTypeBonus() {
        setHP(getHP() - 5);
        setAGI(getAGI() + 13); // AGI represents evasion
    }
}
