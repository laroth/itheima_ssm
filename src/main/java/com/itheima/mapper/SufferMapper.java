package com.itheima.mapper;

import com.itheima.domain.Department;
import com.itheima.domain.Suffer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface SufferMapper {

    List<Suffer> query();

    List<Department> queryDepts();

    void insert(Suffer newsuffer);

    List<Suffer> selectByName(String name);



}
