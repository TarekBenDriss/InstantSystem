package bendriss.tarek.instantsystem.model;

/**
 * This class represents the tag enclosure which contains the url of the image and its type
 */

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "image", strict = false)
public class RssImage {
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
        return "RssImage [url=" + url + ", type= " + type + "]";
    }
}