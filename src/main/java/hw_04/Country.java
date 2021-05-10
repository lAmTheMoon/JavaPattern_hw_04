package hw_04;

public enum Country {
    RUSSIA("Россия"),
    INDIA("Индия"),
    BELARUS("Белоруссия"),
    THAILAND("Таиланд"),
    CHINA("Китай"),
    TURKEY("Турция");

    private final String value;

    Country(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
