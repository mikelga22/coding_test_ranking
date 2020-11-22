package com.idealista.application.service;

import com.idealista.application.model.ad.FullAd;
import com.idealista.application.model.ad.RelevantAd;
import com.idealista.application.utils.Score;
import com.idealista.infrastructure.persistence.InMemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdService {

    @Autowired
    private final InMemoryPersistence repository;

    public AdService(InMemoryPersistence repository) {
        this.repository = repository;
    }

    public List<FullAd> getAll() {
        return repository.getAllAds();
    }

    public List<RelevantAd> getRelevant() {
        return repository.getRelevantAds();
    }

    public List<FullAd> calculateScore() {
        repository.getAllAds().forEach(ad -> {
            int score = Score.calculateScore(ad);

            if (ad.getScore() >= 40 && score < 40) {
                ad.setIrrelevantSince(new Date());
            } else if (score > 40) ad.setIrrelevantSince(null);

            ad.setScore(score);
        });

        return repository.getAllAds();
    }
}
