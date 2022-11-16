

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    private FilmRepo filmRepo;
    @Autowired
    public Controller(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }
    @RequestMapping("/dodaj")
    public String dodajemyDane(
            @RequestParam("tytul") String tytul,
            @RequestParam("gatunek") String gatunek,
            @RequestParam("rezyser") String rezyser,
            @RequestParam("scenarzysta") String scenarzysta,
            @RequestParam("opis") String opis, Model model)
            throws Exception {
        Film film = new Film(tytul, gatunek, rezyser, scenarzysta, opis, true);
        System.out.println(film);
        filmRepo.save(film);
        model.addAttribute("film", film);
        return "Widok";
    }

    @RequestMapping("/")
    public String dodaj( Model model) {
      return "dodaj";
        }

    @RequestMapping("/pokaz")
    public String pokaz( Model model){
        for (Film film : filmRepo.findAll()) {
            System.out.println(film);
        }

        model.addAttribute("film", filmRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/kasuj")
    public String kasuj(@RequestParam("id") Integer id, Model model){
        filmRepo.deleteById(id);

        model.addAttribute("film", filmRepo.findAll());
        return "pokaz";
    }

    @RequestMapping("/wyszukaj")
    public String wyszukaj(@RequestParam("kryterium") String kryterium, Model model){
        model.addAttribute("film", filmRepo.findAllBygatunek(kryterium));
        return "pokaz";
    }

    @RequestMapping("/aktualizuj")
    public String update(
            @RequestParam("id") Integer id,
            @RequestParam("tytul") String tytul,
            @RequestParam("gatunek") String gatunek,
            @RequestParam("rezyser") String rezyser,
            @RequestParam("scenarzysta") String scenarzysta,
            @RequestParam("opis") String opis, Model model)
            throws Exception {
        Film film = new Film(id, tytul, gatunek, rezyser, scenarzysta, opis, true);
        System.out.println(film);
        filmRepo.save(film);
        model.addAttribute("film", film);
        return "Widok";
    }

    @RequestMapping("/przekieruj")
    public String przekieruj(@RequestParam("id") Integer id, Model model)
            throws Exception {
        System.out.println(filmRepo.findById(id));
        model.addAttribute("film", filmRepo.findById(id));
        return "aktualizuj";
    }

}
