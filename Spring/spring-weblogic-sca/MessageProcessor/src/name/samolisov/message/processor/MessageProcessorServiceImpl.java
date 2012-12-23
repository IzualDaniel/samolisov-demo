package name.samolisov.message.processor;

import name.samolisov.adapter.endpoint.AdapterEndpoint;
import name.samolisov.message.enricher.Check;
import name.samolisov.message.enricher.Message;
import name.samolisov.message.enricher.MessageEnrichException;
import name.samolisov.message.enricher.MessageEnricherService;

public class MessageProcessorServiceImpl implements MessageProcessorService {
	
	private String src;
	
	private String dst;
	
	private AdapterEndpoint endpoint;
	
	private MessageEnricherService enricher;
	
	@Override
	public void process(Long id) throws MessageProcessingException {		
		try {
			Message message = enricher.enrich(new Check(id, src, dst));
			if (message != null)
				endpoint.save(id, message.getBody());
			else
				throw new MessageProcessingException("Could not process message with id " + id);
		} catch (MessageEnrichException e) {
			throw new MessageProcessingException("Could not process message with id " + id, e);
		}					
	}

	public AdapterEndpoint getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(AdapterEndpoint endpoint) {
		this.endpoint = endpoint;
	}

	public MessageEnricherService getEnricher() {
		return enricher;
	}

	public void setEnricher(MessageEnricherService enricher) {
		this.enricher = enricher;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}	
}
