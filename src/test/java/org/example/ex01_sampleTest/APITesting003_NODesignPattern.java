package org.example.ex01_sampleTest;

public class APITesting003_NODesignPattern {

    public void step1(){
        System.out.println("step1");
    }
    public void step2(){
        System.out.println("step2");
    }
    public void step3(String param1){
        System.out.println("step3");
    }

    public static void main(String[] args) {
        APITesting003_NODesignPattern np=new APITesting003_NODesignPattern();
        np.step1();
        np.step2();
        np.step3("Ravi_Teja");
    }

}

