package company;

public class person {
    private int age; //年龄
    private String sex;//性别

    public int getAge() {
        return age;
    }

    public void setAge(int age)throws Exception {
        if(age>1&&age<200){
            this.age = age;
        }else{
            throw new Exception("年龄过大或者过小:"+age);
        }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) throws Exception {
        if(sex.equals("男")||sex.equals("女")){
            this.sex = sex;
        }else {
            throw new Exception("性别不可理解:"+sex);
        }
    }

    @Override
    public String toString() {
        return "person{" +
                "age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
