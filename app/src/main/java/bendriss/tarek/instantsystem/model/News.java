package bendriss.tarek.instantsystem.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * The model of the news
 */
public class News implements Serializable {

    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("link")
    private String link;
    @SerializedName("urlImg")
    private String urlImg;


    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public News(String title, String description, String link, String urlImg) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.urlImg = urlImg;
    }

    public News() {
    }


}
