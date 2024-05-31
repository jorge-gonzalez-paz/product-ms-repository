package cl.nttdata.digital.architecture.microservice.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Entity Anotacion para indicar que la clase es una Entity asociado a una tabla de la Base de Datos
 * @Table permite indicar el nombre de la tabla a la que mapea la clase
 */
@Entity
@Table(name = "product")
@Data
public class Product {
    private static final long serialVersionUID = -591431458693400219L;
    /**
     * @Id permite indicar que el campo es clave primaria en la tabla
     * @GeneratedValue permite asignar un autoincremental a la tabla
     * @Column Permite indicar a que columna mapea el campo de la clase
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "product_amount")
    private BigDecimal productAmount;
}
