package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

public class Add extends Command {

    private final CommandReceiver commandReceiver;
    public Add(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда add - Добавить новый элемент в коллекцию");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length > 1) System.out.println("Введен ненужный аргумент. Команда приведена к базовой add.");
        commandReceiver.add();
    }
}
