package cl.nttdata.digital.architecture.microservice.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * The ProductBean class represents a product in the application.
 * This class is used to transfer data between different layers of the application.
 * Each instance of this class represents a unique product.
 *
 * @author jorge-gonzalez-paz
 */
@Data
public class ProductBean {
    /**
     * The unique identifier of the product.
     */
    @JsonProperty("product_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long productId;

    /**
     * The name of the product.
     */
    @JsonProperty("product_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String productName;

    /**
     * The description of the product.
     */
    @JsonProperty("product_description")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String productDescription;

    /**
     * The code of the product.
     */
    @JsonProperty("product_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String productCode;

    /**
     * The creation date of the product.
     */
    @JsonProperty("creation_date")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime creationDate;

    /**
     * The amount of the product.
     */
    @JsonProperty("product_amount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal productAmount;
}