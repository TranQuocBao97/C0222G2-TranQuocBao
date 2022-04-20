package case_study.services;

import case_study.models.facility.AbsFacility;

public interface IFacilityService extends IService<AbsFacility> {
    public void displayMaintenance();
}
