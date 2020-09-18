package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

public class Update extends Command {
    private final CommandReceiver commandReceiver;
    public Update(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда update id - обновить значение элемента коллекции, id которого равен заданному");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length == 2) commandReceiver.update(args[1]);
        else System.out.println("Некорректно количество аргументов.");
    }
}
