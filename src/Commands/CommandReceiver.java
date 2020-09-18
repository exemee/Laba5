package Commands;

import BasicClasses.Organization;
import BasicClasses.Worker;
import Collection.CollectionManager;
import Collection.CollectionUtils;
import Commands.ConcreteCommands.ExecuteScript;
import Commands.Utils.Creators.ElementCreator;
import Commands.Utils.JSON.ParserJSON;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;

public class CommandReceiver {
    private final CommandInvoker commandInvoker;

    public CommandReceiver(CommandInvoker commandInvoker){
        this.commandInvoker = commandInvoker;
    }

    public void help(){
        commandInvoker.getCommandHashMap().forEach((name, command) -> command.writeInfo());
    }

    public void add(){
        CollectionManager.add(ElementCreator.createWorker());
        System.out.println("Элемент добавлен в коллекцию.");
    }

    public void removeById(String ID){
        Integer workerId;
        try {
            workerId = Integer.parseInt(ID);
            if (CollectionUtils.checkExist(workerId)) {
                CollectionManager.removeById(workerId);
                System.out.println("Элемент с ID " + workerId + " успешно удален из коллекции.");
            } else {System.out.println("Элемента с таким ID нет в коллекции.");}
        } catch (NumberFormatException e) {
            System.out.println("Команда не выполнена. Вы ввели некорректный аргумент.");
        }
    }

    public void info(){
        CollectionManager.info();
    }

    public void show(){
        CollectionManager.show();
    }

    public void update(String ID){
        Integer workerId;
        try {
            workerId = Integer.parseInt(ID);
            if (CollectionUtils.checkExist(workerId)) CollectionManager.update(ElementCreator.createWorker(),workerId);
             else {System.out.println("Элемента с таким ID нет в коллекции.");}
        } catch (NumberFormatException e) {
            System.out.println("Команда не выполнена. Вы ввели некорректный аргумент.");
        }
    }

    public void clear(){
        CollectionManager.clear();
        System.out.println("Коллекция успешно очищена.");
    }

    public void exit(){
        System.out.println("Завершение работы программы.");
        System.exit(0);
    }

    public void removeFirst(){
        CollectionManager.removeFirst();
    }

    public void removeGreater(){
        CollectionManager.removeGreater(ElementCreator.createWorker());
    }

    public void save() {
        ParserJSON.collectionToJson();
    }

    public void addIfMax() {
        CollectionManager.addIfMax(ElementCreator.createWorker());
    }

    public void executeScript(String path) {
        String line;
        String command;
        ArrayList<String> parameters = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(path)), StandardCharsets.UTF_8))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(" ")[0].matches("add|update|add_if_max|remove_greater")) {
                    command = line;
                    for (int i = 0; i < 14; i++) {
                        if (line != null) {
                            line = bufferedReader.readLine();
                            parameters.add(line);
                        } else { System.out.println("Не хватает параметров для создания объекта."); break; }
                    }
                    Worker worker = ElementCreator.createScriptWorker(parameters);
                    if(worker != null){
                        switch (command.split(" ")[0]) {
                            case "add":
                                CollectionManager.add(worker);
                                break;
                            case "update":
                                CollectionManager.update(worker, Integer.parseInt(command.split(" ")[1]));
                            case "remove_greater":
                                CollectionManager.removeGreater(worker);
                                break;
                            case "add_if_max":
                                CollectionManager.addIfMax(worker);
                                break;
                        }
                    }
                } else if (line.split(" ")[0].equals("execute_script")
                        && line.split(" ")[1].equals(ExecuteScript.getPath())) { System.out.println("Пресечена попытка рекурсивного вызова скрипта."); }
                else { commandInvoker.executeCommand(line.split(" ")); }
            }
        } catch (IOException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }

    public void minByName() {
        if (CollectionManager.getArrayDeque().size() > 0) {
            CollectionUtils.display(CollectionManager.getArrayDeque().stream()
                    .min(Comparator.comparing(Worker::getName)).get());
        } else System.out.println("Коллекция пуста.");
    }

    public void sumOfSalary() {
        double sumSalary = CollectionManager.getArrayDeque().stream().mapToDouble(Worker::getSalary).sum();
        System.out.println("Размер зарплаты всех работников: " + sumSalary);
    }

    public void count_greater_than_organization(Organization organizationToCompare) {
        int count = (int) CollectionManager.getArrayDeque().stream()
                .filter(worker -> worker.getOrganization()
                .compareTo(organizationToCompare) > 0)
                .count();
        System.out.println("Количество элементов в коллекции превышающее заданный: " + count);
    }
}
