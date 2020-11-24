package dyh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import dyh.entities.Dept;
import myrule.MySelfRule;

@Controller
public class DeptController_Consumer {
	
//	private static final String REST_URL_PREFIX = "http://localhost:8001"; //直连
	private static final String REST_URL_PREFIX = "http://MICROSERVICELOUD-DEPT";
	
	/**
	 * 使用restTemplate访问restful接口非常的简单粗暴无脑
	 * (url,requestMap, ResponseBean.class) 这三个参数分别代表REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping(value="/consumer/dept/discovery")
	@ResponseBody
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
	}
	
	@RequestMapping(value="/consumer/dept/add")
	@ResponseBody
	public int add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Integer.class);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	@ResponseBody
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	
	@SuppressWarnings("unchecked")	//去除List.calss报出的黄线
	@RequestMapping(value="/consumer/dept/list")
	@ResponseBody
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
	}
	
}
