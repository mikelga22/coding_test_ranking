package com.idealista.application.utils;

import com.idealista.application.model.ad.Ad;
import com.idealista.application.model.ad.RelevantAd;

public class Cast {

    public static RelevantAd toRelevantAd(Ad ad) {
        RelevantAd relevant = new RelevantAd();

        relevant.setId(ad.getId());
        relevant.setPictures(ad.getPictures());
        relevant.setTypology(ad.getTypology());
        relevant.setHouseSize(ad.getHouseSize());
        relevant.setGardenSize(ad.getGardenSize());
        relevant.setDescription(ad.getDescription());

        return relevant;
    }
}
