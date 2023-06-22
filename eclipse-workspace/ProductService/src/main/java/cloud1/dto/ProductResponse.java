package cloud1.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//创建这个类的目的：以便创建获得端点以便获取所有要访问的产品端点

//复制request的东西
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
	
	//复制product的变量（为什么不直接使用Product而要创建一个ProductRespinse：
	// 分离模型的好处
	
	private String id;
	private String name;
	private String description;
	private BigDecimal price; 

}

