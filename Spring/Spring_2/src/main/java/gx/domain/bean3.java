package gx.domain;

import java.util.*;

public class bean3 {
    private String[] names;
    private List list;
    private Set set;
    private Map<String,String> map;
    private Properties properties;

    @Override
    public String toString() {
        return "bean3{" +
                "names=" + Arrays.toString(names) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
