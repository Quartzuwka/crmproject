package quartz.crm.service.Impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import quartz.crm.model.Worker;
import quartz.crm.repository.WorkerRepository;
import quartz.crm.service.WorkerService;

import java.beans.Transient;
import java.util.List;

@Service
@AllArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private WorkerRepository repository;

    @Override
    public List<Worker> findAllWorkers() {
        return repository.findAll();
    }

    @Override
    public Worker saveWorker(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public Worker updateWorker(Worker worker) {
        return repository.save(worker);
    }

    @Override
    @Transactional
    public void deleteWorker(String email) {
        repository.deleteByEmail(email);
    }

    @Override
    public List<Worker> findAll() {
        return repository.findAll();
    }

    @Override
    public Worker save(Worker worker) {
        return repository.save(worker);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    // ПРАВИЛЬНО ✅
    @Override
    public Worker update(Long id, Worker workerDetails) {
        // 1. Находим существующего работника в базе данных
        Worker existingWorker = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Работник с id " + id + " не найден"));

        // 2. Обновляем у него ТОЛЬКО те поля, которые пришли в workerDetails
        existingWorker.setFirst_name(workerDetails.getFirst_name());
        existingWorker.setLast_name(workerDetails.getLast_name());
        existingWorker.setEmail(workerDetails.getEmail());
        existingWorker.setCompany(workerDetails.getCompany());

        // Поля age, isEmployed, status мы не трогаем, они остаются прежними

        // 3. Сохраняем обновленного работника
        return repository.save(existingWorker);
    }
}
