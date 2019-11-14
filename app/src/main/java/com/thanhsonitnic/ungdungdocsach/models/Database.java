package com.thanhsonitnic.ungdungdocsach.models;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnDataCompleteListener;

public class Database {
    private static Database database;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference documentReference;

    private Database(){
        documentReference = db.collection("Books");
    }

    public static Database getInstance(){
        if(database == null){
            database = new Database();
        }
        return database;
    }

    public void getListBook(final OnDataCompleteListener onDataCompleteListener){
        documentReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    onDataCompleteListener.onComplete(task.getResult());
                }
            }
        });
    }

    public void getTableOfContent(String bookId, final OnDataCompleteListener onDataCompleteListener){
        documentReference.document(bookId).collection("TableOfContent").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    onDataCompleteListener.onComplete(task.getResult());
                }
            }
        });
    }
}
