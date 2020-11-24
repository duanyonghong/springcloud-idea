package dyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy	//路由网关开启
public class Zuul_9527_startSpringCloudApp {
		
		public static void main(String[] args) {
			SpringApplication.run(Zuul_9527_startSpringCloudApp.class, args);
		}
}
