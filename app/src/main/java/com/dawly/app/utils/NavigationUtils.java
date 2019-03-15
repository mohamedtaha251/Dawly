//package com.dawly.app.utils;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentTransaction;
//import io.anyline.examples.R;
//import io.anyline.examples.meterreadingprocesses.activities.CustomerActivity;
//import io.anyline.examples.meterreadingprocesses.fragments.WorkOrderFragment;
//import io.anyline.examples.model.Customer;
//import io.anyline.examples.model.Order;
//import io.anyline.examples.model.Reading;
//
///**
// * Created by lorena on 06.12.17.
// */
//
//public class NavigationUtils {
//
//    public static void goToOrders(Context context, Order order) {
//
//        FragmentTransaction transaction =  ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
//        transaction.setCustomAnimations(R.anim.activity_open_translate, R.anim.fade_out,R.anim.fade_in, R.anim.activity_close_translate);
//        Fragment workOrdersFragment = WorkOrderFragment.newInstance(order.getId());
//        transaction.replace(R.id.fragment_container, workOrdersFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
//
//    public static void goToEditCustomer(Context context, Customer customer){
//        Bundle b = new Bundle();
//        b.putParcelable("bundleCustomer", customer);
//
//        Intent intent = new Intent(context, CustomerActivity.class);
//        intent.putExtra(CustomerActivity.KEY_CUSTOMER, b);
//        context.startActivity(intent);
//
//    }
//
//    public static void goToCustomerSelfReading(Context context, Reading reading){
//        Bundle b = new Bundle();
//        b.putParcelable("bundleReading", reading);
//
//        Intent intent = new Intent(context, CustomerActivity.class);
//        intent.putExtra(CustomerActivity.KEY_READING, b);
//        context.startActivity(intent);
//    }
//}
