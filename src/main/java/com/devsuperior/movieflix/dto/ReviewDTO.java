package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Preencha o campo para enviar a sua avaliação")
    private String text;

    private UserDTO user;

    private Long movieId;

    public ReviewDTO (Review review) {
        id = review.getId();
        text = review.getText();
        movieId = review.getMovie().getId();
        user = new UserDTO(review.getUser());
    }

    public ReviewDTO(Review review, User user) {
        id = review.getId();
        text = review.getText();
        this.user = new UserDTO(user);
    }

}
