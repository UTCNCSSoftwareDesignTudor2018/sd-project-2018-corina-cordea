package sd.project.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sd.project.data.entity.Client;

public interface ClientJpaRepository extends JpaRepository<Client,Integer>{

}
