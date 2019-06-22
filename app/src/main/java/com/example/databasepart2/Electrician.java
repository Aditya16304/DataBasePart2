package com.example.databasepart2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Electrician extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Model> models;
    Adapter adapter;
    CollectionReference firebaseFirestore;
    FirebaseAuth firebaseAuth;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician);

        firebaseAuth=FirebaseAuth.getInstance();

        cardView=findViewById(R.id.cardView);

        models=new ArrayList<Model>();
        //firebaseFirestore=FirebaseFirestore.getInstance().collection(firebaseAuth.getCurrentUser().getEmail());
        setupRecyclerView();
        if (firebaseAuth.getCurrentUser()!=null){
            loadData();
        }
        else {
            Toast.makeText(this, "No active User!!!", Toast.LENGTH_SHORT).show();
        }
    }
    private void loadData() {
        firebaseFirestore
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        Toast.makeText(Electrician.this, "Success", Toast.LENGTH_SHORT).show();
                        for (DocumentSnapshot documentSnapshot:task.getResult()){
                            Model model=new Model(documentSnapshot.getString("roomDetail"),
                                    documentSnapshot.getString("complaint")
                                    ,documentSnapshot.getLong("otp"));
                            models.add(model);
                        }
                        adapter=new Adapter(getApplicationContext(),models);
                        recyclerView.setAdapter(adapter);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Electrician.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
