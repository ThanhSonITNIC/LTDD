package com.thanhsonitnic.ungdungdocsach.interfaces;

import com.google.firebase.firestore.QuerySnapshot;

public interface OnDataCompleteListener {
    void onComplete(QuerySnapshot data);
}
