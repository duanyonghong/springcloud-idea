package dyh.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import dyh.entities.Dept;
import dyh.service.DeptService;

@Controller
public class DeptController {

	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;	// 客户端发现
	
	
	
	
	//hystrixCommand 关键处理
	@RequestMapping(value="/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get")	//熔断方法说明：一旦调用服务方法失败并抛出了错误信息后,会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@ResponseBody
	public Dept get(@PathVariable("id") Long id) {	//@PathVariable 接收请求路径中占位符的值
		
		Dept dept = service.get(id);
		
		if(null == dept) {
			throw new RuntimeException("该ID："+ id + "没有对应的信息");
		}
		return dept;		
	}
	
	
	
	  public Dept processHystrix_Get(@PathVariable("id") Long id) { 
		  return new Dept().setDeptno(id).setDname("该ID: " + id + "没有对应的信息，null--@HystrixCommand")
				  .setDbsource("no this database in MySql").setDtime(new Date()); 
		}
	 
	
	
	
	
	
	
	
	//对外查看注册中心有哪些 客户端 微服务
	@RequestMapping(value="/dept/discovery", method = RequestMethod.GET)
	@ResponseBody
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("*************\t" + list);	// 获取所有已注册的微服务名称
		
		List<ServiceInstance> srvList = client.getInstances("MICROSERVICELOUD-DEPT");	//根据微服务名称获取微服务对象
		
		for (ServiceInstance serviceInstance : srvList) {
			System.out.println(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());	//打印微服务信息
		}
		return srvList;
	}
	
	@RequestMapping(value="/dept/add", method = RequestMethod.POST)
	@ResponseBody
	public int add(@RequestBody Dept dept) {// @RequestBody 加上这个前端传参必须是json格式、而且要是post
		return service.add(dept);
	};	
	
	
	
	
	
	@RequestMapping(value="/dept/list", method = RequestMethod.GET)
	@ResponseBody
	public List<Dept> list(){
		System.out.println("******************dept list******************");
		return service.list();
	} 
	
}
