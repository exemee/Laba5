package Collection;

import BasicClasses.Worker;

public class CollectionUtils {

    public static boolean checkExist(Integer ID) {
        for (Worker worker:CollectionManager.getArrayDeque()) {
            if(worker.getId().equals(ID)) return true;
        }
        return false;
    }

    public static void display(Worker worker){
        System.out.println("ID элемента коллекции - " + worker.getId());
        System.out.println("Имя рабочего - " + worker.getName());
        System.out.println("Должность рабочего - " + worker.getPosition());
        System.out.println("Статус рабочего - " + worker.getStatus());
        System.out.println("Координата x рабочего - " + worker.getCoordinates().getX());
        System.out.println("Координата y рабочего - " + worker.getCoordinates().getY());
        System.out.println("Имя организации - " + worker.getOrganization().getFullName());
        System.out.println("Годовой оборот организации - " + worker.getOrganization().getAnnualTurnover());
        System.out.println("Количество сотрудников организации - " + worker.getOrganization().getEmployeesCount());
        System.out.println("Количество сотрудников организации - " + worker.getOrganization().getEmployeesCount());
        System.out.println("Улица организации - " + worker.getOrganization().getPostalAddress().getStreet());
        System.out.println("Почтовый индекс организации - " + worker.getOrganization().getPostalAddress().getZipCode());
        System.out.println("Координата X организации в городе - " + worker.getOrganization().getPostalAddress().getTown().getX());
        System.out.println("Координата Y организации в городе - " + worker.getOrganization().getPostalAddress().getTown().getY());
        System.out.println("Координата Z организации в городе - " + worker.getOrganization().getPostalAddress().getTown().getZ());
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n");
    }
}
