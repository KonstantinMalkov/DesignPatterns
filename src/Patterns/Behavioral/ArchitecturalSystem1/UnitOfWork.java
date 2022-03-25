package Patterns.Behavioral.ArchitecturalSystem1;

import java.util.ArrayList;

public class UnitOfWork {

    private ArrayList newObjects = new ArrayList();
    private ArrayList dirtyObjects = new ArrayList();
    private ArrayList removedObjects = new ArrayList();

    public ArrayList getNewObjects() {
        return newObjects;
    }

    public ArrayList getDirtyObjects() {
        return dirtyObjects;
    }

    public ArrayList getRemovedObjects() {
        return removedObjects;
    }

    public void commit(ExchangeWithBase exchangeWithBase){
        insertNew(exchangeWithBase);
        updateDirty(exchangeWithBase);
        deleteRemoved(exchangeWithBase);
    }

    private void insertNew(ExchangeWithBase exchangeWithBase) {
        exchangeWithBase.insertNew(newObjects);
    }

    private void updateDirty(ExchangeWithBase exchangeWithBase) {
        exchangeWithBase.updateDirty(dirtyObjects);
    }

    private void deleteRemoved(ExchangeWithBase exchangeWithBase) {
        exchangeWithBase.deleteRemoved(removedObjects);
    }

}
