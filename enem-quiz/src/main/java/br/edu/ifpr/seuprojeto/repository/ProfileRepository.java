package br.edu.ifpr.seuprojeto.repository;

import br.edu.ifpr.seuprojeto.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
