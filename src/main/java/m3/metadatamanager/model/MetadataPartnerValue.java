package m3.metadatamanager.model;

import java.io.Serializable;
import java.util.List;

public interface MetadataPartnerValue extends Serializable {
	String getPartnerName();
	void setPartnerName(String value);
	String getSource();
	void setSource(String value);
	String getRepresentation();
	void setRepresentation(String value);
	List<String> getValueParts();
	void setValueParts(List<String> parts);
}
