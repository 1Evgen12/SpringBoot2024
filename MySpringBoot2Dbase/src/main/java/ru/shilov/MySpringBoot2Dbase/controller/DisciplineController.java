package ru.shilov.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shilov.MySpringBoot2Dbase.entity.Discipline;
import ru.shilov.MySpringBoot2Dbase.service.DisciplineService;

import java.util.List;
@RestController
@RequestMapping("/api")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/disciplines")
    public List<Discipline> allDisciplines(){
        List<Discipline> allDisciplines = disciplineService.getAllDisciplines();
        return allDisciplines;
    }

    @GetMapping("/disciplines/{id}")
    public Discipline getDiscipline(@PathVariable("id")int id){
        return disciplineService.getDiscipline(id);
    }

    @PostMapping("/disciplines")
    public Discipline saveDiscipline(@RequestBody Discipline discipline){
        return disciplineService.saveDiscipline(discipline);
    }

    @PutMapping("/disciplines")
    public Discipline updateDiscipline(@RequestBody Discipline discipline){
        disciplineService.saveDiscipline(discipline);
        return discipline;
    }
    @DeleteMapping("/disciplines/{id}")
    public void deleteDiscipline(@PathVariable ("id")int id){
        disciplineService.deleteDiscipline(id);
    }
}

