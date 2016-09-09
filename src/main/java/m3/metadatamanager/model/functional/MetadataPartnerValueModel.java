package m3.metadatamanager.model.functional;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import m3.metadatamanager.model.MetadataPartnerValue;
import m3.metadatamanager.model.Model;

@Entity
@Table(name = "metadata_partner_value")
public class MetadataPartnerValueModel implements Model, MetadataPartnerValue {
	private static final long serialVersionUID = 1L;

	private String name;
	private String version;
	private String source;
	private String representation;
	private List<String> valueParts;

    @Id
	@Column(name = "name", nullable = false, length = 32)
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String value) {
		name = value;
	}

	@Basic
	@Column(name = "description", length = 1024)
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setDescription(String value) {
		// TODO Auto-generated method stub

	}

	@Basic
	@Column(name = "version", length = 8)
	@Override
	public String getVersion() {
		return version;
	}
	@Override
	public void setVersion(String value) {
		version = value;
	}

	@Basic
	@Column(name = "source", nullable = false, length = 32)
	@Override
	public String getSource() {
		return source;
	}
	@Override
	public void setSource(String value) {
		source = value;
	}

	@Basic
	@Column(name = "representation", nullable = false, length = 1024)
	@Override
	public String getRepresentation() {
		return representation;
	}
	@Override
	public void setRepresentation(String value) {
		representation = value;
	}

	@Override
	public List<String> getValueParts() {
		return valueParts;
	}
	@Override
	public void setValueParts(List<String> parts) {
		valueParts = parts;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("MetadataPartnerValue#" + name + "." + source + "." + version + "{");
		sb.append(representation);
//		sb.append(", Last Updated = ");
//		sb.append(lastUpdateDate);
		sb.append(", Value Parts [");
		for (String vp : valueParts) {
			sb.append(vp);
			sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

	@Transient
	@Override
	public String getPartnerName() {
		return getName();
	}
	@Override
	public void setPartnerName(String value) {
		setName(value);
	}
}
