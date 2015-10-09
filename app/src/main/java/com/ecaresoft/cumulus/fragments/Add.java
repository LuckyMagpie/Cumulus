package com.ecaresoft.cumulus.fragments;

/**
 * Created by juan on 10/06/15.
 *//*
public class Add extends Fragment implements View.OnClickListener{
    private ImageButton btnSend;
    private EditText etWords;
    private SQLiteDatabase db;
    public String word;
    public Add(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState){
        View rootView = inflater.inflate(R.layout.add,container,false);
        setHasOptionsMenu(true);
        btnSend=(ImageButton)rootView.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(this);
        etWords=(EditText)rootView.findViewById(R.id.etWords);
        setRetainInstance(true);
        return rootView;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSend) {
            try {
                if(etWords.length()>0) {
                    word=etWords.getText().toString();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),getResources().getString(R.string.abc_action_bar_home_description),Toast.LENGTH_SHORT).show();
                }
            } catch (Exception ex) {}
        }
    }


}
*/