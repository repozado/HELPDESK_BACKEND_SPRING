package com.example.models;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ProductUnitId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer inventoryUnitId;          // Corresponde a id_inventory_unit
    private Integer unidadAdministrativaId;   // Corresponde a id_unit

    public ProductUnitId() {}

    public ProductUnitId(Integer inventoryUnitId, Integer unidadAdministrativaId) {
        this.inventoryUnitId = inventoryUnitId;
        this.unidadAdministrativaId = unidadAdministrativaId;
    }
}
