package com.company;
//The position function is a formula for finding distance from an object to the ground when the object is thrown
// or dropped from an elevation
//When distance is in feet: s(t) = -16t^2 + V + S
//When distance is in meters: s(t) = -4.9t^2 + V + S
//-16 and -4.9 are the force of gravity in fps or mps
//t =time; V = initial velocity; S = initial position

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int S;
    static int V;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter input in f/s");
        System.out.println("The formula is -16t^2 + V + S");
        System.out.println("Please enter V and S");
        S = Integer.parseInt(String.valueOf(scan.nextInt()));
        V = Integer.parseInt(String.valueOf(scan.nextInt()));

        double xPoint = findVertex()[0];
        System.out.println("The vertex is at " + Arrays.toString(new double[]{findVertex()[0]}) + " on the X-axis and at "
                + Arrays.toString(new double[]{findVertex()[1]}) + " on the Y-axis");

        System.out.println("The x-intercept is at " + findTimeAtImpact());
    }

    private static double[] findVertex(){
        //h = -b/2a k = a(h)^2 + b(h) + c
        double h = -V / (-32);
        double k = (-16 * Math.pow(h, 2) + (V * h) + S);
        double[] hk= new double[]{h, k};
        return hk;
    }

    public static double findTimeAtImpact(){
        double posT = (-16 + Math.sqrt(Math.pow(V, 2) - (4 * -16 * S)));
        double negT = (-16 - Math.sqrt(Math.pow(V, 2) - (4 * -16 * S)));

        if (posT > 0){
            return posT;
        }
        else{
            return negT;
        }
    }


}
