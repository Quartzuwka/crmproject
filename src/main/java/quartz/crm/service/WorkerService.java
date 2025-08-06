package quartz.crm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import quartz.crm.model.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> findAllWorkers();
    Worker saveWorker(Worker worker);
    Worker updateWorker(Worker worker);
    void deleteWorker(String email);
    List<Worker> findAll();
    Worker save(Worker worker);
    void deleteById(Long id);
    Worker update(Long id, Worker workerDetails);

}
