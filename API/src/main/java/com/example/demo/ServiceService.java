package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    public ServiceEntity getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public ServiceEntity saveService(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    public ServiceEntity updateService(Long id, ServiceEntity serviceDetails) {
        ServiceEntity service = getServiceById(id);
        if (service != null) {
            service.setDetails(serviceDetails.getDetails());
            service.setUpdatedAt(new Date());
            return serviceRepository.save(service);
        }
        return null;
    }
}
