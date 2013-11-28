package hejunbiz.ruiyi_weibo;

import hejunbiz.ruiyi_weibo.util.Tools;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button singleLogin = (Button) this.findViewById(R.id.single_login);
		Button generalLogin = (Button) this.findViewById(R.id.general_login);
		ImageView image = (ImageView) this.findViewById(R.id.loadImage);
		AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);
		animation.setDuration(5000);
		image.setAnimation(animation);
		animation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationStart(Animation arg0) {
				// TODO Auto-generated method stub
				String networkIsConnected = "网络可用";
				Boolean networkStatus = Tools
						.checkNetworkStatus(MainActivity.this);
				if (!networkStatus) {
					Tools.jumpToNetworkSettings(MainActivity.this);
				} else {
					Toast.makeText(MainActivity.this, networkIsConnected,
							Toast.LENGTH_LONG).show();
				}
			}

		});
		// 单点登录
		singleLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "单点登录",
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(MainActivity.this,Main.class);
				startActivity(intent);
				finish();
			}
		});
		// 普通登录
		generalLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "普通登录",
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(MainActivity.this,Main.class);
				startActivity(intent);
				finish();
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
