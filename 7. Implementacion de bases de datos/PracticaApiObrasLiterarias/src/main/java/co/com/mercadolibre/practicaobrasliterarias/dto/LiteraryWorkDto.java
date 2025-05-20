package co.com.mercadolibre.practicaobrasliterarias.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LiteraryWorkDto {
    private String id;
    private String title;
    private String author;
    private int pageCount;
    private String publisher;
    private int firstPublicationYear;
}
