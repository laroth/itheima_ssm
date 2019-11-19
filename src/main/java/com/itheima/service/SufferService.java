package com.itheima.service;

import com.itheima.domain.Department;
import com.itheima.domain.Suffer;

import java.util.List;

public interface SufferService {

    List<Suffer> query();

    List<Department> queryDepts();


    void createNewone(Suffer newsuffer);

    List<Suffer> selectByName(String name);

    List<Suffer> selectByConditions(String name, String ageRange, String deptid);
}
