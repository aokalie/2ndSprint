import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader reader = new FileReader();
        MonthlyReport monthlyReport = new MonthlyReport();
        int m =0;

        //monthlyReport.contentReport();
        YearlyReport yearlyReport = new YearlyReport();
        yearlyReport.yearData();
        yearlyReport.getProfit();



        while (true) {
            printMenu();

            int command = scanner.nextInt();


            if (command == 1) {

                System.out.println("За какой месяц хотите получить данные? - Январь - 01, Февраль - 02, Март - 03");
                command = scanner.nextInt();
                if (command == 01) {

                    System.out.println(reader.readFileContentsOrNull("resources/m.202101.csv"));

                }else if(command == 02){
                    System.out.println(reader.readFileContentsOrNull("resources/m.202102.csv"));
                }else if (command == 03){
                    System.out.println(reader.readFileContentsOrNull("resources/m.202103.csv"));
                }


            } else if (command == 2) {
                System.out.println( reader.readFileContentsOrNull("resources/y.2021.csv"));
            } else if (command == 3) {

            } else if (command == 4) {
                monthlyReport.monthData();
                monthlyReport.monthStatistic();

            } else if (command == 5) {
                yearlyReport.profit();
                yearlyReport.getAverageProfit();
                yearlyReport.getAverageExpense();


            } else if (command == 555) {
                System.out.println("Выход из программы");
                break;

            } else {
                System.out.println("Извините, такой команды пока нет.");

            }
        }



    }

    public static void printMenu(){
        System.out.println("Что вы хотите сделать ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("555 - выйти из программы ");
    }

}
