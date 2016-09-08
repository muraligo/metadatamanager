package m3.metadatamanager.model.functional;

import java.util.List;

import m3.metadatamanager.model.Model;

public class MetadataElement implements Model {
	private String name;
	private Integer instance;
	private String canonicalValue;
	private String representation;
	private Integer segments;
	private List<PartnerValues> partnerValues;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String value) {
		name = value;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVersion(String value) {
		// TODO Auto-generated method stub

	}

	public Integer getInstance() {
		return instance;
	}

	public void setInstance(Integer value) {
		instance = value;
	}

	public String getCanonicalValue() {
		return canonicalValue;
	}

	public void setCanonicalValue(String value) {
		canonicalValue = value;
	}

	public String getRepresentation() {
		return representation;
	}

	public void setRepresentation(String value) {
		representation = value;
	}

	public Integer getSegments() {
		return segments;
	}

	public void setSegments(Integer value) {
		segments = value;
	}

	public List<PartnerValues> getPartnerValues() {
		return partnerValues;
	}

	public void setPartnerValues(List<PartnerValues> values) {
		this.partnerValues = values;
	}
}
