package br.edu.ifpr.seuprojeto;

import br.edu.ifpr.seuprojeto.model.*;
import br.edu.ifpr.seuprojeto.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(CourseRepository courseRepo,
                                    DisciplineRepository discRepo,
                                    StudentRepository studentRepo,
                                    TeacherRepository teacherRepo,
                                    ProfileRepository profileRepo) {
        return args -> {
            Course course = new Course();
            course.setName("Engenharia de Software");

            Discipline d1 = new Discipline();
            d1.setName("Programação");
            d1.setCourse(course);

            Discipline d2 = new Discipline();
            d2.setName("Banco de Dados");
            d2.setCourse(course);

            course.setDisciplines(List.of(d1, d2));

            courseRepo.save(course);

            Student s = new Student();
            s.setName("Aluno Exemplo");
            s.setRegistration("2026001");

            Profile p = new Profile();
            p.setBio("Perfil do aluno exemplo");
            profileRepo.save(p);

            s.setProfile(p);
            s.getCourses().add(course);
            studentRepo.save(s);

            Teacher t = new Teacher();
            t.setName("Professor Exemplo");
            t.setSpecialty("Sistemas");
            teacherRepo.save(t);
        };
    }
}
