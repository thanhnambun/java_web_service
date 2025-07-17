package java.ra.ss7.entity;


import java.util.Map;

public interface Statistical {
    int countRemainingSeeds();
    double totalHarvestMoneyThisMonth();
    double totalPaymentSlipsThisMonth();
    Map<String, Double> profitLossOverYear();
    double totalWorkerSalaryThisMonth();
}