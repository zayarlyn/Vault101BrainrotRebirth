// IGroundUnit.java
// Ground unit interface

interface IGroundUnit extends IEnemyEntity {
    default void applyTypeBonus() {
        setHP(getHP() + 1);
        setATK(getATK() + 1);
    }
}
