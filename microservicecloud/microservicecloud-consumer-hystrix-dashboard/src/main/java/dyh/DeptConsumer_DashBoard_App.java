package dyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard	  //开启图像化监控注解\启动后访问：http://127.0.0.1:9001/hystrix
public class DeptConsumer_DashBoard_App {
		public static void main(String[] args) {
			SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
		}
}
