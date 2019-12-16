package com.revell;

import java.util.Arrays;
import java.util.List;

//Creating an Interface
public interface Bike { public void start(); }
//Creating classes to implement Bike interface
class Honda implements Bike{
    public void start() { System.out.println("Honda Bike"); }
}

class Apache implements Bike{
    public void start() { System.out.println("Apache Bike"); }
}

class Suzuki implements Bike{
    public void start() { System.out.println("Suzuki Bike"); }
}

class Rider{
    public static void test(){
        //
        // create an array of Bike objects and then call their start() methods
        //
        Bike[] bikes = { new Honda(),new Apache(),new Suzuki() };
        for (Bike b : bikes){
            b.start();
        }
    }
}