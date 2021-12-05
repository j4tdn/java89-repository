package home.service;

public class MovieServiceImpl implements MovieService {

	@Override
	public void addMovie() {
		System.out.println("Movie executing ... add movie");
	}

	@Override
	public String getMovie() {
		return "MovieService executing ... getMovie...";
	}

	@Override
	public void validateMovie() throws Exception {
		System.out.println("Movie executing ... validate movie...");
	}

	@Override
	public void updateMovie(String name) {
		System.out.println("Movie executing ... update movie...");
	}

}
