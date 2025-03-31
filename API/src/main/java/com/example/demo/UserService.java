package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Date;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ServiceRepository serviceRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        if (user != null) {
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setGender(userDetails.getGender());
            user.setHeight(userDetails.getHeight());
            user.setWeight(userDetails.getWeight());
            user.setUpdatedAt(new Date());
            return userRepository.save(user);
        }
        return null;
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User subscribeToService(Long userId, Long serviceId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        ServiceEntity service = serviceRepository.findById(serviceId).orElseThrow(() -> new RuntimeException("Service not found"));

        user.getSubscriptions().add(service);
        return userRepository.save(user);
    }
}
