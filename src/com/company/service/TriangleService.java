package com.company.service;

import com.company.models.Triangle;

import java.util.ArrayList;
import java.util.HashMap;

public class TriangleService {
    //calculate sides for necessary triangle
    public static ArrayList<Double> calculateSides(Triangle triangle){
        double a = Math.sqrt(Math.pow(triangle.getA().getxCoordinate() - triangle.getB().getxCoordinate(), 2) + Math.pow(triangle.getA().getyCoordinate() - triangle.getB().getyCoordinate(), 2));
        double b = Math.sqrt(Math.pow(triangle.getA().getxCoordinate() - triangle.getC().getxCoordinate(), 2) + Math.pow(triangle.getA().getyCoordinate() - triangle.getC().getyCoordinate(), 2));
        double c = Math.sqrt(Math.pow(triangle.getC().getxCoordinate() - triangle.getB().getxCoordinate(), 2) + Math.pow(triangle.getC().getyCoordinate() - triangle.getB().getyCoordinate(), 2));
        ArrayList<Double> sides = new ArrayList<>();
        sides.add(a);
        sides.add(b);
        sides.add(c);
        return sides;
    }
    //this method returns map(key = type, value = number of triangles)
    public static HashMap<String, Integer> countOfTrianglesAnyType(ArrayList<Triangle> triangles){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("equilateral", 0);
        map.put("isosceles", 0);
        map.put("right", 0);
        map.put("other", 0);
        for (Triangle triangle:triangles) {
            if (triangle.isExist() == false)
                continue;
            double a, b, c;
            ArrayList<Double> sides = TriangleService.calculateSides(triangle);
            a = sides.get(0);
            b = sides.get(1);
            c = sides.get(2);
            double e = 10e-7;
            if(Math.abs(a - b) < e && Math.abs(b - c) < e){
                map.put("equilateral", map.get("equilateral") + 1);
                map.put("isosceles", map.get("isosceles") + 1);
                continue;
            }
            if((Math.abs(a*a - b*b + c*c) < e || Math.abs(a*a -c*c  + b*b) < e || Math.abs(b*b - a*a + c*c) < e)
                    && (Math.abs(a - b) < e || Math.abs(a-c) < e || Math.abs(c-b)< e)){
                map.put("right", map.get("right") + 1);
                map.put("isosceles", map.get("isosceles") + 1);
                continue;
            }
            if (Math.abs(a*a - b*b + c*c) < e || Math.abs(a*a -c*c  + b*b) < e || Math.abs(b*b - a*a + c*c) < e){
                map.put("right", map.get("right") + 1);
                continue;
            }
            if (Math.abs(a - b) < e || Math.abs(a-c) < e || Math.abs(c-b)< e){
                map.put("isosceles", map.get("isosceles") + 1);
                continue;
            }
            map.put("other", map.get("other") + 1);
        }
        return map;
    }
}
