package quartz.crm.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quartz.crm.model.Worker;
import quartz.crm.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workers")
@AllArgsConstructor
public class WorkerController {
    private WorkerService workerService;

    @GetMapping
    public List<Worker> getAll() {
        return workerService.findAll();
    }

    @PostMapping
    public Worker create(@RequestBody Worker worker) {
        return workerService.save(worker);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        workerService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Worker workerDetails) {
        workerService.update(id, workerDetails);
    }

}

//    @GetMapping
//    public List<Worker> findAllWorker() {
//
//        return workerService.findAllWorkers();
//    }
//
//    @PostMapping("save_worker")
//    public String saveStudent(@RequestBody Worker worker) {
//        workerService.saveWorker(worker);
//        return "Student successfully saved";
//    }
//
//    @PutMapping("update_worker")
//    public Worker updateWorker(@RequestBody Worker worker) {
//        return workerService.updateWorker(worker);
//    }
//
//    @DeleteMapping("delete_worker/{email}")
//    public void deleteWorker(@PathVariable String email) {
//        workerService.deleteWorker(email);
//    }