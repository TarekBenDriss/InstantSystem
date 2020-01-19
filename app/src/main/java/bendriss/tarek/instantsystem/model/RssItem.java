package bendriss.tarek.instantsystem.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * This class represents the root news item in the rss feed.
 */

@Root(name = "item", strict = false)
class RssItem {
    @Element
    private String title;

    @Element
    private String link;

    @Element
    private String pubDate;

    @Element
    private String description;

    @Element(name = "enclosure", required = false)
    private RssImage enclosure;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RssImage getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(RssImage enclosure) {
        this.enclosure = enclosure;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "RssItem [title=" + title + ", link=" + link + ", pubDate=" + pubDate
                + ", description=" + description + "]";
    }
}