package com.mb.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.user.entity.SpsUserRolesEntity;

@Repository
public interface SpsUserRolesRepository extends JpaRepository<SpsUserRolesEntity, Long> {
    // Define custom query methods if needed
}