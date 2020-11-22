package com.idealista.application.service;

import com.idealista.infrastructure.persistence.InMemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;

public class PictureService {

    @Autowired
    private final InMemoryPersistence repository;

    public PictureService(InMemoryPersistence repository) {
        this.repository = repository;
    }
}
