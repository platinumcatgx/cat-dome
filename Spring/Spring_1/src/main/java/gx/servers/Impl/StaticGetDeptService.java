package gx.servers.Impl;

public class StaticGetDeptService {
    public static DeptService getDeptSer(){
        return new DeptService();
    }
}
