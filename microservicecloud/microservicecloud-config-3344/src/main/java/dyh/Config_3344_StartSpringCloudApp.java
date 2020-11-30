package dyh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer	//统一配置开启
//http://config-3344.com:3344/application-dev.yml	dev环境
//http://config-3344.com:3344/application-test.yml	test环境
public class Config_3344_StartSpringCloudApp {
		public static void main(String[] args) {
			SpringApplication.run(Config_3344_StartSpringCloudApp.class, args);
		}
}
