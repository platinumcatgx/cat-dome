package Collection.List.text02;

public class dog {
    private int age;
    private String name;

    @Override
    public String toString() {
        return "dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
