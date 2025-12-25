package flix.db;





public class Movie {
    private int id;
    private String title;
    private String description;
    private String genre;
    private String releaseDate;
    private String image;
    private String video;
    private String url;
    
    public Movie(int id, String title, String description, String genre, String releaseDate, String image, String video) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.image = image;
        this.video = video;
        
    }

    // Add appropriate getters and setters


	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getGenre() {
		return genre;
	}

	public String getDate() {
		return releaseDate;
	}

	public String getImage() {
		return image;
	}

	public String getVideo() {
		return video;
	}

	public String getUrl() {
		return url;
	}


	
}
