package com.ernesto.lambad;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

/**
 * @author Ernesto
 * @date 2019/12/30
 */
public class LambadDemo {

    public static void main(String[] args) {
        //List<Apple> apples = new ArrayList<Apple>();
        //apples.add(new Apple("Red", 20.3));
        //apples.add(new Apple("Green", 21.3));
        //apples.add(new Apple("Yellow", 22.3));
        //apples.add(new Apple("white", 23.3));
        //List<String> colors = mapper(apples, (Apple apple) -> apple.getColor());
        //System.out.println(Arrays.toString(colors.toArray()));
        //System.out.println("------------");
        //System.out.println(mapper(new Apple("No", 23.23), (Apple apple) -> apple.getColor()));
        String date = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
        System.out.println(date);
    }

    /***
     * Function 映射（由输入产生一个输出）
     * @param list
     * @param mapperPattern
     * @param <T>
     * @param <R>
     * @
     *
     *
     */
    public static <T, R> List<R> mapper(List<T> list, Function<T, R> mapperPattern) {
        List<R> result = new ArrayList<R>();
        for (T item : list) {
            result.add(mapperPattern.apply(item));
        }
        return result;
    }

    public static <T, R> R mapper(T t, Function<T, R> mapper) {
        return mapper.apply(t);
    }

}

class Apple {
    private String color;
    private double weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + '}';
    }
}