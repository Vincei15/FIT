package com.example.demo;

import jakarta.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceID;
    private String details;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt = new Date();

    @ManyToMany(mappedBy = "subscriptions")
    @JsonIgnore
    private Set<User> subscribers = new HashSet<>();


    public ServiceEntity() {}

    public Long getServiceID() { return serviceID; }
    public void setServiceID(Long serviceID) { this.serviceID = serviceID; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public Set<User> getSubscribers() { return subscribers; }
    public void setSubscribers(Set<User> subscribers) { this.subscribers = subscribers; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}
