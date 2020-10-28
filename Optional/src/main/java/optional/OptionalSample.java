package optional;

import java.util.Optional;

public class OptionalSample {

    final static String TEST = null;
    String p;

    public static void main(String ar[]){
        OptionalSample os = new OptionalSample();
        os.crash(TEST);

        Optional<String> optional = Optional.ofNullable(TEST);
        os.optionalClause(optional);

    }

    void crash(String s){
        try {
            System.out.println(s.split(","));
        }catch(NullPointerException npe){
            System.out.println(".... Avoiding nulls hell :( ");
        }
    }




    void optionalClause(Optional<String> s){

        System.out.println("Is Present?: " + s.isPresent());
        System.out.println("Is Empty?: " + s.isEmpty());

      //  Optional<String> newOptional = Optional.ofNullable(TEST).orElse(this.getDefault());

        s.ifPresent(name -> System.out.println( name + " is empty "));
    }

    String getDefault(){
        return "Filling null String";
    }

}
