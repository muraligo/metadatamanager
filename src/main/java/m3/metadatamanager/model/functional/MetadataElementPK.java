package m3.metadatamanager.model.functional;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MetadataElementPK implements Cloneable, Comparable<MetadataElementPK>, Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Integer instance;

	@Basic
	@Column(name = "name", nullable = false, length = 32)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Basic
	public Integer getInstance() {
		return instance;
	}
	public void setInstance(Integer instance) {
		this.instance = instance;
	}

	@Override
	public String toString() {
		return name + "." + instance;
	}

	@Override
	public int compareTo(MetadataElementPK o) {
		int nc = this.name.compareTo(o.name);
		return (nc == 0) ? this.instance.compareTo(o.instance) : nc;
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof MetadataElementPK) && (this.compareTo((MetadataElementPK)o) == 0);
	}

	@Override
	public int hashCode() {
		return name.hashCode() * 32 + instance;
	}
}
