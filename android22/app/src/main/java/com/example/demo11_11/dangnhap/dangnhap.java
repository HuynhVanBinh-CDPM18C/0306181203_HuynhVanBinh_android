package com.example.demo11_11.dangnhap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


//facebook
import com.example.demo11_11.MainActivity;
import com.example.demo11_11.dangky.DangKi;
import com.example.demo11_11.taikhoanvb;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.example.demo11_11.R;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

public class dangnhap extends AppCompatActivity {

    EditText edtuser,edtpassword;
    Button btndangnhap;


    private static final String TAG = dangnhap.class.getSimpleName();
    CallbackManager callbackManager;
    LoginButton fbLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        Anhxa();
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();

        fbLoginButton = (LoginButton) findViewById(R.id.login_button);
        //https://developers.facebook.com/docs/facebook-login/permissions#reference
        fbLoginButton.setReadPermissions("email");

        fbLoginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "======Facebook login success======");
                Log.d(TAG, "Facebook Access Token: " + loginResult.getAccessToken().getToken());
                Toast.makeText(dangnhap.this, "Login Facebook success.", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(dangnhap.this, MainActivity.class);
                startActivity(intent);
                getFbInfo();
            }

            @Override
            public void onCancel() {
                Toast.makeText(dangnhap.this, "Login Facebook cancelled.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Log.e(TAG, "======Facebook login error======");
                Log.e(TAG, "Error: " + error.toString());
                Toast.makeText(dangnhap.this, "Login Facebook error.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Anhxa() {
        edtuser=findViewById(R.id.edittextuser);
        edtpassword=findViewById(R.id.edittextpassword);
        btndangnhap=findViewById(R.id.btndangnhap);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void getFbInfo() {
        if (AccessToken.getCurrentAccessToken() != null) {
            GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(final JSONObject me, GraphResponse response) {
                            if (me != null) {
                                Log.i("Login: ", me.optString("name"));
                                Log.i("ID: ", me.optString("id"));

                                Toast.makeText(dangnhap.this, "Name: " + me.optString("name"), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,link");
            request.setParameters(parameters);
            request.executeAsync();
        }
    }

    public void dangnhaps(View view) {
        if(edtuser.getText().length()!=0 && edtpassword.getText().length()!=0)
        {
            if(edtuser.getText().toString().equals("binh")&&edtpassword.getText().toString().equals("binh")){
                Toast.makeText(dangnhap.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(dangnhap.this, MainActivity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(dangnhap.this,"Đăng nhập Thất Bại",Toast.LENGTH_SHORT).show();
            }
        }else
        {
            Toast.makeText(dangnhap.this,"Nội dung không được để trống",Toast.LENGTH_SHORT).show();
        }
    }
}