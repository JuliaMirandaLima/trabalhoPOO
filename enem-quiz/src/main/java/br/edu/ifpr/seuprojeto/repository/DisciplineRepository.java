package br.edu.ifpr.seuprojeto.repository;

import br.edu.ifpr.seuprojeto.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
}
