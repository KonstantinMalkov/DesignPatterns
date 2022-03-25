package Patterns.Behavioral.ArchitecturalSystem1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExchangeTXT extends ExchangeWithBase {

    @Override
    public Person getFromBaseByID(int id) {

        return getFromTXTBaseByID(id);

    }

    public Person getFromTXTBaseByID(int id) {

        Person person = new Person();

        try (FileReader reader = new FileReader("ListPersons.txt")) {
            ArrayList buf = new ArrayList();
            int c;
            String str = "";
            while ((c = reader.read()) != -1) {
                if (!String.valueOf((char) c).equals("\n")) {
                    buf.add((char) c);
                }
                if (!buf.isEmpty() && String.valueOf((char) c).equals("\n")) {
                    for (int i = 0; i <= buf.size() - 1; i++) {
                        str = str + String.valueOf(buf.get(i));
                    }
                    String[] valueStr = str.split(",");
                    if (Integer.parseInt(valueStr[0]) == id) {
                        person.setIdPerson(Integer.parseInt(valueStr[0]));
                        person.setFirstName(valueStr[1]);
                        person.setLastName(valueStr[2]);
                        person.setPhoneNumber(valueStr[3]);
                        return person;
                    }
                    buf = new ArrayList();
                    str = "";
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return person;

    }

    @Override
    public void insertNew(ArrayList newObjects) {

        for (int i = 0; i <= newObjects.size() - 1; i++) {
            Person person = (Person) newObjects.get(i);
            addNewPersonToBaseTXT(person);
        }

    }

    public void addNewPersonToBaseTXT(Person person) {
        try (FileWriter writer = new FileWriter("ListPersons.txt", true)) {
            writer.write(person.getIdPerson() + "," +
                    person.getFirstName() + "," +
                    person.getLastName() + "," +
                    person.getPhoneNumber());
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateDirty(ArrayList dirtyObjects) {

        // получим объекты из файла
        ArrayList<Person> listOfPersons = getAllFromFile();

        // изменим данные из файла по измененным объектам
        for (int i = 0; i <= dirtyObjects.size()-1; i++) {
            Person personFromDirtyList = (Person) dirtyObjects.get(i);
            for (int j = 0; j <= listOfPersons.size()-1; j++) {
                Person personFromList = (Person) listOfPersons.get(j);
                if (personFromDirtyList.getIdPerson() == personFromList.getIdPerson()){
                    personFromList.setFirstName(personFromDirtyList.getFirstName());
                    personFromList.setLastName(personFromDirtyList.getLastName());
                    personFromList.setPhoneNumber(personFromDirtyList.getPhoneNumber());
                    break;
                }
            }
        }

        // очистим файл
        clearFile();

        // запишем измененные данные обратно в файл
        putAllIntoFile(listOfPersons);

    }

    @Override
    public void deleteRemoved(ArrayList removedObjects) {
        // получим объекты из файла
        ArrayList<Person> listOfPersons = getAllFromFile();

        // изменим данные из файла по измененным объектам
        for (int i = 0; i <= removedObjects.size()-1; i++) {
            Person personFromremovedObjects = (Person) removedObjects.get(i);
            for (int j = 0; j <= listOfPersons.size()-1; j++) {
                Person personFromList = (Person) listOfPersons.get(j);
                if (personFromremovedObjects.getIdPerson() == personFromList.getIdPerson()){
                    listOfPersons.remove(personFromList);
                    break;
                }
            }
        }

        // очистим файл
        clearFile();

        // запишем измененные данные обратно в файл
        putAllIntoFile(listOfPersons);
    }


    public ArrayList<Person> getAllFromFile(){
        ArrayList<Person> listOfPersons = new ArrayList<Person>();
        try (FileReader reader = new FileReader("ListPersons.txt")) {
            ArrayList buf = new ArrayList();
            int c;
            String str = "";
            while ((c = reader.read()) != -1) {
                if (!String.valueOf((char) c).equals("\n")) {
                    buf.add((char) c);
                }
                if (!buf.isEmpty() && String.valueOf((char) c).equals("\n")) {
                    for (int i = 0; i <= buf.size() - 1; i++) {
                        str = str + String.valueOf(buf.get(i));
                    }
                    String[] valueStr = str.split(",");
                    Person person = new Person(Integer.parseInt(valueStr[0]), valueStr[1], valueStr[2], valueStr[3]);
                    listOfPersons.add(person);
                    buf = new ArrayList();
                    str = "";
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return listOfPersons;
    }

    public void clearFile(){
        try (PrintWriter writer = new PrintWriter("ListPersons.txt")) {
            writer.print("");
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void putAllIntoFile(ArrayList<Person> listOfPersons){
        try (FileWriter writer = new FileWriter("ListPersons.txt", true)) {
            for (int i = 0; i <= listOfPersons.size()-1; i++) {
                Person personFromList = (Person) listOfPersons.get(i);
                writer.write(personFromList.getIdPerson() + "," +
                        personFromList.getFirstName() + "," +
                        personFromList.getLastName() + "," +
                        personFromList.getPhoneNumber());
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
