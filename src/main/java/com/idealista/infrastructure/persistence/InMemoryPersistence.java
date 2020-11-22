package com.idealista.infrastructure.persistence;

import com.idealista.application.model.Picture;
import com.idealista.application.model.ad.FullAd;
import com.idealista.application.model.ad.RelevantAd;
import com.idealista.application.utils.Cast;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryPersistence {

    private final List<FullAd> ads;
    private final List<Picture> pictures;

    public InMemoryPersistence() {
        ads = new ArrayList<>();
        pictures = new ArrayList<>();

        initAds();
        initPictures();
        initFillPictures();
    }

    public List<FullAd> getAllAds() {
        return ads;
    }

    public List<RelevantAd> getRelevantAds() {
        return ads.stream().filter(ad -> ad.getScore() > 40)
                .sorted(Comparator.comparing(FullAd::getScore))
                .map(Cast::toRelevantAd)
                .collect(Collectors.toList());
    }

    /*________Private init methods_________*/
    private void initAds() {
        ads.add(new AdVO(1, "CHALET", "Este piso es una ganga, compra, compra, COMPRA!!!!!", Collections.emptyList(), 300, 0, 0, new Date()));
        ads.add(new AdVO(2, "FLAT", "Nuevo ático céntrico recién reformado. No deje pasar la oportunidad y adquiera este ático de lujo", Collections.emptyList(), 300, 0, 0, new Date()));
        ads.add(new AdVO(3, "CHALET", "", Collections.emptyList(), 300, 0, 0, new Date()));
        ads.add(new AdVO(4, "FLAT", "Ático céntrico muy luminoso y recién reformado, parece nuevo", Collections.emptyList(), 300, 0, 0, new Date()));
        ads.add(new AdVO(5, "FLAT", "Pisazo,", Collections.emptyList(), 300, 0, 0, new Date()));
        ads.add(new AdVO(6, "GARAGE", "", Collections.emptyList(), 300, 0, 0, new Date()));
        ads.add(new AdVO(7, "GARAGE", "Garaje en el centro de Albacete", Collections.emptyList(), 300, 0, 0, new Date()));
        ads.add(new AdVO(8, "CHALET", "Maravilloso chalet situado en lAs afueras de un pequeño pueblo rural. El entorno es espectacular, las vistas magníficas. ¡Cómprelo ahora!", Collections.emptyList(), 300, 0, 0, new Date()));
    }

    private void initPictures() {

        pictures.add(new PictureVO(1, "http://www.idealista.com/pictures/1", "SD"));
        pictures.add(new PictureVO(2, "http://www.idealista.com/pictures/2", "HD"));
        pictures.add(new PictureVO(3, "http://www.idealista.com/pictures/3", "SD"));
        pictures.add(new PictureVO(4, "http://www.idealista.com/pictures/4", "HD"));
        pictures.add(new PictureVO(5, "http://www.idealista.com/pictures/5", "SD"));
        pictures.add(new PictureVO(6, "http://www.idealista.com/pictures/6", "SD"));
        pictures.add(new PictureVO(7, "http://www.idealista.com/pictures/7", "SD"));
        pictures.add(new PictureVO(8, "http://www.idealista.com/pictures/8", "HD"));
    }

    private void initFillPictures() {
        ads.forEach(ad -> {
            int numPics = (int) (Math.random() * (3)) + 1;
            List<Picture> pics = new ArrayList<>();

            for (int i = 0; i <= numPics; i++) {
                int pic = (int) (Math.random() * (8));
                pics.add(pictures.get(pic));
            }

            ad.setPictures(pics);
        });
    }
}
