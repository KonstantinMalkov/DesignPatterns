package Patterns.Behavioral.ArchitecturalSystem1;

import java.util.ArrayList;

public abstract class ExchangeWithBase{

    public Person getFromBaseByID(int id){
        return null;
    }

    public void insertNew(ArrayList newObjects){}

    public void updateDirty(ArrayList dirtyObjects){}

    public void deleteRemoved(ArrayList removedObjects){}
}
