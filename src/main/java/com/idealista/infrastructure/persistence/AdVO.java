package com.idealista.infrastructure.persistence;

import com.idealista.application.model.Picture;
import com.idealista.application.model.ad.FullAd;

import java.util.Date;
import java.util.List;

public class AdVO extends FullAd {

    public AdVO(Integer id, String typology, String description, List<Picture> pictures, //
                Integer houseSize, Integer gardenSize, Integer score, Date irrelevantSince) {
        setId(id);
        setTypology(typology);
        setDescription(description);
        setPictures(pictures);
        setHouseSize(houseSize);
        setGardenSize(gardenSize);
        setScore(score);
        setIrrelevantSince(irrelevantSince);
    }
}
