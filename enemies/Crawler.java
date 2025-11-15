// Crawler.java
// Crawler enemy implementation

import java.util.Random;

class Crawler extends BaseStats implements IGroundUnit {
    private Random rand = new Random();

    public Crawler() {
        super("Crawler", 15, 5, 4, 4, 2, 4, 1);
        applyTypeBonus(); // Apply ground unit bonus
    }

    public int getExpAmount() { return 15; }
    public String getEnemyName() { return name; }
    public String getEnemyType() { return "GroundUnit"; }
    public String getDescription() { return "Fast moving ground creature"; }

    public void performAttack(ICoreStats target) {
        int attackType = rand.nextInt(100);
        
        if (attackType < 70) { // 70% melee
            int damage = Math.max(1, getATK() - target.getDEF());
            target.setHP(target.getHP() - damage);
            System.out.println(name + " lunges and claws for " + damage + " damage!");
        } else { // 30% ranged
            int damage = Math.max(1, getRATK() - target.getRDEF());
            target.setHP(target.getHP() - damage);
            System.out.println(name + " spits acidic venom for " + damage + " damage!");
        }
    }

    public void onDefeated() {
        System.out.println(name + " lets out a final screech as it collapses! +15 EXP gained.");
    }
}
