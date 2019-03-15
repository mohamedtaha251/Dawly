package com.dawly.app.screens.scan.scanviewresult;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import app.dawly.com.dawly.R;
import at.nineyards.anyline.modules.AnylineBaseModuleView;
import com.dawly.app.screens.scan.ScanModuleEnum;
import com.dawly.app.screens.scan.ScanningConfigurationActivity;
import com.dawly.app.utils.BitmapUtil;
import com.dawly.app.utils.Constant;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Scan Vew Result Activity for the Result Screen
 */

public class ScanViewResultActivity extends ScanningConfigurationActivity {

    private String scanModule;
    private HashMap<String, String> result;
    private ScanViewResultAdapter scanResultAdapter;
    private RecyclerView recyclerView;
    private ImageView imageView;
    private TextView confirmationButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_no_menu);
        getLayoutInflater().inflate(R.layout.activity_result_scan_view, (ViewGroup) findViewById(R.id.placeholder));
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        imageView = (ImageView) findViewById(R.id.controll_image);
        confirmationButton = (TextView) findViewById(R.id.confirmation_button);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            result= (HashMap<String, String>) intent.getSerializableExtra(Constant.SCAN_RESULT_DATA);

            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                scanModule = extras.getString(Constant.SCAN_MODULE, "").trim();

                Bitmap bmp =  BitmapUtil.getBitmap(extras.getString(Constant.SCAN_FULL_PICTURE_PATH));
                imageView.setImageBitmap(bmp);
            }
        } else {
            scanModule = savedInstanceState.getString(Constant.SCAN_MODULE);
        }


        setupScanResultView();
        recyclerView.setAdapter(scanResultAdapter);
        confirmationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();

            }
        });
        setupScanResult();
    }

    @Override
    protected AnylineBaseModuleView getScanView() {
        return null;
    }

    @Override
    protected ScanModuleEnum.ScanModule getScanModule() {
        return null;
    }

    private void setupScanResultView(){
        if(scanModule.equals(getResources().getString(R.string.title_mrz))){

            //for the specific insertion order it is needed a linkedHashMap reconstruct here
            //android transform via bundle transfer the linkedHashMap into a Hashmap
            LinkedHashMap<String, String> orderedHashMap = new LinkedHashMap();

            orderedHashMap.put(getResources().getString(R.string.mrz_given_names), result.get(getResources().getString(R.string.mrz_given_names)));
            orderedHashMap.put(getResources().getString(R.string.mrz_sur_names), result.get(getResources().getString(R.string.mrz_sur_names)));
            orderedHashMap.put(getResources().getString(R.string.mrz_sex), result.get(getResources().getString(R.string.mrz_sex)));
            orderedHashMap.put(getResources().getString(R.string.mrz_date_of_birthday), result.get(getResources().getString(R.string.mrz_date_of_birthday)));
            orderedHashMap.put(getResources().getString(R.string.mrz_document_type), result.get(getResources().getString(R.string.mrz_document_type)));
            orderedHashMap.put(getResources().getString(R.string.mrz_document_number), result.get(getResources().getString(R.string.mrz_document_number)));
            orderedHashMap.put(getResources().getString(R.string.mrz_expiration_date), result.get(getResources().getString(R.string.mrz_expiration_date)));
            orderedHashMap.put(getResources().getString(R.string.mrz_country_code), result.get(getResources().getString(R.string.mrz_country_code)));
            if(result.get(getResources().getString(R.string.mrz_address)) != null) {
                orderedHashMap.put(getResources().getString(R.string.mrz_address), result.get(getResources().getString(R.string.mrz_address)));
            }
            if(result.get(getResources().getString(R.string.issue_date)) != null){
                orderedHashMap.put(getResources().getString(R.string.issue_date), result.get(getResources().getString(R.string.issue_date)));
            }
            if(result.get(getResources().getString(R.string.personal_number)) != null) {
                orderedHashMap.put(getResources().getString(R.string.personal_number), result.get(getResources().getString(R.string.personal_number)));
            }
            scanResultAdapter = new ScanViewResultAdapter(this.getBaseContext(), orderedHashMap);

        }else if(scanModule.equals(getResources().getString(R.string.title_driving_license))){
            LinkedHashMap<String, String> orderedHashMapDrivingLicense = new LinkedHashMap();

            orderedHashMapDrivingLicense.put(getResources().getString(R.string.driving_license_sur_names), result.get(getResources().getString(R.string.driving_license_sur_names)));
            orderedHashMapDrivingLicense.put(getResources().getString(R.string.driving_license_given_names), result.get(getResources().getString(R.string.driving_license_given_names)));
            orderedHashMapDrivingLicense.put(getResources().getString(R.string.driving_license_DOB), result.get(getResources().getString(R.string.driving_license_DOB)));
            orderedHashMapDrivingLicense.put(getResources().getString(R.string.driving_license_document_code), result.get(getResources().getString(R.string.driving_license_document_code)));
            orderedHashMapDrivingLicense.put(getResources().getString(R.string.driving_license_authority), result.get(getResources().getString(R.string.driving_license_authority)));
            orderedHashMapDrivingLicense.put(getResources().getString(R.string.driving_license_expiring_date), result.get(getResources().getString(R.string.driving_license_expiring_date)));
            orderedHashMapDrivingLicense.put(getResources().getString(R.string.driving_license_issuing_date), result.get(getResources().getString(R.string.driving_license_issuing_date)));
            orderedHashMapDrivingLicense.put(getResources().getString(R.string.driving_license_categories), result.get(getResources().getString(R.string.driving_license_categories)));
            orderedHashMapDrivingLicense.put(getResources().getString(R.string.driving_license_POB), result.get(getResources().getString(R.string.driving_license_POB)));

            scanResultAdapter = new ScanViewResultAdapter(this.getBaseContext(), orderedHashMapDrivingLicense);

        }else if(scanModule.equals(getResources().getString(R.string.category_energy))){
            LinkedHashMap<String, String> orderedHashMapEnergy = new LinkedHashMap();

            orderedHashMapEnergy.put(getResources().getString(R.string.reading_result), result.get(getResources().getString(R.string.reading_result)));
            orderedHashMapEnergy.put(getResources().getString(R.string.barcode), result.get(getResources().getString(R.string.barcode)));

            scanResultAdapter = new ScanViewResultAdapter(this.getBaseContext(), orderedHashMapEnergy);
        }
        else{

            scanResultAdapter = new ScanViewResultAdapter(this.getBaseContext(), result);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.activity_close_translate);
    }

}