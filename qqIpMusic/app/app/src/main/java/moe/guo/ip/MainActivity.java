package moe.guo.ip;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings; 
import android.webkit.WebView;
import android.util.DisplayMetrics;

public class MainActivity extends Activity {
    private WebView webView;
    protected void onCreate(Bundle savedInsutanceState)
    {
        super.onCreate(savedInsutanceState);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                                      | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(0);
        setContentView(R.layout.main);
        webView = (WebView) findViewById(R.id.webView); 
        WebSettings settings = webView.getSettings(); 
        settings.setJavaScriptEnabled(true);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setDomStorageEnabled(true); 
        String ua = settings.getUserAgentString();
        settings.setUserAgentString(ua+" MoeGuo/11");
        float statusBarHeight = -1;  
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");  
        if (resourceId > 0) {    
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);  
        }  
        DisplayMetrics dm = new DisplayMetrics();  
        dm = getResources().getDisplayMetrics();  
        float density  = dm.density;
        statusBarHeight = statusBarHeight/density;
        webView.loadUrl("https://ip.guo.moe/index1.php?ver=11&statusBarHeight="+ String.valueOf(statusBarHeight));
    }
}
