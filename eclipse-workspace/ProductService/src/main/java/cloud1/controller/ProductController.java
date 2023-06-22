package cloud1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cloud1.dto.ProductRequest;
import cloud1.dto.ProductResponse;
import cloud1.repository.ProductRepository;
import cloud1.service.ProductService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor //initialize productService declaration

public class ProductController {
	
	//这里的final也是 写完ProductService的方法 再来写
	private final ProductService productService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	
	public void createProduct(@RequestBody ProductRequest productRequest) {	
		//这里的方法主体内容是 写完ProductService的方法 再来写
		//该方法作用：创建 创建产品的 端点
		//下一步是创建另一个端点来检索所有产品--- 先创建另一个dto—productRespons
		productService.createProduct(productRequest);		
	}
	
	 
	//获取缎端点以便获取所有要访问的产品端点
	 
	@GetMapping //获取摄映射注释
	@ResponseStatus(HttpStatus.OK) //用于发送HTTP响应状态
	public List<ProductResponse> getAllProducts(){
		
		//在productService内部创建一个方法获取所有方法
		return productService.getAllProducts();
			
		
	}
	

}
