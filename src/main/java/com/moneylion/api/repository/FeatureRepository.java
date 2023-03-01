package com.moneylion.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moneylion.api.entity.Feature;

public interface FeatureRepository extends JpaRepository <Feature, Integer> {

	Feature findByEmailAndFeatureName(String email, String name);

}
