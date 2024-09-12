package com.example.thawaq.Service;

import com.example.thawaq.Api.ApiException;
import com.example.thawaq.Model.Rating;
import com.example.thawaq.Repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RatingService {
    private final RatingRepository ratingRepository;

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public void addRatingToStore(Rating rating) {

        ratingRepository.save(rating);}


    public void updateRating(Rating rating,Integer id) {
        Rating r = ratingRepository.findRatingById(id);
        if(r == null) {
            throw new ApiException("Rating not found");}
        r.setService(rating.getService());
        r.setCleaning(rating.getCleaning());
        r.setQuality(rating.getQuality());
        r.setCost(rating.getCost());
        r.setComment(rating.getComment());
        r.setTitle(rating.getTitle());
        r.setAverageRating(rating.getAverageRating());
        ratingRepository.save(r);}



    public void deleteRating(Integer id) {
        Rating r = ratingRepository.findRatingById(id);
        if(r == null) {
            throw new ApiException("Rating not found");}
        ratingRepository.delete(r);
    }
}
