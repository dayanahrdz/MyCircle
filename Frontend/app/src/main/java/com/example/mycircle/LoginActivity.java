package com.example.mycircle;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText emailField, passwordField;
    private Button loginButton;
    private TextView createAccountLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);
        loginButton = findViewById(R.id.login_button);
        createAccountLink = findViewById(R.id.create_account_link);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(LoginActivity.this, "Please enter valid email", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if the account exists
                    if (accountExists(email)) {
                        // Perform login
                        performLogin(email, password);
                    } else {
                        // Account doesn't exist, show dialog to create account
                        showCreateAccountDialog(email, password);
                    }
                }
            }

            private boolean accountExists(String email) {
                // TODO: Implement account existence check
                // This should query your backend or local database to check if the account exists
                return false; // Placeholder return value
            }

            private void performLogin(String email, String password) {
                // TODO: Implement actual login logic
                // For now, we'll just navigate to the dashboard
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            }

            private void showCreateAccountDialog(final String email, final String password) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Account Not Found")
                        .setMessage("Would you like to create a new account?")
                        .setPositiveButton("Create Account", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // TODO: Implement account creation logic
                                Toast.makeText(LoginActivity.this, "Creating account...", Toast.LENGTH_SHORT).show();
                                // After creating account, you might want to log the user in or navigate to a registration page
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        createAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }



}
