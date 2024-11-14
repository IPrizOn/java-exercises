import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name; 

    private class Session {
        private String movieTitle; 
        private String startTime; 

        public Session(String movieTitle, String startTime) {
            this.movieTitle = movieTitle;
            this.startTime = startTime;
        }

        public String getMovieTitle() {
            return movieTitle;
        }

        public String getStartTime() {
            return startTime;
        }

        @Override
        public String toString() {
            return "Сеанс{" +
                    "фильм='" + movieTitle + '\'' +
                    ", время='" + startTime + '\'' +
                    '}';
        }
    }

    private List<Session> sessions;

    public Cinema(String name) {
        this.name = name;
        this.sessions = new ArrayList<>();
    }

    public void addSession(String movieTitle, String startTime) {
        sessions.add(new Session(movieTitle, startTime));
    }

    public List<Session> getSessions() {
        return sessions;
    }

    @Override
    public String toString() {
        return "Кинотеатр{" +
                "название='" + name + '\'' +
                ", сеансы=" + sessions +
                '}';
    }
}
