package vn.edu.stu.book_library;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import vn.edu.stu.book_library.list.BookActivity;
import vn.edu.stu.book_library.list.TypeActivity;

public class AboutActivity extends AppCompatActivity implements OnMapReadyCallback {
    TextView txtAction, aboutPhone;
    private static final int Request_call =1;
    GoogleMap gMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        aboutPhone = findViewById(R.id.aboutPhone);



         SupportMapFragment supportMapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);




        addEvents();

    }

    private void addEvents() {
        aboutPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }







 @Override
    public void onMapReady(GoogleMap googleMap) {


        gMap = googleMap;
        LatLng DHCNSG = new LatLng(10.7380096287,106.677825451);
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(DHCNSG,13));
        gMap.addMarker(new MarkerOptions().position(DHCNSG).title("Đại học công nghệ Sài Gòn"));


    }

    String name = "Cao Chiến Hào";
    String id = "DH51804107";
    String cl = "D18_TH11";
    String phone = "0948230620";
    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(phone));
    String email = "haocaochien@gmail.com";

    private View.OnClickListener next = new View.OnClickListener() {

        public void onClick(View v) {
            TextView num=(TextView)findViewById(R.id.aboutPhone);
            String phone = "tel:" + aboutPhone.getText().toString().trim();
            Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(phone));
            startActivity(callIntent);
        }
    };










}