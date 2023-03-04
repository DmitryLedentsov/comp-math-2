package lab2.logic.methods;

import lab2.logic.BinaryFunction;
import lab2.logic.LinearSystem;
import lab2.logic.LinearSystemSolver;
import lab2.logic.NonlinearSystem;
import lombok.Getter;
import lombok.Setter;
import static lab2.logic.BinaryFunction.Utils.*;
public class NewtonMethod {
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
    private double[] solution;
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
        int iter = 0;

        while (iter < 1000) {
            double[][] matrix = new double[][]{
                    {f1d_x.call(xn, yn), f1d_y.call(xn, yn), -f1.call(xn, yn)},
                    {f2d_x.call(xn, yn), f2d_y.call(xn, yn), -f2.call(xn, yn)}
            };

            solver.setSystem(LinearSystem.of(2, 
                f1d_x.call(xn, yn), f1d_y.call(xn, yn), -f1.call(xn, yn),
                f2d_x.call(xn, yn), f2d_y.call(xn, yn), -f2.call(xn, yn)
            ));
            solver.solve();


            solution = solver.getSolution().getData();
            double xNext = xn + solution[0];
            double yNext = yn + solution[1];
            if ((Math.abs(solution[0]) < accuracy) && (Math.abs(solution[1]) < accuracy)) {
                solution[0] = xNext;
                solution[1] = yNext;
                return;
            }
            iter++;
            xn = xNext;
            yn = yNext;
        }

    }
}
