package com.itheima.mapper;

import com.itheima.domain.Department;
import com.itheima.domain.Suffer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface SufferMapper {

    //查询全部患者
    @Select(" SELECT s.*,d.deptName deptName ,d.id deptid FROM suffer s LEFT JOIN dept d ON s.deptid=d.id")
    List<Suffer> query();

    //查询全部部门
    @Select("SELECT * FROM dept ")
    List<Department> queryDepts();

    //插入一条挂号记录
    @Insert("INSERT INTO suffer(name,gender,age,deptid) VALUES(#{name},#{gender},#{age},#{deptid})")
    void insert(Suffer newsuffer);

    //跟据姓名模糊查询
    @Select(" SELECT s.*,d.deptName deptName ,d.id deptid FROM suffer s LEFT JOIN dept d ON s.deptid=d.id WHERE NAME LIKE CONCAT('%',#{name},'%')\n")
    List<Suffer> selectByName(String name);



}
