package com.moneylion.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.moneylion.api.entity.Feature;
import com.moneylion.api.repository.FeatureRepository;

@Service
public class FeatureService {

	@Autowired
	private FeatureRepository featureRepository;

	public boolean getFeatureAccessByEmailAndFeatureName(String email, String name) {
		Feature result = featureRepository.findByEmailAndFeatureName(email, name);
		
		if(result != null) {
			return result.isEnable();
		}
		return false;
	}
	
	public HttpStatus updateFeature(Feature feature) {
		Feature update = featureRepository.findByEmailAndFeatureName(feature.getEmail(), feature.getFeatureName());
		
		if(update != null) {
			update.setEnable(feature.isEnable());
			featureRepository.save(update);
			return HttpStatus.OK;
		}
		return HttpStatus.NOT_MODIFIED;
	}
}
