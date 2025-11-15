// Vault101BrainrotRebirth.java
// Main game file

import java.util.Scanner;

public class Vault101BrainrotRebirth {
    private Player player;
    
    
    public static void main(String[] args) {
        new Vault101BrainrotRebirth().startGame();
    }
    
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%##############################%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#%####################################%###%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%############*****************################%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%##########***************************##############%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%###############************++++++++++++**************#########################%");
        System.out.println("%###########################**********+++++==----++---==++++********#####################%%%%%");
        System.out.println("############################***********++++++++==++==++++************####################%%%%%");
        System.out.println("##########################***********+++++++++==-=====+++++***********#####################%%%");
        System.out.println("%#######%%%%%###########************++++++++===------===+++++++*********+*##################%%");
        System.out.println("###################*************+++++++++==-:::::::::-::-=++++++********++*++*******##########");
        System.out.println("####%%%%%%##########*******++**++++++++===-::::::::::::::-===+++++++++++*************#########");
        System.out.println("###%%%%%%%%%%%%######************++++++==::::::::::::::::::-==+++++*******####################");
        System.out.println("####%%%%%%%%%%######***********++++++--::::::::::::::::::::::--++++*******####################");
        System.out.println("####%%%#############***********+++++--::::::::::::::::::::::::--+=+*********##################");
        System.out.println("######%%###########***********++++++=::::::::::::::::::::::::::=+=+*******####################");
        System.out.println("######%%%%%#######************++++++-::::::::::::::::::::::::::=++++-=+****###################");
        System.out.println("#####%############************++++++:::::::::::::::::::::::::::-++++--=+#**###################");
        System.out.println("###%%%###########*************++++==:::::::::::::::::::::::::::--+++=:=+***###########%%%%%%%#");
        System.out.println("%%%%%%%%%%##%%%##**************++++--::::::::::::::::::::::::::==+++==****###########%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%######*********+++==:::::::::::---:::::::::::-=++=+*****############%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%###*********++++=-::::::::-==--:::::::::-+++++*******###########%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%#%###**********++=-::::::::-==:::::::::-+++*********#############%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%##**********+==-:::::::-=-:::::::-=-++************#########*##%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%##++++******+++==--:::---::::-===++*****+=++****############%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%##***********+++++++====-=+++*+********++***####*######**#%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%#******************++++++*************++***##########%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%#*+=***********************************=****######%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%#**********+==++++++++++++++++++++*************##%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%##**####**+=---::::::::::::::----====++++*++****#%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%##*+++++===----::::----:------===+++++*********#%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#************+*++++=+++++++++*********+********%%%%%%%%%%%%%%%%%%");
        System.out.println("@@%%%%%%%%%%%%%%%%%%%%%%%%%%%#**********++*+*+++==+++**+++*****************#%%%%%%%%%%%%%%%%%%");
        System.out.println("@@@@@@@@@@%%%%%%%%%%%%%%%%%%%%##################***###################*****#%%%%%%%%%%%%%%%%%%");
        System.out.println("@@@@@@@%@@%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#####********%%%%%%%%%%%%%%%%%%");

        System.out.println();
        UiUtils.printBox(UiUtils.formatGreenText("Welcome to VAULT 101: BRAINROT REBIRTH"));
        System.out.println();
        System.out.println("You were a cryogenically preserved soldier from before the Great War,");
        System.out.println("frozen in Vault 101 as part of a military experiment meant to outlast civilization.");
        System.out.println("Centuries later, a system failure awakens you to a world utterly transformed -");
        System.out.println("humanity has been wiped out by nuclear armageddon, and in its place,");
        System.out.println("mutated horrors now roam the radioactive wastelands.");
        System.out.println("Now free from your long slumber, you must fight through mutated creatures");
        System.out.println("and find your purpose in a world that has moved on without you.");
        System.out.println();
        System.out.println(UiUtils.formatGreenText("Press Enter to begin..."));
        scanner.nextLine();

        UiUtils.clearConsole();
        
        
        selectCharacter(scanner);
        
        Map stageOne = new Map(player, this);
        stageOne.startGame();
        
        scanner.close();
    }
    
    private void selectCharacter(Scanner scanner) {
        boolean characterSelected = false;
        
        while (!characterSelected) {
            System.out.println(UiUtils.formatGreenText("\nSELECT YOUR CHARACTER:"));
            System.out.println("1. Tralalero Tralala");
            System.out.println("2. Tung Tung Tung Sahur"); 
            System.out.println("3. Cappuccino Assassino");
            
            int choice = getChoice(scanner, 1, 3);
            boolean confirmed = false;

            UiUtils.clearConsole();
            
            while (!confirmed) {
                switch (choice) {
                    case 1:
                        showCharacterDetails("Tralalero Tralala", 
                            "The Brute - High HP, Low AGI, Heal Special\n" +
                            "A sturdy survivor with incredible endurance.\n" +
                            "Specializes in taking hits and healing through damage.");
                            System.out.println();
                            System.out.println("                                        :++.                                     ");
                            System.out.println("                                      :+*#+                                      ");
                            System.out.println("                                    .+***#+                                      ");
                            System.out.println("                                   -***###+                                      ");
                            System.out.println("                                 .*****###*.                                    -");
                            System.out.println("                    :-==++****++++++*****##+                                  =*.");
                            System.out.println("             .-*##***************************                               .*#= ");
                            System.out.println("       :=*######*******************************=                           =*#*  ");
                            System.out.println(" .:*########**########*******#********###########*-                       =*##.  ");
                            System.out.println("=%%%%%%%%%%#####%%####****##%#%#*****###############*:                  .*###=   ");
                            System.out.println("  +#%##%%%%###############%%#@%@#######################*:              :*##%*.   ");
                            System.out.println("    .=+++==-:::::::-=+*###%%#%%@%##########################*+*#*.     =###%#-    ");
                            System.out.println("       :+**++++++++=-::...:..:.=:..::-====++***######%%%%%#######+-:=###%%%+     ");
                            System.out.println("         :++++++========-:-:-.:-::###*-..             ........:::-=+**##%%*      ");
                            System.out.println("            .-=++++++++++++====+=%%%%#**=....    ............::::::::::.         ");
                            System.out.println("                 *#**++++++******#%%%#**+::.........:..:=---::..      .          ");
                            System.out.println("                :%@@:   .-+*****+++#%#***=-----------..##              .         ");
                            System.out.println("                +@@+         .-=+++*%#*#*+====-:     ++###:             .        ");
                            System.out.println("                #@@-               .%%##+             .%#*#-                     ");
                            System.out.println("               -%%@*                %%##=             .@%##=                     ");
                            System.out.println("             .-#@@@@-               %%##:            :=+###=                     ");
                            System.out.println("            .*+++***+              :%%%#            -**=----                     ");
                            System.out.println("            =+******+              +%%%+            *++=----                     ");
                            System.out.println("         .===++******.            #%###.          :==-------:                    ");
                            System.out.println("       .====++******+=          .=#%%%%.        .+==---------                    ");
                            System.out.println("  .:----===+++*****++=        :+=---===-    .:----------=----.                   ");
                            System.out.println(" -+==-===+++++++++=-:.       .++*+------   -*+=-----------:..                    ");
                            System.out.println(" -+++====-.                  =====-----.   .*++=-::...                           ");
                            System.out.println("                          .-------------                                         ");
                            System.out.println("                        .-=----------===                                         ");
                            System.out.println("                    .::-----------=====-                                         ");
                            System.out.println("                  :=-------------=====--                                         ");
                            System.out.println("                  *+=---------------:.                                           ");
                            System.out.println("                   -=-----::::..                                                 ");
                        break;
                    case 2:
                        showCharacterDetails("Tung Tung Tung Sahur",
                            "The Brawler - Balanced stats, PowerHit Special\n" +
                            "A versatile fighter with no major weaknesses.\n" +
                            "Excels at dealing heavy melee damage.");
                            System.out.println();
                            System.out.println("                                           =====--====                           ");
                            System.out.println("                                         ++===========++                         ");
                            System.out.println("                                         ++====-----===+#                        ");
                            System.out.println("                                        *++-==+%@@@%%+=+#                        ");
                            System.out.println("                                       %@@@@#+%@@#**%#++#                        ");
                            System.out.println("                                      %%#**@%+%@*%#++##+#                        ");
                            System.out.println("                                      %%@@+*%-*%+@@@=*#+#                        ");
                            System.out.println("                                      %%@%*#*-==%%###--=#                        ");
                            System.out.println("                                      +#@%+++-++==--==+*%                        ");
                            System.out.println("                                      #+=+*#+===%%%%%%%%%                        ");
                            System.out.println("                                      *#@@%%@@@@=-#@@@@%%                        ");
                            System.out.println("                                       %+@%*@@%*#%%#%@@%%                        ");
                            System.out.println("                                         *%@@@#*#%++#%%%%                        ");
                            System.out.println("                                         +%%@@@#==+*##%%%                        ");
                            System.out.println("                                         =#@%%***#%#####%                        ");
                            System.out.println("                                         ++@@@@@%#****##%                        ");
                            System.out.println("                                         *+@@%%#*****##+*                        ");
                            System.out.println("                                         %*@%#******##%*+                        ");
                            System.out.println("                                         %#@%#*****###%%++                       ");
                            System.out.println("                                         %#%%##****###%@*+                       ");
                            System.out.println("                                         %%%%%###***##%%=*                       ");
                            System.out.println("                                        #%@%%####***##%*+                        ");
                            System.out.println("                                        ##%%%#########%+*                        ");
                            System.out.println("                                        #%%%%##########=*                        ");
                            System.out.println("                                        =#%%%########+**%                        ");
                            System.out.println("                                        @#%%%#######%%#%@                        ");
                            System.out.println("                                         +%%%%%#####%%%@                         ");
                            System.out.println("                                        +#@@@@@%  @%%@                           ");
                            System.out.println("                                      ++*% %%@@   #*#%                           ");
                            System.out.println("                                     *+*%  %#%@   **#%                           ");
                            System.out.println("                                    #+*%   #*#@   ***%                           ");
                            System.out.println("                                   #+*%    %%%%   ###%                           ");
                            System.out.println("                                  +=*%      %%%    %%#                           ");
                            System.out.println("                                 ++*%       %%%    %##%                          ");
                            System.out.println("                               +++#%        %%%%   %#%%                          ");
                            System.out.println("                              +++#%         #%%%   %#%%                          ");
                            System.out.println("                             *++#%#         %%%%   ##%                           ");
                            System.out.println("                           #***#%#           #%%   ##%                           ");
                            System.out.println("                          #***#%%           +*#%   ###                           ");
                            System.out.println("                         ##**#%%         ---+*#%@  =+#%                          ");
                            System.out.println("                        ##*##%%     ##+=-==+*##%%@==+*#                          ");
                            System.out.println("                       @%%%%%%    +++++==+*#%@@@%===+++*                         ");
                            System.out.println("                         @@@       %#++*%@@    =+#+**+#+*                        ");
                            System.out.println("                                              ###%#%#%%%*                        ");
                        break;
                    case 3:
                        showCharacterDetails("Cappuccino Assassino", 
                            "The Assassin - Low HP, High AGI, Snipe Special\n" +
                            "A swift marksman who strikes from distance.\n" +
                            "Uses speed and precision to eliminate targets.");
                            System.out.println();
                            System.out.println("                                                                                  ");
                            System.out.println("                                                                                  ");
                            System.out.println("                                                    #@@@@@%#                      ");
                            System.out.println("                                                   #@@@@*                         ");
                            System.out.println("                         =###%%@@%%%%%%##**=-===*+:@@@@@                          ");
                            System.out.println("                     +#@@@@@@@@@%%%%%%%###*=++**#%%%%%%@.                         ");
                            System.out.println("                    +#%@@@@@@@@@%%%%%%%%##*=+**##%%%%@@@@%:                       ");
                            System.out.println("                    #%@@%%##%%%%%%%%%%####**+++===*#%@@@@%#                       ");
                            System.out.println("                 .*#@@@@@@@@@@%%%%##*****++==+*###%%%%%%%#%-                      ");
                            System.out.println("                -#%%%%%@@%*+====-------------===++#%@%%#%@@%#*                    ");
                            System.out.println("                =#@*+===*%@%%%#+==---:::::--=++#%#%%*+=++*%%*#                    ");
                            System.out.println("                +@@#%@@@@@@%+*==::---%#*%#=  .--+-###%%%%@#*@@.                   ");
                            System.out.println("                  #%@@@@@@%*++==::-:*=#:*-...:----#%%%%%%@@%%                     ");
                            System.out.println("                  +%@@@@@@%*++==---#*---=-...:----###%%%%@%%++-         =%%%-     ");
                            System.out.println("                  .%%@@@@@@@+*==----::::-:...:--+=%%%%%@@@@@@@@@@%*++%%%%%%*      ");
                            System.out.println("                   %%@@@@@@@%##*+====---===++**##%@%%%%%%%@@@@* #@@@@%%%%%%:      ");
                            System.out.println("  :-               %+==--*@@@#:               .#%%%# .:-=#@+ #@@   #@@@=          ");
                            System.out.println("  .-                -:-:...#**@@%%= .   . =@%%@#=%.    ..:-  =@@%              .  ");
                            System.out.println("  .:*               =.::.=.. .%@@*@+:   :#@+@@@+   +   .:-    %%%%-           ::  ");
                            System.out.println("  ..+=              -.:::=..+@@@  ##     **@@@- *. .- ..::    -%%%%%%%%%%     =.  ");
                            System.out.println("   .:+=             ..::--..%@@@@@@+.    =#@@@@@@+ .= ..:=     :%%%%%%%      +:.  ");
                            System.out.println("    -:+.             .::.=..=%@@@@#+     ==%@@@@#..:....:=       +%%%%      *+.   ");
                            System.out.println("     :-+.            -::::*:..+#*-=       -:=##:..+....:-:          :-     +=.    ");
                            System.out.println("      -=+            +:--:.::==-.... .       -+=. .....:=                .++..    ");
                            System.out.println("       .=+           *#%@@@@%%%%%%%%%%#############%%%#*+                *+..     ");
                            System.out.println("        :+*          #%@@@@@@@%%%%%%%%%%%%%%%%%%%%%%%@@@%              .+=.       ");
                            System.out.println("        ..=+         %%@@@@@@@@%%%%%%%%%%%%%%%%%%%%%%@@%%             -+--        ");
                            System.out.println("          :+*      :@@%%@@@@@@@@%%%%%%%%%%%%%%%%%%%%@@@%@@*          ++:-         ");
                            System.out.println("           -+*    +%# *%@@@@@@@@%%%%%%%%%%%%%%%%%%%@@@@% +%#        *+::          ");
                            System.out.println("            :+*  -%*  =%@@@@@@@@%%%%%%%%%%%%%%%%%%%@@@%*  .@#.    -+=-            ");
                            System.out.println("             *@@*+@.  :%@@@@@@@@%%%%%%%%%%%%%%%%%%%@@@%-   .@%#*+#*--             ");
                            System.out.println("            -+%#+%#%.   ================-=-------------    =@#%=#@%               ");
                            System.out.println("            -#%@@@@%#   ::--::.............  ......::=     @%%@@#++=              ");
                            System.out.println("              #@%@@@#   -----::....................::-    -@@@@%@#.               ");
                            System.out.println("               %@@@#%-   --==========-------:::..::-+     #@@@@@=                 ");
                            System.out.println("                 .@@*%+    :+*+=--:::........:-=++:     =@%@%@.                   ");
                            System.out.println("                   *@+%*      %@+            .@@:      #%+@@                      ");
                            System.out.println("                    -#*-      %@              @%-      *#%:                       ");
                            System.out.println("                              #@=            .@@:                                 ");
                            System.out.println("                          -*%@%%%@.         #%%%%@#+                              ");
                            System.out.println("                        #%%%*%%%@@#         @@@@%%#+#%+                           ");
                            System.out.println("                       @@@@%%@@@@@%        #@@@@@%%%%@@:                          ");
                            System.out.println("                       +@@@@@@@@=             +@@@@@@@%                           ");
                            System.out.println("                                                                                  ");
                            System.out.println("                                                                                  ");
                        break;
                }

                switch (choice) {
                    case 1: player = new TralaleroTralala(); break;
                    case 2: player = new TungTungTungSahur(); break;
                    case 3: player = new CappuccinoAssassino(); break;
                }
                
                System.out.println(UiUtils.formatGreenText("\nCharacter selected: " + player.getName()));
                System.out.println("c. Confirm the character and begin your journey...");
                System.out.println("b. Back to character selection\n");

                System.out.print(UiUtils.formatGreenText("Choice: "));
                String confirm = scanner.nextLine().trim().toLowerCase();
                if (confirm.equals("c")) {
                    confirmed = true;
                    characterSelected = true;
                } else if (confirm.equals("b")) {
                    confirmed = true;
                } else {
                    System.out.println(UiUtils.formatGreenText("Invalid choice! Press 'c' to confirm or 'b' to go back."));
                }
                
                UiUtils.clearConsole();
            }
        }
    }

    private void showCharacterDetails(String name, String description) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println(name.toUpperCase());
        System.out.println("=".repeat(50));
        System.out.println(description);
        System.out.println("=".repeat(50));
    }
    
    private int getChoice(Scanner scanner, int min, int max) {
        while (true) {
            try {
                System.out.print(UiUtils.formatGreenText("\nChoice (" + min + "-" + max + "): "));
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) return input;
            } catch (NumberFormatException e) {}
            System.out.println("Invalid choice!");
        }
    }
    
    public boolean triggerCombat(IEnemyEntity enemy) {
        CoreCombat combat = new CoreCombat(player, enemy);
        return combat.startCombat();
    }
}