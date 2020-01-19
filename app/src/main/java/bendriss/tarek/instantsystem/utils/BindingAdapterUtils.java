package bendriss.tarek.instantsystem.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;


/**
 * This class is used to create new attributes in the views to facilitate some treatments
 */
public class BindingAdapterUtils {

    /**
     * This function is used to create a new xml attribute to load an image from an url into an imageView
     *
     * @param view the imageView which will be used to show the image
     * @param url  the url of the image
     */
    @BindingAdapter("urlImg")
    public static void setImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .into(view);
    }
}
