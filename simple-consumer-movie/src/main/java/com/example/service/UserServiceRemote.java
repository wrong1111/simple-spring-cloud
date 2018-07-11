package  com.example.service;


import com.example.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign调用实现
 */
@FeignClient(name= "simple-provider-user")
public interface UserServiceRemote {

    @RequestMapping(value = "/user")
    public User findUserById(@RequestParam(value = "id") Integer id);
}