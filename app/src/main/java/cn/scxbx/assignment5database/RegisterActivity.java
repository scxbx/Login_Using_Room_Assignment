package cn.scxbx.assignment5database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegisterActivity extends AppCompatActivity {
    public static final String TAG = "RegisterActivity";
//    public static final int MALE = ""

    enum GENDER {
        MALE,
        FEMALE,
    }

    private EditText etRegisterAccount;
    private EditText etRegisterEmail;
    private EditText etRegisterPass;
    private EditText etRegisterPassRepeat;

    private RadioButton rbMale;
    private RadioButton rbFemale;
    private CheckBox cbAgree;
    private Button btnRegisterSubmit;


    private GENDER gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();

        btnRegisterSubmit.setOnClickListener(v -> {
            String account = etRegisterAccount.getText().toString();
            String email = etRegisterEmail.getText().toString();
            String password = etRegisterPass.getText().toString();
            String passwordRepeat = etRegisterPassRepeat.getText().toString();

            boolean isAgreed = cbAgree.isChecked();

            String outMsg = String.format("Register Info: %s %s %s %s %b %s",
                    account, email, password, passwordRepeat, isAgreed, gender);
            Log.d(TAG, "btnRegisterSubmit: " + outMsg);
        });

        rbMale.setOnClickListener(this::onRadioButtonClicked);
        rbFemale.setOnClickListener(this::onRadioButtonClicked);
    }

    private void initView() {
        etRegisterAccount = findViewById(R.id.etRegisterAccount);
        etRegisterEmail = findViewById(R.id.etRegisterEmail);
        etRegisterPass = findViewById(R.id.etRegisterPass);
        etRegisterPassRepeat = findViewById(R.id.etRegisterPassRepeat);

        cbAgree = findViewById(R.id.cbAgreement);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        btnRegisterSubmit = findViewById(R.id.btnRegisterSubmit);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        int id = view.getId();
        if (id == R.id.rbMale) {
            if (checked) {
                gender = GENDER.MALE;
            }
        } else if (id == R.id.rbFemale) {
            if (checked) {
                gender = GENDER.FEMALE;
            }
        } else {
            Log.d(TAG, "onRadioButtonClicked: checked a button with an id neither rbMale nor rbFemale");
        }
    }
}