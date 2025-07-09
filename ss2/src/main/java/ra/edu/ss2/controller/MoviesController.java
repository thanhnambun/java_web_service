package ra.edu.ss2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.ss2.entity.Movie;
import ra.edu.ss2.repository.MovieRepository;

import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/home")
    public String showAllMovies(Model model, @ModelAttribute("message") String message) {
        if (movieRepository.findAll().isEmpty()) {
            model.addAttribute("error", "No movies found");
        }
        model.addAttribute("movies", movieRepository.findAll());
        model.addAttribute("message", message);
        return "movies/home";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movies/movie-add";
    }

    @PostMapping("/add")
    public String addMovie(Movie movie, RedirectAttributes redirectAttributes) {
        movieRepository.save(movie);
        redirectAttributes.addFlashAttribute("message", "Movie added successfully");
        return "redirect:/movies/home";
    }

    @GetMapping("/edit")
    public String showEditForm(@RequestParam("movieId") Long movieId, Model model, RedirectAttributes redirectAttributes) {
        Optional<Movie> movie = movieRepository.findById(movieId);
        if (movie.isPresent()) {
            model.addAttribute("movie", movie.get());
            return "movies/movie-edit"; // ✅ Đã sửa
        } else {
            redirectAttributes.addFlashAttribute("error", "Movie not found");
            return "redirect:/movies";
        }
    }

    @PostMapping("/edit")
    public String editMovie(Movie movie, RedirectAttributes redirectAttributes) {
        movieRepository.save(movie);
        redirectAttributes.addFlashAttribute("message", "Movie updated successfully");
        return "redirect:/movies/home";
    }

    @GetMapping("/delete")
    public String deleteMovie(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        movieRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Movie deleted successfully");
        return "redirect:/movies/home";
    }
}
