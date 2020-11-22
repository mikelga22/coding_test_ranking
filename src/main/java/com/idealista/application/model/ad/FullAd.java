package com.idealista.application.model.ad;

import java.util.Date;

public class FullAd extends Ad {
    private Integer score;
    private Date irrelevantSince;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getIrrelevantSince() {
        return irrelevantSince;
    }

    public void setIrrelevantSince(Date irrelevantSince) {
        this.irrelevantSince = irrelevantSince;
    }
}
