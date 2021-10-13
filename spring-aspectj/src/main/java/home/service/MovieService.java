package home.service;


//joint ponit
public interface MovieService {
	void addMovie();
	String getMovie();
	void validateMovie() throws Exception;
	void getUpdate(String name);
	
}
