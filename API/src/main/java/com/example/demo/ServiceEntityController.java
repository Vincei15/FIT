package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/services")
public class ServiceEntityController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public List<ServiceEntity> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public ServiceEntity getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id);
    }

    @PostMapping
    public ServiceEntity createService(@RequestBody ServiceEntity service) {
        return serviceService.saveService(service);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
    }

    @PutMapping("/{id}")
    public ServiceEntity updateService(@PathVariable Long id, @RequestBody ServiceEntity service) {
        return serviceService.updateService(id, service);
    }
}
