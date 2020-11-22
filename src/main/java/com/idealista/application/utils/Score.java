package com.idealista.application.utils;

import com.idealista.application.model.Picture;
import com.idealista.application.model.ad.Ad;

import java.util.Arrays;
import java.util.List;

public class Score {

    public static int calculateScore(Ad ad) {
        int score = 0;

        //Check pictures
        score += checkPictures(ad.getPictures());

        //Check description
        score += checkDescription(ad.getDescription(), ad.getTypology());

        //Check ad is complete
        if (isAdComplete(ad)) {
            score += 40;
        }

        //set score
        if (score < 0) score = 0;

        return score;
    }

    private static int checkPictures(List<Picture> pictures) {
        int score = 0;

        if (pictures.isEmpty()) {
            score -= 10;
        } else {
            for (Picture pic : pictures) {
                if (pic.getQuality().equals("HD"))
                    score += 20;
                else
                    score += 10;
            }
        }

        return score;
    }

    private static int checkDescription(String description, String type) {
        int score = 0;
        List<String> words = Arrays.asList("Luminoso", "Nuevo", "Céntrico", "Reformado", "Ático");

        if (!description.isEmpty()) {
            score += 5;

            //check description length
            int numWords = description.split("\\s+").length;

            if (type.equals("CHALET") && numWords > 50) {
                score += 20;
            } else if (type.equals("CHALET")) {
                if (20 <= numWords && numWords <= 40) {
                    score += 10;
                } else if (numWords > 50) {
                    score += 30;
                }
            }

            //check description contains words
            for (String word : words) {
                if (description.contains(word) || description.contains(word.toLowerCase())) {
                    score += 5;
                }
            }
        }

        return score;
    }

    private static boolean isAdComplete(Ad ad) {

        if (ad.getPictures().isEmpty()) {
            return false;
        }
        if (ad.getTypology().isEmpty()) {
            return false;
        }
        if ((ad.getTypology().equals("CHALET") || ad.getTypology().equals("FLAT")) //
                && (ad.getDescription().isEmpty() || ad.getHouseSize() == 0)) {
            return false;
        }
        return !ad.getTypology().equals("CHALET") || ad.getGardenSize() != 0;
    }
}
