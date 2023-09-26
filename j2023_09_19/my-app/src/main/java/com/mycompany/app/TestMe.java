// package c;
package com.mycompany.app;

public class TestMe {
        private double value = Double.NaN;

        public static void main(String[] args) {
                System.out.println("Hello world!");
        }

	public TestMe() {}
        public void setValue(double v) {
                value = v;
        }
        public double square() { return value*value; }
        public double addition() { return value + value;}
        public double subtraction() { return value - value;}
        public double division() { return value / value;} 
        



}
