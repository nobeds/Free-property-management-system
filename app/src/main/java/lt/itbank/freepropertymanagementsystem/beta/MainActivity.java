package lt.itbank.freepropertymanagementsystem.beta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.content.Context;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
        {
            WebView myWebView = findViewById(R.id.webview);
            myWebView.getSettings().setJavaScriptEnabled(true);
            myWebView.getSettings().setSavePassword(true);
            myWebView.getSettings().setSaveFormData(true);
            myWebView.getSettings().setDomStorageEnabled(true);
            myWebView.setWebViewClient(new WebViewClient());
            myWebView.loadUrl("https://app.nobeds.com");
        }
        else {
            Toast.makeText(MainActivity.this, "Error, pls check your internet connection and try again!", Toast.LENGTH_LONG).show();
        }



    }
}
