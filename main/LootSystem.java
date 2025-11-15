// LootSystem.java
// Handles all loot and inventory management

import java.util.Random;
import java.util.Scanner;

public class LootSystem {
    private Random random;
    private boolean playerLeftVault = false;
    private java.util.HashSet<String> lootedLocations = new java.util.HashSet<>();
    private static final String[] LOOTABLE_LOCATIONS = {
        "Engineering Storage", "Pharmacy Shelves", "Clothing Rack", "Office Desk", 
        "Backroom", "Cashier Area", "Kitchen Area", "Broken Tables", "Bar Counter", 
        "Storage Closet", "Restroom", "Behind Counter", "Broken Display Case", 
        "Storage Room", "Cash Register", "Wall Rack Remains", "Overturned Bus", 
        "Broken Newsstand", "Broken Bridge Approach"
    };

    public LootSystem() {
        this.random = new Random();
    }

    public boolean handleLoot(String location, Player player, Scanner scanner) {
        System.out.println("Searching " + location + "...");

        // Check for encounter - ALWAYS CHECK FOR ENCOUNTER EVEN IF ALREADY LOOTED
        double encounterChance = getEncounterChance(location);
        
        if (checkEncounter(encounterChance)) {
            IEnemyEntity enemy = getEncounterEnemy(location, player.getLVL());
            System.out.println(UiUtils.formatRedText("An enemy appears! " + enemy.getEnemyName()));
            // Use CoreCombat directly with the current player
            CoreCombat combat = new CoreCombat(player, enemy);
            if (!combat.startCombat()) {
                return false; // Player died
            }
        } else {
            System.out.println("The area seems clear...");
        }

        // Give loot only if not already looted
        if (!isLocationLooted(location)) {
            giveLocationLoot(location, player, scanner);
            lootedLocations.add(location);
        } else {
            System.out.println("This area has already been looted. Nothing new found.");
        }
        
        return true;
    }

    private IEnemyEntity getEncounterEnemy(String location, int playerLevel) {
        if (location.equals("Broken Bridge Approach")) return new OvergrownBrute();
        
        // Use switch for better performance with string matching
        if (location.contains("Shattered Storefronts") || isStoreLocation(location)) {
            return new Crawler();
        } else if (location.contains("Collapsed Cafe") || isCafeLocation(location)) {
            return new Brute();
        } else if (location.contains("Weapon Shop Ruins") || isWeaponShopLocation(location)) {
            return new Screecher();
        }
        
        return new Crawler(); // Default fallback
    }

    private boolean isStoreLocation(String location) {
        return location.equals("Pharmacy Shelves") || location.equals("Clothing Rack") || 
               location.equals("Office Desk") || location.equals("Backroom") || 
               location.equals("Cashier Area");
    }

    private boolean isCafeLocation(String location) {
        return location.equals("Kitchen Area") || location.equals("Broken Tables") || 
               location.equals("Bar Counter") || location.equals("Storage Closet") || 
               location.equals("Restroom");
    }

    private boolean isWeaponShopLocation(String location) {
        return location.equals("Behind Counter") || location.equals("Broken Display Case") || 
               location.equals("Storage Room") || location.equals("Cash Register") || 
               location.equals("Wall Rack Remains");
    }

    private void giveLocationLoot(String location, Player player, Scanner scanner) {
        switch (location) {
            case "Engineering Storage": equipItem(player, "Steel Bar", 0, scanner); break;
            case "Pharmacy Shelves": addPotion(player); break;
            case "Clothing Rack": equipItem(player, "Leather Head Gear", 2, scanner); break;
            case "Office Desk": equipItem(player, "Crossbow", 1, scanner); break;
            case "Bar Counter": equipItem(player, "Sentinel Vest", 3, scanner); break;
            case "Storage Closet": equipItem(player, "Machete", 0, scanner); break;
            case "Behind Counter": equipItem(player, "Hunting Rifle", 1, scanner); break;
            case "Broken Display Case": equipItem(player, "Ranger Greaves", 4, scanner); break;
            case "Storage Room": equipItem(player, "Vanguard Tacticals", 4, scanner); break;
            case "Cash Register": addPotion(player); break;
            case "Broken Bridge Approach": 
                equipItem(player, "Tactical Headset", 2, scanner); 
                showEndGameMessage(scanner);
                break;
            default: System.out.println("Found nothing useful.");
        }
    }

    private void equipItem(Player player, String item, int slot, Scanner scanner) {
        String[] inventory = player.getInventory();
        String current = inventory[slot];
        
        if (!current.equals("Empty")) {
            System.out.println("You already have " + current + " equipped.");
            System.out.println("Would you like to replace it with " + item + "? (y/n)");
            
            String choice = scanner.nextLine().trim().toLowerCase();
            
            if (choice.equals("y") || choice.equals("yes")) {
                inventory[slot] = item;
                System.out.println("Replaced " + current + " with " + item);
                player.resetBattleStats();
            } else {
                System.out.println("Left " + item + " behind.");
            }
        } else {
            inventory[slot] = item;
            System.out.println("Equipped: " + item);
            player.resetBattleStats();
        }
    }

    private void addPotion(Player player) {
        String[] inv = player.getInventory();
        for (int i = 5; i < inv.length; i++) {
            if (inv[i].equals("Empty")) {
                inv[i] = "Healing Potion";
                System.out.println("Found Healing Potion!");
                return;
            }
        }
        System.out.println("Inventory full - couldn't take potion");
    }

    public boolean checkEncounter(double chance) {
        return random.nextDouble() * 100 < chance;
    }

    private double getEncounterChance(String location) {
        // NO ENCOUNTERS IN VAULT
        if (location.equals("Engineering Storage")) {
            return 0.0;
        }
        
        // BOSS ALWAYS APPEARS
        if (location.equals("Broken Bridge Approach")) {
            return 100.0;
        }
        
        // Chance to encounter an enemy
        if (playerLeftVault && isLootableLocation(location)) {
            return 70.0;
        }
        
        return 0.0;
    }

    private boolean isLootableLocation(String location) {
        for (String lootable : LOOTABLE_LOCATIONS) {
            if (location.equals(lootable)) {
                return true;
            }
        }
        return false;
    }

    public void setPlayerLeftVault(boolean leftVault) {
        this.playerLeftVault = leftVault;
    }

    public boolean isLocationLooted(String location) {
        return lootedLocations.contains(location);
    }

    public int countHealingPotions(Player player) {
        int count = 0;
        for (String item : player.getInventory()) {
            if (item.equals("Healing Potion")) count++;
        }
        return count;
    }

    public boolean useHealingPotion(Player player) {
        String[] inv = player.getInventory();
        for (int i = 0; i < inv.length; i++) {
            if (inv[i].equals("Healing Potion")) {
                inv[i] = "Empty";
                return true;
            }
        }
        return false;
    }

    private void showEndGameMessage(Scanner scanner) {
        System.out.println("\n\n");
        System.out.println("==================================================================");
        System.out.println("                        THE CALM AFTER THE STORM");
        System.out.println("==================================================================");
        System.out.println();
        System.out.println("As the massive Overgrown Brute collapses, a eerie silence falls.");
        System.out.println("The ground stops trembling. The air grows still.");
        System.out.println();
        System.out.println("You stand victorious amidst the ruins, the Tactical Headset");
        System.out.println("now humming with power on your head. For the first time since");
        System.out.println("awakening, you can hear... something else.");
        System.out.println();
        System.out.println("Faint signals. Distant transmissions. Whispers in the static.");
        System.out.println();
        System.out.println("The headset isn't just equipment - it's a key.");
        System.out.println("And now you can hear them calling...");
        System.out.println();
        System.out.println("Other survivors. Other vaults. A resistance.");
        System.out.println();
        System.out.println("This was just the beginning. Your journey has truly started.");
        System.out.println();
        System.out.println("==================================================================");
        System.out.println("                   TO BE CONTINUED IN CHAPTER 2...");
        System.out.println("==================================================================");
        System.out.println();
        System.out.println("Press Enter to accept your destiny...");
        scanner.nextLine();
        
        System.out.print("\033[2J\033[H");
        System.out.flush();
        
        System.out.println("VAULT 101: BRAINROT REBIRTH - CHAPTER 1 COMPLETE");
        System.out.println("Thank you for playing!");
        System.exit(0);
    }
}