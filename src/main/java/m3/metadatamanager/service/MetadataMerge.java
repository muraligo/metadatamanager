package m3.metadatamanager.service;

import java.util.List;
import java.util.Map;

import m3.metadatamanager.model.MetadataStatus;
import m3.metadatamanager.model.functional.MetadataPartnerValueModel;

public interface MetadataMerge {
	MetadataStatus merge(MetadataPartnerValueModel value);
	List<MetadataStatus> merge(String partnerSource, Map<String, MetadataPartnerValueModel> values);
}
