package com.bh.noteon.drawing;

public class Point {
    private float mX;
    private float mY;
    private boolean mCheck;
    private int mColor;

    private Point() {};

    private void setX(float x) {
        this.mX = x;
    }

    private void setY(float y) {
        this.mY = y;
    }

    private void setCheck(boolean check) {
        this.mCheck = check;
    }

    private void setColor(int color) {
        this.mColor = color;
    }

    public static class Builder {
        private Point mPoint;

        public Builder() {
            mPoint = new Point();
        }

        public void setX(float x) {
            mPoint.setX(x);
        }

        public void setY(float y) {
            mPoint.setY(y);
        }

        public void setCheck(boolean check) {
            mPoint.setCheck(check);
        }

        public void setColor(int color) {
            mPoint.setColor(color);
        }

        public Point build() {
            return mPoint;
        }
    }
}
