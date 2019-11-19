package com.itheima.mapper;

import com.itheima.domain.Department;
import com.itheima.domain.Suffer;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface SufferMapper {

    List<Suffer> query();

    List<Department> queryDepts();

    void insert(Suffer newsuffer);

    List<Suffer> selectByName(String name);


    List<Suffer> selectByConditions(@Param("name") String name,@Param("maxage") int maxage,@Param("minage") int minage,@Param("deptid") String deptid);
}
