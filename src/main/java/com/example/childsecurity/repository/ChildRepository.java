package com.example.childsecurity.repository;

import com.example.childsecurity.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildRepository extends JpaRepository<Child, Long> {
    List<Child> findByParentId(Long parentId);
}
