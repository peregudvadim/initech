package by.peregud.initech.llc.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "clients")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity extends BaseEntity {


    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "industry")
    private String industry;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
