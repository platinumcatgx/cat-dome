package company;

public class Main {

    public static void main(String[] args) {
        person person = new person();

        try {
            person.setAge(25);
            person.setSex("男");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
