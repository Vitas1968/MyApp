package com.example.googlelerning.myapp.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.googlelerning.myapp.R;
import com.example.googlelerning.myapp.recicler.DataClass;
import com.example.googlelerning.myapp.recicler.RecyclerViewAdapter;
import java.util.ArrayList;
import java.util.Objects;


public class ShowWeatherFragment extends Fragment  {
    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;

    public ShowWeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setRetainInstance(true);
        return inflater.inflate(R.layout.fragment_show_weathe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRetainInstance(true);
        recyclerView=view.findViewById(R.id.recyclerView);
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<DataClass> list = new ArrayList<>();
        list.add(new DataClass(ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.dozjd),
                "+15"));
        list.add(new DataClass(ContextCompat.getDrawable(getContext(), R.drawable.groza),
                "+20"));
        list.add(new DataClass(ContextCompat.getDrawable(getContext(), R.drawable.oblachno),
                "+23"));
        list.add(new DataClass(ContextCompat.getDrawable(getContext(), R.drawable.wind),
                "+17"));
        list.add(new DataClass(ContextCompat.getDrawable(getContext(), R.drawable.solnce_v_tuche),
                "+25"));
        list.add(new DataClass(ContextCompat.getDrawable(getContext(), R.drawable.jara),
                "+35"));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        DividerItemDecoration itemDecoration;
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT) {
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            itemDecoration= new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL);
        } else {
            layoutManager.setOrientation(RecyclerView.HORIZONTAL);
            itemDecoration= new DividerItemDecoration(getContext(),LinearLayoutManager.HORIZONTAL);
        }

        itemDecoration.setDrawable(Objects.requireNonNull(ContextCompat.getDrawable(getContext(), R.drawable.separator)));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
