package com.litereaction.pawspassport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.litereaction.pawspassport.types.Status;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String name;

    private String displayName;

    private Status status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Tenant tenant;

    public Owner() {
    }

    public Owner(String name, String email, Tenant tenant) {
        this.name = name;
        this.email = email;
        this.tenant = tenant;
        this.status = Status.ACTIVE;
    }

    public String getDisplayName() {
        return StringUtils.isEmpty(displayName) ? name : displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tenant getTenant() { return tenant; }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }
}
