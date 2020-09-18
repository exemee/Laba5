package Commands.ConcreteCommands;

import Commands.Command;
import Commands.CommandReceiver;

public class SumOfSalary extends Command {
    private final CommandReceiver commandReceiver;
    public SumOfSalary(CommandReceiver commandReceiver){
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void writeInfo() {
        System.out.println("Команда sum_of_salary - вывести сумму значений поля salary для всех элементов коллекции");
    }

    @Override
    protected void execute(String[] args) {
        if(args.length > 1) System.out.println("Введен ненужный аргумент. Команда приведена к базовой sum_of_salary.");
        commandReceiver.sumOfSalary();
    }
}
