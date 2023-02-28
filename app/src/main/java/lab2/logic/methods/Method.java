package lab2.logic.methods;

import lab2.logic.Function;

public interface Method {
    void setA(double a);
    void setB(double b);
    void setAccuracy(double accuracy);
    void setFunction(Function function);
    void solve();
    double getX();
    Status getStatus();
    enum Status {
        OK, NOT_CONVERGED, NOT_FOUND
    }
}
