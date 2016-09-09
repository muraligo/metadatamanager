package m3.metadatamanager.model;

import java.io.Serializable;

public interface MetadataStatus extends Serializable {
	String partnerSource();
	String partnerName();
	Integer statusCode();
	String statusTitle();
	String statusDescription();
	String additionalText();
}
