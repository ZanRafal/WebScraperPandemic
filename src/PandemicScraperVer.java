import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class PandemicScraperVer {
    public static final ArrayList<Elements> sources = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Connection connection = Jsoup.connect("https://www.medonet.pl/koronawirus/to-musisz-wiedziec,zasieg-koronawirusa-covid-19--mapa-,artykul,54726942.html?utm_source=sgonet&utm_medium=referral&utm_campaign=mapasgonet&srcc=mapasgonet");
        Document document = connection.get();

        Elements polandDeaths = document.select("#pageArticle > section:nth-child(3) > section > div.inlineFrame.warning > ol > li:nth-child(1) > span.value");
        Elements worldwideDeaths = document.select("#pageArticle > section:nth-child(3) > section > div.inlineFrame.warning > ol > li:nth-child(2) > span.value");
        Elements polandCases = document.select("#pageArticle > section:nth-child(3) > section > div:nth-child(6) > ol > li:nth-child(1) > span.value");
        Elements worldwideCases = document.select("#pageArticle > section:nth-child(3) > section > div:nth-child(6) > ol > li:nth-child(2) > span.value");
        Elements curedWorldwide = document.select("#pageArticle > section:nth-child(3) > section > div:nth-child(6) > ol > li:nth-child(2) > span.value");

        sources.add(polandCases);
        sources.add(worldwideCases);
        sources.add(polandDeaths);
        sources.add(worldwideDeaths);
        sources.add(curedWorldwide);

        for(Elements element : sources) {
            System.out.println(element.text());
        }
    }
}
