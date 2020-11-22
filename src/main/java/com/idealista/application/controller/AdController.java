package com.idealista.application.controller;

import com.idealista.application.model.ad.FullAd;
import com.idealista.application.model.ad.RelevantAd;
import com.idealista.application.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdController {

    @Autowired
    private final AdService service;

    public AdController(AdService service) {
        this.service = service;
    }

    @GetMapping("/ads")
    public ResponseEntity<List<RelevantAd>> relevantAds() {
        return ResponseEntity.ok(service.getRelevant());
    }

    @GetMapping("/admin/ads")
    public ResponseEntity<List<FullAd>> allAds() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/admin/ads/score")
    public ResponseEntity<List<FullAd>> calculateScore() {
        return ResponseEntity.ok(service.calculateScore());
    }
}
