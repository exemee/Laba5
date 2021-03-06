package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

public class Clear extends Command {
    private final CommandReceiver commandReceiver;
    public Clear(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда clear - очистить коллекцию");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length > 1) System.out.println("Введен ненужный аргумент. Команда приведена к базовой clear.");
        commandReceiver.clear();
    }
}
