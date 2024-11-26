package com.yourcompany.app;

import android.app.Activity;
import android.content.Intent;
import com.paypal.checkout.PayPalCheckout;
import com.paypal.checkout.Order;
import com.paypal.checkout.Payment;
import com.paypal.checkout.PayPalException;
import org.nativescript.plugins.NativeScriptActivity;

public class MainActivity extends NativeScriptActivity {
    private PaypalCheckout paypalCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Initialize the PayPal Checkout instance
        paypalCheckout = new PaypalCheckout(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        // Pass the result to the PayPal checkout to handle
        if (paypalCheckout != null) {
            paypalCheckout.handleActivityResult(requestCode, resultCode, data);
        }
    }
}
