package name.samolisov.adapter.endpoint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_DESTINATION")
public class DestinationMessage {

	@Id
	@SequenceGenerator(name = "message_id_gen", sequenceName = "DESTINATION_MESSAGE_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "message_id_gen", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "SRC_ID")
	private Long srcId;
	
	@Column(name = "MESSAGE")
	private String content;
	
	@SuppressWarnings("unused")
	private DestinationMessage() {}
	
	public DestinationMessage(Long srcId, String content) {
		this.srcId = srcId;
		this.content = content;
	}	
	
	public Long getId() {
		return id;
	}

	public Long getSrcId() {
		return srcId;
	}

	public void setSrcId(Long srcId) {
		this.srcId = srcId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
}
