package org.ahmedukamel.eduai.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "STUDENTS")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(value = TemporalType.DATE)
    @Column(nullable = false, updatable = false)
    private LocalDate birthDate;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false)
    private User user;
}