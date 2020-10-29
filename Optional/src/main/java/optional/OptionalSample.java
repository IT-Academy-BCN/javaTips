package optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalSample {

    final static String NULL = null;
    String p;

    public static void main(String ar[]){
        OptionalSample os = new OptionalSample();
        os.crash(NULL);

        Optional<String> optional = Optional.ofNullable(NULL);
        os.avoidNulls(optional);

    }

    void crash(String s){
        try {
            System.out.println(s.split(","));
        }catch(NullPointerException npe){
            System.out.println(".... Oooh, crash!!!! :( ");
        }
    }




    void avoidNulls(Optional<String> opt){

        System.out.println("Is Present?: " + opt.isPresent());
        System.out.println("Is Empty?: " + opt.isEmpty());

        //orElse
        String optOne = Optional.ofNullable(NULL).orElse("Filling null String");
        System.out.println(optOne);

        //orElseGet
        String optTwo = Optional.ofNullable(NULL).orElseGet(this::getDefault);
        System.out.println(optTwo);

        try {
            //orElseThrow
            String optThree = Optional.ofNullable(NULL).orElseThrow();
        }catch (NoSuchElementException nse) { System.out.println("Exception captured!"); }

        try {
            //get (exception)
            System.out.println(opt.get()); //null value = exception
        }catch (NoSuchElementException nse) { System.out.println("Exception captured again!"); }

    }


    String getDefault(){
        return "Default Value";
    }

}
