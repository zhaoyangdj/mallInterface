package com.springapp.controller;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.chuchujie.mall.api.CommentApi;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/commentApi")
public class CommentController {

    @Resource
    private CommentApi commentApi;

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    public String get() {
        long stime = System.currentTimeMillis();
        String json = commentApi.get();
        return  json;
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public String getUser() {
        long stime = System.currentTimeMillis();
        String json = commentApi.getByName();
        return  json;
    }

    @ResponseBody
    @RequestMapping(value = "/name", method = RequestMethod.GET, produces = "application/json")
    public String getName() {
        long stime = System.currentTimeMillis();
        String json = commentApi.getName();
        return  json;
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List getUsers() {
        long stime = System.currentTimeMillis();
        List list = commentApi.getUsers();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
        return  list;
    }

}