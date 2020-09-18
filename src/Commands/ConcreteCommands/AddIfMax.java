package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

public class AddIfMax extends Command {
    private final CommandReceiver commandReceiver;
    public AddIfMax(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда add_if_max - добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length > 1) System.out.println("Введен ненужный аргумент. Команда приведена к базовой add_if_max.");
        commandReceiver.addIfMax();
    }
}
