import java.util.ArrayList;

public class MonthlyReport {
    FileReader reader = new FileReader();
    ArrayList<MonthlyReportRecord> records = new ArrayList<>();



    public void monthData() {
    for (int m = 1; m < 3; m++) {
    String content = reader.readFileContentsOrNull("resources/m.20210" + m + ".csv");
    String[] lines = content.split("\n");
    for (int i = 1; i < lines.length; i++) {
        String line = lines[i];
        String[] parts = line.split(",");

        String itemName = parts[0];
        boolean isExpense = Boolean.parseBoolean(parts[1]);
        int quantity = Integer.parseInt(parts[2]);
        int sumOfOne = Integer.parseInt(parts[3]);

        MonthlyReportRecord record = new MonthlyReportRecord(itemName, isExpense, quantity, sumOfOne);
        records.add(record);

    }
    }
    }


    private Integer sum(Integer count, Integer cost){
        return count * cost;
    }
    public void monthStatistic() {

        for (Month month : Month.values()) {

            System.out.println("Месяц - " + month.getMonthName());
            //monthReport("resources/m.20210" + month.getMonthNumber() + ".csv");
            month("resources/m.20210" + month.getMonthNumber() + ".csv");

        }
    }
    public void monthReport(String path) {
        String content = reader.readFileContentsOrNull(path);
        String[] lines = content.split("\n");
        String profitName = null;
        int profit= 0;
        String expenseName = null;
        int expenses = 0;

        for (int i = 1; i < lines.length; i++) {

            String[] lineContents = lines[i].split(",");

            if (lineContents[1].equals("TRUE")) {
                Integer sum = sum(Integer.parseInt(lineContents[2]), Integer.parseInt(lineContents[3]));
                if (sum > expenses) {
                    expenses = sum;
                    expenseName = lineContents[0];
                }
            } else if (lineContents[1].equals("FALSE")) {
                Integer sum = sum(Integer.parseInt(lineContents[2]), Integer.parseInt(lineContents[3]));
                if (sum > profit) {
                    profit= sum;
                    profitName = lineContents[0];
                }
            }

        }

        System.out.println(String.format("Самый прибыльный товар: '%s' сумма прибыли %d", profitName, profit));
        System.out.println(String.format("Самая большая трата: '%s' на сумму %d", expenseName, expenses));

    }
    public void month(String path) {
        String profitName = null;
        int profit= 0;
        String expenseName = null;
        int expenses = 0;

        for(MonthlyReportRecord month: records){

            if (month.isExpense) {
                Integer sum = month.sumOfOne * month.quantity;
                if (sum > expenses) {
                    expenses = sum;
                    expenseName = month.itemName;
                }
            } else if (!month.isExpense) {
                Integer sum = month.sumOfOne * month.quantity;
                if (sum > profit) {
                    profit= sum;
                    profitName = month.itemName;
                }
            }

        }

        System.out.println(String.format("Самый прибыльный товар: '%s' сумма прибыли %d", profitName, profit));
        System.out.println(String.format("Самая большая трата: '%s' на сумму %d", expenseName, expenses));

    }

}