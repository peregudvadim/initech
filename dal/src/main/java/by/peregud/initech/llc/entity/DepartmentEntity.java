package by.peregud.initech.llc.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "departments")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager_id", nullable = false)
    private EmployeeEntity manager;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

