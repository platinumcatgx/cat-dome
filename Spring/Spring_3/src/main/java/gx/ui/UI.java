package gx.ui;

import gx.domain.Dept;
import gx.domain.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("ui")
public class UI {
    @Autowired
    public Dept dept1=null;
    @Autowired
    public Dept dept2=null;

    @Autowired
    public Emp emp1 = null;
    @Autowired
    public Emp emp2 = null;

}
