declare var com: any;

export class PaypalCheckout {
  private paypalCheckout: any;

  constructor() {
    this.paypalCheckout = new com.yourcompany.paypal.PaypalCheckout();
  }

  initialize(clientId: string, environment: string) {
    this.paypalCheckout.initialize(clientId, environment);
  }

  startPayment(amount: number, currencyCode: string) {
    this.paypalCheckout.startPayment(amount, currencyCode);
  }

  handleActivityResult(requestCode: number, resultCode: number, data: any) {
    this.paypalCheckout.handleActivityResult(requestCode, resultCode, data);
  }
}
