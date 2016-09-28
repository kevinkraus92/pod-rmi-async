package itba.pod;

import java.util.Objects;
import java.util.Optional;

/**
 *
 */
public final class Movie {
    private final String name;
    private final String genre;

    public Movie(final String name, final String genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public int hashCode() {
        return (name == null) ? 0 : name.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {

        return this == obj || Optional
                                      .ofNullable(obj)
                                      .filter(o -> o instanceof Movie)
                                      .map(o -> (Movie) o)
                                      .filter(m -> Objects.equals(name, m.name))
                                      .isPresent();
    }

    @Override
    public String toString() {
        return name;
    }

}
