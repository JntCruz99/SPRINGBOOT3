package br.com.farmaciaideal.FarmaciaIdeal.entities.enums;

public enum CarrinhoStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private CarrinhoStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public static CarrinhoStatus valueOf(int code) {
        for (CarrinhoStatus value : CarrinhoStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
