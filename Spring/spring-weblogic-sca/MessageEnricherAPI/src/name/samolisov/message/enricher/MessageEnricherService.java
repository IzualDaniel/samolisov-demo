package name.samolisov.message.enricher;

public interface MessageEnricherService {

	public Message enrich(Check check) throws MessageEnrichException;
}
