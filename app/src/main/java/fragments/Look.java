package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.juan.eduquer.R;

/**
 * Created by juan on 10/06/15.
 */
public class Look extends Fragment {
    public Look(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        View rootView = inflater.inflate(R.layout.look,container,false);
        return rootView;
    }
}

