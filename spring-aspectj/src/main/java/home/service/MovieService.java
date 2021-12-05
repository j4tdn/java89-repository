package home.service;

public interface MovieService {
	void addMovie();
	String getMovie();
	void validateMovie() throws Exception;
	void updateMovie(String name);
}
