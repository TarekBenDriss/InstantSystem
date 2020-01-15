package bendriss.tarek.instantsystem.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tarek Ben Driss on 15/01/2020.
 */

@SuppressWarnings("unused")
public class NewsWrapperOld {
    @SerializedName("data")
    private List<News> mData;
    @SerializedName("error")
    private Boolean mError;
    @SerializedName("message")
    private String mMessage;
    @SerializedName("status")
    private String mStatus;

    public List<News> getNews() {
        return mData;
    }

    public void setmData(List<News> mData) {
        this.mData = mData;
    }

    public Boolean getmError() {
        return mError;
    }

    public void setmError(Boolean mError) {
        this.mError = mError;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }
}
