package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Department;
import com.itheima.domain.Suffer;
import com.itheima.service.SufferService;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: IDEAProject
 * @description:
 * @author: Mr.Laroth
 * @create: 2019-11-18 19:16
 **/
@Controller
@RequestMapping("/guahao")
public class SufferController {
    @Autowired
    private SufferService sufferService;

    //查询所有患者名单
    @RequestMapping(value="/reservation",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String reserve() throws JsonProcessingException {
        List<Suffer> list= sufferService.query();
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        return s;
    }

    // 查询所有挂号科室
    @RequestMapping(value="/departments",produces =  "application/json;charset=utf-8")
    @ResponseBody
    public String queryDept() throws JsonProcessingException {
       List<Department> deptlist= sufferService.queryDepts();
        String s = new ObjectMapper().writeValueAsString(deptlist);
        return s;
    }

    //新增挂号
    @RequestMapping(value="/newone",produces =  "application/json;charset=utf-8")
    public String newone(Suffer newsuffer,String deptid){
         sufferService.createNewone(newsuffer);
         return "/pages/subscribe-form.jsp";
    }


    //根据姓名模糊查询
    @RequestMapping(value = "/selectByName",produces =  "application/json;charset=utf-8")
    @ResponseBody
    public String selectByName(String name) throws JsonProcessingException {
        List<Suffer> lists= sufferService.selectByName(name);
        return new ObjectMapper().writeValueAsString(lists);
    }


    //根据多条件模糊查询
    @RequestMapping(value = "/selectByConditions",produces =  "application/json;charset=utf-8")
    @ResponseBody
    public String selectByConditions(@RequestParam("name") String name,@RequestParam("age") String ageRange,@RequestParam("dept") String deptid) throws JsonProcessingException {
//        int maxage= Integer.parseInt("ageRange.split('-')[1]");
//        int maxage= Integer.parseInt("ageRange.split('-')[1]");
        List<Suffer> lists= sufferService.selectByConditions(name,ageRange,deptid);
        return new ObjectMapper().writeValueAsString(lists);
    }

}
