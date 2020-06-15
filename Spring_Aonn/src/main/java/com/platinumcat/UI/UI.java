package com.platinumcat.UI;

import com.platinumcat.Service.impl.DeptSer;
import com.platinumcat.Service.impl.EmpSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UI {
    @Autowired
    private EmpSer empSer;
    @Autowired
    private DeptSer deptSer;

    public void print(){
        System.out.println(empSer.findAll());
        System.out.println(deptSer.findAll());
    }
}
