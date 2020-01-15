package bendriss.tarek.instantsystem.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Tarek Ben Driss on 16/01/2020.
 */
@Root(name = "channel", strict = false)
public class RssChannel
{
    @Element
    private String title;

    //@Element
    //private RssImage image;

    @ElementList(inline = true, required = false)
    public List<RssItem> item;

    @Override
    public String toString() {
       // return "Channel [image=" + image + ", item=" + item + "]";
        return "Channel [image=" +  ", item=" + item + "]";
    }
}