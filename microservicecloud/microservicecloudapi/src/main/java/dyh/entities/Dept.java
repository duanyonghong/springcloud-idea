package dyh.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;


@SuppressWarnings("serial")	//忽略黄色警告线
@Data	//提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
@Accessors(chain=true)	//支持链式写法, 如：dept.setDbsource("x1").setDname("x2");
public class Dept implements Serializable{
	
		private Long deptno; //主键
		private String dname;	//名称
		private String dbsource; //来自哪个数据库,因为微服务架构可以一个服务对应一个数据库,同一个信息被存储到不同的数据库
		private Date dtime;




}
