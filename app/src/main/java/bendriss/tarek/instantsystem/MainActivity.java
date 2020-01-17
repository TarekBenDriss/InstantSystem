package bendriss.tarek.instantsystem;

import androidx.appcompat.app.AppCompatActivity;

import bendriss.tarek.instantsystem.fragment.DetailsNewsFragment;
import bendriss.tarek.instantsystem.fragment.ListNewsFragment;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static MainActivity thisActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        thisActivity=this;

        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new ListNewsFragment()).addToBackStack(null).commit();

    }


    public static void redirectToDetails()
    {
        thisActivity.getSupportFragmentManager().beginTransaction().replace(R.id.container,new DetailsNewsFragment()).addToBackStack(null).commit();
    }
}