// Map.java
// Stage 1 map navigation

import java.util.Scanner;

public class Map {

    private Player player;
    private Scanner scanner;
    private LootSystem lootSystem;
    private String currentArea = "Vault 101";
    private Vault101BrainrotRebirth game;
    private int stepCounter = 1;

    // First visit flags for each area
    private boolean firstTimeStorefronts = true;
    private boolean firstTimeCafe = true;
    private boolean firstTimeWeaponShop = true;
    private boolean firstTimeBossArea = true;

    public Map(Player player, Vault101BrainrotRebirth game) {
        this.player = player;
        this.scanner = new Scanner(System.in);
        this.lootSystem = new LootSystem();
        this.game = game;
    }

    public void startGame() {
        System.out.println("=== Vault 101: Brainrot Rebirth ===");

        while (player.isAlive() && !currentArea.equals("COMPLETED")) {
            displayArea();
            handleInput();
        }

        if (player.isAlive()) {
            System.out.println("\n*** STAGE 1 COMPLETED! ***");
        }
    }

    private void displayArea() {
        // System.out.println(UiUtils.formatGreenText("\n================================="));
        UiUtils.printBox(UiUtils.formatGreenText(String.format("[STEP %d] Location: %s", stepCounter, currentArea)));
        // System.out.println(UiUtils.formatGreenText("================================="));

        switch (currentArea) {
            case "Vault 101":
                displayVault101();
                break;
            case "Run-Down Town":
                displayRunDownTown();
                break;
            case "Crumbled Main Street":
                displayMainStreet();
                break;
            case "Shattered Storefronts":
                displayStorefronts();
                break;
            case "Collapsed Cafe":
                displayCafe();
                break;
            case "Weapon Shop Ruins":
                displayWeaponShop();
                break;
            case "Broken Bridge Approach":
                displayBossArea();
                break;
        }
    }

    private void displayVault101() {
        System.out.println(UiUtils.formatGreenText("The familiar hum of Vault machinery surrounds you."));
        System.out.println("1. Engineering Storage" + (lootSystem.isLocationLooted("Engineering Storage") ? " [LOOTED]" : " [LOOT]"));
        System.out.println("2. Leave Vault 101");
        System.out.println("s. View Stats");
        System.out.println("i. View Inventory");
    }

    private void displayRunDownTown() {
        System.out.println("You step out into the radioactive wasteland.");
        System.out.println();

        System.out.println("******######*****************************************************************************#%%**");
        System.out.println("*****************************************************************************************#@@**");
        System.out.println("***************+++++++++++++++++++++++++++++++++++************************************#@@@@@@@");
        System.out.println("******+++++++++++++++++++++++++++++++++++++++++++++++++++++++*******************#%%@@%%@@@@@@@");
        System.out.println("+++++++++++++++++++++++=+==========================+++++++++++++%%*+++++++++++%@@@@@@%%@@@@@@@");
        System.out.println("+++++++++++++++++=============================================+@@@@+++++++++++%@@@@@%@@@@@@@@@");
        System.out.println("++++=================================+*+=====================*@@@@@@#======+*%@@@@@@@@@@@@@@@@");
        System.out.println("=============================--======%@@#===================%@@##*#%@@======*@@@@@@@@@@@@@@@@@");
        System.out.println("==================-------------------#@@#=-------------===+@@%#*+++*#@@*-==--*@@@%@@@@@@@@@@@@");
        System.out.println("=========---------------------------:*@@+-------::::::-::+@@#*+*@%==+*%@#::*%@@@@@@@@%@@@@@@@@");
        System.out.println("-----------------------------::::....%@@+::::.::........#@%*++%@@##=-++#@%+##@@@@@@@@@@@@@@%@@");
        System.out.println("=**+=------------=************+++++++%%##+++++++++++++*@@#+===#@###-::=+*%@@%@@@@@@@@@@@%%%@@@");
        System.out.println("+###%#+-----=:::-+***+*****++++++++++++++++++++++++++%@#*+====+####-:::=+***@@@%%%@@#@@@@@@@@@");
        System.out.println("#@@@%%@%#**##*-:=++*++++++++++++++++++++++++++++++++@%*#+===-:=####=:::::+*#*%@@@@%%@@@%%@@@@@");
        System.out.println("%@@%%@@@@%@@%#+*****+++++++++++++++++++++++=+++=++#@@@@*===-::----=-::::::+@%@@%%@@@@#%##@@@@@");
        System.out.println("@@@@@@@@@@%@@@@*+++++++++++++++++++++++++++++++++*@@@@@@@@#%@@@@@@@@@@#+++*@@@@@@%@@@%#%@@@@@@");
        System.out.println("@@@@@%@@@@%@@@%++*+++++++++++=++++++=++++==++===+*@@%==--:::@@@@@@@@@%=-::-=+@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@%@@@@%##@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%@@@#----:::++=-%%+*#*=-----+%@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@+-#+++#@@@@@+++*@@@@@++++++*@@@@@#*#%#=-:--:-+*++@%+*##==-----%@@@@@@@@@@@@@@@@");
        System.out.println("@@%%@@@@@@@@@@@%##==-=@##%+----%*##*----===#*++#===%#-------+%%#%*+**+---====#@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@*---=@**#+----%*#%+-------**++#===%=:::::::=@###*=+++-------*@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@%%%@@@@@@@@@*=---#%@%-::::%@@*-:::::::+++++:::*+-----:-*#********-::::--*@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@+----++%#=-===#%%**##*****#####***#*-::-+*#@@@@@@@@@@@%*=-:-+@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#--=%@@%@@@@@@@@@@@@@@#-:*@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@%###@%###@@###@@###@@@@@%%@@%%%@@@*:::-**+=++#%@%#+=*#@*+--*@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@#%@%%@%%#@%#%%%%%%##@@%@@@@@@@@%@@#---:+@@#+*@@@@@@+%@@++--*@@%%##%###@@@@@@");
        System.out.println("@@@@@@@@@@@@@@%+#@@**++==++@#++**%**#@**@@@@@@@@@@#*#----:%*===@@@@@#:#@#++--+@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@++++++*#@##%@%%@@@%=+@@@#@@@@@@+=#=----#====@@@@@#:#@#++-:+@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@+==@@@%%@@@@@@@%%@@@@@@@@=*@@@@@@@@@@+=*::::.#+===@@@@@%:%@%++--+@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@*%=%@%%%@@@@%%@%%%@%@@%%%=*@@@@@@@@@@+=*-=-=-#+===@@@@@%:#@%++--+@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@+#-%%@+--*=--++++*#*+****+*@@@@@@@@@%++##*##%**===@@@@@%:#@@++-=+@@@@@@@@#####*#@");
        System.out.println("@@@@@@@@@@@@@*%-%%%#***+***#####%%@%#%##@@@@@@@@@###%%#%#%%%##@@@@@@@%@@@**=*##%%%####%##%%%##");
        System.out.println("@@@@@@@@@@@%##%*#*###%%####%@@%@@@@@@@@@@@@@@@@@@%@@%@%@@@@@@%#******@@%@+*%%@%@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@#%%%@%@@#*%%@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@%@@@@@@@%%%%%%#%%%%%%%@@@@@@%@@@@@@@@@@@@@%@@@@@@@@@@@%#####%@@%%#@@@@@@@@@@@@@@@@@@@");
        System.out.println("@%%#**#%##*****++***********+*********************************+*************#*##*##*#*##*#####");
        System.out.println("************************************##*****#********##*****#**########*##########%%%%######%##");
        System.out.println("####*####********+++****************************+************###***###***##*#***###*#*########");
        System.out.println("****+***************+*+*************#*##***********#**********************#*********##########");
        System.out.println("%%@@@@@@%###****###############**#####*#*****##****#*##*#**###****#*****###########****#######");

        System.out.println();
        System.out.println(UiUtils.formatGreenText("Press 'c' to continue to Crumbled Main Street..."));
    }

    private void displayMainStreet() {
        System.out.println(UiUtils.formatGreenText("Crumbled Main Street - The heart of the ruined town."));
        System.out.println("1. Shattered Storefronts");
        System.out.println("2. Collapsed Cafe" + (player.getLVL() < 3 ? " [LOCKED - Level 3]" : ""));
        System.out.println("3. Weapon Shop Ruins" + (player.getLVL() < 4 ? " [LOCKED - Level 4]" : ""));
        System.out.println("4. Broken Bridge Approach" + (player.getLVL() < 5 ? " [LOCKED - Level 5]" : ""));
        System.out.println("s. View Stats");
        System.out.println("i. View Inventory");
    }

    private void displayStorefronts() {
        if (firstTimeStorefronts) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("SHATTERED STOREFRONTS");
            System.out.println("=".repeat(50));
            System.out.println("Broken glass and debris cover what was once a bustling shopping district.");
            System.out.println("The skeletal remains of stores stand as monuments to a lost civilization.");
            System.out.println("Something moves in the shadows...");
            System.out.println("=".repeat(50));
            System.out.println();

            System.out.println("@@@@@@@@@@@@@%@##=.##=@@@@@@@%@@@@@@@@@@@@@@@=:+*#.+@@@@%%#:%#+#*@##*##%##**++*:. .=.        .*=+@@@");
            System.out.println("@@@@@@@@@@@@@%@##=.%+#@@@@@@@@#@@@@@@@@@@@@@@:.:*#.+@@@@@%#:+==**%*+-+*%@@%****....=         =#%+@#@");
            System.out.println("@@@@@@@@@@@@@%@##=.@#+@@@@@@@@@@@@@@@%%@@@@@@: .+*.+%@@@@@*.=+*#+%+=.:*%%@#++++....-     .   .#%#@@%");
            System.out.println("@@@@@@@@@@@@@%%*#=.@%#%@@@@@@@@@@%%@@@%%@@@@@+ .+*.+%*@@@%*.#*+###+-.=#%@@#=+=@%.- .  .    ..=+=%%%%");
            System.out.println("@@@@@@@@@@@@@%%*#+.@#-:*@@@@@@@@@@#@@%***#*@@@.:+*.+@@@@@@+:%#+%@*+-*@##%%++#+==+:  -:=.  .: +*.#@@@");
            System.out.println("@@@@@@@@@@@@@%%*#+.###%+@@@@@@@@@@@@@%*@@@@@@@#-+*.=+##%%%+.%#%#@#=-@@##%#==@*#*+++  .#+-+-:. =. #@@");
            System.out.println("@@@@@@@@@@*@@%%*#*.@@###@@@@@@@#@@@@%%--#%@@@@@%+#.=%::*#++.#+#@@#=:@@+=##:.#+%*@***  -:=+*+ ...++**");
            System.out.println("@@@@@@@@@@%@@%%*#*.%@+##*#@@@@@@@@@@@@%@@@@@#@##=*.+%..+.-=..=#@@*=:%%+:=*:.%-*+%*%*+ ..--=*:.   .+*");
            System.out.println("@@@@@@@@@@@*%%%##*.%#%@@@%%@%@@@@@@@@@@@@@@@%##%+*.=%##*-==..=-#@*=:#%+-+*:=%+*-#-@#%#**::++*++===-#");
            System.out.println("@@@@@@@@@@@@@@%#**.@@#@@@@@@@@%==:*@%#@@@@@@**@@**.+%@@%**=.+=+--+=-::==+*.+%++:*=@##@@#=:===+#*#==#");
            System.out.println("@@@@@@@@@@@@@%%***-@@=@@@@@==--+%#---=#@@@%+=+@@*#.=@@@@+-=.*+*@@*=+@@+=-+..#++:+=%%+*=:=*:==#**+*#@");
            System.out.println("@@@@@@@@@@@@@%%***.#@%@@@+--#@@@%@@*=:+@%%+:+@@@**.:-==+--=.=-+#*+==##=:.-..#+=.==#*-*=:-%+=*%*#=-==");
            System.out.println("@@@@@@@@@@@@@%%*++.##++-=%@%@@@@%@@#%+--#+::@@@#**.:=-...:=.:::..-=..:..:-.-#-=.--#+:*..:=*=+:.=:...");
            System.out.println("@@@@@@@@@@@@@%%*++.=+####@@@*#@@@@@@%%+=::.#@@@+**..---:..-.:.:::==..*:  :..+.=.--*=-*   ..-...-##..");
            System.out.println("@@@@@@@@@@@@@@%*+*.*%%*@#%%#%#%#%%@@%%#=+-:#@@@:*+.-=-+-.:-:+==**==.-+.  :. + -.=:--:..........@@%#+");
            System.out.println("@@@@@@@@@@@@@@##++.-:+##+%@@@@@*=**#+*+=##+-=@#-+=.:......-......-=.--...:..*.  .........=--....:..:");
            System.out.println("@@@@@@@@@@@@@@##++.#*+-#%%#%%%+++=+=%%*+*##*+-+*+-........-......-=:::...-.  ......   ...    .......");
            System.out.println("@@@@@@@@@@@@@@##++.**@%-=%%%#+#%%*#@*#+##*+%%+=+--.......:-......==:...  .:.::.   ... .  ...........");
            System.out.println("@@@@@@@@@@@@@@##++.==%@@+:**%%%##%#=++++*%*%%%#==+........=..... .+.    ...          ...............");
            System.out.println("@@@@@@@@@@@@@@##++.+#%@@@#:=#%**#*#-=+=**#+###*-==+-.....:=.     .... ......             ...........");
            System.out.println("@@@@@@@@@@@@@@#*=+.+%%##%%%++-+++=====+==++===--=--+*=........ .... .............................:::");
            System.out.println("@@@@@@@@@@@@@%%#=+.##########+=*+======+=-=-=:=::...=+#=.........     . ...:... ................::::");
            System.out.println("@@@%%%%%%#####%#=+.*******++++++====-:::::...........:*=*. ... ..  ..  .:.:. :.  ...............::::");
            System.out.println("%%############%#++.#*++======+==+=-.. .....:...........=+**.  .    . .....:.. .... .....:=-:-:..-:.:");
            System.out.println("*%%*****=+##*%@#++.+*+%%++:::++=::#-....:................##%+... . . .    ............ .::::....-:::");
            System.out.println("****####%%%%%%@%+*.+::::::=-:=-::::+%=.........:...........%%%+................................:--:-");
            System.out.println("+****++*+++==::-=#::..:--=+*+**+-=*+*@%+-:........:--.::=*#%%+=:...........::.:::......:::::::::-=:-");
            System.out.println("=+++=-:::......::#:---=++*****#***#*#%@@%******%%%#++*%@%@#+:........:..::=%%%*-:......:..+#:....:..");
            System.out.println("--::...::..::-+**+==++=---===-==--==-::::::::.:-=++++====--...........:::::.:::::::::-=-=-*@@@@@@@%#");
            System.out.println(".:-:::+#=--=+**+==--------::-::::::::::::::::::::-:::::--=-::::....:....::::.::::::::+%@@#+----==*==");

            System.out.println();
            System.out.println(UiUtils.formatGreenText("Press 'c' to continue exploring..."));
            waitForContinue();
            firstTimeStorefronts = false;
        }

        System.out.println(UiUtils.formatGreenText("Shattered Storefronts - Broken glass everywhere."));
        String[] locations = {"Pharmacy Shelves", "Clothing Rack", "Office Desk", "Backroom", "Cashier Area"};
        for (int i = 0; i < locations.length; i++) {
            System.out.println((i + 1) + ". " + locations[i] + (lootSystem.isLocationLooted(locations[i]) ? " [LOOTED]" : " [LOOT]"));
        }
        System.out.println("b. Back to Main Street");
        System.out.println("s. View Stats");
        System.out.println("i. View Inventory");
    }

    private void displayCafe() {
        if (player.getLVL() < 3) {
            System.out.println("Area too dangerous! Need level 3.");
            currentArea = "Crumbled Main Street";
            return;
        }

        if (firstTimeCafe) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("COLLAPSED CAFE");
            System.out.println("=".repeat(50));
            System.out.println("The smell of old coffee and decay fills the air.");
            System.out.println("Broken tables and chairs are scattered everywhere.");
            System.out.println("This place hasn't served customers in decades.");
            System.out.println("=".repeat(50));
            System.out.println();

            System.out.println("+=:....:=================++++**++=======-:::::.............::..:::::::-+++++++++==============");
            System.out.println("+=:....:-================++++**++=======-:::...............::..:::::::-+++++++++==============");
            System.out.println("+=:....:-================++++**++=======-:::..............:..::.::::::-+++++++++==============");
            System.out.println("+=:....:-================++++**++=======-:::..............:.....::::::=+++++++++==============");
            System.out.println("+=:....:-================+++++*++=======-:::...................:::::::=+++++++++==============");
            System.out.println("+=:.....-================+++++*++=======-:::............:..:.:::..::::=+++++++++==============");
            System.out.println("+=-.....-=================++++*++=======-:::.....................:::::=+++++++++==============");
            System.out.println("++-.....-=================++++*++=======-:::..................::::::::=+++++++================");
            System.out.println("++-.....-=================++++++========--::.............::::....:::::=++++++=================");
            System.out.println("++-.....-=================+=*+*+=++*+===--::............::::::::::::::=++++++=================");
            System.out.println("++-.....-==================+=*++=++***==-:::............::::::::::::::=++++++=================");
            System.out.println("++-.....-=================+++++++****#*=-:::.............:::::::::::::=++++++=================");
            System.out.println("++-.....-=================++-+**+****+*=-:::.............::::.::::::::+++++++=================");
            System.out.println("++-.....-==================+=+++#****##+-:::...................:::::::+++++++=================");
            System.out.println("=+-.....-====================++***#*+*#+-:::..............:......:::::+++++++=================");
            System.out.println("=+=.....-====================++***#*+*+=-:::.....................:::::+++++++=================");
            System.out.println("=+=.....-==================+=**#****+===-:::....................::::::++++++++================");
            System.out.println("++=.....-=================++==**##*+====-:::......................:::-++++++++================");
            System.out.println("++=:....-================+=+=****#*+====-:::.......................::-++++++++================");
            System.out.println("++=:....-==============+++==+*+*#*+++===-:::.......................::-++++++++================");
            System.out.println("++=:....-==========+==++++==*+*##*+++===--::......................:::-+++++++++===============");
            System.out.println("++=:....-========++++*##**++***#**+++++=--::......................:::=+++++++++===============");
            System.out.println("++=-....-=+==++=+++++*=-+#%%%%%%#*+++++=--:::::..:.................::=++++++++++==============");
            System.out.println("++=-:...-+++++++**+*+:-*#%%%%%%%%%*++++=---::::::::........:......:::=++++++++++==============");
            System.out.println("+++-:::.-++++++++***=-*##%##%%%%##*+++++=----:::::::.............::::++++++++++++=============");
            System.out.println("+*+=-:::=+++-++++*#*++**##*###**##*+++++=-------::::::.......:...::::++++++=--::-=+===========");
            System.out.println("+*+=-:::=++-=#%#%%%%******+#%###*#+-*#*+==-=----::::.............::::+++++=-:::::-+*+=========");
            System.out.println("+*+=--::=+++****###%#+=+++=**##**+-=##*##+===---::::.............::::++++=:::::::-=#*+========");
            System.out.println("+++==-::=++***####%%%*==+++**##*+++#%##***+==---:::::.............:::+++=::::::::--##*========");
            System.out.println("+*+==--:=+***#%%###%%#%*+*#%%#####%%%%###*#++=++--:::::.........:::::++=-::::::::--##*========");
            System.out.println("++++=---=*+==++++=+=-----:=**+-:------=====---=+=--:::::...........::++-::::::::--=##*========");
            System.out.println("+*+=-:...:::::::::::::::-:-=+=::-=------:::::::::::::::::.........:::++-::::::::--*##*========");
            System.out.println("+===-:::.::::::::::::::::.:---::========---:::--===::::::::::.:::.:::+=:::::::::--###+========");
            System.out.println("*+++=+++++++===-----------------------====+++++++=--:::::::::::::::::+=::::::::--+##*=========");
            System.out.println("*+++++*##%%##%@%%%##*#***************@@%%##*+++++=----:::::::::::::::+=::::::::-=###==========");
            System.out.println("*+++++*++#####%%*+*##%#########*****#@%%%##**++++=----:-:::::::::::::++::::::::=#%#+==========");
            System.out.println("******+++#####%%*+*##%%#######******#@%%%%#***+++===-----::::::::::::++-:::::-=#%#*=====+***+=");
            System.out.println("=========*#+++***+*##%%#######*****##@%%%%##***++===------:::::::::::++=-:::-+#%#+++========*#");
            System.out.println("---------+*=--===*###%%#######******#@%%%%##***+++===-----::::::::::-+=+#*=+#%#+++++====++++=+");
            System.out.println("---------+*=-==+**#%%%%#######*****##@%%%%##****++====---------::::::+=*%++=*%++++++===+++++=+");
            System.out.println("-------==**+++#%%%@@%@%########**####@%%%%##***++=-:::::::::::::::::-==##===##++++++++++++++=+");
            System.out.println("++***##%%%@@@@@@@@@@%@%%%%###########@@%%%*=-----------------------------==+%*++++++++++++++++");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@%%%%##########@@%%*====++++================------=++#%+=+++++++++++++*#");
            System.out.println("@@@@@@@@@@@@@@@@@@@@%@@%%%###########@@%@@*++***####**********************%@+====++++++++***#@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@%%%%%#########@@%@%########%%%%%%%################*+======+++**#%@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@%%%%%#########@@@@%#####**%@@%@@@@@%##****@=--==+*%@*==+++***###%@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@%%%%%%#######%@@@@%#######@*+++++===------%#-======*@*=++***####%@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%#####%%@@@@%%%####%@#+++++===------=@-=======##+++***####%@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%@@@@@%%%%%##%@#**+++====------%*=======*@*++***####%@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%@@@@@@@@%%%%%#%@#***+++====-----+@+=======#%*+**#####%@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%#%@#****+++====-----@#=====+++%#***#########@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%@@%*****+++====----*@++===+++#@***#########***");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%@@@%%%%%%%%@@%#####*+++====-=--@*++=+++++%%**#####%%##***");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%#@@@#####***%@##*####***+===--=-%@++=++++*#@##%%%%%%%###**");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%%%%@@@####****%@#********++++++===*@*+*###%%%@@%%%%%%@@@%###");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%%###@@@###*****%@**+*******++++++++*%@#####%%%%@%%%%%%%%%%@@%");
            System.out.println("@@@@@@@@@@@@@@@@@%%@@@@@%%%%%%%%%%###@@@#****+++%@**+++++=+++++++++++++++*******#@############");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%#@@%##***++*%@*++++=+++++++++++++++++++++++++@%+++++++++**");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@%%%%%%%%%%#####%@@%*******+%%*+++++++++++++++++=++==++++++++*@*++++++++++");
            System.out.println("@@@@@@@@@@@@@@%%%%%@@%%%%%%%%%%######%##@#*****+%%**+++++++++++++++++++++++++++*+*%@++++++++++");
            System.out.println("@@@@@@@@@@@@@%%%%%%@@%%%%%%%%%##########%#******%%***+*****++++++++*++++++*******+*@%++++++***");
            System.out.println("@@@@@@@@@@@@@@%%%%%@@%%%%%%%%#######%%@%#*****++%%*********++********+++++++*******#%#********");
            System.out.println("@@@@@@@%%@@@@@@@@@%@@%%%%%%%%%%%%@@@%%#####*****%%*+++************++++++++++++++**************");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%#######*******###*%%#***+++*********+++++++++++*++++*+**********");

            System.out.println();
            System.out.println(UiUtils.formatGreenText("Press 'c' to continue exploring..."));
            waitForContinue();
            firstTimeCafe = false;
        }

        System.out.println(UiUtils.formatGreenText("Collapsed Cafe - Smell of decay fills the air."));
        String[] locations = {"Kitchen Area", "Broken Tables", "Bar Counter", "Storage Closet", "Restroom"};
        for (int i = 0; i < locations.length; i++) {
            System.out.println((i + 1) + ". " + locations[i]
                    + (lootSystem.isLocationLooted(locations[i]) ? " [LOOTED]" : " [LOOT]"));
        }
        System.out.println("b. Back to Main Street");
        System.out.println("s. View Stats");
        System.out.println("i. View Inventory");
    }

    private void displayWeaponShop() {
        if (player.getLVL() < 4) {
            System.out.println("Area too dangerous! Need level 4.");
            currentArea = "Crumbled Main Street";
            return;
        }

        if (firstTimeWeaponShop) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("WEAPON SHOP RUINS");
            System.out.println("=".repeat(50));
            System.out.println("Broken firearms and empty shelves line the walls.");
            System.out.println("Maybe something useful survived the destruction...");
            System.out.println("The air feels heavy with anticipation.");
            System.out.println("=".repeat(50));
            System.out.println();

            System.out.println("**#**#%#*########**##**+**%@@%%%%%%@@@@@@%*++*%##**+++==+++++++++++++*###############%***=*#%@");
            System.out.println("***######%%%%#%%%#*##*%#%@@%@@@%%%%##%%@@@@@%*+#@%#*#*+++++++++++*#%%%##############%%@%##%@@%");
            System.out.println("***###+*****%%%%%#%%%%%@@@@@@@%####**#*#%@@@@@@*#@%%#*+++++++*#%#%%%%%#######%###%@@@@%@##%+*#");
            System.out.println("%######*%%#%#####*%%@%@@@@@@@%#*+*#*===+#%%%%@@@@@%@%###**#%%%%#*#%%%%#%%###%@@@@@@@@%%%@%%%#@");
            System.out.println("#*%%###%######%%%%%%@@@@@@@%#%**+*#*==--==+**#%@@#*#@@%%%%%%%%%#*%%#*##%@@@@@@@%%#%%%@@@@@%%%@");
            System.out.println("#%**#*%%@#*#%%@@%@@@@@%%%%@@%*+**##*==-====+==++%*+#%*%%%%%%%%%#*+=*%@@@@@%%###%@@@@@@@@@@%@@@");
            System.out.println("##*#%%%@%@%%%@@@@@@@%%%@@@@#**+***#*++==+#@#%++++%**%#@@@@%#%%%@%%#%@###%%%@@@@@@@@@@@@@@@%@@@");
            System.out.println("@##%#%@@@@%%%@@@@@@##%%@%@@##+#%%#%+++=*@@@@@@@@***+=%%@@@@@@@%%*#@@@**@@@@@@@@@@@@@@@#%@@%@@@");
            System.out.println("%%%%%%%%%%@@@@@%@%###%#%#@@##%%%%%*+==%@@@@@@@@@@%+++=++++**%@@@@%*@@@@@@@@@@@@@%@@@@@@@@@%%@@");
            System.out.println("%%%#%*+%@@@@%%@@@####**#@@@##%%%##*+===@@@@@@@@@@@@%*+*++**#*#+%@@@@%#@@@@@@@@@@@@@@@@@@@@@#@%");
            System.out.println("%%@@#%%%%@@%@@@%######**#@@%##%%%%*+==+@@@@@@@@@@@@@@**#@@%*++*###@@@@@%@@@@@@@@@@@@@@%#%@@#%%");
            System.out.println("%%@@#*+%@@##%@@####%###*#@@%%#%##**====@@@@@@@@@@@@@@@@@@%@#++++=+#%@%@@@@@@@@@#%%%@@@@@@@@@*#");
            System.out.println("#*#*%%#%*%##%@@##%%%###*#@@#%%%#%#*====@@@@@@@@@@@@@@@@@@@@**#++==*=*#%@@@@@@@@@@@@#@%@@@@@@*%");
            System.out.println("%%##%#@@@%*###@###%##*##%%%%%#%@%**====@@@@@@@@@@@@@@@@@@@@@=++++=*+###@@@@@@@@@@@@@@@@@%%%%#%");
            System.out.println("@@%##%@%%%####@#######%%%%%%#%@@%**====@@@@@@@@@@@@%@@@@@@@%++++#*#@@%#@@@@@@@@%%%########%%@%");
            System.out.println("@@@@%%%%@%###%@%##%##%##%#%%%@@@%**====++@@@@@@@@@@%@@@@@@@@=+*+**##%%#@@@%%%@@%%%@%@@@@%%%@@%");
            System.out.println("@@@@@@@@@#########%#*%%######@@@%*#*=+****%@@@@@@@@%@@@@@@@@@%*++++%%##@@@@@@@@@%%%%%@%%%##***");
            System.out.println("@@@@@@@@@##*###%%%%%####%####@@@@#%*++***+*#@@@@@@@%@@@@@@@@@@@@+++%##%#@@@@%%%#####*###*###**");
            System.out.println("@@@@@@@@@######%%#%%*%#%%%#%%@#%%%%*+*+*+*+**@@@@@@%#@@@@@@@@@@@@*+%####%%########***##******#");
            System.out.println("@@@@@@@@#**##%##%%%%#%%#####%#%%%%%%=*******++#@@@@%*@@@@@@@@@@%@#+%%#%##%#####*#****#####%##%");
            System.out.println("@@@@@@@@***####%#%%%%%%###%%%%%%###====+*+##*+*%@@@#*@@@@@@@@@@*#%*@@%##%%%%#%####************");
            System.out.println("%@@@@@@@#***##%##%%%%%%%%##**##%%%*===++++*+++=+++++*%%%*+#@@@@+*#*@@%%%##%%#####**#**********");
            System.out.println("*@@@@@@#*###%%%#####%%%#%####%%%%%*==+====++++++++*+@@@%+++++++++**@@@@%##%%##*****####%%@@@@@");
            System.out.println("+#@@@@@@##%%@%%#%%##%%%%#*%%%%%%%%#=====+==+===++++*@@@%**=++**++**%@%%%##@@@@@@@@@@@@@@@@@@@@");
            System.out.println("**@@@@@@%##%@%%#%%#%%%%%%%##%%%%%%#+++++++++++++++++#@%*+=++++*++++#%%%%@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("#@@@@@@@%#@@@%%#%##@%#%@@@**%%%%%%@+=++++=++++=+**#***+*%%%##****++*##%%@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("%%%%@@@@@@@@@@@@@%%@@@@@@@@@@@@@@@@%=****++++*++*+*#*+**@@@@@@@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@%%@@@@@@@%@@@%@@@@@%@@@@@#%%@@@@%+++++**+++*+++*++*+***@@@@@@@@@@@@@@%@*@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("%%%@%@@@@%%@@%@@@@@@%@@@@@##%@@@@@%*++***+++*+++*#+*#++*@@@%@@@@@@@@%@*@%@@@@@@@@@@@@%%%%%%@@%");
            System.out.println("%%@%@@@@@%#@@%@@@%@@%%%@@@*#@@@@@@@*++******+++++++*++++@@%#@@@@@@@@#%*@@%@@@@@@@%@@@%@@@@@@@@");
            System.out.println("%###@@@@@##@%%%#@%@@%@@@@%##%@@@@@@++*+*++***+++++++*+*+%%%#@@@@@@@*+=#@%#@@@@@@@%@@@%@%%%%%%%");
            System.out.println("%%%%%%%%%##@@%##%%@%%@@@@%*%%@@@@@%+**+**++#*++++*+**+#+++=-*@@@@@%*==*@@#@@@@@@@%%@@@@@@@@@@@");
            System.out.println("@%@%%%%%###@%%##%%%%%@@@@%*%%%%@@@%*********+++++***@@@@*++=+%@@@@%*=++@@%@@@@@@@%%@@@@@@@@@@@");
            System.out.println("%%@@@@@%%#%###%%%%%%%@@@@#*%#%@@@@#+=***+*#++=*+*+**@@@@@*+-=%@@@@%*===%@@@@@@@@@@%@@@@@@@@@@@");
            System.out.println("@@@%@@@@##%#%%%#%%%%%%@@%#*%@@@@@@++******=+#++++++**@@@#*+=+*@@@@@*===%@@@@@@@@@@%@@@@@@@@@@@");
            System.out.println("#*#@@%@%####%%%%%%##%#%%%%%%%@%%@@*++**=+*=***++##+**+@*+++==@@@@@@*+==#@@@@@@@@@@%@@@@@@@@@@@");
            System.out.println("+**%@%%#*#*#*%%%%%%%%%#%%%#%%%@%@%+++*+=*++#***+***#*+****++==@@@@@%+++#@@@@@@@%%@%%@@@@@@@@@@");
            System.out.println("++*%%@%%*##*#%#%%%%%%%%%@%#%%%%%%%++*++=**+**#*#*****+**#*++++@@@@@@##+#@@@%%@@%%%%%@@@@%@@@@@");

            System.out.println();
            System.out.println(UiUtils.formatGreenText("Press 'c' to continue exploring..."));
            waitForContinue();
            firstTimeWeaponShop = false;
        }

        System.out.println(UiUtils.formatGreenText("Weapon Shop Ruins - Broken firearms everywhere."));
        String[] locations = {"Behind Counter", "Broken Display Case", "Storage Room", "Cash Register", "Wall Rack Remains"};
        for (int i = 0; i < locations.length; i++) {
            System.out.println((i + 1) + ". " + locations[i]
                    + (lootSystem.isLocationLooted(locations[i]) ? " [LOOTED]" : " [LOOT]"));
        }
        System.out.println("b. Back to Main Street");
        System.out.println("s. View Stats");
        System.out.println("i. View Inventory");
    }

    private void displayBossArea() {

        /* 
        if (player.getLVL() < 5) {
            System.out.println("You're not ready for the boss! Need level 5.");
            currentArea = "Crumbled Main Street";
            return;
        }
         */
        if (firstTimeBossArea) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("BROKEN BRIDGE APPROACH");
            System.out.println("=".repeat(50));
            System.out.println("An intense aura radiates from ahead.");
            System.out.println("The ground trembles with each heavy footstep.");
            System.out.println("Something powerful waits here...");
            System.out.println("This is the point of no return.");
            System.out.println("=".repeat(50));
            System.out.println();

            System.out.println("@%%%%%%%%%%##****##***+*####*##*****+++++++++==*#*+##%%#***#****#**#%%%#####%#%%%%%%%%@@%%%@@@");
            System.out.println("%#*#%%%%%%%%%%########***+*++***++++*+++++======++#####****#####***####%%%%%%%%%%%@@@@@@@@@@@@");
            System.out.println("%*++*************###****#****++++*##*****+++++***++++*++*+######***+**####%%%%%%%%%%%%%@@@@@@@");
            System.out.println("##**##*###*+====+++++++++++*****+++++**##***++**********+**#####**#####**##%%%%%%%%#%%%%@%%@@@");
            System.out.println("@%%###**####*++========++++++++++++++++++*********++++++****++***#**#*****#########%%%%%%%%%%@");
            System.out.println("%%%%%######*###*****++++=======----=++*+==++++++++**+++++++++====+**#****#####******##%#%%%@@%");
            System.out.println("************##*************++++++++++==--=======---====++++++**++++*#####**++++*#############%");
            System.out.println("*****+*++**++++++++++++++++++++++======++++******+=======++++++*+=--=+*###******#####%%%%%%%@@");
            System.out.println("%%%%####************+++++++++++*%@@#*******+++++**+***+++++*******====++*****########*#%%%%@@@");
            System.out.println("@%%%%%%%%%%###########********##%@@@@%%%##***++++++=+=++=++=++++++++++**##########*+++**#%%%%%");
            System.out.println("%%%%######******************#%#%@@@@@@@@@@%%@@@@@@%#**************************++++++**+++**##%");
            System.out.println("@%%%%%#####************++*%%%#@@@@@@@@@@@@#%@#@@@@@@*******#*#*******++++==--=========++****##");
            System.out.println("++++++++**+++++++======+%%%@@@@%%@@@@@%#@#%%@#@%#********###*********#########**++======++*##%");
            System.out.println("@@@%%###**+++++++++++*%%%@@@@@@@@@@@@##*@%@@@#+++++++++++********##########***++++++++++++++++");
            System.out.println("@@@@@@%%##***++++++*#%@@@@@@@@@@@@%%%#**%@@@%**+++++*********+**+++******###***++++++++++++***");
            System.out.println("++++++********+++*%%@@@@@@@@@@%%###***#%@@@@%%###*++=====++++********#########%%%%%%%##%%@@@@@");
            System.out.println("######*+++++**+*%%@@@@@@@@%%%@#####*@@@%%@@####%%%%%@+============++++++=====+++++***#%%%%%%%@");
            System.out.println("##**######****%@@@@@@@%@######**%@@@#%%%%%%#%##%%#%%%#******+++****++++++++*****++++++*******#");
            System.out.println("####*******#%@@@@@@%######%%%#*+++==#%%@@@@@@@%%%%%#********************************######%%%%");
            System.out.println("%######**#@@@@@@@%%###%#+++++++++++++++#%@@@%@##%%#**********#######**###################%%%%%");
            System.out.println("%###%%%%@@@@@##@@@@#********###%%%###***%%@%@@%#%%###################%#################%%%%%%@");
            System.out.println("###%@@@@@@@@%*%%%@@@@@@@@@@@@@@@@@@@@@@%@%%#@%#%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@@@@@@@@%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#@%#@%@@##%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@@@@@@@@@@%%##%@@@@%%%%@@@@@@@@@@@@@@#%@%%@%@%%@%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@");
            System.out.println("@@@@@@@%%%@%@%%%#########%%%##*#*###%#*%@%%%@@@%#%#*+*****##********#*#***##############%%%%%%");
            System.out.println("@@@@%%%@@@%%@%%@@@@@%%%%%##*#*#####%%##%@%%%@@%%#%@*###%%%%%%%%%%########################%%%%%");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%#%%@#*#%@%%%@%%@@@@##%########*##%%#%%%%%%#%@@@@@@@@@@@@@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@@@@%@@@@@@@@@@%#%##%%%%%%%%%%#%%@@%%%%@@@@@@@@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@@@@@@@@%%%%%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%%@@@@@@@@@@");
            System.out.println("@@@@@%@@@@@@@%@@@@@@@%%%@@@@@%%%%%%%%@@%%@@@@@@@@@%%@@@@@%%@@@@@%@@@@@%%##%%@@@@@@@@@@@@@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@%%%@@@@%%@%%%%@@@@@@@@@@@@@@@@@@@@@@@@@%%%@%%#%%@@@@%%@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@%@%%@%%%%@@@%%%%#%@@%@%%%#%#%%%%%%%%@%#%%#%%%%%%%%%%@@%@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@%@%%@@@@@@@@%@@%@%@@%@%@%%%%%@%@%@@@@%%%%@@@@@%%@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@##***##%#%@@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

            System.out.println();
            System.out.println(UiUtils.formatGreenText("Press 'c' to continue exploring..."));
            waitForContinue();
            firstTimeBossArea = false;
        }

        System.out.println("Broken Bridge Approach - Intense aura radiates ahead.");
        System.out.println("A primal fear grips you. Do you dare proceed?");
        System.out.println("c. Confirm - Face the horror that awaits");
        System.out.println("b. Back away - Return to Main Street");
        System.out.println("s. View Stats");
        System.out.println("i. View Inventory");
    }

    private void waitForContinue() {
        while (true) {
            System.out.print(UiUtils.formatGreenText("\nChoice: "));
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("c")) {
                break;
            }
            System.out.println("Press 'c' to continue...");
        }
        UiUtils.clearConsole();
    }

    private void handleInput() {
        System.out.print(UiUtils.formatGreenText("\nChoose action: "));
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("s")) {
            UiUtils.clearConsole();
            showStats();
            return;
        }
        if (input.equals("i")) {
            UiUtils.clearConsole();
            showInventory();
            return;
        }
        if (input.equals("b") && !currentArea.equals("Vault 101") && !currentArea.equals("Run-Down Town")) {
            if (currentArea.equals("Shattered Storefronts") || currentArea.equals("Collapsed Cafe")
                    || currentArea.equals("Weapon Shop Ruins") || currentArea.equals("Broken Bridge Approach")) {
                currentArea = "Crumbled Main Street";
                return;
            }
        }

        UiUtils.clearConsole();
        switch (currentArea) {
            case "Vault 101":
                handleVaultInput(input);
                break;
            case "Run-Down Town":
                handleTownInput(input);
                break;
            case "Crumbled Main Street":
                handleMainStreetInput(input);
                break;
            case "Shattered Storefronts":
                handleStorefrontsInput(input);
                break;
            case "Collapsed Cafe":
                handleCafeInput(input);
                break;
            case "Weapon Shop Ruins":
                handleWeaponShopInput(input);
                break;
            case "Broken Bridge Approach":
                handleBossInput(input);
                break;
        }
        stepCounter++;
    }

    private void handleVaultInput(String input) {
        switch (input) {
            case "1":
                if (!lootSystem.handleLoot("Engineering Storage", player, scanner)) {
                    player.setHP(0);
                }
                break;
            case "2":
                System.out.println("You leave the vault...");
                lootSystem.setPlayerLeftVault(true);
                currentArea = "Run-Down Town";
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private void handleTownInput(String input) {
        if (input.equals("c")) {
            currentArea = "Crumbled Main Street";
        } else {
            System.out.println("Invalid choice! Press 'c' to continue.");
        }
    }

    private void handleMainStreetInput(String input) {
        switch (input) {
            case "1":
                currentArea = "Shattered Storefronts";
                break;
            case "2":
                currentArea = "Collapsed Cafe";
                break;
            case "3":
                currentArea = "Weapon Shop Ruins";
                break;
            case "4":
                currentArea = "Broken Bridge Approach";
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private void handleStorefrontsInput(String input) {
        if (input.equals("b")) {
            currentArea = "Crumbled Main Street";
            return;
        }

        String[] locations = {"Pharmacy Shelves", "Clothing Rack", "Office Desk", "Backroom", "Cashier Area"};
        try {
            int choice = Integer.parseInt(input) - 1;
            if (choice >= 0 && choice < locations.length) {
                if (!lootSystem.handleLoot(locations[choice], player, scanner)) {
                    player.setHP(0);
                }
            } else {
                System.out.println("Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice!");
        }
    }

    private void handleCafeInput(String input) {
        if (input.equals("b")) {
            currentArea = "Crumbled Main Street";
            return;
        }

        String[] locations = {"Kitchen Area", "Broken Tables", "Bar Counter", "Storage Closet", "Restroom"};
        try {
            int choice = Integer.parseInt(input) - 1;
            if (choice >= 0 && choice < locations.length) {
                if (!lootSystem.handleLoot(locations[choice], player, scanner)) {
                    player.setHP(0);
                }
            } else {
                System.out.println("Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice!");
        }
    }

    private void handleWeaponShopInput(String input) {
        if (input.equals("b")) {
            currentArea = "Crumbled Main Street";
            return;
        }

        String[] locations = {"Behind Counter", "Broken Display Case", "Storage Room", "Cash Register", "Wall Rack Remains"};
        try {
            int choice = Integer.parseInt(input) - 1;
            if (choice >= 0 && choice < locations.length) {
                if (!lootSystem.handleLoot(locations[choice], player, scanner)) {
                    player.setHP(0);
                }
            } else {
                System.out.println("Invalid choice!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice!");
        }
    }

    private void handleBossInput(String input) {
        switch (input) {
            case "c":
                System.out.println("\nA cold dread washes over you as you step forward.");
                System.out.println("There's no turning back now...");
                if (!lootSystem.handleLoot("Broken Bridge Approach", player, scanner)) {
                    player.setHP(0);
                } else {
                    currentArea = "COMPLETED";
                }
                break;
            case "b":
                System.out.println("You wisely choose to retreat. Perhaps you need more preparation.");
                currentArea = "Crumbled Main Street";
                break;
            default:
                System.out.println("Invalid choice! Press 'c' to confront the boss or 'b' to back away.");
        }
    }

    private void showStats() {
        System.out.println(UiUtils.formatGreenText("\n=== " + player.getName() + " STATS ==="));
        System.out.println("Level: " + player.getLVL());
        System.out.println("EXP: " + player.getEXP() + "/" + (20 + (player.getLVL() * 5)));
        System.out.println("HP: " + player.calculateTotalHP());
        System.out.println("ATK: " + player.calculateTotalATK());
        System.out.println("DEF: " + player.calculateTotalDEF());
        System.out.println("RATK: " + player.calculateTotalRATK());
        System.out.println("RDEF: " + player.calculateTotalRDEF());
        System.out.println("AGI: " + player.calculateTotalAGI());
        System.out.println("ACC: " + player.calculateTotalACC());
        System.out.println("ENE: " + player.calculateTotalENE());
        System.out.println("Special: " + player.getSPEC());

        System.out.println("\nSpecial Move Details:");
        switch (player.getSPEC()) {
            case "Heal":
                System.out.println("Heals for 25% of Max-HP");
                System.out.println("Cost: 5 ENE");
                break;
            case "PowerHit":
                System.out.println("Deals 160% ATK damage");
                System.out.println("Cost: 6 ENE");
                break;
            case "Snipe":
                System.out.println("Deals 150% RATK damage (guaranteed hit)");
                System.out.println("Cost: 7 ENE");
                break;
        }

        System.out.print(UiUtils.formatGreenText("\nPress 'b' to go back: "));
        scanner.nextLine();
    }

    private void showInventory() {
        System.out.println(UiUtils.formatGreenText("\n=== INVENTORY ==="));
        String[] inv = player.getInventory();
        System.out.println("Melee Weapon: " + inv[0]);
        System.out.println("Ranged Weapon: " + inv[1]);
        System.out.println("Head Gear: " + inv[2]);
        System.out.println("Body Armor: " + inv[3]);
        System.out.println("Leggings: " + inv[4]);

        int potions = 0;
        for (int i = 5; i < inv.length; i++) {
            if (inv[i].equals("Healing Potion")) {
                potions++;
            }
        }
        System.out.println("Healing Potions: " + potions);

        System.out.print(UiUtils.formatGreenText("\nPress 'b' to go back: "));
        scanner.nextLine();
    }
}
