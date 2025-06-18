package com.mercadolibre.melifrescosg9w31.repository;

import com.mercadolibre.melifrescosg9w31.dtos.WarehouseDTO;
import com.mercadolibre.melifrescosg9w31.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBatchRepository extends JpaRepository<Batch, Long> {
    // Suma el actualQuantity para un producto específico y lotes no vencidos (opcional)
    @Query("SELECT SUM(b.actualQuantity) FROM Batch b WHERE b.product.id = :productId AND b.actualQuantity > 0")
    Integer getStockForProduct(Long productId);

    // Si solo quieres los lotes no vencidos:
    @Query("SELECT SUM(b.actualQuantity) FROM Batch b WHERE b.product.id = :productId AND b.actualQuantity > 0 AND b.expireDate > CURRENT_DATE")
    Integer getStockForProductValid(Long productId);

    // Supongamos que expireDate es de tipo LocalDate
    List<Batch> findByProductIdAndExpireDateAfterOrderByExpireDateAsc(Long productId, LocalDate fechaHoy);

    //ENDPOINT 5
    // Busca batches no vencidos, próximos a vencer (dentro de 21 días) y con stock, de un warehouse específico
    @Query("SELECT b FROM Batch b WHERE b.product.id=:productId AND b.sector.warehouse.id=:warehouseId " +
            "AND b.actualQuantity>0 " +
            "AND b.expireDate >= :maxExpireDate ORDER BY b.expireDate ASC")
    List<Batch> findBatchesAvailableForOrder(Long productId, Long warehouseId, LocalDate maxExpireDate);

    List<Batch> findAllByProductIdAndExpireDateAfterOrderByExpireDateAsc(Long productId, LocalDate minimumExpireDate);

    @Query(
            "SELECT b FROM Batch b "
                    + "JOIN b.product p "
                    + "JOIN b.sector s "
                    + "JOIN s.productType pt "
                    + "WHERE p.id = :productId "
                    + "AND pt.id = :productTypeId "
                    + "AND s.id <> :sectorId")
    List<Batch> findByProductIdAndProductTypeIdExcludingSector(
            @Param("productId") Long productId,
            @Param("productTypeId") Long productTypeId,
            @Param("sectorId") Long sectorId);

    Optional<Batch> findByBatchNumberAndInboundOrderId(Integer batchNumber, Long id);

    @Query("SELECT b FROM Batch b WHERE b.product.id = :productId")
    List<Batch> findBatchByProductId(@Param("productId") Long productId);

    @Query("SELECT b FROM Batch b WHERE b.expireDate BETWEEN :today AND :date ORDER BY b.expireDate ASC")
    List<Batch> findBatchesWithDueDateBetweenOrderedAsc(@Param("today") LocalDate today, @Param("date") LocalDate date);

    @Query("SELECT b FROM Batch b WHERE b.product.id = :productId ORDER BY b.batchNumber ASC")
    List<Batch> findBatchByProductIdOrderByBatchNumber(@Param("productId") Long productId);

    @Query("SELECT b FROM Batch b WHERE b.expireDate BETWEEN :today AND :date AND b.product.productType.category = :category ORDER BY b.expireDate ASC")
    List<Batch> findBatchesWithDueDateBetweenFromCategoryOrderedAsc(@Param("today") LocalDate today, @Param("date") LocalDate date, @Param("category") String category);

    @Query("SELECT b FROM Batch b WHERE b.expireDate BETWEEN :today AND :date AND b.product.productType.category = :category ORDER BY b.expireDate DESC")
    List<Batch> findBatchesWithDueDateBetweenFromCategoryOrderedDesc(@Param("today") LocalDate today, @Param("date") LocalDate date, @Param("category") String category);

    @Query("SELECT b FROM Batch b WHERE b.product.id = :productId ORDER BY b.actualQuantity ASC")
    List<Batch> findBatchByProductIdOrderByActualQuantity(@Param("productId") Long productId);

    @Query("SELECT b FROM Batch b WHERE b.product.id = :productId ORDER BY b.expireDate ASC")
    List<Batch> findBatchByProductIdOrderByDueDate(@Param("productId") Long productId);

    @Query("SELECT new com.mercadolibre.melifrescosg9w31.dtos.WarehouseDTO(w.warehouseCode, SUM(b.actualQuantity)) " +
            "FROM Batch b " +
            "JOIN b.sector s " +
            "JOIN s.warehouse w " +
            "WHERE b.product.id = :productId " +
            "GROUP BY w.warehouseCode")
    List<WarehouseDTO> findTotalQuantityInWarehouseByProductId(@Param("productId") Long productId);

    @Query("SELECT b FROM Batch b WHERE b.sector.id IN (:list)")
    List<Batch> findBySectorIds(List<Long> list);
}
