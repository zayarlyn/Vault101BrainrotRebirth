public class UiUtils {
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String formatRedText(String text) {
        return "\u001B[31m" + text + "\u001B[0m";
    }

    public static String formatGreenText(String text) {
        return "\u001B[32m" + text + "\u001B[0m";
    }

    public static String formatYellowText(String text) {
        return "\u001B[33m" + text + "\u001B[0m";
    }

    public static String formatBlueText(String text) {
        return "\u001B[34m" + text + "\u001B[0m";
    }

    public static void printBox(String text) {
        int width = text.length() + 50;
        // Top border
        System.out.print("┌");
        for (int i = 0; i < width - 11; i++) System.out.print("─");
        System.out.println("┐");

        // Center text
        int space = width - 2 - text.length();
        int left = space / 2;
        int right = space - left;

        System.out.print("│");
        for (int i = 0; i < left; i++) System.out.print(" ");
        System.out.print(text);
        for (int i = 0; i < right; i++) System.out.print(" ");
        System.out.println("│");

        // Bottom border
        System.out.print("└");
        for (int i = 0; i < width - 11; i++) System.out.print("─");
        System.out.println("┘");
    }
}