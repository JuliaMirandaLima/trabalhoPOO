package br.edu.ifpr.seuprojeto.repository;

import br.edu.ifpr.seuprojeto.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
