package dyh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dyh.entities.Dept;
import dyh.service.DeptClientService;

@Controller
public class DeptController_Consumer {
	
	@Autowired
	private DeptClientService deptClientService;

	@RequestMapping(value="/consumer/dept/discovery")
	@ResponseBody
	public Object discovery() {
		System.out.println("*********************feign*********************");
		return deptClientService.discovery();
	}
	
	@RequestMapping(value="/consumer/dept/add")
	@ResponseBody
	public int add(Dept dept) {
		return deptClientService.add(dept);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}")
	@ResponseBody
	public Dept get(@PathVariable("id") Long id) {
		return deptClientService.get(id);
	}
	
	@SuppressWarnings("unchecked")	//去除List.calss报出的黄线
	@RequestMapping(value="/consumer/dept/list")
	@ResponseBody
	public List<Dept> list() {
		return deptClientService.list();
	}
	
}
