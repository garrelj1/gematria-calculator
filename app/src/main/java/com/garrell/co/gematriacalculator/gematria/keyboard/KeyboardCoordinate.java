package com.garrell.co.gematriacalculator.gematria.keyboard;

import java.util.Objects;

public class KeyboardCoordinate {

    public final int row;
    public final int column;

    public KeyboardCoordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyboardCoordinate that = (KeyboardCoordinate) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
