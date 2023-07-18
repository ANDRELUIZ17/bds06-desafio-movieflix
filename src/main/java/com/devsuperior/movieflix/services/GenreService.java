package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class GenreService {

    private final GenreRepository genreRepository;

    @Transactional(readOnly = true)
    @PreAuthorize("hasAnyRole('MEMBER', 'VISITOR')")
    public List<GenreDTO> findAll() {
        List<Genre>list = genreRepository.findAll();
        return list.stream().map(GenreDTO::new).toList();
    }
    public GenreDTO findyById(Long id) {
        Optional<Genre>categoryObj = genreRepository.findById(id);
        Genre client = categoryObj.orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        return new GenreDTO(client);
    }
}
