package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

public class Exit extends Command {
    private final CommandReceiver commandReceiver;
    public Exit(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда exit - Завершить программу (без сохранения в файл)");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length > 1) System.out.println("Введен ненужный аргумент. Команда приведена к базовой exit.");
        commandReceiver.exit();
    }
}
