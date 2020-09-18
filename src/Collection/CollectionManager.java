package Collection;

import BasicClasses.Worker;

import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.Comparator;

public class CollectionManager {
    private static ArrayDeque<Worker> arrayDeque;
    private static ZonedDateTime creationDate;

    public static ArrayDeque<Worker> getArrayDeque() {
        return arrayDeque;
    }

    public static void initArray(){
        if(arrayDeque == null){
            arrayDeque = new ArrayDeque<>();
            creationDate = ZonedDateTime.now();
        }
    }

    public static void add(Worker worker){
        arrayDeque.add(worker);
    }

    public static void removeById(Integer ID){
        arrayDeque.forEach(worker -> {
            if (worker.getId().equals(ID)) { arrayDeque.remove(worker); }
        });
    }

    public static void show(){
        arrayDeque.forEach(CollectionUtils::display);
    }

    public static void info(){
        System.out.println("Тип коллекции – " + arrayDeque.getClass().getName());
        System.out.println("Дата инициализации коллекции – " + creationDate);
        System.out.println("Количество элементов в коллекции – " + arrayDeque.size());
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ \n");
    }

    public static void update(Worker workerToUpdate, Integer ID){
        arrayDeque.forEach( worker -> {
            if (worker.getId().equals(ID)) {
                worker.setName(workerToUpdate.getName());
                worker.setPosition(workerToUpdate.getPosition());
                worker.setStatus(workerToUpdate.getStatus());
                worker.setCoordinates(workerToUpdate.getCoordinates());
                worker.setOrganization(workerToUpdate.getOrganization());
            }
        });
    }

    public static void clear(){
        arrayDeque.clear();
    }

    public static void removeFirst(){
        if (arrayDeque.size() > 0) {
            arrayDeque.removeFirst();
            System.out.println("Удален первый элемент коллекции");}
        else { System.out.println("Коллекция пуста."); }
    }
    public static void removeGreater(Worker workerToCompare){
        arrayDeque.forEach(worker -> {
            if (worker.compareTo(workerToCompare) > 0) {
                arrayDeque.remove(workerToCompare);
            } else { System.out.println("Таких элементов не найдено"); }
        });
    }

    public static void addIfMax(Worker workerToAdd) {
        if (arrayDeque.size() > 0 ) {
            Worker worker = arrayDeque.stream().max(Comparator.comparing(Worker::getId)).get();
            if (workerToAdd.getId() > worker.getId()) { arrayDeque.add(workerToAdd); }
        } else System.out.println("Коллекция пуста.");
    }

    public static void addJsonObject(Worker worker) {
        worker.setId(IDGenerator.generateID(worker.getId()));
        arrayDeque.add(worker);
    }
}
