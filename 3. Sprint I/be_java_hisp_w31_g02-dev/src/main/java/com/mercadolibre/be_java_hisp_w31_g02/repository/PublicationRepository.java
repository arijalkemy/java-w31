package com.mercadolibre.be_java_hisp_w31_g02.repository;

import com.mercadolibre.be_java_hisp_w31_g02.dto.ProductCountDto;
import com.mercadolibre.be_java_hisp_w31_g02.entity.Promotion;
import com.mercadolibre.be_java_hisp_w31_g02.entity.Publication;
import com.mercadolibre.be_java_hisp_w31_g02.entity.User;
import com.mercadolibre.be_java_hisp_w31_g02.exception.NotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class PublicationRepository implements IPublicationRepository {
    private List<Publication> publications;
    private final AtomicInteger idGenerator = new AtomicInteger(1);
    private final IUserRepository UserRepository;
    private final ObjectMapper mapper;


    private void loadData(String jsonPath) throws IOException {
        File file;
        file= ResourceUtils.getFile("classpath:"+jsonPath);
        this.publications = mapper.readValue(file,new TypeReference<List<Publication>>(){});

    }

    public PublicationRepository(List<Publication> publications, IUserRepository userRepository, ObjectMapper mapper) throws IOException {
        this.publications = publications;
        UserRepository = userRepository;
        this.mapper = mapper;
        loadData("publications.json");
    }

    public void save(Publication publication) {
        publication.setPostId(idGenerator.getAndIncrement());
        publications.add(publication);
    }

    public List<Publication> findAll() {
        return new ArrayList<>(publications);
    }

    public Publication findById(int postId) {
        return publications.stream()
                .filter(pub -> pub.getPostId().equals(postId))
                .findFirst()
                .orElse(null);
    }

    public ProductCountDto countProduct(Integer userId) {
        // Find the user
        Optional<User> optionalUser = UserRepository.findUserById(userId);
        if (!optionalUser.isPresent()) {
            throw new NotFoundException("User Id not found");
        }
        User user = optionalUser.get();

        // Find the publication IDs of the user
        List<Integer> publicationIds = user.getPublications();

        // Get the publications from those IDs
        List<Publication> userPublications = this.publications.stream()
            .filter(p -> publicationIds.contains(p.getPostId()))
            .collect(Collectors.toList());

        // Filter publications with promotion
        long promoCount = userPublications.stream()
            .filter(pub -> pub.getPromotionList().stream()
            .anyMatch(promo -> promo.hasCurrentPromo(LocalDate.now())))
            .count();

        return new ProductCountDto(user.getUserId(), user.getUserName(), (int) promoCount);
    }

    public void addPromotion(Promotion promotion, Integer publicationId) {
        findById(publicationId).getPromotionList().add(promotion);
    }
}
