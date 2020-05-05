package server;

public interface CacheManager {

	String getSolution(String problem);
	void saveSolution(String problem, String Solution);

}
