package jsr.test;

public class SubClazz extends SuperClazz{
    public void setStr(String str) {
        super.setStr("JSR JSR");
    }


    public static void main(String[] args) {
        SubClazz subClazz = new SubClazz();
        subClazz.setStr("JSR");
        System.out.println(subClazz.getStr());
    }

}
