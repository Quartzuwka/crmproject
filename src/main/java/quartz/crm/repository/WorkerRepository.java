package quartz.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quartz.crm.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    void deleteByEmail(String email);

}