package org.example.ex01_sampleTest;

public class APITesting004_BuilderPattern {

    public APITesting004_BuilderPattern step1(){
        System.out.println("step1");
        return this;
    }
    public APITesting004_BuilderPattern step2(){
        System.out.println("step2");
        return this;
    }
    public APITesting004_BuilderPattern step3(String param1){
        System.out.println("step3");
        return this;
    }
//Advantage of this
    public static void main(String[] args) {
        APITesting004_BuilderPattern bp=new APITesting004_BuilderPattern();
        bp.step1().step2().step3("Raviteja");
    }

}
