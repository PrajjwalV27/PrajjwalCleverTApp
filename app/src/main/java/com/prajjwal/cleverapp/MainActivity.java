package com.prajjwal.cleverapp;

        // Enable Debugging

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import androidx.appcompat.app.AppCompatActivity;
        import com.clevertap.android.sdk.CleverTapAPI;

        import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public CleverTapAPI cleverTapAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cleverTapAPI = CleverTapAPI.getDefaultInstance(getApplicationContext());
        CleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
        // Track "Product Viewed" event
        if (cleverTapAPI != null) {
            cleverTapAPI.pushEvent("Product Viewed");
        }

        // UI elements
        EditText nameInput = findViewById(R.id.nameInput);
        EditText emailInput = findViewById(R.id.emailInput);
        Button loginButton = findViewById(R.id.loginButton);
        Button testButton = findViewById(R.id.testButton);

        // Login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                String email = emailInput.getText().toString();

                // Login the user
                if (cleverTapAPI != null) {
                    HashMap<String, Object> userProfile = new HashMap<>();
                    userProfile.put("Name", name);
                    userProfile.put("Email", email);
                    cleverTapAPI.onUserLogin(userProfile);

                    // Clear the input fields after successful API call
                    nameInput.setText("");
                    emailInput.setText("");
                }
            }
        });

        // Test button click listener
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cleverTapAPI != null) {
                    cleverTapAPI.pushEvent("TEST");
                }
            }
        });
    }

    public CleverTapAPI getCleverTapAPI() {
        return cleverTapAPI;


    }
}

