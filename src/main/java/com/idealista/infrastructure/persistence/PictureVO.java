package com.idealista.infrastructure.persistence;

import com.idealista.application.model.Picture;

public class PictureVO extends Picture {

    public PictureVO(Integer id, String url, String quality) {
        setId(id);
        setUrl(url);
        setQuality(quality);
    }
}
