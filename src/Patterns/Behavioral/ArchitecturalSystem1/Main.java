package Patterns.Behavioral.ArchitecturalSystem1;

import java.util.ArrayList;

public class Main {

    public static ExchangeWithBase exchangeWithBase = new ExchangeTXT();
    public static UnitOfWork unitOfWork = new UnitOfWork();

    public static void main(String[] args) {

        // изменим номер тел. в базе
        getPersonAndChangePhoneNumber(1, "+79190000004");

        // добавим нового человека в базу
        addNewPerson(5, "Fedorov", "Fedor", "+79190000005");

        // удалим человека из базы
        getPersonAndDelete(2);

        // запишем все изменения в базу
        unitOfWork.commit(exchangeWithBase);
    }

    public static void getPersonAndChangePhoneNumber(int id, String newPhoneNumber){
        Person person = exchangeWithBase.getFromBaseByID(id);
        person.setPhoneNumber(newPhoneNumber);
        ArrayList dirtyObjects = unitOfWork.getDirtyObjects();
        dirtyObjects.add(person);
    }

    public static void addNewPerson(int id, String firstName, String lastName, String phoneNumber){
        Person person = new Person(id, firstName, lastName, phoneNumber);
        ArrayList newObjects = unitOfWork.getNewObjects();
        newObjects.add(person);
    }

    public static void getPersonAndDelete(int id){
        Person person = exchangeWithBase.getFromBaseByID(id);
        ArrayList removedObjects = unitOfWork.getRemovedObjects();
        removedObjects.add(person);
    }

}
