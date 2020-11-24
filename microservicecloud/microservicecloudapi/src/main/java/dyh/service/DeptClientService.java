package dyh.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dyh.entities.Dept;


//@FeignClient(value = "MICROSERVICELOUD-DEPT")
//降级概念： 当接口
@FeignClient(value = "MICROSERVICELOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFacktory.class)	//服务降级处理、替换掉：dyh.controller.DeptController下面的 、@HystrixCommand(fallbackMethod = "processHystrix_Get")
public interface DeptClientService {
	
		@RequestMapping(value="/dept/discovery", method = RequestMethod.GET)
		public Object discovery();
	
		@RequestMapping(value="/dept/get/{id}", method = RequestMethod.GET)
		public Dept get(@PathVariable("id") long id);
		
		@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
		public List<Dept> list();
		
		@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
		public int add(Dept dept);
}
