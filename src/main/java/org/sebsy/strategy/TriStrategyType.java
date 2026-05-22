package org.sebsy.strategy;

public enum TriStrategyType {
    BUBBLE(1),
    INSERTION(2),
    SELECTION(3);

    private final int code;

    TriStrategyType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TriStrategyType fromCode(int code) {
        for (TriStrategyType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Type de tri inconnu : " + code);
    }
}
