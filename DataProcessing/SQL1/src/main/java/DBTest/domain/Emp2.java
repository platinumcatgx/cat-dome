package DBTest.domain;

import java.util.Date;

public class Emp2 {
    private Integer empnos;
    private String enames;
    private String jobs;
    private Integer mgrs;
    private Date hiredates;
    private Integer sals;
    private Integer comms;
    private Integer deptnos;

    @Override
    public String toString() {
        return "Emp2{" +
                "empnos=" + empnos +
                ", enames='" + enames + '\'' +
                ", jobs='" + jobs + '\'' +
                ", mgrs=" + mgrs +
                ", hiredates=" + hiredates +
                ", sals=" + sals +
                ", comms=" + comms +
                ", deptnos=" + deptnos +
                '}';
    }

    public Integer getEmpnos() {
        return empnos;
    }

    public void setEmpnos(Integer empnos) {
        this.empnos = empnos;
    }

    public String getEnames() {
        return enames;
    }

    public void setEnames(String enames) {
        this.enames = enames;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public Integer getMgrs() {
        return mgrs;
    }

    public void setMgrs(Integer mgrs) {
        this.mgrs = mgrs;
    }

    public Date getHiredates() {
        return hiredates;
    }

    public void setHiredates(Date hiredates) {
        this.hiredates = hiredates;
    }

    public Integer getSals() {
        return sals;
    }

    public void setSals(Integer sals) {
        this.sals = sals;
    }

    public Integer getComms() {
        return comms;
    }

    public void setComms(Integer comms) {
        this.comms = comms;
    }

    public Integer getDeptnos() {
        return deptnos;
    }

    public void setDeptnos(Integer deptnos) {
        this.deptnos = deptnos;
    }
}
