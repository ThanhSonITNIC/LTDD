package com.thanhsonitnic.ungdungdocsach.models;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnBookResultListener;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnDataCompleteListener;
import com.thanhsonitnic.ungdungdocsach.interfaces.OnDocumentSnapshotCompleteListener;

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

    /**
     * List book document
     * @param onDataCompleteListener
     */
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

    /**
     * Get book by id
     * @param bookId
     * @param onDocumentSnapshotCompleteListener
     */
    public void getBook(final String bookId, final OnDocumentSnapshotCompleteListener onDocumentSnapshotCompleteListener){
        documentReference.document(bookId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    onDocumentSnapshotCompleteListener.onComplete(task.getResult());
                }
            }
        });
    }

    /**
     * Get table of content
     * @param bookId
     * @param onDataCompleteListener
     */
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
