package com.mercadolibre.melifrescosg9w31.utils;

import com.mercadolibre.melifrescosg9w31.dtos.BatchStockDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductBatchDTO;
import com.mercadolibre.melifrescosg9w31.dtos.ProductWarehouseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.WarehouseDTO;
import com.mercadolibre.melifrescosg9w31.dtos.request.ProductRequestDTO;
import com.mercadolibre.melifrescosg9w31.entity.*;
import com.mercadolibre.melifrescosg9w31.mapper.ProductBatchMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomFactory {
    private static final Long ID = 1L;
    private static final Product product = createProduct(ID);
    private static final Sector sector = createSector(ID);

    public static List<Sector> createTestSectors() {
        List<Sector> sectors = new ArrayList<>();
        Sector sector = new Sector();
        sector.setId(ID);
        sector.setWarehouse(createWarehouse(ID));
        sectors.add(sector);
        return sectors;
    }

    public static List<Batch> createBatchesWithDifferentStock() {
        Product product1 = createProduct(1L);
        product1.setName("Product 1");

        Product product2 = createProduct(2L);
        product2.setName("Product 2");

        Product product3 = createProduct(3L);
        product3.setName("Product 3");

        List<Batch> batches = new ArrayList<>();

        Batch batch1 = new Batch();
        batch1.setProduct(product3);
        batch1.setActualQuantity(20);
        batches.add(batch1);

        Batch batch2 = new Batch();
        batch2.setProduct(product1);
        batch2.setActualQuantity(30);
        batches.add(batch2);

        Batch batch3 = new Batch();
        batch3.setProduct(product2);
        batch3.setActualQuantity(60);
        batches.add(batch3);

        return batches;
    }


    public static ProductRequestDTO createProductRequestDTO() {
        ProductType productType = new ProductType(1L, "FF", "Congelado", BigDecimal.valueOf(5), BigDecimal.valueOf(10));
        Seller seller = new Seller();
        seller.setId(2L);
        seller.setName("Juan Seller");

        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setName("Fresa Orgánica");
        productRequestDTO.setDescription("Caja 1kg");
        productRequestDTO.setPrice(BigDecimal.valueOf(39.50));
        productRequestDTO.setProductType(productType);
        productRequestDTO.setSeller(seller);

        return productRequestDTO;
    }

    public static Product createProductFromRequestDTO(ProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setProductType(dto.getProductType());
        product.setSeller(dto.getSeller());
        return product;
    }


    public static ProductWarehouseDTO createProductWarehouseDTO() {
        List<WarehouseDTO> warehouses = new ArrayList<>();
        warehouses.add(new WarehouseDTO(1, 10L));
        warehouses.add(new WarehouseDTO(2, 20L));
        warehouses.add(new WarehouseDTO(3, 15L));
        warehouses.add(new WarehouseDTO(4, 1L));
        ProductWarehouseDTO productWarehouseDTO = new ProductWarehouseDTO(
                1L,
                warehouses
        );
        return productWarehouseDTO;
    }

    public static BatchStockDTO createBatchStockDTO() {
        return new BatchStockDTO(
                101,
                1L,
                2.5,
                1.0,
                100,
                95,
                LocalDate.now(),
                LocalDateTime.now(),
                LocalDate.now().plusMonths(2));
    }

    public static Product createProduct(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("Producto " + id);
        return product;
    }

    public static InboundOrder createTestInboundOrder() {
        InboundOrder order = new InboundOrder();
        order.setId(1L);
        order.setOrderNumber(1001);
        order.setOrderDate(LocalDate.now());
        return order;
    }

    public static Sector createSector(Long id) {
        Sector sector = new Sector();
        sector.setId(id);
        sector.setName("Sector " + id);
        sector.setWarehouse(createWarehouse(id));
        return sector;
    }

    public static WarehouseRep createTestRepresentative() {
        WarehouseRep rep = new WarehouseRep();
        rep.setId(1L);
        rep.setName("Test Rep");
        return rep;
    }

    public static Warehouse createWarehouse(Long id) {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(id);
        warehouse.setName("Warehouse " + id);
        warehouse.setWarehouseCode(101);
        return warehouse;
    }
    public static Warehouse createTestWarehouse() {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L);
        warehouse.setWarehouseCode(101);
        warehouse.setName("Test Warehouse");
        return warehouse;
  }

  public static Batch createBatch(
        Long id, int batchNumber, int initialQuantity, int actualQuantity,
        LocalDateTime manufacturingDatetime, LocalDate expireDate,
        BigDecimal registrationTemp, BigDecimal minimumTemp,
        Product product, Sector sector, InboundOrder inboundOrder) {
        return new Batch(
                id, batchNumber, initialQuantity, actualQuantity,
                manufacturingDatetime, expireDate, registrationTemp, minimumTemp,
                product, sector, inboundOrder
        );

    }

    public static Sector createTestSector() {
        Sector sector = new Sector();
        sector.setId(1L);
        sector.setSectorCode(1001);
        sector.setName("Test Sector");
        return sector;
  }

  public static List<Batch> createBatchesUnordered() {
        return Arrays.asList(
                createBatch(2L, 20, 100, 90, LocalDateTime.now(),
                        LocalDate.of(2024, 8, 1), BigDecimal.valueOf(6.0),
                        BigDecimal.valueOf(2.5), product, sector, null),
                createBatch(3L, 30, 100, 85, LocalDateTime.now(),
                        LocalDate.of(2024, 6, 22), BigDecimal.valueOf(7.0), BigDecimal.valueOf(3.0),
                        product, sector, null),
                createBatch(1L, 10, 100, 95, LocalDateTime.now(),
                        LocalDate.of(2024, 7, 15), BigDecimal.valueOf(5.0), BigDecimal.valueOf(2.0),
                        product, sector, null)
        );
    }
    
    public static Batch createTestBatch() {
        Batch batch = new Batch();
        batch.setId(1L);
        batch.setBatchNumber(101);
        batch.setInitialQuantity(100);
        batch.setActualQuantity(95);
        batch.setRegistrationTemp(BigDecimal.valueOf(2.0));
        batch.setMinimumTemp(BigDecimal.valueOf(1.0));
        batch.setManufacturingDatetime(LocalDateTime.now());
        batch.setExpireDate(LocalDate.now().plusMonths(2));
        batch.setProduct(createTestProduct());
        return batch;
  }

    static public List<Batch> getBatchesOrderedAsc() {
        List<Batch> batches = new ArrayList<>();

        ProductType productType = new ProductType(1L, "FF", "Congelado", new BigDecimal(5), new BigDecimal(10));
        Product product = new Product(1L, "Helado", "Helado torpedo de limon", new BigDecimal(1000), productType, null);

        batches.add(new Batch(1L, 1, 20, 15, LocalDateTime.now(), LocalDate.now().plusDays(7), new BigDecimal(0), new BigDecimal(0), product, null, null));
        batches.add(new Batch(2L, 2, 30, 30, LocalDateTime.now(), LocalDate.now().plusDays(14), new BigDecimal(5), new BigDecimal(12), product, null, null));
        batches.add(new Batch(3L, 3, 45, 20, LocalDateTime.now(), LocalDate.now().plusDays(17), new BigDecimal(10), new BigDecimal(12), product, null, null));

        return batches;
    }

    public static List<Batch> createBatchesOrderedByBatchNumber() {
        Product product = createProduct(1L);
        Sector sector = createSector(1L);

        return Arrays.asList(
                createBatch(1L, 10, 100, 95, LocalDateTime.now(),
                        LocalDate.of(2024, 7, 15), BigDecimal.valueOf(5.0),
                        BigDecimal.valueOf(2.0), product, sector, null),
                createBatch(2L, 20, 100, 90, LocalDateTime.now(),
                        LocalDate.of(2024, 8, 1), BigDecimal.valueOf(6.0),
                        BigDecimal.valueOf(2.5), product, sector, null),
                createBatch(3L, 30, 100, 85, LocalDateTime.now(),
                        LocalDate.of(2024, 6, 22), BigDecimal.valueOf(7.0),
                        BigDecimal.valueOf(3.0), product, sector, null)
        );
    }public static Product createTestProduct() {
    Product product = new Product();
    product.setId(1L);
    product.setName("Test Product");
    product.setDescription("Test Description");
        product.setPrice(BigDecimal.valueOf(100.00));
    return product;}

    public static List<Batch> createBatchesOrderedByActualQuantity() {
        Product product = createProduct(2L);
        Sector sector = createSector(2L);

        return Arrays.asList(
                createBatch(3L, 30, 100, 85, LocalDateTime.now(),
                        LocalDate.of(2024,6,22), BigDecimal.valueOf(7.0),
                        BigDecimal.valueOf(3.0), product, sector, null),
                createBatch(2L, 20, 100, 90, LocalDateTime.now(),
                        LocalDate.of(2024,8,1), BigDecimal.valueOf(6.0),
                        BigDecimal.valueOf(2.5), product, sector, null),
                createBatch(1L, 10, 100, 95, LocalDateTime.now(),
                        LocalDate.of(2024,7,15), BigDecimal.valueOf(5.0),
                        BigDecimal.valueOf(2.0), product, sector, null)
        );
    }

    static public List<Batch> getBatchesOrderedDesc() {
        List<Batch> batches = new ArrayList<>();

        ProductType productType = new ProductType(1L, "FF", "Congelado", new BigDecimal(5), new BigDecimal(10));
        Product product = new Product(1L, "Helado", "Helado torpedo de limon", new BigDecimal(1000), productType, null);
        batches.add(new Batch(3L, 3, 45, 20, LocalDateTime.now(), LocalDate.now().plusDays(17), new BigDecimal(10), new BigDecimal(12), product, null, null));
        batches.add(new Batch(2L, 2, 30, 30, LocalDateTime.now(), LocalDate.now().plusDays(14), new BigDecimal(5), new BigDecimal(12), product, null, null));
        batches.add(new Batch(1L, 1, 20, 15, LocalDateTime.now(), LocalDate.now().plusDays(7), new BigDecimal(0), new BigDecimal(0), product, null, null));

        return batches;
    }
  public static String createValidInboundOrderRequest() {
    return """
        {
            "inbound_order": {
                "order_number": 1001,
                "order_date": "28-10-2010",
                "section": {
                    "section_code": "1001",
                    "warehouse_code": "101"
                },
                "batch_stock": [
                    {
                        "batch_number": "101",
                        "product_id": 1,
                        "current_temperature": 10,
                        "minimum_temperature": 9,
                        "initial_quantity": 10,
                        "current_quantity": 10,
                        "manufacturing_date": "28-10-2010",
                        "manufacturing_time": "28-10-2010 12:01:00",
                        "due_date": "28-11-2010"
                    }
                ]
            }
        }
        """;
  }
  public static String responseCreateInvalidOrderRequestWithInboundOrBatchNumber() {
    return """
    {"batch_stock":[{"batch_number":101,"product_id":1,"current_temperature":10.0,"minimum_temperature":9.0,
    "initial_quantity":10,"current_quantity":10,"manufacturing_date":"28-10-2010","manufacturing_time":"28-10-2010 12:01:00","due_date":"28-11-2010"}]}""";}

    public static List<Batch> createBatchesOrderedByDueDate() {
        Product product = createProduct(3L);
        Sector sector = createSector(3L);

        return Arrays.asList(
                createBatch(3L, 30, 100, 85,
                        LocalDateTime.now(), LocalDate.of(2024,6,22), BigDecimal.valueOf(7.0),
                        BigDecimal.valueOf(3.0), product, sector, null),
                createBatch(1L, 10, 100, 95, LocalDateTime.now(),
                        LocalDate.of(2024,7,15), BigDecimal.valueOf(5.0),
                        BigDecimal.valueOf(2.0), product, sector, null),
                createBatch(2L, 20, 100, 90, LocalDateTime.now(),
                        LocalDate.of(2024,8,1), BigDecimal.valueOf(6.0),
                        BigDecimal.valueOf(2.5), product, sector, null)
        );
    }

    public static ProductBatchDTO productBatchUnordered(){
        List<Batch> batchList = createBatchesUnordered();
        return ProductBatchMapper.toProductBatchStockDTO(batchList, ID);
    }

    public static ProductBatchDTO productBatchOrderedByNumber() {
        List<Batch> batchList = createBatchesOrderedByBatchNumber();
        return ProductBatchMapper.toProductBatchStockDTO(batchList, ID);
  }

  public static String createInvalidOrderRequestWithInboundOrBatchNumber() {
    return """
        {
            "inbound_order": {
                "order_number": 1002,
                "order_date": "28-10-2010",
                "section": {
                    "section_code": "1001",
                    "warehouse_code": "101"
                },
                "batch_stock": [
                    {
                        "batch_number": "101",
                        "product_id": 1,
                        "current_temperature": 10,
                        "minimum_temperature": 9,
                        "initial_quantity": 10,
                        "current_quantity": 10,
                        "manufacturing_date": "28-10-2010",
                        "manufacturing_time": "28-10-2010 12:01:00",
                        "due_date": "28-11-2010"
                    }
                ]
            }
        }
        """;
  }

  public static String createInvalidOrderRequestWithNotSuitableType() {
    return """
                {
                    "inbound_order": {
                        "order_number": 1001,
                        "order_date": "28-10-2010",
                        "section": {
                            "section_code": "1001",
                            "warehouse_code": "101"
                        },
                        "batch_stock": [
                            {
                            "batch_number": "101",
                            "product_id": 3,
                            "current_temperature": 10,
                            "minimum_temperature": 9,
                            "initial_quantity": 10,
                            "current_quantity": 10,
                            "manufacturing_date": "28-10-2010",
                            "manufacturing_time": "28-10-2010 12:01:00",
                            "due_date": "28-11-2010"
                            },
                            {
                            "batch_number": "104",
                            "product_id": 2,
                            "current_temperature": 10,
                            "minimum_temperature": 5,
                            "initial_quantity": 90,
                            "current_quantity": 90,
                            "manufacturing_date": "28-10-2011",
                            "manufacturing_time": "28-10-2011 12:01:00",
                            "due_date": "28-11-2011"
                            }
                        ]

                    }

                }
                """;
  }
public static ProductBatchDTO productBatchOrderedByQuantity(){
        List<Batch> batchList = createBatchesOrderedByActualQuantity();
        return ProductBatchMapper.toProductBatchStockDTO(batchList, ID);
    }

    public static ProductBatchDTO productBatchOrderedByDueDate(){
        List<Batch> batchList = createBatchesOrderedByDueDate();
                return ProductBatchMapper.toProductBatchStockDTO(batchList, ID);
    }
  public static String createInvalidOrderRequestWithExceedsProducts() {
    return """
                {
                    "inbound_order": {
                        "order_number": 1001,
                        "order_date": "28-10-2010",
                        "section": {
                            "section_code": "1001",
                            "warehouse_code": "101"
                        },
                        "batch_stock": [
                            {
                            "batch_number": "101",
                            "product_id": 3,
                            "current_temperature": 10,
                            "minimum_temperature": 9,
                            "initial_quantity": 100,
                            "current_quantity": 100,
                            "manufacturing_date": "28-10-2010",
                            "manufacturing_time": "28-10-2010 12:01:00",
                            "due_date": "28-11-2010"
                            },
                            {
                            "batch_number": "104",
                            "product_id": 2,
                            "current_temperature": 10,
                            "minimum_temperature": 5,
                            "initial_quantity": 90,
                            "current_quantity": 90,
                            "manufacturing_date": "28-10-2011",
                            "manufacturing_time": "28-10-2011 12:01:00",
                            "due_date": "28-11-2011"
                            }
                        ]

                    }

                }
                """;
  }

    public static String createValidUpdateProduct() {
        return """
            {
                "product_name": "Yogurt",
                "product_description": "Un gran yogurt",
                "product_price": 2000
            }
            """;
    }

    public static String createValidAddProduct() {
        return """
    {
      "product_name": "Producto Nueva Integracion 3459",
      "product_description": "Unico en el universo",
      "product_price": 99.99,
      "product_type": {"id": 1},
      "product_seller": {"id": 1}
    }
    """;
    }

    public static String createInvalidAddProduct() {
        return """
    {
      "product_name": "Refrigerated Product",
      "product_description": "Unico en el universo",
      "product_price": 99.99,
      "product_type": {"id": 1},
      "product_seller": {"id": 1}
    }
    """;
    }
}
