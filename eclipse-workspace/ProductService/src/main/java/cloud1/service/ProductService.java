package cloud1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cloud1.dto.ProductRequest;
import cloud1.dto.ProductResponse;
import cloud1.model.Product;
import cloud1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@RequiredArgsConstructor //initialize declaration
@Slf4j
public class ProductService {
	
	
	private final ProductRepository productRepository ;
	
	//创建好产品实例(这里这个方法来自controller
	public void createProduct(ProductRequest productRequest) {
		
	Product product = Product.builder()
			.name(productRequest.getName())
			.description(productRequest.getDescription())
			.price(productRequest.getPrice())
		    .build();
	
	
	//下一步保存到数据库
	productRepository.save(product);
	log.info("Product {} is saved", product.getId());
			
	}

	public List<ProductResponse> getAllProducts() {
		
		// TODO Auto-generated method stub
		//本来是自动生成的 修改void改成return
		//读取数据里所有的产品 然后存在Product里 
		List<Product> products = productRepository.findAll();
		//然后用map转化成产品response(也就是讲每个产品映射到产品响应对象,这里创建一个新方法
		return products.stream().map(product -> mapToProductResponse()).toList()
	}
	
	
	//写这个mapToProductResponse方法
	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
			    .build();
		
	}
	//获得了所有产品返回产品响应列表以后，去controller，开始application并检查是否可以启动
	
	
}
