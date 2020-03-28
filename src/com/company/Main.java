package com.company;

import com.company.models.Top;
import com.company.models.Triangle;
import com.company.service.TriangleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        //creating triangles list
        ArrayList<Triangle> triangles= new ArrayList<>();
        triangles.add(new Triangle(new Top(1, 1), new Top(0, 0), new Top(1, 0))); // right and isosceles
        triangles.add(new Triangle(new Top(1, 1), new Top(1, 1), new Top(1, 0))); // nor exist
        triangles.add(new Triangle(new Top(-2, 0), new Top(0, Math.sqrt(12)), new Top(2, 0))); //isosceles and equilateral
        triangles.add(new Triangle(new Top(0, 0), new Top(0, 4), new Top(3, 0)));//right
        triangles.add(new Triangle(new Top(-1, 5), new Top(0, 0), new Top(3, 0)));//other

        //calling calculateSquareAndPerimeter method for each triangle in triangles list
        for (Triangle triangle:triangles) {
            triangle.calculateSquareAndPerimeter();
        }
        System.out.println(triangles);
        Map<String, Integer> typesCount= new HashMap<>();
        typesCount = TriangleService.countOfTrianglesAnyType(triangles);
        System.out.println(typesCount);
    }
}
