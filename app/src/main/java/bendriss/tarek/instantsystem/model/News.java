package bendriss.tarek.instantsystem.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tarek Ben Driss on 15/01/2020.
 */
public class News {

    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("link")
    private String link;
    @SerializedName("thumbnail")
    private String mThumbnail;

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setmThumbnail(String mThumbnail) {
        this.mThumbnail = mThumbnail;
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
}
