package com.example.project_3_fragments;

import android.os.Bundle;

public interface ListSelectionListener {
    String KEY_SELECTED_ITEM = "KEY_SELECTED_ITEM";

    void onItemSelected(String item);
}
