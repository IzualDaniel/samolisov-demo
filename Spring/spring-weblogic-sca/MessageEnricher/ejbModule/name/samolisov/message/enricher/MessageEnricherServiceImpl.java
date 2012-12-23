package name.samolisov.message.enricher;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "messagenricher")
public class MessageEnricherServiceImpl implements MessageEnricherServiceRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Message enrich(Check check) throws MessageEnrichException {
		return em.find(SourceMessage.class, check.id);		
	}
}
