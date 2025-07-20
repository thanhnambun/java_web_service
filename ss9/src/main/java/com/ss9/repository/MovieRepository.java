package com.ss9.repository;


import com.ss9.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE m.title LIKE %:searchMovie%")
    List<Movie> findByTitleContaining(@Param("searchMovie") String searchMovie);
}