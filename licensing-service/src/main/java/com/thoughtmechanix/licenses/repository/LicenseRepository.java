package com.thoughtmechanix.licenses.repository;

import com.thoughtmechanix.licenses.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, String> {

    public List<License> findByOrganizationId(String organizationId);

    public License findByLicenseAndOrganizationId(String organizationId, String licenseId);

}
