package CreationalDesignPattern.Builder;

public class Client {
    public static void main(String[] args) {
//        Student.Builder bldr=Student.getBuilder();
//        bldr.name="ABC";
//        bldr.email="Abc@gmail.com";
//        bldr.phoneno="99999";
//        bldr.age=10;
//        bldr.psp=100;
//        Student st1=bldr.build();
////      Student st=new Student(bldr); cannot create new Student as we make the constructor as private
        Student st=Student.getBuilder()
                .setAge(10)
                .setName("abc")
                .setEmail("a@b.com")
                .setPSP(100)
                .setPhone("999")
                .build();
    }
}
