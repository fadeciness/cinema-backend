package ru.rosbank.javaschool.cinema.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rosbank.javaschool.cinema.dto.FilmDto;
import ru.rosbank.javaschool.cinema.dto.FilmSaveRequestDto;
import ru.rosbank.javaschool.cinema.entity.FilmEntity;
import ru.rosbank.javaschool.cinema.enumeration.Name;
import ru.rosbank.javaschool.cinema.exception.FilmNotFoundException;
import ru.rosbank.javaschool.cinema.repository.FilmRepository;

import javax.transaction.Transactional;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository repository;
    private final Path path = Paths.get(String.valueOf(Name.UPLOAD_PATH));

//    @PostConstruct
//    public void init() throws IOException {
//        if (Files.notExists(path)) {
//            Files.createDirectories(path);
//        }
//        String picName = Names.GARFIELD_IMAGE;
//        byte[] picBytes = this.getClass().getClassLoader().getResourceAsStream(picName).readAllBytes();
//        String out = Names.UPLOAD_PATH + "/" + picName;
//        try (FileOutputStream fos = new FileOutputStream(out)) {
//            fos.write(picBytes);
//        }
//        String movName = Names.GARFIELD_VIDEO;
//        byte[] movBytes = this.getClass().getClassLoader().getResourceAsStream(movName).readAllBytes();
//        out = Names.UPLOAD_PATH + "/" + movName;
//        try (FileOutputStream fos = new FileOutputStream(out)) {
//            fos.write(movBytes);
//        }
//
//        FilmEntity first = new FilmEntity(
//                0,
//                "Гарфилд",
//                "Хозяин кота Гарфилда, Джон, приносит в дом милого щенка Оди, и с этого момента жизнь Гарфилда идёт наперекосяк...",
//                picName,
//                movName,
//                List.of(Genre.FAMILY, Genre.COMEDY, Genre.CARTOON),
//                null
//        );
//        repository.save(first);
//
//        picName = Names.INCEPTION_IMAGE;
//        picBytes = this.getClass().getClassLoader().getResourceAsStream(picName).readAllBytes();
//        out = Names.UPLOAD_PATH + "/" + picName;
//        try (FileOutputStream fos = new FileOutputStream(out)) {
//            fos.write(picBytes);
//        }
//
//        FilmEntity second = new FilmEntity(
//                0,
//                "Начало",
//                "Кобб — талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим...",
//                picName,
//                null,
//                List.of(Genre.ACTION, Genre.DRAMA),
//                null
//        );
//        repository.save(second);
//    }

    public List<FilmDto> getAll() {
        return repository.findAll().stream()
                .map(FilmDto::from)
                .collect(Collectors.toList());
    }

    public FilmDto save(FilmSaveRequestDto dto) {
        return FilmDto.from(repository.save(FilmEntity.from(dto)));
    }

    public void removeById(int id) {
        repository.deleteById(id);
    }

    public FilmDto getById(int id) {
        return FilmDto.from(repository.findById(id).orElseThrow(FilmNotFoundException::new));
    }
}
