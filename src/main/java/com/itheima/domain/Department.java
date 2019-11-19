package com.itheima.domain;

/**
 * @program: IDEAProject
 * @description:
 * @author: Mr.Laroth
 * @create: 2019-11-19 13:04
 **/
public class Department {
    private int id;
    private String  deptName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
