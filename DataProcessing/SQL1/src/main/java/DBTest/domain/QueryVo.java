package DBTest.domain;

import java.util.List;

public class QueryVo {
    private Emp emp;

    private List<Integer> ids;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "emp=" + emp.toString() +
                '}';
    }
}
