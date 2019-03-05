package com.heq;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;

/**
 * @Auther: heq
 * @Date: 2019/3/1
 * @Description:
 */
public class BeanWrapperTest {
    public static void main(String[] args) {
        test4PropertyValues();
    }

    public static void test4PropertyValue(){
        User user = new User();
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(user);
        bw.setPropertyValue("userName", "张三");
        System.out.println(user.getUserName()); //输出张三
        PropertyValue value = new PropertyValue("userName", "李四");
        bw.setPropertyValue(value);
        System.out.println(user.getUserName()); //输出李四
    }

    public static void test4PropertyValues(){
        User user = new User();
        BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(user);
        bw.setPropertyValue("userName", "张三");
        System.out.println(user);
        PropertyValue pv2UserName = new PropertyValue("userName", "李四");
        PropertyValue pv2Age = new PropertyValue("age", 28);
        PropertyValues pvs = new PropertyValues() {
            @Override
            public PropertyValue[] getPropertyValues() {
                return new PropertyValue[]{pv2UserName,pv2Age};
            }

            @Override
            public PropertyValue getPropertyValue(String propertyName) {
                return null;
            }

            @Override
            public PropertyValues changesSince(PropertyValues old) {
                return null;
            }

            @Override
            public boolean contains(String propertyName) {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        };
        bw.setPropertyValues(pvs,true);
        System.out.println(user);
    }
}