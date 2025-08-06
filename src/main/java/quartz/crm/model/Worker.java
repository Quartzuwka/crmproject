package quartz.crm.model;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "worker_db")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private int age;
    private String email;
    private boolean isEmployed;
    private String status;
    private String company;
}
