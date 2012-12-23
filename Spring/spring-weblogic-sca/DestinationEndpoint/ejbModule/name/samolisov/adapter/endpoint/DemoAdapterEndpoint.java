package name.samolisov.adapter.endpoint;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(mappedName = "destination")
public class DemoAdapterEndpoint implements AdapterEndpoint {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Long srcId, String content) {
		em.persist(new DestinationMessage(srcId, content));
	}
}
