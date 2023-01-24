package ru.yandex.practicum.filmorate.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Film;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class FilmController {

    private Long id = 1L;
    private final Map<Long, Film> films = new HashMap<>();

    @PostMapping("/films")
    public Film addFilm(@RequestBody @Valid Film film) {
        log.info("Добавляем фильм{}", film);
        film.setId(id);
        films.put(id, film);
        id++;
        return film;
    }

    @PutMapping("/films")
    public Film updateFilm(@RequestBody Film film) {
     //   Long id = film.getId();
        if (films.containsKey(film.getId())) {
            films.put(film.getId(), film);
            log.info("Обновляем фильм {}", film);
        }
     //   for (Map.Entry a : films.entrySet()) {
    //        if (a.getKey().equals(id)) {
    //            films.put(id, film);
    //        }
    //    }
        return film;
    }

    @GetMapping("/films")
    public List<Film> getAllFilm() {
        log.debug("Текущее колличество фильмов {}", films.size());
        return new ArrayList<>(films.values());
    }
}
