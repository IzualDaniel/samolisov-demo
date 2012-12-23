package name.samolisov.message.enricher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTS_DEMO")
public class SourceMessage implements Message {

	@Id
	@Column(name = "RECORDID")
	private Long id;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "DATA")
	private String data;

	private SourceMessage() {}
	
	public Long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public String getData() {
		return data;
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public String getBody() {
		return data;
	}	
}
