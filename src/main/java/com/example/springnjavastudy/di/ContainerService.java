package com.example.springnjavastudy.di;

import java.lang.reflect.InvocationTargetException;

public class ContainerService {

    //Generic type parameter type으로 return을 해주고 싶을 때
    public static <T> T getObject(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
