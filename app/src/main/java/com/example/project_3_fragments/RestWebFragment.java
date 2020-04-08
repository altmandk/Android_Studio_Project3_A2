package com.example.project_3_fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;

public class RestWebFragment extends Fragment {
    private WebView mWebView = null;
    private int mCurrIdx = -1;
    private int mWebArrLen;

    int getShownIndex() {
        return mCurrIdx;
    }

    void showQuoteAtIndex(int newIndex) {
        if (newIndex < 0 || newIndex >= mWebArrLen)
            return;
        mCurrIdx = newIndex;
        //mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(RestaurantsActivity.mWebArray[mCurrIdx]);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.web_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWebView = (WebView) getActivity().findViewById(R.id.webView);
        mWebArrLen = RestaurantsActivity.mWebArray.length;
        //showQuoteAtIndex(mCurrIdx);
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
    }
}
