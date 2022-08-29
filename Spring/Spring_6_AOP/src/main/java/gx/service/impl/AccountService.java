package gx.service.impl;

import gx.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountService implements IAccountService {


    public void Save() {
        System.out.println("执行了保存");
    }

    public void Update(int i) {
        System.out.println("执行了更新");
    }

    public int Delete() {
        System.out.println("执行了删除");
        return 0;
    }
}
