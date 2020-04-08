package com.example.project_3_fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;

public class RestListFragment extends ListFragment {
    private ListSelectionListener mListener = null;
    private int mCurrIdx = -1;

    public interface ListSelectionListener {
        public void onListSelection(int index);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            mListener = (ListSelectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.list_fragment, RestaurantsActivity.mListArray));

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        getListView().setItemChecked(pos, true);
        mListener.onListSelection(pos);
    }
}

