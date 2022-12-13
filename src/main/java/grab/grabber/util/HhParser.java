package grab.grabber.util;

import grab.grabber.domain.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HhParser implements Parser {

    @Override
    public List<Vacancy> list(String link) {
        return null;
    }

    @Override
    public Vacancy detail(String link) {
        var vacancy = new Vacancy();
        try {
            Document document = Jsoup.connect(link).get();
            Elements elements = document.select(".row-content");
            System.out.println(elements.select(".vacancy-title").text());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        var parser = new HhParser();
        System.out.println(parser.detail("https://spb.hh.ru/vacancy/73131091?from=vacancy_search_list&query=java"));
        System.out.println("Привет!");
    }
}
