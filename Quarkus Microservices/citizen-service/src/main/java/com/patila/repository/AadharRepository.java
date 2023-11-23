package com.patila.repository;

import com.patila.entity.Aadhar;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AadharRepository implements PanacheRepository<Aadhar> {
}
