package com.thoughtmechanix.licenses.services;

import com.thoughtmechanix.licenses.config.ServiceConfig;
import com.thoughtmechanix.licenses.model.License;
import com.thoughtmechanix.licenses.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    private ServiceConfig config;

    public List<License> getLicencesByOrg(String organizationId){
        return licenseRepository.findByOrganizationId(organizationId);
    }

    public License getLicense(String organizationId, String licenseId){
        License license = licenseRepository.findByLicenseAndOrganizationId(organizationId, licenseId);
        return license.withComment(config.getExampleProperty());
    }

    public void saveLicense(License license){
        license.withId(UUID.randomUUID().toString());
        licenseRepository.save(license);
    }
}
