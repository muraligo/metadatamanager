package m3.metadatamanager.model.functional;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import m3.metadatamanager.model.LocalDateTimePersistenceConverter;
import m3.metadatamanager.model.MetadataCanonical;
import m3.metadatamanager.model.Model;

@Entity
@Table(name = "metadata_element")
public class MetadataElement implements Model, Serializable, Comparable<MetadataElement> {
	private static final long serialVersionUID = 1L;
	private static final long REFRESH_INTERVAL = 300L; // in seconds

	private MetadataElementPK id;
	private String version;
	private String canonicalValue;
	private String representation;
	private Integer segments;
	private LocalDateTime lastUpdateDate;
	private List<MetadataPartnerValueModel> partnerValues;

	@EmbeddedId
	public MetadataElementPK getId() {
		return id;
	}
	public void setId(MetadataElementPK id) {
		this.id = id;
	}

	@Transient
	@Override
	public String getName() {
		return id.getName();
	}
	@Override
	public void setName(String value) {
		id.setName(value);
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

	@Transient
	public Integer getInstance() {
		return id.getInstance();
	}
	public void setInstance(Integer value) {
		id.setInstance(value);
	}

	@Basic
	@Column(name = "canonical_value", nullable = false, length = 1024)
	public String getCanonicalValue() {
		return canonicalValue;
	}
	public void setCanonicalValue(String value) {
		canonicalValue = value;
	}

	@Basic
	@Column(name = "representation", nullable = false, length = 1024)
	public String getRepresentation() {
		return representation;
	}
	public void setRepresentation(String value) {
		representation = value;
	}

	@Basic
	@Column(name = "segments", nullable = false)
	public Integer getSegments() {
		return segments;
	}
	public void setSegments(Integer value) {
		segments = value;
	}

	@Column(name = "last_update_date", nullable = false)
	@Convert(converter = LocalDateTimePersistenceConverter.class)
	public LocalDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(LocalDateTime value) {
		lastUpdateDate = value;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ELEMENT_ID")
	public List<MetadataPartnerValueModel> getPartnerValues() {
		return partnerValues;
	}
	public void setPartnerValues(List<MetadataPartnerValueModel> values) {
		this.partnerValues = values;
	}

	@Transient
	public int getFreshness() {
		long diff = lastUpdateDate.until(LocalDateTime.now(), ChronoUnit.SECONDS);
		double ratio = ((double) diff) * 100.0 / ((double) REFRESH_INTERVAL);
		return (int) Math.round(ratio);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("MetadataElement#" + id.toString() + "." + version + "{");
		sb.append(canonicalValue + "#" + representation + "." + segments);
		sb.append(", Last Updated = ");
		sb.append(lastUpdateDate);
		sb.append(", Partner Values [");
		for (MetadataPartnerValueModel pv : partnerValues) {
			sb.append(pv);
			sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int compareTo(MetadataElement o) {
		return id.compareTo(o.getId());
	}

	public MetadataCanonical toCanonical() {
		MetadataCanonical res = new MetadataCanonical();
		res.setName(getName());
		res.setInstance(getInstance());
		res.setRepresentation(representation);
		res.setSegments(segments);
		return res;
	}
}
