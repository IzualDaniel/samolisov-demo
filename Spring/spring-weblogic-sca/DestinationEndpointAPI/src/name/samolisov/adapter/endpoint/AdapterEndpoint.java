package name.samolisov.adapter.endpoint;

import javax.ejb.Remote;

@Remote
public interface AdapterEndpoint {

	public void save(Long srcId, String content);
}
