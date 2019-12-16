package com.revell;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

class Test {
    /** private members - encapsulation */
    private String name;
    private boolean tested = false;

    /** Constructor */
    public Test(String name) {
        this.name = name;
    }

    /** Getters & setters */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isTested() {
        return tested;
    }
    public void setTested(boolean tested) {
        this.tested = tested;
    }
}

/** This class extends the Test class and so inherits its methods and members */
class TestTool extends Test {
    /** These are TestTool class specific members */
    private int result = 0;
    private boolean executed;

    /** Constructor - calls the base/super class constructor to initialize this object
     * then initializes a subclass member - executed */
    TestTool(){
        super("Testing Tool");
        this.executed = false;
    }
    /** Getters & setters */
    public int getResult() {
        return result;
    }
    public boolean isExecuted() {
        return executed;
    }
    public void setResult(int result) {
        this.result = result;
        this.executed = true;
    }
}


/** Compile time method invocation example */
class compileTimePolymorphism {
    @Contract(pure = true)
    /** method overloading (int,int) , (double,double) & (String,String) which Java will resolve
     * at compile time */
    public static int add(int a, int b ){
        return a+b;
    }
    @Contract(pure = true)
    public static double add(double a, double b){
        return a+b;
    }
    @NotNull
    @Contract(pure = true)
    public static String add(String a, String b){
        return a+b;
    }
}

/** Polymorphism example classes */
class runTimePolymorphism {
    /** Base class method */
    void sms() {
        System.out.println("Base class sms()");
    }
}

/** Extending the runTimePolymorphism class */
class Three extends runTimePolymorphism {
    //Overriding sms() of runTimePolymorphism base class
    void sms() {
        System.out.println("Three class sms()");
    }

    /** run method to instantiate new object and execute subclass & super class sms() methods */
    public void run() {
        Three smsObj = new Three();
        smsObj.sms();
        super.sms();
    }
}


public class Main {

    public static void main(String[] args) {
        simpleClass();
        inheritance();
        polymorphism();
        abstractClass();
        interfaceClass();
    }

    public static void simpleClass(){
        Test test = new Test("Test class");
        if ( !test.isTested()){
            test.setTested(true);
        }
        System.out.println(test.getName()+" has been tested = "+test.isTested());
    }

    public static void inheritance(){
        TestTool testTool = new TestTool();
        testTool.setResult(100);
        System.out.println(testTool.getName()+" has been executed = "+testTool.isExecuted());
    }

    public static void polymorphism(){
        System.out.println(compileTimePolymorphism.add(11,21));
        System.out.println(compileTimePolymorphism.add(11.11,21.21));
        System.out.println(compileTimePolymorphism.add("1020","2030"));
        Three three = new Three();
        three.run();
    }

    public static void abstractClass(){
        /** Can't instantiate an abstract class object, the line below won't compile */
        // MyAbstractClass mac = new MyAbstractClass();

        newAbstractClass nac = new newAbstractClass();
        nac.abstractMethod();
    }

    public static void interfaceClass(){
        Rider rider = new Rider();
        rider.test();
    }

}
