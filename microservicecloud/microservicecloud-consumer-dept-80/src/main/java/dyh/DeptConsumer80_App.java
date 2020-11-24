package dyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

import myrule.MySelfRule;


//RestTemplate + Ribbon 
@SpringBootApplication
@EnableEurekaClient //开启uereka注册中心模式, 英语发音(you rui ka)
@RibbonClient(name="MICROSERVICELOUD-DEPT", configuration = MySelfRule.class)	//自定义负载均衡算法、 英语发音：（ruai ben）  MySelfRule。class不能与@ComponentScan 在同一级和子目录下,所以它的包名另外建立：myrule、不能在dyh包下
public class DeptConsumer80_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}

}
