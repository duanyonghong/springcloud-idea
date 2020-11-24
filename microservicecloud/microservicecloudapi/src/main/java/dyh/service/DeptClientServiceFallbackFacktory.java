package dyh.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import dyh.entities.Dept;
import feign.hystrix.FallbackFactory;

@Component //不要忘记添加注解
public class DeptClientServiceFallbackFacktory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		return new DeptClientService() {
			
				@Override
				public List<Dept> list() {
					return null;
				}
				
				@Override
				public Dept get(long id) {
					return new Dept().setDeptno(id).setDname("该ID: " + id + "没有对应的信息，Consumer客户端提供的降级信息, 此刻服务Provider已关闭")
							 .setDbsource("no this database in MySql").setDtime(new Date());
				}
				
				@Override
				public Object discovery() {
					return null;
				}
				
				@Override
				public int add(Dept dept) {
					return 0;
				}
		};
	}

}
