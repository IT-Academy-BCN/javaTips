package optional;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalSample implements Serializable {

    final static String NULL = null;
    final static String STRING = "javaTips";

    public static void main(String ar[]){

        OptionalSample os = new OptionalSample();
        os.crash(NULL);

        Optional<String> optional = Optional.ofNullable(NULL);
        os.avoidNulls(optional);

        //filter example
        os.filters();
        //map example
        os.mapAndFilter();

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

        //Optional.of
        Optional<String> optional_string = Optional.of(STRING);
        System.out.println(optional_string.get());

    }


    void filters(){
        Integer year = 2020;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2020 = yearOptional.filter(y -> y == 2020).isPresent();
        System.out.println(is2020);
    }


    void mapAndFilter() {
        String PASSWORD = " password ";
        Optional<String> passOpt = Optional.of(PASSWORD);

        boolean correctPassword = passOpt.
                filter(pass -> pass.compareTo("password")==0)
                .isPresent();//false
        System.out.println("Correct Password? : " +correctPassword);

        correctPassword = passOpt.map(String::trim)
                .filter(pass -> pass.compareTo("password")==0)
                .isPresent();//true (trim)
        System.out.println("Correct Password? : " +correctPassword);


    }

    String getDefault(){
        return "Default Value";
    }

}
