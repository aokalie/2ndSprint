public enum Month {
    JANUARY("Январь", 01),
    FEBRUARY("Февраль", 02),
    MARCH("Март", 03);

    private String monthName;
    private int monthNumber;

    Month(String monthName, int monthNumber) {
        this.monthName = monthName;
        this.monthNumber = monthNumber;
    }
    public String getMonthName() {
        return monthName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    @Override
    public String toString() {
        return "Month{" +
                "monthName='" + monthName + '\'' +
                ", monthNumber=" + monthNumber +
                '}';
    }
}
