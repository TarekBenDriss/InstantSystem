package bendriss.tarek.instantsystem.model;

/**
 * Created by Tarek Ben Driss on 16/01/2020.
 */
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "image", strict = false)
public class RssImage
{
    @Element
    public String url;

    @Element
    private String width;

    @Element
    private String height;

    @Override
    public String toString() {
        return "RssImage [url=" + url + ", width=" + width + ", height=" + height + "]";
    }
}