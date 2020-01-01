package company.SGS;

import java.util.Collection;

public class PaiDui {
    private Collection collection = null;

    public Collection getCollection() {
        if(collection == null){
            collection.add("黑2");
            collection.add("黑3");
            collection.add("黑4");
            collection.add("黑5");
        }
        return collection;
    }

//    public void setCollection(Collection collection) {
//        this.collection = collection;
//    }
}
