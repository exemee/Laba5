import Commands.CommandInvoker;
import Commands.CommandReceiver;
import Commands.ConcreteCommands.*;
import Collection.CollectionManager;

import java.util.Collection;
import java.util.Scanner;

public class ConsoleManager {
    void startInteractiveMode(){
        CommandInvoker commandInvoker = new CommandInvoker();
        CommandReceiver commandReceiver = new CommandReceiver(commandInvoker);

        CollectionManager.initArray();

        commandInvoker.register("help", new Help(commandReceiver));
        commandInvoker.register("add", new Add(commandReceiver));
        commandInvoker.register("remove_by_id", new RemoveById(commandReceiver));
        commandInvoker.register("info", new Info(commandReceiver));
        commandInvoker.register("show", new Show(commandReceiver));
        commandInvoker.register("update", new Update(commandReceiver));
        commandInvoker.register("clear", new Clear(commandReceiver));
        commandInvoker.register("exit", new Exit(commandReceiver));
        commandInvoker.register("remove_first", new RemoveFirst(commandReceiver));
        commandInvoker.register("remove_greater", new RemoveGreater(commandReceiver));
        commandInvoker.register("save", new Save(commandReceiver));
        commandInvoker.register("execute_script", new ExecuteScript(commandReceiver));
        commandInvoker.register("add_if_max", new AddIfMax(commandReceiver));
        commandInvoker.register("sum_of_salary", new SumOfSalary(commandReceiver));
        commandInvoker.register("min_by_name", new MinByName(commandReceiver));

        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()){
                commandInvoker.executeCommand(scanner.nextLine().trim().toLowerCase().split(" "));
            }
        }
    }
}
