package lab2.logic.methods;

import lab2.logic.BinaryFunction;
import lab2.logic.LinearSystem;
import lab2.logic.LinearSystemSolver;
import lab2.logic.NonlinearSystem;
import lab2.logic.Vector;
import lombok.Getter;
import lombok.Setter;
import static lab2.logic.BinaryFunction.Utils.*;
import static java.lang.Math.*;
import lab2.exceptions.DivergeException;
public class NewtonMethod {
    public static final int MAX_ITERATIONS = 1000;
    @Getter @Setter
    private NonlinearSystem system;
    @Getter
    private LinearSystemSolver solver;
    @Getter @Setter
    private double x0;
    @Getter @Setter
    private double y0;
    @Setter @Getter
    private double accuracy;
    @Getter
    private Vector solution;
    @Getter
    private Vector errors;

    @Getter 
    int n;
    public NewtonMethod(){
        solver = new LinearSystemSolver();
    }
    public void solve(){
        BinaryFunction f1 = system.getFirst();
        BinaryFunction f2 = system.getSecond();
        BinaryFunction f1d_x = derivativeX(f1);
        BinaryFunction f1d_y = derivativeY(f1);
        BinaryFunction f2d_x = derivativeX(f2);
        BinaryFunction f2d_y = derivativeY(f2);
       

        double xn = x0;
        double yn = y0;
        n = 1;

        while (n < MAX_ITERATIONS) {

            solver.setSystem(LinearSystem.of(2, 
                f1d_x.call(xn, yn), f1d_y.call(xn, yn), -f1.call(xn, yn),
                f2d_x.call(xn, yn), f2d_y.call(xn, yn), -f2.call(xn, yn)
            ));
            solver.solve();


            solution = solver.getSolution();
            double xNext = xn + solution.get(0);
            double yNext = yn + solution.get(1);
            if ((Math.abs(solution.get(0)) < accuracy) && (Math.abs(solution.get(1)) < accuracy)) {
                solution.set(0,xNext);
                solution.set(1,yNext);
                errors = new Vector(2);
                errors.set(0, abs(xNext-xn));
                errors.set(1, abs(yNext-yn));
                return;
            }
            n++;
            xn = xNext;
            yn = yNext;
        }
        throw new DivergeException();

    }
}
