package bendriss.tarek.instantsystem.model;
import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Tarek Ben Driss on 15/01/2020.
 */
@Root(name = "rss", strict = false)
public class NewsWrapper
{
    @Element
    public RssChannel channel;

    @Override
    public String toString() {
        return "RssFeed [channel=" + channel + "]";
    }
}