package grab.grabber.util;

import grab.grabber.domain.Vacancy;

import java.util.List;

public interface Parser {
    List<Vacancy> list(String link);

    Vacancy detail(String link);
}
