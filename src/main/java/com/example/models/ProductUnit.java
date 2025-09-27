package com.example.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product_unit")
@Data
public class ProductUnit {

    @EmbeddedId
    private ProductUnitId id;

    @ManyToOne
    @MapsId("inventoryUnitId")
    @JoinColumn(name = "id_inventory_unit")
    private InventoryUnit inventoryUnit;

    @ManyToOne
    @MapsId("unidadAdministrativaId")
    @JoinColumn(name = "id_unit")
    private UnidadAdministrativa unidadAdministrativa;

    public ProductUnit() {}

    public ProductUnit(InventoryUnit inventoryUnit, UnidadAdministrativa unidadAdministrativa) {
        this.inventoryUnit = inventoryUnit;
        this.unidadAdministrativa = unidadAdministrativa;
        this.id = new ProductUnitId(inventoryUnit.getId(), unidadAdministrativa.getIdUniAdm());
    }
}
