package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

public class RemoveGreater extends Command {
    private final CommandReceiver commandReceiver;
    public RemoveGreater(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда remove_greater - удалить из коллекции все элементы, превышающие заданный");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length > 1) System.out.println("Введен ненужный аргумент. Команда приведена к базовой remove_greater.");
        commandReceiver.removeGreater();
    }
}
