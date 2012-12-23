package name.samolisov.message.enricher;

public class Check {
	
	public final Long id;
	
	public final String src;
	
	public final String dst;
	
	public Check(Long id, String src, String dst) {
		this.id = id;
		this.src = src;
		this.dst = dst;
	}
}
