import Commands.Utils.JSON.ParserJSON;

public class Main {
    public static void main(String[] args) {
        ParserJSON.fromJsonToCollection();
        ConsoleManager consoleManager = new ConsoleManager();
        consoleManager.startInteractiveMode();
    }
}
