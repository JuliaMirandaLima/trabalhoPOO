package br.edu.ifpr.seuprojeto.repository;

import br.edu.ifpr.seuprojeto.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
