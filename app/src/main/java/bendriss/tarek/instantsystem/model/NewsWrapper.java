package bendriss.tarek.instantsystem.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the main root element in the rss feed
 */
@Root(name = "rss", strict = false)
public class NewsWrapper {
    @Element
    private RssChannel channel;

    @Override
    public String toString() {
        return "RssFeed [channel=" + channel + "]";
    }

    public RssChannel getChannel() {
        return channel;
    }

    public void setChannel(RssChannel channel) {
        this.channel = channel;
    }

    public List<News> getNewsModel() {
        List<RssItem> items = channel.getItem();
        List<News> newsList = new ArrayList<>();
        for (RssItem item : items) {
            if(item.getEnclosure()==null)
                newsList.add(new News(item.getTitle(), item.getDescription(), item.getLink(), ""));
            else
            newsList.add(new News(item.getTitle(), item.getDescription(), item.getLink(), item.getEnclosure().getUrl()));
        }
        return newsList;
    }
}