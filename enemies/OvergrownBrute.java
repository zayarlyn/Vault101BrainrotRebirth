// OvergrownBrute.java
// OvergrownBrute enemy implementation

import java.util.Random;

class OvergrownBrute extends BaseStats implements IGroundUnit {
    private Random rand = new Random();

    public OvergrownBrute() {
        super("Overgrown Brute", 30, 10, 8, 7, 6, 5, 5);
        applyTypeBonus(); // Apply ground unit bonus
    }

    public int getExpAmount() { return 40; }
    public String getEnemyName() { return name; }
    public String getEnemyType() { return "GroundUnit (Boss)"; }
    public String getDescription() { return "Massive mutated boss creature"; }

    public void performAttack(ICoreStats target) {
        int attackType = rand.nextInt(100);
        
        if (attackType < 60) { // 60% melee
            int damage = Math.max(1, getATK() - target.getDEF());
            target.setHP(target.getHP() - damage);
            System.out.println(name + " delivers a devastating ground slam for " + damage + " damage!");
        } else { // 40% ranged
            int damage = Math.max(1, getRATK() - target.getRDEF());
            target.setHP(target.getHP() - damage);
            System.out.println(name + " throws a massive boulder for " + damage + " damage!");
        }
    }

    public void onDefeated() {
        System.out.println(name + " lets out an earth-shaking roar as it crashes to the ground! +40 EXP gained.");
        System.out.println("The very ground trembles with the boss's final breath!");
    }
}
