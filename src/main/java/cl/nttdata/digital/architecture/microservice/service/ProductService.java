package cl.nttdata.digital.architecture.microservice.service;

import cl.nttdata.digital.architecture.microservice.bean.ProductBean;
import cl.nttdata.digital.architecture.microservice.domain.Product;
import cl.nttdata.digital.architecture.microservice.jpa.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The ProductService class provides business logic related to products.
 * It interacts with the ProductRepository to perform database operations.
 * This class is marked as a service in the Spring Boot application, allowing it to be automatically
 * instantiated and used in other classes.
 *
 * @author jorge-gonzalez-paz
 */
@Service
public class ProductService {
    /**
     * The ProductRepository instance for interacting with the database.
     */
    @Autowired
    private ProductRepository repository;

    /**
     * Creates a new product using the provided ProductBean.
     * The creation date is set to the current date and time.
     * The product is saved in the database and the generated ID and creation date are set in the ProductBean.
     *
     * @param bean The ProductBean representing the product to be created.
     * @return The ProductBean with the generated ID and creation date.
     */
    public ProductBean createProduct(ProductBean bean) {
        Product p = new Product();
        p.setProductName(bean.getProductName());
        p.setProductCode(bean.getProductCode());
        p.setProductDescription(bean.getProductDescription());
        p.setProductAmount(bean.getProductAmount());
        p.setCreationDate(LocalDateTime.now());

        p = repository.save(p);

        bean.setProductId(p.getProductId());
        bean.setCreationDate(p.getCreationDate());

        return bean;
    }

    /**
     * Retrieves all products from the database.
     * Each product is converted to a ProductBean.
     *
     * @return A list of ProductBeans representing all products in the database.
     */
    public List<ProductBean> getProducts() {
        List<Product> products = repository.findAll();
        return products.stream().map(p -> getProductBean(p)).collect(Collectors.toList());
    }

    //create a method for get a Product by productId and return as a ProductBean
    public ProductBean getProduct(Long productId) {
        Product product = repository.findById(productId).orElse(null);

        if (product == null) {
            return null;
        }

        return getProductBean(product);
    }

    /**
     * Converts a Product entity to a ProductBean.
     *
     * @param product The Product entity to be converted.
     * @return The ProductBean representing the provided Product entity.
     */
    private ProductBean getProductBean(Product product) {
        ProductBean bean = new ProductBean();

        bean.setProductName(product.getProductName());
        bean.setProductCode(product.getProductCode());
        bean.setProductDescription(product.getProductDescription());
        bean.setProductAmount(product.getProductAmount());
        bean.setCreationDate(product.getCreationDate());

        return bean;
    }

    public boolean deleteProduct(Long productId) {
        repository.deleteById(productId);
        return true;
    }

    public ProductBean updateProduct(Long productId, ProductBean product) {
        //complete this method to update a product by productId and a productBean
        Product p = repository.findById(productId).orElse(null);
        if (p != null) {
            p.setProductName(product.getProductName());
            p.setProductCode(product.getProductCode());
            p.setProductDescription(product.getProductDescription());
            p.setProductAmount(product.getProductAmount());
            p = repository.save(p);
            return getProductBean(p);
        } else {
            return null;
        }
    }
}