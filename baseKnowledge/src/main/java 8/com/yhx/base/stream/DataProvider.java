package com.yhx.base.stream;

import com.yhx.base.entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class DataProvider {

    public static void main(String[] args){

        Integer value=12;
       Stream<Integer> integerStream = Stream.of(value,13,15,2343);
       integerStream.forEach(System.out::println);
    }

    public static  List<Dish> getDishList(){
        List<Dish> menu= Arrays.asList(
                new Dish("pork",false,800, Dish.Type.MEAT),
                new Dish("beef",false,700, Dish.Type.MEAT),
                new Dish("chicken",false,400, Dish.Type.MEAT),
                new Dish("french",true,530, Dish.Type.OTHER),
                new Dish("rice",true,350, Dish.Type.OTHER),
                new Dish("season fruit",true,120, Dish.Type.OTHER),
                new Dish("pizza",true,550, Dish.Type.MEAT),
                new Dish("parwns",true,300, Dish.Type.FISH),
                new Dish("salmon",true,1450, Dish.Type.FISH)
        );
        return menu;
    }

}
