package myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * 自定义负载均衡算法、不能与主启动类目录和子目录在一起、所以单独、独立到myrule包下，不能让主启动类扫描到该类
 * @author dyh
 *
 */

@Configuration
public class MySelfRule {
	
	@Bean
	public IRule MyRule() {
		System.out.println("**************自定义负载均衡***************");
		//return new RandomRule();	//Ribbon默认时轮询、我自定义为随机
		
		return new RandomRule_Custom();	//自定义负载均衡算法
	}
}
