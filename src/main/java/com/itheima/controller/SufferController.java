package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.Department;
import com.itheima.domain.Suffer;
import com.itheima.service.SufferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    /**
     * @Description: 查询所有患者名单
     * @Author: Mr.oth
     * @Date: 2019/11/19 10:51
    * @return java.lang.String
    */
    @RequestMapping(value="/reservation",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String reserve() throws JsonProcessingException {
        List<Suffer> list= sufferService.query();
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        return s;
    }

    /**
     * @Description: 查询所有挂号科室
     * @Author: Mr.oth
     * @Date: 2019/11/19 10:51
    * @return java.lang.String
    */
    @RequestMapping(value="/departments",produces =  "application/json;charset=utf-8")
    @ResponseBody
    public String queryDept() throws JsonProcessingException {
       List<Department> deptlist= sufferService.queryDepts();
        String s = new ObjectMapper().writeValueAsString(deptlist);
        return s;
    }

    /**
     * @Description: 新增挂号
     * @Author: Mr.oth
     * @Date: 2019/11/19 10:51
    * @param
     * @return null
    */
    @RequestMapping(value="/newone",produces =  "application/json;charset=utf-8")
    public String newone(Suffer newsuffer,String deptid){
         sufferService.createNewone(newsuffer);
         return "/pages/subscribe-form.jsp";
    }


    @RequestMapping(value = "/selectByName",produces =  "application/json;charset=utf-8")
    @ResponseBody
    public String selectByName(String name) throws JsonProcessingException {
        List<Suffer> lists= sufferService.selectByName(name);
        return new ObjectMapper().writeValueAsString(lists);
    }
}
