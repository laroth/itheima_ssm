package com.itheima.service.impl;

import com.itheima.domain.Department;
import com.itheima.domain.Suffer;
import com.itheima.mapper.SufferMapper;
import com.itheima.service.SufferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: IDEAProject
 * @description:
 * @author: Mr.Laroth
 * @create: 2019-11-18 19:22
 **/
@Service
public class SufferServiceImpl implements SufferService {

    @Autowired
    private SufferMapper sufferMapper;


    //模糊查询方法一
    @Override
    public List<Suffer> selectByName(String name) {
        return sufferMapper.selectByName(name);
    }

    //模糊查询方法二
    /*@Override
    public List<Suffer> selectByName(String name) {
        return sufferMapper.selectByName("%"+name+"%");
    }*/

    /**
     * @Description: 添加新挂号流水
     * @Author: Mr.oth
     * @Date: 2019/11/19 11:17
 * @param newsuffer
    */
    @Override
    public void createNewone(Suffer newsuffer) {
        sufferMapper.insert(newsuffer);
    }

    /**
     * @Description: 查询全部挂号科室
     * @Author: Mr.oth
     * @Date: 2019/11/19 10:17
 * @return java.util.List<java.lang.String>
    */
    @Override
    public List<Department> queryDepts() {
        return sufferMapper.queryDepts();
    }

    /**
     * @Description: 查询全部患者
     * @Author: Mr.oth
     * @Date: 2019/11/19 10:17
 * @return java.util.List<com.itheima.domain.Suffer>
    */
    @Override
    public List<Suffer> query() {
        return sufferMapper.query();
    }
}
