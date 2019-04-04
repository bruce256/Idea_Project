package fel;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author 儒尊
 * @date 2017/05/18
 */
public class FelTest {
	
	public static void main(String[] args) {
		FelEngine fel    = new FelEngineImpl();
		Object    result = fel.eval("5000*12+7500");
		System.out.println(result);
		
		variable();
		obj();
		collection();
		method();
	}
	
	public static void variable() {
		FelEngine  fel = new FelEngineImpl();
		FelContext ctx = fel.getContext();
		ctx.set("单价", 5000);
		ctx.set("数量", 12);
		ctx.set("运费", 7500);
		Object result = fel.eval("单价*数量+运费");
		System.out.println(result);
	}
	
	public static void obj() {
		FelEngine  fel = new FelEngineImpl();
		FelContext ctx = fel.getContext();
		Foo        foo = new Foo();
		ctx.set("foo", foo);
		Map m = new HashMap();
		m.put("ElName", "fel");
		ctx.set("m", m);
		
		//调用foo.getSize()方法。
		Object result = fel.eval("foo.getSize()");
		System.out.println(result);
		//调用foo.isSample()方法。
		result = fel.eval("foo.sample");
		System.out.println(result);
		
		//foo没有name、getName、isName方法
		// foo.name会调用foo.get("name")方法。
		result = fel.eval("foo.name");
		System.out.println(result);
		
		//m.ElName会调用m.get("ElName");
		result = fel.eval("m.ElName");
		System.out.println(result);
		
	}
	
	public static void collection() {
		FelEngine  fel = new FelEngineImpl();
		FelContext ctx = fel.getContext();

//数组
		int[] intArray = {1, 2, 3};
		ctx.set("intArray", intArray);
//获取intArray[0]
		String exp = "intArray[0]";
		System.out.println(exp + "->" + fel.eval(exp));

//List
		List<Integer> list = Arrays.asList(1, 2, 3);
		ctx.set("list", list);
		//获取list.get(0)
		exp = "list[0]";
		System.out.println(exp + "->" + fel.eval(exp));

//集合
		Collection coll = Arrays.asList("a", "b", "c");
		ctx.set("coll", coll);
		//获取集合最前面的元素。执行结果为"a"
		exp = "coll[0]";
		System.out.println(exp + "->" + fel.eval(exp));

//迭代器
		Iterator iterator = coll.iterator();
		ctx.set("iterator", iterator);
		//获取迭代器最前面的元素。执行结果为"a"
		exp = "iterator[0]";
		System.out.println(exp + "->" + fel.eval(exp));

//Map
		Map m = new HashMap();
		m.put("name", "HashMap");
		ctx.set("map", m);
		exp = "map.name";
		System.out.println(exp + "->" + fel.eval(exp));

//多维数组
		int[][] intArrays = {{11, 12}, {21, 22}};
		ctx.set("intArrays", intArrays);
		exp = "intArrays[0][0]";
		System.out.println(exp + "->" + fel.eval(exp));

//多维综合体，支持数组、集合的任意组合。
		List listArray = new ArrayList();
		listArray.add(new int[]{1, 2, 3});
		listArray.add(new int[]{4, 5, 6});
		ctx.set("listArray", listArray);
		exp = "listArray[0][0]";
		System.out.println(exp + "->" + fel.eval(exp));
	}
	
	public static void method() {
		FelEngine  fel = new FelEngineImpl();
		FelContext ctx = fel.getContext();
		ctx.set("out", System.out);
		"a".toUpperCase();
		fel.eval("out.println('Hello Everybody'.toLowerCase())");
		fel.eval("out.println('Hello Everybody'.toUpperCase())");
	}
	
	@Test
	public void method2() {
		FelEngine  fel = new FelEngineImpl();
		FelContext ctx = fel.getContext();
		Foo        foo = new Foo();
		ctx.set("foo", foo);
		ctx.set("name", "儒尊");
		fel.eval("foo.setName(\"儒尊\")");
		System.out.println(foo.getName());
	}
	
	@Test
	public void list() {
		FelEngine  fel = new FelEngineImpl();
		FelContext ctx = fel.getContext();
		Foo        foo = new Foo();
		
		ctx.set("foo", foo);
		ctx.set("name", "儒尊");
		fel.eval("foo.getList().add(name)");
		System.out.println(foo.getList());
	}
	
	@Test
	public void typeConvert() {
		FelEngine  fel      = new FelEngineImpl();
		FelContext ctx      = fel.getContext();
		Foo        foo      = new Foo();
		Long       itemType = 1L;
		
		ctx.set("foo", foo);
		ctx.set("itemType", itemType);
		fel.eval("foo.getList().setItemType(()itemType)");
		System.out.println(foo.getList());
	}
	
	
}
