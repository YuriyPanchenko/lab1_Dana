package com.company.models;

import com.company.service.TriangleService;

import java.util.ArrayList;

public class Triangle {
    private Top A;
    private Top B;
    private Top C;
    private boolean isExist;
    private double perimeter;
    private double square;

    public Triangle(Top a, Top b, Top c) {
        A = a;
        B = b;
        C = c;
    }

    public Top getA() {
        return A;
    }

    public void setA(Top a) {
        A = a;
    }

    public Top getB() {
        return B;
    }

    public void setB(Top b) {
        B = b;
    }

    public Top getC() {
        return C;
    }

    public void setC(Top c) {
        C = c;
    }

    public boolean isExist() {
        return isExist;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public String toString() {
        return "\nTriangle{" +
                "A" + A +
                ", B" + B +
                ", C" + C +
                ", isExist=" + isExist +
                ", perimeter=" + perimeter +
                ", square=" + square +
                '}';
    }
    // this method calculate all necessary params for this triangle
    public void calculateSquareAndPerimeter(){
        double a, b, c;
        ArrayList<Double> sides = TriangleService.calculateSides(this);
        a = sides.get(0);
        b = sides.get(1);
        c = sides.get(2);

        if(a >= b + c || b >= a + c || c >= a + b){
            this.isExist = false;
            return;
        }
        this.isExist = true;
        this.perimeter = a + b + c;
        double p = this.perimeter/2;
        this.square = Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
}
