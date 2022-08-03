import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundWithPrecision(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundWithPrecision(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundWithPrecision(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = in.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        int period = in.nextInt();

        System.out.println("Выберите тип вклада, " +
                "1 - вклад с обычным процентом, " +
                "2 - вклад с капитализацией:");
        int action = in.nextInt();

        double calculatedAmount = 0;

        if (action == 1) {
            calculatedAmount = calculateSimplePercent(amount, 0.06, period);
        }
        else if (action == 2) {
            calculatedAmount = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + calculatedAmount);
    }
}
