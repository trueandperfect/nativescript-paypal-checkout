package com.yourcompany.paypal;

import android.app.Activity;
import android.content.Intent;
import com.paypal.checkout.PayPalCheckout;
import com.paypal.checkout.Order;
import com.paypal.checkout.Payment;
import com.paypal.checkout.PayPalException;
import org.nativescript.plugins.NativeScriptActivity;
import org.nativescript.plugins.NativeScriptActivityResultCallback;

public class PaypalCheckout {

    private static final int PAYPAL_REQUEST_CODE = 12345;
    private Activity activity;

    public PaypalCheckout(Activity activity) {
        this.activity = activity;
    }

    // Initialize PayPal SDK
    public void initialize(String clientId, String environment) {
        PayPalCheckout.setEnvironment(environment);
        PayPalCheckout.setClientId(clientId);
    }

    // Start payment flow
    public void startPayment(double amount, String currencyCode) {
        Order order = new Order();
        order.setAmount(amount);
        order.setCurrencyCode(currencyCode);

        Payment payment = new Payment(order);

        PayPalCheckout.createOrder(payment, new PayPalCheckout.OrderCallback() {
            @Override
            public void onSuccess(Payment payment) {
                // Payment success
                // Notify the NativeScript app
                // You could use a callback to the JS side or send a custom event
            }

            @Override
            public void onFailure(PayPalException exception) {
                // Payment failure
            }
        });
    }

    // Handle the payment result
    public void handleActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PAYPAL_REQUEST_CODE) {
            // Handle PayPal response here
        }
    }
}
