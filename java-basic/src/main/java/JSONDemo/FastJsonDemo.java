package JSONDemo;

import bean.Person;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luzc
 * @date 2020/8/14 9:06
 * @desc fastjson ，对象，string，json 三者之间的互转
 */
public class FastJsonDemo {

    public static void main(String[] args) {
        Person p = new Person(10, "张三");
        Person p2 = new Person(10, "张三");

        List<Person> personList = new ArrayList<Person>();
        personList.add(p);
        personList.add(p2);

        //todo: 如下是对象转成string

        //对象 转 json
        System.out.println("---------对象 转 json-------");
        Object toJSON = JSONArray.toJSON(p);
        String json = toJSON.toString();
        System.out.println("将Person对象转成json:" + json);


        //todo: 如下主要是string转成对象（jsonObject 或者普通的对象）

        //string 转 jsonObject
        System.out.println("---------string 转 jsonObject-------");
        JSONObject jSONObject = JSONObject.parseObject(json);
        System.out.println(jSONObject.toJSONString());

        //string 转 jsonArray
        System.out.println("---------string 转 jsonArray-------");
        JSONArray jsonArray= JSONArray.parseArray(JSON.toJSONString(personList));
        System.out.println(jsonArray.toJSONString());

        //json 转 对象
        System.out.println("---------json 转 对象-------");
        Person person = JSONArray.parseObject(json, Person.class);
        System.out.println("person.getName():" + person.getName());

        //对象 转 string
        String json2string = JSON.toJSONString(personList);

        //json 转 string


    }

}
