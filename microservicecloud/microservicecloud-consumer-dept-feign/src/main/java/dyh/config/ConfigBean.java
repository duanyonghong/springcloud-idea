package dyh.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;



//@Configuration 
public class ConfigBean { //boot --> spring applictionContext.xml --- @Configuration 配置 ConfigBean = applicationContext.xml
	
	
	//@Bean //已使用feign接口编程进行调用了、所有这个不用了，接口编程地址:   /microservicecloudapi/src/main/java/dyh/service/DeptClientService.java
	//@LoadBalanced //SpringCloud Ribbon 是基于Netfix Ribbon实现的一套客户端    负载均衡的工具
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/**
	   springcloud 自带负载均衡算法
	   已使用自定义负载均衡：myrule.MySelfRule.java
	   这个自带的负载均衡就关闭了
	 * @return
	 */
	//@Bean
	public IRule myRule() {		
		
		//return new RoundRobinRule();	//轮询 (SpringCloud默认)
		return new RandomRule();	//随机 
		//return new AvailabilityFilteringRule();	//会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务, 还有并发的连接数量超过阈值的服务,然后对剩余的服务列表按照轮询策略进行访问;
		
		
		/*  根据平均响应时间计算所有服务的权重,响应时间越快服务权重越大,被选中的概率高.
			刚启动时如果统计信息不足,则使用RoundRobinRule策略,等统计信息足够,会切换到WeightedResponseTimeRule
		 */
		//return new WeightedResponseTimeRule(); 
				
		//return new RetryRule();	//先按照RoundRobinRule的策勒获取服务,如果获取服务失败则在指定的时间内会进行重试,获取可用的服务, 如果轮询每次都是到同一个服务出现故障、则自动从轮询中移除、继续轮询其它可执行的服务
		
		
		//return new BestAvailableRule();	//会先过滤掉犹豫多次访问故障而处于断路器跳闸状态的服务,然后选择一个并发量最小的服务
		
		//return new ZoneAvoidanceRule();	//默认规则,复合判断server所在区域的性能和server的可用性选择服务器
	}
}
