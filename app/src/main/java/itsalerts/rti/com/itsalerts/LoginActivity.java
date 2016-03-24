package itsalerts.rti.com.itsalerts;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.common.io.ByteStreams;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import itsalerts.rti.com.itsalerts.itsalerts.rti.com.itsalerts.network.HTTPConnection;

public class LoginActivity extends AppCompatActivity {

    EditText et_username, et_password;
    Button btn_submit;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = (EditText) findViewById(R.id.username);
        et_password = (EditText) findViewById(R.id.password);
        btn_submit = (Button) findViewById(R.id.submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }

    private void sendRequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                sendSoapRequest();
            }
        }).start();

    }

    private void sendSoapRequest() {
        try {
            URL url = new URL("https://www.americanexpress.com/in/");
            HttpURLConnection urlConnection = HTTPConnection.getHttpURLConnection(url);
            InputStream in = urlConnection.getInputStream();
            System.out.println("Response:: "+new String(ByteStreams.toByteArray(in)));
        }catch (IOException e){
            e.printStackTrace();
        }
    }



}
