// Screecher.java
// Screecher enemy implementation

import java.util.Random;

class Screecher extends BaseStats implements IFlyingUnit {
    private Random rand = new Random();

    public Screecher() {
        super("Screecher", 23, 8, 4, 10, 4, 5, 4);
        applyTypeBonus(); // Apply flying unit bonus
    }

    public int getExpAmount() { return 25; }
    public String getEnemyName() { return name; }
    public String getEnemyType() { return "FlyingUnit"; }
    public String getDescription() { return "Fast flying attacker"; }

    public void performAttack(ICoreStats target) {
        int attackType = rand.nextInt(100);
        
        if (attackType < 65) { // 65% ranged
            int damage = Math.max(1, getRATK() - target.getRDEF());
            target.setHP(target.getHP() - damage);
            System.out.println(name + " unleashes a piercing sonic scream for " + damage + " damage!");
        } else { // 35% melee
            int damage = Math.max(1, getATK() - target.getDEF());
            target.setHP(target.getHP() - damage);
            System.out.println(name + " dives and claws for " + damage + " damage!");
        }
    }

    public void onDefeated() {
        System.out.println(name + " lets out one final weak screech before falling silent! +25 EXP gained.");
    }
}
