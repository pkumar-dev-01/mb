package com.mb.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mb.user.entity.ContactInfoEntity;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfoEntity, String> {
    // Define custom query methods if needed
}
