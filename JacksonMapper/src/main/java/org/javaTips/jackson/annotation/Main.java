package org.javaTips.jackson.annotation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.javaTips.jackson.annotation.bidirection.ItemWithIdentity;
import org.javaTips.jackson.annotation.bidirection.ItemWithRef;
import org.javaTips.jackson.annotation.bidirection.UserWithIdentity;
import org.javaTips.jackson.annotation.bidirection.UserWithRef;
import org.javaTips.jackson.annotation.date.EventWithFormat;
import org.javaTips.jackson.annotation.date.EventWithSerializer;
import org.javaTips.jackson.annotation.ignore.MyMixInForIgnoreType;
import org.javaTips.jackson.annotation.dtos.withEnum.DistanceEnumWithValue;
import org.javaTips.jackson.annotation.exception.UserWithRoot;
import org.javaTips.jackson.annotation.exception.UserWithRootNamespace;
import org.javaTips.jackson.annotation.jsonview.Item;
import org.javaTips.jackson.annotation.jsonview.Views;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class Main {


    public static void main(String r[]){
        Main main = new Main();

        try{
            main.whenSerializingUsingJsonAnyGetter_thenCorrect();
            main.whenSerializingUsingJsonGetter_thenCorrect();
            main.whenSerializingUsingJsonPropertyOrder_thenCorrect();
            main.whenSerializingUsingJsonRawValue_thenCorrect();
            main.whenSerializingUsingJsonRootName_thenCorrect();
            main.whenSerializingUsingJsonValue_thenCorrect();
            main.whenSerializingUsingJsonSerialize_thenCorrect();
            main.whenDeserializingUsingJsonCreator_thenCorrect();
            main.whenDeserializingUsingJsonInject_thenCorrect();
            main.whenDeserializingUsingJsonAnySetter_thenCorrect();
            main.whenDeserializingUsingJsonSetter_thenCorrect();
            main.whenDeserializingUsingJsonDeserialize_thenCorrect();
            main.whenSerializingUsingJsonIgnoreProperties_thenCorrect();
            main.whenSerializingUsingJsonIgnore_thenCorrect();
            main.whenSerializingUsingJsonIgnoreType_thenCorrect();
            main.whenSerializingUsingJsonInclude_thenCorrect();
            main.whenSerializingUsingJsonAutoDetect_thenCorrect();
            main.whenSerializingPolymorphic_thenCorrect();
            main.whenDeserializingPolymorphic_thenCorrect();
            main.whenUsingJsonProperty_thenCorrect();
            main.whenSerializingUsingJsonFormat_thenCorrect();
            main.whenSerializingUsingJsonUnwrapped_thenCorrect();
            main.whenSerializingUsingJsonView_thenCorrect();
            main.whenSerializingUsingJacksonReferenceAnnotation_thenCorrect();
            main.whenSerializingUsingJsonIdentityInfo_thenCorrect();
            main.whenSerializingUsingJsonFilter_thenCorrect();
            main.whenSerializingUsingCustomAnnotation_thenCorrect();
            main.whenSerializingUsingMixInAnnotation_thenCorrect();
            main.whenDisablingAllAnnotations_thenAllDisabled();
            main.whenDeserializingUsingJsonAlias_thenCorrect();
            main.whenSerializingUsingXMLRootNameWithNameSpace_thenCorrect();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void whenSerializingUsingJsonAnyGetter_thenCorrect() throws JsonProcessingException {
        final ExtendableBean bean = new ExtendableBean("My bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");

        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    public void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
        final BeanWithGetter bean = new BeanWithGetter(1, "My bean");

        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    public void whenSerializingUsingJsonPropertyOrder_thenCorrect() throws JsonProcessingException {
        final MyBean bean = new MyBean(1, "My bean");

        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    public void whenSerializingUsingJsonRawValue_thenCorrect() throws JsonProcessingException {
        final RawBean bean = new RawBean("My bean", "{\"attr\":false}");

        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    public void whenSerializingUsingJsonRootName_thenCorrect() throws JsonProcessingException {
        final UserWithRoot user = new UserWithRoot(1, "John");

        final ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        final String result = mapper.writeValueAsString(user);

        System.out.println(result);
    }

    public void whenSerializingUsingJsonValue_thenCorrect() throws IOException {
        final String enumAsString = new ObjectMapper().writeValueAsString(DistanceEnumWithValue.MILE);

        System.out.println(enumAsString);
    }

    public void whenSerializingUsingJsonSerialize_thenCorrect() throws JsonProcessingException, ParseException {
        final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        final String toParse = "20-12-2014 02:30:00";
        final Date date = df.parse(toParse);
        final EventWithSerializer event = new EventWithSerializer("party", date);

        final String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);
    }

    // ========================= Deserializing annotations ============================

    public void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        final String json = "{\"id\":1,\"theName\":\"My bean\"}";

        final BeanWithCreator bean = new ObjectMapper().readerFor(BeanWithCreator.class)
                .readValue(json);
        System.out.println(bean.name);
    }

    public void whenDeserializingUsingJsonInject_thenCorrect() throws IOException {
        final String json = "{\"name\":\"My bean\"}";
        final InjectableValues inject = new InjectableValues.Std().addValue(int.class, 1);

        final BeanWithInject bean = new ObjectMapper().reader(inject)
                .forType(BeanWithInject.class)
                .readValue(json);
        System.out.println(bean.name);
        System.out.println(bean.id);
    }

    public void whenDeserializingUsingJsonAnySetter_thenCorrect() throws IOException {
        final String json = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";

        final ExtendableBean bean = new ObjectMapper().readerFor(ExtendableBean.class)
                .readValue(json);
        System.out.println(bean.name);
        System.out.println(bean.getProperties());
    }

    public void whenDeserializingUsingJsonSetter_thenCorrect() throws IOException {
        final String json = "{\"id\":1,\"name\":\"My bean\"}";

        final BeanWithGetter bean = new ObjectMapper().readerFor(BeanWithGetter.class)
                .readValue(json);
        System.out.println(bean.getTheName());
    }

    public void whenDeserializingUsingJsonDeserialize_thenCorrect() throws IOException {
        final String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";

        final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        final EventWithSerializer event = new ObjectMapper().readerFor(EventWithSerializer.class)
                .readValue(json);
        System.out.println(df.format(event.eventDate));
    }

    // ========================= Inclusion annotations ============================

    public void whenSerializingUsingJsonIgnoreProperties_thenCorrect() throws JsonProcessingException {
        final BeanWithIgnore bean = new BeanWithIgnore(1, "My bean");

        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    public void whenSerializingUsingJsonIgnore_thenCorrect() throws JsonProcessingException {
        final BeanWithIgnore bean = new BeanWithIgnore(1, "My bean");

        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    public void whenSerializingUsingJsonIgnoreType_thenCorrect() throws JsonProcessingException, ParseException {
        final UserWithIgnoreType.Name name = new UserWithIgnoreType.Name("John", "Doe");
        final UserWithIgnoreType user = new UserWithIgnoreType(1, name);

        final String result = new ObjectMapper().writeValueAsString(user);

        System.out.println(result);
    }

    public void whenSerializingUsingJsonInclude_thenCorrect() throws JsonProcessingException {
        final MyBean bean = new MyBean(1, null);

        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    public void whenSerializingUsingJsonAutoDetect_thenCorrect() throws JsonProcessingException {
        final PrivateBean bean = new PrivateBean(1, "My bean");

        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
    }

    // ========================= Polymorphic annotations ============================

    public void whenSerializingPolymorphic_thenCorrect() throws JsonProcessingException {
        final Zoo.Dog dog = new Zoo.Dog("lacy");
        final Zoo zoo = new Zoo(dog);

        final String result = new ObjectMapper().writeValueAsString(zoo);

        System.out.println(result);
    }

    public void whenDeserializingPolymorphic_thenCorrect() throws IOException {
        final String json = "{\"animal\":{\"name\":\"lacy\",\"type\":\"cat\"}}";

        final Zoo zoo = new ObjectMapper().readerFor(Zoo.class)
                .readValue(json);

        System.out.println(zoo.animal.name);
        System.out.println(zoo.animal.getClass());
    }
    // ========================= General annotations ============================

    public void whenUsingJsonProperty_thenCorrect() throws IOException {
        final BeanWithGetter bean = new BeanWithGetter(1, "My bean");

        final String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);

        final BeanWithGetter resultBean = new ObjectMapper().readerFor(BeanWithGetter.class)
                .readValue(result);
        System.out.println(resultBean.getTheName());
    }

    public void whenSerializingUsingJsonFormat_thenCorrect() throws JsonProcessingException, ParseException {
        final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        final String toParse = "20-12-2014 02:30:00";
        final Date date = df.parse(toParse);
        final EventWithFormat event = new EventWithFormat("party", date);

        final String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);
    }

    public void whenSerializingUsingJsonUnwrapped_thenCorrect() throws JsonProcessingException, ParseException {
        final UnwrappedUser.Name name = new UnwrappedUser.Name("John", "Doe");
        final UnwrappedUser user = new UnwrappedUser(1, name);

        final String result = new ObjectMapper().writeValueAsString(user);
        System.out.println(result);
    }

    public void whenSerializingUsingJsonView_thenCorrect() throws JsonProcessingException, JsonProcessingException {
        final Item item = new Item(2, "book", "John");

        final String result = new ObjectMapper().writerWithView(Views.Public.class)
                .writeValueAsString(item);

        System.out.println(result);
    }

    public void whenSerializingUsingJacksonReferenceAnnotation_thenCorrect() throws JsonProcessingException {
        final UserWithRef user = new UserWithRef(1, "John");
        final ItemWithRef item = new ItemWithRef(2, "book", user);
        user.addItem(item);

        final String result = new ObjectMapper().writeValueAsString(item);

        System.out.println(result);
    }

    public void whenSerializingUsingJsonIdentityInfo_thenCorrect() throws JsonProcessingException {
        final UserWithIdentity user = new UserWithIdentity(1, "John");
        final ItemWithIdentity item = new ItemWithIdentity(2, "book", user);
        user.addItem(item);

        final String result = new ObjectMapper().writeValueAsString(item);

        System.out.println(result);
    }

    public void whenSerializingUsingJsonFilter_thenCorrect() throws JsonProcessingException {
        final BeanWithFilter bean = new BeanWithFilter(1, "My bean");

        final FilterProvider filters = new SimpleFilterProvider().addFilter("myFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name"));

        final String result = new ObjectMapper().writer(filters)
                .writeValueAsString(bean);

        System.out.println(result);
    }

    // =========================
    public void whenSerializingUsingCustomAnnotation_thenCorrect() throws JsonProcessingException {
        final BeanWithCustomAnnotation bean = new BeanWithCustomAnnotation(1, "My bean", null);

        final String result = new ObjectMapper().writeValueAsString(bean);

        System.out.println(result);
    }

    // @Ignore("Jackson 2.7.1-1 seems to have changed the API regarding mixins")
    public void whenSerializingUsingMixInAnnotation_thenCorrect() throws JsonProcessingException {
        final org.javaTips.jackson.annotation.dtos.Item item = new org.javaTips.jackson.annotation.dtos.Item(1, "book", null);

        String result = new ObjectMapper().writeValueAsString(item);
        System.out.println(result);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(org.javaTips.jackson.annotation.dtos.User.class, MyMixInForIgnoreType.class);

        result = mapper.writeValueAsString(item);
        System.out.println(result);
    }

    public void whenDisablingAllAnnotations_thenAllDisabled() throws JsonProcessingException {
        final MyBean bean = new MyBean(1, null);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.USE_ANNOTATIONS);

        final String result = mapper.writeValueAsString(bean);
        System.out.println(result);
        System.out.println(result);
    }

    public void whenDeserializingUsingJsonAlias_thenCorrect() throws IOException {

        // arrange
        String json = "{\"fName\": \"John\", \"lastName\": \"Green\"}";

        // act
        AliasBean aliasBean = new ObjectMapper().readerFor(AliasBean.class).readValue(json);

        // assert
        System.out.println(aliasBean.getFirstName());
    }

    public void whenSerializingUsingXMLRootNameWithNameSpace_thenCorrect() throws JsonProcessingException {

        // arrange
        UserWithRootNamespace author = new UserWithRootNamespace(1, "John");

        // act
        ObjectMapper mapper = new XmlMapper();
        mapper = mapper.enable(SerializationFeature.WRAP_ROOT_VALUE).enable(SerializationFeature.INDENT_OUTPUT);
        String result = mapper.writeValueAsString(author);

        System.out.println(result);

        /*
            <user xmlns="users">
              <id xmlns="">3006b44a-cf62-4cfe-b3d8-30dc6c46ea96</id>
              <id xmlns="">1</id>
              <name xmlns="">John</name>
              <items xmlns=""/>
            </user>
        */

    }



}
