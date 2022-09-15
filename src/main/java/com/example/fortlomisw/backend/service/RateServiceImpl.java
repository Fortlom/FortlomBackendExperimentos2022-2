package com.example.fortlomisw.backend.service;

import com.example.fortlomisw.backend.domain.model.entity.Fanatic;
import com.example.fortlomisw.backend.domain.model.entity.Rate;
import com.example.fortlomisw.backend.domain.persistence.*;
import com.example.fortlomisw.backend.domain.service.RateService;
import com.example.fortlomisw.shared.exception.ResourceNotFoundException;
import com.example.fortlomisw.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.validation.Validator;
@Service
public class RateServiceImpl implements RateService {

    private static final Integer LIMIT_DANGEROURS = 3;
    private static final Integer LIMIT_HATER = 3;
    private static final String ENTITY = "Rate";
    @Autowired
    private  RateRepository rateRepository;
    @Autowired
    private  FanaticRepository fanaticRepository;
    @Autowired
    private  ArtistRepository artistRepository;
    @Autowired
    private FollowRepository followRepository;

    @Autowired
    private ReportRepository reportRepository;
    public RateServiceImpl() {

    }


    @Override
    public List<Rate> getAll() {
        return rateRepository.findAll();
    }

    @Override
    public Page<Rate> getAll(Pageable pageable) {
        return rateRepository.findAll(pageable);
    }

    @Override
    public Rate getById(Long rateId) {
        return rateRepository.findById(rateId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, rateId));
    }
    public Boolean isItLowerThanThree(Integer rate){
        if(rate<LIMIT_HATER){
            return true;
        }else{
            return false;
        }
    }
    public Boolean userIsHater(Long userid){
        Integer a=reportRepository.findByUserMainId(userid).size();
        if(a>=LIMIT_DANGEROURS){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public Rate create(Long FanaticId, Long ArtistId, Rate request) {

        Fanatic faan = fanaticRepository.findById(FanaticId)
                .orElseThrow(() -> new ResourceNotFoundException("Fanatic", FanaticId));
        //probe
        if(isItLowerThanThree(request.getRates())&&(userIsHater(faan.getId()))){
            throw new ResourceValidationException(ENTITY, "User  is considered hater");
        }
        else {
            return artistRepository.findById(ArtistId)
                    .map(artist -> {
                        request.setArtist(artist);
                        request.setFanatic(faan);
                        return rateRepository.save(request);
                    })
                    .orElseThrow(() -> new ResourceNotFoundException("Artist", ArtistId));
        }
    }

    @Override
    public Rate update(Long rateId, Rate request) {

        return rateRepository.findById(rateId).map(post->{
            request.setRates(request.getRates());
            rateRepository.save(post);
            return post;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, rateId));



    }

    @Override
    public List<Rate> ratesByFanaticId(Long FanaticId) {
        return rateRepository.findByFanaticId(FanaticId) ;   }

    @Override
    public List<Rate> ratesByArtistId(Long ArtistId) {
        return rateRepository.findByArtistId(ArtistId);
    }

    @Override
    public ResponseEntity<?> delete(Long rateId) {
        return rateRepository.findById(rateId).map(post -> {
            rateRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, rateId));
    }
}
