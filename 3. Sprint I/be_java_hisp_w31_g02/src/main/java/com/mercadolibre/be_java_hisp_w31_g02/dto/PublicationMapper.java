package com.mercadolibre.be_java_hisp_w31_g02.dto;

import com.mercadolibre.be_java_hisp_w31_g02.entity.Product;
import com.mercadolibre.be_java_hisp_w31_g02.entity.Publication;
import com.mercadolibre.be_java_hisp_w31_g02.utils.FormatUtils;


public final class PublicationMapper {


    public static Publication toEntity(PublicationDto publicationDto) {
        if (publicationDto == null) {
            return null;
        }
        Publication publication = new Publication();
        publication.setPostId(null); //postId is automatically generated when saved to the repository
        publication.setPublishDate(FormatUtils.StringDateToLocalDateOrThrow(publicationDto.getDate()));
        publication.setCategory(publicationDto.getCategory());
        publication.setPrice(publicationDto.getPrice());

        if (publicationDto.getProduct() != null) {
            publication.setProduct(ProductMapper.toEntity(publicationDto.getProduct()));
        }

        return publication;
    }

    public static ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }
        ProductDto productDto = new ProductDto();
        productDto.setProduct_id(product.getProductId());
        productDto.setProduct_name(product.getProductName());
        productDto.setType(product.getType());
        productDto.setBrand(product.getBrand());
        productDto.setColor(product.getColor());
        productDto.setNotes(product.getNotes());
        return productDto;
    }

}
