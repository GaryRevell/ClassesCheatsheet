package com.revell;

/**
 * Abstract Class is a class which is declared with an abstract keyword and cannot be instantiated:
 *
 * It can contain abstract and non-abstract methods.
 * It can contain constructors and static methods as well.
 * It can contain final methods which force the subclass not to change the body of the method.
 *
 */
public abstract class MyAbstractClass
{
    public abstract void abstractMethod();
    public void display(){ System.out.println("Concrete method");  }
}

class newAbstractClass extends MyAbstractClass{
    public void abstractMethod(){
        System.out.println("newAbstractClass.abstractMethod()...");
        display();
    }
}