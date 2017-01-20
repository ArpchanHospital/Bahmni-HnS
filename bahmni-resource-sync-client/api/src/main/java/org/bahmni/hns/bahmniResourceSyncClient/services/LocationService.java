package org.bahmni.hns.bahmniResourceSyncClient.services;

import org.hl7.fhir.dstu3.model.Location;
import org.openmrs.api.context.Context;
import org.openmrs.healthStandard.converter.fhir.FHIRConverter;
import org.openmrs.healthStandard.converter.fhir.FHIRConverterRegistry;

public class LocationService {

    public org.openmrs.Location save(Location fhirLocation) {
        FHIRConverter<Location, org.openmrs.Location> fhirConverter = FHIRConverterRegistry.getInstance()
                .getConverterFor(Location.class, org.openmrs.Location.class);
        org.openmrs.Location openmrsLocation = fhirConverter.convert(fhirLocation);
        return Context.getLocationService().saveLocation(openmrsLocation);
    }
}
