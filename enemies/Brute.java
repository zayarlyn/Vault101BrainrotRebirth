// Brute.java
// Brute enemy implementation

import java.util.Random;

class Brute extends BaseStats implements IGroundUnit {
    private Random rand = new Random();

    public Brute() {
        super("Brute", 20, 8, 7, 6, 5, 3, 3);
        applyTypeBonus(); // Apply ground unit bonus
    }

    public int getExpAmount() { return 20; }
    public String getEnemyName() { return name; }
    public String getEnemyType() { return "GroundUnit"; }
    public String getDescription() { return "Heavy ground fighter"; }

    public void performAttack(ICoreStats target) {
        int attackType = rand.nextInt(100);
        
        if (attackType < 60) { // 60% melee
            int damage = Math.max(1, getATK() - target.getDEF());
            target.setHP(target.getHP() - damage);
            System.out.println(name + " smashes with brute force for " + damage + " damage!");
        } else { // 40% ranged
            int damage = Math.max(1, getRATK() - target.getRDEF());
            target.setHP(target.getHP() - damage);
            System.out.println(name + " hurls debris for " + damage + " damage!");
        }
    }

    public void onDefeated() {
        System.out.println(name + " roars in agony before crumbling! +20 EXP gained.");
    }
}
