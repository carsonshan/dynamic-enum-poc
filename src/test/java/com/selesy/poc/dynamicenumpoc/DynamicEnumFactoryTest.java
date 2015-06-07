package com.selesy.poc.dynamicenumpoc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.Test;

public class DynamicEnumFactoryTest {

  @Test
  public void testAddingEnumMember() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
  Class<?>[] parameterTypes = {String.class, int.class, String.class, String.class};
  Object[] parameterValues = {"SIX", 6, "6", "Six"};
    
    //printEnumNames(DynamicEnum.class);
    
    //System.out.println("---");
    DynamicEnumFactory<DynamicEnum> factory = new DynamicEnumFactory<DynamicEnum>();
    factory.something(DynamicEnum.class, parameterTypes, parameterValues);
    
    //printEnumNames(DynamicEnum.class);
    
    DynamicEnum dynamicEnum = DynamicEnum.valueOf("SIX");
    assertEquals("SIX", dynamicEnum.name());
    assertEquals(6, dynamicEnum.ordinal());
    assertEquals("6", dynamicEnum.stringOrdinal);
    assertEquals("Six", dynamicEnum.stringEnglish);
  }
  
  public void printEnumNames(Class<? extends Enum<?>> clazz) {
    System.out.println("Enum: " + clazz.getName());
    for(Enum<?> item: DynamicEnum.values()) {
      System.out.println("    Item: " + item.name());
    }
  }
  
}
