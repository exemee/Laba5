package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

public class Show extends Command {
    private final CommandReceiver commandReceiver;
    public Show(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда show - Вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length > 1) System.out.println("Введен ненужный аргумент. Команда приведена к базовой show.");
        commandReceiver.show();
    }
}
