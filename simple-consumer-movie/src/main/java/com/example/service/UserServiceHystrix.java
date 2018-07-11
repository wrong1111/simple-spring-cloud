package com.example.service;

import com.example.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wyong
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/11
 */
@Component
public class UserServiceHystrix implements UserServiceRemote{

    /**
     * 注意，feign调用 requestParam时，需要指定 value="xx"，否则会默认是queryMap
     *
     * @param id
     * @return
     */
    @Override
    public User findUserById(@RequestParam(value="id") Integer id) {
        User u = new User();
        u.setId(0);
        return new User();
    }

    @Override
    public User findById(@PathVariable(value="id")Integer id) {
        User u = new User();
        u.setId(0);
        return u;
    }
}
