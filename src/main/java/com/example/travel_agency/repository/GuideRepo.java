package com.example.travel_agency.repository;

import com.example.travel_agency.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuideRepo extends JpaRepository<Guide,Long> {
    List<Guide> findByLanguage(String language);
}
