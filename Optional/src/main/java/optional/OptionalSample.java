package optional;

import java.util.Optional;

public class OptionalSample {

    final static String TEST = null;
    String p;

    public static void main(String ar[]){
        OptionalSample os = new OptionalSample();
        os.crash(TEST);

        Optional<String> optional = Optional.ofNullable(TEST);
        os.avoidNulls(optional);

    }

    void crash(String s){
        try {
            System.out.println(s.split(","));
        }catch(NullPointerException npe){
            System.out.println(".... Oooh, crash!!!! :( ");
        }
    }




    void avoidNulls(Optional<String> s){

        System.out.println("Is Present?: " + s.isPresent());
        System.out.println("Is Empty?: " + s.isEmpty());

        //orElse
        String newOptional = Optional.ofNullable(TEST).orElse("Filling null String");
        System.out.println(newOptional);

        //orElseGet
        String anotherNewOptional = Optional.ofNullable(TEST).orElseGet(() -> "Filling again!!");
        System.out.println(anotherNewOptional);



    }

}
