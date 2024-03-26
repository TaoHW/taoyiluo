package com.taoyiluo.springbootquickstarterapi.designPattern;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Taohw
 * @Classname Singleton
 * @Description TODO
 * @Date 2024/3/19 20:31
 * @Version V1.0
 */
public class Singleton implements Serializable {
	private volatile static Singleton singleton;

	private Singleton() {
	}

	public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

	//hasReadResolveMethod :如果实现了serializable 或者 externalizable接口的类中包含 readResolve 则返回true
	//通过这种方式防止反序列化破坏单例
	private Object readResolve() {
		return singleton;
	}

	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
//		Singleton singleton1 = Singleton.getSingleton();
//		//通过反射获取到构造参数
//		Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
//		//将构造函数设置为可访问类型
//		constructor.setAccessible(true);
//		//调用构造函数的newInstance方法创建新的对象
//		Singleton singleton2 = constructor.newInstance();
//		//判断是否创建成功
//		if (singleton != null)
//			throw new RuntimeException("单例对象只能创建一个");
//		//判断反射创建的对象和之前的对象是不是同一个对象
//		System.out.println(singleton1 == singleton2);
		//false



		//写入
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.obj"));
		oos.writeObject(Singleton.getSingleton());
		oos.flush();

		//读取
		File file = new File("singleton.obj");

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Singleton newSingleton = (Singleton) ois.readObject();

		System.out.println(newSingleton == Singleton.getSingleton());
	}
}
