import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class YearlyReport {
    FileReader reader = new FileReader();

    ArrayList<YearlyReportRecord> records = new ArrayList<>();

    public void add(YearlyReportRecord record) {
        records.add(record);
    }

    public void yearData() {
        String content = reader.readFileContentsOrNull("resources/y.2021.csv");
        String[] lines = content.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");

            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);


            YearlyReportRecord record = new YearlyReportRecord(month, amount, isExpense);
            add(record);

        }

    }
    public void getAverageExpense() {
        int averageExpense = 0;
        int sum = 0;
        int averageYearExpense = 0;

        for (YearlyReportRecord y : records) {
            if (y.isExpense) {
                sum += y.amount;
                averageExpense = sum / 3;
                averageYearExpense = sum / 12;
            }
        }
        System.out.println("Средний расход за отчетные месяцы в году: " + averageExpense);
        System.out.println("Средний расход за год: " + averageYearExpense);


    }
    public void getAverageProfit() {
        int averageProfit = 0;
        int sum = 0;
        int averageYearProfit = 0;
        for (YearlyReportRecord y : records) {
            if (!y.isExpense) {
                sum += y.amount;
                averageProfit = sum / 3;
                averageYearProfit = sum /12;
            }
        }
        System.out.println("Средний доход за отчетные месяцы в году: " + averageProfit);
        System.out.println("Средний доход  за год: " + averageYearProfit);

    }
    public HashMap<String, Integer[]> getProfit() {
        Integer[] profit = new Integer[2];
        HashMap<String, Integer[]> s = new HashMap<>();
        for (Month month : Month.values()) {
            for (YearlyReportRecord record : records) {
                if (record.month == month.getMonthNumber()) {
                    if (record.isExpense) {
                        profit[0] = record.amount;

                    } else  {
                        profit[1] = record.amount;

                    }
                    s.put(month.getMonthName(), profit);

                }

            }

        }
        return s;
    }
    public void profit(){
        HashMap<String, Integer[]> contentReport = getProfit();
        Set<String> keysMonth = contentReport.keySet();

        for(String month: keysMonth){
        Integer profit = contentReport.get(month)[1] - contentReport.get(month)[0];

            System.out.println("Месяц: " + month);
            System.out.println(String.format("Прибыль: %d", profit));

        }

    }

}
