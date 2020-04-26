package com.codewithmosh.generics;

public class Utils {
  public static <T extends Comparable<T>> T max(T first, T second) {
    return (first.compareTo(second) < 0) ? second : first;
  }

  public static <K, V> void print(K key, V value) {
    System.out.println(key + "=" + value);
  }

  public static void printUser(User user) {
    System.out.println(user);
  }

  public static void printUsers
        (GenericList<? super User> users) {
    User x = (User) users.get(0);
    users.add(new User(10));
    users.add(new Instructor(11));
    users.forEach(user -> printUser((User) user));
  }
}
