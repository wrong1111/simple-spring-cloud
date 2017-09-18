package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.UserConfig;
import com.example.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping("/movie")
public class MovieController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	UserConfig userConfig;


	
	@Autowired
	private LoadBalancerClient loadBalancerClient; 
	
	
	 /**
     * 为Netflix不具体的发现客户端提供简单的API
     */
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @Autowired
    private EurekaClient eurekaClient;
    
	/**
	 * 配合robbin使用 
	 * 需要provider-user模块注意几点，
	 * 	1, 配置spring.application.name=simple-provider-user
	 *  2,配置eureka.instance.instance_id=instance-id: ${spring.application.name}:${spring.cloud.client.ipAddress}:${spring.application.instance_id:${server.port}}
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Integer id) { 
		return this.restTemplate.getForObject(userConfig.getUserServiceUrl() + id, User.class);
//		return simpleProviderUserClient.user(id);
	}
//	@Autowired
//	SimpleProviderUserClient simpleProviderUserClient;
//	
//	
//	@FeignClient("simple-provider-user")
//    interface SimpleProviderUserClient {
//        @RequestMapping(value = "/user", method = GET)
//        User user(Integer id);
//    }

	
    /**
	 * 用于处理rpc内部请求处理的默认内置处理类
	 * @return
	 */
	@Bean
	@LoadBalanced //用于处理客户端的轮循请求。
	public RestTemplate restTemaplate() {
		return new RestTemplate();
	}
	@Autowired
	private RestTemplate restTemplate;

	/**
     * 发现其他服务, 返回一个url:port
     * @return
     */
    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo eureka = this.eurekaClient.getNextServerFromEureka("simple-consumer-movie", false);
        return eureka.getHomePageUrl();
    }
	 /**
	  * 发现服务的一些配置说明
	  * 尤其可以自定义配置metadata: key-value值
	  * 如：
	  * {"host":"192.168.88.101","port":8010,"serviceId":"simple-consumer-movie",
	  * 	"metadata":{"abc":"test","movie":"simple-consumer-movie","zone":"beijing"},
	  * 	"secure":false,"uri":"http://192.168.88.101:8010"}
	 * @return
	 */
	@GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }

	/**
	 * 为测试robbin是否应用了负载均衡。具体看打印日志输出 
	 */
	@GetMapping("/log-instance")
	public void logUserInstance() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("simple-provider-user");
		MovieController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());;
	}
	
}
