package bendriss.tarek.instantsystem.activity;

import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;
import bendriss.tarek.instantsystem.R;
import bendriss.tarek.instantsystem.databinding.ActivityMainBinding;
import bendriss.tarek.instantsystem.fragment.DetailsNewsFragment;
import bendriss.tarek.instantsystem.fragment.ListNewsFragment;
import bendriss.tarek.instantsystem.interfaces.ActionsDelegate;
import bendriss.tarek.instantsystem.model.News;
import bendriss.tarek.instantsystem.utils.WindowUtils;

import android.os.Bundle;

/**
 * The main activity which contains two fragments, the list of news and the details
 */
public class MainActivity extends AppCompatActivity implements ActionsDelegate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        WindowUtils.setStausBarColor(this, R.color.grey);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListNewsFragment()).addToBackStack(null).commit();

    }

    /**
     * The redirection to the details of a news, it is an implementation of the interface ActionsDelegate
     *
     * @param item is the news object
     */
    @Override
    public void redirectButton(News item) {
        DetailsNewsFragment fragment = new DetailsNewsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("news", item);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(null).commit();
    }


}
