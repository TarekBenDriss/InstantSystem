package bendriss.tarek.instantsystem.model;

/**
 * Created by Tarek Ben Driss on 16/01/2020.
 */
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class RssItem
{
    @Element
    public String title;

    @Element
    private String link;

    @Element
    private String pubDate;

    @Element
    private String description;

    @Override
    public String toString() {
        return "RssItem [title=" + title + ", link=" + link + ", pubDate=" + pubDate
                + ", description=" + description + "]";
    }
}