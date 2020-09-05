package com.thoughtmechanix.licenses.controllers;

import com.thoughtmechanix.licenses.model.License;
import com.thoughtmechanix.licenses.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    @Autowired
    private LicenseService licenseService;

    @RequestMapping(value="{licenseId}", method = RequestMethod.GET)
    public List<License> getLicenses(@PathVariable("organizationId") String organizationId){
        return licenseService.getLicencesByOrg(organizationId);
    }

    @RequestMapping(value="{licenseId}", method = RequestMethod.GET)
    public License getLicenses(@PathVariable("organizationId") String organizationId, @PathVariable("licenseId") String licenseId){
        return licenseService.getLicense(organizationId, licenseId);
    }

    @RequestMapping(value = "{licenseId}", method = RequestMethod.PUT)
    public String updateLicense(@PathVariable("licenseId") String licenseId){
        return String.format("Updating license");
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public void saveLicense(@RequestBody License license){
        licenseService.saveLicense(license);
    }

    @RequestMapping(value = "{licenseId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteLicense(@PathVariable("licenseId") String licenseId){
        return String.format("License deleted.");
    }



}
