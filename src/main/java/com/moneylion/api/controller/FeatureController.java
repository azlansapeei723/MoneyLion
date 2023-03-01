package com.moneylion.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moneylion.api.entity.Feature;
import com.moneylion.api.service.FeatureService;

@RestController
public class FeatureController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
	private FeatureService featureService;

	@GetMapping(value = "/feature")
	public Map<String, Boolean> getFeatureAccessByEmailAndFeatureName(@RequestParam Map<String, String> details) {
		logger.info("Get access details... ");
		HashMap<String, Boolean> map = new HashMap<>();
		map.put("canAccess",
				featureService.getFeatureAccessByEmailAndFeatureName(details.get("email"), details.get("featureName")));
		return map;
	}

	@PostMapping(value = "/feature")
	public ResponseEntity<Void> postUpdateFeature(@RequestBody Feature feature) {
		logger.info("Update access details... ");
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, featureService.updateFeature(feature));
	}
}
