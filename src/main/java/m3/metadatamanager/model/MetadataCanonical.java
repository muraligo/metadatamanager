package m3.metadatamanager.model;

import java.io.Serializable;

public class MetadataCanonical implements Cloneable, Comparable<MetadataCanonical>, Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Integer instance;
	private String value;
	private String representation;
	private Integer segments;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getInstance() {
		return instance;
	}
	public void setInstance(Integer instance) {
		this.instance = instance;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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

	@Override
	public String toString() {
		return name + "." + instance;
	}

	@Override
	public int compareTo(MetadataCanonical o) {
		int nc = this.name.compareTo(o.name);
		return (nc == 0) ? this.instance.compareTo(o.instance) : nc;
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof MetadataCanonical) && (this.compareTo((MetadataCanonical)o) == 0);
	}

	@Override
	public int hashCode() {
		return name.hashCode() * 32 + instance;
	}
}
