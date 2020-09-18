package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

public class RemoveFirst extends Command {
    private final CommandReceiver commandReceiver;
    public RemoveFirst(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда remove_first - удалить первый элемент из коллекции");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length > 1) System.out.println("Введен ненужный аргумент. Команда приведена к базовой remove_first.");
        commandReceiver.removeFirst();
    }
}
