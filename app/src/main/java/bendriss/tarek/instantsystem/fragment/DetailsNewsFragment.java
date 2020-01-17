package bendriss.tarek.instantsystem.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import bendriss.tarek.instantsystem.R;


public class DetailsNewsFragment extends Fragment {

    public DetailsNewsFragment() {
        // Required empty public constructor
    }


    public static DetailsNewsFragment newInstance(String param1, String param2) {
        DetailsNewsFragment fragment = new DetailsNewsFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details_news, container, false);

        ImageView img = view.findViewById(R.id.profile_img);
        Glide.with(view.getContext())
                .load("https://img.lemde.fr/2020/01/17/416/0/5000/2500/644/322/60/0/4a8db92_tqoGbS9QRjjur_MlIpzVU6XA.JPG")
                .into(img);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

}
