package bendriss.tarek.instantsystem.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * This class represents the channel tag in the rss feed
 */
@Root(name = "channel", strict = false)
public class RssChannel {
    @Element
    private String title;

    @ElementList(inline = true, required = false)
    private List<RssItem> item;

    @Override
    public String toString() {
        return "Channel [image=" + ", item=" + item + "]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RssItem> getItem() {
        return item;
    }

    public void setItem(List<RssItem> item) {
        this.item = item;
    }
}