package com.github.therealroguewarlock.dirtbud;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bumptech.glide.Glide;
import com.github.therealroguewarlock.dirtbud.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

	private AppBarConfiguration mAppBarConfiguration;
	private ActivityMainBinding binding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		binding = ActivityMainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());

		setSupportActionBar(binding.appBarMain.toolbar);

		Fragment navFragment = getSupportFragmentManager().getFragments().get(0);

		navigationUserDetails();

		binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Log.d("fab fragment", "the tag:" + navFragment.getChildFragmentManager().getFragments().get(0));
			}
		});

		DrawerLayout drawer = binding.drawerLayout;
		NavigationView navigationView = binding.navView;
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_profile, R.id.nav_activity, R.id.nav_dirt_bike_list, R.id.nav_inventory).setOpenableLayout(drawer)
		                                                                                                                                                       .build();
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
		NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
		NavigationUI.setupWithNavController(navigationView, navController);
	}

	private void navigationUserDetails() {
		// Navigation Drawer Views
		NavigationView navigationView = findViewById(R.id.nav_view);
		View headerView = navigationView.getHeaderView(0);
		TextView navUsername = headerView.findViewById(R.id.navUsername);
		TextView navEmail = headerView.findViewById(R.id.navMail);
		ImageView navImage = headerView.findViewById(R.id.navImage);

		// Getting the Firebase User
		FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
		assert user != null;

		// Set information for User
		String username = user.getDisplayName();
		String mail = user.getEmail();
		Uri imageURI = user.getPhotoUrl();

		Log.d("PFP", "Image URI: " + imageURI);

		navUsername.setText(username);
		navEmail.setText(mail);
		// Profile Picture
		String placeholderProfilePic = "https://cdn5.vectorstock.com/i/thumb-large/87/24/man-profile-vector-31988724.jpg";
		Glide.with(this).load(imageURI != null ? imageURI : placeholderProfilePic).into( navImage);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onSupportNavigateUp() {
		NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
		return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
	}
}
