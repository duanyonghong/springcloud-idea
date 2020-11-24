package dyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient	//开启eureka注册中心模式、本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient	//服务发现、查询注册中心都有哪些服务提供者
@EnableCircuitBreaker //开启、对hystrix熔断器机制的支持、dyh.controller.DeptController
public class DeptProvider8001_Hystrix_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
	}

}
