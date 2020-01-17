package bendriss.tarek.instantsystem.model;

/**
 * Created by Tarek Ben Driss on 16/01/2020.
 */
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "image", strict = false)
public class RssImage
{
    @Attribute(name = "url", required = false)
    private String url;

    @Attribute(name = "type", required = false)
    private String type;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RssImage [url=" + url + ", type= "+type+"]";
    }
}