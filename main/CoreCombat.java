// CoreCombat.java
// Combat system

import java.util.Random;
import java.util.Scanner;

public class CoreCombat {
    private Player player;
    private IEnemyEntity enemy;
    private Scanner scanner;
    private Random random;
    private boolean playerTurn;
    private boolean encounterMessageShown = false;

    public CoreCombat(Player player, IEnemyEntity enemy) {
        this.player = player;
        this.enemy = enemy;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.playerTurn = player.getAGI() >= enemy.getAGI();
        player.resetBattleStats();
    }

    public boolean startCombat() {
        if (!encounterMessageShown) {
            showEncounterMessage();
            encounterMessageShown = true;
        }

        boolean isStarted = false;

        System.out.println(UiUtils.formatGreenText("\nPlayer stats"));
        displayCombatStatus();
        System.out.print(UiUtils.formatGreenText("\nPress Enter to start combat: "));
        scanner.nextLine();
        UiUtils.clearConsole();

        while (player.isAlive() && enemy.isAlive()) {
            
            if (playerTurn) {
                // displayCombatStatus();
                handlePlayerTurn();
                displayCombatStatus();
                // UiUtils.clearConsole();
                System.out.print(UiUtils.formatGreenText("\nPress Enter to continue: "));
                scanner.nextLine();
                UiUtils.clearConsole();
            } else {
                handleEnemyTurn();
                displayCombatStatus();
                System.out.print(UiUtils.formatGreenText("\nPress Enter to continue: "));
                scanner.nextLine();
                UiUtils.clearConsole();
            }
            
            // Check if combat ended during the turn
            if (!player.isAlive() || !enemy.isAlive()) {
                break;
            }
            
            playerTurn = !playerTurn;

        }
        
        return resolveCombat();
    }

    private void waitForContinue() {
        System.out.println(UiUtils.formatGreenText("\nPress 'c' to continue..."));
        while (true) {
            System.out.print("\nChoice: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("c")) {
                UiUtils.clearConsole();
                break;
            }
            System.out.println(UiUtils.formatGreenText("Press 'c' to continue..."));
        }
    }

    private void showEncounterMessage() {
        System.out.println("\n" + "=".repeat(50));
        String enemyName = enemy.getEnemyName();
        
        if (enemyName.equals("Crawler")) {
            System.out.println(UiUtils.formatRedText("A Crawler appeared!"));
            System.out.println(UiUtils.formatRedText("A fast-moving ground creature emerges from the rubble!"));
                System.out.println();
                System.out.println("                           :*%#:        --+#%+*#=                                 ");
                System.out.println("                         .%@@%#%@#.  .-=%%%%%%**#*- ..                            ");
                System.out.println("                        -@@@@%@%%%@%*:@#@%%%%%#@#+%%+                             ");
                System.out.println("                        *@%@@@@@%*==*%@%@%%%%###*#%+*+.                           ");
                System.out.println("                       -%%%@+ =@#%%##%@@%%#@##**#%**++=-                          ");
                System.out.println("                      .@%##:   .*@@@%%@@@%%%#%%*#%**-++*.                         ");
                System.out.println("                      *#%#       =@@@@%%#@#%%##%##****#%*.                        ");
                System.out.println("                      #%%*        %@@@@#+%##++##**+*####*+                        ");
                System.out.println("                     .%#%*       :%%@@##*+==+=+%%#%%#%###+-                       ");
                System.out.println("                     +#*+-        *=#@+*+*#@@#=%#+#%#@@@%%**=                     ");
                System.out.println("                     @#**+-          :%@**%@%*#%%#*.=%%%%@@###*                   ");
                System.out.println("                    +%#+-:=.          #%*#*%#%%*:.  -*+#%#=*%%+                   ");
                System.out.println("                :=+==+=:---++++..::::-*%@@%@%*#+:...#*%*#*=+-:                    ");
                System.out.println("              :#%%+#**=-:....::=--===++#@@@%%%*****##%##%*+*+.                    ");
                System.out.println("             =+-..+=:.            ..... -%%##=---==+++*#%*=+=*-                   ");
                System.out.println("            :   .=                       +*=:   :=++**=+%**+#+:.                  ");
                System.out.println("                                               .   =##--:+*-.:*#%-                ");
                System.out.println("                                                   +.    -:      .                ");
                System.out.println("                                                                                  ");
                System.out.println("                                                                                  ");
        }
        else if (enemyName.equals("Brute")) {
            System.out.println(UiUtils.formatRedText("A Brute appeared!"));
            System.out.println(UiUtils.formatRedText("A heavy ground fighter lumbers toward you menacingly!"));
                System.out.println();
                System.out.println("                                                                                  ");
                System.out.println("                                                     @%%                          ");
                System.out.println("                            ..+*       ==+#####**##*#%%#                          ");
                System.out.println("                        -+#=****++*******#####+*%*+=+%%%#                         ");
                System.out.println("                       -+*+++*+++=+%**==+####*##+#=--=###%-*                      ");
                System.out.println("                      -=+===++++==*@%*::-#######*---====*%%%#*=-                  ");
                System.out.println("                     -#**===--====#%**:-+#%*##*#*+##%==+*#%%%%%##+**              ");
                System.out.println("                    -++=*+-==+++++*%#*=+*##**##**+====*##%%##%%##%%#*             ");
                System.out.println("                   -#*=--=****%###%%%#=*+#@***##*++=*####%%%%%%%#%%%%#            ");
                System.out.println("                   ++++++=##%%%#%%@@@#*####****##**+####%%%%%@@@%%%%##            ");
                System.out.println("                 ++*+=++#%%%@@@%##%@@@#**##%##%#***##%%%@%%%@@@@%%%%%#%           ");
                System.out.println("                 +**#*##%@@%@%%##%@@@%####%%%%%%%+*##%%@@%@@@@@@%#*%%%#           ");
                System.out.println("               +++***#%@@#%%#%%%%@%#####***+##**#%@@@%@@@@@@@@@@%%%%@%#           ");
                System.out.println("          ##  ++****######%%%%########*%###########%@@@@%%%@@@@@@@@@@%#           ");
                System.out.println("         ##%**+++**%@@%%@@    =-#%#####%@%#%%%%####%%%@@%%%%%#%%@@@@%%@%          ");
                System.out.println("        ###@#**++*#%@@@        +-*###%%#%@@#%%#####*#%%%%%%  %%@%%@@@@@@%%%%      ");
                System.out.println("       **#@%%#*+**%@@%        #*#*###+*#%%%%#%%#%#*%%%%@%       ##@@@@@@@%%#%     ");
                System.out.println("      +*#%%##*%##%#%%        =+**###%#######%%%%%#%%%%%          +#@@@%##%@%@%    ");
                System.out.println("      **#@##%%##%@%%         =-=+*****##*#####@@#%%%%%#=          +*@@%*##%@#%    ");
                System.out.println("     ***@%%@@**###%#         =--+***+*##++*####%%%#*%@#%*==+       +*%@*##%%%#    ");
                System.out.println("     **%%@@%***+++++*%    +***########*%%#####%@@##%#*#%@@###*      +*#%##%@@%#   ");
                System.out.println("     *#%  @#*++*+%@#*%@ ####++#*########%#####%@%%%+*####%%@#%%#     #*******%%%  ");
                System.out.println("     *#    **++**%%    +*#*+=%#**#####%#***###%@@%+*****###%@@%%%     +++==+#%#%  ");
                System.out.println("     *#     *++*#%@% =-#%**+%%######%@%****##%#%@***#***##%*#%#%@     =++***@@#%% ");
                System.out.println("     *       *+*#%@@++#%#+#%########%%%###%%%%@@%###*****#*:*%%#*     +++**#@##@% ");
                System.out.println("             ###%@@%*##%#***##*%%%%%%@@###**%%%%###*#*****+==*####%    *+++****#  ");
                System.out.println("               *#%%**%%@%##++*##%@%@@@@%####%%%%########*++++**+=##  %%%%@**%#**# ");
                System.out.println("                %#%%@%%%%@@#***#%%@@@@@#**##+#%@%#%######***##***##%    #%##%@@@  ");
                System.out.println("                   ++*+%@%%@%####%%@@@ ###%%#%#%%#%%############%%%%#    %@@      ");
                System.out.println("                 =++++%@@@@@%%%%%%%%   #### ####  %%@@%%**###*##%%%%%             ");
                System.out.println("                +++++#%%%%%@%@@@@                       +###%%%%%%%%#             ");
                System.out.println("               ++**+=**#%%%%@@                          **#######%%%%             ");
                System.out.println("            #*****##+**%%%@@%                          *+*****##%%%%%%#           ");
                System.out.println("            =***##%%#%%%%%%%                           ++**######%%%%%##          ");
                System.out.println("           ++#*###%%%%%%@%%%                         **+**#######*#%####          ");
                System.out.println("           +++##%%%%%%%%%%##                          *++++++**##%%%%%%           ");
                System.out.println("           ****%%%%%%@%%@@%#                          ++++*#####%%%%%%%#          ");
                System.out.println("          **####%##%%%%%%%#                             ##%%%%%%%%%%%%%%          ");
                System.out.println("         **###%%%%%%@%%@%%                               #######%@@%%%@%          ");
                System.out.println("         #####%%@@@@@@%                                   +**#%######@@@#         ");
                System.out.println("       *#%%%%%####%%%%%                                  ++*%#*######%%%%%        ");
                System.out.println("      ##%%@@%%##%%%%@@                                   ++*+****#%%%%%%###       ");
                System.out.println("      #%@@@@%%##%@@%                                      ##*++**###%@%%##%%%     ");
                System.out.println("                                                             #**###%@@%%%%%%%     ");
                System.out.println("                                                               %%%%%@@@@@         ");
        }
        else if (enemyName.equals("Screecher")) {
            System.out.println(UiUtils.formatRedText("A Screecher appeared!"));
            System.out.println(UiUtils.formatRedText("A flying mutant descends from above with piercing shrieks!"));
                System.out.println();
                System.out.println("                                                                                 ");
                System.out.println("                                                                                 ");
                System.out.println("                                                                                 ");
                System.out.println("                                                          .=+.                   ");
                System.out.println("                       ..+                               %@.                     ");
                System.out.println("                          *@.                           *@                       ");
                System.out.println("                           @@                           @                        ");
                System.out.println("                           @@@                         @:                        ");
                System.out.println("                           +@@@.                      #@.                        ");
                System.out.println("                            @@@@.                    =@@.                        ");
                System.out.println("                            @@#%@                   -@@@:                        ");
                System.out.println("                            #@@#@+                  @@@@*                        ");
                System.out.println("                            *@@@@%                 @@@@@@=                       ");
                System.out.println("                            @@@#@@                #@@@@@@@   -+ .                ");
                System.out.println("                            #@@%@@               -@@@@#@@@@@%                    ");
                System.out.println("                            @@@@@@              .@@@@@@#@@@@                     ");
                System.out.println("                           :@@@@@@              %@@@@@@@@@@%                     ");
                System.out.println("                           =@@@@@@@.           *@@@@@@@@@@@*                     ");
                System.out.println("                           *@@@@@@@@@         -@@@@@@@@@@@@                      ");
                System.out.println("                           #@@@@@@@#@%        @@@@@@@@@@@@@:                     ");
                System.out.println("                    .-     #@@@@@@@%%@%      #@@@@@@@@@@@@@+                     ");
                System.out.println("                      +    #@@@@@*@@%@@=    :@@@@@@@@@@@@@@%                     ");
                System.out.println("                       #   %@@@@@@%@@@@%    #@@@@@@@@@@@@@@@                     ");
                System.out.println("                       =:  @@@@@@@@@@%=%=   @@@@@@@@@@@@@##@*                    ");
                System.out.println("                        *  @@@@@@@@@@%%@%   @@@@@@@@@@@@@@@%@-                   ");
                System.out.println("                        .%@%@@@@@@@@@@@@## -@@@@@@@@@@@@@@@@@%                   ");
                System.out.println("                         #@@@@@@@@@@@@@%%%%%@@@@@@@@@@@@@@@@@@@                  ");
                System.out.println("                          @%@@@@@@@@@@@@@%%%@@@@@@@@@@@@@@@@@@@@%#%+             ");
                System.out.println("                          *%@@@@@@@@@@@@@%=%%@@@@@@@@@@@@@@@@@@-     .           ");
                System.out.println("                           %%%@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@                   ");
                System.out.println("                            +@@@@@@@@@@@@@%@@@@@@@@@@@#@@@%@@                    ");
                System.out.println("                             +@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@:                    ");
                System.out.println("                              *@@@@@@@@@@%@@@@@@@@@@@@@@@@@#                     ");
                System.out.println("                               @@@@@@@@@@%@@@@@@@@@@@@@@@@@.                     ");
                System.out.println("                                %@@@@@@@@@@@@@@@@@@@@@@@@@#                      ");
                System.out.println("                                 @@@@@@@@@@@@@@@@@@@@@@@#@                       ");
                System.out.println("                                 :@@@@@@@@@@@@@@@@@@@@@@#%                       ");
                System.out.println("                                  #@@@@@@@@@@@@%@@@@@@@@@=                       ");
                System.out.println("                                   @@%@@@@@@@@@@@@@@@@@@@                        ");
                System.out.println("                     .+=-        --#@@@@@@@@@@@@@@@@@@*@@                        ");
                System.out.println("                     +@@%.      -%@@@@@@@@@@@@@@@@@@@@+@%                        ");
                System.out.println("                      .@@@*+*+-.@@@@@%@@@@@%%@@@@@@@@@#%=                        ");
                System.out.println("                       %@@@@@@@@@@@%#%%%%%*@@@@@@@@@@@@@.                        ");
                System.out.println("                       :@@@@@@%@@%@@@@%%*#%@@@@@@@@@@@@@                         ");
                System.out.println("                     ..:@@@@%@#@@@@@@@@%*#@@@@@@@@@@%@@=                         ");
                System.out.println("                      . #@%@@@@@@@@@@@%%%%%@@@@@@@@@@@%                          ");
                System.out.println("                      -+.%@@@@@@@@@@@@@@@@%@@#@@@@@@@@+                          ");
                System.out.println("                   .=-    #@@@@@@@@#@@@@@%%%%@@@@%@@@@                           ");
                System.out.println("               .=++.      @@@@@@@%:*@@@@@@@@#@@#%@@@@=                           ");
                System.out.println("               :*         @@@:     #@@#%@@@@@%@#%%@@%                            ");
                System.out.println("             -+:.        +@@       %@@@@@@@@@@@%%@@@                             ");
                System.out.println("         :    .           -.       @@@@@@+   @@%@@@                              ");
                System.out.println("                        .         .@@@@@     %@@@@=                              ");
                System.out.println("                        +@@%%@@@%%@@@@       %@@@-                               ");
                System.out.println("                       . .- -=#              @@@                                 ");
                System.out.println("                           ## -@            #@.                                  ");
                System.out.println("                          .    .           *@:                                   ");
                System.out.println("                                  ##@**@@**+                                     ");
                System.out.println("                                      #.@@*                                      ");
                System.out.println("                                        -%*.                                     ");
                System.out.println("                                       -@ .:                                     ");
                System.out.println("                                                                                 ");
                System.out.println("                                                                                 ");
                System.out.println("                                                                                 ");
                System.out.println("                                                                                 ");
        }
        else if (enemyName.equals("Overgrown Brute")) {
            System.out.println(UiUtils.formatRedText("The Overgrown Brute appeared!"));
            System.out.println(UiUtils.formatRedText("A massive mutated boss creature blocks your path!"));
                System.out.println();
                System.out.println("                    -#%%#=                                                        ");
                System.out.println("                  .#@@@@@@@%=                                                     ");
                System.out.println("                 .#@@@@@@@@@@@@@*+=:.                                             ");
                System.out.println("                 =@@@@@@@@@@@@@@@@@@@@@@%#+=-*@@@@%#-                             ");
                System.out.println("                -@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%:                           ");
                System.out.println("               =@@%@@@@@@@@@@@@@@@@@@@@@@@#-...=%@%=--%@@*                        ");
                System.out.println("              +@%@@@@@%%#%@@@@@@@@@@@@@@@%-.   -%#:...-%@@@@=                     ");
                System.out.println("             .@@@@@@@@@=.:%@%%%@@@%@@@@@%*:.  .*%#:. ..%@%@@@@@+                  ");
                System.out.println("             =@@@@@@@@@%=*@@%=*@@@%*@@@@#:. .+#@@%*:. .#@@@@@@@%@#.               ");
                System.out.println("             *@@@@@@@@@@@@@@+=@@@%:*@@@@*...+%*++*#*. .+@@@@@@%@@@@=              ");
                System.out.println("             #@@@@@@@@@@@@@@%%@@@@%@@#@@@#-+#+. ..:+..:%@@@@@%@@@@@%-             ");
                System.out.println("            =@@@@@@@@@@@@@@@@@@@@%@@=:@@@@@*.:.   .=+*%@@@@%@@#@@@@@*             ");
                System.out.println("           +@@@@@@@@%@@@@@@@@@%#*+%%:.@@@@#-....  .=@@@@@@@@@%%@@@@@#             ");
                System.out.println("         .%@@@@@@@@@@@@@@@@@@@##=#@*.+@@@@@-.    .:#@@@@#@@@@@%@@@@@=             ");
                System.out.println("         =@@@@@@@@@@@@@@@@@@%%%@@@%#*@@@@@@--  ..-#%@@@@@%@@@%%@@@@%.             ");
                System.out.println("         =@@@@@@@@@@@@@@@@@@+::-=@@@@@@@@@@*:...=#%@@@*%@@@@@@@@@@@+              ");
                System.out.println("         =@@%@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@%%#%@@%@@@@@@@@@@@@@@@@               ");
                System.out.println("        *%@@@@@@@@@@@@@@@@@@#%@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%               ");
                System.out.println("       *@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%               ");
                System.out.println("      :@@@@@@@@@@@@@@@@@@-*@@@@@@####@@@@%@@@@@@@@@@@@@@@@@@@@@@@@#               ");
                System.out.println("     :@%%%@@@@@@@@@@@@@@+  #@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#               ");
                System.out.println("    +@@@@@@@@@@@@@@@@@@-    @@@@@@@@%@@@@@@@@@@@@@@@@@@@@%: #@@@@@%:              ");
                System.out.println("  =%@@@@@@@@@@@@@@@@@@.     -@@@@@%#-+@@@@@@@@@@@@@@%@@@=    #@@@@%-              ");
                System.out.println(" :@@@@@@@@@@@@@@@@@=.        -@@@@@@@@@@@@@@@@@@@@@@@@@+      @@@@@*              ");
                System.out.println(" #@@@@@@@@@@@@@@@=            =@@@@@@@@@@@@@@@@@@@%#@@:       #@@@@@#             ");
                System.out.println(" =@@@@@@@@@@@@@@@#             #@@@@@@@@@@@@@@@@@@@@@-        =@@@@@#+            ");
                System.out.println("  #@@@@@@@@@@@@@%@=            #@@@@@@@@@@@@@@@@@%@@@          +@@@@@%*           ");
                System.out.println("  +@@@@@@@@@@@@@@@=            *@@@@@@@@@@@@@@@@@@@@@-          -@@@@%@*.         ");
                System.out.println("   #@@@@@@@@@@@@%@=           +@@@@@@@@@@@@@@@@@@@@@@*            *@@@@@*         ");
                System.out.println("   -@@@@@@@@@@@@@%.          =@@@@@@@@@@@@@@@@@@@@@@@@             .#@@@@-        ");
                System.out.println("   .@@@@@@@@@@@@@*          .@@@@@@@@@@@@@@@@@@@@@@@@@%              +@@@@.       ");
                System.out.println("    %@@@@@@@@@@@@:          @@@@@@@@@@@@@@@@@@@@@@@@@@@=              .@@@%       ");
                System.out.println("    .@@@@@@@@@@@@          #@@@@@@@@@@@@@@@@@@@@@@@@@@@+               :@@@@%-.   ");
                System.out.println("     @@@@@@@@@@@*         .%@@@@@@@@@@@@@@@@@@@@@@@@@@@*                .%@@@@@#. ");
                System.out.println("    .@@@@@@@@@%@@-        =@@@@@@@@@@@@@@@@@@@@@@@@@@@@%.                  *@@@@% ");
                System.out.println("    -@@@@@@@@@@@@#       :@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@:                   +@@## ");
                System.out.println("     #@@@@@@@@@@+        -@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@:                  :%-*@= ");
                System.out.println("      .@@@@@@@@%-        .@@@@@@@@@@@@%=:-==@@@@@@@@@@@@.                 ::  #-  ");
                System.out.println("         :=:.            :@@@@@@@@@@@:       =@@@@@@@@@+                          ");
                System.out.println("                          %@@@@@@@@@.         *@@@@@@@@:                          ");
                System.out.println("                          #@@@@@@@@-          :@@@@@@@%                           ");
                System.out.println("                          #@@@@@@@-            =@@@@@@%                           ");
                System.out.println("                         :@@@@@@@               #@@@@@*                           ");
                System.out.println("                         -@@@@@@.               :@@@@@#                           ");
                System.out.println("                         #@@@@@@                %@@@@@                            ");
                System.out.println("                         @@@@@@@                %@@@@:                            ");
                System.out.println("                         @@@@@@#                #@@@@                             ");
                System.out.println("                        :@@@@@@-                .@@@-                             ");
                System.out.println("                        @@@@@@@-                .@@@-                             ");
                System.out.println("                        -@@@@@@-                #@@@+                             ");
                System.out.println("                        :@@@@@*                 %@@@@:                            ");
                System.out.println("                        #@@@@@-                 .*%@@@+                           ");
                System.out.println("                       =@@@@@:                     *@@@@%                         ");
                System.out.println("                      =@@@@@+                        #%=                          ");
                System.out.println("                       .+##+                                                      ");
        }
        else {
            System.out.println("A wild " + enemyName + " appeared!");
        }
        
        waitForContinue();
        System.out.println("=".repeat(50));
    }

    private void displayCombatStatus() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("COMBAT: " + player.getName() + " vs " + enemy.getEnemyName());
        System.out.println("=".repeat(50));
        
        System.out.println(UiUtils.formatGreenText("PLAYER STATS:"));
        System.out.println("HP: " + player.getHP() + "/" + player.calculateTotalHP());
        System.out.println("ATK: " + player.calculateTotalATK());
        System.out.println("DEF: " + player.calculateTotalDEF());
        System.out.println("RATK: " + player.calculateTotalRATK());
        System.out.println("RDEF: " + player.calculateTotalRDEF());
        System.out.println("AGI: " + player.calculateTotalAGI());
        System.out.println("ACC: " + player.calculateTotalACC());
        System.out.println("ENE: " + player.getENE() + "/" + player.calculateTotalENE());
        
        System.out.println(UiUtils.formatRedText("\nENEMY STATS:"));
        System.out.println("HP: " + enemy.getHP());
        System.out.println("ATK: " + enemy.getATK());
        System.out.println("DEF: " + enemy.getDEF());
        System.out.println("RATK: " + enemy.getRATK());
        System.out.println("RDEF: " + enemy.getRDEF());
        System.out.println("AGI: " + enemy.getAGI());
        System.out.println("Type: " + enemy.getEnemyType());
        System.out.println("=".repeat(50));
    }

    private void handlePlayerTurn() {
        System.out.println("\nYOUR TURN!");
        
        while (true) {
            System.out.println(UiUtils.formatGreenText("Choose your action:"));
            System.out.println("1. Melee Attack");
            System.out.println("2. Ranged Attack");
            System.out.println("3. Special: " + player.getSPEC());
            System.out.println("4. Use Healing Potion");
            
            int choice = getChoice(1, 4);
            boolean actionSuccessful = false;
            
            switch (choice) {
                case 1: 
                    actionSuccessful = meleeAttack();
                    break;
                case 2: 
                    actionSuccessful = rangedAttack();
                    break;
                case 3: 
                    actionSuccessful = useSpecial();
                    break;
                case 4: 
                    actionSuccessful = useHealingPotion();
                    break;
            }
            
            if (actionSuccessful) {
                return;
            } else {
                System.out.println("Choose a different action!");
            }
        }
    }

    private boolean meleeAttack() {
        // Check if enemy dodges (15% base + AGI * 3)
        int enemyDodgeChance = 15 + (enemy.getAGI() * 3);
        if (random.nextInt(100) < enemyDodgeChance) {
            System.out.println(enemy.getEnemyName() + " swiftly dodges your melee attack!");
            return true;
        }
        
        int damage = Math.max(1, player.calculateTotalATK() - enemy.getDEF());
        enemy.setHP(enemy.getHP() - damage);
        System.out.println("You strike true with your weapon for " + damage + " damage!");
        return true;
    }

    private boolean rangedAttack() {
        if (player.getInventory()[1].equals("Empty")) {
            System.out.println("No ranged weapon equipped!");
            return false;
        }
        
        // Check if enemy dodges (20% base + AGI * 5 - ACC * 5)
        int enemyDodgeChance = 20 + (enemy.getAGI() * 5) - (player.calculateTotalACC() * 5);
        enemyDodgeChance = Math.max(0, Math.min(100, enemyDodgeChance)); // Clamp between 0-100
        
        if (random.nextInt(100) < enemyDodgeChance) {
            System.out.println(enemy.getEnemyName() + " evades your ranged attack!");
            return true;
        }
        
        int damage = Math.max(1, player.calculateTotalRATK() - enemy.getRDEF());
        enemy.setHP(enemy.getHP() - damage);
        System.out.println("Your shot finds its mark for " + damage + " damage!");
        return true;
    }

    private boolean useSpecial() {
        String spec = player.getSPEC();
        
        switch (spec) {
            case "Heal":
                if (player.getENE() < 5) {
                    System.out.println("Not enough energy! Need 5 ENE.");
                    return false;
                }
                int heal = (int)(player.calculateTotalHP() * 0.25) + (player.calculateTotalATK() / 2);
                player.setHP(Math.min(player.calculateTotalHP(), player.getHP() + heal));
                player.useEnergy(5);
                System.out.println("You channel healing energy, recovering " + heal + " HP!");
                return true;
                
            case "PowerHit":
                if (player.getENE() < 6) {
                    System.out.println("Not enough energy! Need 6 ENE.");
                    return false;
                }
                // PowerHit ignores enemy defense
                int damage = (int)(player.calculateTotalATK() * 1.6);
                enemy.setHP(enemy.getHP() - damage);
                player.useEnergy(6);
                System.out.println("You unleash a devastating PowerHit for " + damage + " damage!");
                return true;
                
            case "Snipe":
                if (player.getENE() < 7) {
                    System.out.println("Not enough energy! Need 7 ENE.");
                    return false;
                }
                // Snipe ignores enemy defense
                int snipeDamage = (int)(player.calculateTotalRATK() * 1.5);
                enemy.setHP(enemy.getHP() - snipeDamage);
                player.useEnergy(7);
                System.out.println("You take careful aim and snipe for " + snipeDamage + " damage!");
                return true;
        }
        return false;
    }

    private boolean useHealingPotion() {
        LootSystem loot = new LootSystem();
        if (loot.countHealingPotions(player) > 0 && loot.useHealingPotion(player)) {
            int heal = 8;
            player.setHP(Math.min(player.calculateTotalHP(), player.getHP() + heal));
            System.out.println("You quickly drink a Healing Potion, recovering " + heal + " HP!");
            return true;
        } else {
            System.out.println("No healing potions available!");
            return false;
        }
    }

    private void handleEnemyTurn() {
        System.out.println(UiUtils.formatRedText("\n" + enemy.getEnemyName() + "'s turn!"));
        
        // Check if player dodges (15% base + AGI * 3)
        int playerDodgeChance = 15 + (player.getAGI() * 3);
        if (random.nextInt(100) < playerDodgeChance) {
            System.out.println("You skillfully dodge the enemy's attack!");
            return;
        }
        
        enemy.performAttack(player);
    }

    private int getChoice(int min, int max) {
        while (true) {
            try {
                System.out.print(UiUtils.formatGreenText("\nChoice (" + min + "-" + max + "): "));
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) return input;
            } catch (NumberFormatException e) {}
            System.out.println("Invalid choice!");
        }
    }

    private boolean resolveCombat() {
        if (player.isAlive()) {
            System.out.println("\n*** VICTORY! ***");
            player.gainEXP(enemy.getExpAmount());
            enemy.onDefeated();
            return true;
        } else {
            System.out.println("\n*** DEFEAT! ***");
            return false;
        }
    }
}