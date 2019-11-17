package cl.cehd.ocr.algorithm.entity;

public class AccountDigit {

    private final String line1;
    private final String line2;
    private final String line3;

    public AccountDigit(String line1, String line2, String line3) {

        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountDigit that = (AccountDigit) o;

        if (!line1.equals(that.line1)) return false;
        if (!line2.equals(that.line2)) return false;
        return line3.equals(that.line3);
    }

    @Override
    public int hashCode() {
        int result = line1.hashCode();
        result = 31 * result + line2.hashCode();
        result = 31 * result + line3.hashCode();
        return result;
    }

    public String recreateNumber() {
        return line1 + "\n" + line2 + "\n" + line3;
    }
}
