package com.meli.blog.dto;

import java.util.List;

import com.meli.blog.model.PostModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPostResponseDTO {
    private String id;
    private String title;
    private String authorName;
    private String publicationDate;

    public static GetPostResponseDTO mapPostModelToDTO(PostModel post) {
        return new GetPostResponseDTO(
                post.getId(),
                post.getTitle(),
                post.getAuthorName(),
                post.getPublicationDate());
    }

    public static List<GetPostResponseDTO> mapPostModelListToDTO(List<PostModel> posts) {
        return posts.stream()
                .map(GetPostResponseDTO::mapPostModelToDTO)
                .toList();
    }
}
