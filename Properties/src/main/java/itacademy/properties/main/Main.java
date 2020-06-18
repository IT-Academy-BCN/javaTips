package itacademy.properties.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class Main {


    Properties myProps;

    public static void main (String ar[]){

        Main m = new Main();
        m.printSystemProperties();
        m.loadProperties();


    }

    void loadProperties(){
        InputStream input = getClass().getClassLoader().getResourceAsStream("application.properties");

        myProps = new Properties();

        try {
            if (input !=null){
                myProps.load(input);
            }
            System.out.println(myProps.getProperty("db.url"));
            System.out.println(myProps.getProperty("db.user"));
            System.out.println(myProps.getProperty("db.password"));

        }catch (IOException ioe){
            System.out.println("File not located " + ioe.getMessage());
        }

    }

    void printSystemProperties(){
        Properties systemProperties = System.getProperties();
        systemProperties.forEach( (key, value) -> System.out.println(key.toString() + ": " + value.toString()));

        System.out.println("Line separator: **" + System.lineSeparator() + "**");
        System.out.println("Now: "+ System.currentTimeMillis());
        System.out.println("Environment: " + System.getenv());
    }
}
