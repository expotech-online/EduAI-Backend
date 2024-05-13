package org.ahmedukamel.eduai.repository;

import org.ahmedukamel.eduai.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByNid(String nid);
}