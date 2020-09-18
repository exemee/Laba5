package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

public class Info extends Command {
    private final CommandReceiver commandReceiver;
    public Info(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда info - Вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length > 1) System.out.println("Введен ненужный аргумент. Команда приведена к базовой info.");
        commandReceiver.info();
    }
}
