package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;
import Commands.Utils.Creators.ElementCreator;

public class CountGreaterThanOrganization extends Command {
    private final CommandReceiver commandReceiver;
    public CountGreaterThanOrganization(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда count_greater_than_organization - вывести количество элементов, значение поля organization которых больше заданного");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length > 1) System.out.println("Введен ненужный аргумент. Команда приведена к базовой exit.");
        commandReceiver.count_greater_than_organization(ElementCreator.createOrganization());
    }
}
