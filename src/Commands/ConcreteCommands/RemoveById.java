package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

public class RemoveById extends Command {

    private final CommandReceiver commandReceiver;
    public RemoveById(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда remove_by_id - Обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length == 2) commandReceiver.removeById(args[1]);
        else System.out.println("Некорректно количество аргументов.");
    }
}
