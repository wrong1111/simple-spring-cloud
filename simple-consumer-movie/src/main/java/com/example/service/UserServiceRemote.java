package  com.example.service;


import com.example.pojo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign调用实现
 */
@FeignClient(name= "SIMPLE-PROVIDER-USER")
public interface UserServiceRemote {

    @RequestMapping(value = "/user/find")
    public User findUserById(@RequestParam(value = "id") Integer id);


    @RequestMapping(value = "/user/find/{id}")
    public User findById(@PathVariable Integer id);
}