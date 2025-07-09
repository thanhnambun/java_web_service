package ra.edu.ss2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.edu.ss2.entity.Showtime;
import ra.edu.ss2.service.MovieService;
import ra.edu.ss2.service.ScreenRoomService;
import ra.edu.ss2.service.ShowtimeService;
import ra.edu.ss2.service.TheaterService;

@Controller
@RequestMapping("/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService ShowtimeService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ShowtimeService showtimeService;

    @Autowired
    private TheaterService theaterService;
    @Autowired
    private ScreenRoomService screenRoomService;

    @GetMapping
    public String showShowtimes(
            @RequestParam(required = false) Long movieId,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) Long cinemaId,
            @RequestParam(required = false) Long roomId,
            Model model) {

        String filteredDate = date;
        if (date != null && date.trim().isEmpty()) {
            filteredDate = null;
        }
        model.addAttribute("showtimes", showtimeService.filterShowtimes(movieId, filteredDate, cinemaId, roomId));

        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("cinemas", theaterService.findAll());
        model.addAttribute("rooms", screenRoomService.findAll());

        return "showtime/showtime-list";
    }
    @GetMapping("/add")
    public String showAddShowtime(Model model) {
        model.addAttribute("showtime", new Showtime());
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("screenRooms", showtimeService.findAll());
        return "/showtime/showtime-add";
    }

    @PostMapping("/add")
    public String addShowtime(@ModelAttribute("showtime") Showtime Showtime) {
        ShowtimeService.save(Showtime);
        return "redirect:/showtimes";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Showtime Showtime = ShowtimeService.findById(id);
        if (Showtime == null) {
            return "redirect:/showtimes";
        }
        model.addAttribute("movies", movieService.findAll());
        model.addAttribute("screenRooms", showtimeService.findAll());
        model.addAttribute("showtime", Showtime);
        return "/showtime/showtime-edit";
    }

    @PostMapping("/edit/{id}")
    public String editShowtime(@PathVariable("id") Long id, @ModelAttribute("showtime") Showtime updatedShowtime) {
        updatedShowtime.setId(id);
        ShowtimeService.update(updatedShowtime);
        return "redirect:/showtimes";
    }
    @PostMapping("/delete/{id}")
    public String deleteShowtime(@PathVariable("id") Long id) {
        ShowtimeService.delete(id);
        return "redirect:/showtimes";
    }
}