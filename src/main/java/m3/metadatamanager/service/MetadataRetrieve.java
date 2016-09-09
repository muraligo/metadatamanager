package m3.metadatamanager.service;

import m3.metadatamanager.model.MetadataResult;

public interface MetadataRetrieve {
	MetadataResult getCanonicalAll();
	MetadataResult getCanonicalName(String name);
	MetadataResult getPartner(String partnerName);
}
