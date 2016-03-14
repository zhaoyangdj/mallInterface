package com.springapp.controller;

import com.chuchujie.mall.api.TestApi;
import com.chuchujie.mall.api.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/3/11.
 */
@Controller
@RequestMapping("/testApi")
public class TestController {

    @Resource
    private TestApi testApi;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "application/json")
    public String add() {
        long stime = System.currentTimeMillis();
        User users=new User();
        users.setId(100);
        users.setName("add");
        users.setAge(10);
        users.setSex(0);
        String json = testApi.addTest(users);
        return  json;
    }

    @ResponseBody
    @RequestMapping(value = "/del", method = RequestMethod.GET, produces = "application/json")
    public String del() {
        long stime = System.currentTimeMillis();
        String json = testApi.delTest(111);
        return  json;
    }

    @ResponseBody
    @RequestMapping(value = "/modify", method = RequestMethod.GET, produces = "application/json")
    public String modify() {
        long stime = System.currentTimeMillis();
        User users=new User();
        users.setId(100);
        users.setName("modify");
        users.setAge(10);
        users.setSex(0);
        String json = testApi.modifyTest(users);
        return  json;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User> select() {
        long stime = System.currentTimeMillis();
        User users=new User();
        users.setId(100);
        users.setName("add");
        users.setAge(10);
        users.setSex(0);
        User user = testApi.selectTest(users);
        return  ResponseEntity.ok(user);
    }
}
