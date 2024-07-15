package com.mb.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mb.user.dto.RegistrationRequestDTO;
import com.mb.user.entity.ContactInfoEntity;
import com.mb.user.entity.SpsUserRolesEntity;
import com.mb.user.entity.UserEntity;
import com.mb.user.repository.ContactInfoRepository;
import com.mb.user.repository.SpsUserRolesRepository;
import com.mb.user.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    @Autowired
    private SpsUserRolesRepository userRolesRepository;

    @Transactional
    public void registerUser(RegistrationRequestDTO request) {
        // Create User Entity
        UserEntity userEntity = new UserEntity();
        
        userEntity.setPassword(request.getPassword());
        userEntity.setEmail(request.getEmail());
        userEntity.setFirstName(request.getFirstName());
        userEntity.setLastName(request.getLastName());

        // Save User Entity
        userRepository.save(userEntity);

        // Create Contact Info Entity
        ContactInfoEntity contactInfoEntity = new ContactInfoEntity();
        contactInfoEntity.setUserId(userEntity.getId());
        contactInfoEntity.setPhoneNumber(request.getPhoneNumber());

        // Save Contact Info Entity
        contactInfoRepository.save(contactInfoEntity);

        // Create User Roles Entities (assuming roles are provided in request)
       
            SpsUserRolesEntity userRolesEntity = new SpsUserRolesEntity();
            userRolesEntity.setUserId(userEntity.getId());
            userRolesEntity.setRoleId(userRolesEntity.getRoleId());
            userRolesRepository.save(userRolesEntity);
    }

    @Transactional(readOnly = true)
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public UserEntity getUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
    }

    @Transactional
    public void updateUser(UserEntity user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    // Additional methods for user management can be added here

}
