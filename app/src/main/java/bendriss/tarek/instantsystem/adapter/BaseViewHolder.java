package bendriss.tarek.instantsystem.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Tarek Ben Driss on 15/01/2020.
 */
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    private int mCurrentPosition;
    public BaseViewHolder(View itemView) {
        super(itemView);
    }
    protected abstract void clear();
    public void onBind(int position) {
        mCurrentPosition = position;
        clear();
    }
    public int getCurrentPosition() {
        return mCurrentPosition;
    }
}