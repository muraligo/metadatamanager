package m3.metadatamanager.model;

import java.io.Serializable;
import java.util.List;

public interface MetadataResult extends Serializable {
	MetadataStatus status();
	Boolean isCanonical();
	List<MetadataCanonical> canonicalValues();
	List<MetadataPartnerValue> partnerValues();
}
