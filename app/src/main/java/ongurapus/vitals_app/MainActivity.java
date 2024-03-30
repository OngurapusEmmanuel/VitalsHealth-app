package ongurapus.vitals_app;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerlayout);
        navigationView=findViewById(R.id.navview);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.home:
                    {
                        Toast.makeText(MainActivity.this, "Main activity selected", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.contact:
                    {
                        Toast.makeText(MainActivity.this, "Contact activity selected", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.settings:
                    {
                        Toast.makeText(MainActivity.this, "Settings activity selected", Toast.LENGTH_SHORT).show();

                    }
                    case R.id.about:
                    {
                        Toast.makeText(MainActivity.this, "About activity selected", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.updateprofile:
                    {
                        Toast.makeText(MainActivity.this, "Update profile activity selected", Toast.LENGTH_SHORT).show();

                    }
                    case R.id.logout:
                    {
                        Toast.makeText(MainActivity.this, "Logout activity selected", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.rate:
                    {
                        Toast.makeText(MainActivity.this, "Rating activity selected", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.share:
                    {

                        Toast.makeText(MainActivity.this, "Share activity selected", Toast.LENGTH_SHORT).show();
                    }

                }
                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
