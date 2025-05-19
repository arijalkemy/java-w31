package com.mercadolibre.be_java_hisp_w31_g02.controller;

import com.mercadolibre.be_java_hisp_w31_g02.dto.FollowedPublicationDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.ProductCountDto;
import com.mercadolibre.be_java_hisp_w31_g02.dto.PublicationDto;
import com.mercadolibre.be_java_hisp_w31_g02.service.IPublicationService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Validated
public class PublicationController {
    @Autowired
    private IPublicationService publicationService ;

    @GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<List<FollowedPublicationDto>> getPublicationsFollowedByAnUser(
            @PathVariable("userId") Integer userId,
            @RequestParam(name = "order", required = false, defaultValue="date_desc") String order){
        return new ResponseEntity<>(publicationService.getPublicationsFollowedByAnUser(userId, order), HttpStatus.OK);
    }
    
    @PostMapping("/products/post")
    public ResponseEntity<?> createPublication(
        @Valid @RequestBody PublicationDto publicationDto,
        BindingResult bindingResult
    ) {
        return new ResponseEntity<>(publicationService.createPublicationOrThrow(publicationDto),
                HttpStatus.CREATED);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<?> createPublicationWithPromo(@Valid @RequestBody PublicationDto publicationDto, BindingResult bindingResult) {
        return new ResponseEntity<>(publicationService.createPublicationOrThrow(publicationDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<ProductCountDto> getCountProduct(@RequestParam("user_id") Integer userId) {
        ProductCountDto result = publicationService.countProduct(userId);
        return ResponseEntity.ok(result);
    }

}
