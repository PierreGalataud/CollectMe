package com.example.collectme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class InscriptionActivity extends AppCompatActivity {

    private EditText et_mail, et_mdp;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        init();
    }

    public void init(){
        et_mail = findViewById(R.id.et_inscription_email);
        et_mdp = findViewById(R.id.et_inscription_motDePasse);
        mAuth = FirebaseAuth.getInstance();

    }

    public void onClickInscription(View view){
    //Log.d("testInscription","on passe bien dans la méthode onClickInscription");
        String mail = et_mail.getText().toString();
        String mdp = et_mdp.getText().toString();

        Log.d("testInscription",mail + " - " + mdp);

        insertUserFirebase(mail, mdp);
    }

    public void onClickGoToConnexion(View view) {
        String mail = et_mail.getText().toString();
        String mdp = et_mdp.getText().toString();


        Log.d("testInscription",mail + " - " + mdp);

        signIn(mail, mdp);
    }

    public void insertUserFirebase(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("testInscription", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("testInscription", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(InscriptionActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }

    public void updateUI(FirebaseUser user){
        if(user != null){
            Toast.makeText(this,R.string.inscription_reussite,Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,R.string.inscription_echec,Toast.LENGTH_LONG).show();
        }
    }

    public void signIn(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("testConnexion", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            connexionCheck(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("testConnexion", "signInWithEmail:failure", task.getException());
                            Toast.makeText(InscriptionActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            connexionCheck(null);
                        }
                    }
                });
    }
    public void connexionCheck(FirebaseUser user){
        if(user != null){
            Intent newIntent = new Intent(this, MainActivity.class);
            Toast.makeText(this,R.string.connexion_reussite,Toast.LENGTH_LONG).show();
            startActivity(newIntent);
            finish();
        } else {
            Toast.makeText(this,R.string.connexion_echec,Toast.LENGTH_LONG).show();
        }
    }
}