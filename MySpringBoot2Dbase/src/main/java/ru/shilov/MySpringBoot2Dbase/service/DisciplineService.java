package ru.shilov.MySpringBoot2Dbase.service;

import org.springframework.stereotype.Service;
import ru.shilov.MySpringBoot2Dbase.entity.Discipline;
import ru.shilov.MySpringBoot2Dbase.entity.Student;

import java.util.List;

@Service
public interface DisciplineService {
    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);
}
