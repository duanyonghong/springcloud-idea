package dyh.service;

import java.util.List;

import dyh.entities.Dept;

public interface DeptService {
	
		public int add(Dept dept);
		
		public Dept get(Long id);
		
		public List<Dept> list();
}
