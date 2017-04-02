// Jack Palmstrom       ccc username: jnpalmstrom

// Problem 2.4 - Step 4: Use Exceptions to Report Invalid or Lowered Rates

public class InvalidRateException extends Exception {

    public double oldRate;
    public double newRate;

    InvalidRateException() {}

}
