package home.service;

public class MovieServiceImpl implements MovieService {

	public void addMovie() {
		System.out.println("movie excuting addMovie...");
		
	}

	public String getMovie() {
		// TODO Auto-generated method stub
		return "movie excuting addMovie...getmovie...";
	}

	public void validateMovie() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("movie excuting addMovie...validatemovie");
		throw new Exception();

	}

	public void getUpdate(String name) {
		// TODO Auto-generated method stub
		System.out.println("movie excuting addMovie...updatemovie");
		
	}

}
