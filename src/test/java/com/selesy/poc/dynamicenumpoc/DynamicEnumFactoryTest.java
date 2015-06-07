package com.selesy.poc.dynamicenumpoc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.Test;

public class DynamicEnumFactoryTest {

  @Test
  public void testAddingEnumMemberToComplexEnum() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
  Class<?>[] parameterTypes = {String.class, int.class, String.class, String.class};
  Object[] parameterValues = {"SIX", 6, "6", "Six"};
    
    //printEnumNames(DynamicEnum.class);
    
    //System.out.println("---");
    DynamicEnumFactory<ComplexEnum> factory = new DynamicEnumFactory<ComplexEnum>();
    factory.addValue(ComplexEnum.class, parameterTypes, parameterValues);
    
    //printEnumNames(DynamicEnum.class);
    
    ComplexEnum dynamicEnum = ComplexEnum.valueOf("SIX");
    assertEquals("SIX", dynamicEnum.name());
    assertEquals(6, dynamicEnum.ordinal());
    assertEquals("6", dynamicEnum.stringOrdinal);
    assertEquals("Six", dynamicEnum.stringEnglish);
  }
  
  @Test
  public void testAddingEnumMemberToSimpleEnum() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
    assertEquals(4, SimpleEnum.values().length);
    
    DynamicEnumFactory<SimpleEnum> factory = new DynamicEnumFactory<>();
    factory.addValue(SimpleEnum.class, "FIVE");
    
    assertEquals(5, SimpleEnum.values().length);
    SimpleEnum simpleEnum = null;
    try {
      simpleEnum = SimpleEnum.valueOf("FIVE");
    } catch(IllegalArgumentException e) {
      fail("FIVE should have been found in SimpleEnum after change.");
    }
    assertNotNull(simpleEnum);
  }
  
  public void printEnumNames(Class<? extends Enum<?>> clazz) {
    System.out.println("Enum: " + clazz.getName());
    for(Enum<?> item: ComplexEnum.values()) {
      System.out.println("    Item: " + item.name());
    }
  }
  
}
