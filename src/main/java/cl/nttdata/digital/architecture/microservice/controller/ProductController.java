package cl.nttdata.digital.architecture.microservice.controller;

import cl.nttdata.digital.architecture.microservice.bean.ProductBean;
import cl.nttdata.digital.architecture.microservice.domain.Product;
import cl.nttdata.digital.architecture.microservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The ProductController class is a REST controller in a Spring Boot application.
 * It handles HTTP requests related to products and delegates the business logic to the ProductService.
 *
 * @author jorge-gonzalez-paz
 */
@RestController
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService service;

    /**
     * Handles the POST requests to create a new product.
     *
     * @param product The product to be created.
     * @return ResponseEntity with the created product and an HTTP status code.
     */
    @PostMapping(value = "/v1/product", produces = {"application/json"})
    public ResponseEntity<ProductBean> createProducto(@RequestBody ProductBean product) {
        try {
            product = service.createProduct(product);
            return new ResponseEntity(product, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity(product, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Handles the GET requests to retrieve a list of all products.
     *
     * @return ResponseEntity with the list of products and an HTTP status code.
     */
    @GetMapping(value = "/v1/product", produces = {"application/json"})
    public ResponseEntity<List<Product>> getProductos() {
        return new ResponseEntity(service.getProducts(), HttpStatus.OK);
    }

    //create a GetMapping to get a ProductBean by id
    /**
     * Handles the GET requests to retrieve a product by ID.
     *
     * @param productId The ID of the product to retrieve.
     * @return ResponseEntity with the product and an HTTP status code.
     */
    @GetMapping(value = "/v1/product/{productId}", produces = {"application/json"})
    public ResponseEntity<ProductBean> getProducto(@PathVariable Long productId) {
        ProductBean product = service.getProduct(productId);
        if (product != null) {
            return new ResponseEntity(product, HttpStatus.OK);
        } else {
            return new ResponseEntity(product, HttpStatus.NOT_FOUND);
        }
    }

    //create a PutMapping to update a ProductBean
    /**
     * Handles the PUT requests to update a product.
     *
     * @param productId The ID of the product to update.
     * @param product The updated product data.
     * @return ResponseEntity with the updated product and an HTTP status code.
     */
    @PutMapping(value = "/v1/product/{productId}", produces = {"application/json"})
    public ResponseEntity<ProductBean> updateProducto(@PathVariable Long productId, @RequestBody ProductBean product) {
        product = service.updateProduct(productId, product);
        if (product != null) {
            return new ResponseEntity(product, HttpStatus.OK);
        } else {
            return new ResponseEntity(product, HttpStatus.NOT_FOUND);
        }
    }

    //create a DeleteMapping to delete a ProductBean
    /**
     * Handles the DELETE requests to delete a product by ID.
     *
     * @param productId The ID of the product to delete.
     * @return ResponseEntity with an HTTP status code.
     */
    @DeleteMapping(value = "/v1/product/{productId}", produces = {"application/json"})
    public ResponseEntity deleteProducto(@PathVariable Long productId) {
        if (service.deleteProduct(productId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}